package com.sample.merchant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.DoUATPExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoUATPExpressCheckoutPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoUATPExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsReq;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutRequestType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AddressType;
import urn.ebay.apis.eBLBaseComponents.BillingAgreementDetailsType;
import urn.ebay.apis.eBLBaseComponents.BillingCodeType;
import urn.ebay.apis.eBLBaseComponents.CountryCodeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.ErrorType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsItemType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.SetExpressCheckoutRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.ShippingOptionType;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

/**
 * Servlet implementation class CheckoutServlet
 */
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CheckoutServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getRequestURI().contains("SetExpressCheckout"))
			getServletConfig().getServletContext()
					.getRequestDispatcher("/Checkout/SetExpressCheckout.jsp")
					.forward(request, response);
		if (request.getRequestURI().contains("GetExpressCheckout"))
			getServletConfig().getServletContext()
					.getRequestDispatcher("/Checkout/GetExpressCheckout.jsp")
					.forward(request, response);
		if (request.getRequestURI().contains("DoExpressCheckout"))
			getServletConfig().getServletContext()
					.getRequestDispatcher("/Checkout/DoExpressCheckout.jsp")
					.forward(request, response);
		if (request.getRequestURI().contains("DoUATPExpressCheckoutPayment"))
			getServletConfig()
					.getServletContext()
					.getRequestDispatcher(
							"/Checkout/DoUATPExpressCheckoutPayment.jsp")
					.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try {
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(
					this.getServletContext().getRealPath("/")
							+ "/WEB-INF/sdk_config.properties");
			if (request.getRequestURI().contains("SetExpressCheckout")) {
				SetExpressCheckoutRequestType setExpressCheckoutReq = new SetExpressCheckoutRequestType();
				SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();

				StringBuffer url = new StringBuffer();
				url.append("http://");
				url.append(request.getServerName());
				url.append(":");
				url.append(request.getServerPort());
				url.append(request.getContextPath());

				String returnURL = url.toString() + "/EC/GetExpressCheckout";
				String cancelURL = url.toString() + "/index.html";

				details.setReturnURL(returnURL + "?currencyCodeType="
						+ request.getParameter("currencyCode"));

				details.setCancelURL(cancelURL);
				details.setBuyerEmail(request.getParameter("buyerMail"));

				request.getSession().setAttribute("paymentType",
						request.getParameter("paymentType"));

				/*
				 * details.setCallbackURL("https://www.ppcallback.com/callback.pl"
				 * ); details.setCallbackTimeout("5");
				 */
				double itemTotal = 0.00;
				double orderTotal = 0.00;
				// populate line item details
				String amountItems = request.getParameter("itemAmount");
				String qtyItems = request.getParameter("itemQuantity");
				String names = request.getParameter("itemName");

				List<PaymentDetailsItemType> lineItems = new ArrayList<PaymentDetailsItemType>();

				PaymentDetailsItemType item = new PaymentDetailsItemType();
				BasicAmountType amt = new BasicAmountType();
				amt.setCurrencyID(CurrencyCodeType.fromValue(request
						.getParameter("currencyCode")));
				amt.setValue(amountItems);
				item.setQuantity(new Integer(qtyItems));
				item.setName(names);
				item.setAmount(amt);

				if (request.getParameter("salesTax") != "") {
					item.setTax(new BasicAmountType(CurrencyCodeType
							.fromValue(request.getParameter("currencyCode")),
							request.getParameter("salesTax")));
					orderTotal += Double.parseDouble(request
							.getParameter("salesTax"));
				}
				itemTotal += Double.parseDouble(qtyItems)
						* Double.parseDouble(amountItems);

				List<PaymentDetailsType> payDetails = new ArrayList<PaymentDetailsType>();
				PaymentDetailsType paydtl = new PaymentDetailsType();
				paydtl.setPaymentAction(PaymentActionCodeType.fromValue(request
						.getParameter("paymentType")));
				if (request.getParameter("shippingTotal") != "") {
					BasicAmountType shippingTotal = new BasicAmountType();
					shippingTotal.setValue(request
							.getParameter("shippingTotal"));
					shippingTotal.setCurrencyID(CurrencyCodeType
							.fromValue(request.getParameter("currencyCode")));
					orderTotal += Double.parseDouble(request
							.getParameter("shippingTotal"));
					paydtl.setShippingTotal(shippingTotal);
				}
				if (request.getParameter("insuranceTotal") != "") {
					paydtl.setInsuranceTotal(new BasicAmountType(
							CurrencyCodeType.fromValue(request
									.getParameter("currencyCode")), request
									.getParameter("insuranceTotal")));
					paydtl.setInsuranceOptionOffered("true");
					orderTotal += Double.parseDouble(request
							.getParameter("insuranceTotal"));
				}
				if (request.getParameter("handlingTotal") != "") {
					paydtl.setHandlingTotal(new BasicAmountType(
							CurrencyCodeType.fromValue(request
									.getParameter("currencyCode")), request
									.getParameter("handlingTotal")));
					orderTotal += Double.parseDouble(request
							.getParameter("handlingTotal"));
				}
				if (request.getParameter("taxTotal") != "") {
					paydtl.setTaxTotal(new BasicAmountType(CurrencyCodeType
							.fromValue(request.getParameter("currencyCode")),
							request.getParameter("taxTotal")));
					orderTotal += Double.parseDouble(request
							.getParameter("taxTotal"));
				}
				if (request.getParameter("orderDescription") != "") {
					paydtl.setOrderDescription(request
							.getParameter("orderDescription"));
				}

				orderTotal += itemTotal;
				BasicAmountType itemsTotal = new BasicAmountType();
				itemsTotal.setValue(Double.toString(itemTotal));
				itemsTotal.setCurrencyID(CurrencyCodeType.fromValue(request
						.getParameter("currencyCode")));
				paydtl.setOrderTotal(new BasicAmountType(CurrencyCodeType
						.fromValue(request.getParameter("currencyCode")),
						Double.toString(orderTotal)));
				paydtl.setPaymentDetailsItem(lineItems);

				paydtl.setItemTotal(itemsTotal);
				payDetails.add(paydtl);
				details.setPaymentDetails(payDetails);
				if (request.getParameter("billingAgreementText") != "") {
					BillingAgreementDetailsType billingAgreement = new BillingAgreementDetailsType(
							BillingCodeType.fromValue(request
									.getParameter("billingType")));
					billingAgreement.setBillingAgreementDescription(request
							.getParameter("billingAgreementText"));
					List<BillingAgreementDetailsType> billList = new ArrayList<BillingAgreementDetailsType>();
					billList.add(billingAgreement);
					details.setBillingAgreementDetails(billList);
				}
				// populate shipping address details}
				details.setNoShipping(request.getParameter("noShipping"));

				/*
				 * List<ShippingOptionType> shippings = new
				 * ArrayList<ShippingOptionType>();
				 * 
				 * ShippingOptionType ship = new ShippingOptionType();
				 * ship.setShippingOptionName(request
				 * .getParameter("shippingMethod")); BasicAmountType shipAmt =
				 * new BasicAmountType();
				 * shipAmt.setCurrencyID(CurrencyCodeType.fromValue(request
				 * .getParameter("currencyCode")));
				 * 
				 * 
				 * ship.setShippingOptionIsDefault(request
				 * .getParameter("shippingOptionIsDefault"));
				 * 
				 * shipAmt.setValue(request.getParameter("shippingAmount"));
				 * 
				 * ship.setShippingOptionAmount(shipAmt); shippings.add(ship);
				 * 
				 * details.setFlatRateShippingOptions(shippings);
				 * 
				 * // populate shipping address (in a real application buyer //
				 * shipping address is chosen or collected on the merchant site)
				 * AddressType address = new AddressType();
				 * address.setName(request.getParameter("name"));
				 * address.setStreet1(request.getParameter("street"));
				 * address.setCityName(request.getParameter("city"));
				 * address.setStateOrProvince(request.getParameter("state"));
				 * address.setCountryName(request.getParameter("countryCode"));
				 * address.setCountry(CountryCodeType.fromValue(request
				 * .getParameter("countryCode")));
				 * address.setPostalCode(request.getParameter("postalCode"));
				 * paydtl.setShipToAddress(address);
				 */

				setExpressCheckoutReq
						.setSetExpressCheckoutRequestDetails(details);
				setExpressCheckoutReq.setVersion("82");
				SetExpressCheckoutReq expressCheckoutReq = new SetExpressCheckoutReq();
				expressCheckoutReq
						.setSetExpressCheckoutRequest(setExpressCheckoutReq);

				SetExpressCheckoutResponseType setExpressCheckoutResponse = service
						.setExpressCheckout(expressCheckoutReq);
				response.setContentType("text/html");
				if (setExpressCheckoutResponse != null) {
					if (setExpressCheckoutResponse.getAck().toString()
							.equalsIgnoreCase("SUCCESS")) {
						response.getWriter().println(
								"CorelationId : "
										+ setExpressCheckoutResponse
												.getCorrelationID());
						response.getWriter().println("<br/>");
						response.getWriter()
								.println(
										"Token : "
												+ setExpressCheckoutResponse
														.getToken());

						response.getWriter()
								.println(
										"<a href=https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token="
												+ setExpressCheckoutResponse
														.getToken()
												+ ">RedirectURL</a>");
					} else {
						HttpSession session = request.getSession();
						session.setAttribute("Error",
								setExpressCheckoutResponse.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}
			}
			if (request.getRequestURI().contains("GetExpressCheckout")) {
				GetExpressCheckoutDetailsReq req = new GetExpressCheckoutDetailsReq();
				GetExpressCheckoutDetailsRequestType reqType = new GetExpressCheckoutDetailsRequestType(
						request.getParameter("token"));
				reqType.setVersion("84");
				req.setGetExpressCheckoutDetailsRequest(reqType);
				GetExpressCheckoutDetailsResponseType resp = service
						.getExpressCheckoutDetails(req);
				if (resp != null) {
					if (resp.getAck().toString().equalsIgnoreCase("SUCCESS")) {
						response.getWriter().println("Ack: " + resp.getAck());
						response.getWriter().println("<br/>");
						response.getWriter()
								.println(
										"Payer Id:"
												+ resp.getGetExpressCheckoutDetailsResponseDetails()
														.getPayerInfo()
														.getPayerID());
						response.getWriter().println("<br/>");
						response.getWriter()
								.println(
										"Token:"
												+ resp.getGetExpressCheckoutDetailsResponseDetails()
														.getToken());

					} else {
						HttpSession session = request.getSession();
						session.setAttribute("Error", resp.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}
			}
			if (request.getRequestURI().contains("DoExpressCheckout")) {
				DoExpressCheckoutPaymentRequestType doCheckoutPaymentRequestType = new DoExpressCheckoutPaymentRequestType();
				doCheckoutPaymentRequestType.setVersion("84");
				DoExpressCheckoutPaymentRequestDetailsType details = new DoExpressCheckoutPaymentRequestDetailsType();
				details.setToken(request.getParameter("token"));
				details.setPayerID(request.getParameter("payerID"));
				details.setPaymentAction(PaymentActionCodeType
						.fromValue((String) request.getSession().getAttribute(
								"paymentType")));

				PaymentDetailsType paymentDetails = new PaymentDetailsType();
				BasicAmountType orderTotal = new BasicAmountType();
				orderTotal.setValue(request.getParameter("amt"));
				orderTotal.setCurrencyID(CurrencyCodeType.fromValue(request
						.getParameter("currencyCode")));
				paymentDetails.setOrderTotal(orderTotal);

				BasicAmountType itemTotal = new BasicAmountType();
				itemTotal.setValue(request.getParameter("amt"));
				itemTotal.setCurrencyID(CurrencyCodeType.fromValue(request
						.getParameter("currencyCode")));
				paymentDetails.setItemTotal(itemTotal);

				List<PaymentDetailsItemType> paymentItems = new ArrayList<PaymentDetailsItemType>();
				PaymentDetailsItemType paymentItem = new PaymentDetailsItemType();
				paymentItem.setName("Photographic Print - Tropical Sunset");
				paymentItem.setQuantity(new Integer("1"));
				BasicAmountType amount = new BasicAmountType();
				amount.setValue(request.getParameter("amt"));
				amount.setCurrencyID(CurrencyCodeType.fromValue(request
						.getParameter("currencyCode")));
				paymentItem.setAmount(amount);
				paymentItems.add(paymentItem);
				paymentDetails.setPaymentDetailsItem(paymentItems);

				List<PaymentDetailsType> payDetailType = new ArrayList<PaymentDetailsType>();
				payDetailType.add(paymentDetails);
				details.setPaymentDetails(payDetailType);

				doCheckoutPaymentRequestType
						.setDoExpressCheckoutPaymentRequestDetails(details);
				DoExpressCheckoutPaymentReq doExpressCheckoutPaymentReq = new DoExpressCheckoutPaymentReq();
				doExpressCheckoutPaymentReq
						.setDoExpressCheckoutPaymentRequest(doCheckoutPaymentRequestType);

				DoExpressCheckoutPaymentResponseType doCheckoutPaymentResponseType = service
						.doExpressCheckoutPayment(doExpressCheckoutPaymentReq);
				response.setContentType("text/html");
				if (doCheckoutPaymentResponseType != null) {
					if (doCheckoutPaymentResponseType.getAck().toString()
							.equalsIgnoreCase("SUCCESS")) {
						response.getWriter().println(
								"CorelationId : "
										+ doCheckoutPaymentResponseType
												.getCorrelationID());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Ack : "
										+ doCheckoutPaymentResponseType
												.getAck());
						response.getWriter().println("<br/>");
						response.getWriter()
								.println(
										"ID : "
												+ doCheckoutPaymentResponseType
														.getDoExpressCheckoutPaymentResponseDetails()
														.getPaymentInfo()
														.get(0)
														.getTransactionID());
					} else {
						HttpSession session = request.getSession();
						session.setAttribute("Error",
								doCheckoutPaymentResponseType.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}

			} else if (request.getRequestURI()
					.contains("DoUATPExpressCheckout")) {
				DoUATPExpressCheckoutPaymentReq req = new DoUATPExpressCheckoutPaymentReq();
				DoUATPExpressCheckoutPaymentRequestType reqType = new DoUATPExpressCheckoutPaymentRequestType();
				reqType.setVersion("82");
				DoExpressCheckoutPaymentRequestDetailsType checkoutDetails = new DoExpressCheckoutPaymentRequestDetailsType();
				checkoutDetails.setPayerID("EJTLSVJNCUC7E");
				checkoutDetails.setToken("EC-85T68611V3712474E");
				checkoutDetails.setPaymentAction(PaymentActionCodeType.ORDER);
				BasicAmountType amount = new BasicAmountType(
						CurrencyCodeType.fromValue(request
								.getParameter("currencyID")),
						request.getParameter("amt"));
				PaymentDetailsType detailsType = new PaymentDetailsType();
				detailsType.setOrderTotal(amount);
				List<PaymentDetailsType> payList = new ArrayList<PaymentDetailsType>();
				payList.add(detailsType);
				checkoutDetails.setPaymentDetails(payList);
				reqType.setDoExpressCheckoutPaymentRequestDetails(checkoutDetails);
				req.setDoUATPExpressCheckoutPaymentRequest(reqType);
				DoUATPExpressCheckoutPaymentResponseType resp = service
						.doUATPExpressCheckoutPayment(req);

				if (resp != null) {
					if (resp.getAck().toString().equalsIgnoreCase("SUCCESS")
							|| resp.getAck().toString()
									.equalsIgnoreCase("SUCCESSWITHWARNING")) {
						response.getWriter().println("Ack : " + resp.getAck());
						response.getWriter().println("<br/>");

					} else {
						HttpSession session = request.getSession();
						session.setAttribute("Error", resp.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}
			}
			response.getWriter().println("<br/>");
			response.getWriter().println(
					"<a href='/merchant-sample/index.html'>Home</a>");
			response.getWriter().println("<br/>");
			response.getWriter().println("See also:");
			response.getWriter().println("<br/>");
			response.getWriter()
					.println(
							"<ul><li><a href='SetExpressCheckout'>SetExpressCheckout</a></li><li><a href='GetExpressCheckout'>GetExpressCheckout</a></li><li><a href='DoExpressCheckout'>DoExpressCheckout</a></li><li><a href='DoUATPExpressCheckoutPayment'>DoUATPExpressCheckout</a></li></ul>");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SSLConfigurationException e) {
			e.printStackTrace();
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (HttpErrorException e) {
			e.printStackTrace();
		} catch (InvalidResponseDataException e) {
			e.printStackTrace();
		} catch (ClientActionRequiredException e) {
			e.printStackTrace();
		} catch (MissingCredentialException e) {
			e.printStackTrace();
		} catch (OAuthException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private float round(float Rval, int Rpl) {
		float p = (float) Math.pow(10, Rpl);
		Rval = Rval * p;
		float tmp = Math.round(Rval);
		return (float) tmp / p;
	}

}

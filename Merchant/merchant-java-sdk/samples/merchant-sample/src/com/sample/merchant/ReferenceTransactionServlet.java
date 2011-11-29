package com.sample.merchant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.BAUpdateRequestType;
import urn.ebay.api.PayPalAPI.BAUpdateResponseType;
import urn.ebay.api.PayPalAPI.BillAgreementUpdateReq;
import urn.ebay.api.PayPalAPI.BillUserReq;
import urn.ebay.api.PayPalAPI.BillUserRequestType;
import urn.ebay.api.PayPalAPI.BillUserResponseType;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionReq;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionRequestType;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionResponseType;
import urn.ebay.api.PayPalAPI.GetBillingAgreementCustomerDetailsReq;
import urn.ebay.api.PayPalAPI.GetBillingAgreementCustomerDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetBillingAgreementCustomerDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AddressType;
import urn.ebay.apis.eBLBaseComponents.CountryCodeType;
import urn.ebay.apis.eBLBaseComponents.CreditCardNumberTypeType;
import urn.ebay.apis.eBLBaseComponents.CreditCardTypeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.DoReferenceTransactionRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.MerchantPullPaymentCodeType;
import urn.ebay.apis.eBLBaseComponents.MerchantPullPaymentType;
import urn.ebay.apis.eBLBaseComponents.MerchantPullStatusCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PersonNameType;
import urn.ebay.apis.eBLBaseComponents.ReferenceCreditCardDetailsType;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

/**
 * Servlet implementation class ReferenceTransactionServlet
 */
public class ReferenceTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ReferenceTransactionServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getRequestURI().contains(
				"GetBillingAgreementCustomerDetails")) {
			getServletConfig()
					.getServletContext()
					.getRequestDispatcher(
							"/ReferenceTransactions/GetBillingAgreementCustomerDetails.jsp")
					.forward(request, response);
		} else if (request.getRequestURI().contains("BillAgreementUpdate")) {
			getServletConfig()
					.getServletContext()
					.getRequestDispatcher(
							"/ReferenceTransactions/BillAgreementUpdate.jsp")
					.forward(request, response);
		} else if (request.getRequestURI().contains(
				"SetCustomerBillingAgreement")) {
			getServletConfig()
					.getServletContext()
					.getRequestDispatcher(
							"/ReferenceTransactions/DeprecatedBillingAgreement.jsp")
					.forward(request, response);
		} else if (request.getRequestURI().contains("CreateBillingAgreement")) {
			getServletConfig()
					.getServletContext()
					.getRequestDispatcher(
							"/ReferenceTransactions/DeprecatedBillingAgreement.jsp")
					.forward(request, response);
		} else if (request.getRequestURI().contains("DoReferenceTransaction")) {
			getServletConfig()
					.getServletContext()
					.getRequestDispatcher(
							"/ReferenceTransactions/DoReferenceTransaction.jsp")
					.forward(request, response);
		} else if (request.getRequestURI().contains("BillUser")) {
			getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/ReferenceTransactions/BillUser.jsp")
					.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("url", request.getRequestURI());
		session.setAttribute(
				"relatedUrl",
				"<ul><li><a href='RT/SetCustomerBillingAgreement'>SetCustomerBillingAgreement</a></li><li><a href='RT/CreateBillingAgreement'>CreateBillingAgreement</a></li><li><a href='RT/GetBillingAgreementCustomerDetails'>GetBillingAgreementCustomerDetails</a></li><li><a href='RT/BillAgreementUpdate'>BillAgreementUpdate</a></li><li><a href='RT/DoReferenceTransaction'>DoReferenceTransaction</a></li><li><a href='RT/BillUser'>BillUser</a></li></ul>");
		response.setContentType("text/html");
		try {
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(
					this.getServletContext().getRealPath("/")
							+ "/WEB-INF/sdk_config.properties");
			if (request.getRequestURI().contains(
					"GetBillingAgreementCustomerDetails")) {

				GetBillingAgreementCustomerDetailsReq gReq = new GetBillingAgreementCustomerDetailsReq();
				GetBillingAgreementCustomerDetailsRequestType gRequestType = new GetBillingAgreementCustomerDetailsRequestType();
				gRequestType.setToken(request.getParameter("token"));
				gReq.setGetBillingAgreementCustomerDetailsRequest(gRequestType);
				GetBillingAgreementCustomerDetailsResponseType txnresponse = service
						.getBillingAgreementCustomerDetails(gReq);

				if (txnresponse != null) {
					session.setAttribute("lastReq", service.getLastRequest());
					session.setAttribute("lastResp", service.getLastResponse());
					if (txnresponse.getAck().toString()
							.equalsIgnoreCase("SUCCESS")) {
						Map<Object, Object> map = new LinkedHashMap<Object, Object>();
						map.put("Ack", txnresponse.getAck());
						map.put("Payer Mail",
								txnresponse
										.getGetBillingAgreementCustomerDetailsResponseDetails()
										.getPayerInfo().getPayer());
						map.put("Address Owner",
								txnresponse
										.getGetBillingAgreementCustomerDetailsResponseDetails()
										.getBillingAddress().getAddressOwner());
						session.setAttribute("map", map);
						response.sendRedirect("/merchant-sample/Response.jsp");
					} else {
						session.setAttribute("Error", txnresponse.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}

			} else if (request.getRequestURI().contains("BillAgreementUpdate")) {

				BillAgreementUpdateReq bReq = new BillAgreementUpdateReq();
				BAUpdateRequestType baUpdateRequestType = new BAUpdateRequestType();
				baUpdateRequestType.setReferenceID(request
						.getParameter("referenceID"));
				baUpdateRequestType
						.setBillingAgreementStatus(MerchantPullStatusCodeType.fromValue(request
								.getParameter("billingAgreementStatus")));
				baUpdateRequestType.setBillingAgreementDescription(request
						.getParameter("billingAgreementDescription"));
				bReq.setBAUpdateRequest(baUpdateRequestType);
				BAUpdateResponseType txnresponse = service
						.billAgreementUpdate(bReq);

				if (txnresponse != null) {
					session.setAttribute("lastReq", service.getLastRequest());
					session.setAttribute("lastResp", service.getLastResponse());
					if (txnresponse.getAck().toString()
							.equalsIgnoreCase("SUCCESS")) {
						Map<Object, Object> map = new LinkedHashMap<Object, Object>();
						map.put("Ack", txnresponse.getAck());
						map.put("Billing Agreement ID", txnresponse
								.getBAUpdateResponseDetails()
								.getBillingAgreementID());
						map.put("Billing Agreement Description", txnresponse
								.getBAUpdateResponseDetails()
								.getBillingAgreementDescription());
						map.put("Billing Agreement Status", txnresponse
								.getBAUpdateResponseDetails()
								.getBillingAgreementStatus());
						session.setAttribute("map", map);
						response.sendRedirect("/merchant-sample/Response.jsp");
					} else {
						session.setAttribute("Error", txnresponse.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}
			} else if (request.getRequestURI().contains(
					"DoReferenceTransaction")) {
				DoReferenceTransactionReq doReq = new DoReferenceTransactionReq();
				DoReferenceTransactionRequestType doRequestType = new DoReferenceTransactionRequestType();
				DoReferenceTransactionRequestDetailsType doDetailsType = new DoReferenceTransactionRequestDetailsType();

				doDetailsType.setPaymentAction(PaymentActionCodeType
						.fromValue(request.getParameter("paymentAction")));
				String pt = request.getParameter("paymentType");
				doDetailsType.setPaymentType(MerchantPullPaymentCodeType
						.fromValue(pt));

				PaymentDetailsType paymentDetails = new PaymentDetailsType();

				paymentDetails.setButtonSource("Java_SDK_JSP");
				BasicAmountType amount = new BasicAmountType();
				amount.setValue(request.getParameter("amount"));
				amount.setCurrencyID(CurrencyCodeType.fromValue(request
						.getParameter("currencyID")));
				paymentDetails.setOrderTotal(amount);

				AddressType shipTo = new AddressType();
				shipTo.setName(request.getParameter("firstName") + " "
						+ request.getParameter("lastName"));
				shipTo.setStreet1(request.getParameter("address1"));
				shipTo.setStreet2(request.getParameter("address2"));
				shipTo.setCityName(request.getParameter("city"));
				shipTo.setStateOrProvince(request.getParameter("state"));
				shipTo.setCountry(CountryCodeType.US);
				shipTo.setPostalCode(request.getParameter("zip"));
				paymentDetails.setShipToAddress(shipTo);

				doDetailsType.setPaymentDetails(paymentDetails);

				doDetailsType.setReferenceID(request
						.getParameter("referenceID"));
				if (request.getParameter("ReferenceCreditCardDetails") != null
						&& "ON".equalsIgnoreCase(request
								.getParameter("ReferenceCreditCardDetails"))) {
					ReferenceCreditCardDetailsType rType = new ReferenceCreditCardDetailsType();

					PersonNameType personNameType = new PersonNameType();
					personNameType.setFirstName(request
							.getParameter("firstName"));
					personNameType
							.setLastName(request.getParameter("lastName"));
					rType.setCardOwnerName(personNameType);

					CreditCardNumberTypeType crType = new CreditCardNumberTypeType();
					crType.setCreditCardNumber(request
							.getParameter("creditCardNumber"));
					crType.setCreditCardType(CreditCardTypeType
							.fromValue(request.getParameter("creditCardType")));
					rType.setCreditCardNumberType(crType);

					rType.setCVV2(request.getParameter("CVV2"));
					rType.setExpMonth(Integer.parseInt(request
							.getParameter("expMonth")));
					rType.setExpYear(Integer.parseInt(request
							.getParameter("expYear")));
					rType.setStartMonth(Integer.parseInt(request
							.getParameter("startMonth")));
					rType.setStartYear(Integer.parseInt(request
							.getParameter("startYear")));

					AddressType billAddr = new AddressType();
					billAddr.setName(request.getParameter("firstName") + " "
							+ request.getParameter("lastName"));
					billAddr.setStreet1(request.getParameter("address1"));
					billAddr.setStreet2(request.getParameter("address2"));
					billAddr.setCityName(request.getParameter("city"));
					billAddr.setStateOrProvince(request.getParameter("state"));
					billAddr.setCountry(CountryCodeType.US);
					billAddr.setPostalCode(request.getParameter("zip"));
					rType.setBillingAddress(billAddr);

					doDetailsType.setCreditCard(rType);
				}

				doRequestType
						.setDoReferenceTransactionRequestDetails(doDetailsType);
				doReq.setDoReferenceTransactionRequest(doRequestType);
				DoReferenceTransactionResponseType txnresponse = null;
				txnresponse = service.doReferenceTransaction(doReq);
				response.setContentType("text/html");
				if (txnresponse != null) {
					session.setAttribute("lastReq", service.getLastRequest());
					session.setAttribute("lastResp", service.getLastResponse());
					if (txnresponse.getAck().toString()
							.equalsIgnoreCase("SUCCESS")) {
						Map<Object, Object> map = new LinkedHashMap<Object, Object>();
						map.put("Ack", txnresponse.getAck());
						map.put("Transaction ID", txnresponse
								.getDoReferenceTransactionResponseDetails()
								.getTransactionID());
						map.put("Billing Agreement ID", txnresponse
								.getDoReferenceTransactionResponseDetails()
								.getBillingAgreementID());
						map.put("",
								txnresponse
										.getDoReferenceTransactionResponseDetails()
										.getAmount().getValue()
										+ " "
										+ txnresponse
												.getDoReferenceTransactionResponseDetails()
												.getAmount().getCurrencyID());
						session.setAttribute("map", map);
						response.sendRedirect("/merchant-sample/Response.jsp");
					} else {
						session.setAttribute("Error", txnresponse.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}
			} else if (request.getRequestURI().contains("BillUser")) {
				BillUserReq req = new BillUserReq();
				BillUserRequestType reqType = new BillUserRequestType();
				MerchantPullPaymentType merchantPullPayment = new MerchantPullPaymentType();
				merchantPullPayment.setMpID(request
						.getParameter("billingAgreementID"));
				merchantPullPayment.setPaymentType(MerchantPullPaymentCodeType
						.fromValue(request.getParameter("paymentCodeType")));
				merchantPullPayment.setItemName(request
						.getParameter("itemName"));
				merchantPullPayment.setItemNumber(request
						.getParameter("itemNum"));
				merchantPullPayment.setAmount(new BasicAmountType(
						CurrencyCodeType.fromValue(request
								.getParameter("currencyID")), request
								.getParameter("amt")));
				merchantPullPayment.setMemo(request.getParameter("memo"));
				merchantPullPayment.setTax(new BasicAmountType(CurrencyCodeType
						.fromValue(request.getParameter("currencyID")), request
						.getParameter("tax")));
				merchantPullPayment.setShipping(new BasicAmountType(
						CurrencyCodeType.fromValue(request
								.getParameter("currencyID")), request
								.getParameter("shipping")));
				merchantPullPayment.setHandling(new BasicAmountType(
						CurrencyCodeType.fromValue(request
								.getParameter("currencyID")), request
								.getParameter("handling")));
				merchantPullPayment.setEmailSubject(request
						.getParameter("mailSubject"));
				reqType.setMerchantPullPaymentDetails(merchantPullPayment);
				req.setBillUserRequest(reqType);
				BillUserResponseType resp = service.billUser(req);
				if (resp != null) {
					session.setAttribute("lastReq", service.getLastRequest());
					session.setAttribute("lastResp", service.getLastResponse());
					if (resp.getAck().toString().equalsIgnoreCase("SUCCESS")) {
						Map<Object, Object> map = new LinkedHashMap<Object, Object>();
						map.put("Ack", resp.getAck());
						map.put("Payer Mail", resp.getBillUserResponseDetails()
								.getPayerInfo().getPayer());
						map.put("Merchant Pull Status", resp
								.getBillUserResponseDetails()
								.getMerchantPullInfo().getMpStatus());
						map.put("Transaction ID", resp
								.getBillUserResponseDetails().getPaymentInfo()
								.getTransactionID());
						session.setAttribute("map", map);
						response.sendRedirect("/merchant-sample/Response.jsp");
					} else {
						session.setAttribute("Error", resp.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}
			}

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
}

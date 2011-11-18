package com.sample.merchant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.BAUpdateRequestType;
import urn.ebay.api.PayPalAPI.BAUpdateResponseType;
import urn.ebay.api.PayPalAPI.BillAgreementUpdateReq;
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
import urn.ebay.apis.eBLBaseComponents.ErrorType;
import urn.ebay.apis.eBLBaseComponents.MerchantPullPaymentCodeType;
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
		}
		if (request.getRequestURI().contains("BillAgreementUpdate")) {
			getServletConfig()
					.getServletContext()
					.getRequestDispatcher(
							"/ReferenceTransactions/BillAgreementUpdate.jsp")
					.forward(request, response);
		}
		if (request.getRequestURI().contains("DoReferenceTransaction")) {
			getServletConfig()
					.getServletContext()
					.getRequestDispatcher(
							"/ReferenceTransactions/DoReferenceTransaction.jsp")
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
				gRequestType.setVersion("82.0");
				gReq.setGetBillingAgreementCustomerDetailsRequest(gRequestType);
				GetBillingAgreementCustomerDetailsResponseType txnresponse = service
						.getBillingAgreementCustomerDetails(gReq);

				if (txnresponse != null) {
					if (txnresponse.getAck().toString()
							.equalsIgnoreCase("SUCCESS")) {
						response.getWriter().println(
								"Ack : " + txnresponse.getAck());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"CorrelationID : "
										+ txnresponse.getCorrelationID());
						response.getWriter().println("<br/>");
						if (txnresponse
								.getGetBillingAgreementCustomerDetailsResponseDetails()
								.getPayerInfo() != null) {
							response.getWriter()
									.println(
											"<b>BillingAgreement User detail :</b><br/>");
							response.getWriter()
									.println(
											"Payer Id : "
													+ txnresponse
															.getGetBillingAgreementCustomerDetailsResponseDetails()
															.getPayerInfo().getPayerID());
							response.getWriter().println("<br/>");
							response.getWriter()
									.println(
											"Contact phone No : "
													+ txnresponse
															.getGetBillingAgreementCustomerDetailsResponseDetails()
															.getPayerInfo().getContactPhone());
							response.getWriter().println("<br/>");
							response.getWriter()
									.println(
											"Payer : "
													+ txnresponse
															.getGetBillingAgreementCustomerDetailsResponseDetails()
															.getPayerInfo().getPayer());
							response.getWriter().println("<br/>");
							response.getWriter()
									.println(
											"Payer Country Name : "
													+ txnresponse
															.getGetBillingAgreementCustomerDetailsResponseDetails()
															.getPayerInfo().getPayerCountry());
						}

					} else {
						List<ErrorType> errorList = txnresponse.getErrors();
						for (ErrorType e : errorList) {
							response.getWriter().println(
									"Short Err Msg : " + e.getShortMessage());
							response.getWriter().println("<br/>");
							response.getWriter().println(
									"Long Err Msg : " + e.getLongMessage());
						}
					}
				}

			} else if (request.getRequestURI().contains("BillAgreementUpdate")) {

				BillAgreementUpdateReq bReq = new BillAgreementUpdateReq();
				BAUpdateRequestType baUpdateRequestType = new BAUpdateRequestType();
				baUpdateRequestType.setVersion("82.0");
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
					if (txnresponse.getAck().toString()
							.equalsIgnoreCase("SUCCESS")) {
						response.getWriter().println(
								"Ack : " + txnresponse.getAck());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"CorrelationID : "
										+ txnresponse.getCorrelationID());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Billing Agreement Status : "
										+ txnresponse
												.getBAUpdateResponseDetails()
												.getBillingAgreementStatus());

					} else {
						List<ErrorType> errorList = txnresponse.getErrors();
						for (ErrorType e : errorList) {
							response.getWriter().println(
									"Short Err Msg : " + e.getShortMessage());
							response.getWriter().println("<br/>");
							response.getWriter().println(
									"Long Err Msg : " + e.getLongMessage());
						}
					}
				}

			} else if (request.getRequestURI().contains(
					"DoReferenceTransaction")) {
				DoReferenceTransactionReq doReq = new DoReferenceTransactionReq();
				DoReferenceTransactionRequestType doRequestType = new DoReferenceTransactionRequestType();
				DoReferenceTransactionRequestDetailsType doDetailsType = new DoReferenceTransactionRequestDetailsType();

				doRequestType.setVersion("82.0");
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
					if (txnresponse.getAck().toString()
							.equalsIgnoreCase("SUCCESS")) {
						response.getWriter().println(
								"Ack : " + txnresponse.getAck());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"CorrelationID : "
										+ txnresponse.getCorrelationID());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"<b>Reference Transaction detail :</b><br/>");
						response.getWriter()
								.println(
										"BillingAgreementID : "
												+ txnresponse
														.getDoReferenceTransactionResponseDetails()
														.getBillingAgreementID());
						response.getWriter().println("<br/>");
						response.getWriter()
								.println(
										"TransactionID : "
												+ txnresponse
														.getDoReferenceTransactionResponseDetails()
														.getTransactionID());
						response.getWriter().println("<br/>");
						response.getWriter()
								.println(
										"Amount : "
												+ txnresponse
														.getDoReferenceTransactionResponseDetails()
														.getAmount().getValue());

					} else {
						List<ErrorType> errorList = txnresponse.getErrors();
						for (ErrorType e : errorList) {
							response.getWriter().println(
									"Short Err Msg : " + e.getShortMessage());
							response.getWriter().println("<br/>");
							response.getWriter().println(
									"Long Err Msg : " + e.getLongMessage());
						}
					}
				}
			}
			response.getWriter().println("<br/>");
			response.getWriter().println("<a href='/merchant-sample/index.html'>Home</a>");

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

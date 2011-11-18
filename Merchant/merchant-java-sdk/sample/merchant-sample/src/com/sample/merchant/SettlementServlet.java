package com.sample.merchant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

import urn.ebay.api.PayPalAPI.DoAuthorizationReq;
import urn.ebay.api.PayPalAPI.DoAuthorizationRequestType;
import urn.ebay.api.PayPalAPI.DoAuthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoCaptureReq;
import urn.ebay.api.PayPalAPI.DoCaptureRequestType;
import urn.ebay.api.PayPalAPI.DoCaptureResponseType;
import urn.ebay.api.PayPalAPI.DoReauthorizationReq;
import urn.ebay.api.PayPalAPI.DoReauthorizationRequestType;
import urn.ebay.api.PayPalAPI.DoReauthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionReq;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionRequestType;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionResponseType;
import urn.ebay.api.PayPalAPI.DoVoidReq;
import urn.ebay.api.PayPalAPI.DoVoidRequestType;
import urn.ebay.api.PayPalAPI.DoVoidResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AddressType;
import urn.ebay.apis.eBLBaseComponents.CompleteCodeType;
import urn.ebay.apis.eBLBaseComponents.CountryCodeType;
import urn.ebay.apis.eBLBaseComponents.CreditCardNumberTypeType;
import urn.ebay.apis.eBLBaseComponents.CreditCardTypeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.DoReferenceTransactionRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.ErrorType;
import urn.ebay.apis.eBLBaseComponents.MerchantPullPaymentCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PersonNameType;
import urn.ebay.apis.eBLBaseComponents.ReferenceCreditCardDetailsType;

/**
 * Servlet implementation class CheckoutServlet
 */
public class SettlementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SettlementServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getRequestURI().contains("DoAuthorization"))
			getServletConfig().getServletContext()
					.getRequestDispatcher("/Settlements/DoAuthorization.jsp")
					.forward(request, response);
		else if (request.getRequestURI().contains("DoReauthorization"))
			getServletConfig().getServletContext()
					.getRequestDispatcher("/Settlements/DoReauthorization.jsp")
					.forward(request, response);
		else if (request.getRequestURI().contains("DoVoid"))
			getServletConfig().getServletContext()
					.getRequestDispatcher("/Settlements/DoVoid.jsp")
					.forward(request, response);
		else if (request.getRequestURI().contains("DoCapture"))
			getServletConfig().getServletContext()
					.getRequestDispatcher("/Settlements/DoCapture.jsp")
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
			if (request.getRequestURI().contains("DoAuthorization")) {
				DoAuthorizationReq req = new DoAuthorizationReq();
				BasicAmountType amount = new BasicAmountType(
						CurrencyCodeType.fromValue(request
								.getParameter("currencyCode")),
						request.getParameter("amt"));
				DoAuthorizationRequestType reqType = new DoAuthorizationRequestType(
						request.getParameter("transID"), amount);
				reqType.setVersion("82");
				req.setDoAuthorizationRequest(reqType);
				DoAuthorizationResponseType resp = service.doAuthorization(req);
				if (resp != null) {
					if (resp.getAck().toString().equalsIgnoreCase("SUCCESS")) {
						response.getWriter().println("Ack: " + resp.getAck());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Authorization ID: " + resp.getTransactionID());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Protection Eligibility:"
										+ resp.getAuthorizationInfo()
												.getProtectionEligibility());
						response.getWriter().println("<br/>");
						response.getWriter()
								.println(
										"Protection Eligiblity Type:"
												+ resp.getAuthorizationInfo()
														.getProtectionEligibilityType());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Payment Status:"
										+ resp.getAuthorizationInfo()
												.getPaymentStatus());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Pending Reason:"
										+ resp.getAuthorizationInfo()
												.getPendingReason());
						response.getWriter().println("<br/>");

					} else {
						HttpSession session = request.getSession();
						session.setAttribute("Error", resp.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}
			} else if (request.getRequestURI().contains("DoReauthorization")) {
				DoReauthorizationReq req = new DoReauthorizationReq();
				BasicAmountType amount = new BasicAmountType(
						CurrencyCodeType.fromValue(request
								.getParameter("currencyCode")),
						request.getParameter("amt"));
				DoReauthorizationRequestType reqType = new DoReauthorizationRequestType(
						request.getParameter("authID"), amount);
				reqType.setVersion("82");
				req.setDoReauthorizationRequest(reqType);
				DoReauthorizationResponseType resp = service
						.doReauthorization(req);

				if (resp != null) {
					if (resp.getAck().toString().equalsIgnoreCase("SUCCESS")) {
						response.getWriter().println("Ack: " + resp.getAck());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Authorization ID: "
										+ resp.getAuthorizationID());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Protection Eligibility:"
										+ resp.getAuthorizationInfo()
												.getProtectionEligibility());
						response.getWriter().println("<br/>");
						response.getWriter()
								.println(
										"Protection Eligiblity Type:"
												+ resp.getAuthorizationInfo()
														.getProtectionEligibilityType());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Payment Status:"
										+ resp.getAuthorizationInfo()
												.getPaymentStatus());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Pending Reason:"
										+ resp.getAuthorizationInfo()
												.getPendingReason());
						response.getWriter().println("<br/>");

					} else {
						HttpSession session = request.getSession();
						session.setAttribute("Error", resp.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}
			} else if (request.getRequestURI().contains("DoVoid")) {
				DoVoidReq req = new DoVoidReq();
				DoVoidRequestType reqType = new DoVoidRequestType(
						request.getParameter("authID"));
				reqType.setVersion("82");
				req.setDoVoidRequest(reqType);
				DoVoidResponseType resp = service.doVoid(req);
				if (resp != null) {
					if (resp.getAck().toString().equalsIgnoreCase("SUCCESS")) {
						response.getWriter().println("Ack: " + resp.getAck());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Authorization ID: "
										+ resp.getAuthorizationID());
						response.getWriter().println("<br/>");

					} else {
						HttpSession session = request.getSession();
						session.setAttribute("Error", resp.getErrors());
						response.sendRedirect("/merchant-sample/Error.jsp");
					}
				}
			} else if (request.getRequestURI().contains("DoCapture")) {
				DoCaptureReq req = new DoCaptureReq();
				BasicAmountType amount = new BasicAmountType(
						CurrencyCodeType.fromValue(request
								.getParameter("currencyCode")),
						request.getParameter("amt"));
				DoCaptureRequestType reqType = new DoCaptureRequestType(
						request.getParameter("authID"), amount,
						CompleteCodeType.fromValue(request
								.getParameter("completeCodeType")));
				reqType.setVersion("82");
				req.setDoCaptureRequest(reqType);
				DoCaptureResponseType resp = service.doCapture(req);
				if (resp != null) {
					if (resp.getAck().toString().equalsIgnoreCase("SUCCESS")) {
						response.getWriter().println("Ack: " + resp.getAck());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"Authorization ID: "
										+ resp.getDoCaptureResponseDetails()
												.getAuthorizationID());
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
							"<ul><li><a href='DoAuthorization'>DoAuthorization</a></li><li><a href='DoCapture'>DoCapture</a></li><li><a href='DoVoid'>DoVoid</a></li><li><a href='DoReauthorization'>DoReauthorization</a></li></ul>");
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

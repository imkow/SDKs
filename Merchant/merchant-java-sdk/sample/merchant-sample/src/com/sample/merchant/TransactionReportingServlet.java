package com.sample.merchant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.TransactionSearchReq;
import urn.ebay.api.PayPalAPI.TransactionSearchRequestType;
import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;
import urn.ebay.apis.eBLBaseComponents.ErrorType;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

public class TransactionReportingServlet extends HttpServlet {
	private static final long serialVersionUID = 2212442342452L;

	public TransactionReportingServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletConfig().getServletContext()
				.getRequestDispatcher("/Reports/TransactionSearch.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		TransactionSearchReq txnreq = new TransactionSearchReq();
		TransactionSearchRequestType type = new TransactionSearchRequestType();
		try {
			DateFormat dfRead = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
			if ((request.getParameter("startDate") != null)
					&& !request.getParameter("startDate").toString().equals("")) {
				type.setStartDate(request.getParameter("startDate")
						+ "T00:00:00.000Z");
			}

			if ((request.getParameter("endDate") != null)
					&& !request.getParameter("endDate").toString().equals("")) {
				type.setEndDate(request.getParameter("endDate")
						+ "T23:59:59.000Z");
			}

			type.setVersion("76.0");
			type.setTransactionID(request.getParameter("transactionID"));
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(
					this.getServletContext().getRealPath("/")
							+ "/WEB-INF/sdk_config.properties");
			txnreq.setTransactionSearchRequest(type);
			TransactionSearchResponseType txnresponse = null;
			txnresponse = service.transactionSearch(txnreq);
			response.setContentType("text/html");
			if (txnresponse != null) {
				if (txnresponse.getAck().toString().equalsIgnoreCase("SUCCESS")) {
					if (txnresponse.getPaymentTransactions().size() > 0) {
						response.getWriter().println(
								"Ack : " + txnresponse.getAck());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"TransactionId : "
										+ txnresponse.getPaymentTransactions()
												.get(0).getTransactionID());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"CurrencyId : "
										+ txnresponse.getPaymentTransactions()
												.get(0).getNetAmount()
												.getCurrencyID());
						response.getWriter().println("<br/>");
						response.getWriter().println(
								"NetAmount : "
										+ txnresponse.getPaymentTransactions()
												.get(0).getNetAmount()
												.getValue());
					}
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("Error", txnresponse.getErrors());
					response.sendRedirect("/merchant-sample/Error.jsp");
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
							"<ul><li><a href='GetTransactionDetails'>GetTransactionDetails</a></li><li><a href='TransactionSearch'>TransactionSearch</a></li></ul>");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SSLConfigurationException e) {
			e.printStackTrace();
		} catch (InvalidCredentialException e) {
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
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
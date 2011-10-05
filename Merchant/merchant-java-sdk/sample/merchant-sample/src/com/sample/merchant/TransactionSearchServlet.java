package com.sample.merchant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.TransactionSearchReq;
import urn.ebay.api.PayPalAPI.TransactionSearchRequestType;
import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

public class TransactionSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 2212442342452L;

	public TransactionSearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletConfig().getServletContext().getRequestDispatcher(
				"/TransactionSearch.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		TransactionSearchReq txnreq = new TransactionSearchReq();
		TransactionSearchRequestType type = new TransactionSearchRequestType();
		try {
			DateFormat dfRead = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
			if ((request.getParameter("startDateStr") != null)
					&& !request.getParameter("startDateStr").toString().equals("")) {
				type.setStartDate(request.getParameter("startDateStr")+ "T00:00:00.000Z"); 
			}

			if ((request.getParameter("endDateStr") != null)
					&& !request.getParameter("endDateStr").toString().equals("")) {
				type.setEndDate(request.getParameter("endDateStr")+ "T23:59:59.000Z"); 
			}

			type.setVersion("76.0");
			type.setTransactionID(request.getParameter("transactionID"));
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(
					this.getServletContext().getRealPath("/")+ "/WEB-INF/sdk_config.properties");
			txnreq.setTransactionSearchRequest(type);
			TransactionSearchResponseType txnresponse = null;
			txnresponse = service.transactionSearch(txnreq);
			
			if (txnresponse.getPaymentTransactions().size() > 0) {
				response.setContentType("text/html");
				response.getWriter().println("Ack : " + txnresponse.getAck());
				response.getWriter().println("<br/>");
				response.getWriter().println("CurrencyId : "+ txnresponse.getPaymentTransactions().get(0)
						.getNetAmount().getCurrencyID());
				response.getWriter().println("<br/>");
				response.getWriter().println("NetAmount : "+txnresponse.getPaymentTransactions().get(0)
						.getNetAmount().getValue());
			}
			response.getWriter().println("<br/>");
			response.getWriter().println("<a href='index.html'>Home</a>");
		}catch (FileNotFoundException e) {
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
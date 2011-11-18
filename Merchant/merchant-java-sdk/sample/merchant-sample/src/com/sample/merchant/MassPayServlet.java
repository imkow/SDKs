package com.sample.merchant;

import java.io.IOException;
import java.util.ArrayList;
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

import urn.ebay.api.PayPalAPI.MassPayReq;
import urn.ebay.api.PayPalAPI.MassPayRequestItemType;
import urn.ebay.api.PayPalAPI.MassPayRequestType;
import urn.ebay.api.PayPalAPI.MassPayResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.PayerInfoType;
import urn.ebay.apis.eBLBaseComponents.ReceiverInfoCodeType;

/**
 * Servlet implementation class MassPayServlet
 */
public class MassPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MassPayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext()
				.getRequestDispatcher("/MassPay/MassPay.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MassPayReq req = new MassPayReq();

		List<MassPayRequestItemType> massPayItem = new ArrayList<MassPayRequestItemType>();
		BasicAmountType amount1 = new BasicAmountType(
				CurrencyCodeType.fromValue(request
						.getParameter("currencyCode1")),
				request.getParameter("amount1"));
		BasicAmountType amount2 = new BasicAmountType(
				CurrencyCodeType.fromValue(request
						.getParameter("currencyCode2")),
				request.getParameter("amount2"));
		BasicAmountType amount3 = new BasicAmountType(
				CurrencyCodeType.fromValue(request
						.getParameter("currencyCode3")),
				request.getParameter("amount3"));
		MassPayRequestItemType item1 = new MassPayRequestItemType(amount1);
		item1.setReceiverEmail(request.getParameter("mail1"));
		massPayItem.add(item1);
		MassPayRequestItemType item2 = new MassPayRequestItemType(amount2);
		item2.setReceiverEmail(request.getParameter("mail2"));
		massPayItem.add(item2);
		MassPayRequestItemType item3 = new MassPayRequestItemType(amount3);
		item3.setReceiverEmail(request.getParameter("mail3"));
		massPayItem.add(item3);
		MassPayRequestType reqType = new MassPayRequestType(massPayItem);
		reqType.setVersion("84.0");
		reqType.setReceiverType(ReceiverInfoCodeType.EMAILADDRESS);
		req.setMassPayRequest(reqType);
		PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(
				this.getServletContext().getRealPath("/")
						+ "/WEB-INF/sdk_config.properties");
		try {
			response.setContentType("text/html");
			MassPayResponseType resp = service.massPay(req);
			if (resp != null) {
				if (resp.getAck().toString().equalsIgnoreCase("SUCCESS")) {
					response.getWriter().println("Ack : " + resp.getAck());
					response.getWriter().println("<br/>");

				} else {
					HttpSession session = request.getSession();
					session.setAttribute("Error", resp.getErrors());
					response.sendRedirect("/merchant-sample/Error.jsp");
				}
			}
			response.getWriter().println("<br/>");
			response.getWriter().println("<a href='index.html'>Home</a>");
			response.getWriter().println("<br/>");
			response.getWriter().println("See also:");
			response.getWriter().println("<br/>");
			response.getWriter().println(
					"<ul><li><a href='MassPay'></a></li></ul>");
		} catch (SSLConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HttpErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidResponseDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientActionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

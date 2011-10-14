package com.sample.merchant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.DoDirectPaymentReq;
import urn.ebay.api.PayPalAPI.DoDirectPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoDirectPaymentResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AddressType;
import urn.ebay.apis.eBLBaseComponents.CountryCodeType;
import urn.ebay.apis.eBLBaseComponents.CreditCardDetailsType;
import urn.ebay.apis.eBLBaseComponents.CreditCardTypeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.DoDirectPaymentRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.PayerInfoType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PersonNameType;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

public class DoDirectPaymentServlet extends HttpServlet{

	private static final long serialVersionUID = 12345456723541232L;
	
	public DoDirectPaymentServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  getServletConfig().getServletContext().getRequestDispatcher("/DoDirectPayment.jsp").forward(req, res);	
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		DoDirectPaymentReq doPaymentReq = new DoDirectPaymentReq();
		DoDirectPaymentRequestType pprequest = new DoDirectPaymentRequestType();
		pprequest.setVersion("76.0");
		DoDirectPaymentRequestDetailsType details = new DoDirectPaymentRequestDetailsType();
		PaymentDetailsType paymentDetails = new PaymentDetailsType();
		paymentDetails.setButtonSource("Java_SDK_JSP");

		BasicAmountType amount = new BasicAmountType();
		amount.setValue(req.getParameter("amount"));
		amount.setCurrencyID(CurrencyCodeType.USD);
		paymentDetails.setOrderTotal(amount);	
				
		AddressType shipTo = new AddressType();
		shipTo.setName(req.getParameter("firstName")+ " " + req.getParameter("lastName"));
		shipTo.setStreet1(req.getParameter("address1"));
		shipTo.setStreet2(req.getParameter("address2"));
		shipTo.setCityName(req.getParameter("city"));
		shipTo.setStateOrProvince(req.getParameter("state"));
		shipTo.setCountry(CountryCodeType.US);
		shipTo.setPostalCode(req.getParameter("zip"));
		paymentDetails.setShipToAddress(shipTo);
		
		details.setPaymentDetails(paymentDetails);
	       
		CreditCardDetailsType cardDetails = new CreditCardDetailsType();
		cardDetails.setCreditCardType(CreditCardTypeType.fromValue(req.getParameter("creditCardType")));
		cardDetails.setCreditCardNumber(req.getParameter("creditCardNumber"));
		cardDetails.setExpMonth(Integer.parseInt(req.getParameter("expDateMonth")));
		cardDetails.setExpYear(Integer.parseInt(req.getParameter("expDateYear")));
		cardDetails.setCVV2(req.getParameter("cvv2Number"));
		
		PayerInfoType payer = new PayerInfoType();
		PersonNameType name = new PersonNameType();
		name.setFirstName(req.getParameter("firstName"));
		name.setLastName(req.getParameter("lastName"));
		payer.setPayerName(name);
		payer.setPayerCountry(CountryCodeType.US);
	    payer.setAddress(shipTo);
	   
	    cardDetails.setCardOwner(payer);
	                
		details.setCreditCard(cardDetails);
		
		details.setIPAddress("127.0.0.1");
		details.setPaymentAction(PaymentActionCodeType.fromValue(req.getParameter("paymentType")));
		
	    pprequest.setDoDirectPaymentRequestDetails(details);
	    doPaymentReq.setDoDirectPaymentRequest(pprequest);
	    
		try {
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(
					this.getServletContext().getRealPath("/")+ "/WEB-INF/sdk_config.properties");
			DoDirectPaymentResponseType ddresponse = service.doDirectPayment(doPaymentReq);
			res.setContentType("text/html");
			if(ddresponse!=null){
				if(ddresponse.getAck().toString().equalsIgnoreCase("SUCCESS") || ddresponse.getAck().toString().equalsIgnoreCase("SUCCESSWITHWARNING")){
					res.getWriter().println("CorelationId : "+ddresponse.getCorrelationID());
					res.getWriter().println("<br/>");
					res.getWriter().println("TransactionId : "+ddresponse.getTransactionID());
				}else{
					List<ErrorType> errorList = ddresponse.getErrors();
					for(ErrorType e:errorList){
						res.getWriter().println("Short Err Msg : "+e.getShortMessage());
						res.getWriter().println("Long Err Msg : "+e.getLongMessage());
					}
				}
			}
			
			res.getWriter().println("<br/>");
			res.getWriter().println("<a href='index.html'>Home</a>");
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SAXException e) {
			e.printStackTrace();
		}catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (SSLConfigurationException e) {
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
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}

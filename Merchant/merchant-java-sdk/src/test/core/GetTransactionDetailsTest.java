package test.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.DoDirectPaymentReq;
import urn.ebay.api.PayPalAPI.DoDirectPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoDirectPaymentResponseType;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsReq;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.apis.eBLBaseComponents.DoDirectPaymentRequestDetailsType;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

public class GetTransactionDetailsTest {
	@Test
	public void doDirectPayment() throws ParserConfigurationException, SAXException {
		DoDirectPaymentReq req = new DoDirectPaymentReq();
		
		DoDirectPaymentRequestDetailsType DoDirectPaymentRequestDetails = new DoDirectPaymentRequestDetailsType();
	
		DoDirectPaymentRequestType reqType = new DoDirectPaymentRequestType(
				DoDirectPaymentRequestDetails);
		reqType.setVersion("78.0");
		
		req.setDoDirectPaymentRequest(reqType);
		PayPalAPIInterfaceServiceService service = null;
		try {
			service = new PayPalAPIInterfaceServiceService(
					"C:/Documents and Settings/lvairamani/Desktop/eclipsews/MerchantJava/resource/sdk_config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DoDirectPaymentResponseType response = null;
		try {

			response = service.doDirectPayment(req);
			System.out.println(response.getAck());
			System.out.println(response.getVersion());

		} catch (SSLConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void f() {

		GetTransactionDetailsReq req = new GetTransactionDetailsReq();
		GetTransactionDetailsRequestType reqType = new GetTransactionDetailsRequestType();
		reqType.setVersion("78.0");
		reqType.setTransactionID("6MS29234D79035902");
		req.setGetTransactionDetailsRequest(reqType);
		PayPalAPIInterfaceServiceService service = null;
		try {
			service = new PayPalAPIInterfaceServiceService(
					"C:/Documents and Settings/lvairamani/Desktop/eclipsews/MerchantJava/resource/sdk_config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetTransactionDetailsResponseType response = null;
		try {

			response = service.getTransactionDetails(req);
			System.out.println(response.getAck());
			System.out.println(response.getVersion());
			System.out.println(response.getPaymentTransactionDetails()
					.getPayerInfo().getPayerStatus());
		} catch (SSLConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

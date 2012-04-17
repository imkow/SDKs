/**
 * PayPalAPIInterfaceServiceService wrapper class
 * Auto generated code
 */
package urn.ebay.api.PayPalAPI;

import com.paypal.core.BaseService;
import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import urn.ebay.api.PayPalAPI.AddressVerifyReq;
import urn.ebay.api.PayPalAPI.AddressVerifyResponseType;
import urn.ebay.api.PayPalAPI.BAUpdateResponseType;
import urn.ebay.api.PayPalAPI.BillAgreementUpdateReq;
import urn.ebay.api.PayPalAPI.BillOutstandingAmountReq;
import urn.ebay.api.PayPalAPI.BillOutstandingAmountResponseType;
import urn.ebay.api.PayPalAPI.BillUserReq;
import urn.ebay.api.PayPalAPI.BillUserResponseType;
import urn.ebay.api.PayPalAPI.CancelRecoupReq;
import urn.ebay.api.PayPalAPI.CancelRecoupResponseType;
import urn.ebay.api.PayPalAPI.CompleteRecoupReq;
import urn.ebay.api.PayPalAPI.CompleteRecoupResponseType;
import urn.ebay.api.PayPalAPI.CreateBillingAgreementReq;
import urn.ebay.api.PayPalAPI.CreateBillingAgreementResponseType;
import urn.ebay.api.PayPalAPI.CreateMobilePaymentReq;
import urn.ebay.api.PayPalAPI.CreateMobilePaymentResponseType;
import urn.ebay.api.PayPalAPI.CreateRecurringPaymentsProfileReq;
import urn.ebay.api.PayPalAPI.CreateRecurringPaymentsProfileResponseType;
import urn.ebay.api.PayPalAPI.DoAuthorizationReq;
import urn.ebay.api.PayPalAPI.DoAuthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoCancelReq;
import urn.ebay.api.PayPalAPI.DoCancelResponseType;
import urn.ebay.api.PayPalAPI.DoCaptureReq;
import urn.ebay.api.PayPalAPI.DoCaptureResponseType;
import urn.ebay.api.PayPalAPI.DoDirectPaymentReq;
import urn.ebay.api.PayPalAPI.DoDirectPaymentResponseType;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.DoMobileCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoMobileCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.DoNonReferencedCreditReq;
import urn.ebay.api.PayPalAPI.DoNonReferencedCreditResponseType;
import urn.ebay.api.PayPalAPI.DoReauthorizationReq;
import urn.ebay.api.PayPalAPI.DoReauthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionReq;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionResponseType;
import urn.ebay.api.PayPalAPI.DoUATPAuthorizationReq;
import urn.ebay.api.PayPalAPI.DoUATPAuthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoUATPExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoUATPExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.DoVoidReq;
import urn.ebay.api.PayPalAPI.DoVoidResponseType;
import urn.ebay.api.PayPalAPI.EnterBoardingReq;
import urn.ebay.api.PayPalAPI.EnterBoardingResponseType;
import urn.ebay.api.PayPalAPI.ExecuteCheckoutOperationsReq;
import urn.ebay.api.PayPalAPI.ExecuteCheckoutOperationsResponseType;
import urn.ebay.api.PayPalAPI.ExternalRememberMeOptOutReq;
import urn.ebay.api.PayPalAPI.ExternalRememberMeOptOutResponseType;
import urn.ebay.api.PayPalAPI.GetAccessPermissionDetailsReq;
import urn.ebay.api.PayPalAPI.GetAccessPermissionDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetAuthDetailsReq;
import urn.ebay.api.PayPalAPI.GetAuthDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetBalanceReq;
import urn.ebay.api.PayPalAPI.GetBalanceResponseType;
import urn.ebay.api.PayPalAPI.GetBillingAgreementCustomerDetailsReq;
import urn.ebay.api.PayPalAPI.GetBillingAgreementCustomerDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetBoardingDetailsReq;
import urn.ebay.api.PayPalAPI.GetBoardingDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsReq;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetIncentiveEvaluationReq;
import urn.ebay.api.PayPalAPI.GetIncentiveEvaluationResponseType;
import urn.ebay.api.PayPalAPI.GetMobileStatusReq;
import urn.ebay.api.PayPalAPI.GetMobileStatusResponseType;
import urn.ebay.api.PayPalAPI.GetPalDetailsReq;
import urn.ebay.api.PayPalAPI.GetPalDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetRecurringPaymentsProfileDetailsReq;
import urn.ebay.api.PayPalAPI.GetRecurringPaymentsProfileDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsReq;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsResponseType;
import urn.ebay.api.PayPalAPI.InitiateRecoupReq;
import urn.ebay.api.PayPalAPI.InitiateRecoupResponseType;
import urn.ebay.api.PayPalAPI.ManagePendingTransactionStatusReq;
import urn.ebay.api.PayPalAPI.ManagePendingTransactionStatusResponseType;
import urn.ebay.api.PayPalAPI.ManageRecurringPaymentsProfileStatusReq;
import urn.ebay.api.PayPalAPI.ManageRecurringPaymentsProfileStatusResponseType;
import urn.ebay.api.PayPalAPI.MassPayReq;
import urn.ebay.api.PayPalAPI.MassPayResponseType;
import urn.ebay.api.PayPalAPI.RefundTransactionReq;
import urn.ebay.api.PayPalAPI.RefundTransactionResponseType;
import urn.ebay.api.PayPalAPI.ReverseTransactionReq;
import urn.ebay.api.PayPalAPI.ReverseTransactionResponseType;
import urn.ebay.api.PayPalAPI.SetAccessPermissionsReq;
import urn.ebay.api.PayPalAPI.SetAccessPermissionsResponseType;
import urn.ebay.api.PayPalAPI.SetAuthFlowParamReq;
import urn.ebay.api.PayPalAPI.SetAuthFlowParamResponseType;
import urn.ebay.api.PayPalAPI.SetCustomerBillingAgreementReq;
import urn.ebay.api.PayPalAPI.SetCustomerBillingAgreementResponseType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.api.PayPalAPI.SetMobileCheckoutReq;
import urn.ebay.api.PayPalAPI.SetMobileCheckoutResponseType;
import urn.ebay.api.PayPalAPI.TransactionSearchReq;
import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;
import urn.ebay.api.PayPalAPI.UpdateAccessPermissionsReq;
import urn.ebay.api.PayPalAPI.UpdateAccessPermissionsResponseType;
import urn.ebay.api.PayPalAPI.UpdateRecurringPaymentsProfileReq;
import urn.ebay.api.PayPalAPI.UpdateRecurringPaymentsProfileResponseType;
import urn.ebay.apis.eBLBaseComponents.AbstractRequestType;


public class PayPalAPIInterfaceServiceService extends BaseService {

	private static final String SERVICE_VERSION = "87.0";
	private static final String SERVICE_NAME = "PayPalAPIInterfaceService";

	public PayPalAPIInterfaceServiceService(File configFile) throws IOException, FileNotFoundException {
		super(SERVICE_NAME, SERVICE_VERSION);
		initConfig(configFile);
	}
	public PayPalAPIInterfaceServiceService(InputStream config) throws IOException, FileNotFoundException {
		super(SERVICE_NAME, SERVICE_VERSION);
		initConfig(config);
	}
	public PayPalAPIInterfaceServiceService(String configFilePath) throws IOException, FileNotFoundException {
		super(SERVICE_NAME, SERVICE_VERSION);
		initConfig(configFilePath);
		
	}

	private void setStandardParams(AbstractRequestType request) {
		if (request.getVersion() == null) {
			request.setVersion(SERVICE_VERSION);
		}
	}
	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public RefundTransactionResponseType refundTransaction (RefundTransactionReq RefundTransactionReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(RefundTransactionReq.getRefundTransactionRequest());
		String response = call("RefundTransaction", RefundTransactionReq.toXMLString(), apiUsername);
		return new RefundTransactionResponseType(response);
	}

	public RefundTransactionResponseType refundTransaction (RefundTransactionReq RefundTransactionReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return refundTransaction(RefundTransactionReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public InitiateRecoupResponseType initiateRecoup (InitiateRecoupReq InitiateRecoupReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(InitiateRecoupReq.getInitiateRecoupRequest());
		String response = call("InitiateRecoup", InitiateRecoupReq.toXMLString(), apiUsername);
		return new InitiateRecoupResponseType(response);
	}

	public InitiateRecoupResponseType initiateRecoup (InitiateRecoupReq InitiateRecoupReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return initiateRecoup(InitiateRecoupReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public CompleteRecoupResponseType completeRecoup (CompleteRecoupReq CompleteRecoupReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(CompleteRecoupReq.getCompleteRecoupRequest());
		String response = call("CompleteRecoup", CompleteRecoupReq.toXMLString(), apiUsername);
		return new CompleteRecoupResponseType(response);
	}

	public CompleteRecoupResponseType completeRecoup (CompleteRecoupReq CompleteRecoupReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return completeRecoup(CompleteRecoupReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public CancelRecoupResponseType cancelRecoup (CancelRecoupReq CancelRecoupReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(CancelRecoupReq.getCancelRecoupRequest());
		String response = call("CancelRecoup", CancelRecoupReq.toXMLString(), apiUsername);
		return new CancelRecoupResponseType(response);
	}

	public CancelRecoupResponseType cancelRecoup (CancelRecoupReq CancelRecoupReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return cancelRecoup(CancelRecoupReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetTransactionDetailsResponseType getTransactionDetails (GetTransactionDetailsReq GetTransactionDetailsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetTransactionDetailsReq.getGetTransactionDetailsRequest());
		String response = call("GetTransactionDetails", GetTransactionDetailsReq.toXMLString(), apiUsername);
		return new GetTransactionDetailsResponseType(response);
	}

	public GetTransactionDetailsResponseType getTransactionDetails (GetTransactionDetailsReq GetTransactionDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getTransactionDetails(GetTransactionDetailsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public BillUserResponseType billUser (BillUserReq BillUserReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(BillUserReq.getBillUserRequest());
		String response = call("BillUser", BillUserReq.toXMLString(), apiUsername);
		return new BillUserResponseType(response);
	}

	public BillUserResponseType billUser (BillUserReq BillUserReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return billUser(BillUserReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public TransactionSearchResponseType transactionSearch (TransactionSearchReq TransactionSearchReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(TransactionSearchReq.getTransactionSearchRequest());
		String response = call("TransactionSearch", TransactionSearchReq.toXMLString(), apiUsername);
		return new TransactionSearchResponseType(response);
	}

	public TransactionSearchResponseType transactionSearch (TransactionSearchReq TransactionSearchReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return transactionSearch(TransactionSearchReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public MassPayResponseType massPay (MassPayReq MassPayReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(MassPayReq.getMassPayRequest());
		String response = call("MassPay", MassPayReq.toXMLString(), apiUsername);
		return new MassPayResponseType(response);
	}

	public MassPayResponseType massPay (MassPayReq MassPayReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return massPay(MassPayReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public BAUpdateResponseType billAgreementUpdate (BillAgreementUpdateReq BillAgreementUpdateReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(BillAgreementUpdateReq.getBAUpdateRequest());
		String response = call("BillAgreementUpdate", BillAgreementUpdateReq.toXMLString(), apiUsername);
		return new BAUpdateResponseType(response);
	}

	public BAUpdateResponseType billAgreementUpdate (BillAgreementUpdateReq BillAgreementUpdateReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return billAgreementUpdate(BillAgreementUpdateReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public AddressVerifyResponseType addressVerify (AddressVerifyReq AddressVerifyReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(AddressVerifyReq.getAddressVerifyRequest());
		String response = call("AddressVerify", AddressVerifyReq.toXMLString(), apiUsername);
		return new AddressVerifyResponseType(response);
	}

	public AddressVerifyResponseType addressVerify (AddressVerifyReq AddressVerifyReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return addressVerify(AddressVerifyReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public EnterBoardingResponseType enterBoarding (EnterBoardingReq EnterBoardingReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(EnterBoardingReq.getEnterBoardingRequest());
		String response = call("EnterBoarding", EnterBoardingReq.toXMLString(), apiUsername);
		return new EnterBoardingResponseType(response);
	}

	public EnterBoardingResponseType enterBoarding (EnterBoardingReq EnterBoardingReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return enterBoarding(EnterBoardingReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetBoardingDetailsResponseType getBoardingDetails (GetBoardingDetailsReq GetBoardingDetailsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetBoardingDetailsReq.getGetBoardingDetailsRequest());
		String response = call("GetBoardingDetails", GetBoardingDetailsReq.toXMLString(), apiUsername);
		return new GetBoardingDetailsResponseType(response);
	}

	public GetBoardingDetailsResponseType getBoardingDetails (GetBoardingDetailsReq GetBoardingDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getBoardingDetails(GetBoardingDetailsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public CreateMobilePaymentResponseType createMobilePayment (CreateMobilePaymentReq CreateMobilePaymentReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(CreateMobilePaymentReq.getCreateMobilePaymentRequest());
		String response = call("CreateMobilePayment", CreateMobilePaymentReq.toXMLString(), apiUsername);
		return new CreateMobilePaymentResponseType(response);
	}

	public CreateMobilePaymentResponseType createMobilePayment (CreateMobilePaymentReq CreateMobilePaymentReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return createMobilePayment(CreateMobilePaymentReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetMobileStatusResponseType getMobileStatus (GetMobileStatusReq GetMobileStatusReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetMobileStatusReq.getGetMobileStatusRequest());
		String response = call("GetMobileStatus", GetMobileStatusReq.toXMLString(), apiUsername);
		return new GetMobileStatusResponseType(response);
	}

	public GetMobileStatusResponseType getMobileStatus (GetMobileStatusReq GetMobileStatusReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getMobileStatus(GetMobileStatusReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public SetMobileCheckoutResponseType setMobileCheckout (SetMobileCheckoutReq SetMobileCheckoutReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(SetMobileCheckoutReq.getSetMobileCheckoutRequest());
		String response = call("SetMobileCheckout", SetMobileCheckoutReq.toXMLString(), apiUsername);
		return new SetMobileCheckoutResponseType(response);
	}

	public SetMobileCheckoutResponseType setMobileCheckout (SetMobileCheckoutReq SetMobileCheckoutReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return setMobileCheckout(SetMobileCheckoutReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoMobileCheckoutPaymentResponseType doMobileCheckoutPayment (DoMobileCheckoutPaymentReq DoMobileCheckoutPaymentReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoMobileCheckoutPaymentReq.getDoMobileCheckoutPaymentRequest());
		String response = call("DoMobileCheckoutPayment", DoMobileCheckoutPaymentReq.toXMLString(), apiUsername);
		return new DoMobileCheckoutPaymentResponseType(response);
	}

	public DoMobileCheckoutPaymentResponseType doMobileCheckoutPayment (DoMobileCheckoutPaymentReq DoMobileCheckoutPaymentReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doMobileCheckoutPayment(DoMobileCheckoutPaymentReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetBalanceResponseType getBalance (GetBalanceReq GetBalanceReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetBalanceReq.getGetBalanceRequest());
		String response = call("GetBalance", GetBalanceReq.toXMLString(), apiUsername);
		return new GetBalanceResponseType(response);
	}

	public GetBalanceResponseType getBalance (GetBalanceReq GetBalanceReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getBalance(GetBalanceReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetPalDetailsResponseType getPalDetails (GetPalDetailsReq GetPalDetailsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetPalDetailsReq.getGetPalDetailsRequest());
		String response = call("GetPalDetails", GetPalDetailsReq.toXMLString(), apiUsername);
		return new GetPalDetailsResponseType(response);
	}

	public GetPalDetailsResponseType getPalDetails (GetPalDetailsReq GetPalDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getPalDetails(GetPalDetailsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoExpressCheckoutPaymentResponseType doExpressCheckoutPayment (DoExpressCheckoutPaymentReq DoExpressCheckoutPaymentReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoExpressCheckoutPaymentReq.getDoExpressCheckoutPaymentRequest());
		String response = call("DoExpressCheckoutPayment", DoExpressCheckoutPaymentReq.toXMLString(), apiUsername);
		return new DoExpressCheckoutPaymentResponseType(response);
	}

	public DoExpressCheckoutPaymentResponseType doExpressCheckoutPayment (DoExpressCheckoutPaymentReq DoExpressCheckoutPaymentReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doExpressCheckoutPayment(DoExpressCheckoutPaymentReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoUATPExpressCheckoutPaymentResponseType doUATPExpressCheckoutPayment (DoUATPExpressCheckoutPaymentReq DoUATPExpressCheckoutPaymentReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoUATPExpressCheckoutPaymentReq.getDoUATPExpressCheckoutPaymentRequest());
		String response = call("DoUATPExpressCheckoutPayment", DoUATPExpressCheckoutPaymentReq.toXMLString(), apiUsername);
		return new DoUATPExpressCheckoutPaymentResponseType(response);
	}

	public DoUATPExpressCheckoutPaymentResponseType doUATPExpressCheckoutPayment (DoUATPExpressCheckoutPaymentReq DoUATPExpressCheckoutPaymentReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doUATPExpressCheckoutPayment(DoUATPExpressCheckoutPaymentReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public SetAuthFlowParamResponseType setAuthFlowParam (SetAuthFlowParamReq SetAuthFlowParamReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(SetAuthFlowParamReq.getSetAuthFlowParamRequest());
		String response = call("SetAuthFlowParam", SetAuthFlowParamReq.toXMLString(), apiUsername);
		return new SetAuthFlowParamResponseType(response);
	}

	public SetAuthFlowParamResponseType setAuthFlowParam (SetAuthFlowParamReq SetAuthFlowParamReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return setAuthFlowParam(SetAuthFlowParamReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetAuthDetailsResponseType getAuthDetails (GetAuthDetailsReq GetAuthDetailsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetAuthDetailsReq.getGetAuthDetailsRequest());
		String response = call("GetAuthDetails", GetAuthDetailsReq.toXMLString(), apiUsername);
		return new GetAuthDetailsResponseType(response);
	}

	public GetAuthDetailsResponseType getAuthDetails (GetAuthDetailsReq GetAuthDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getAuthDetails(GetAuthDetailsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public SetAccessPermissionsResponseType setAccessPermissions (SetAccessPermissionsReq SetAccessPermissionsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(SetAccessPermissionsReq.getSetAccessPermissionsRequest());
		String response = call("SetAccessPermissions", SetAccessPermissionsReq.toXMLString(), apiUsername);
		return new SetAccessPermissionsResponseType(response);
	}

	public SetAccessPermissionsResponseType setAccessPermissions (SetAccessPermissionsReq SetAccessPermissionsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return setAccessPermissions(SetAccessPermissionsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public UpdateAccessPermissionsResponseType updateAccessPermissions (UpdateAccessPermissionsReq UpdateAccessPermissionsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(UpdateAccessPermissionsReq.getUpdateAccessPermissionsRequest());
		String response = call("UpdateAccessPermissions", UpdateAccessPermissionsReq.toXMLString(), apiUsername);
		return new UpdateAccessPermissionsResponseType(response);
	}

	public UpdateAccessPermissionsResponseType updateAccessPermissions (UpdateAccessPermissionsReq UpdateAccessPermissionsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return updateAccessPermissions(UpdateAccessPermissionsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetAccessPermissionDetailsResponseType getAccessPermissionDetails (GetAccessPermissionDetailsReq GetAccessPermissionDetailsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetAccessPermissionDetailsReq.getGetAccessPermissionDetailsRequest());
		String response = call("GetAccessPermissionDetails", GetAccessPermissionDetailsReq.toXMLString(), apiUsername);
		return new GetAccessPermissionDetailsResponseType(response);
	}

	public GetAccessPermissionDetailsResponseType getAccessPermissionDetails (GetAccessPermissionDetailsReq GetAccessPermissionDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getAccessPermissionDetails(GetAccessPermissionDetailsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetIncentiveEvaluationResponseType getIncentiveEvaluation (GetIncentiveEvaluationReq GetIncentiveEvaluationReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetIncentiveEvaluationReq.getGetIncentiveEvaluationRequest());
		String response = call("GetIncentiveEvaluation", GetIncentiveEvaluationReq.toXMLString(), apiUsername);
		return new GetIncentiveEvaluationResponseType(response);
	}

	public GetIncentiveEvaluationResponseType getIncentiveEvaluation (GetIncentiveEvaluationReq GetIncentiveEvaluationReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getIncentiveEvaluation(GetIncentiveEvaluationReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public SetExpressCheckoutResponseType setExpressCheckout (SetExpressCheckoutReq SetExpressCheckoutReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(SetExpressCheckoutReq.getSetExpressCheckoutRequest());
		String response = call("SetExpressCheckout", SetExpressCheckoutReq.toXMLString(), apiUsername);
		return new SetExpressCheckoutResponseType(response);
	}

	public SetExpressCheckoutResponseType setExpressCheckout (SetExpressCheckoutReq SetExpressCheckoutReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return setExpressCheckout(SetExpressCheckoutReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public ExecuteCheckoutOperationsResponseType executeCheckoutOperations (ExecuteCheckoutOperationsReq ExecuteCheckoutOperationsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(ExecuteCheckoutOperationsReq.getExecuteCheckoutOperationsRequest());
		String response = call("ExecuteCheckoutOperations", ExecuteCheckoutOperationsReq.toXMLString(), apiUsername);
		return new ExecuteCheckoutOperationsResponseType(response);
	}

	public ExecuteCheckoutOperationsResponseType executeCheckoutOperations (ExecuteCheckoutOperationsReq ExecuteCheckoutOperationsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return executeCheckoutOperations(ExecuteCheckoutOperationsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetExpressCheckoutDetailsResponseType getExpressCheckoutDetails (GetExpressCheckoutDetailsReq GetExpressCheckoutDetailsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetExpressCheckoutDetailsReq.getGetExpressCheckoutDetailsRequest());
		String response = call("GetExpressCheckoutDetails", GetExpressCheckoutDetailsReq.toXMLString(), apiUsername);
		return new GetExpressCheckoutDetailsResponseType(response);
	}

	public GetExpressCheckoutDetailsResponseType getExpressCheckoutDetails (GetExpressCheckoutDetailsReq GetExpressCheckoutDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getExpressCheckoutDetails(GetExpressCheckoutDetailsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoDirectPaymentResponseType doDirectPayment (DoDirectPaymentReq DoDirectPaymentReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoDirectPaymentReq.getDoDirectPaymentRequest());
		String response = call("DoDirectPayment", DoDirectPaymentReq.toXMLString(), apiUsername);
		return new DoDirectPaymentResponseType(response);
	}

	public DoDirectPaymentResponseType doDirectPayment (DoDirectPaymentReq DoDirectPaymentReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doDirectPayment(DoDirectPaymentReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public ManagePendingTransactionStatusResponseType managePendingTransactionStatus (ManagePendingTransactionStatusReq ManagePendingTransactionStatusReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(ManagePendingTransactionStatusReq.getManagePendingTransactionStatusRequest());
		String response = call("ManagePendingTransactionStatus", ManagePendingTransactionStatusReq.toXMLString(), apiUsername);
		return new ManagePendingTransactionStatusResponseType(response);
	}

	public ManagePendingTransactionStatusResponseType managePendingTransactionStatus (ManagePendingTransactionStatusReq ManagePendingTransactionStatusReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return managePendingTransactionStatus(ManagePendingTransactionStatusReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoCancelResponseType doCancel (DoCancelReq DoCancelReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoCancelReq.getDoCancelRequest());
		String response = call("DoCancel", DoCancelReq.toXMLString(), apiUsername);
		return new DoCancelResponseType(response);
	}

	public DoCancelResponseType doCancel (DoCancelReq DoCancelReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doCancel(DoCancelReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoCaptureResponseType doCapture (DoCaptureReq DoCaptureReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoCaptureReq.getDoCaptureRequest());
		String response = call("DoCapture", DoCaptureReq.toXMLString(), apiUsername);
		return new DoCaptureResponseType(response);
	}

	public DoCaptureResponseType doCapture (DoCaptureReq DoCaptureReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doCapture(DoCaptureReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoReauthorizationResponseType doReauthorization (DoReauthorizationReq DoReauthorizationReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoReauthorizationReq.getDoReauthorizationRequest());
		String response = call("DoReauthorization", DoReauthorizationReq.toXMLString(), apiUsername);
		return new DoReauthorizationResponseType(response);
	}

	public DoReauthorizationResponseType doReauthorization (DoReauthorizationReq DoReauthorizationReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doReauthorization(DoReauthorizationReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoVoidResponseType doVoid (DoVoidReq DoVoidReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoVoidReq.getDoVoidRequest());
		String response = call("DoVoid", DoVoidReq.toXMLString(), apiUsername);
		return new DoVoidResponseType(response);
	}

	public DoVoidResponseType doVoid (DoVoidReq DoVoidReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doVoid(DoVoidReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoAuthorizationResponseType doAuthorization (DoAuthorizationReq DoAuthorizationReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoAuthorizationReq.getDoAuthorizationRequest());
		String response = call("DoAuthorization", DoAuthorizationReq.toXMLString(), apiUsername);
		return new DoAuthorizationResponseType(response);
	}

	public DoAuthorizationResponseType doAuthorization (DoAuthorizationReq DoAuthorizationReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doAuthorization(DoAuthorizationReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public SetCustomerBillingAgreementResponseType setCustomerBillingAgreement (SetCustomerBillingAgreementReq SetCustomerBillingAgreementReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(SetCustomerBillingAgreementReq.getSetCustomerBillingAgreementRequest());
		String response = call("SetCustomerBillingAgreement", SetCustomerBillingAgreementReq.toXMLString(), apiUsername);
		return new SetCustomerBillingAgreementResponseType(response);
	}

	public SetCustomerBillingAgreementResponseType setCustomerBillingAgreement (SetCustomerBillingAgreementReq SetCustomerBillingAgreementReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return setCustomerBillingAgreement(SetCustomerBillingAgreementReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetBillingAgreementCustomerDetailsResponseType getBillingAgreementCustomerDetails (GetBillingAgreementCustomerDetailsReq GetBillingAgreementCustomerDetailsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetBillingAgreementCustomerDetailsReq.getGetBillingAgreementCustomerDetailsRequest());
		String response = call("GetBillingAgreementCustomerDetails", GetBillingAgreementCustomerDetailsReq.toXMLString(), apiUsername);
		return new GetBillingAgreementCustomerDetailsResponseType(response);
	}

	public GetBillingAgreementCustomerDetailsResponseType getBillingAgreementCustomerDetails (GetBillingAgreementCustomerDetailsReq GetBillingAgreementCustomerDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getBillingAgreementCustomerDetails(GetBillingAgreementCustomerDetailsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public CreateBillingAgreementResponseType createBillingAgreement (CreateBillingAgreementReq CreateBillingAgreementReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(CreateBillingAgreementReq.getCreateBillingAgreementRequest());
		String response = call("CreateBillingAgreement", CreateBillingAgreementReq.toXMLString(), apiUsername);
		return new CreateBillingAgreementResponseType(response);
	}

	public CreateBillingAgreementResponseType createBillingAgreement (CreateBillingAgreementReq CreateBillingAgreementReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return createBillingAgreement(CreateBillingAgreementReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoReferenceTransactionResponseType doReferenceTransaction (DoReferenceTransactionReq DoReferenceTransactionReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoReferenceTransactionReq.getDoReferenceTransactionRequest());
		String response = call("DoReferenceTransaction", DoReferenceTransactionReq.toXMLString(), apiUsername);
		return new DoReferenceTransactionResponseType(response);
	}

	public DoReferenceTransactionResponseType doReferenceTransaction (DoReferenceTransactionReq DoReferenceTransactionReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doReferenceTransaction(DoReferenceTransactionReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoNonReferencedCreditResponseType doNonReferencedCredit (DoNonReferencedCreditReq DoNonReferencedCreditReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoNonReferencedCreditReq.getDoNonReferencedCreditRequest());
		String response = call("DoNonReferencedCredit", DoNonReferencedCreditReq.toXMLString(), apiUsername);
		return new DoNonReferencedCreditResponseType(response);
	}

	public DoNonReferencedCreditResponseType doNonReferencedCredit (DoNonReferencedCreditReq DoNonReferencedCreditReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doNonReferencedCredit(DoNonReferencedCreditReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DoUATPAuthorizationResponseType doUATPAuthorization (DoUATPAuthorizationReq DoUATPAuthorizationReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(DoUATPAuthorizationReq.getDoUATPAuthorizationRequest());
		String response = call("DoUATPAuthorization", DoUATPAuthorizationReq.toXMLString(), apiUsername);
		return new DoUATPAuthorizationResponseType(response);
	}

	public DoUATPAuthorizationResponseType doUATPAuthorization (DoUATPAuthorizationReq DoUATPAuthorizationReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return doUATPAuthorization(DoUATPAuthorizationReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public CreateRecurringPaymentsProfileResponseType createRecurringPaymentsProfile (CreateRecurringPaymentsProfileReq CreateRecurringPaymentsProfileReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(CreateRecurringPaymentsProfileReq.getCreateRecurringPaymentsProfileRequest());
		String response = call("CreateRecurringPaymentsProfile", CreateRecurringPaymentsProfileReq.toXMLString(), apiUsername);
		return new CreateRecurringPaymentsProfileResponseType(response);
	}

	public CreateRecurringPaymentsProfileResponseType createRecurringPaymentsProfile (CreateRecurringPaymentsProfileReq CreateRecurringPaymentsProfileReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return createRecurringPaymentsProfile(CreateRecurringPaymentsProfileReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public GetRecurringPaymentsProfileDetailsResponseType getRecurringPaymentsProfileDetails (GetRecurringPaymentsProfileDetailsReq GetRecurringPaymentsProfileDetailsReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(GetRecurringPaymentsProfileDetailsReq.getGetRecurringPaymentsProfileDetailsRequest());
		String response = call("GetRecurringPaymentsProfileDetails", GetRecurringPaymentsProfileDetailsReq.toXMLString(), apiUsername);
		return new GetRecurringPaymentsProfileDetailsResponseType(response);
	}

	public GetRecurringPaymentsProfileDetailsResponseType getRecurringPaymentsProfileDetails (GetRecurringPaymentsProfileDetailsReq GetRecurringPaymentsProfileDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return getRecurringPaymentsProfileDetails(GetRecurringPaymentsProfileDetailsReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public ManageRecurringPaymentsProfileStatusResponseType manageRecurringPaymentsProfileStatus (ManageRecurringPaymentsProfileStatusReq ManageRecurringPaymentsProfileStatusReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(ManageRecurringPaymentsProfileStatusReq.getManageRecurringPaymentsProfileStatusRequest());
		String response = call("ManageRecurringPaymentsProfileStatus", ManageRecurringPaymentsProfileStatusReq.toXMLString(), apiUsername);
		return new ManageRecurringPaymentsProfileStatusResponseType(response);
	}

	public ManageRecurringPaymentsProfileStatusResponseType manageRecurringPaymentsProfileStatus (ManageRecurringPaymentsProfileStatusReq ManageRecurringPaymentsProfileStatusReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return manageRecurringPaymentsProfileStatus(ManageRecurringPaymentsProfileStatusReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public BillOutstandingAmountResponseType billOutstandingAmount (BillOutstandingAmountReq BillOutstandingAmountReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(BillOutstandingAmountReq.getBillOutstandingAmountRequest());
		String response = call("BillOutstandingAmount", BillOutstandingAmountReq.toXMLString(), apiUsername);
		return new BillOutstandingAmountResponseType(response);
	}

	public BillOutstandingAmountResponseType billOutstandingAmount (BillOutstandingAmountReq BillOutstandingAmountReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return billOutstandingAmount(BillOutstandingAmountReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public UpdateRecurringPaymentsProfileResponseType updateRecurringPaymentsProfile (UpdateRecurringPaymentsProfileReq UpdateRecurringPaymentsProfileReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(UpdateRecurringPaymentsProfileReq.getUpdateRecurringPaymentsProfileRequest());
		String response = call("UpdateRecurringPaymentsProfile", UpdateRecurringPaymentsProfileReq.toXMLString(), apiUsername);
		return new UpdateRecurringPaymentsProfileResponseType(response);
	}

	public UpdateRecurringPaymentsProfileResponseType updateRecurringPaymentsProfile (UpdateRecurringPaymentsProfileReq UpdateRecurringPaymentsProfileReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return updateRecurringPaymentsProfile(UpdateRecurringPaymentsProfileReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public ReverseTransactionResponseType reverseTransaction (ReverseTransactionReq ReverseTransactionReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(ReverseTransactionReq.getReverseTransactionRequest());
		String response = call("ReverseTransaction", ReverseTransactionReq.toXMLString(), apiUsername);
		return new ReverseTransactionResponseType(response);
	}

	public ReverseTransactionResponseType reverseTransaction (ReverseTransactionReq ReverseTransactionReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return reverseTransaction(ReverseTransactionReq, null);
	}

	/**
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public ExternalRememberMeOptOutResponseType externalRememberMeOptOut (ExternalRememberMeOptOutReq ExternalRememberMeOptOutReq,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		setStandardParams(ExternalRememberMeOptOutReq.getExternalRememberMeOptOutRequest());
		String response = call("ExternalRememberMeOptOut", ExternalRememberMeOptOutReq.toXMLString(), apiUsername);
		return new ExternalRememberMeOptOutResponseType(response);
	}

	public ExternalRememberMeOptOutResponseType externalRememberMeOptOut (ExternalRememberMeOptOutReq ExternalRememberMeOptOutReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException {
		return externalRememberMeOptOut(ExternalRememberMeOptOutReq, null);
	}

}

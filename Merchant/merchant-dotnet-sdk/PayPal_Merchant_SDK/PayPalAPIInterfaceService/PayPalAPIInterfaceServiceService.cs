/** 
 * Auto generated code
 */

using PayPal.Authentication;

namespace PayPal.PayPalAPIInterfaceService {

	using PayPal;
	using PayPal.Util;
	using PayPal.Manager;
	using PayPal.PayPalAPIInterfaceService.Model;

	public partial class PayPalAPIInterfaceServiceService :BasePayPalService{

		private static string serviceName = "PayPalAPIInterfaceService";


		private static string serviceVersion"87.0";


		 public PayPalAPIInterfaceServiceService() : base(serviceName)
		        {}
	/// <summary>
 /// Sets standard parameters common to all requests
 /// </summary>
   private void setStandardParams(AbstractRequestType request)
  {
       if (request.Version == null)
    {
      request.Version = serviceVersion;
     }
    if(request.ErrorLanguage != null && ConfigManager.Instance.GetProperty("languageCode") != null)
    {
    request.ErrorLanguage = ConfigManager.Instance.GetProperty("languageCode");
   }            
   }
		/**
		 *
		 */
		public RefundTransactionResponseType RefundTransaction(RefundTransactionReq RefundTransactionReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(RefundTransactionReq.getRefundTransactionRequest);
			string resp = service.call("RefundTransaction", RefundTransactionReq.toXMLString(), apiUsername);

			return new RefundTransactionResponseType(resp);
		}

		public RefundTransactionResponseType RefundTransaction(RefundTransactionReq RefundTransactionReq) 
		{
			return RefundTransaction(RefundTransactionReq, null);
		}
		/**
		 *
		 */
		public InitiateRecoupResponseType InitiateRecoup(InitiateRecoupReq InitiateRecoupReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(InitiateRecoupReq.getInitiateRecoupRequest);
			string resp = service.call("InitiateRecoup", InitiateRecoupReq.toXMLString(), apiUsername);

			return new InitiateRecoupResponseType(resp);
		}

		public InitiateRecoupResponseType InitiateRecoup(InitiateRecoupReq InitiateRecoupReq) 
		{
			return InitiateRecoup(InitiateRecoupReq, null);
		}
		/**
		 *
		 */
		public CompleteRecoupResponseType CompleteRecoup(CompleteRecoupReq CompleteRecoupReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(CompleteRecoupReq.getCompleteRecoupRequest);
			string resp = service.call("CompleteRecoup", CompleteRecoupReq.toXMLString(), apiUsername);

			return new CompleteRecoupResponseType(resp);
		}

		public CompleteRecoupResponseType CompleteRecoup(CompleteRecoupReq CompleteRecoupReq) 
		{
			return CompleteRecoup(CompleteRecoupReq, null);
		}
		/**
		 *
		 */
		public CancelRecoupResponseType CancelRecoup(CancelRecoupReq CancelRecoupReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(CancelRecoupReq.getCancelRecoupRequest);
			string resp = service.call("CancelRecoup", CancelRecoupReq.toXMLString(), apiUsername);

			return new CancelRecoupResponseType(resp);
		}

		public CancelRecoupResponseType CancelRecoup(CancelRecoupReq CancelRecoupReq) 
		{
			return CancelRecoup(CancelRecoupReq, null);
		}
		/**
		 *
		 */
		public GetTransactionDetailsResponseType GetTransactionDetails(GetTransactionDetailsReq GetTransactionDetailsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetTransactionDetailsReq.getGetTransactionDetailsRequest);
			string resp = service.call("GetTransactionDetails", GetTransactionDetailsReq.toXMLString(), apiUsername);

			return new GetTransactionDetailsResponseType(resp);
		}

		public GetTransactionDetailsResponseType GetTransactionDetails(GetTransactionDetailsReq GetTransactionDetailsReq) 
		{
			return GetTransactionDetails(GetTransactionDetailsReq, null);
		}
		/**
		 *
		 */
		public BillUserResponseType BillUser(BillUserReq BillUserReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(BillUserReq.getBillUserRequest);
			string resp = service.call("BillUser", BillUserReq.toXMLString(), apiUsername);

			return new BillUserResponseType(resp);
		}

		public BillUserResponseType BillUser(BillUserReq BillUserReq) 
		{
			return BillUser(BillUserReq, null);
		}
		/**
		 *
		 */
		public TransactionSearchResponseType TransactionSearch(TransactionSearchReq TransactionSearchReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(TransactionSearchReq.getTransactionSearchRequest);
			string resp = service.call("TransactionSearch", TransactionSearchReq.toXMLString(), apiUsername);

			return new TransactionSearchResponseType(resp);
		}

		public TransactionSearchResponseType TransactionSearch(TransactionSearchReq TransactionSearchReq) 
		{
			return TransactionSearch(TransactionSearchReq, null);
		}
		/**
		 *
		 */
		public MassPayResponseType MassPay(MassPayReq MassPayReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(MassPayReq.getMassPayRequest);
			string resp = service.call("MassPay", MassPayReq.toXMLString(), apiUsername);

			return new MassPayResponseType(resp);
		}

		public MassPayResponseType MassPay(MassPayReq MassPayReq) 
		{
			return MassPay(MassPayReq, null);
		}
		/**
		 *
		 */
		public BAUpdateResponseType BillAgreementUpdate(BillAgreementUpdateReq BillAgreementUpdateReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(BillAgreementUpdateReq.getBAUpdateRequest);
			string resp = service.call("BillAgreementUpdate", BillAgreementUpdateReq.toXMLString(), apiUsername);

			return new BAUpdateResponseType(resp);
		}

		public BAUpdateResponseType BillAgreementUpdate(BillAgreementUpdateReq BillAgreementUpdateReq) 
		{
			return BillAgreementUpdate(BillAgreementUpdateReq, null);
		}
		/**
		 *
		 */
		public AddressVerifyResponseType AddressVerify(AddressVerifyReq AddressVerifyReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(AddressVerifyReq.getAddressVerifyRequest);
			string resp = service.call("AddressVerify", AddressVerifyReq.toXMLString(), apiUsername);

			return new AddressVerifyResponseType(resp);
		}

		public AddressVerifyResponseType AddressVerify(AddressVerifyReq AddressVerifyReq) 
		{
			return AddressVerify(AddressVerifyReq, null);
		}
		/**
		 *
		 */
		public EnterBoardingResponseType EnterBoarding(EnterBoardingReq EnterBoardingReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(EnterBoardingReq.getEnterBoardingRequest);
			string resp = service.call("EnterBoarding", EnterBoardingReq.toXMLString(), apiUsername);

			return new EnterBoardingResponseType(resp);
		}

		public EnterBoardingResponseType EnterBoarding(EnterBoardingReq EnterBoardingReq) 
		{
			return EnterBoarding(EnterBoardingReq, null);
		}
		/**
		 *
		 */
		public GetBoardingDetailsResponseType GetBoardingDetails(GetBoardingDetailsReq GetBoardingDetailsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetBoardingDetailsReq.getGetBoardingDetailsRequest);
			string resp = service.call("GetBoardingDetails", GetBoardingDetailsReq.toXMLString(), apiUsername);

			return new GetBoardingDetailsResponseType(resp);
		}

		public GetBoardingDetailsResponseType GetBoardingDetails(GetBoardingDetailsReq GetBoardingDetailsReq) 
		{
			return GetBoardingDetails(GetBoardingDetailsReq, null);
		}
		/**
		 *
		 */
		public CreateMobilePaymentResponseType CreateMobilePayment(CreateMobilePaymentReq CreateMobilePaymentReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(CreateMobilePaymentReq.getCreateMobilePaymentRequest);
			string resp = service.call("CreateMobilePayment", CreateMobilePaymentReq.toXMLString(), apiUsername);

			return new CreateMobilePaymentResponseType(resp);
		}

		public CreateMobilePaymentResponseType CreateMobilePayment(CreateMobilePaymentReq CreateMobilePaymentReq) 
		{
			return CreateMobilePayment(CreateMobilePaymentReq, null);
		}
		/**
		 *
		 */
		public GetMobileStatusResponseType GetMobileStatus(GetMobileStatusReq GetMobileStatusReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetMobileStatusReq.getGetMobileStatusRequest);
			string resp = service.call("GetMobileStatus", GetMobileStatusReq.toXMLString(), apiUsername);

			return new GetMobileStatusResponseType(resp);
		}

		public GetMobileStatusResponseType GetMobileStatus(GetMobileStatusReq GetMobileStatusReq) 
		{
			return GetMobileStatus(GetMobileStatusReq, null);
		}
		/**
		 *
		 */
		public SetMobileCheckoutResponseType SetMobileCheckout(SetMobileCheckoutReq SetMobileCheckoutReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(SetMobileCheckoutReq.getSetMobileCheckoutRequest);
			string resp = service.call("SetMobileCheckout", SetMobileCheckoutReq.toXMLString(), apiUsername);

			return new SetMobileCheckoutResponseType(resp);
		}

		public SetMobileCheckoutResponseType SetMobileCheckout(SetMobileCheckoutReq SetMobileCheckoutReq) 
		{
			return SetMobileCheckout(SetMobileCheckoutReq, null);
		}
		/**
		 *
		 */
		public DoMobileCheckoutPaymentResponseType DoMobileCheckoutPayment(DoMobileCheckoutPaymentReq DoMobileCheckoutPaymentReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoMobileCheckoutPaymentReq.getDoMobileCheckoutPaymentRequest);
			string resp = service.call("DoMobileCheckoutPayment", DoMobileCheckoutPaymentReq.toXMLString(), apiUsername);

			return new DoMobileCheckoutPaymentResponseType(resp);
		}

		public DoMobileCheckoutPaymentResponseType DoMobileCheckoutPayment(DoMobileCheckoutPaymentReq DoMobileCheckoutPaymentReq) 
		{
			return DoMobileCheckoutPayment(DoMobileCheckoutPaymentReq, null);
		}
		/**
		 *
		 */
		public GetBalanceResponseType GetBalance(GetBalanceReq GetBalanceReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetBalanceReq.getGetBalanceRequest);
			string resp = service.call("GetBalance", GetBalanceReq.toXMLString(), apiUsername);

			return new GetBalanceResponseType(resp);
		}

		public GetBalanceResponseType GetBalance(GetBalanceReq GetBalanceReq) 
		{
			return GetBalance(GetBalanceReq, null);
		}
		/**
		 *
		 */
		public GetPalDetailsResponseType GetPalDetails(GetPalDetailsReq GetPalDetailsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetPalDetailsReq.getGetPalDetailsRequest);
			string resp = service.call("GetPalDetails", GetPalDetailsReq.toXMLString(), apiUsername);

			return new GetPalDetailsResponseType(resp);
		}

		public GetPalDetailsResponseType GetPalDetails(GetPalDetailsReq GetPalDetailsReq) 
		{
			return GetPalDetails(GetPalDetailsReq, null);
		}
		/**
		 *
		 */
		public DoExpressCheckoutPaymentResponseType DoExpressCheckoutPayment(DoExpressCheckoutPaymentReq DoExpressCheckoutPaymentReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoExpressCheckoutPaymentReq.getDoExpressCheckoutPaymentRequest);
			string resp = service.call("DoExpressCheckoutPayment", DoExpressCheckoutPaymentReq.toXMLString(), apiUsername);

			return new DoExpressCheckoutPaymentResponseType(resp);
		}

		public DoExpressCheckoutPaymentResponseType DoExpressCheckoutPayment(DoExpressCheckoutPaymentReq DoExpressCheckoutPaymentReq) 
		{
			return DoExpressCheckoutPayment(DoExpressCheckoutPaymentReq, null);
		}
		/**
		 *
		 */
		public DoUATPExpressCheckoutPaymentResponseType DoUATPExpressCheckoutPayment(DoUATPExpressCheckoutPaymentReq DoUATPExpressCheckoutPaymentReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoUATPExpressCheckoutPaymentReq.getDoUATPExpressCheckoutPaymentRequest);
			string resp = service.call("DoUATPExpressCheckoutPayment", DoUATPExpressCheckoutPaymentReq.toXMLString(), apiUsername);

			return new DoUATPExpressCheckoutPaymentResponseType(resp);
		}

		public DoUATPExpressCheckoutPaymentResponseType DoUATPExpressCheckoutPayment(DoUATPExpressCheckoutPaymentReq DoUATPExpressCheckoutPaymentReq) 
		{
			return DoUATPExpressCheckoutPayment(DoUATPExpressCheckoutPaymentReq, null);
		}
		/**
		 *
		 */
		public SetAuthFlowParamResponseType SetAuthFlowParam(SetAuthFlowParamReq SetAuthFlowParamReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(SetAuthFlowParamReq.getSetAuthFlowParamRequest);
			string resp = service.call("SetAuthFlowParam", SetAuthFlowParamReq.toXMLString(), apiUsername);

			return new SetAuthFlowParamResponseType(resp);
		}

		public SetAuthFlowParamResponseType SetAuthFlowParam(SetAuthFlowParamReq SetAuthFlowParamReq) 
		{
			return SetAuthFlowParam(SetAuthFlowParamReq, null);
		}
		/**
		 *
		 */
		public GetAuthDetailsResponseType GetAuthDetails(GetAuthDetailsReq GetAuthDetailsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetAuthDetailsReq.getGetAuthDetailsRequest);
			string resp = service.call("GetAuthDetails", GetAuthDetailsReq.toXMLString(), apiUsername);

			return new GetAuthDetailsResponseType(resp);
		}

		public GetAuthDetailsResponseType GetAuthDetails(GetAuthDetailsReq GetAuthDetailsReq) 
		{
			return GetAuthDetails(GetAuthDetailsReq, null);
		}
		/**
		 *
		 */
		public SetAccessPermissionsResponseType SetAccessPermissions(SetAccessPermissionsReq SetAccessPermissionsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(SetAccessPermissionsReq.getSetAccessPermissionsRequest);
			string resp = service.call("SetAccessPermissions", SetAccessPermissionsReq.toXMLString(), apiUsername);

			return new SetAccessPermissionsResponseType(resp);
		}

		public SetAccessPermissionsResponseType SetAccessPermissions(SetAccessPermissionsReq SetAccessPermissionsReq) 
		{
			return SetAccessPermissions(SetAccessPermissionsReq, null);
		}
		/**
		 *
		 */
		public UpdateAccessPermissionsResponseType UpdateAccessPermissions(UpdateAccessPermissionsReq UpdateAccessPermissionsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(UpdateAccessPermissionsReq.getUpdateAccessPermissionsRequest);
			string resp = service.call("UpdateAccessPermissions", UpdateAccessPermissionsReq.toXMLString(), apiUsername);

			return new UpdateAccessPermissionsResponseType(resp);
		}

		public UpdateAccessPermissionsResponseType UpdateAccessPermissions(UpdateAccessPermissionsReq UpdateAccessPermissionsReq) 
		{
			return UpdateAccessPermissions(UpdateAccessPermissionsReq, null);
		}
		/**
		 *
		 */
		public GetAccessPermissionDetailsResponseType GetAccessPermissionDetails(GetAccessPermissionDetailsReq GetAccessPermissionDetailsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetAccessPermissionDetailsReq.getGetAccessPermissionDetailsRequest);
			string resp = service.call("GetAccessPermissionDetails", GetAccessPermissionDetailsReq.toXMLString(), apiUsername);

			return new GetAccessPermissionDetailsResponseType(resp);
		}

		public GetAccessPermissionDetailsResponseType GetAccessPermissionDetails(GetAccessPermissionDetailsReq GetAccessPermissionDetailsReq) 
		{
			return GetAccessPermissionDetails(GetAccessPermissionDetailsReq, null);
		}
		/**
		 *
		 */
		public GetIncentiveEvaluationResponseType GetIncentiveEvaluation(GetIncentiveEvaluationReq GetIncentiveEvaluationReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetIncentiveEvaluationReq.getGetIncentiveEvaluationRequest);
			string resp = service.call("GetIncentiveEvaluation", GetIncentiveEvaluationReq.toXMLString(), apiUsername);

			return new GetIncentiveEvaluationResponseType(resp);
		}

		public GetIncentiveEvaluationResponseType GetIncentiveEvaluation(GetIncentiveEvaluationReq GetIncentiveEvaluationReq) 
		{
			return GetIncentiveEvaluation(GetIncentiveEvaluationReq, null);
		}
		/**
		 *
		 */
		public SetExpressCheckoutResponseType SetExpressCheckout(SetExpressCheckoutReq SetExpressCheckoutReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(SetExpressCheckoutReq.getSetExpressCheckoutRequest);
			string resp = service.call("SetExpressCheckout", SetExpressCheckoutReq.toXMLString(), apiUsername);

			return new SetExpressCheckoutResponseType(resp);
		}

		public SetExpressCheckoutResponseType SetExpressCheckout(SetExpressCheckoutReq SetExpressCheckoutReq) 
		{
			return SetExpressCheckout(SetExpressCheckoutReq, null);
		}
		/**
		 *
		 */
		public ExecuteCheckoutOperationsResponseType ExecuteCheckoutOperations(ExecuteCheckoutOperationsReq ExecuteCheckoutOperationsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(ExecuteCheckoutOperationsReq.getExecuteCheckoutOperationsRequest);
			string resp = service.call("ExecuteCheckoutOperations", ExecuteCheckoutOperationsReq.toXMLString(), apiUsername);

			return new ExecuteCheckoutOperationsResponseType(resp);
		}

		public ExecuteCheckoutOperationsResponseType ExecuteCheckoutOperations(ExecuteCheckoutOperationsReq ExecuteCheckoutOperationsReq) 
		{
			return ExecuteCheckoutOperations(ExecuteCheckoutOperationsReq, null);
		}
		/**
		 *
		 */
		public GetExpressCheckoutDetailsResponseType GetExpressCheckoutDetails(GetExpressCheckoutDetailsReq GetExpressCheckoutDetailsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetExpressCheckoutDetailsReq.getGetExpressCheckoutDetailsRequest);
			string resp = service.call("GetExpressCheckoutDetails", GetExpressCheckoutDetailsReq.toXMLString(), apiUsername);

			return new GetExpressCheckoutDetailsResponseType(resp);
		}

		public GetExpressCheckoutDetailsResponseType GetExpressCheckoutDetails(GetExpressCheckoutDetailsReq GetExpressCheckoutDetailsReq) 
		{
			return GetExpressCheckoutDetails(GetExpressCheckoutDetailsReq, null);
		}
		/**
		 *
		 */
		public DoDirectPaymentResponseType DoDirectPayment(DoDirectPaymentReq DoDirectPaymentReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoDirectPaymentReq.getDoDirectPaymentRequest);
			string resp = service.call("DoDirectPayment", DoDirectPaymentReq.toXMLString(), apiUsername);

			return new DoDirectPaymentResponseType(resp);
		}

		public DoDirectPaymentResponseType DoDirectPayment(DoDirectPaymentReq DoDirectPaymentReq) 
		{
			return DoDirectPayment(DoDirectPaymentReq, null);
		}
		/**
		 *
		 */
		public ManagePendingTransactionStatusResponseType ManagePendingTransactionStatus(ManagePendingTransactionStatusReq ManagePendingTransactionStatusReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(ManagePendingTransactionStatusReq.getManagePendingTransactionStatusRequest);
			string resp = service.call("ManagePendingTransactionStatus", ManagePendingTransactionStatusReq.toXMLString(), apiUsername);

			return new ManagePendingTransactionStatusResponseType(resp);
		}

		public ManagePendingTransactionStatusResponseType ManagePendingTransactionStatus(ManagePendingTransactionStatusReq ManagePendingTransactionStatusReq) 
		{
			return ManagePendingTransactionStatus(ManagePendingTransactionStatusReq, null);
		}
		/**
		 *
		 */
		public DoCancelResponseType DoCancel(DoCancelReq DoCancelReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoCancelReq.getDoCancelRequest);
			string resp = service.call("DoCancel", DoCancelReq.toXMLString(), apiUsername);

			return new DoCancelResponseType(resp);
		}

		public DoCancelResponseType DoCancel(DoCancelReq DoCancelReq) 
		{
			return DoCancel(DoCancelReq, null);
		}
		/**
		 *
		 */
		public DoCaptureResponseType DoCapture(DoCaptureReq DoCaptureReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoCaptureReq.getDoCaptureRequest);
			string resp = service.call("DoCapture", DoCaptureReq.toXMLString(), apiUsername);

			return new DoCaptureResponseType(resp);
		}

		public DoCaptureResponseType DoCapture(DoCaptureReq DoCaptureReq) 
		{
			return DoCapture(DoCaptureReq, null);
		}
		/**
		 *
		 */
		public DoReauthorizationResponseType DoReauthorization(DoReauthorizationReq DoReauthorizationReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoReauthorizationReq.getDoReauthorizationRequest);
			string resp = service.call("DoReauthorization", DoReauthorizationReq.toXMLString(), apiUsername);

			return new DoReauthorizationResponseType(resp);
		}

		public DoReauthorizationResponseType DoReauthorization(DoReauthorizationReq DoReauthorizationReq) 
		{
			return DoReauthorization(DoReauthorizationReq, null);
		}
		/**
		 *
		 */
		public DoVoidResponseType DoVoid(DoVoidReq DoVoidReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoVoidReq.getDoVoidRequest);
			string resp = service.call("DoVoid", DoVoidReq.toXMLString(), apiUsername);

			return new DoVoidResponseType(resp);
		}

		public DoVoidResponseType DoVoid(DoVoidReq DoVoidReq) 
		{
			return DoVoid(DoVoidReq, null);
		}
		/**
		 *
		 */
		public DoAuthorizationResponseType DoAuthorization(DoAuthorizationReq DoAuthorizationReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoAuthorizationReq.getDoAuthorizationRequest);
			string resp = service.call("DoAuthorization", DoAuthorizationReq.toXMLString(), apiUsername);

			return new DoAuthorizationResponseType(resp);
		}

		public DoAuthorizationResponseType DoAuthorization(DoAuthorizationReq DoAuthorizationReq) 
		{
			return DoAuthorization(DoAuthorizationReq, null);
		}
		/**
		 *
		 */
		public SetCustomerBillingAgreementResponseType SetCustomerBillingAgreement(SetCustomerBillingAgreementReq SetCustomerBillingAgreementReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(SetCustomerBillingAgreementReq.getSetCustomerBillingAgreementRequest);
			string resp = service.call("SetCustomerBillingAgreement", SetCustomerBillingAgreementReq.toXMLString(), apiUsername);

			return new SetCustomerBillingAgreementResponseType(resp);
		}

		public SetCustomerBillingAgreementResponseType SetCustomerBillingAgreement(SetCustomerBillingAgreementReq SetCustomerBillingAgreementReq) 
		{
			return SetCustomerBillingAgreement(SetCustomerBillingAgreementReq, null);
		}
		/**
		 *
		 */
		public GetBillingAgreementCustomerDetailsResponseType GetBillingAgreementCustomerDetails(GetBillingAgreementCustomerDetailsReq GetBillingAgreementCustomerDetailsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetBillingAgreementCustomerDetailsReq.getGetBillingAgreementCustomerDetailsRequest);
			string resp = service.call("GetBillingAgreementCustomerDetails", GetBillingAgreementCustomerDetailsReq.toXMLString(), apiUsername);

			return new GetBillingAgreementCustomerDetailsResponseType(resp);
		}

		public GetBillingAgreementCustomerDetailsResponseType GetBillingAgreementCustomerDetails(GetBillingAgreementCustomerDetailsReq GetBillingAgreementCustomerDetailsReq) 
		{
			return GetBillingAgreementCustomerDetails(GetBillingAgreementCustomerDetailsReq, null);
		}
		/**
		 *
		 */
		public CreateBillingAgreementResponseType CreateBillingAgreement(CreateBillingAgreementReq CreateBillingAgreementReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(CreateBillingAgreementReq.getCreateBillingAgreementRequest);
			string resp = service.call("CreateBillingAgreement", CreateBillingAgreementReq.toXMLString(), apiUsername);

			return new CreateBillingAgreementResponseType(resp);
		}

		public CreateBillingAgreementResponseType CreateBillingAgreement(CreateBillingAgreementReq CreateBillingAgreementReq) 
		{
			return CreateBillingAgreement(CreateBillingAgreementReq, null);
		}
		/**
		 *
		 */
		public DoReferenceTransactionResponseType DoReferenceTransaction(DoReferenceTransactionReq DoReferenceTransactionReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoReferenceTransactionReq.getDoReferenceTransactionRequest);
			string resp = service.call("DoReferenceTransaction", DoReferenceTransactionReq.toXMLString(), apiUsername);

			return new DoReferenceTransactionResponseType(resp);
		}

		public DoReferenceTransactionResponseType DoReferenceTransaction(DoReferenceTransactionReq DoReferenceTransactionReq) 
		{
			return DoReferenceTransaction(DoReferenceTransactionReq, null);
		}
		/**
		 *
		 */
		public DoNonReferencedCreditResponseType DoNonReferencedCredit(DoNonReferencedCreditReq DoNonReferencedCreditReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoNonReferencedCreditReq.getDoNonReferencedCreditRequest);
			string resp = service.call("DoNonReferencedCredit", DoNonReferencedCreditReq.toXMLString(), apiUsername);

			return new DoNonReferencedCreditResponseType(resp);
		}

		public DoNonReferencedCreditResponseType DoNonReferencedCredit(DoNonReferencedCreditReq DoNonReferencedCreditReq) 
		{
			return DoNonReferencedCredit(DoNonReferencedCreditReq, null);
		}
		/**
		 *
		 */
		public DoUATPAuthorizationResponseType DoUATPAuthorization(DoUATPAuthorizationReq DoUATPAuthorizationReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(DoUATPAuthorizationReq.getDoUATPAuthorizationRequest);
			string resp = service.call("DoUATPAuthorization", DoUATPAuthorizationReq.toXMLString(), apiUsername);

			return new DoUATPAuthorizationResponseType(resp);
		}

		public DoUATPAuthorizationResponseType DoUATPAuthorization(DoUATPAuthorizationReq DoUATPAuthorizationReq) 
		{
			return DoUATPAuthorization(DoUATPAuthorizationReq, null);
		}
		/**
		 *
		 */
		public CreateRecurringPaymentsProfileResponseType CreateRecurringPaymentsProfile(CreateRecurringPaymentsProfileReq CreateRecurringPaymentsProfileReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(CreateRecurringPaymentsProfileReq.getCreateRecurringPaymentsProfileRequest);
			string resp = service.call("CreateRecurringPaymentsProfile", CreateRecurringPaymentsProfileReq.toXMLString(), apiUsername);

			return new CreateRecurringPaymentsProfileResponseType(resp);
		}

		public CreateRecurringPaymentsProfileResponseType CreateRecurringPaymentsProfile(CreateRecurringPaymentsProfileReq CreateRecurringPaymentsProfileReq) 
		{
			return CreateRecurringPaymentsProfile(CreateRecurringPaymentsProfileReq, null);
		}
		/**
		 *
		 */
		public GetRecurringPaymentsProfileDetailsResponseType GetRecurringPaymentsProfileDetails(GetRecurringPaymentsProfileDetailsReq GetRecurringPaymentsProfileDetailsReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(GetRecurringPaymentsProfileDetailsReq.getGetRecurringPaymentsProfileDetailsRequest);
			string resp = service.call("GetRecurringPaymentsProfileDetails", GetRecurringPaymentsProfileDetailsReq.toXMLString(), apiUsername);

			return new GetRecurringPaymentsProfileDetailsResponseType(resp);
		}

		public GetRecurringPaymentsProfileDetailsResponseType GetRecurringPaymentsProfileDetails(GetRecurringPaymentsProfileDetailsReq GetRecurringPaymentsProfileDetailsReq) 
		{
			return GetRecurringPaymentsProfileDetails(GetRecurringPaymentsProfileDetailsReq, null);
		}
		/**
		 *
		 */
		public ManageRecurringPaymentsProfileStatusResponseType ManageRecurringPaymentsProfileStatus(ManageRecurringPaymentsProfileStatusReq ManageRecurringPaymentsProfileStatusReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(ManageRecurringPaymentsProfileStatusReq.getManageRecurringPaymentsProfileStatusRequest);
			string resp = service.call("ManageRecurringPaymentsProfileStatus", ManageRecurringPaymentsProfileStatusReq.toXMLString(), apiUsername);

			return new ManageRecurringPaymentsProfileStatusResponseType(resp);
		}

		public ManageRecurringPaymentsProfileStatusResponseType ManageRecurringPaymentsProfileStatus(ManageRecurringPaymentsProfileStatusReq ManageRecurringPaymentsProfileStatusReq) 
		{
			return ManageRecurringPaymentsProfileStatus(ManageRecurringPaymentsProfileStatusReq, null);
		}
		/**
		 *
		 */
		public BillOutstandingAmountResponseType BillOutstandingAmount(BillOutstandingAmountReq BillOutstandingAmountReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(BillOutstandingAmountReq.getBillOutstandingAmountRequest);
			string resp = service.call("BillOutstandingAmount", BillOutstandingAmountReq.toXMLString(), apiUsername);

			return new BillOutstandingAmountResponseType(resp);
		}

		public BillOutstandingAmountResponseType BillOutstandingAmount(BillOutstandingAmountReq BillOutstandingAmountReq) 
		{
			return BillOutstandingAmount(BillOutstandingAmountReq, null);
		}
		/**
		 *
		 */
		public UpdateRecurringPaymentsProfileResponseType UpdateRecurringPaymentsProfile(UpdateRecurringPaymentsProfileReq UpdateRecurringPaymentsProfileReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(UpdateRecurringPaymentsProfileReq.getUpdateRecurringPaymentsProfileRequest);
			string resp = service.call("UpdateRecurringPaymentsProfile", UpdateRecurringPaymentsProfileReq.toXMLString(), apiUsername);

			return new UpdateRecurringPaymentsProfileResponseType(resp);
		}

		public UpdateRecurringPaymentsProfileResponseType UpdateRecurringPaymentsProfile(UpdateRecurringPaymentsProfileReq UpdateRecurringPaymentsProfileReq) 
		{
			return UpdateRecurringPaymentsProfile(UpdateRecurringPaymentsProfileReq, null);
		}
		/**
		 *
		 */
		public ReverseTransactionResponseType ReverseTransaction(ReverseTransactionReq ReverseTransactionReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(ReverseTransactionReq.getReverseTransactionRequest);
			string resp = service.call("ReverseTransaction", ReverseTransactionReq.toXMLString(), apiUsername);

			return new ReverseTransactionResponseType(resp);
		}

		public ReverseTransactionResponseType ReverseTransaction(ReverseTransactionReq ReverseTransactionReq) 
		{
			return ReverseTransaction(ReverseTransactionReq, null);
		}
		/**
		 *
		 */
		public ExternalRememberMeOptOutResponseType ExternalRememberMeOptOut(ExternalRememberMeOptOutReq ExternalRememberMeOptOutReq, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
		setStandardParams(ExternalRememberMeOptOutReq.getExternalRememberMeOptOutRequest);
			string resp = service.call("ExternalRememberMeOptOut", ExternalRememberMeOptOutReq.toXMLString(), apiUsername);

			return new ExternalRememberMeOptOutResponseType(resp);
		}

		public ExternalRememberMeOptOutResponseType ExternalRememberMeOptOut(ExternalRememberMeOptOutReq ExternalRememberMeOptOutReq) 
		{
			return ExternalRememberMeOptOut(ExternalRememberMeOptOutReq, null);
		}
	}
}


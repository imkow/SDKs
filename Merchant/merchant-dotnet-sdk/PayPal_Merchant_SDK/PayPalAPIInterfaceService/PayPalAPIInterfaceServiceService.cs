/** 
 * Auto generated code
 */

using PayPal.Authentication;

namespace PayPal.PayPalAPIInterfaceService {

	using PayPal;
	using PayPal.Util;
	using PayPal.Manager;
	using PayPal.PayPalAPIInterfaceService.Model;

	public partial class PayPalAPIInterfaceServiceService : BasePayPalService {

		private static string serviceName = "PayPalAPIInterfaceService";
        private static string serviceVersion = "84.0";

		public PayPalAPIInterfaceServiceService() : base(serviceName, serviceVersion)
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
            setStandardParams(RefundTransactionReq.RefundTransactionRequest);			
			string resp = call("RefundTransaction", RefundTransactionReq.toXMLString(), apiUsername);
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
            setStandardParams(InitiateRecoupReq.InitiateRecoupRequest);
			string resp = call("InitiateRecoup", InitiateRecoupReq.toXMLString(), apiUsername);
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
            setStandardParams(CompleteRecoupReq.CompleteRecoupRequest);
			string resp = call("CompleteRecoup", CompleteRecoupReq.toXMLString(), apiUsername);
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
            setStandardParams(CancelRecoupReq.CancelRecoupRequest);
			string resp = call("CancelRecoup", CancelRecoupReq.toXMLString(), apiUsername);
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
            setStandardParams(GetTransactionDetailsReq.GetTransactionDetailsRequest);
			string resp = call("GetTransactionDetails", GetTransactionDetailsReq.toXMLString(), apiUsername);
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
			setStandardParams(BillUserReq.BillUserRequest);
			string resp = call("BillUser", BillUserReq.toXMLString(), apiUsername);
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
			setStandardParams(TransactionSearchReq.TransactionSearchRequest);
			string resp = call("TransactionSearch", TransactionSearchReq.toXMLString(), apiUsername);
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
			setStandardParams(MassPayReq.MassPayRequest);
			string resp = call("MassPay", MassPayReq.toXMLString(), apiUsername);
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
			setStandardParams(BillAgreementUpdateReq.BAUpdateRequest);
			string resp = call("BillAgreementUpdate", BillAgreementUpdateReq.toXMLString(), apiUsername);
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
			setStandardParams(AddressVerifyReq.AddressVerifyRequest);
			string resp = call("AddressVerify", AddressVerifyReq.toXMLString(), apiUsername);
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
			setStandardParams(EnterBoardingReq.EnterBoardingRequest);
			string resp = call("EnterBoarding", EnterBoardingReq.toXMLString(), apiUsername);
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
			setStandardParams(GetBoardingDetailsReq.GetBoardingDetailsRequest);
			string resp = call("GetBoardingDetails", GetBoardingDetailsReq.toXMLString(), apiUsername);
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
			setStandardParams(CreateMobilePaymentReq.CreateMobilePaymentRequest);
			string resp = call("CreateMobilePayment", CreateMobilePaymentReq.toXMLString(), apiUsername);
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
            setStandardParams(GetMobileStatusReq.GetMobileStatusRequest);
			string resp = call("GetMobileStatus", GetMobileStatusReq.toXMLString(), apiUsername);
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
            setStandardParams(SetMobileCheckoutReq.SetMobileCheckoutRequest);
			string resp = call("SetMobileCheckout", SetMobileCheckoutReq.toXMLString(), apiUsername);
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
            setStandardParams(DoMobileCheckoutPaymentReq.DoMobileCheckoutPaymentRequest);
			string resp = call("DoMobileCheckoutPayment", DoMobileCheckoutPaymentReq.toXMLString(), apiUsername);
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
            setStandardParams(GetBalanceReq.GetBalanceRequest);
			string resp = call("GetBalance", GetBalanceReq.toXMLString(), apiUsername);
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
            setStandardParams(GetPalDetailsReq.GetPalDetailsRequest);
			string resp = call("GetPalDetails", GetPalDetailsReq.toXMLString(), apiUsername);
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
            setStandardParams(DoExpressCheckoutPaymentReq.DoExpressCheckoutPaymentRequest);
			string resp = call("DoExpressCheckoutPayment", DoExpressCheckoutPaymentReq.toXMLString(), apiUsername);
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
            setStandardParams(DoUATPExpressCheckoutPaymentReq.DoUATPExpressCheckoutPaymentRequest);
			string resp = call("DoUATPExpressCheckoutPayment", DoUATPExpressCheckoutPaymentReq.toXMLString(), apiUsername);
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
            setStandardParams(SetAuthFlowParamReq.SetAuthFlowParamRequest);
			string resp = call("SetAuthFlowParam", SetAuthFlowParamReq.toXMLString(), apiUsername);
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
            setStandardParams(GetAuthDetailsReq.GetAuthDetailsRequest);
			string resp = call("GetAuthDetails", GetAuthDetailsReq.toXMLString(), apiUsername);
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
            setStandardParams(SetAccessPermissionsReq.SetAccessPermissionsRequest);
			string resp = call("SetAccessPermissions", SetAccessPermissionsReq.toXMLString(), apiUsername);
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
            setStandardParams(UpdateAccessPermissionsReq.UpdateAccessPermissionsRequest);
			string resp = call("UpdateAccessPermissions", UpdateAccessPermissionsReq.toXMLString(), apiUsername);
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
            setStandardParams(GetAccessPermissionDetailsReq.GetAccessPermissionDetailsRequest);
			string resp = call("GetAccessPermissionDetails", GetAccessPermissionDetailsReq.toXMLString(), apiUsername);
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
            setStandardParams(GetIncentiveEvaluationReq.GetIncentiveEvaluationRequest);
			string resp = call("GetIncentiveEvaluation", GetIncentiveEvaluationReq.toXMLString(), apiUsername);
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
            setStandardParams(SetExpressCheckoutReq.SetExpressCheckoutRequest);
			string resp = call("SetExpressCheckout", SetExpressCheckoutReq.toXMLString(), apiUsername);
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
            setStandardParams(ExecuteCheckoutOperationsReq.ExecuteCheckoutOperationsRequest);
			string resp = call("ExecuteCheckoutOperations", ExecuteCheckoutOperationsReq.toXMLString(), apiUsername);

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
            setStandardParams(GetExpressCheckoutDetailsReq.GetExpressCheckoutDetailsRequest);
			string resp = call("GetExpressCheckoutDetails", GetExpressCheckoutDetailsReq.toXMLString(), apiUsername);
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
            setStandardParams(DoDirectPaymentReq.DoDirectPaymentRequest);
			string resp = call("DoDirectPayment", DoDirectPaymentReq.toXMLString(), apiUsername);
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
            setStandardParams(ManagePendingTransactionStatusReq.ManagePendingTransactionStatusRequest);
			string resp = call("ManagePendingTransactionStatus", ManagePendingTransactionStatusReq.toXMLString(), apiUsername);
			return new ManagePendingTransactionStatusResponseType(resp);
		}

		public ManagePendingTransactionStatusResponseType ManagePendingTransactionStatus(ManagePendingTransactionStatusReq ManagePendingTransactionStatusReq) 
		{
			return ManagePendingTransactionStatus(ManagePendingTransactionStatusReq, null);
		}
		/**
		 *
		 */
		public DoCaptureResponseType DoCapture(DoCaptureReq DoCaptureReq, string apiUsername) 
		{
            setStandardParams(DoCaptureReq.DoCaptureRequest);
			string resp = call("DoCapture", DoCaptureReq.toXMLString(), apiUsername);
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
            setStandardParams(DoReauthorizationReq.DoReauthorizationRequest);
			string resp = call("DoReauthorization", DoReauthorizationReq.toXMLString(), apiUsername);
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
            setStandardParams(DoVoidReq.DoVoidRequest);
			string resp = call("DoVoid", DoVoidReq.toXMLString(), apiUsername);
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
            setStandardParams(DoAuthorizationReq.DoAuthorizationRequest);
			string resp = call("DoAuthorization", DoAuthorizationReq.toXMLString(), apiUsername);
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
            setStandardParams(SetCustomerBillingAgreementReq.SetCustomerBillingAgreementRequest);
			string resp = call("SetCustomerBillingAgreement", SetCustomerBillingAgreementReq.toXMLString(), apiUsername);
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
            setStandardParams(GetBillingAgreementCustomerDetailsReq.GetBillingAgreementCustomerDetailsRequest);
			string resp = call("GetBillingAgreementCustomerDetails", GetBillingAgreementCustomerDetailsReq.toXMLString(), apiUsername);
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
            setStandardParams(CreateBillingAgreementReq.CreateBillingAgreementRequest);
			string resp = call("CreateBillingAgreement", CreateBillingAgreementReq.toXMLString(), apiUsername);
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
            setStandardParams(DoReferenceTransactionReq.DoReferenceTransactionRequest);
			string resp = call("DoReferenceTransaction", DoReferenceTransactionReq.toXMLString(), apiUsername);
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
            setStandardParams(DoNonReferencedCreditReq.DoNonReferencedCreditRequest);
			string resp = call("DoNonReferencedCredit", DoNonReferencedCreditReq.toXMLString(), apiUsername);
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
            setStandardParams(DoUATPAuthorizationReq.DoUATPAuthorizationRequest);
			string resp = call("DoUATPAuthorization", DoUATPAuthorizationReq.toXMLString(), apiUsername);
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
            setStandardParams(CreateRecurringPaymentsProfileReq.CreateRecurringPaymentsProfileRequest);
			string resp = call("CreateRecurringPaymentsProfile", CreateRecurringPaymentsProfileReq.toXMLString(), apiUsername);
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
            setStandardParams(GetRecurringPaymentsProfileDetailsReq.GetRecurringPaymentsProfileDetailsRequest);
			string resp = call("GetRecurringPaymentsProfileDetails", GetRecurringPaymentsProfileDetailsReq.toXMLString(), apiUsername);
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
            setStandardParams(ManageRecurringPaymentsProfileStatusReq.ManageRecurringPaymentsProfileStatusRequest);
			string resp = call("ManageRecurringPaymentsProfileStatus", ManageRecurringPaymentsProfileStatusReq.toXMLString(), apiUsername);
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
            setStandardParams(BillOutstandingAmountReq.BillOutstandingAmountRequest);
			string resp = call("BillOutstandingAmount", BillOutstandingAmountReq.toXMLString(), apiUsername);
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
            setStandardParams(UpdateRecurringPaymentsProfileReq.UpdateRecurringPaymentsProfileRequest);
			string resp = call("UpdateRecurringPaymentsProfile", UpdateRecurringPaymentsProfileReq.toXMLString(), apiUsername);
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
            setStandardParams(ReverseTransactionReq.ReverseTransactionRequest);
			string resp = call("ReverseTransaction", ReverseTransactionReq.toXMLString(), apiUsername);
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
            setStandardParams(ExternalRememberMeOptOutReq.ExternalRememberMeOptOutRequest);
			string resp = call("ExternalRememberMeOptOut", ExternalRememberMeOptOutReq.toXMLString(), apiUsername);
			return new ExternalRememberMeOptOutResponseType(resp);
		}

		public ExternalRememberMeOptOutResponseType ExternalRememberMeOptOut(ExternalRememberMeOptOutReq ExternalRememberMeOptOutReq) 
		{
			return ExternalRememberMeOptOut(ExternalRememberMeOptOutReq, null);
		}
	}
}


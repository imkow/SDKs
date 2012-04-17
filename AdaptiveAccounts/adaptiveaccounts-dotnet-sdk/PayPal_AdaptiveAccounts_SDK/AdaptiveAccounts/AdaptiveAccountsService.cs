/** 
 * Auto generated code
 */

using PayPal.Authentication;

namespace PayPal.AdaptiveAccounts {

	using PayPal;
	using PayPal.Util;
	using PayPal.Manager;
	using PayPal.AdaptiveAccounts.Model;

	public partial class AdaptiveAccountsService :BasePayPalService{

		private static string serviceName = "AdaptiveAccounts";


		private static string serviceVersion"1.0.3";


		 public AdaptiveAccountsService() : base(serviceName)
		        {}
	/// <summary>
 /// Sets standard parameters common to all requests
 /// </summary>
		/**
		 *		 * Coutries Supported:
		 * AU - Australia
		 * CA - Canada
		 * CY - Cyprus
		 * CZ - Czech Republic
		 * DK - Denmark
		 * EE - Estonia
		 * FI - Finland
		 * FR - France
		 * DE - Germany
		 * GR - Greece
		 * HU - Hungary
		 * IT - Italy
		 * LV - Latvia
		 * LT - Lithuania
		 * LU - Luxembourg
		 * MT - Malta
		 * NL - Netherlands
		 * PL - Poland
		 * PT - Portugal
		 * SK - Slovak Republic
		 * SI - Slovenia
		 * ES - Spain
		 * SE - Sweden
		 * UK - United Kingdom
		 * US - United States

		 */
		public CreateAccountResponse CreateAccount(CreateAccountRequest CreateAccountRequest, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
			string resp = service.call("CreateAccount", CreateAccountRequest.toNVPString(""), apiUsername);

			NVPUtil util = new NVPUtil();
			return new CreateAccountResponse(util.parseNVPString(resp), "");
		}

		public CreateAccountResponse CreateAccount(CreateAccountRequest CreateAccountRequest) 
		{
			return CreateAccount(CreateAccountRequest, null);
		}
		/**
		 *		 * Countries Supported:
		 * AU - Australia
		 * AT - Austria  
		 * CA - Canada
		 * CZ - Czech Republic
		 * EU - European Union *
		 * FR - France
		 * DE - Germany
		 * GB - Great Britain
		 * GR - Greece
		 * IE - Ireland
		 * IL - Israel
		 * IT - Italy
		 * JP - Japan
		 * NL - Netherlands
		 * NZ - New Zealand (Aotearoa)
		 * PL - Poland
		 * PT - Portugal
		 * RU - Russian Federation
		 * SG - Singapore
		 * ZA - South Africa
		 * ES - Spain
		 * CH - Switzerland  
		 * US - United States
		 * * technically a group of countries

		 */
		public GetUserAgreementResponse GetUserAgreement(GetUserAgreementRequest GetUserAgreementRequest, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
			string resp = service.call("GetUserAgreement", GetUserAgreementRequest.toNVPString(""), apiUsername);

			NVPUtil util = new NVPUtil();
			return new GetUserAgreementResponse(util.parseNVPString(resp), "");
		}

		public GetUserAgreementResponse GetUserAgreement(GetUserAgreementRequest GetUserAgreementRequest) 
		{
			return GetUserAgreement(GetUserAgreementRequest, null);
		}
		/**
		 *		 * All countries are supported.

		 */
		public GetVerifiedStatusResponse GetVerifiedStatus(GetVerifiedStatusRequest GetVerifiedStatusRequest, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
			string resp = service.call("GetVerifiedStatus", GetVerifiedStatusRequest.toNVPString(""), apiUsername);

			NVPUtil util = new NVPUtil();
			return new GetVerifiedStatusResponse(util.parseNVPString(resp), "");
		}

		public GetVerifiedStatusResponse GetVerifiedStatus(GetVerifiedStatusRequest GetVerifiedStatusRequest) 
		{
			return GetVerifiedStatus(GetVerifiedStatusRequest, null);
		}
		/**
		 *		 * Countries Supported:
		 * AU - Australia
		 * CA - Canada
		 * FR - France
		 * DE - Germany
		 * IL - Israel
		 * IT - Italy
		 * NL - Netherlands
		 * UK - United Kingdom
		 * US - United States

		 */
		public AddBankAccountResponse AddBankAccount(AddBankAccountRequest AddBankAccountRequest, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
			string resp = service.call("AddBankAccount", AddBankAccountRequest.toNVPString(""), apiUsername);

			NVPUtil util = new NVPUtil();
			return new AddBankAccountResponse(util.parseNVPString(resp), "");
		}

		public AddBankAccountResponse AddBankAccount(AddBankAccountRequest AddBankAccountRequest) 
		{
			return AddBankAccount(AddBankAccountRequest, null);
		}
		/**
		 *		 * Countries Supported:
		 * AU - Australia
		 * AT - Austria  
		 * BE - Belgium
		 * BR - Brazil
		 * CA - Canada
		 * CZ - Czech Republic
		 * FR - France
		 * DE - Germany
		 * GR - Greece
		 * HK - Hong Kong
		 * IE - Ireland
		 * IT - Italy
		 * JP - Japan
		 * LU - Luxembourg
		 * MX - Mexico
		 * NL - Netherlands
		 * NZ - New Zealand (Aotearoa)
		 * PL - Poland
		 * PT - Portugal
		 * RU - Russian Federation
		 * SG - Singapore
		 * ZA - South Africa
		 * ES - Spain
		 * CH - Switzerland  
		 * UK - United Kingdom
		 * US - United States

		 */
		public AddPaymentCardResponse AddPaymentCard(AddPaymentCardRequest AddPaymentCardRequest, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
			string resp = service.call("AddPaymentCard", AddPaymentCardRequest.toNVPString(""), apiUsername);

			NVPUtil util = new NVPUtil();
			return new AddPaymentCardResponse(util.parseNVPString(resp), "");
		}

		public AddPaymentCardResponse AddPaymentCard(AddPaymentCardRequest AddPaymentCardRequest) 
		{
			return AddPaymentCard(AddPaymentCardRequest, null);
		}
		/**
		 *		 * To be updated.
		 * Countries Supported:
		 * AU - Australia
		 * AT - Austria  
		 * BE - Belgium
		 * BR - Brazil
		 * CA - Canada
		 * CZ - Czech Republic
		 * FR - France
		 * DE - Germany
		 * GR - Greece
		 * HK - Hong Kong
		 * IE - Ireland
		 * IT - Italy
		 * JP - Japan
		 * LU - Luxembourg
		 * MX - Mexico
		 * NL - Netherlands
		 * NZ - New Zealand (Aotearoa)
		 * PL - Poland
		 * PT - Portugal
		 * RU - Russian Federation
		 * SG - Singapore
		 * ZA - South Africa
		 * ES - Spain
		 * CH - Switzerland  
		 * UK - United Kingdom
		 * US - United States

		 */
		public SetFundingSourceConfirmedResponse SetFundingSourceConfirmed(SetFundingSourceConfirmedRequest SetFundingSourceConfirmedRequest, string apiUsername) 
		{
			BasePayPalService service = new BasePayPalService(serviceName);
			string resp = service.call("SetFundingSourceConfirmed", SetFundingSourceConfirmedRequest.toNVPString(""), apiUsername);

			NVPUtil util = new NVPUtil();
			return new SetFundingSourceConfirmedResponse(util.parseNVPString(resp), "");
		}

		public SetFundingSourceConfirmedResponse SetFundingSourceConfirmed(SetFundingSourceConfirmedRequest SetFundingSourceConfirmedRequest) 
		{
			return SetFundingSourceConfirmed(SetFundingSourceConfirmedRequest, null);
		}
	}
}


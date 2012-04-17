<?php

require_once('PPBaseService.php');
require_once('AdaptiveAccounts.php');
require_once('PPUtils.php');
/**
 * AdaptiveAccounts wrapper class
 * Auto generated code
 */
class AdaptiveAccountsService extends PPBaseService {
	private static $SERVICE_VERSION='1.0.3';
	public function __construct() {
		parent::__construct('AdaptiveAccounts');
	}

	/**
	 * Service Call: CreateAccount
	 * Coutries Supported:
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
	 * @param CreateAccountRequest $createAccountRequest
	 * @return CreateAccountResponse
	 * @throws APIException
	 */
	public function CreateAccount($createAccountRequest, $apiUsername=null) {
		$ret = new CreateAccountResponse();
		$resp = $this->call("CreateAccount", $createAccountRequest, $apiUsername);
		$ret->init(PPUtils::nvpToMap($resp));
		return $ret;
	}


	/**
	 * Service Call: GetUserAgreement
	 * Countries Supported:
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
	 * @param GetUserAgreementRequest $getUserAgreementRequest
	 * @return GetUserAgreementResponse
	 * @throws APIException
	 */
	public function GetUserAgreement($getUserAgreementRequest, $apiUsername=null) {
		$ret = new GetUserAgreementResponse();
		$resp = $this->call("GetUserAgreement", $getUserAgreementRequest, $apiUsername);
		$ret->init(PPUtils::nvpToMap($resp));
		return $ret;
	}


	/**
	 * Service Call: GetVerifiedStatus
	 * All countries are supported.
	 * @param GetVerifiedStatusRequest $getVerifiedStatusRequest
	 * @return GetVerifiedStatusResponse
	 * @throws APIException
	 */
	public function GetVerifiedStatus($getVerifiedStatusRequest, $apiUsername=null) {
		$ret = new GetVerifiedStatusResponse();
		$resp = $this->call("GetVerifiedStatus", $getVerifiedStatusRequest, $apiUsername);
		$ret->init(PPUtils::nvpToMap($resp));
		return $ret;
	}


	/**
	 * Service Call: AddBankAccount
	 * Countries Supported:
	 * AU - Australia
	 * CA - Canada
	 * FR - France
	 * DE - Germany
	 * IL - Israel
	 * IT - Italy
	 * NL - Netherlands
	 * UK - United Kingdom
	 * US - United States
	 * @param AddBankAccountRequest $addBankAccountRequest
	 * @return AddBankAccountResponse
	 * @throws APIException
	 */
	public function AddBankAccount($addBankAccountRequest, $apiUsername=null) {
		$ret = new AddBankAccountResponse();
		$resp = $this->call("AddBankAccount", $addBankAccountRequest, $apiUsername);
		$ret->init(PPUtils::nvpToMap($resp));
		return $ret;
	}


	/**
	 * Service Call: AddPaymentCard
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
	 * @param AddPaymentCardRequest $addPaymentCardRequest
	 * @return AddPaymentCardResponse
	 * @throws APIException
	 */
	public function AddPaymentCard($addPaymentCardRequest, $apiUsername=null) {
		$ret = new AddPaymentCardResponse();
		$resp = $this->call("AddPaymentCard", $addPaymentCardRequest, $apiUsername);
		$ret->init(PPUtils::nvpToMap($resp));
		return $ret;
	}


	/**
	 * Service Call: SetFundingSourceConfirmed
	 * To be updated.
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
	 * @param SetFundingSourceConfirmedRequest $setFundingSourceConfirmedRequest
	 * @return SetFundingSourceConfirmedResponse
	 * @throws APIException
	 */
	public function SetFundingSourceConfirmed($setFundingSourceConfirmedRequest, $apiUsername=null) {
		$ret = new SetFundingSourceConfirmedResponse();
		$resp = $this->call("SetFundingSourceConfirmed", $setFundingSourceConfirmedRequest, $apiUsername);
		$ret->init(PPUtils::nvpToMap($resp));
		return $ret;
	}


}

?>
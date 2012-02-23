<?php
$path = '../lib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
require_once('services/AdaptiveAccounts/AdaptiveAccountsService.php');
require_once('PPLoggingManager.php');
require_once('Common/Constants.php');
session_start();

$logger = new PPLoggingManager('AddBankAccount');

try {

	$addBankAccount = new AddBankAccountRequest();
	$addBankAccount->accountId = $_REQUEST['accountID'];
	$addBankAccount->emailAddress = $_REQUEST['emailAddress'];
	$addBankAccount->createAccountKey  = $_REQUEST['createAccountKey'];
	$addBankAccount->bankCountryCode  = $_REQUEST['bankCountryCode'];

	$addBankAccount->bankName  = $_REQUEST['bankName'];
	$addBankAccount->routingNumber  = $_REQUEST['routingNumber'];
	$addBankAccount->bankAccountType  = $_REQUEST['bankAccountType'];
	$addBankAccount->bankAccountNumber = $_REQUEST['bankAccountNumber'];
	$addBankAccount->iban = $_REQUEST['iban'];
	$addBankAccount->clabe  = $_REQUEST['clabe'];
	$addBankAccount->bsbNumber  = $_REQUEST['bsbNumber'];
	$addBankAccount->branchLocation = $_REQUEST['branchLocation'];
	$addBankAccount->sortCode  = $_REQUEST['sortCode'];
	$addBankAccount->bankTransitNumber = $_REQUEST['bankTransitNumber'];
	$addBankAccount->institutionNumber = $_REQUEST['institutionNumber'];
	$addBankAccount->branchCode = $_REQUEST['branchCode'];
	$addBankAccount->agencyNumber = $_REQUEST['agencyNumber'];
	$addBankAccount->bankCode = $_REQUEST['bankCode'];
	$addBankAccount->ribKey = $_REQUEST['ribKey'];
	$addBankAccount->controlDigit = $_REQUEST['controlDigit'];
	$addBankAccount->accountHolderDateOfBirth = $_REQUEST['accountHolderDateOfBirth'];
	$addBankAccount->confirmationType = $_REQUEST['confirmationType'];

	if($addBankAccount->confirmationType == 'WEB')
	{
		$serverName = $_SERVER['SERVER_NAME'];
		$serverPort = $_SERVER['SERVER_PORT'];
		$url=dirname('http://'.$serverName.':'.$serverPort.$_SERVER['REQUEST_URI']);
		if($_REQUEST['returnURL']!=null)
		{
			$returnURL = $_REQUEST['returnURL'];
		}
		else
		$returnURL = $url."/Common/WebflowReturnPage.php";

		if($_REQUEST['cancelURL']!=null)
		{
			$cancelURL = $_REQUEST['cancelURL'];
		}
		else
		$cancelURL = $url. "/AddBankAccount.html.php" ;

		$webOption = new WebOptionsType();
		$webOption->cancelUrl = $cancelURL;
		$webOption->cancelUrlDescription = $_REQUEST['returnURLDescription'];
		$webOption->returnUrl = $returnURL;
		$webOption->returnUrlDescription = $_REQUEST['cancelURLDescription'];
		$addBankAccount->webOptions = $webOption;
	}


	$service  = new AdaptiveAccountsService();
	$response = $service->AddBankAccount($addBankAccount);

	$ack = strtoupper($response->responseEnvelope->ack);

	if($ack != "SUCCESS"){
		$_SESSION['reshash']=$response;
		$location = "APIError.php";
		header("Location: $location");
	}
	else
	{

		echo "<pre>";
		print_r($response);
		echo "</pre>";
		$payPalURL = $response->redirectURL;
		echo" <a href=$payPalURL><b>* Redirect URL to Add Bank Account </b></a><br>";
		

	}

}
catch(Exception $ex) {
	throw new Exception('Error occurred in AddBankAccount method');
}

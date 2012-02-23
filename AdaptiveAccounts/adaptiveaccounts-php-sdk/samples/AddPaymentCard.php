<?php
$path = '../lib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
require_once('services/AdaptiveAccounts/AdaptiveAccountsService.php');
require_once('PPLoggingManager.php');
require_once('Common/Constants.php');
session_start();

$logger = new PPLoggingManager('AddPaymentCard');

try {
	
	$nameOnCard = new NameType();
	$nameOnCard->firstName  = $_REQUEST['firstName'];
	$nameOnCard->lastName = $_REQUEST['lastName'];
	$nameOnCard->middleName = $_REQUEST['middleName'];
	$nameOnCard->salutation = $_REQUEST['saluation'];
	$nameOnCard->suffix = $_REQUEST['suffix'];
	
	$startDate = new CardDateType();
	$startDate->month = $_REQUEST['startMonth'];
	$startDate->year = $_REQUEST['startYear'];
	
	$expDate = new CardDateType();
	$expDate->month  = $_REQUEST['expirationMonth'];
	$expDate->year = $_REQUEST['expirationYear'];
	
	$billingAddress = new AddressType();
	$billingAddress->line1 = $_REQUEST['billingStreet'];
	$billingAddress->line2 = $_REQUEST['billingLine2'];
	$billingAddress->city = $_REQUEST['billingCity'];
	$billingAddress->state = $_REQUEST['billingState'];
	$billingAddress->postalCode = $_REQUEST['billingPostalCode'];
	$billingAddress->countryCode = $_REQUEST['billingCountryCode'];
	
	$addPaymentCard = new AddPaymentCardRequest();
	$addPaymentCard->accountId = $_REQUEST['accountID'];
	$addPaymentCard->emailAddress = $_REQUEST['emailAddress'];
	$addPaymentCard->createAccountKey  = $_REQUEST['createAccountKey'];
	$addPaymentCard->nameOnCard = $nameOnCard;

	$addPaymentCard->cardNumber  = $_REQUEST['cardNumber'];
	$addPaymentCard->cardType  = $_REQUEST['cardType'];
	$addPaymentCard->cardOwnerDateOfBirth  = $_REQUEST['cardOwnerDateOfBirth'];
	$addPaymentCard->cardVerificationNumber = $_REQUEST['cardVerificationNumber'];
	$addPaymentCard->issueNumber = $_REQUEST['issueNumber'];
	$addPaymentCard->startDate  = $startDate;
	$addPaymentCard->expirationDate  = $expDate;
	$addPaymentCard->billingAddress = $_REQUEST['branchLocation'];
	$addPaymentCard->confirmationType = $_REQUEST['confirmationType'];

	if($addPaymentCard->confirmationType == 'WEB')
	{
		$serverName = $_SERVER['SERVER_NAME'];
		$serverPort = $_SERVER['SERVER_PORT'];
		$url=dirname('http://'.$serverName.':'.$serverPort.$_SERVER['REQUEST_URI']);
		if(isset($_REQUEST['returnURL']))
		{
			$returnURL = $_REQUEST['returnURL'];
		}
		else
		$returnURL = $url."/Common/WebflowReturnPage.php";

		if(isset($_REQUEST['cancelURL']))
		{
			$cancelURL = $_REQUEST['cancelURL'];
		}
		else
		$cancelURL = $url. "/CreateAccount.html.php" ;

		$webOption = new WebOptionsType();
		$webOption->cancelUrl = $cancelURL;
		$webOption->cancelUrlDescription = $_REQUEST['returnURLDescription'];
		$webOption->returnUrl = $returnURL;
		$webOption->returnUrlDescription = $_REQUEST['cancelURLDescription'];
		$addPaymentCard->webOptions = $webOption;
	}


	$service  = new AdaptiveAccountsService();
	$response = $service->AddPaymentCard($addPaymentCard);

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

	}

}
catch(Exception $ex) {
	throw new Exception('Error occurred in AddPaymentCard method');
}

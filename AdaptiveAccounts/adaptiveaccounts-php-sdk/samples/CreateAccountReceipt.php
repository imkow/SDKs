<?php

/********************************************
 CreateAccountReceipt.php
 Calls CreateAccount API of CreateAccounts webservices.

 Called by CreateAccount.php
 Calls  AdaptiveAccounts.php,and APIError.php.
 ********************************************/
$path = '../lib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
require_once('services/AdaptiveAccounts/AdaptiveAccountsService.php');
require_once('PPLoggingManager.php');
require_once('Common/Constants.php');
session_start();
$logger = new PPLoggingManager('CreateAccount');
try {
	$serverName = $_SERVER['SERVER_NAME'];
	$serverPort = $_SERVER['SERVER_PORT'];
	$url=dirname('http://'.$serverName.':'.$serverPort.$_SERVER['REQUEST_URI']);
	$returnURL = $url."/Common/WebflowReturnPage.php";
	$cancelURL = $url. "/CreateAccount.php" ;

	$preferredLanguageCode = 'en_US';
	$registrationType = 'WEB';

	if($_REQUEST['accountType']=="BUSINESS")
	{

		$businessInfobusinessName = $_REQUEST['businessName'];
		$businessInfobusinessAddressline1 = $_REQUEST['businessAddress1'];
		$businessInfobusinessAddressline2 = $_REQUEST['businessAddress2'];
		$businessInfobusinessAddresscity = $_REQUEST['businessCity'];
		$businessInfobusinessAddressstate = $_REQUEST['businessState'];
		$businessInfobusinessAddresspostalCode = $_REQUEST['businessZip'];
		$businessInfobusinessAddresscountryCode = $_REQUEST['businessCountry'];
		$businessInfoworkPhone = $_REQUEST['businessPhone'];
		$businessInfocategory = $_REQUEST['businessCategory'];
		$businessInfosubCategory = $_REQUEST['businessSubCategory'];
		$businessInfocustomerServicePhone = $_REQUEST['businessCustomerServicePhone'];
		$businessInfocustomerServiceEmail = $_REQUEST['businessCustomerServiceEmail'];
		$businessInfowebSite = $_REQUEST['businessWeb'];
		$businessInfodateOfEstablishment = $_REQUEST['dateOfEstablishment'];
		$businessInfobusinessType = $_REQUEST['businessType'];
		$businessInfoaveragePrice = $_REQUEST['avgPrice'];
		$businessInfoaverageMonthlyVolume = $_REQUEST['averageMonthlyVolume'];
		$businessInfopercentageRevenueFromOnline = $_REQUEST['percentageRevenueFromOnline'];
		$businessInfosalesVenue = $_REQUEST['salesVenue'];
			
			
	}
	$requestEnvelope = new RequestEnvelope();
	$requestEnvelope->errorLanguage = "en_US";

	$name = new NameType();
	$name->salutation = $_REQUEST['salutation'];
	$name->firstName = $_REQUEST['firstName'];
	$name->middleName = $_REQUEST['middleName'];
	$name->lastName = $_REQUEST['lastName'];

	$address = new AddressType();
	$address->line1 =  $_REQUEST['address1'];
	$address->line2 =$_REQUEST['address2'];
	$address->city = $_REQUEST['city'];
	$address->state =  $_REQUEST['state'];
	$address->postalCode= $_REQUEST['postalCode'];
	$address->countryCode =  $_REQUEST['countryCode'];

	$createAccountWebOptions = new CreateAccountWebOptionsType();
	$createAccountWebOptions->returnUrl = $returnURL;

	$createAccountRequest = new CreateAccountRequest($requestEnvelope, $name, $address, $preferredLanguageCode);
	$createAccountRequest->accountType = $_REQUEST['accountType'];
	$createAccountRequest->dateOfBirth =  $_REQUEST['dateOfBirth'];
	$createAccountRequest->notificationURL = $_REQUEST['notificationUrl'];
	$createAccountRequest->citizenshipCountryCode = $_REQUEST['citizenshipCountryCode'];
	$createAccountRequest->contactPhoneNumber = $_REQUEST['contactPhoneNumber'];
	$createAccountRequest->registrationType = $registrationType;
	$createAccountRequest->currencyCode = $_REQUEST['currencyCode'];;
	$createAccountRequest->emailAddress = $_REQUEST['newemail'];
	$createAccountRequest->createAccountWebOptions =  $createAccountWebOptions;

	$adaptiveAccounts  = new AdaptiveAccountsService();
	$response = $adaptiveAccounts->CreateAccount($createAccountRequest);
	//$logger->log("Received CreateAccount Response:");

	$ack = strtoupper($response->responseEnvelope->ack);

	if($ack!="SUCCESS"){
		$_SESSION['reshash']=$response;
		$location = "APIError.php";
		header("Location: $location");
	}
	else
	{

		$payPalURL = $response->redirectURL;
		echo" <a href=$payPalURL><b>* Redirect URL to Complete Account Creation </b></a><br>";

	}
}
catch(Exception $ex) {
	throw new Exception('Error occurred in PayReceipt method');
}

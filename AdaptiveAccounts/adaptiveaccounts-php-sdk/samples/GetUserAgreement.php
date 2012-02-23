<?php
$path = '../lib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
require_once('services/AdaptiveAccounts/AdaptiveAccountsService.php');
require_once('PPLoggingManager.php');
require_once('Common/Constants.php');
session_start();

$logger = new PPLoggingManager('GetUserAgreement');
try {
	
	$getUserAgreement = new GetUserAgreementRequest();
	$getUserAgreement->countryCode  = $_REQUEST['countryCode'];
	$getUserAgreement->createAccountKey = $_REQUEST['createAccountKey'];
	$getUserAgreement->languageCode = $_REQUEST['languageCode'];

	$service  = new AdaptiveAccountsService();
	$response = $service->GetUserAgreement($getUserAgreement);

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
	throw new Exception('Error occurred in GetUserAgreement method');
}
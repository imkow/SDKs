<?php
$path = '../lib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
require_once('services/AdaptiveAccounts/AdaptiveAccountsService.php');
require_once('PPLoggingManager.php');
require_once('Common/Constants.php');
session_start();

$logger = new PPLoggingManager('SetFundingSourceConfirmed');
try {

	$setFundingSourceConfirmed = new SetFundingSourceConfirmedRequest();
	$setFundingSourceConfirmed->accountId = $_REQUEST['accountId'];
	$setFundingSourceConfirmed->emailAddress = $_REQUEST['emailAddress'];
	$setFundingSourceConfirmed->fundingSourceKey = $_REQUEST['fundingSourceKey'];

	$service  = new AdaptiveAccountsService();
	$response = $service->SetFundingSourceConfirmed($setFundingSourceConfirmed);

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
	throw new Exception('Error occurred in SetFundingSourceConfirmed method');
}
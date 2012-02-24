<?php
$path = '../lib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
require_once('services/AdaptiveAccounts/AdaptiveAccountsService.php');
require_once('PPLoggingManager.php');
require_once('Common/Constants.php');
session_start();

$logger = new PPLoggingManager('GetVerifiedStatus');
try {

	$getVerifiedStatus = new GetVerifiedStatusRequest();
	$getVerifiedStatus->emailAddress = $_REQUEST['emailAddress'];
	$getVerifiedStatus->firstName = $_REQUEST['firstName'];
	$getVerifiedStatus->lastName = $_REQUEST['lastName'];
	$getVerifiedStatus->matchCriteria = $_REQUEST['matchCriteria'];
	$service  = new AdaptiveAccountsService();
	$response = $service->GetVerifiedStatus($getVerifiedStatus);

	$ack = strtoupper($response->responseEnvelope->ack);

	if($ack != "SUCCESS"){
		echo "<b>Error </b>";
		echo "<pre>";
		print_r($response);
		echo "</pre>";
		require_once 'Common/Response.php';
	}
	else
	{

		echo "<pre>";
		print_r($response);
		echo "</pre>";

	}

}
catch(Exception $ex) {
	throw new Exception('Error occurred in GetVerifiedStatus method');
}
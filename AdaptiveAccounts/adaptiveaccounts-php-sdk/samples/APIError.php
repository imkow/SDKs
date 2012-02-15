<?php
/**
 *
 * APIError.php - Displays error parameters.
 *
 **************************************************/
$path = '../lib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
require_once('services/AdaptiveAccounts/AdaptiveAccountsService.php');
session_start();

$response = $_SESSION['reshash'];
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>PayPal API Error</title>
<link href="Common/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="wrapper">
	<?php
	require_once 'Common/menu.html';?>
		<div id="response_form">
			<h3>
				<b>The PayPal API has returned an error!</b>
			</h3>			
			<?php  //it will print if any URL errors
			if(isset($_SESSION['curl_error_no'])) {
				$errorCode = $_SESSION['curl_error_no'] ;
				$errorMessage = $_SESSION['curl_error_msg'] ;
				session_unset();
			?>
			<table width="280">
				<tr>
					<td class="thinfield">Error Number:</td>
					<td><?php $errorCode ?></td>
				</tr>
				<tr>
					<td>Error Message:</td>
					<td><?php $errorMessage ?></td>
				</tr>
			</table>	
<?php } else {
?>
	<font size=2 color=black face=Verdana><b></b></font>
	<b> PayPal API Error</b>	
    <table width="400">
	<?php    
    	var_dump($response);
    ?>
    </table>	
<?php 
}// end else
?>
		</div>
	</div>
</body>
</html>
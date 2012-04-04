<!DOCTYPE html>

<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
	<meta charset="utf-8" />

	<!-- Set the viewport width to device width for mobile -->
	<meta name="viewport" content="width=device-width" />

	<title>PayPal Adaptive Payments SDK for ColdFusion</title>
  
	<!-- Included CSS Files -->
	<link rel="stylesheet" href="assets/stylesheets/foundation.css">
	<link rel="stylesheet" href="assets/stylesheets/app.css">

	<!--[if lt IE 9]>
		<link rel="stylesheet" href="stylesheets/ie.css">
	<![endif]-->


	<!-- IE Fix for HTML5 Tags -->
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	

<script type="text/javascript" src="Common/sdk_functions.js"></script>
<script src="assets/javascripts/jquery-1.7.1.min.js"></script>

</head>
<body>

<div class="container">

	<div class="row">
		<div class="twelve columns">
			<h2>Adaptive Payments SDK - ColdFusion</h2>

			<cfinclude template="menu.cfm" >
			
			<h4>About</h4>
			<p>
            This SDK includes a ColdFusion component library for making API calls to PayPal Adaptive Payments API.  The Adaptive Payments API allows merchants and developers to pay almost anyone and set up automated payments. They can create applications that manage payments, payment preapprovals, and refunds. They can also send money peer-to-peer, split payments in both parallel and chained models. 
</p>

<h4>Integration</h4>
<p>
The sample code contained in this project contains documentation, sample code for each method along with configuration information. This project contains several files and directories that are required for integration:
</p>
<ul>
<li><b>com/paypal/adaptivepayments/lib/ </b>- contains the ColdFusion components that represent all the PayPal objects needed to make PayPal API requests and parse the corresponding responses.</li>

<li><b>com/paypal/service/service.cfc</b> - The component contains the method for making HTTP calls to PayPal servers with the appropriate headers information (i.e. credentials, appid, request and response format).
</li>

<li><b>com/paypal/service/adaptivepayments.cfc </b>- The component contains the methods for making each of the PayPal specific API calls.  The methods include pay, paymentdetails, preapproval, preapprovaldetails, cancelpreapproval, setpaymentoptions, getpaymentoptions, executepayment,refund, and convertcurrency.  Each method contains both required and optional arguments and will intelligently build your payload based on which arguments are passed.  Any arguments that accept multiple options, for example receiverEmail, should pass in a comma-separated list.
</li>

<li><b>samples/Application.cfc</b>  - The Application.cfc contains the customtag path for the com directory, it will run fine out of the box, but may need to be updated based on where your store your components.  You'll also find the API credentials and APP-ID in this file.  You can create an account at developer.paypal.com to create your own sandbox credentials for testing.
</li>

<li><b>samples/</b> - location for all the sample API calls and docs</li>
</ul>			
			<b>Use the menu above to see the code run, source code and configuration information</b>
		</div>
	</div>
			
</div>

<!-- Included JS Files -->
<script src="assets/javascripts/foundation.js"></script>
<script src="assets/javascripts/app.js"></script>
	

</body>
</html>


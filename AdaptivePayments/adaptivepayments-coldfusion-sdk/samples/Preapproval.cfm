<cfif isDefined('url.seeit')>
	
	<cfinvoke component="adaptivepayments" method="preapprovalRequest" returnvariable="response">
		<cfinvokeargument name="returnURL" value="#request.serverURL##GetDirectoryFromPath(SCRIPT_NAME)#WebflowReturnPage.cfm">
		<cfinvokeargument name="cancelURL" value="#request.serverURL##GetDirectoryFromPath(SCRIPT_NAME)#Preapproval.cfm">
		<cfinvokeargument name="senderEmail" value="html5_1319498027_per@x.com">
		<cfinvokeargument name="startingDate" value="#DateFormat(DateAdd("s",60,now()),'YYYY-MM-DD')#">
		<cfinvokeargument name="currencyCode" value="USD">
		<cfinvokeargument name="maxTotalAmountOfAllPayments" value="100">
		<cfinvokeargument name="displayMaxTotalAmount" value="true">
		<cfinvokeargument name="memo" value="Max Amount: $100">
		
	</cfinvoke>

</cfif>


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
			
			<h4>Preapproval</h4>
			<dl class="tabs  contained">
				<dd><a href="#overview" class="active">Overview</a></dd>
				<dd><a href="#simple1">See It</a></dd>
				<dd><a href="#simple2">Source Code</a></dd>
				<dd><a href="#simple3">Configuration</a></dd>
			</dl>

			<ul class="tabs-content contained">
				<li class="active" id="overviewTab">
					<h3>Overview</h3>
					
					<p>
					Preapproved payments require the sender to log in to paypal.com to set up the payment agreement with a particular vendor. You control the interaction between your application and PayPal by specifying URLs for redirection in various situations.
					</p>
					<p>
					The sender logs in to paypal.com and sets up the preapproval, which includes setting the following information:
					</p>
					<p>
					<ul>
					<li>duration of the preapproval, from the start date to the end date, inclusive</li>
					<li>the maximum amount being preapproved</li>
					<li>the maximum number of payments</li>
					<li>The following diagram shows the basic flow of control during a preapproval operation:</li>
					</ul>
						<img src="assets/paypal-images/AdapPymntSrvcFlow_B.gif">	
					</p>
					<p>
					The following items correspond to the circled numbers in the diagram:
					</p>
					<p>
					
					<ol>
					<li>Your site or device sends a Preapproval request to PayPal on behalf of a sender.</li>
					<li>PayPal responds with a key, called a preapproval key, that you use when you direct the sender to PayPal, and once the preapproval has been established, whenever you automatically complete a payment on behalf of the sender.</li>
					<li>You redirect your sender's browser to PayPal.</li>
					<li>After the sender logs in to paypal.com and sets up the preapproval, PayPal redirects the sender's browser to a location you specify.</li>
					</ol>
					</p>
					<p>
					<b>NOTE:</b><br>
					The cancel operation is not shown in the above diagram. Cancellation is handled by a separate cancellation URL to which PayPal redirects the sender's browser any time the sender cancels while on paypal.com.
					</p>
					<p>
					
					In addition to the steps shown above, PayPal sends an email notifying you and the sender that the preapproval has been created.
					</p>
					<p>
					After the sender sets up the approval, you can make payments on the sender's behalf directly. The sender is no longer required to log in to PayPal to complete the payment. The following diagram shows the basic flow of control during a Pay operation:
					</p>
					<p>
					
					<img src="assets/paypal-images/AdapPymntSrvcFlow_C.gif">	
					</p>
					<p>
					The following items correspond to the circled numbers in the diagram:
					</p>
					<p>
					
					<ol>
					<li>Your site or device sends a Pay request to PayPal on behalf of a sender. You can require the sender to provide a personal identification number (PIN); however, logging in to paypal.com is no longer required.</li>
					NOTE:You must provide a preapproval key that identifies the agreement.
					
					<li>PayPal still responds with a payment key that you can use for other API operations, such as for obtaining details of the payment or for issuing a refund.</li>
					</ol>
					</p>
				
				</li>
			
				<li  id="simple1Tab">
					<h3>See It</h3>
				
					<p>
						We've built a simple interface for our SDK.  You create an instance of the adaptivepayment.cfc.  Then 
						 call the <em>PreapprovalRequest</em> method and pass the arguments listed below.  Click the <em>SEE IT</em> button below 
						 to make an API call and see the JSON request and response from our APIs.  The JSON response is deserialized into a  object.
						 The object contains getter methods you can call to retrieve data.  You also have 
						 the option to convert the data in your object to a structure by calling the getStruct() method.
					</p>
						<table>
							<thead>
								<tr>
									<th>Name</th>
									<th>Value</th>
								</tr>
							</thead>
							<tbody>
								<cfoutput>
								<tr>
									<td><label>returnURL</label></td>
									<td>#request.serverURL##GetDirectoryFromPath(SCRIPT_NAME)#WebflowReturnPage.cfm</td>
								</tr>
								<tr>
									<td><label>cancelURL</label></td>
									<td>#request.serverURL##GetDirectoryFromPath(SCRIPT_NAME)#SimplePay.cfm</td>
								</tr>
								
								<tr>
									<td><label>senderEmail</label></td>
									<td>platfo_1255077030_biz@gmail.com</td>
								</tr>
							
								<tr>
									<td>currencyCode</td>
									<td>USD</td>
								</tr>
								
								<tr>
									<td>startDate</td>
									<td>#DateFormat(DateAdd("d",1,now()),'YYYY-MM-DD')#</td>
								</tr>
								</cfoutput>
							
							</tbody>
						</table>
					
					<cfif NOT isDefined('url.seeit')>
						<p><a href="Preapproval.cfm?seeit=true#simple1" class="nice radius blue button large" name="seeit"  id="seeit">See It</a></p>
					</cfif>

					<cfif isDefined('url.seeit')>
						<hr>
						<h4>JSON Request</h4>
						<script src="https://gist.github.com/1714091.js?file=gistfile1.json"></script>
						
						
						<h4>JSON Response</h4>
						<script src="https://gist.github.com/1714097.js?file=gistfile1.json"></script>
						
						<h4>Response Methods</h4>
						<cfoutput>
						<table>
							<thead>
								<tr>
									<th>Name</th>
									<th>Value</th>
								</tr>
							</thead>
							<tbody>
							
								<tr>
									<td><label>response.getPreapprovalKey()</label></td>
									<td>#response.getPreapprovalKey()#</td>
								</tr>
								
								<tr>
									<td><label>response.getResponseEnvelope().getAck().getAckCode()</label></td>
									<td>#response.getResponseEnvelope().getAck().getAckCode()#</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getBuild()</label></td>
									<td>#response.getResponseEnvelope().getBuild()#</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getCorrelationId()</label></td>
									<td>#response.getResponseEnvelope().getCorrelationId()#</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getTimestamp()</label></td>
									<td>#response.getResponseEnvelope().getTimestamp()#</td>
								</tr>
							
							</tbody>
						</table>
						
						
						<h4>How to build your redirect URL</h4>
						
						<table>
							<thead>
								<tr>
									<th>code</th>
									<th>request.paypalStruct['PAYPAL-REDIRECT-URL'] & _ap-preapproval&preapprovalkey= ' & response.getPreapprovalKey()</th>
								</tr>
							</thead>
							<tbody>
							
								<tr>
									<td>output</td>
									<td><cfoutput>#request.paypalStruct['PAYPAL-REDIRECT-URL']#_ap-preapproval&preapprovalkey=#response.getPreapprovalKey()#</cfoutput></td>
								</tr>
								</tbody>
						</table>
						</cfoutput>
						<p>
						<cfoutput>
							<cfset payPalURL = request.paypalStruct['PAYPAL-REDIRECT-URL'] & '_ap-preapproval&preapprovalkey=#response.getPreapprovalKey()#'>
							Test out the <a href="#payPalURL#"  class="nice radius blue button" target="_blank"><b>Redirect To PayPal </b></a><br>
						</cfoutput>
						</p>
						
						
						<h4>getStruct() Method</h4>
						
						<table>
							<thead>
								<tr>
									<th>response.getStruct()</th>
									<td><p><cfdump var="#response.getStruct()#"></p></td>
								</tr>
							</thead>
						</table>
						
						
					</cfif>
				</li>
				<li id="simple2Tab">
					
					<h4>ColdFusion Request code</h4>
					<script src="https://gist.github.com/1714218.js?file=gistfile1.cfm"></script>
					
					<h4>ColdFusion Response code</h4>
					<script src="https://gist.github.com/1714210.js?file=gistfile1.cfm"></script>
	
				</li>
				<li id="simple3Tab">
				
					<cfinclude template="config.cfm" >

				</li>
				
			</ul>
			
		</div>
	</div>
			
</div>

<!-- Included JS Files -->
<script src="assets/javascripts/foundation.js"></script>
<script src="assets/javascripts/app.js"></script>
	

</body>
</html>

<cfif isDefined('url.seeit')>
	
	<cfinvoke component="adaptivepayments" method="paymentDetailsRequest" returnvariable="response">
		<cfinvokeargument name="payKey" value="AP-9RA521127B143051X">
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
			
			<h4>Payment Details</h4>
			<dl class="tabs  contained">
				<dd><a href="#overview" class="active">Overview</a></dd>
				<dd><a href="#seeit">See It</a></dd>
				<dd><a href="#source">Source Code</a></dd>
				<dd><a href="#config">Configuration</a></dd>
			</dl>

			<ul class="tabs-content contained">
				<li class="active" id="overviewTab">
					<h3>Overview</h3>
					
					<p>
					Use the PaymentDetails API operation to obtain information about a payment. You can identify the 
					payment by your tracking ID, the PayPal transaction ID in an IPN message, 
					or the pay key associated with the payment.
					</p>
					<p>
					The PaymentDetailsRequest message contains the identifier used to retrieve information about the payment.	
					</p>
					
				</li>
			
				<li  id="seeitTab">
					<h3>See It</h3>
				
					<p>
						We've built a simple interface for our SDK.  You create an instance of the adaptivepayment.cfc.  Then 
						 call the <em>PaymentDetails</em> method and pass the arguments listed below.  Click the <em>SEE IT</em> button below 
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
			
								<tr>
									<td><label>payKey</label></td>
									<td>AP-9RA521127B143051X</td>
								</tr>
								
							</tbody>
						</table>
					
					<cfif NOT isDefined('url.seeit')>
						<p><a href="PaymentDetails.cfm?seeit=true#seeit" class="nice radius blue button large" name="seeit"  id="seeit">See It</a></p>
					</cfif>

					<cfif isDefined('url.seeit')>
						<hr>
						<h4>JSON Request</h4>
						<script src="https://gist.github.com/1707383.js?file=gistfile1.json"></script>
							
				
						<h4>JSON Response</h4>
						<script src="https://gist.github.com/1707402.js?file=gistfile1.json"></script>
				
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
									<td>response.getActionType()</td>
									<td>#response.getActionType()#</td>
								</tr>
								<tr>
									<td>response.getCancelUrl()</td>
									<td>#response.getCancelUrl()#</td>
								</tr>
								<tr>
									<td>response.getCurrencyCode()</td>
									<td>#response.getCurrencyCode()#</td>
								</tr>
								<tr>
									<td>response.getFeesPayer()</td>
									<td>#response.getFeesPayer()#</td>
								</tr>
								<tr>
									<td>response.getPayKey()</td>
									<td>#response.getPayKey()#</td>
								</tr>
								
								<tr>
									<td>response.getPaymentInfoList().getPaymentInfo().getReceiver().getPrimary()</td>
									<td>#response.getPaymentInfoList().getPaymentInfo().getReceiver().getPrimary()#</td>
								</tr>
								<tr>
									<td>response.getPaymentInfoList().getPaymentInfo().getReceiver().getAmount()</td>
									<td>#response.getPaymentInfoList().getPaymentInfo().getReceiver().getAmount()#</td>
								</tr>
								<tr>
									<td>response.getPaymentInfoList().getPaymentInfo().getReceiver().getPaymentType()</td>
									<td>#response.getPaymentInfoList().getPaymentInfo().getReceiver().getPaymentType()#</td>
								</tr>
								<tr>
									<td>response.getPaymentInfoList().getPaymentInfo().getReceiver().getEmail()</td>
									<td>#response.getPaymentInfoList().getPaymentInfo().getReceiver().getEmail()#</td>
								</tr>
									
								<tr>
									<td>response.getPaymentInfoList().getPaymentInfo().getPendingRefund()</td>
									<td>#response.getPaymentInfoList().getPaymentInfo().getPendingRefund()#</td>
								</tr>
								
								<tr>
									<td>response.getResponseEnvelope().getAck().getAckCode()</td>
									<td>#response.getResponseEnvelope().getAck().getAckCode()#</td>
								</tr>
								
								<tr>
									<td>response.getResponseEnvelope().getBuild()</td>
									<td>#response.getResponseEnvelope().getBuild()#</td>
								</tr>
								
								<tr>
									<td>response.getResponseEnvelope().getCorrelationId()</td>
									<td>#response.getResponseEnvelope().getCorrelationId()#</td>
								</tr>
								
								<tr>
									<td>response.getResponseEnvelope().getTimestamp()</td>
									<td>#response.getResponseEnvelope().getTimestamp()#</td>
								</tr>
								
								<tr>
									<td>response.getResponseEnvelope().getTimestamp()</td>
									<td>#response.getResponseEnvelope().getTimestamp()#</td>
								</tr>
								
								<tr>
									<td>response.getReturnUrl()</td>
									<td>#response.getReturnUrl()#</td>
								</tr>
								
								<tr>
									<td>response.getReverseAllParallelPaymentsOnError()</td>
									<td>#response.getReverseAllParallelPaymentsOnError()#</td>
								</tr>
								
								<tr>
									<td>response.getSender().getUseCredentials()</td>
									<td>#response.getSender().getUseCredentials()#</td>
								</tr>
								
								<tr>
									<td>response.getStatus()</td>
									<td>#response.getStatus()#</td>
								</tr>
							</tbody>
						</table>
						
						</cfoutput>
						
						
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
				<li id="sourceTab">
					
					<h4>ColdFusion Request code</h4>
					<script src="https://gist.github.com/1707476.js?file=gistfile1.cfm"></script>
	
				</li>
				<li id="configTab">
				
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

<cfif isDefined('url.seeit')>
	

	<!---
	<cfinvoke component="adaptivepayments" method="payRequest" returnvariable="response">
		<cfinvokeargument name="returnURL" value="#request.serverURL##GetDirectoryFromPath(SCRIPT_NAME)#WebflowReturnPage.cfm">
		<cfinvokeargument name="cancelURL" value="#request.serverURL##GetDirectoryFromPath(SCRIPT_NAME)#DelayedPayment.cfm">
		<cfinvokeargument name="senderEmail" value="html5_1319498027_per@x.com">
		<cfinvokeargument name="receiverAmount" value="20.00,19.00">
		<cfinvokeargument name="receiverEmail" value="platfo_1255612361_per@gmail.com,max_1317246900_per@x.com">
		<cfinvokeargument name="receiverPrimary" value="true,false">
		<cfinvokeargument name="actionType" value="PAY_PRIMARY">
		<cfinvokeargument name="currencyCode" value="USD">
		<cfinvokeargument name="returnObj" value="payload">
	</cfinvoke>
	
	<cfinvoke component="adaptivepayments" method="executePaymentRequest" returnvariable="response">
		<cfinvokeargument name="payKey" value="AP-9RD3501282045003B">
	</cfinvoke>
	--->
	
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
			
			<h4>Delayed Payment</h4>
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
					Delayed payments enable a developer to create a chained payment where the primary receiver collects 100% of the transaction
					and delays the transfer of payment to the secondary receivers.  The developer can delay payment for up to 90 days.  When the 
					developer is ready they can make an ExecutePayment method call to pay the secondary receivers.
					
					</p><p>
					Scenarios involving delayed payments might include the following scenarios:
					</p>
					<ul>
					<li>Buyer makes a purchase on a marketplace website, but payment to secondary receivers is only made after the item as shipped.</li>
					</ul>
					<p>
					
				</li>
			
				<li  id="seeitTab">
					<h3>See It</h3>
				
					<p>
						Delayed payments are a multi-step process. 
					</p>
					<p>
						First, you'll create a chained payment and  and redirect the buyer to PayPal to login and complete the payment.  During this 
						process, you'll want to save the payKey that is created.  The big difference with this chained payment is you'll
						specify the <b>ACTIONTYPE equal to PAY_PRIMARY</b>.  The primary will get paid the full amount of the transaction. 
					</p>
					<p>
						Second, you'll call Execute Payment within the next 90 days and pass in the payKey.  This will execute payment for each of the secondary 
						receivers.
					</p>
					<p>
						Note, since this is a 2 step process involving having to login to PayPal AND the payKey and only be 
						executed ONCE, when you click the <em>SEE IT</em> button below, <b>all the responses displayed are from 
						previous API calls done when this documentation was created</b>.
					
					</p>
					<p>
						 The JSON response is deserialized into a  object.
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
									<td>#request.serverURL##GetDirectoryFromPath(SCRIPT_NAME)#ChainedPay.cfm</td>
								</tr>
								</cfoutput>
								<tr>
									<td><label>senderEmail</label></td>
									<td>html5_1319498027_per@x.com</td>
								</tr>
								<tr>
									<td>receiverEmail</td>
									<td>platfo_1255612361_per@gmail.com, max_1317246900_per@x.com</td>
								</tr>
								<tr>
									<td>receiverAmount</td>
									<td>20.00, 19.00</td>
								</tr>
								
								<tr>
									<td>primaryReceiver</td>
									<td>true, false</td>
								</tr>
								
								<tr>
									<td>actionType</td>
									<td>PAY_PRIMARY</td>
								</tr>
								<tr>
									<td>currencyCode</td>
									<td>USD</td>
								</tr>
							
							</tbody>
						</table>
					
					<cfif NOT isDefined('url.seeit')>
						<p><a href="DelayedPayment.cfm?seeit=true#seeit" class="nice radius blue button large" name="seeit"  id="seeit">See It</a></p>
					</cfif>

					<cfif isDefined('url.seeit')>
						
						<hr>
						<h4>STEP 1 - JSON Request</h4>
						<script src="https://gist.github.com/1773064.js?file=gistfile1.json"></script>
						
						<h4>STEP 1 - JSON Response</h4>
						<script src="https://gist.github.com/1773103.js?file=gistfile1.json"></script>
					
						 <h4>STEP 2 - JSON Request</h4>
						 <script src="https://gist.github.com/1773131.js?file=gistfile1.json"></script>
						 
						 <h4>STEP 2 - JSON Response</h4>
						 <script src="https://gist.github.com/1773149.js?file=gistfile1.json"></script>
						 
						<h4>Chained Payment Response Methods</h4>
						
						<table>
							<thead>
								<tr>
									<th>Name</th>
									<th>Value</th>
								</tr>
							</thead>
							<tbody>
							
								<tr>
									<td><label>response.getPayKey()</label></td>
									<td>AP-9RD3501282045003B</td>
								</tr>
								<tr>
									<td><label>response.getPaymentExecStatus()</label></td>
									<td>CREATED</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getAck().getAckCode()</label></td>
									<td>Success</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getBuild()</label></td>
									<td>2486531</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getCorrelationId()</label></td>
									<td>f3b31e8c3b47b</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getTimestamp()</label></td>
									<td>2012-02-27T15:50:22.677-08:00</td>
								</tr>
								
								
							</tbody>
						</table>
						
						
						<h4>Execute Payment Response Methods</h4>
						
						<table>
							<thead>
								<tr>
									<th>Name</th>
									<th>Value</th>
								</tr>
							</thead>
							<tbody>
							
							
								<tr>
									<td><label>response.getPaymentExecStatus()</label></td>
									<td>COMPLETED</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getAck().getAckCode()</label></td>
									<td>Success</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getBuild()</label></td>
									<td>2486531</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getCorrelationId()</label></td>
									<td>3862b185a3d15</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().getTimestamp()</label></td>
									<td>2012-02-27T15:59:46.982-08:00</td>
								</tr>
								
								
							</tbody>
						</table>
					
	
	

						
						
					</cfif>
				</li>
				<li id="sourceTab">
					
					<h4>ColdFusion Request code</h4>
					<script src="https://gist.github.com/1773280.js?file=gistfile1.cfm"></script>
					
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

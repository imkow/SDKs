<cfif isDefined('url.seeit')>
	
	<cfinvoke component="adaptivepayments" method="payRequest" returnvariable="response">
		<cfinvokeargument name="returnURL" value="#request.serverURL##GetDirectoryFromPath(SCRIPT_NAME)#WebflowReturnPage.cfm">
		<cfinvokeargument name="cancelURL" value="#request.serverURL##GetDirectoryFromPath(SCRIPT_NAME)#SimplePay.cfm">
		<cfinvokeargument name="senderEmail" value="platfo_1255612361_per@gmail.com">
		<cfinvokeargument name="receiverAmount" value="600.00">
		<cfinvokeargument name="receiverEmail" value="max_1317246900_per@x.com">
		<cfinvokeargument name="actionType" value="PAY">
		<cfinvokeargument name="currencyCode" value="USD">
	</cfinvoke>
	<cfset paykey = "#response.getPayKey()#">
	<cfinvoke component="adaptivepayments" method="setPaymentOptionsRequest" returnvariable="response">
		<cfinvokeargument name="payKey" value="#response.getPayKey()#">
		<cfinvokeargument name="senderRequireShippingAddressSelection" value="true">
		<cfinvokeargument name="BusinessName" value="ACME Corp">
		<cfinvokeargument name="emailAccountIdentifier" value="max_1317246900_per@x.com"> 
		<cfinvokeargument name="nameInvoiceItem" value="iPad,iPhone"> 
		<cfinvokeargument name="priceInvoiceItem" value="400.00,200.00"> 
	</cfinvoke>


</cfif>
<!---
<cfoutput>
<script>
var myJSON = JSON.stringify(#response#, null, 4);
document.write(myJSON);
</script>
</cfoutput>
--->
						
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
			
			<h4>Set Payment Option</h4>
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
						You use the SetPaymentOptions API operation to specify settings for a payment of the actionType CREATE. This actionType is specified in the PayRequest message.
					</p>
		
					
				</li>
			
				<li  id="seeitTab">
					<h3>See It</h3>
				
				
					<p>
						We've built a simple interface for our SDK.  You create an instance of the adaptivepayment.cfc.  Then 
						 call the <em>SetPaymentOptionRequest</em> method and pass the arguments listed below.  Click the <em>SEE IT</em> button below 
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
									<td>payKey</td>
									<td>AP-06S18396CS9933906</td>
								</tr>
								
								<tr>
									<td>emailAccountIdentifier</td>
									<td>max_1317246900_per@x.com</td>
								</tr>
								
								<tr>
									<td>priceInvoiceItem</td>
									<td>499.00,299.00</td>
								</tr>
								
								<tr>
									<td>nameInvoiceItem</td>
									<td>iPad,iPhone</td>
								</tr>
								
								<tr>
									<td>RequireShippingAddressSelection</td>
									<td>true</td>
								</tr>
								
								<tr>
									<td>BusinessName</td>
									<td>ACME Corp</td>
								</tr>
								
								<tr>
									<td>referrerCode</td>
									<td>12345</td>
								</tr>
								
								
							</tbody>
						</table>
					
					<cfif NOT isDefined('url.seeit')>
						<p><a href="SetPaymentOption.cfm?seeit=true#seeit" class="nice radius blue button large" name="seeit"  id="seeit">See It</a></p>
					</cfif>

					<cfif isDefined('url.seeit')>
						<hr>
						<h4>JSON Request</h4>
						<script src="https://gist.github.com/1726544.js?file=gistfile1.json"></script>
				
						<h4>JSON Response</h4>
						<script src="https://gist.github.com/1726576.js?file=gistfile1.json"></script>
					
						 
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
									<td><label>response.getResponseEnvelope().getAck().getAckCode()</label></td>
									<td>#response.getResponseEnvelope().getAck().getAckCode()#</td>
								</tr>
								<tr>
									<td><label>response.getResponseEnvelope().g	etBuild()</label></td>
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
					<script src="https://gist.github.com/1726607.js?file=gistfile1.cfm"></script>
					
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

<cfif isDefined('url.seeit')>
	
	<cfinvoke component="adaptivepayments" method="refundRequest" returnvariable="response">
		<cfinvokeargument name="receiverAmount" value="1.00">
		<cfinvokeargument name="receiverEmail" value="platfo_1255612361_per@gmail.com">
		<cfinvokeargument name="payKey" value="AP-7V796008YN405901T">
		<cfinvokeargument name="currencyCode" value="USD">		
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
			
			<h4>Refund Payment</h4>
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
						Use the Refund API operation to refund all or part of a payment. You can specify the amount of the refund 
						and identify the accounts to receive the refund by the payment key or tracking ID, and optionally, by 
						transaction ID or the receivers of the original payment.
					</p>
					<p>
						PayPal supports refunds made manually, via the PayPal account interface, or by means of the RefundTransaction API. 
						The terms sender and receiver refer to sender and receivers of the original payment using the Pay API operation. 
						
						When making a refund, the sender's account receives the refund and the receivers' accounts are the source of 
						the refund. Refunds are made from one or more receivers to a sender.
					</p>
					
				</li>
			
				<li  id="simple1Tab">
					<h3>See It</h3>
				
				
					<p>
						We've built a simple interface for our SDK.  You create an instance of the adaptivepayment.cfc.  Then 
						 call the <em>RefundRequest</em> method and pass the arguments listed below.  Click the <em>SEE IT</em> button below 
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
									<td>receiverEmail</td>
									<td>platfo_1255612361_per@gmail.com</td>
								</tr>
								<tr>
									<td>receiverAmount</td>
									<td>1.00</td>
								</tr>
							
								<tr>
									<td>payKey</td>
									<td>AP-7V796008YN405901T</td>
								</tr>
								<tr>
									<td>currencyCode</td>
									<td>USD</td>
								</tr>
							
							</tbody>
						</table>
					
					<cfif NOT isDefined('url.seeit')>
						<p><a href="Refund.cfm?seeit=true#simple1" class="nice radius blue button large" name="seeit"  id="seeit">See It</a></p>
					</cfif>

					<cfif isDefined('url.seeit')>
						<hr>
						<h4>JSON Request</h4>
						<script src="https://gist.github.com/1775573.js?file=gistfile1.json"></script>
						
						<!---<cfoutput>
							<script>
							var myJSON = JSON.stringify(#response#, null, 4);
							document.write(myJSON);
							</script>
						</cfoutput>--->	
						 
						<h4>JSON Response</h4>
						<script src="https://gist.github.com/1775592.js?file=gistfile1.json"></script>
						
						
						<h4>Response Methods </h4>
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
									<td><label>response.getCurrencyCode()</label></td>
									<td>#response.getCurrencyCode()#</td>
								</tr>
								<tr>
									<td><label>response.getRefundInfoList().getItems()[1]['receiver']['amount']</label></td>
									<td>#response.getRefundInfoList().getItems()[1]['receiver']['amount']#</td>
								</tr>
								<tr>
									<td><label>response.getRefundInfoList().getItems()[1]['receiver']['email']</label></td>
									<td>#response.getRefundInfoList().getItems()[1]['receiver']['email']#</td>
								</tr>
								<tr>
									<td><label>response.getRefundInfoList().getItems()[1]['refundStatus']</label></td>
									<td>#response.getRefundInfoList().getItems()[1]['refundStatus']#</td>
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
				<li id="simple2Tab">
					
					<h4>ColdFusion Request code</h4>
					<script src="https://gist.github.com/1775751.js?file=gistfile1.cfm"></script>
					
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

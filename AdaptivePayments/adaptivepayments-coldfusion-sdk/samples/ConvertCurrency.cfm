<cfif isDefined('url.seeit')>
	
	<cfinvoke component="adaptivepayments" method="convertCurrencyRequest" returnvariable="response">
		<cfinvokeargument name="fromCurrency" value="USD">
		<cfinvokeargument name="amount" value="1.00">
		<cfinvokeargument name="toCurrency" value="CAD">
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
			
			<h4>Convert Currency</h4>
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
						Use the ConvertCurrency API operation to obtain the estimated current foreign exchange (FX) rate for a 
						specific amount and currency. This is an estimated rate, which may be different from the 
						FX rate used at the time of the transaction.
					</p>
					
				</li>
			
				<li  id="simple1Tab">
					<h3>See It</h3>
				
					<p>
						We've built a simple interface for our SDK.  You create an instance of the adaptivepayment.cfc.  Then 
						 call the <em>PayRequest</em> method and pass the arguments listed below.  Click the <em>SEE IT</em> button below 
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
									<td><label>fromCurrency</label></td>
									<td>USD</td>
								</tr>
								<tr>
									<td>amount</td>
									<td>1.00</td>
								</tr>
								<tr>
									<td>toCurrency</td>
									<td>CAD</td>
								</tr>
								
							</tbody>
						</table>
					
					<cfif NOT isDefined('url.seeit')>
						<p><a href="ConvertCurrency.cfm?seeit=true#simple1" class="nice radius blue button large" name="seeit"  id="seeit">See It</a></p>
					</cfif>

					<cfif isDefined('url.seeit')>
						<hr>
						<h4>JSON Request</h4>
						<script src="https://gist.github.com/1793571.js?file=gistfile1.json"></script>
					
						<h4>JSON Response</h4>
						<script src="https://gist.github.com/1793590.js?file=gistfile1.json"></script>
						
						
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
									<td><label>response.getEstimatedAmountTable()getItems()[1]["baseAmount"]["code"]</label></td>
									<td>#response.getEstimatedAmountTable().getItems()[1]["baseAmount"]["code"]#</td>
								</tr>
								<tr>
									<td><label>response.getEstimatedAmountTable()getItems()[1]["baseAmount"]["amount"]</label></td>
									<td>#response.getEstimatedAmountTable().getItems()[1]["baseAmount"]["amount"]#</td>
								</tr>
								
								
								<tr>
									<td><label>response.getEstimatedAmountTable().getItems()[1]["currencyList"]["currency"][1]["code"]</label></td>
									<td>#response.getEstimatedAmountTable().getItems()[1]["currencyList"]["currency"][1]["code"]#</td>
								</tr>
								<tr>
									<td><label>response.getEstimatedAmountTable().getItems()[1]["currencyList"]["currency"][1]["amount"]</label></td>
									<td>#response.getEstimatedAmountTable().getItems()[1]["currencyList"]["currency"][1]["amount"]#</td>
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
					<script src="https://gist.github.com/1793596.js?file=gistfile1.cfm"></script>
	
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

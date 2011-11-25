<html>
<head>
<title>PayPal SDK - DoDirectPayment</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>DoDirectPayment</h3>
			<div id="apidetails">
				<p>DoDirectPayment API Operation enables you to process a credit
					card payment.</p>
			</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">First Name:</div>
					<div class="param_value">
						<input type=text size=30 maxlength=32 name=firstName value=John>
					</div>
				</div>
				<div class="params">
					<div class="param_name">Last Name:</div>
					<div class="param_value">
						<input type=text size=30 maxlength=32 name=lastName value=Doe>
					</div>
				</div>

				<div class="params">
					<div class="param_name">Card Type:</div>
					<div class="param_value">
						<select name=creditCardType>
							<option value=Visa selected>Visa</option>
							<option value=MasterCard>MasterCard</option>
							<option value=Discover>Discover</option>
							<option value=Amex>American Express</option>
						</select>
					</div>
				</div>
				<div class="params">
					<div class="param_name">Card Number:</div>
					<div class="param_value">
						<input type=text size=19 maxlength=19 name=creditCardNumber>
					</div>
				</div>
				<div class="params">
					<div class="param_name">Expiration Date:</div>
					<div class="param_value">
						<select name=expDateMonth>
							<option value=1>01</option>
							<option value=2>02</option>
							<option value=3>03</option>
							<option value=4>04</option>
							<option value=5>05</option>
							<option value=6>06</option>
							<option value=7>07</option>
							<option value=8>08</option>
							<option value=9>09</option>
							<option value=10>10</option>
							<option value=11>11</option>
							<option value=12>12</option>
						</select> <select name=expDateYear>
							<option value=2005>2005</option>
							<option value=2006>2006</option>
							<option value=2007>2007</option>
							<option value=2008>2008</option>
							<option value=2009>2009</option>
							<option value=2010>2010</option>
							<option value=2011>2011</option>
							<option value=2012 selected>2012</option>
							<option value=2013>2013</option>
							<option value=2014>2014</option>
							<option value=2015>2015</option>
						</select>
					</div>
				</div>
				<div class="params">
					<div class="param_name">Card Verification Number:</div>
					<div class="param_value">
						<input type=text size=3 maxlength=4 name=cvv2Number value=962>
					</div>
				</div>
				<div class="params">
					<div class="param_name">Payment Type:</div>
					<div class="param_value">
						<select name=paymentType>
							<option value=Authorization selected>Sale</option>
							<option value=Authorization>Authorization</option>
						</select>
					</div>
				</div>
				<br> <b>Billing Address:</b>
				<div class="params">
					<div class="param_name">Address 1:</div>
					<div class="param_value">
						<input type=text size=25 maxlength=100 name=address1
							value="1 Main St">
					</div>
				</div>
				<div class="params">
					<div class="param_name">Address 2:</div>
					<div class="param_value">
						<input type=text size=25 maxlength=100 name=address2>(optional)
					</div>
				</div>
				<div class="params">
					<div class="param_name">City:</div>
					<div class="param_value">
						<input type=text size=25 maxlength=40 name=city value="San Jose">
					</div>
				</div>
				<div class="params">
					<div class="param_name">State:</div>
					<div class="param_value">
						<select id=state name=state>
							<option value=></option>
							<option value=AK>AK</option>
							<option value=AL>AL</option>
							<option value=AR>AR</option>
							<option value=AZ>AZ</option>
							<option value=CA selected>CA</option>
							<option value=CO>CO</option>
							<option value=CT>CT</option>
							<option value=DC>DC</option>
							<option value=DE>DE</option>
							<option value=FL>FL</option>
							<option value=GA>GA</option>
							<option value=HI>HI</option>
							<option value=IA>IA</option>
							<option value=ID>ID</option>
							<option value=IL>IL</option>
							<option value=IN>IN</option>
							<option value=KS>KS</option>
							<option value=KY>KY</option>
							<option value=LA>LA</option>
							<option value=MA>MA</option>
							<option value=MD>MD</option>
							<option value=ME>ME</option>
							<option value=MI>MI</option>
							<option value=MN>MN</option>
							<option value=MO>MO</option>
							<option value=MS>MS</option>
							<option value=MT>MT</option>
							<option value=NC>NC</option>
							<option value=ND>ND</option>
							<option value=NE>NE</option>
							<option value=NH>NH</option>
							<option value=NJ>NJ</option>
							<option value=NM>NM</option>
							<option value=NV>NV</option>
							<option value=NY>NY</option>
							<option value=OH>OH</option>
							<option value=OK>OK</option>
							<option value=OR>OR</option>
							<option value=PA>PA</option>
							<option value=RI>RI</option>
							<option value=SC>SC</option>
							<option value=SD>SD</option>
							<option value=TN>TN</option>
							<option value=TX>TX</option>
							<option value=UT>UT</option>
							<option value=VA>VA</option>
							<option value=VT>VT</option>
							<option value=WA>WA</option>
							<option value=WI>WI</option>
							<option value=WV>WV</option>
							<option value=WY>WY</option>
							<option value=AA>AA</option>
							<option value=AE>AE</option>
							<option value=AP>AP</option>
							<option value=AS>AS</option>
							<option value=FM>FM</option>
							<option value=GU>GU</option>
							<option value=MH>MH</option>
							<option value=MP>MP</option>
							<option value=PR>PR</option>
							<option value=PW>PW</option>
							<option value=VI>VI</option>
						</select>
					</div>
				</div>
				<div class="params">
					<div class="param_name">ZIP Code:</div>
					<div class="param_value">
						<input type=text size=10 maxlength=10 name=zip value=95131>(5
						or 9 digits)
					</div>
				</div>
				<div class="params">
					<div class="param_name">CountryCode:</div>
					<div class="param_value">
						<input type=text size=4 maxlength=7 name=countryCode value=US>
					</div>
				</div>
				<div class="params">
					<div class="param_name">Amount:</div>
					<div class="param_value">
						<input type=text size=4 maxlength=7 name=amount value=1.00>
					</div>
				</div>
				<div class="params">
					<div class="param_name">CurrencyCode:</div>
					<div class="param_value">
						<input type=text size=4 maxlength=7 name=currencyCode value=USD>
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="DirectPaymentBtn" value="DirectPayment" /><br />
				</div>
				<a href="/merchant-sample/index.html">Home</a> <br /> <br />
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href="RT/DoReferenceTransaction">DoReferenceTransaction</a>
				</li>
				<li><a href="RP/CreateRecurringPaymentsProfile">CreateRecurringPaymentsProfile</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
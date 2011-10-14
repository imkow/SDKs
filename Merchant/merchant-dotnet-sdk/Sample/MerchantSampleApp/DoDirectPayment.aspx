<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DoDirectPayment.aspx.cs" Inherits="MerchantSampleApp.DoDirectPayment" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Merchant API</title>
</head>
<body>
   <h2>DoDirectPayment</h2>
    <form id="form1" runat="server" action="MerchantHandler.ashx">
    <div class="params">
			<div class="param_name">First Name</div>
			<div class="param_value">
				<input type="text" id="firstName" name="firstName" size="60"
					value="John" /><br />
			</div>
			<div class="param_name">Last Name</div>
			<div class="param_value">
				<input type="text" id="lastName" name="lastName" size="60"
					value="Liu" /><br />
			</div>
			<div class="param_name">Card Type</div>
			<div class="param_value">
			<select name="creditCardType">
				<option value="Visa" selected="selected">Visa</option>
				<option value="MasterCard">MasterCard</option>
				<option value="Discover">Discover</option>
				<option value="Amex">American Express</option>
			</select>
				<br />
			</div>
			<div class="param_name">Card Number</div>
			<div class="param_value">
				<input type="text" id="cardNum" name="cardNum" size="60"
					value="4274175925901887" /><br />
			</div>
			<div class="param_name">Expiration Date</div>
			<div class="param_value">
				<select name="expDateMonth">
				<option value="1">01</option>
				<option value="2">02</option>
				<option value="3">03</option>
				<option value="4">04</option>
				<option value="5">05</option>
				<option value="6">06</option>
				<option value="7">07</option>
				<option value="8">08</option>
				<option value="9">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			<select name="expDateYear">
				<option value="2005">2005</option>
				<option value="2006">2006</option>
				<option value="2007">2007</option>
				<option value="2008">2008</option>
				<option value="2009">2009</option>
				<option value="2010">2010</option>
				<option value="2011">2011</option>
				<option value="2012" selected="selected">2012</option>
				<option value="2013">2013</option>
				<option value="2014">2014</option>
				<option value="2015">2015</option>
			</select><br />
			</div>
			<div class="param_name">Card Verification Number</div>
			<div class="param_value">
				<input type="text" id="cvv2Num" name="cvv2Num" size="60"
					value="962" /><br />
			</div>
			<div class="param_name">Payment Type</div>
			<div class="param_value">
				<select name="paymentType" >
				<option value="Authorization" selected="selected">Sale</option>
				<option value="Authorization">Authorization</option>
			</select><br />
			</div>
			<div class="param_name">Address Line 1</div>
			<div class="param_value">
				<input type="text" id="addr1" name="addr1" size="60"
					value="1 Main St" /><br />
			</div>
			<div class="param_name">Address Line 2</div>
			<div class="param_value">
				<input type="text" id="addr2" name="addr2" size="60"
					value="" />(optional)<br />
			</div>
			<div class="param_name">City</div>
			<div class="param_value">
				<input type="text" id="city" name="city" size="60"
					value="San Jose" /><br />
			</div>
			<div class="param_name">State</div>
			<div class="param_value">
				<select id="state" name="state">
				<option value=""></option>
				<option value="AK">AK</option>
				<option value="AL">AL</option>
				<option value="AR">AR</option>
				<option value="AZ">AZ</option>
				<option value="CA"selected="selected">CA</option>
				<option value="CO">CO</option>
				<option value="CT">CT</option>
				<option value="DC">DC</option>
				<option value="DE">DE</option>
				<option value="FL">FL</option>
				<option value="GA">GA</option>
				<option value="HI">HI</option>
				<option value="IA">IA</option>
				<option value="ID">ID</option>
				<option value="IL">IL</option>
				<option value="IN">IN</option>
				<option value="KS">KS</option>
				<option value="KY">KY</option>
				<option value="LA">LA</option>
				<option value="MA">MA</option>
				<option value="MD">MD</option>
				<option value="ME">ME</option>
				<option value="MI">MI</option>
				<option value="MN">MN</option>
				<option value="MO">MO</option>
				<option value="MS">MS</option>
				<option value="MT">MT</option>
				<option value="NC">NC</option>
				<option value="ND">ND</option>
				<option value="NE">NE</option>
				<option value="NH">NH</option>
				<option value="NJ">NJ</option>
				<option value="NM">NM</option>
				<option value="NV">NV</option>
				<option value="NY">NY</option>
				<option value="OH">OH</option>
				<option value="OK">OK</option>
				<option value="OR">OR</option>
				<option value="PA">PA</option>
				<option value="RI">RI</option>
				<option value="SC">SC</option>
				<option value="SD">SD</option>
				<option value="TN">TN</option>
				<option value="TX">TX</option>
				<option value="UT">UT</option>
				<option value="VA">VA</option>
				<option value="VT">VT</option>
				<option value="WA">WA</option>
				<option value="WI">WI</option>
				<option value="WV">WV</option>
				<option value="WY">WY</option>
				<option value="AA">AA</option>
				<option value="AE">AE</option>
				<option value="AP">AP</option>
				<option value="AS">AS</option>
				<option value="FM">FM</option>
				<option value="GU">GU</option>
				<option value="MH">MH</option>
				<option value="MP">MP</option>
				<option value="PR">PR</option>
				<option value="PW">PW</option>
				<option value="VI">VI</option>
			</select><br />
			</div>
			<div class="param_name">ZipCode</div>
			<div class="param_value">
				<input type="text" id="zipCode" name="zipCode" size="60"
					value="95131" />(5 or 9 digits)<br />
			</div>
			<div class="param_name">CountryCode</div>
			<div class="param_value">
				<input type="text" id="countryCode" name="countryCode" size="60"
					value="US" /><br />
			</div>
			<div class="param_name">Amount</div>
			<div class="param_value">
				<input type="text" id="amount" name="amount" size="60"
					value="1.00" /><br />
			</div>
			<div class="param_name">Currency Code</div>
			<div class="param_value">
				<input type="text" id="currencyCode" name="currencyCode" size="60"
					value="USD" /><br />
			</div>
			
			
		</div>
		<input type="submit" name="MerchantBtn" value="DoDirectPayment" />
		<br /> 
    </form>
</body>
</html>

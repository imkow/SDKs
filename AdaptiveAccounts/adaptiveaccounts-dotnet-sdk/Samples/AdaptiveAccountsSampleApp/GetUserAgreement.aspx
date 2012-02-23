<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GetUserAgreement.aspx.cs" Inherits="AdaptiveAccountsSampleApp.GetUserAgreement" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
<title>Adaptive Accounts - Get User Agreement</title>    
    <link rel="stylesheet" type="text/css" href="Content/sdk.css" />
    <script type="text/javascript" src="Content/sdk_functions.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>Get User Agreement</h3>
			<div id="apidetails">The GetUserAgreement method lets you retrieve the user 
			agreement for the customer to approve the new PayPal account.</div>
		</div>
		<form method="post" action="adaptiveaccountshandler.ashx" runat="server">
			<div id="request_form">
				<div class="note">If you specify CreateAccount key, do not pass a
					country code or language code. Doing so will result in an error.</div>
				<div class="params">
					<div class="param_name">
						CreateAccountKey (<a href="CreateAccount.aspx">Get CreateAccountKey</a>)</div>
					<div class="param_value">
						<input type="text" name="createAccountKey" value="AA-26W36874VP570305F" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Country Code</div>
					<div class="param_value">
						<select name="countryCode">
							<option value="US">US - United States *</option>
							<option value="AU">AU - Australia</option>
							<option value="AT">AT - Austria</option>
							<option value="CA">CA - Canada</option>
							<option value="CZ">CZ - Czech Republic</option>
							<option value="EU">EU - European Union *</option>
							<option value="FR">FR - France</option>
							<option value="DE">DE - Germany</option>
							<option value="GB">GB - Great Britain</option>
							<option value="GR">GR - Greece</option>
							<option value="IE">IE - Ireland</option>
							<option value="IL">IL - Israel</option>
							<option value="IT">IT - Italy</option>
							<option value="JP">JP - Japan</option>
							<option value="NL">NL - Netherlands</option>
							<option value="NZ">NZ - New Zealand (Aotearoa)</option>
							<option value="PL">PL - Poland</option>
							<option value="PT">PT - Portugal</option>
							<option value="RU">RU - Russian Federation</option>
							<option value="SG">SG - Singapore</option>
							<option value="ZA">ZA - South Africa</option>
							<option value="ES">ES - Spain</option>
							<option value="CH">CH - Switzerland</option>							
						</select>
					</div>
				</div>
				<div class="params">
					<div class="param_name">Language Code</div>
					<div class="param_value">
						<input type="text" name="languageCode" value="" />
					</div>
				</div>
				<div class="submit">
				    <asp:Button ID="AdaptiveAccountsBtn" Text="GetUserAgreement" runat="server" PostBackUrl="adaptiveaccountshandler.ashx" />					
				</div>			
			</div>
		</form>
		<a href="Default.aspx">Home</a>
	</div>
</body>
</html>
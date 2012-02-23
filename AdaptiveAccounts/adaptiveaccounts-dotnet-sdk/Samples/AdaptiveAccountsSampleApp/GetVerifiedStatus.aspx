<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GetVerifiedStatus.aspx.cs" Inherits="AdaptiveAccountsSampleApp.GetVerifiedStatus" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
<title>Adaptive Accounts - Get Verified Status</title>    
    <link rel="stylesheet" type="text/css" href="Content/sdk.css" />
    <script type="text/javascript" src="Content/sdk_functions.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>Get Verified Status</h3>
			<div id="apidetails">The GetVerifiedStatus method lets you check if a PayPal account 
			status is verified. A PayPal account gains verified status under a variety of 
			circumstances, such as when an account is linked to a verified funding source. 
			Verified status serves to indicate a trust relationship.</div>
		</div>
		<form method="post" action="adaptiveaccountshandler.ashx" runat="server">
			<div id="request_form">
				<div class="params">
					<div class="param_name">Email Address of the account holder *</div>
					<div class="param_value">
						<input type="text" name="emailAddress" value="platfo@paypal.com" />
					</div>
				</div>
				
				<div class="params">
					<div class="param_name">Match criteria *</div>
					<div class="param_value">
						<select name="matchCriteria">							
							<option value="NAME" selected="selected">Name</option>
							<option value="NONE">None</option>
						</select>
					</div>
					<span class="note">NOTE: To use Match criteria NONE you must
					request and be granted advanced permission levels.</span>
				</div>
				<div class="params">
					<div class="param_name">First Name (Required if matchCriteria is
						NAME)</div>
					<div class="param_value">
						<input type="text" name="firstName" value="Bonzop" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Last Name (Required if matchCriteria is
						NAME)</div>
					<div class="param_value">
						<input type="text" name="lastName" value="Zaius" />
					</div>
				</div>
				<div class="submit">
				    <asp:Button ID="AdaptiveAccountsBtn" Text="GetVerifiedStatus" runat="server" PostBackUrl="adaptiveaccountshandler.ashx" />					
				</div>			
			</div>
		</form>
		<a href="Default.aspx">Home</a>
	</div>
</body>
</html>
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="SetFundingSourcesConfirmed.aspx.cs" Inherits="AdaptiveAccountsSampleApp.SetFundingSourcesConfirmed" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
<title>Adaptive Accounts - Set Funding Sources Confirmed</title>    
    <link rel="stylesheet" type="text/css" href="Content/sdk.css" />
    <script type="text/javascript" src="Content/sdk_functions.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>Set Funding Sources Confirmed</h3>
			<div id="apidetails">The SetFundingSourceConfirmed method lets your application 
			set up bank accounts as funding sources for PayPal accounts.</div>
		</div>
		<form method="post" action="adaptiveaccountshandler.ashx" runat="server">
			<div id="request_form">
				<div class="input_header">Account Id or email address of the account to which the funding source is to be added.
				</div>
				<table class="params">
					<tr>
						<th>Account ID</th>
						<th>Email Address</th>
					</tr>
					<tr>
						<td><input type="text" name="accountId" value="" /></td>
						<td><input type="text" name="emailAddress" value="" /></td>
					</tr>
				</table>
				<div class="params">
					<div class="param_name">
						Funding Source Key * (Get FundingSourceKey via <a
							href='AddBankAccount.aspx'>AddBankAccount</a> or <a
							href='AddPaymentCard.aspx'>AddPaymentCard</a>)
					</div>
					<div class="param_value">
						<input type="text" name="fundingSourceKey" value="" />
					</div>
				</div>
				<div class="submit">
				    <asp:Button ID="AdaptiveAccountsBtn" Text="SetFundingSourcesConfirmed" runat="server" PostBackUrl="adaptiveaccountshandler.ashx" />					
				</div>			
			</div>
		</form>
		<a href="Default.aspx">Home</a>
	</div>
</body>
</html>
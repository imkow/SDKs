<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="TransactionSearch.aspx.cs" Inherits="MerchantSampleApp.TransactionSearch" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Merchant API</title>
</head>
<body>
<h2>TransactionSearch</h2>
    <form id="form1" runat="server" action="MerchantHandler.ashx">
    <div class="params">
			<div class="param_name">StartDate(YYYY-MM-DD)</div>
			<div class="param_value">
				<input type="text" id="startDate" name="startDate" size="60"
					value="2011-10-04" /><br />
			</div>
		</div>
		<div class="params">
			<div class="param_name">TransactionID</div>
			<div class="param_value">
				<input type="text" id="transID" name="transID" size="60"
					value="76959366JE436874M" /><br />
			</div>
		</div>
		<input type="submit" name="MerchantBtn" value="TransSearch" />
		<br /> 
    </form>
</body>
</html>

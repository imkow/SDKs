<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ReverseTransaction.aspx.cs" Inherits="PayPalAPISample.APICalls.ReverseTransaction" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
    <title>PayPal SDK - ReverseTransaction</title>
    <link href="sdk.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <div id="wrapper">
    <div id="header">
        <h3>ReverseTransaction</h3>
        <div id="apidetails">Reverses a transaction.</div>
    </div>
    <form id="form1" runat="server">
        <div id="request_form">
				<div class="params">
					<div class="param_name">
						Transaction ID * <a href="SetExpressCheckout.aspx"> (Create a EC Transaction )</a>
					</div>
					<div class="param_value">
						<input type="text" id="transactionID" name="transactionID" value="" runat="server"/>
					</div>
				</div>        
        </div>
    </form>
    <div id="relatedcalls"> 
    </div>
    </div>
</body>
</html>
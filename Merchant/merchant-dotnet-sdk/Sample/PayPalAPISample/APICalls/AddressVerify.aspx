<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="AddressVerify.aspx.cs" Inherits="PayPalAPISample.APICalls.AddressVerify" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
    <title>PayPal SDK - AddressVerify</title>
    <link rel="stylesheet" type="text/css" href="sdk.css" />
</head>
<body>
    <div id="wrapper">
    <div id="header">
        <h3>AddressVerify</h3>
        <div id="apidetails">Confirms whether a postal address and postal code match those of the specified PayPal account holder.</div>
    </div>
    <form id="form1" runat="server">
        <div id="request_form">
            <div class="param_name">Buyer's Email address *</div>
            <div class="param_value">
                <input type="text" name="email" id="email" value="sdk-three@sdk.com" runat="server" />
            </div>
            <div class="param_name">First line of street address *</div>
            <div class="param_value">
                <input type="text" name="street" id="street" value="123" runat="server" />
            </div>
            <div class="param_name">Postal code *</div>
            <div class="param_value">
                <input type="text" name="zip" id="zip" value="95131" runat="server" />
            </div>                                    
            <div class="submit">
                <input id="submit" type="submit" name="submit" value="Submit" runat="server" onserverclick="Submit_Click"/>
            </div>            
        </div>
    </form>
    <div id="relatedcalls"> 
    </div>
    </div>
</body>
</html>
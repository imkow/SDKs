<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="SetCustomerBillingAgreement.aspx.cs" Inherits="PayPalAPISample.APICalls.SetCustomerBillingAgreement" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
    <title>PayPal SDK - SetCustomerBillingAgreement</title>
    <link rel="stylesheet" type="text/css" href="sdk.css" />
</head>
<body>
    <div id="wrapper">
    <div id="header">
        <h3>SetCustomerBillingAgreement</h3>
        <div id="apidetails">Initiates the creation of a billing agreement. PayPal recommends that you 
        use the newer SetExpressCheckout API instead to create billing agreements.</div>
    </div>
    <form id="form1" runat="server">
        <div id="request_form">
            <div class="param_name">Buyer's Email address</div>
            <div class="param_value">
                <input type="text" name="buyerEmail" id="buyerEmail" value="sdk-three@sdk.com" runat="server" />
            </div>
            <div class="param_name">Return URL *</div>
            <div class="param_value">
                <input type="text" name="returnUrl" id="returnUrl" runat="server" />
            </div>
            <div class="param_name">Cancel URL *</div>
            <div class="param_value">
                <input type="text" name="cancelUrl" id="cancelUrl" runat="server" />
            </div>
            <div class="param_name">Billing Agreement Description *</div>
            <div class="param_value">
                <textarea cols="80" rows="10" id="billingAgreementText" runat="server" ></textarea>
            </div>
            <div class="param_name">Billing type *</div>
            <div class="param_value">
                <asp:DropDownList ID="billingType" runat="server">
                    <asp:ListItem Text="Recurring payments" Value="RECURRINGPAYMENTS" />
                    <asp:ListItem Text="Reference transactions" Value="MERCHANTINITIATEDBILLING" />
                </asp:DropDownList>
            </div>            
            
            <div class="submit">
                <input id="submit" type="submit" name="submit" value="Submit" runat="server" onserverclick="Submit_Click"/>
            </div>            
        </div>
    </form>
    <div id="relatedcalls">
        <ul>
            <li><a href="">PayPal Web Flow (_customer-billing-agreement)</a></li>
        </ul> 
    </div>
    </div>
</body>
</html>
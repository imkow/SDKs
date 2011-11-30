<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="PayPalAPISample._Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>PayPal SDK - API Samples - Home page</title>
    <link rel="stylesheet" type="text/css" href="APICalls/sdk.css" /> 
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h2>PayPal SDK - API Samples</h2>
        <table>
            <tr>
                <td>
                    <div class="section_header">Express Checkout</div>
                    <ul>
                        <li><a href="APICalls/SetExpressCheckout.aspx">SetExpressCheckout</a></li>
                        <li><a href="APICalls/GetExpressCheckoutDetails.aspx">GetExpressCheckoutDetails</a></li>
                        <li><a href="APICalls/DoExpressCheckoutPayment.aspx">DoExpressCheckoutPayment</a></li>
                    </ul>
                </td>   
                <td>
                    <div class="section_header">Settlements and refund</div>
                    <ul>
                        <li><a href="APICalls/DoAuthorization.aspx">DoAuthorization</a></li>
                        <li><a href="APICalls/DoCapture.aspx">DoCapture</a></li>
                        <li><a href="APICalls/DoReauthorization.aspx">DoReauthorization</a></li>                                                
                        <li><a href="APICalls/DoVoid.aspx">DoVoid</a></li>
                        <li><a href="APICalls/RefundTransaction.aspx">RefundTransaction</a></li>
                        <li><a href="APICalls/ReverseTransaction.aspx">ReverseTransaction</a></li>                        
                    </ul>
                </td>
                <td>
                    <div class="section_header">Transaction reporting</div>
                    <ul>
                        <li><a href="APICalls/GetTransactionDetails.aspx">GetTransactionDetails</a></li>
                        <li><a href="APICalls/TransactionSearch.aspx">TransactionSearch</a></li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="section_header">Direct Payment</div>
                    <ul>
                        <li><a href="APICalls/DoDirectPayment.aspx">DoDirectPayment</a></li>
                    </ul>
                </td>
                <td>
                    <div class="section_header">Button Manager</div>
                    <ul>
                        <li><a href="APICalls/BMButtonSearch.aspx">BMButtonSearch</a></li>
                        <li><a href="APICalls/BMCreateButton.aspx">BMCreateButton</a></li>
                        <li><a href="APICalls/BMGetButtonDetails.aspx">BMGetButtonDetails</a></li>
                        <li><a href="APICalls/BMGetInventory.aspx">BMGetInventory</a></li>                        
                        <li><a href="APICalls/BMSetInventory.aspx">BMSetInventory</a></li>                                                
                        <li><a href="APICalls/BMManageButtonStatus.aspx">BMManageButtonStatus</a></li>
                        <li><a href="APICalls/BMUpdateButton.aspx">BMUpdateButton</a></li>
                    </ul>
                </td>                
                <td>
                    <div class="section_header">Reference Transaction</div>
                    <ul>
                        <li><a href="APICalls/BillAgreementUpdate.aspx">BillAgreementUpdate</a></li>
                        <li><a href="APICalls/CreateBillingAgreement.aspx">CreateBillingAgreement</a></li>
                        <li><a href="APICalls/GetBillingAgreementCustomerDetails.aspx">GetBillingAgreementCustomerDetails</a></li>                    
                        <li><a href="APICalls/SetCustomerBillingAgreement.aspx">SetCustomerBillingAgreement</a></li>                        
                    </ul>
                </td>                
            </tr>
            <tr>
                <td>
                    <div class="section_header">Miscellaneous</div>
                    <ul>
                        <li><a href="APICalls/AddressVerify.aspx">AddressVerify</a></li>
                        <li><a href="APICalls/GetBalance.aspx">GetBalance</a></li>
                        <li><a href="APICalls/GetPalDetails.aspx">GetPalDetails</a></li>
                        <li><a href="APICalls/ManagePendingTransactionStatus.aspx">ManagePendingTransactionStatus</a></li>                        
                    </ul>
                </td>
                <td>
                    <div class="section_header">Merchant Onboarding</div>
                    <ul>
                        <li><a href="APICalls/EnterBoarding.aspx">EnterBoarding</a></li>
                        <li><a href="APICalls/GetBoardingDetails.aspx">GetBoardingDetails</a></li>
                    </ul>
                </td>
                <td>
                    <div class="section_header">Mass Pay</div>
                    <ul>
                        <li><a href="APICalls/MassPay.aspx">MassPay</a></li>
                    </ul>
                </td>                                
            </tr>            
        </table>
    </div>
    </form>
</body>
</html>

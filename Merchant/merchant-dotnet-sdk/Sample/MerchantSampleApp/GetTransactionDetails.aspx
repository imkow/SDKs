<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GetTransactionDetails.aspx.cs" Inherits="MerchantSampleApp.GetTransactionDetails" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Get Transaction Details</title>
</head>
<body>
    
    <div id="wrapper">
        <div id="requestform">
            <form id="form1" runat="server">
                <div class="param_name">Transaction ID</div>
                <div class="param_value">
                    <input id="transactionId" type="text" maxlength="100" value=""
									name="transactionId" runat="server" class="longfield"/>
                </div>
                
                <input type="submit" name="SubmitBtn" id="SubmitBtn" value="Search" 
                    runat="server" onserverclick="Submit_Click"/>
            </form>
        </div>    
    </div>
    
</body>
</html>

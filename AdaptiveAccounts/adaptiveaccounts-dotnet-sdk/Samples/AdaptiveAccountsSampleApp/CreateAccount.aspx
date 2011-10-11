<%@ Page Language="C#" AutoEventWireup="true" Codebehind="CreateAccount.aspx.cs"
    Inherits="AdaptiveAccountsSampleApp.CreateAccount" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>AdaptiveAccounts</title>
</head>
<body>
    <h2>
        CreateAccount API</h2>
    <form id="form1" runat="server" action="adaptiveaccountshandler.ashx">
        <div class="params">
            <div class="param_name">
                FirstName</div>
            <div class="param_value">
                <input type="text" name="firstName" size="50" maxlength="260" id="firstName" value="John" /></div>
        </div>
        <div class="params">
            <div class="param_name">
                LastName</div>
            <div class="param_value">
                <input type="text" name="lastName" size="50" maxlength="260" id="lastName" value="Lui" /></div>
        </div>
        <div class="params">
            <div class="param_name">
                Address Line 1</div>
            <div class="param_value">
                <input type="text" id="addr1" name="addr1" size="60" value="1 Main St" /><br />
            </div>
        </div>
        
        <div class="params">
            <div class="param_name">
                City</div>
            <div class="param_value">
                <input type="text" id="city" name="city" size="60" value="San Jose" /><br />
            </div>
        </div>
        <div class="params">
            <div class="param_name">
                ZipCode</div>
            <div class="param_value">
                <input type="text" id="zipCode" name="zipCode" size="60" value="95131" />(5 or 9
                digits)<br />
            </div>
        </div>
        <div class="params">
            <div class="param_name">
                State</div>
            <div class="param_value">
                <input type="text" name="state" size="50" maxlength="260" id="state" value="CA" /></div>
        </div>
        <div class="params">
            <div class="param_name">
                CountryCode</div>
            <div class="param_value">
                <input type="text" name="countryCode" size="50" maxlength="260" id="countryCode"
                    value="US" /></div>
        </div>
        <div class="params">
            <div class="param_name">
                ContactNumber</div>
            <div class="param_value">
                <input type="text" name="contactNum" size="50" maxlength="260" id="contactNum" value="5126914160" /></div>
        </div>
        <div class="params">
            <div class="param_name">
                PreferredLanguageCode</div>
            <div class="param_value">
                <input type="text" name="preferredLangCode" size="50" maxlength="260" id="preferredLangCode"
                    value="en_US" /></div>
        </div>
        <div class="params">
            <div class="param_name">
                CurrencyCode</div>
            <div class="param_value">
                <input type="text" name="currencyCode" size="50" maxlength="260" id="currencyCode"
                    value="USD" /></div>
        </div>
        <div class="params">
            <div class="param_name">
                CitizenshipCountryCode</div>
            <div class="param_value">
                <input type="text" name="citiCounCode" size="50" maxlength="260" id="citiCounCode"
                    value="US" /></div>
        </div>
        <div class="params">
            <div class="param_name">
                Email Address</div>
            <div class="param_value">
                <input type="text" name="mail" size="50" maxlength="260" id="mail" value="test@paypal.com" /></div>
        </div>
        
         <%string url = Request.Url.Scheme + "://" + Request.Url.Host + ":" + Request.Url.Port;
                       string returnURL = url + "/Default.aspx"; %>
                     <div class="params">  <div class="param_name">
                ReturnUrl</div>
            <div class="param_value">
                <input type="text" name="returnUrl" size="50" maxlength="260" id="returnUrl" value="<%=returnURL%>"
                     /><br />
            </div> </div>
            <div class="params">
            <div class="param_name">
               Registration Type</div>
            <div class="param_value">
                <input type="text" name="regType" size="50" maxlength="260" id="regType" value="WEB" /></div>
        </div>
        <input name="AdaptiveAccountsBtn" type="submit" value="CreateAccount" /><br />
    </form>
</body>
</html>

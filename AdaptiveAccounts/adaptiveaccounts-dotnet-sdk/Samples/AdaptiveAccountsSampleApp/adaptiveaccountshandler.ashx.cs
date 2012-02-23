using System;
using System.Data;
using System.Web;
using System.Collections;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Web.Services;
using System.Web.Services.Protocols;
using PayPal;
using PayPal.AdaptiveAccounts;
using PayPal.AdaptiveAccounts.Model;
using PayPal.Util;
using PayPal.Exception;
using System.Configuration;

namespace AdaptiveAccountsSampleApp
{
    /// <summary>
    /// Summary description for $codebehindclassname$
    /// </summary>
    
    public class adaptiveaccountshandler : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/html";
            String strCall = context.Request.Params["AdaptiveAccountsBtn"];

            if (strCall.Equals("CreateAccount"))
            {
                CreateAccount(context);
            }
            else if (strCall.Equals("AddBankAccount"))
            {
                AddBankAccount(context);
            }
            else if (strCall.Equals("AddPaymentCard"))
            {
                AddPaymentCard(context);
            }
            else if (strCall.Equals("GetVerifiedStatus"))
            {
                GetVerifiedStatus(context);
            }
            else if (strCall.Equals("GetUserAgreement"))
            {
                GetUserAgreement(context);
            }
            else if (strCall.Equals("SetFundingSourceConfirmed"))
            {
                SetFundingSourceConfirmed(context);
            }
        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }
        private void CreateAccount(HttpContext context)
        {
            NameValueCollection parameters = context.Request.Params;

            NameType nameOnCard = new NameType(parameters["firstName"], parameters["lastName"]);
            if (parameters["salutation"] != "")
                nameOnCard.salutation = parameters["salutation"];
            if (parameters["middleName"] != "")
                nameOnCard.middleName = parameters["middleName"];
            if (parameters["suffix"] != "")
                nameOnCard.suffix = parameters["suffix"];

            AddressType address = new AddressType(parameters["line1"], parameters["countryCode"]);
            if (parameters["line2"] != "")
                address.line2 = parameters["line2"];
            if (parameters["city"] != "")
                address.city = parameters["city"];
            if (parameters["state"] != "")
                address.state = parameters["state"];
            if (parameters["postalCode"] != "")
                address.postalCode = parameters["postalCode"];

            CreateAccountRequest req = new CreateAccountRequest(new RequestEnvelope(), nameOnCard, address,
                parameters["preferredLanguageCode"]);
            // set optional parameters
            if(parameters["contactPhoneNumber"] != "")
                req.contactPhoneNumber = parameters["contactPhoneNumber"];
            if (parameters["homePhoneNumber"] != "")
                req.homePhoneNumber = parameters["homePhoneNumber"];
            if (parameters["mobilePhoneNumber"] != "")
                req.mobilePhoneNumber = parameters["mobilePhoneNumber"];
            if (parameters["emailAddress"] != "")
                req.emailAddress = parameters["emailAddress"];
            if (parameters["currencyCode"] != "")
                req.currencyCode = parameters["currencyCode"];
            req.citizenshipCountryCode = parameters["citizenshipCountryCode"];
            req.registrationType = parameters["registrationType"];

            if (parameters["returnUrl"] != "" || parameters["returnUrlDescription"] != ""
                || parameters["showAddCreditCard"] != "" || parameters["showMobileConfirm"] != ""
                || parameters["useMiniBrowser"] != "")
            {
                CreateAccountWebOptionsType webOptions = new CreateAccountWebOptionsType();
                req.createAccountWebOptions = webOptions;

                if (parameters["returnUrl"] != "")
                    webOptions.returnUrl = parameters["returnUrl"];
                if (parameters["returnUrlDescription"] != "")
                    webOptions.returnUrlDescription = parameters["returnUrlDescription"];
                if (parameters["showAddCreditCard"] != "")
                    webOptions.showAddCreditCard = Boolean.Parse(parameters["showAddCreditCard"]);
                if (parameters["showMobileConfirm"] != "")
                    webOptions.showMobileConfirm = Boolean.Parse(parameters["showMobileConfirm"]);
                if (parameters["useMiniBrowser"] != "")
                    webOptions.useMiniBrowser = Boolean.Parse(parameters["useMiniBrowser"]);
            }            
            

            // All set. Fire the request
            AdaptiveAccountsService service = new AdaptiveAccountsService();
            CreateAccountResponse resp = null;
            try
            {
                resp = service.CreateAccount(req);
            }
            catch (System.Exception e)
            {
                context.Response.Write(e.Message);
            }


            // Display response values. 
            Dictionary<string, string> keyResponseParams = new Dictionary<string, string>();
            string redirectUrl = null;
            if (!(resp.responseEnvelope.ack == AckCode.FAILURE) &&
                !(resp.responseEnvelope.ack == AckCode.FAILUREWITHWARNING))
            {
                redirectUrl = ConfigurationManager.AppSettings["PAYPAL_REDIRECT_URL"]
                    + resp.redirectURL;
                keyResponseParams.Add("Account Id", resp.accountId);
                keyResponseParams.Add("Create account key", resp.createAccountKey);
                keyResponseParams.Add("Execution status", resp.execStatus.ToString());                
            }
            displayResponse(context, "CreateAccount", keyResponseParams, service.getLastRequest(), service.getLastResponse(),
                resp.error, redirectUrl);
        }

        /// <summary>
        /// Handle AddBankAccount API call
        /// </summary>
        /// <param name="context"></param>
        private void AddBankAccount(HttpContext context)
        {
            NameValueCollection parameters = context.Request.Params;

            ConfirmationType confirmationType = (ConfirmationType) 
                Enum.Parse(typeof(ConfirmationType), parameters["confirmationType"]);
            AddBankAccountRequest req = new AddBankAccountRequest(
                new RequestEnvelope(), parameters["bankCountryCode"], confirmationType);
            // set optional parameters
            if (parameters["accountId"] != "")
                req.accountId = parameters["accountId"];
            if (parameters["emailAddress"] != "")
                req.emailAddress = parameters["emailAddress"];
            if (parameters["createAccountKey"] != "")
                req.createAccountKey = parameters["createAccountKey"];            
            if (parameters["bankName"] != "")
                req.bankName = parameters["bankName"];
            if (parameters["routingNumber"] != "")
                req.routingNumber = parameters["routingNumber"];
            if (parameters["bankAccountType"] != "")
                req.bankAccountType = 
                    (BankAccountType) Enum.Parse( typeof(BankAccountType), parameters["bankAccountType"]);
            if (parameters["bankAccountNumber"] != "")
                req.bankAccountNumber = parameters["bankAccountNumber"];
            if (parameters["iban"] != "")
                req.iban = parameters["iban"];
            if (parameters["clabe"] != "")
                req.clabe = parameters["clabe"];
            if (parameters["bsbNumber"] != "")
                req.bsbNumber = parameters["bsbNumber"];
            if (parameters["branchLocation"] != "")
                req.branchLocation = parameters["branchLocation"];
            if (parameters["sortCode"] != "")
                req.sortCode = parameters["sortCode"];
            if (parameters["bankTransitNumber"] != "")
                req.bankTransitNumber = parameters["bankTransitNumber"];
            if (parameters["institutionNumber"] != "")
                req.institutionNumber = parameters["institutionNumber"];
            if (parameters["branchCode"] != "")
                req.branchCode = parameters["branchCode"];
            if (parameters["agencyNumber"] != "")
                req.agencyNumber = parameters["agencyNumber"];
            if (parameters["bankCode"] != "")
                req.bankCode = parameters["bankCode"];
            if (parameters["ribKey"] != "")
                req.ribKey = parameters["ribKey"];
            if (parameters["controlDigit"] != "")
                req.controlDigit = parameters["controlDigit"];
            if (parameters["taxIdType"] != "")
                req.taxIdType = parameters["taxIdType"];
            if (parameters["taxIdNumber"] != "")
                req.taxIdNumber = parameters["taxIdNumber"];
            if (parameters["accountHolderDateOfBirth"] != "")
                req.accountHolderDateOfBirth = parameters["accountHolderDateOfBirth"];
            if ( confirmationType == ConfirmationType.WEB &&
                (parameters["returnURL"] != "" || parameters["returnURLDescription"] != ""
                || parameters["cancelURL"] != "" || parameters["cancelURLDescription"] != ""))
            {
                req.webOptions = new WebOptionsType();
                if (parameters["returnURL"] != "")
                    req.webOptions.returnUrl = parameters["returnURL"];
                if (parameters["returnURLDescription"] != "")
                    req.webOptions.returnUrlDescription = parameters["returnURLDescription"];
                if (parameters["cancelURL"] != "")
                    req.webOptions.cancelUrl = parameters["cancelURL"];
                if (parameters["cancelURLDescription"] != "")
                    req.webOptions.cancelUrlDescription = parameters["cancelURLDescription"];
            }           

            // All set. Fire the request            
            AdaptiveAccountsService service = new AdaptiveAccountsService();
            AddBankAccountResponse resp = null;
            try
            {
                resp = service.AddBankAccount(req);
            }
            catch (System.Exception e)
            {
                context.Response.Write(e.Message);
                return;
            }

            // Display response values. 
            Dictionary<string, string> keyResponseParams = new Dictionary<string, string>();
            string redirectUrl = null;
            if (!(resp.responseEnvelope.ack == AckCode.FAILURE) &&
                !(resp.responseEnvelope.ack == AckCode.FAILUREWITHWARNING))
            {
                redirectUrl = ConfigurationManager.AppSettings["PAYPAL_REDIRECT_URL"] 
                    + resp.redirectURL;
                keyResponseParams.Add("Execution status", resp.execStatus.ToString());
                keyResponseParams.Add("Funding source key", resp.fundingSourceKey);
            }
            displayResponse(context, "AddBankAccount", keyResponseParams, service.getLastRequest(), service.getLastResponse(),
                resp.error, redirectUrl);
        }


        /// <summary>
        /// Handle AddPaymentCard API call
        /// </summary>
        /// <param name="context"></param>
        private void AddPaymentCard(HttpContext context)
        {
            NameValueCollection parameters = context.Request.Params;

            NameType nameOnCard = new NameType(parameters["firstName"], parameters["lastName"]);
            if (parameters["salutation"] != "")
                nameOnCard.salutation = parameters["salutation"];
            if (parameters["middleName"] != "")
                nameOnCard.middleName = parameters["middleName"];
            if (parameters["suffix"] != "")
                nameOnCard.suffix = parameters["suffix"];

            AddressType billingAddress = new AddressType(parameters["line1"], parameters["countryCode"]);
            if (parameters["line2"] != "")
                billingAddress.line2 = parameters["line2"];
            if (parameters["city"] != "")
                billingAddress.city = parameters["city"];
            if (parameters["state"] != "")
                billingAddress.state = parameters["state"];
            if (parameters["postalCode"] != "")
                billingAddress.postalCode = parameters["postalCode"];
            
            CardTypeType cardType = 
                (CardTypeType) Enum.Parse(typeof(CardTypeType), parameters["cardType"]);
            ConfirmationType confirmationType = 
                (ConfirmationType) Enum.Parse(typeof(ConfirmationType), parameters["confirmationType"]);

            // Create API request object
            AddPaymentCardRequest req = new AddPaymentCardRequest(new RequestEnvelope(), nameOnCard, billingAddress,
                    parameters["cardNumber"], cardType, confirmationType);
            // set optional parameters
            if (parameters["accountId"] != "")
                req.accountId = parameters["accountId"];
            if (parameters["emailAddress"] != "")
                req.emailAddress = parameters["emailAddress"];
            if (parameters["createAccountKey"] != "")
                req.createAccountKey = parameters["createAccountKey"];
            if (parameters["cardOwnerDateOfBirth"] != "")
                req.cardOwnerDateOfBirth = parameters["cardOwnerDateOfBirth"];
            if (parameters["expirationMonth"] != "" && parameters["expirationYear"] != "")
            {
                req.expirationDate = new CardDateType(
                    Int32.Parse(parameters["expirationMonth"]),
                    Int32.Parse(parameters["expirationYear"]));
            }
            if (parameters["cardVerificationNumber"] != "")
                req.cardVerificationNumber = parameters["cardVerificationNumber"];
            if (parameters["startMonth"] != "" && parameters["startYear"] != "")
            {
                req.expirationDate = new CardDateType(
                    Int32.Parse(parameters["startMonth"]),
                    Int32.Parse(parameters["startYear"]));
            }            
            if (parameters["issueNumber"] != "")
                req.issueNumber = parameters["issueNumber"];
            if (confirmationType == ConfirmationType.WEB &&
                (parameters["returnURL"] != "" || parameters["returnURLDescription"] != ""
                || parameters["cancelURL"] != "" || parameters["cancelURLDescription"] != ""))
            {
                req.webOptions = new WebOptionsType();
                if (parameters["returnURL"] != "")
                    req.webOptions.returnUrl = parameters["returnURL"];
                if (parameters["returnURLDescription"] != "")
                    req.webOptions.returnUrlDescription = parameters["returnURLDescription"];
                if (parameters["cancelURL"] != "")
                    req.webOptions.cancelUrl = parameters["cancelURL"];
                if (parameters["cancelURLDescription"] != "")
                    req.webOptions.cancelUrlDescription = parameters["cancelURLDescription"];
            }

            // All set. Fire the request            
            AdaptiveAccountsService service = new AdaptiveAccountsService();
            AddPaymentCardResponse resp = null;
            try
            {
                resp = service.AddPaymentCard(req);
            }
            catch (System.Exception e)
            {
                context.Response.Write(e.Message);
                return;
            }

            // Display response values. 
            Dictionary<string, string> keyResponseParams = new Dictionary<string, string>();
            string redirectUrl = null;
            if (!(resp.responseEnvelope.ack == AckCode.FAILURE) &&
                !(resp.responseEnvelope.ack == AckCode.FAILUREWITHWARNING))
            {
                keyResponseParams.Add("Execution status", resp.execStatus.ToString());
                keyResponseParams.Add("Funding source key", resp.fundingSourceKey);                
            }
            displayResponse(context, "AddPaymentCard", keyResponseParams, service.getLastRequest(), service.getLastResponse(),
                resp.error, redirectUrl);
        }

        /// <summary>
        /// Handle GetVerifiedStatus API call
        /// </summary>
        /// <param name="context"></param>
        private void GetVerifiedStatus(HttpContext context)
        {
            NameValueCollection parameters = context.Request.Params;
            GetVerifiedStatusRequest req = new GetVerifiedStatusRequest(
                new RequestEnvelope(), parameters["emailAddress"], parameters["matchCriteria"]);
            // set optional parameters
            if (parameters["firstName"] != "")
                req.firstName = parameters["firstName"];
            if (parameters["lastName"] != "")
                req.lastName = parameters["lastName"];

            // All set. Fire the request            
            AdaptiveAccountsService service = new AdaptiveAccountsService();
            GetVerifiedStatusResponse resp = null;
            try
            {
                resp = service.GetVerifiedStatus(req);
            }
            catch (System.Exception e)
            {
                context.Response.Write(e.Message);
                return;
            }

            // Display response values. 
            Dictionary<string, string> keyResponseParams = new Dictionary<string, string>();
            string redirectUrl = null;
            if (!(resp.responseEnvelope.ack == AckCode.FAILURE) &&
                !(resp.responseEnvelope.ack == AckCode.FAILUREWITHWARNING))
            {
                keyResponseParams.Add("Account status", resp.accountStatus);
                if (resp.userInfo != null)
                {
                    keyResponseParams.Add("Account Id", resp.userInfo.accountId);
                    keyResponseParams.Add("Account type", resp.userInfo.accountType);
                }
            }
            displayResponse(context, "GetVerifiedStatus", keyResponseParams, service.getLastRequest(), service.getLastResponse(),
                resp.error, redirectUrl);
        }

        /// <summary>
        /// Handle GetUserAgreement API call
        /// </summary>
        /// <param name="context"></param>
        private void GetUserAgreement(HttpContext context)
        {
            NameValueCollection parameters = context.Request.Params;
            GetUserAgreementRequest req = new GetUserAgreementRequest(new RequestEnvelope());
            // set optional parameters
            if (parameters["createAccountKey"] != "")
                req.createAccountKey = parameters["createAccountKey"];
            if (parameters["countryCode"] != "")
                req.countryCode = parameters["countryCode"];
            if (parameters["languageCode"] != "")
                req.languageCode = parameters["languageCode"];

            // All set. Fire the request            
            AdaptiveAccountsService service = new AdaptiveAccountsService();
            GetUserAgreementResponse resp = null;
            try
            {
                resp = service.GetUserAgreement(req);
            }
            catch (System.Exception e)
            {
                context.Response.Write(e.Message);
                return;
            }

            // Display response values. 
            Dictionary<string, string> keyResponseParams = new Dictionary<string, string>();
            string redirectUrl = null;
            if (!(resp.responseEnvelope.ack == AckCode.FAILURE) &&
                !(resp.responseEnvelope.ack == AckCode.FAILUREWITHWARNING))
            {
                keyResponseParams.Add("Agreement", resp.agreement.Substring(0, 100) + "....");
            }
            displayResponse(context, "GetUserAgreement", keyResponseParams, service.getLastRequest(), service.getLastResponse(),
                resp.error, redirectUrl);
        }


        /// <summary>
        /// Handle SetFundingSourceConfirmed API call
        /// </summary>
        /// <param name="context"></param>
        private void SetFundingSourceConfirmed(HttpContext context)
        {
            NameValueCollection parameters = context.Request.Params;
            SetFundingSourceConfirmedRequest req =
                new SetFundingSourceConfirmedRequest(new RequestEnvelope(), parameters["fundingSourceKey"]);
            // set optional parameters
            if (parameters["accountId"] != "")
                req.accountId = parameters["accountId"];
            if (parameters["emailAddress"] != "")
                req.emailAddress = parameters["emailAddress"];
            
            // All set. Fire the request            
            AdaptiveAccountsService service = new AdaptiveAccountsService();
            SetFundingSourceConfirmedResponse resp = null;
            try
            {
                resp = service.SetFundingSourceConfirmed(req);
            }
            catch (System.Exception e)
            {
                context.Response.Write(e.Message);
                return;
            }

            // Display response values. 
            Dictionary<string, string> keyResponseParams = new Dictionary<string, string>();
            string redirectUrl = null;
            if (!(resp.responseEnvelope.ack == AckCode.FAILURE) &&
                !(resp.responseEnvelope.ack == AckCode.FAILUREWITHWARNING))
            {
                // nothing to add
            }
            displayResponse(context, "SetFundingSourceConfirmed", keyResponseParams, service.getLastRequest(), service.getLastResponse(),
                resp.error, redirectUrl);
        }

        /// <summary>
        /// Utility method for displaying API response
        /// </summary>
        /// <param name="context"></param>
        /// <param name="apiName"></param>
        /// <param name="responseValues"></param>
        /// <param name="requestPayload"></param>
        /// <param name="responsePayload"></param>
        /// <param name="errorMessages"></param>
        /// <param name="redirectUrl"></param>
        private void displayResponse(HttpContext context, string apiName, Dictionary<string, string> responseValues, 
            string requestPayload, string responsePayload, List<ErrorData> errorMessages, string redirectUrl)
        {

            context.Response.Write("<html><head><title>");
            context.Response.Write("PayPal Adaptive Accounts - " + apiName);
            context.Response.Write("</title><link rel='stylesheet' href='Content/sdk.css' type='text/css'/></head><body>");
            context.Response.Write("<h3>" + apiName + " response</h3>");
            if (errorMessages != null && errorMessages.Count > 0)
            {
                context.Response.Write("<div class='section_header'>Error messages</div>");
                context.Response.Write("<div class='note'>Investigate the response object for further error information</div><ul>");
                foreach (ErrorData error in errorMessages)
                {   
                    context.Response.Write("<li>" + error.message + "</li>");       
                }
                context.Response.Write("</ul>");
            }
            if (redirectUrl != null)
            {
                string red = "<div>This API involves a web flow. You must now redirect your user to " + redirectUrl;
                red = red + "<br />Please click <a href='" + redirectUrl + "' target='_blank'>here</a> to try the flow.</div><br/>";
                context.Response.Write(red);
            }
            context.Response.Write("<div class='section_header'>Key values from response</div>");
            context.Response.Write("<div class='note'>Consult response object and reference doc for complete list of response values.</div><table>");
            foreach (KeyValuePair<String, String> entry in responseValues) {
                context.Response.Write("<tr><td class='label'>");
                context.Response.Write(entry.Key);
                context.Response.Write(": </td><td>");
                context.Response.Write(entry.Value);
                context.Response.Write("</td></tr>");
            }

            context.Response.Write("</table><h4>Request:</h4><br/><textarea rows=15 cols=80 readonly>");
            context.Response.Write(requestPayload);
            context.Response.Write("</textarea><br/><h4>Response</h4><br/><textarea rows=15 cols=80 readonly>");
            context.Response.Write(responsePayload);
            context.Response.Write("</textarea>");            
            context.Response.Write("<br/><br/><a href='Default.aspx'>Home<a><br/><br/></body></html>");
        }
    }
}

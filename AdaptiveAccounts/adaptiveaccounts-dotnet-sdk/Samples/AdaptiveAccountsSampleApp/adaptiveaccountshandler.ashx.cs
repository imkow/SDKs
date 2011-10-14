using System;
using System.Data;
using System.Web;
using System.Collections;
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
            context.Response.ContentType = "text/plain";
            String strCall = context.Request.Params["AdaptiveAccountsBtn"];

            if (strCall.Equals("CreateAccount"))
            {
                CreateAccount(context);
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
            CreateAccountRequest req = new CreateAccountRequest();
            req.requestEnvelope = new RequestEnvelope();
            req.requestEnvelope.errorLanguage = "en_US";
            req.name = new NameType(context.Request.Params["firstName"],context.Request.Params["lastName"]);
            req.preferredLanguageCode=context.Request.Params["preferredLangCode"];
            req.address = new AddressType(context.Request.Params["addr1"],context.Request.Params["countryCode"]);
            req.contactPhoneNumber=context.Request.Params["contactNum"];
            req.emailAddress=context.Request.Params["mail"];
            req.currencyCode=context.Request.Params["currencyCode"];
            req.citizenshipCountryCode=context.Request.Params["citiCounCode"];
            req.address.city=context.Request.Params["city"];
            req.address.state=context.Request.Params["state"];
            req.registrationType = context.Request.Params["regType"];
            req.createAccountWebOptions = new CreateAccountWebOptionsType();
            req.createAccountWebOptions.returnUrl=context.Request.Params["returnUrl"];
            req.address.postalCode=context.Request.Params["zipCode"];
            try
            {
                AdaptiveAccountsService service = new AdaptiveAccountsService();
                CreateAccountResponse resp = service.CreateAccount(req);
                context.Response.Write("<html><body><textarea rows=30 cols=80>");
                ObjectDumper.Write(resp, 5, context.Response.Output);
                context.Response.Write("</textarea></body></html>");

                string red = "<br>";
                red = red + "<a href=";
                red = red + ConfigurationManager.AppSettings["PAYPAL_REDIRECT_URL"]
                                + resp.redirectURL;
                red = red + ">Redirect URL (Click to redirect)</a><br>";
                context.Response.Write(red);
            }
            catch (System.Exception e)
            {
                context.Response.Write(e.Message);
            }
        }
    }
}

using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Collections.Generic;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

using PayPal.PayPalAPIInterfaceService;
using PayPal.PayPalAPIInterfaceService.Model;

namespace PayPalAPISample.APICalls
{
    public partial class DoAuthorization : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object

            DoAuthorizationRequestType request =
                new DoAuthorizationRequestType();

            request.TransactionID = transactionId.Value;
            CurrencyCodeType currency = (CurrencyCodeType)
                Enum.Parse(typeof(CurrencyCodeType), currencyCode.SelectedValue);
            request.Amount = new BasicAmountType(currency, amount.Value);

            // Invoke the API
            DoAuthorizationReq wrapper = new DoAuthorizationReq();
            wrapper.DoAuthorizationRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            DoAuthorizationResponseType doAuthorizationResponse =
                    service.DoAuthorization(wrapper);


            // Check for API return status
            setKeyResponseObjects(service, doAuthorizationResponse);
        }

        // A helper method used by APIResponse.aspx that returns select response parameters 
        // of interest. You must process API response objects as applicable to your application
        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, DoAuthorizationResponseType response)
        {
            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            responseParams.Add("Transaction Id", response.TransactionID);
            responseParams.Add("Payment status", response.AuthorizationInfo.PaymentStatus.ToString());
            responseParams.Add("Pending reason", response.AuthorizationInfo.PendingReason.ToString());

            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_keyResponseObject", responseParams);
            CurrContext.Items.Add("Response_apiName", "DoAuthorization");
            CurrContext.Items.Add("Response_redirectURL", null);
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());

            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                CurrContext.Items.Add("Response_error", response.Errors);
            }
            else
            {
                CurrContext.Items.Add("Response_error", null);
                responseParams.Add("Transaction ID", response.TransactionID);
                responseParams.Add("Payment status", response.AuthorizationInfo.PaymentStatus.ToString());
            }
            Server.Transfer("../APIResponse.aspx");
        }

    }
}

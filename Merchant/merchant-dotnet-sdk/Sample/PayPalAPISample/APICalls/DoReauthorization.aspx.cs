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
    public partial class DoReauthorization : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object

            DoReauthorizationRequestType request =
                new DoReauthorizationRequestType();

            request.AuthorizationID = authorizationId.Value;
            CurrencyCodeType currency = (CurrencyCodeType)
                Enum.Parse(typeof(CurrencyCodeType), currencyCode.SelectedValue);
            request.Amount = new BasicAmountType(currency, amount.Value);

            // Invoke the API
            DoReauthorizationReq wrapper = new DoReauthorizationReq();
            wrapper.DoReauthorizationRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            DoReauthorizationResponseType doReauthorizationResponse =
                    service.DoReauthorization(wrapper);

            // Check for API return status
            setKeyResponseObjects(service, doReauthorizationResponse);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, DoReauthorizationResponseType response)
        {
            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            responseParams.Add("Correlation Id", response.CorrelationID);
            responseParams.Add("API Result", response.Ack.ToString());
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_keyResponseObject", responseParams);
            CurrContext.Items.Add("Response_apiName", "DoReauthorization");
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
                responseParams.Add("Authorization ID", response.AuthorizationID);
                responseParams.Add("Payment status", response.AuthorizationInfo.PaymentStatus.ToString());
            }
            Server.Transfer("../APIResponse.aspx");

        }

    }
}

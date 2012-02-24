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
    public partial class GetExpressCheckoutDetails : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            // Prepopulate EC Token value if coming from another page
            if (Request.Params["token"] != null && token.Value == "")
            {
                token.Value = Request.Params["token"];
            }
        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            GetExpressCheckoutDetailsRequestType request = new GetExpressCheckoutDetailsRequestType();
            request.Token = token.Value;

            // Invoke the API
            GetExpressCheckoutDetailsReq wrapper = new GetExpressCheckoutDetailsReq();
            wrapper.GetExpressCheckoutDetailsRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            GetExpressCheckoutDetailsResponseType ecResponse = service.GetExpressCheckoutDetails(wrapper);

            // Check for API return status
            setKeyResponseObjects(service, ecResponse);

        }

        // A helper method used by APIResponse.aspx that returns select response parameters 
        // of interest. 
        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, GetExpressCheckoutDetailsResponseType response)
        {
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_apiName", "GetExpressChecoutDetails");
            CurrContext.Items.Add("Response_redirectURL", null);
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());

            Dictionary<string, string> keyResponseParameters = new Dictionary<string, string>();
            keyResponseParameters.Add("Correlation Id", response.CorrelationID);
            keyResponseParameters.Add("API Result", response.Ack.ToString());

            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                CurrContext.Items.Add("Response_error", response.Errors);
            }
            else
            {
                CurrContext.Items.Add("Response_error", null);
            }
            CurrContext.Items.Add("Response_keyResponseObject", keyResponseParameters);
            Server.Transfer("../APIResponse.aspx");
        }

    }
}

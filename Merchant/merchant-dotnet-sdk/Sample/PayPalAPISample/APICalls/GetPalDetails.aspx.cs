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
    public partial class GetPalDetails : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            // GetPalDetails does not require you to pass any data other than your credentials
            GetPalDetailsRequestType request = new GetPalDetailsRequestType();

            // Invoke the API
            GetPalDetailsReq wrapper = new GetPalDetailsReq();
            wrapper.GetPalDetailsRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            GetPalDetailsResponseType palDetails = service.GetPalDetails(wrapper);

            // Check for API return status
            setKeyResponseParams(service, palDetails);
        }

        private void setKeyResponseParams(PayPalAPIInterfaceServiceService service, GetPalDetailsResponseType response)
        {
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_apiName", "GetPalDetails");
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
                keyResponseParameters.Add("Pal Id", response.Pal);
            }
            CurrContext.Items.Add("Response_keyResponseObject", keyResponseParameters);
            Server.Transfer("../APIResponse.aspx");
        }
    }
}

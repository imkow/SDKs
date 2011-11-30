using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Collections.Generic;
using System.Web;
using System.Web.Security;
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
            Session["Response_apiName"] = "GetPalDetails";
            Session["Response_redirectURL"] = null;
            Session["Response_requestPayload"] = service.getLastRequest();
            Session["Response_responsePayload"] = service.getLastResponse();

            Dictionary<string, string> keyResponseParameters = new Dictionary<string, string>();
            keyResponseParameters.Add("Correlation Id", response.CorrelationID);
            keyResponseParameters.Add("API Result", response.Ack.ToString());

            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))

            {
                Session["Response_error"] = response.Errors;
            }
            else
            {
                Session["Response_error"] = null;
                keyResponseParameters.Add("Pal Id", response.Pal);
            }
            Session["Response_keyResponseObject"] = keyResponseParameters;
            Response.Redirect("../APIResponse.aspx");
        }
    }
}

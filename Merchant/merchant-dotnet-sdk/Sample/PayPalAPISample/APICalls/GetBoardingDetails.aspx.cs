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
    public partial class GetBoardingDetails : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            GetBoardingDetailsRequestType request = new GetBoardingDetailsRequestType();
            request.Token = token.Value;

            // Invoke the API
            GetBoardingDetailsReq wrapper = new GetBoardingDetailsReq();
            wrapper.GetBoardingDetailsRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            GetBoardingDetailsResponseType enterBoardingResponse = service.GetBoardingDetails(wrapper);

            // Check for API return status
            processResponse(service, enterBoardingResponse);
        }

        private void processResponse(PayPalAPIInterfaceServiceService service, GetBoardingDetailsResponseType response)
        {
            Session["Response_apiName"] = "GetBoardingDetails";
            Session["Response_redirectURL"] = null;
            Session["Response_requestPayload"] = service.getLastRequest();
            Session["Response_responsePayload"] = service.getLastResponse();

            Dictionary<string, string> keyParameters = new Dictionary<string, string>();
            keyParameters.Add("Correlation Id", response.CorrelationID);
            keyParameters.Add("API Result", response.Ack.ToString());

            if (response.Errors != null && response.Errors.Count > 0)
            {
                Session["Response_error"] = response.Errors;
            }
            else
            {
                Session["Response_error"] = null;
            }

            if (!response.Ack.Equals(AckCodeType.FAILURE))
            {
            }
            Session["Response_keyResponseObject"] = keyParameters;
            Response.Redirect("../APIResponse.aspx");
            
        }
    }
}

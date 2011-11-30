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

using PayPal.Manager;
using PayPal.PayPalAPIInterfaceService;
using PayPal.PayPalAPIInterfaceService.Model;

namespace PayPalAPISample.APICalls
{
    public partial class EnterBoarding : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            EnterBoardingRequestType request = new EnterBoardingRequestType();
            EnterBoardingRequestDetailsType boardingDetails = new EnterBoardingRequestDetailsType();
            boardingDetails.ProductList = productList.Value;
            boardingDetails.ProgramCode = programCode.Value;
            boardingDetails.ImageUrl = imageUrl.Value;
            request.EnterBoardingRequestDetails = boardingDetails;

            // Invoke the API
            EnterBoardingReq wrapper = new EnterBoardingReq();
            wrapper.EnterBoardingRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            EnterBoardingResponseType enterBoardingResponse = service.EnterBoarding(wrapper);

            // Check for API return status
            processResponse(service, enterBoardingResponse);
        }

        private void processResponse(PayPalAPIInterfaceServiceService service, EnterBoardingResponseType response)
        {
            Session["Response_apiName"] = "EnterBoarding";
            if (response.Token != null)
            {
                Session["Response_redirectURL"] = ConfigManager.Instance.GetProperty("paypalUrl")
                    + "_partner-onboard-flow&onboarding_token=" + response.Token;
            }
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

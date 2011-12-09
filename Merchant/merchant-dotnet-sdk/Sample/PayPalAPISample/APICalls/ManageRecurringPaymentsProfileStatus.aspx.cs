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
    public partial class ManageRecurringPaymentsProfileStatus : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            
            ManageRecurringPaymentsProfileStatusRequestType request =
                new ManageRecurringPaymentsProfileStatusRequestType();
            ManageRecurringPaymentsProfileStatusRequestDetailsType details =
                new ManageRecurringPaymentsProfileStatusRequestDetailsType();
            request.ManageRecurringPaymentsProfileStatusRequestDetails = details;
            details.ProfileID = profileId.Value;
            details.Action = (StatusChangeActionType)
                Enum.Parse(typeof(StatusChangeActionType), action.SelectedValue);
            if (note.Value != "")
            {
                details.Note = note.Value;
            }

            // Invoke the API
            ManageRecurringPaymentsProfileStatusReq wrapper = new ManageRecurringPaymentsProfileStatusReq();
            wrapper.ManageRecurringPaymentsProfileStatusRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            ManageRecurringPaymentsProfileStatusResponseType manageProfileStatusResponse =
                    service.ManageRecurringPaymentsProfileStatus(wrapper);


            // Check for API return status
            setKeyResponseObjects(service, manageProfileStatusResponse);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, ManageRecurringPaymentsProfileStatusResponseType response)
        {
            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            responseParams.Add("API Status", response.Ack.ToString());
            Session["Response_redirectURL"] = null;
            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                Session["Response_error"] = response.Errors;
            }
            else
            {
                Session["Response_error"] = null;
                responseParams.Add("Profile Id", response.ManageRecurringPaymentsProfileStatusResponseDetails.ProfileID);                
            }
            Session["Response_keyResponseObject"] = responseParams;
            Session["Response_apiName"] = "ManageRecurringPaymentsProfileStatus";
            Session["Response_requestPayload"] = service.getLastRequest();
            Session["Response_responsePayload"] = service.getLastResponse();
            Response.Redirect("../APIResponse.aspx");
        }

    }
}
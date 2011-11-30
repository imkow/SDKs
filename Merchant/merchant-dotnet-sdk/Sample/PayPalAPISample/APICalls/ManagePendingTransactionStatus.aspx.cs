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
    public partial class ManagePendingTransactionStatus : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            ManagePendingTransactionStatusRequestType request =
                new ManagePendingTransactionStatusRequestType();
            request.TransactionID = transactionId.Value;
            request.Action = (FMFPendingTransactionActionType)
                Enum.Parse(typeof(FMFPendingTransactionActionType), action.SelectedValue);

            // Invoke the API
            ManagePendingTransactionStatusReq wrapper = new ManagePendingTransactionStatusReq();
            wrapper.ManagePendingTransactionStatusRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            ManagePendingTransactionStatusResponseType manageProfileStatusResponse =
                    service.ManagePendingTransactionStatus(wrapper);


            // Check for API return status
            setKeyResponseObjects(service, manageProfileStatusResponse);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, ManagePendingTransactionStatusResponseType response)
        {
            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            Session["Response_keyResponseObject"] = responseParams;

            Session["Response_apiName"] = "ManagePendingTransactionStatus";
            Session["Response_redirectURL"] = null;
            Session["Response_requestPayload"] = service.getLastRequest();
            Session["Response_responsePayload"] = service.getLastResponse();

            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                Session["Response_error"] = response.Errors;
            }
            else
            {
                Session["Response_error"] = null;
                responseParams.Add("Transaction Id", response.TransactionID);
                responseParams.Add("Status", response.Status);
            }
            Response.Redirect("../APIResponse.aspx");

        }
    }
}

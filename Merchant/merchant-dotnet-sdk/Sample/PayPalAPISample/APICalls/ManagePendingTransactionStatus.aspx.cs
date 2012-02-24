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
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_keyResponseObject", responseParams);

            CurrContext.Items.Add("Response_apiName", "ManagePendingTransactionStatus");
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
                responseParams.Add("Transaction Id", response.TransactionID);
                responseParams.Add("Status", response.Status);
            }
            Server.Transfer("../APIResponse.aspx");

        }
    }
}

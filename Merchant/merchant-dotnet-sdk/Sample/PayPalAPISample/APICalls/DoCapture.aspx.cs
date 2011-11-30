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
    public partial class DoCapture : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object

            DoCaptureRequestType request =
                new DoCaptureRequestType();

            request.AuthorizationID = authorizationId.Value;
            CurrencyCodeType currency = (CurrencyCodeType)
                Enum.Parse(typeof(CurrencyCodeType), currencyCode.SelectedValue);
            request.Amount = new BasicAmountType(currency, amount.Value);
            if (completeType.SelectedIndex != 0)
            {
                request.CompleteType = (CompleteCodeType)
                    Enum.Parse(typeof(CompleteCodeType), completeType.SelectedValue);
            }
            if (note.Value != "")
            {
                request.Note = note.Value;
            }
            if (invoiceId.Value != "")
            {
                request.InvoiceID = invoiceId.Value;
            }
            if (softDescriptor.Value != "")
            {
                request.Descriptor = softDescriptor.Value;
            }

            // Invoke the API
            DoCaptureReq wrapper = new DoCaptureReq();
            wrapper.DoCaptureRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            DoCaptureResponseType doCaptureResponse =
                    service.DoCapture(wrapper);


            // Check for API return status
            setKeyResponseObjects(service, doCaptureResponse);
        }

        // A helper method used by APIResponse.aspx that returns select response parameters 
        // of interest. You must process API response objects as applicable to your application
        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, DoCaptureResponseType doCaptureResponse)
        {
            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            Session["Response_keyResponseObject"] = responseParams;

            Session["Response_apiName"] = "DoCapture";
            Session["Response_redirectURL"] = null;
            Session["Response_requestPayload"] = service.getLastRequest();
            Session["Response_responsePayload"] = service.getLastResponse();

            if (doCaptureResponse.Ack.Equals(AckCodeType.FAILURE) ||
                (doCaptureResponse.Errors != null && doCaptureResponse.Errors.Count > 0))
            {
                Session["Response_error"] = doCaptureResponse.Errors;
            }
            else
            {
                Session["Response_error"] = null;
                responseParams.Add("Transaction Id", doCaptureResponse.DoCaptureResponseDetails.PaymentInfo.TransactionID);
                responseParams.Add("Payment status", doCaptureResponse.DoCaptureResponseDetails.PaymentInfo.PaymentStatus.ToString());
                responseParams.Add("Pending reason", doCaptureResponse.DoCaptureResponseDetails.PaymentInfo.PendingReason.ToString());
            }
            Response.Redirect("../APIResponse.aspx");
        }

    }
}

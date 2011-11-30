using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Collections.Generic;

using PayPal.PayPalAPIInterfaceService;
using PayPal.PayPalAPIInterfaceService.Model;

namespace PayPalAPISample.APICalls
{
    public partial class DoExpressCheckout : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            DoExpressCheckoutPaymentRequestType request = new DoExpressCheckoutPaymentRequestType();
            DoExpressCheckoutPaymentRequestDetailsType requestDetails = new DoExpressCheckoutPaymentRequestDetailsType();
            request.DoExpressCheckoutPaymentRequestDetails = requestDetails;
            // TODO: 
            requestDetails.PaymentDetails = (List<PaymentDetailsType>) Session["paymentDetails"];
            requestDetails.Token = token.Value;
            requestDetails.PayerID = payerId.Value;
            requestDetails.PaymentAction = (PaymentActionCodeType)
                Enum.Parse(typeof(PaymentActionCodeType), paymentAction.SelectedValue);

            // Invoke the API
            DoExpressCheckoutPaymentReq wrapper = new DoExpressCheckoutPaymentReq();
            wrapper.DoExpressCheckoutPaymentRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            DoExpressCheckoutPaymentResponseType doECResponse = service.DoExpressCheckoutPayment(wrapper);

            // Check for API return status
            setKeyResponseObjects(service, doECResponse);
        }

        // A helper method used by APIResponse.aspx that returns select response parameters 
        // of interest. You must process API response objects as applicable to your application
        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, DoExpressCheckoutPaymentResponseType doECResponse)
        {
            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            responseParams.Add("Correlation Id", doECResponse.CorrelationID);
            responseParams.Add("API Result", doECResponse.Ack.ToString());

            if (doECResponse.Ack.Equals(AckCodeType.FAILURE) ||
                (doECResponse.Errors != null && doECResponse.Errors.Count > 0))
            {
                Session["Response_error"] = doECResponse.Errors;
            }
            else
            {
                Session["Response_error"] = null;
                responseParams.Add("EC Token", doECResponse.DoExpressCheckoutPaymentResponseDetails.Token);
                responseParams.Add("Transaction Id", doECResponse.DoExpressCheckoutPaymentResponseDetails.PaymentInfo[0].TransactionID);
                responseParams.Add("Payment status", doECResponse.DoExpressCheckoutPaymentResponseDetails.PaymentInfo[0].PaymentStatus.ToString());
                if (doECResponse.DoExpressCheckoutPaymentResponseDetails.PaymentInfo[0].PendingReason != null)
                {
                    responseParams.Add("Pending reason", doECResponse.DoExpressCheckoutPaymentResponseDetails.PaymentInfo[0].PendingReason.ToString());
                }
                if (doECResponse.DoExpressCheckoutPaymentResponseDetails.BillingAgreementID != null)
                    responseParams.Add("Billing Agreement Id", doECResponse.DoExpressCheckoutPaymentResponseDetails.BillingAgreementID);
            }

            Session["Response_keyResponseObject"] = responseParams;
            Session["Response_apiName"] = "DoExpressChecoutPayment";
            Session["Response_redirectURL"] = null;
            Session["Response_requestPayload"] = service.getLastRequest();
            Session["Response_responsePayload"] = service.getLastResponse();
            Response.Redirect("../APIResponse.aspx");
        }

    }
}

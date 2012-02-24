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
    public partial class DoUATPExpressCheckoutPayment : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            DoUATPExpressCheckoutPaymentRequestType request = new DoUATPExpressCheckoutPaymentRequestType();
            DoExpressCheckoutPaymentRequestDetailsType paymentDetails = new DoExpressCheckoutPaymentRequestDetailsType();
            request.DoExpressCheckoutPaymentRequestDetails = paymentDetails;
            paymentDetails.PayerID = payerID.Value;
            paymentDetails.Token = token.Value;
            paymentDetails.PaymentAction = (PaymentActionCodeType)
                Enum.Parse(typeof(PaymentActionCodeType), paymentAction.SelectedValue);

            // Set payment amount
            CurrencyCodeType currency = (CurrencyCodeType)
                Enum.Parse(typeof(CurrencyCodeType), currencyID.Value);
            paymentDetails.PaymentDetails.Add(new PaymentDetailsType());
            paymentDetails.PaymentDetails[0].OrderTotal = 
                new BasicAmountType(currency, amount.Value);

            // Invoke the API
            DoUATPExpressCheckoutPaymentReq wrapper = new DoUATPExpressCheckoutPaymentReq();
            wrapper.DoUATPExpressCheckoutPaymentRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            DoUATPExpressCheckoutPaymentResponseType response = service.DoUATPExpressCheckoutPayment(wrapper);

            // Check for API return status
            setKeyResponseObjects(service, response);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, DoUATPExpressCheckoutPaymentResponseType response)
        {
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_apiName", "DoUATPExpressCheckoutPayment");
            CurrContext.Items.Add("Response_redirectURL", null);
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());

            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            responseParams.Add("Correlation Id", response.CorrelationID);
            responseParams.Add("API Result", response.Ack.ToString());

            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                CurrContext.Items.Add("Response_error", response.Errors);
            }
            else
            {
                CurrContext.Items.Add("Response_error", null);
                responseParams.Add("Transaction Id", response.DoExpressCheckoutPaymentResponseDetails.PaymentInfo[0].TransactionID);
                responseParams.Add("UATP number", response.UATPDetails.UATPNumber);
            }
            CurrContext.Items.Add("Response_keyResponseObject", responseParams);
            Server.Transfer("../APIResponse.aspx");

        }
    }
}

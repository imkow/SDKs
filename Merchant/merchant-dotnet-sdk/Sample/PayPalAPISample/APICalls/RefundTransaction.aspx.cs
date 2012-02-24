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
    public partial class RefundTransaction : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void calDate_SelectionChanged(object sender, EventArgs e)
        {
            retryUntil.Text = calDate.SelectedDate.ToString("yyyy-MM-ddTHH:mm:ss");
        }
        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            RefundTransactionRequestType request = new RefundTransactionRequestType();
            request.TransactionID = transactionId.Value;
            if (refundType.SelectedIndex != 0)
            {
                request.RefundType = (RefundType)
                    Enum.Parse(typeof(RefundType), refundType.SelectedValue);
                if (request.RefundType.Equals(RefundType.PARTIAL) && refundAmount.Value != "")
                {
                    CurrencyCodeType currency = (CurrencyCodeType)
                        Enum.Parse(typeof(CurrencyCodeType), currencyCode.SelectedValue);
                    request.Amount = new BasicAmountType(currency, refundAmount.Value);
                }
            }
            if (memo.Value != "")
            {
                request.Memo = memo.Value;
            }
            if (retryUntil.Text != "")
            {
                request.RetryUntil = retryUntil.Text;
            }
            if (refundSource.SelectedIndex != 0)
            {
                request.RefundSource = (RefundSourceCodeType)
                    Enum.Parse(typeof(RefundSourceCodeType), refundSource.SelectedValue);
            }
            

            // Invoke the API
            RefundTransactionReq wrapper = new RefundTransactionReq();
            wrapper.RefundTransactionRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            RefundTransactionResponseType refundTransactionResponse = service.RefundTransaction(wrapper);

            // Check for API return status
            processResponse(service, refundTransactionResponse);
        }

        private void processResponse(PayPalAPIInterfaceServiceService service, RefundTransactionResponseType response)
        {
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_apiName", "RefundTransaction");
            CurrContext.Items.Add("Response_redirectURL", null);
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());

            Dictionary<string, string> keyParameters = new Dictionary<string, string>();
            keyParameters.Add("Correlation Id", response.CorrelationID);
            keyParameters.Add("API Result", response.Ack.ToString());

            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                CurrContext.Items.Add("Response_error", response.Errors);
            }
            else
            {
                CurrContext.Items.Add("Response_error", null);
                keyParameters.Add("Refund transaction Id", response.RefundTransactionID);
                keyParameters.Add("Total refunded amount", 
                    response.TotalRefundedAmount.value + response.TotalRefundedAmount.currencyID);
            }
            CurrContext.Items.Add("Response_keyResponseObject", keyParameters);
            Server.Transfer("../APIResponse.aspx");

        }

    }
}

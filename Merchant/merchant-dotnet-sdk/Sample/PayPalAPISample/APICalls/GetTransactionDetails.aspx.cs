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
    public partial class GetTransactionDetails : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Search_Submit(object sender, EventArgs e)
        {
            // Create request object
            GetTransactionDetailsRequestType request = new GetTransactionDetailsRequestType();
            request.TransactionID = transactionId.Value;            

            // Invoke the API
            GetTransactionDetailsReq wrapper = new GetTransactionDetailsReq();
            wrapper.GetTransactionDetailsRequest = request;            
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            GetTransactionDetailsResponseType transactionDetails = service.GetTransactionDetails(wrapper);

            // Check for API return status
            processResponse(service, transactionDetails);
        }

        private void processResponse(PayPalAPIInterfaceServiceService service, GetTransactionDetailsResponseType response)
        {
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_apiName", "GetTransactionDetails");
            CurrContext.Items.Add("Response_redirectURL", null);
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());

            Dictionary<string, string> keyResponseParameters = new Dictionary<string, string>();
            keyResponseParameters.Add("Correlation Id", response.CorrelationID);
            keyResponseParameters.Add("API Result", response.Ack.ToString());

            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                CurrContext.Items.Add("Response_error", response.Errors);
            }
            else
            {
                CurrContext.Items.Add("Response_error", null);
                PaymentTransactionType transactionDetails = response.PaymentTransactionDetails;
                keyResponseParameters.Add("Payment receiver", transactionDetails.ReceiverInfo.Receiver);
                keyResponseParameters.Add("Payer", transactionDetails.PayerInfo.Payer);
                keyResponseParameters.Add("Payment date", transactionDetails.PaymentInfo.PaymentDate);
                keyResponseParameters.Add("Payment status", transactionDetails.PaymentInfo.PaymentStatus.ToString());
                keyResponseParameters.Add("Gross amount",
                    transactionDetails.PaymentInfo.GrossAmount.value + transactionDetails.PaymentInfo.GrossAmount.currencyID.ToString());

                if (transactionDetails.PaymentInfo.SettleAmount != null)
                {
                    keyResponseParameters.Add("Settlement amount", 
                        transactionDetails.PaymentInfo.SettleAmount.value + transactionDetails.PaymentInfo.SettleAmount.currencyID.ToString());
                }
            }
            CurrContext.Items.Add("Response_keyResponseObject", keyResponseParameters);
            Server.Transfer("../APIResponse.aspx");

        }
    }
}

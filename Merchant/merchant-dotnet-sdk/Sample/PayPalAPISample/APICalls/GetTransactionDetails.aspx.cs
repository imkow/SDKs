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
            Session["Response_apiName"] = "GetTransactionDetails";
            Session["Response_redirectURL"] = null;
            Session["Response_requestPayload"] = service.getLastRequest();
            Session["Response_responsePayload"] = service.getLastResponse();

            Dictionary<string, string> keyResponseParameters = new Dictionary<string, string>();
            keyResponseParameters.Add("Correlation Id", response.CorrelationID);
            keyResponseParameters.Add("API Result", response.Ack.ToString());

            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                Session["Response_error"] = response.Errors;
            }
            else
            {
                Session["Response_error"] = null;
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
            Session["Response_keyResponseObject"] = keyResponseParameters;
            Response.Redirect("../APIResponse.aspx");

        }
    }
}

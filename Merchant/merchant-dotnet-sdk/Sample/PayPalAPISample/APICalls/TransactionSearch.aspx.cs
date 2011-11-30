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
    public partial class TransactionSearch : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void calDate_SelectionChanged(object sender, EventArgs e)
        {
            Calendar calendar = (Calendar)sender;
            if(calendar.ID.Equals("calStartDate")) 
            {
                startDate.Text = calendar.SelectedDate.ToString("yyyy-MM-ddTHH:mm:ss");
            } 
            else if (calendar.ID.Equals("calEndDate")) 
            {
                endDate.Text = calendar.SelectedDate.ToString("yyyy-MM-ddTHH:mm:ss");
            }
        }


        protected void Search_Submit(object sender, EventArgs e)
        {
            // Create request object
            TransactionSearchRequestType request = new TransactionSearchRequestType();           
            if (transactionID.Value != "")
            {
                request.TransactionID = transactionID.Value;
            }
            if (startDate != null && startDate.Text != null)
            {
                request.StartDate = startDate.Text;
            }
            if (endDate != null && endDate.Text != null)
            {
                request.EndDate = endDate.Text;
            }
            if (payer.Value != "")
            {
                request.Payer = payer.Value;
            }
            if (receiver.Value != "")
            {
                request.Receiver = receiver.Value;
            }
            if (receiptId.Value != "")
            {
                request.ReceiptID = receiptId.Value;
            }
            if (profileId.Value != "")
            {
                request.ProfileID = profileId.Value;
            }
            if (auctionItemNumber.Value != "")
            {
                request.AuctionItemNumber = auctionItemNumber.Value;
            }
            if (invoiceID.Value != "")
            {
                request.InvoiceID = invoiceID.Value;
            }
            if (cardNumber.Value != "")
            {
                request.CardNumber = cardNumber.Value;
            }
            if (transactionClass.SelectedIndex != 0)
            {
                request.TransactionClass = (PaymentTransactionClassCodeType)
                    Enum.Parse(typeof(PaymentTransactionClassCodeType), transactionClass.SelectedValue);
            }
            if (amount.Value != "" && currencyCode.SelectedIndex != 0)
            {
                request.CurrencyCode = (CurrencyCodeType)
                    Enum.Parse(typeof(CurrencyCodeType), currencyCode.SelectedValue);
                BasicAmountType searchAmount = new BasicAmountType(request.CurrencyCode, amount.Value);
                request.Amount = searchAmount;
                
            }
            if (transactionStatus.SelectedIndex != 0)
            {
                request.Status = (PaymentTransactionStatusCodeType)
                    Enum.Parse(typeof(PaymentTransactionStatusCodeType), transactionStatus.SelectedValue);
            }

            
            // Invoke the API
            TransactionSearchReq wrapper = new TransactionSearchReq();
            wrapper.TransactionSearchRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            TransactionSearchResponseType transactionDetails = service.TransactionSearch(wrapper);

            // Check for API return status
            processResponse(service, transactionDetails);
        }

        private void processResponse(PayPalAPIInterfaceServiceService service, TransactionSearchResponseType response)
        {
            Session["Response_apiName"] = "TransactionSearch";
            Session["Response_redirectURL"] = null;
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

            if(!response.Ack.Equals(AckCodeType.FAILURE))
            {
                keyParameters.Add("Total matching transactions", response.PaymentTransactions.Count.ToString());

                for (int i = 0; i < response.PaymentTransactions.Count; i++ )
                {
                    PaymentTransactionSearchResultType result = response.PaymentTransactions[i];
                    String label = "Result " + (i+1);
                    keyParameters.Add(label + " Payer", result.Payer);
                    keyParameters.Add(label + " Transaction Id", result.TransactionID);
                    keyParameters.Add(label + " Payment status", result.Status);
                    keyParameters.Add(label + " Payment timestamp", result.Timestamp);
                    keyParameters.Add(label + " Transaction type", result.Type);
                    keyParameters.Add(label + " Net amount",
                        result.NetAmount.value + result.NetAmount.currencyID.ToString());
                    keyParameters.Add(label + " Gross amount",
                        result.GrossAmount.value + result.GrossAmount.currencyID.ToString());
                }
            }
            Session["Response_keyResponseObject"] = keyParameters;
            Response.Redirect("../APIResponse.aspx");

        }
    }
}

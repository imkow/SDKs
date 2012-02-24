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
    public partial class DoNonReferencedCredit : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void calDate_SelectionChanged(object sender, EventArgs e)
        {
            cardExpiryDate.Text = calDate.SelectedDate.ToString("MM/yyyy");
        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            DoNonReferencedCreditRequestType request = new DoNonReferencedCreditRequestType();
            request.DoNonReferencedCreditRequestDetails = new DoNonReferencedCreditRequestDetailsType();

            CurrencyCodeType currency = (CurrencyCodeType)
                Enum.Parse( typeof(CurrencyCodeType), currencyId.Value);
            request.DoNonReferencedCreditRequestDetails.Amount = new BasicAmountType(currency, itemAmount.Value);

            CreditCardDetailsType creditCard = new CreditCardDetailsType();
            request.DoNonReferencedCreditRequestDetails.CreditCard = creditCard;
            creditCard.CreditCardNumber = creditCardNumber.Value;
            creditCard.CreditCardType = (CreditCardTypeType)
                Enum.Parse(typeof(CreditCardTypeType), creditCardType.SelectedValue);
            creditCard.CVV2 = cvv.Value;
            string[] cardExpiryDetails = cardExpiryDate.Text.Split(new char[] { '/' });
            creditCard.ExpMonth = Int32.Parse(cardExpiryDetails[0]);
            creditCard.ExpYear = Int32.Parse(cardExpiryDetails[1]);

            if (comment.Value != "")
            {
                request.DoNonReferencedCreditRequestDetails.Comment = comment.Value;
            }
            // Invoke the API
            DoNonReferencedCreditReq wrapper = new DoNonReferencedCreditReq();
            wrapper.DoNonReferencedCreditRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            DoNonReferencedCreditResponseType DoNonReferencedCreditResponse = service.DoNonReferencedCredit(wrapper);

            // Check for API return status
            setKeyResponseObjects(service, DoNonReferencedCreditResponse);
        }

        // A helper method used by APIResponse.aspx that returns select response parameters 
        // of interest. 
        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, DoNonReferencedCreditResponseType response)
        {
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_apiName", "DoNonReferencedCredit");
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
                keyResponseParameters.Add("Transaction ID", response.DoNonReferencedCreditResponseDetails.TransactionID);
            }
            CurrContext.Items.Add("Response_keyResponseObject", keyResponseParameters);
            Server.Transfer("../APIResponse.aspx");
        }
    }
}

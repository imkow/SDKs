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
    public partial class DoDirectPayment : System.Web.UI.Page
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
            DoDirectPaymentRequestType request = new DoDirectPaymentRequestType();
            DoDirectPaymentRequestDetailsType requestDetails = new DoDirectPaymentRequestDetailsType();
            request.DoDirectPaymentRequestDetails = requestDetails;

            requestDetails.PaymentAction = (PaymentActionCodeType)
                Enum.Parse(typeof(PaymentActionCodeType), paymentType.SelectedValue);
            
            // Populate card requestDetails
            CreditCardDetailsType creditCard = new CreditCardDetailsType();
            
            PayerInfoType payer = new PayerInfoType();
            PersonNameType name = new PersonNameType();
            name.FirstName = firstName.Value;
            name.LastName = lastName.Value;
            payer.PayerName = name;
            creditCard.CardOwner = payer;

            creditCard.CreditCardNumber = creditCardNumber.Value;
            creditCard.CreditCardType = (CreditCardTypeType)
                Enum.Parse(typeof(CreditCardTypeType), creditCardType.SelectedValue);
            creditCard.CVV2 = cvv2Number.Value;
            string[] cardExpiryDetails = cardExpiryDate.Text.Split(new char[] { '/' });
            creditCard.ExpMonth = Int32.Parse(cardExpiryDetails[0]);
            creditCard.ExpYear = Int32.Parse(cardExpiryDetails[1]);

            // Populate shipping address, if given
            AddressType shipTo = new AddressType();
            shipTo.Name = firstName.Value + " " + lastName.Value;
            shipTo.Street1 = street1.Value;
            shipTo.Street2 = street2.Value;
            shipTo.CityName = city.Value;
            shipTo.StateOrProvince = state.Value;
            shipTo.Country = (CountryCodeType) Enum.Parse( typeof(CountryCodeType), country.Value);
            shipTo.PostalCode = postalCode.Value;
            requestDetails.PaymentDetails.ShipToAddress = shipTo;

            // Populate payment requestDetails
            CurrencyCodeType currency = (CurrencyCodeType)
                Enum.Parse(typeof(CurrencyCodeType), currencyCode.SelectedValue);
            BasicAmountType paymentAmount = new BasicAmountType(currency, amount.Value);
            requestDetails.PaymentDetails.OrderTotal = paymentAmount;


            // Invoke the API
            DoDirectPaymentReq wrapper = new DoDirectPaymentReq();
            wrapper.DoDirectPaymentRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            DoDirectPaymentResponseType response = service.DoDirectPayment(wrapper);
         
            // Check for API return status
            setKeyResponseObjects(service, response);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, DoDirectPaymentResponseType response)
        {
            Session["Response_apiName"] = "DoDirectPayment";
            Session["Response_redirectURL"] = null;
            Session["Response_requestPayload"] = service.getLastRequest();
            Session["Response_responsePayload"] = service.getLastResponse();

            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            responseParams.Add("Correlation Id", response.CorrelationID);
            responseParams.Add("API Result", response.Ack.ToString());

            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                Session["Response_error"] = response.Errors;
            }
            else
            {
                Session["Response_error"] = null;                
                responseParams.Add("Transaction Id", response.TransactionID);
                responseParams.Add("Payment status", response.PaymentStatus.ToString());
                if(response.PendingReason != null) {
                    responseParams.Add("Pending reason", response.PendingReason.ToString());
                }
            }
            Session["Response_keyResponseObject"] = responseParams;
            Response.Redirect("../APIResponse.aspx");
            
        }
    }
}

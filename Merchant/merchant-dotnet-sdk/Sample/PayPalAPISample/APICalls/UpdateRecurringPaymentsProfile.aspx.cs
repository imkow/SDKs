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
    public partial class UpdateRecurringPaymentsProfile : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void calDate_SelectionChanged(object sender, EventArgs e)
        {
            billingStartDate.Text = calDate.SelectedDate.ToString("yyyy-MM-ddTHH:mm:ss");
        }
        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            UpdateRecurringPaymentsProfileRequestType request = new UpdateRecurringPaymentsProfileRequestType();
            populateRequestObject(request);

            // Invoke the API
            UpdateRecurringPaymentsProfileReq wrapper = new UpdateRecurringPaymentsProfileReq();
            wrapper.UpdateRecurringPaymentsProfileRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            UpdateRecurringPaymentsProfileResponseType updateRPProfileResponse = service.UpdateRecurringPaymentsProfile(wrapper);

            // Check for API return status            
            setKeyResponseObjects(service, updateRPProfileResponse);
        }

        private void populateRequestObject(UpdateRecurringPaymentsProfileRequestType request)
        {

            
            CurrencyCodeType currency = (CurrencyCodeType)
                Enum.Parse(typeof(CurrencyCodeType), "USD");
            // Set EC-Token or Credit card requestDetails
            UpdateRecurringPaymentsProfileRequestDetailsType profileDetails = new UpdateRecurringPaymentsProfileRequestDetailsType();
            request.UpdateRecurringPaymentsProfileRequestDetails = profileDetails;


            profileDetails.ProfileID = profileId.Value;
            if (note.Value != "")
            {
                profileDetails.Note = note.Value;                                                                                                                                                                                                                               
            }            
            // Populate Recurring Payments Profile Details
            if (subscriberName.Value != "")
            {
                profileDetails.SubscriberName = subscriberName.Value;
            }
            if (shippingName.Value != "" && shippingStreet1.Value != "" && shippingCity.Value != ""
                && shippingState.Value != "" && shippingPostalCode.Value != "" && shippingCountry.Value != "")
            {
                AddressType shippingAddr = new AddressType();
                shippingAddr.Name = shippingName.Value;
                shippingAddr.Street1 = shippingStreet1.Value;
                shippingAddr.CityName = shippingCity.Value;
                shippingAddr.StateOrProvince = shippingCity.Value;
                shippingAddr.CountryName = shippingCountry.Value;
                shippingAddr.PostalCode = shippingPostalCode.Value;

                if (shippingStreet2.Value != "")
                {
                    shippingAddr.Street2 = shippingStreet2.Value;
                }
                if (shippingPhone.Value != "")
                {
                    shippingAddr.Phone = shippingPhone.Value;
                }
                profileDetails.SubscriberShippingAddress = shippingAddr;
            }
            if (additionalBillingCycles.Value != "")
            {
                profileDetails.AdditionalBillingCycles = Int32.Parse(additionalBillingCycles.Value);
            }
            if (amount.Value != "")
            {
                profileDetails.Amount = new BasicAmountType(currency, amount.Value);
            }
            if (outstandingBalance.Value != "")
            {
                profileDetails.OutstandingBalance =
                        new BasicAmountType(currency, outstandingBalance.Value);
            }
            if (maxFailedPayments.Value != "")
            {
                profileDetails.MaxFailedPayments = Int32.Parse(maxFailedPayments.Value);
            }
            if (autoBillOutstandingAmount.SelectedIndex != 0)
            {
                profileDetails.AutoBillOutstandingAmount = (AutoBillType)
                    Enum.Parse(typeof(AutoBillType), autoBillOutstandingAmount.SelectedValue);
            }
            if(billingStartDate.Text != ""){
                profileDetails.BillingStartDate = billingStartDate.Text;
            }
            if (creditCardNumber.Value != "" && cvv.Value != "")
            {
                CreditCardDetailsType cc = new CreditCardDetailsType();
                cc.CreditCardNumber = creditCardNumber.Value;
                cc.CVV2 = cvv.Value;
                cc.ExpMonth = Int32.Parse(expMonth.SelectedValue);
                cc.ExpYear = Int32.Parse(expYear.SelectedValue);
                profileDetails.CreditCard = cc;
            }
            
            // Populate trial payment details
            if (trialBillingAmount.Value != "" && trialBillingFrequency.Value != ""
                    && trialBillingCycles.Value != "")
            {
                BillingPeriodDetailsType_Update trialPeriod = new BillingPeriodDetailsType_Update();
                trialPeriod.BillingPeriod = (BillingPeriodType)
                    Enum.Parse(typeof(BillingPeriodType), trialBillingPeriod.SelectedValue);
                trialPeriod.BillingFrequency = Int32.Parse(trialBillingFrequency.Value);
                trialPeriod.Amount = new BasicAmountType(currency, trialBillingAmount.Value);

                trialPeriod.TotalBillingCycles = Int32.Parse(trialBillingCycles.Value);
                if (trialShippingAmount.Value != "")
                {
                    trialPeriod.ShippingAmount = new BasicAmountType(currency, trialShippingAmount.Value);
                }
                if (trialTaxAmount.Value != "")
                {
                    trialPeriod.TaxAmount = new BasicAmountType(currency, trialTaxAmount.Value);
                }
                profileDetails.TrialPeriod = trialPeriod;
            }
            // Populate regular payment details
            if (billingAmount.Value != "" && billingFrequency.Value != ""
                    && totalBillingCycles.Value != "")
            {
                BillingPeriodDetailsType_Update paymentPeriod = new BillingPeriodDetailsType_Update();                
                paymentPeriod.BillingPeriod = (BillingPeriodType)
                    Enum.Parse(typeof(BillingPeriodType), billingPeriod.SelectedValue);
                paymentPeriod.BillingFrequency = Int32.Parse(billingFrequency.Value);
                paymentPeriod.Amount = new BasicAmountType(currency, billingAmount.Value);

                paymentPeriod.TotalBillingCycles = Int32.Parse(totalBillingCycles.Value);
                if (trialShippingAmount.Value != "")
                {
                    paymentPeriod.ShippingAmount = new BasicAmountType(currency, shippingAmount.Value);
                }
                if (trialTaxAmount.Value != "")
                {
                    paymentPeriod.TaxAmount = new BasicAmountType(currency, taxAmount.Value);
                }
                profileDetails.PaymentPeriod = paymentPeriod;
            }
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, UpdateRecurringPaymentsProfileResponseType response)
        {
            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            responseParams.Add("API Status", response.Ack.ToString());
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_redirectURL", null);
            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                CurrContext.Items.Add("Response_error", response.Errors);
            }
            else
            {
                CurrContext.Items.Add("Response_error", null);
            }
            CurrContext.Items.Add("Response_keyResponseObject", responseParams);
            CurrContext.Items.Add("Response_apiName", "UpdateRecurringPaymentsProfile");
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());
            Server.Transfer("../APIResponse.aspx");
        }

    }
}

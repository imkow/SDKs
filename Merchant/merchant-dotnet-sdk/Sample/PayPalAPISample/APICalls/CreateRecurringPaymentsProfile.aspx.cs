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
    public partial class CreateRecurringPaymentsProfile : System.Web.UI.Page
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
            CreateRecurringPaymentsProfileRequestType request = new CreateRecurringPaymentsProfileRequestType();
            populateRequest(request);

            // Invoke the API
            CreateRecurringPaymentsProfileReq wrapper = new CreateRecurringPaymentsProfileReq();
            wrapper.CreateRecurringPaymentsProfileRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            CreateRecurringPaymentsProfileResponseType createRPProfileResponse = service.CreateRecurringPaymentsProfile(wrapper);

            // Check for API return status            
            setKeyResponseObjects(service, createRPProfileResponse);
        }

        private void populateRequest(CreateRecurringPaymentsProfileRequestType request)
        {
            CurrencyCodeType currency = (CurrencyCodeType)
                Enum.Parse(typeof(CurrencyCodeType), "USD");

            // Set EC-Token or Credit card requestDetails
            CreateRecurringPaymentsProfileRequestDetailsType profileDetails = new CreateRecurringPaymentsProfileRequestDetailsType();
            request.CreateRecurringPaymentsProfileRequestDetails = profileDetails;

            if(token.Value != "") 
            {
                profileDetails.Token = token.Value;
            } 
            else if (creditCardNumber.Value != "" && cvv.Value != "") 
            {
                CreditCardDetailsType cc = new CreditCardDetailsType();
                cc.CreditCardNumber = creditCardNumber.Value;
                cc.CVV2 = cvv.Value;
                cc.ExpMonth = Int32.Parse(expMonth.SelectedValue);
                cc.ExpYear = Int32.Parse(expYear.SelectedValue);
                profileDetails.CreditCard = cc;
            }


            // Populate Recurring Payments Profile Details
            RecurringPaymentsProfileDetailsType rpProfileDetails = 
                new RecurringPaymentsProfileDetailsType(billingStartDate.Text);
            profileDetails.RecurringPaymentsProfileDetails = rpProfileDetails;
            if(subscriberName.Value != "") 
            {
                rpProfileDetails.SubscriberName = subscriberName.Value;
            }
            if(shippingName.Value != "" && shippingStreet1.Value != "" && shippingCity.Value != ""
                && shippingState.Value != "" && shippingPostalCode.Value != "" && shippingCountry.Value != "") 
            {
                AddressType shippingAddr = new AddressType();
                shippingAddr.Name = shippingName.Value;
                shippingAddr.Street1 = shippingStreet1.Value;
                shippingAddr.CityName = shippingCity.Value;
                shippingAddr.StateOrProvince = shippingCity.Value;
                shippingAddr.CountryName = shippingCountry.Value;
                shippingAddr.PostalCode = shippingPostalCode.Value;

                if(shippingStreet2.Value != "") 
                {
                    shippingAddr.Street2 = shippingStreet2.Value;
                }
                if(shippingPhone.Value != "") 
                {
                    shippingAddr.Phone = shippingPhone.Value;
                }
                rpProfileDetails.SubscriberShippingAddress = shippingAddr;
            }


            // Populate schedule requestDetails
            ScheduleDetailsType scheduleDetails = new ScheduleDetailsType();
            profileDetails.ScheduleDetails = scheduleDetails;
            if(profileDescription.Value != "") 
            {
                scheduleDetails.Description = profileDescription.Value;
            }
            if(maxFailedPayments.Value != "") 
            {
                scheduleDetails.MaxFailedPayments = Int32.Parse(maxFailedPayments.Value);
            }
            if(autoBillOutstandingAmount.SelectedIndex != 0) 
            {
                scheduleDetails.AutoBillOutstandingAmount = (AutoBillType)
                    Enum.Parse(typeof(AutoBillType), autoBillOutstandingAmount.SelectedValue);
            }
            if(initialAmount.Value != "")
            {
                ActivationDetailsType activationDetails = 
                    new ActivationDetailsType(new BasicAmountType(currency, initialAmount.Value));
                if(failedInitialAmountAction.SelectedIndex != 0) 
                {
                    activationDetails.FailedInitialAmountAction = (FailedPaymentActionType)
                        Enum.Parse(typeof(FailedPaymentActionType), failedInitialAmountAction.SelectedValue);
                }
                scheduleDetails.ActivationDetails = activationDetails;
            }
            if(trialBillingAmount.Value != "" && trialBillingFrequency.Value != "" 
                    && trialBillingCycles.Value != "") 
            {
                int frequency = Int32.Parse(trialBillingFrequency.Value);                
                BasicAmountType paymentAmount = new BasicAmountType(currency, trialBillingAmount.Value);
                BillingPeriodType period = (BillingPeriodType)
                    Enum.Parse(typeof(BillingPeriodType), trialBillingPeriod.SelectedValue);
                int numCycles = Int32.Parse(trialBillingCycles.Value);

                BillingPeriodDetailsType trialPeriod = new BillingPeriodDetailsType(period, frequency, paymentAmount);
                trialPeriod.TotalBillingCycles = numCycles;
                if(trialShippingAmount.Value != "") 
                {
                    trialPeriod.ShippingAmount = new BasicAmountType(currency, trialShippingAmount.Value);
                }
                if(trialTaxAmount.Value != "")
                {
                    trialPeriod.TaxAmount = new BasicAmountType(currency, trialTaxAmount.Value);
                }

                scheduleDetails.TrialPeriod = trialPeriod;
            }
            if(billingAmount.Value != "" && billingFrequency.Value != "" 
                    && totalBillingCycles.Value != "") 
            {
                int frequency = Int32.Parse(billingFrequency.Value);                
                BasicAmountType paymentAmount = new BasicAmountType(currency, billingAmount.Value);
                BillingPeriodType period = (BillingPeriodType)
                    Enum.Parse(typeof(BillingPeriodType), billingPeriod.SelectedValue);
                int numCycles = Int32.Parse(totalBillingCycles.Value);

                BillingPeriodDetailsType paymentPeriod = new BillingPeriodDetailsType(period, frequency, paymentAmount);
                paymentPeriod.TotalBillingCycles = numCycles;
                if(trialShippingAmount.Value != "") 
                {
                    paymentPeriod.ShippingAmount = new BasicAmountType(currency, shippingAmount.Value);
                }
                if(trialTaxAmount.Value != "")
                {
                    paymentPeriod.TaxAmount = new BasicAmountType(currency, taxAmount.Value);                     
                }
                scheduleDetails.PaymentPeriod = paymentPeriod;
            }
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, CreateRecurringPaymentsProfileResponseType response)
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
                responseParams.Add("Transaction Id", response.CreateRecurringPaymentsProfileResponseDetails.TransactionID);
                responseParams.Add("Profile Id", response.CreateRecurringPaymentsProfileResponseDetails.ProfileID);
                responseParams.Add("Profile Status", response.CreateRecurringPaymentsProfileResponseDetails.ProfileStatus.ToString());
            }
            CurrContext.Items.Add("Response_keyResponseObject", responseParams);
            CurrContext.Items.Add("Response_apiName", "CreateRecurringPaymentsProfile");
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());
            Server.Transfer("../APIResponse.aspx");
        }

    }
}

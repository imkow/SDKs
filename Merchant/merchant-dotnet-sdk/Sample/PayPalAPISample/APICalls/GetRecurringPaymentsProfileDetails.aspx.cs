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
    public partial class GetRecurringPaymentsProfileDetails : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            GetRecurringPaymentsProfileDetailsRequestType request = new GetRecurringPaymentsProfileDetailsRequestType();
            request.ProfileID = profileId.Value;

            // Invoke the API
            GetRecurringPaymentsProfileDetailsReq wrapper = new GetRecurringPaymentsProfileDetailsReq();
            wrapper.GetRecurringPaymentsProfileDetailsRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            GetRecurringPaymentsProfileDetailsResponseType recurringPaymentsProfileDetailsResponse =
                    service.GetRecurringPaymentsProfileDetails(wrapper);

            // Check for API return status
            setKeyResponseObjects(service, recurringPaymentsProfileDetailsResponse);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, GetRecurringPaymentsProfileDetailsResponseType response)
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

                GetRecurringPaymentsProfileDetailsResponseDetailsType profileDetails = response.GetRecurringPaymentsProfileDetailsResponseDetails;
                responseParams.Add("Profile description", profileDetails.Description);
                responseParams.Add("Profile status", profileDetails.ProfileStatus.ToString());
                responseParams.Add("Subscriber name", profileDetails.RecurringPaymentsProfileDetails.SubscriberName);
                responseParams.Add("Billing start date", profileDetails.RecurringPaymentsProfileDetails.BillingStartDate);
                responseParams.Add("Next billing date", profileDetails.RecurringPaymentsSummary.NextBillingDate);
                responseParams.Add("Payment amount", profileDetails.RegularRecurringPaymentsPeriod.Amount.value 
                                        + profileDetails.RegularRecurringPaymentsPeriod.Amount.currencyID.ToString());
            }
            CurrContext.Items.Add("Response_keyResponseObject", responseParams);
            CurrContext.Items.Add("Response_apiName", "GetRecurringPaymentsProfileDetails");
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());
            Server.Transfer("../APIResponse.aspx");
        }

    }
}

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
    public partial class GetBillingAgreementCustomerDetails : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Params["token"] != null && token.Value == "")
            {
                token.Value = Request.Params["token"];
            }
        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            GetBillingAgreementCustomerDetailsRequestType request = new GetBillingAgreementCustomerDetailsRequestType();
            request.Token = token.Value;

            // Invoke the API
            GetBillingAgreementCustomerDetailsReq wrapper = new GetBillingAgreementCustomerDetailsReq();
            wrapper.GetBillingAgreementCustomerDetailsRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            GetBillingAgreementCustomerDetailsResponseType getBillingAgreementCustomerDetailsResponse =
                    service.GetBillingAgreementCustomerDetails(wrapper);

            // Check for API return status
            setKeyResponseObjects(service, getBillingAgreementCustomerDetailsResponse);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, GetBillingAgreementCustomerDetailsResponseType response)
        {
            Dictionary<string, string> keyResponseParameters = new Dictionary<string, string>();
            keyResponseParameters.Add("API Status", response.Ack.ToString());
            HttpContext CurrContext = HttpContext.Current;
            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                CurrContext.Items.Add("Response_error", response.Errors);
            }
            else
            {
                CurrContext.Items.Add("Response_error", null);
                keyResponseParameters.Add("Payer", response.GetBillingAgreementCustomerDetailsResponseDetails.PayerInfo.Payer);
                AddressType billingAddr = response.GetBillingAgreementCustomerDetailsResponseDetails.PayerInfo.Address;
                if (billingAddr != null)
                {
                    if (billingAddr.AddressOwner != null)
                    {
                        keyResponseParameters.Add("Billing address - Owner", billingAddr.AddressOwner.ToString());
                    }
                    keyResponseParameters.Add("Billing address - Street 1", billingAddr.Street1);
                    keyResponseParameters.Add("Billing address - City", billingAddr.CityName);
                    keyResponseParameters.Add("Billing address - State", billingAddr.StateOrProvince);
                    if (billingAddr.Country != null)
                    {
                        keyResponseParameters.Add("Billing address - Country", billingAddr.Country.ToString());
                    }
                }
            }
            CurrContext.Items.Add("Response_keyResponseObject", keyResponseParameters);
            CurrContext.Items.Add("Response_apiName", "GetBillingAgreementCustomerDetails");
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());
            CurrContext.Items.Add("Response_redirectURL", null);
            Server.Transfer("../APIResponse.aspx");
            
        }

    }
}

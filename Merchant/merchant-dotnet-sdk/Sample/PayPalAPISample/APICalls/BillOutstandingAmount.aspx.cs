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
    public partial class BillOutstandingAmount : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object

            BillOutstandingAmountRequestType request =
                new BillOutstandingAmountRequestType();

            BillOutstandingAmountRequestDetailsType details =
                new BillOutstandingAmountRequestDetailsType();
            request.BillOutstandingAmountRequestDetails = details;
            details.ProfileID = profileId.Value;
            if (currencyCode.SelectedIndex != 0 && amount.Value != "")
            {
                CurrencyCodeType currency = (CurrencyCodeType)
                    Enum.Parse(typeof(CurrencyCodeType), currencyCode.SelectedValue);
                details.Amount = new BasicAmountType(currency, amount.Value);
            }
            if (note.Value != "")
            {
                details.Note = note.Value;
            }

            // Invoke the API
            BillOutstandingAmountReq wrapper = new BillOutstandingAmountReq();
            wrapper.BillOutstandingAmountRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            BillOutstandingAmountResponseType response =
                    service.BillOutstandingAmount(wrapper);


            // Check for API return status
            setKeyResponseObjects(service, response);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, BillOutstandingAmountResponseType response)
        {
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_apiName", "BillOutstandingAmount");
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
                keyResponseParameters.Add("Profile ID", response.BillOutstandingAmountResponseDetails.ProfileID);
            }
            CurrContext.Items.Add("Response_keyResponseObject", keyResponseParameters);
            Server.Transfer("../APIResponse.aspx");
            
        }
    }
}

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
            Session["Response_apiName"] = "BillOutstandingAmount";
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
                keyResponseParameters.Add("Profile ID", response.BillOutstandingAmountResponseDetails.ProfileID);
            }
            Session["Response_keyResponseObject"] = keyResponseParameters;
            Response.Redirect("../APIResponse.aspx");
            
        }
    }
}

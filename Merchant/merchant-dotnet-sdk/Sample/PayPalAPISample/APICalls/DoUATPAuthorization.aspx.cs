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
    public partial class DoUATPAuthorization : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            DoUATPAuthorizationRequestType request = new DoUATPAuthorizationRequestType();
            request.UATPDetails = new UATPDetailsType();
            request.UATPDetails.UATPNumber = uatpNumber.Value;
            request.UATPDetails.ExpMonth = Int32.Parse(expMonth.Value);
            request.UATPDetails.ExpYear = Int32.Parse(expYear.Value);

            request.TransactionEntity = (TransactionEntityType)
                Enum.Parse(typeof(TransactionEntityType), transactionEntity.SelectedValue);

            CurrencyCodeType currency = (CurrencyCodeType)
                Enum.Parse( typeof(CurrencyCodeType), currencyID.Value);
            request.Amount = new BasicAmountType(currency, amount.Value);


            // Invoke the API
            DoUATPAuthorizationReq wrapper = new DoUATPAuthorizationReq();
            wrapper.DoUATPAuthorizationRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            DoUATPAuthorizationResponseType response = service.DoUATPAuthorization(wrapper);

            // Check for API return status
            setKeyResponseObjects(service, response);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, DoUATPAuthorizationResponseType response)
        {
            Session["Response_apiName"] = "DoUATPAuthorization";
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
                responseParams.Add("Transaction Id", response.AuthorizationCode);
                responseParams.Add("Payment status", response.AuthorizationInfo.PaymentStatus.ToString());
                if (response.AuthorizationInfo.PendingReason != null)
                {
                    responseParams.Add("Pending reason", response.AuthorizationInfo.PendingReason.ToString());
                }
            }
            Session["Response_keyResponseObject"] = responseParams;
            Response.Redirect("../APIResponse.aspx");

        }
    }
}

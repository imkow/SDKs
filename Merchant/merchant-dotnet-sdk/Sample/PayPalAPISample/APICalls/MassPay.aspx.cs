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
    public partial class MassPay : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            MassPayRequestType request = new MassPayRequestType();
             ReceiverInfoCodeType receiverInfoType = (ReceiverInfoCodeType)
                Enum.Parse(typeof(ReceiverInfoCodeType), receiverType.SelectedValue);

             request.ReceiverType = receiverInfoType;
            if (emailSubject.Value != "")
            {
                request.EmailSubject = emailSubject.Value;
            }


            // Processing a single masspay receiver.
            // You can add upto 250 receivers in one call
            MassPayRequestItemType massPayItem = new MassPayRequestItemType();
            CurrencyCodeType currency = (CurrencyCodeType)
                Enum.Parse(typeof(CurrencyCodeType), currencyCode.SelectedValue);
            massPayItem.Amount = new BasicAmountType(currency, amount.Value);
            if (receiverInfoType.Equals(ReceiverInfoCodeType.EMAILADDRESS) && emailId.Value != "")
            {
                massPayItem.ReceiverEmail = emailId.Value;
            }
            else if (receiverInfoType.Equals(ReceiverInfoCodeType.PHONENUMBER) && phoneNumber.Value != "")
            {
                massPayItem.ReceiverPhone = phoneNumber.Value;
            }
            else if (receiverInfoType.Equals(ReceiverInfoCodeType.USERID) && receiverId.Value != "")
            {
                massPayItem.ReceiverID = receiverId.Value;
            }

            if (note.Value != "")
            {
                massPayItem.Note = note.Value;
            }
            if (uniqueId.Value != "")
            {
                massPayItem.UniqueId = uniqueId.Value;
            }
            request.MassPayItem.Add(massPayItem);            


            // Invoke the API
            MassPayReq wrapper = new MassPayReq();
            wrapper.MassPayRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            MassPayResponseType massPayResponse = service.MassPay(wrapper);

            // Check for API return status
            processResponse(service, massPayResponse);
        }

        private void processResponse(PayPalAPIInterfaceServiceService service, MassPayResponseType response)
        {
            Session["Response_apiName"] = "MassPay";
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

            if (!response.Ack.Equals(AckCodeType.FAILURE))
            {
            }
            Session["Response_keyResponseObject"] = keyParameters;
            Response.Redirect("../APIResponse.aspx");            
        }
    }
}

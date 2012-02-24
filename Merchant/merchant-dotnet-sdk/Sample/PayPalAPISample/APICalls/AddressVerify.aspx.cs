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
    public partial class AddressVerify : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            AddressVerifyRequestType request = new AddressVerifyRequestType();
            request.Email = email.Value;
            request.Street = street.Value;
            request.Zip = zip.Value;

            // Invoke the API
            AddressVerifyReq wrapper = new AddressVerifyReq();
            wrapper.AddressVerifyRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            AddressVerifyResponseType addressVerifyResponse = service.AddressVerify(wrapper);

            // Check for API return status
            setKeyResponseObjects(service, addressVerifyResponse);
        }

        // A helper method used by APIResponse.aspx that returns select response parameters 
        // of interest. 
        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, AddressVerifyResponseType response)
        {
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_apiName", "AddressVerify");
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
                keyResponseParameters.Add("Address confirmation code", response.ConfirmationCode.ToString());
                keyResponseParameters.Add("Street address match", response.StreetMatch.ToString());
                keyResponseParameters.Add("Zip code match", response.ZipMatch.ToString());
            }
            CurrContext.Items.Add("Response_keyResponseObject", keyResponseParameters);
            Server.Transfer("../APIResponse.aspx");
        }
    }
}

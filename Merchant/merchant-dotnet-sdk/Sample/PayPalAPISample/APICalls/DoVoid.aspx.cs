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
    public partial class DoVoid : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            DoVoidRequestType request =
                new DoVoidRequestType();     
            request.AuthorizationID = authorizationId.Value;
            if (note.Value != "")
            {
                request.Note = note.Value;                
            }

            // Invoke the API
            DoVoidReq wrapper = new DoVoidReq();
            wrapper.DoVoidRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            DoVoidResponseType doVoidResponse =
                    service.DoVoid(wrapper);


            // Check for API return status
            setKeyResponseObjects(service, doVoidResponse);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, DoVoidResponseType doVoidResponse)
        {
            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            Session["Response_keyResponseObject"] = responseParams;

            Session["Response_apiName"] = "DoVoid";
            Session["Response_redirectURL"] = null;
            Session["Response_requestPayload"] = service.getLastRequest();
            Session["Response_responsePayload"] = service.getLastResponse();

            if (doVoidResponse.Ack.Equals(AckCodeType.FAILURE) ||
                (doVoidResponse.Errors != null && doVoidResponse.Errors.Count > 0))
            {
                Session["Response_error"] = doVoidResponse.Errors;
            }
            else
            {
                Session["Response_error"] = null;
                responseParams.Add("Authorization Id", doVoidResponse.AuthorizationID);
            }
            Response.Redirect("../APIResponse.aspx");

        }

    }
}

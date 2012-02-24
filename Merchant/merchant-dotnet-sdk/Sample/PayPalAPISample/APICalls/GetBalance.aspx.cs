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
    public partial class GetBalance : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            // Create request object
            GetBalanceRequestType request = new GetBalanceRequestType();
            request.Version = "84.0";
            request.ReturnAllCurrencies = returnAllCurrencies.SelectedValue;

            // Invoke the API
            GetBalanceReq wrapper = new GetBalanceReq();
            wrapper.GetBalanceRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            GetBalanceResponseType getBalanceResponse = service.GetBalance(wrapper);

            // Check for API return status
            processResponse(service, getBalanceResponse);
        }

        private void processResponse(PayPalAPIInterfaceServiceService service, GetBalanceResponseType response)
        {
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_apiName", "GetBalance");
            CurrContext.Items.Add("Response_redirectURL", null);
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());

            Dictionary<string, string> keyParameters = new Dictionary<string, string>();
            keyParameters.Add("Correlation Id", response.CorrelationID);
            keyParameters.Add("API Result", response.Ack.ToString());

            if (response.Errors != null && response.Errors.Count > 0)
            {
                CurrContext.Items.Add("Response_error", response.Errors);
            }
            else
            {
                CurrContext.Items.Add("Response_error", null);
                keyParameters.Add("Balance reported at", response.BalanceTimeStamp);
                keyParameters.Add("Balance holding in primary currency",
                    response.Balance.value + response.Balance.currencyID.ToString());
                if (response.BalanceHoldings != null && response.BalanceHoldings.Count > 0)
                {
                    for (int i = 0; i < response.BalanceHoldings.Count; i++)
                    {
                        keyParameters.Add("Balance holding" + (i + 1),
                            response.BalanceHoldings[i].value + response.BalanceHoldings[i].currencyID.ToString());
                    }
                }
            }

            if (!response.Ack.Equals(AckCodeType.FAILURE))
            {
            }
            CurrContext.Items.Add("Response_keyResponseObject", keyParameters);
            Server.Transfer("../APIResponse.aspx"); 
        }
    }
}

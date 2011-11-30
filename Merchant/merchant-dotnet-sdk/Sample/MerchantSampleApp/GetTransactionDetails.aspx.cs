using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

using PayPal.PayPalAPIInterfaceService;
using PayPal.PayPalAPIInterfaceService.Model;

namespace MerchantSampleApp
{
    public partial class GetTransactionDetails : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            GetTransactionDetailsReq request = new GetTransactionDetailsReq();
            GetTransactionDetailsRequestType requestType = new GetTransactionDetailsRequestType();
            requestType.TransactionID = transactionId.Value;
            request.GetTransactionDetailsRequest = requestType;

            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            service.GetTransactionDetails(request);
        }
    }
}

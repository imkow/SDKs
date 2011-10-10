using System;
using System.Data;
using System.Web;
using System.Collections;
using System.Web.Services;
using System.Web.Services.Protocols;
using PayPal.PayPalAPIInterfaceService.Model;
using PayPal.PayPalAPIInterfaceService;
using PayPal;
using PayPal.Exception;



namespace MerchantSampleApp
{
    /// <summary>
    /// Summary description for $codebehindclassname$
    /// </summary>

    public class merchanthandler : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            String strCall = context.Request.Params["MerchantBtn"];

            if (strCall.Equals("TransSearch"))
            {
                TransSearch(context);
            }
            
        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }
        private void TransSearch(HttpContext context)
        {
            TransactionSearchReq req = new TransactionSearchReq();
            TransactionSearchRequestType reqType = new TransactionSearchRequestType();
            reqType.Version = "78.0";
            reqType.StartDate = context.Request.Params["startDate"];
            reqType.TransactionID = "6MS29234D79035902";
            req.TransactionSearchRequest = reqType;
            try
            {
                PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
                TransactionSearchResponseType resp = service.TransactionSearch(req);
                context.Response.Write("<html><body><textarea rows=30 cols=80>");
                ObjectDumper.Write(resp, 5, context.Response.Output);
                context.Response.Write("</textarea></body></html>");
            }
            catch (System.Exception e)
            {
                context.Response.Write(e.Message);
            }

        }
        
    }
}

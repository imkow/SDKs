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
            else if (strCall.Equals("DoDirectPayment"))
            {
                DoDirectPayment(context);
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
            reqType.StartDate = context.Request.Params["startDate"] + "T00:00:00.000Z";
            reqType.TransactionID = context.Request.Params["transID"];;
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
        private void DoDirectPayment(HttpContext context)
        {
            DoDirectPaymentReq req = new DoDirectPaymentReq();
            req.DoDirectPaymentRequest = new DoDirectPaymentRequestType();
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails = new DoDirectPaymentRequestDetailsType();
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard = new CreditCardDetailsType();
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails = new PaymentDetailsType();
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.OrderTotal = new BasicAmountType();
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.ShipToAddress = new AddressType();
            req.DoDirectPaymentRequest.Version = "78.0";
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CreditCardNumber = context.Request.Params["cardNum"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CreditCardType = (CreditCardTypeType)EnumUtils.getValue(context.Request.Params["creditcardType"], typeof(CreditCardTypeType));
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CVV2 = context.Request.Params["cvv2Num"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.ExpMonth = System.Convert.ToInt32(context.Request.Params["expDateMonth"]);
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.ExpYear = System.Convert.ToInt32(context.Request.Params["expDateYear"]);
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentAction = (PaymentActionCodeType)EnumUtils.getValue(context.Request.Params["paymentType"], typeof(PaymentActionCodeType));
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.OrderTotal.currencyID = (CurrencyCodeType)EnumUtils.getValue(context.Request.Params["currencyCode"], typeof(CurrencyCodeType));
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.OrderTotal.value = context.Request.Params["amount"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.ShipToAddress.Street1 = context.Request.Params["addr1"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.ShipToAddress.Street2 = context.Request.Params["addr2"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.ShipToAddress.CityName = context.Request.Params["city"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.ShipToAddress.StateOrProvince = context.Request.Params["state"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.ShipToAddress.PostalCode = context.Request.Params["zipCode"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.ShipToAddress.Country =(CountryCodeType)EnumUtils.getValue(context.Request.Params["countryCode"], typeof(CountryCodeType));
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.PaymentDetails.ShipToAddress.Name = context.Request.Params["firstName"] + context.Request.Params["lastName"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner = new PayerInfoType();
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.PayerName = new PersonNameType();
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.PayerCountry = (CountryCodeType)EnumUtils.getValue(context.Request.Params["countryCode"], typeof(CountryCodeType));
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.PayerName.FirstName=context.Request.Params["firstName"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.PayerName.LastName = context.Request.Params["lastName"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.Address = new AddressType();
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.Address.Street1 = context.Request.Params["addr1"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.Address.Street2 = context.Request.Params["addr2"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.Address.CityName = context.Request.Params["city"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.Address.StateOrProvince = context.Request.Params["state"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.Address.PostalCode = context.Request.Params["zipCode"];
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.Address.Country = (CountryCodeType)EnumUtils.getValue(context.Request.Params["countryCode"], typeof(CountryCodeType));
            req.DoDirectPaymentRequest.DoDirectPaymentRequestDetails.CreditCard.CardOwner.Address.Name = context.Request.Params["firstName"] + context.Request.Params["lastName"];
            try
            {
                PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
                DoDirectPaymentResponseType resp = service.DoDirectPayment(req);
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

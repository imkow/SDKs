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
    public partial class BillUser : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void BillUser_Submit(object sender, EventArgs e)
        {
            // Create request object
            BillUserRequestType request = new BillUserRequestType();            
            request.ReturnFMFDetails = Int32.Parse(returnFMFDetails.SelectedValue);

            MerchantPullPaymentType paymentDetails = new MerchantPullPaymentType();
            request.MerchantPullPaymentDetails = paymentDetails;            
            paymentDetails.Amount = new BasicAmountType(
                (CurrencyCodeType) Enum.Parse(typeof(CurrencyCodeType), currencyCode.SelectedValue), amount.Value);
            paymentDetails.MpID = mpId.Value;
            if (paymentType.SelectedIndex != 0)
            {
                paymentDetails.PaymentType =
                    (MerchantPullPaymentCodeType)Enum.Parse(typeof(MerchantPullPaymentCodeType), paymentType.SelectedValue);
            }
            if (memo.Value != "")
            {
                paymentDetails.Memo = memo.Value;
            }
            if (emailSubject.Value != "")
            {
                paymentDetails.EmailSubject = emailSubject.Value;
            }
            if (tax.Value != "" && taxCurrencyCode.SelectedIndex != 0)
            {
                paymentDetails.Tax = new BasicAmountType(
                    (CurrencyCodeType)Enum.Parse(typeof(CurrencyCodeType), taxCurrencyCode.SelectedValue), tax.Value);
            }
            if (shipping.Value != "" && shippingCurrencyCode.SelectedIndex != 0)
            {
                paymentDetails.Shipping = new BasicAmountType(
                    (CurrencyCodeType)Enum.Parse(typeof(CurrencyCodeType), shippingCurrencyCode.SelectedValue), shipping.Value);
            }
            if (handling.Value != "" && handlingCurrencyCode.SelectedIndex != 0)
            {
                paymentDetails.Handling = new BasicAmountType(
                    (CurrencyCodeType)Enum.Parse(typeof(CurrencyCodeType), handlingCurrencyCode.SelectedValue), handling.Value);
            }
            if (itemName.Value != "")
            {
                paymentDetails.ItemName = itemName.Value;
            }
            if (itemNumber.Value != "")
            {
                paymentDetails.ItemNumber = itemNumber.Value;
            }
            if (invoiceNumber.Value != "")
            {
                paymentDetails.Invoice = invoiceNumber.Value;
            }
            if (custom.Value != "")
            {
                paymentDetails.Custom = custom.Value;
            }
            if (buttonSource.Value != "")
            {
                paymentDetails.ButtonSource = buttonSource.Value;
            }
            if (softDescriptor.Value != "")
            {
                paymentDetails.SoftDescriptor = softDescriptor.Value;
            }
            


            // Invoke the API
            BillUserReq wrapper = new BillUserReq();
            wrapper.BillUserRequest = request;
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            BillUserResponseType billUserResponse = service.BillUser(wrapper);

            // Check for API return status
            setKeyResponseObjects(service, billUserResponse);
        }

        private void setKeyResponseObjects(PayPalAPIInterfaceServiceService service, BillUserResponseType response)
        {
            Dictionary<string, string> responseParams = new Dictionary<string, string>();
            HttpContext CurrContext = HttpContext.Current;
            CurrContext.Items.Add("Response_keyResponseObject", responseParams);

            CurrContext.Items.Add("Response_apiName", "BillUser");
            CurrContext.Items.Add("Response_redirectURL", null);
            CurrContext.Items.Add("Response_requestPayload", service.getLastRequest());
            CurrContext.Items.Add("Response_responsePayload", service.getLastResponse());

            if (response.Ack.Equals(AckCodeType.FAILURE) ||
                (response.Errors != null && response.Errors.Count > 0))
            {
                CurrContext.Items.Add("Response_error", response.Errors);
            }
            else
            {
                CurrContext.Items.Add("Response_error", null);
                responseParams.Add("Transaction Id", response.BillUserResponseDetails.PaymentInfo.TransactionID);
                responseParams.Add("Gross amount", response.BillUserResponseDetails.PaymentInfo.GrossAmount.value +
                            response.BillUserResponseDetails.PaymentInfo.GrossAmount.currencyID);
                responseParams.Add("Fees amount", response.BillUserResponseDetails.PaymentInfo.FeeAmount.value +
                                            response.BillUserResponseDetails.PaymentInfo.FeeAmount.currencyID);
            }
            Server.Transfer("../APIResponse.aspx");


        }
        
    }
}

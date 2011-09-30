
/**
 * Auto generated code
 */

package urn.ebay.apis.eBLBaseComponents;

import urn.ebay.apis.eBLBaseComponents.MerchantPullPaymentCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.ReferenceCreditCardDetailsType;


/**
 */
public class DoReferenceTransactionRequestDetailsType {

	/**
	 *
	 * @Required
	 */
	private String ReferenceID;
	public String getReferenceID() {
		return ReferenceID;
	}
	public void setReferenceID(String value) {
		this.ReferenceID = value;
	}

	/**
	 *
	 * @Required
	 */
	private PaymentActionCodeType PaymentAction;
	public PaymentActionCodeType getPaymentAction() {
		return PaymentAction;
	}
	public void setPaymentAction(PaymentActionCodeType value) {
		this.PaymentAction = value;
	}

	/**
	 */
	private MerchantPullPaymentCodeType PaymentType;
	public MerchantPullPaymentCodeType getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(MerchantPullPaymentCodeType value) {
		this.PaymentType = value;
	}

	/**
	 *
	 * @Required
	 */
	private PaymentDetailsType PaymentDetails;
	public PaymentDetailsType getPaymentDetails() {
		return PaymentDetails;
	}
	public void setPaymentDetails(PaymentDetailsType value) {
		this.PaymentDetails = value;
	}

	/**
	 */
	private ReferenceCreditCardDetailsType CreditCard;
	public ReferenceCreditCardDetailsType getCreditCard() {
		return CreditCard;
	}
	public void setCreditCard(ReferenceCreditCardDetailsType value) {
		this.CreditCard = value;
	}

	/**
	 */
	private String IPAddress;
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String value) {
		this.IPAddress = value;
	}

	/**
	 */
	private String MerchantSessionId;
	public String getMerchantSessionId() {
		return MerchantSessionId;
	}
	public void setMerchantSessionId(String value) {
		this.MerchantSessionId = value;
	}

	/**
	 */
	private String ReqConfirmShipping;
	public String getReqConfirmShipping() {
		return ReqConfirmShipping;
	}
	public void setReqConfirmShipping(String value) {
		this.ReqConfirmShipping = value;
	}

	/**
	 */
	private String SoftDescriptor;
	public String getSoftDescriptor() {
		return SoftDescriptor;
	}
	public void setSoftDescriptor(String value) {
		this.SoftDescriptor = value;
	}


	public DoReferenceTransactionRequestDetailsType(String ReferenceID, PaymentActionCodeType PaymentAction, PaymentDetailsType PaymentDetails) {
		this.ReferenceID = ReferenceID;
		this.PaymentAction = PaymentAction;
		this.PaymentDetails = PaymentDetails;
	}
	public DoReferenceTransactionRequestDetailsType() {
	}

	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( ReferenceID != null ) {
			sb.append("<ebl:ReferenceID>").append(ReferenceID);
			sb.append("</ebl:ReferenceID>");
		}
		if( PaymentAction != null ) {
			sb.append("<ebl:PaymentAction>").append( PaymentAction.getValue());
			sb.append("</ebl:PaymentAction>");
		}
		if( PaymentType != null ) {
			sb.append("<ebl:PaymentType>").append( PaymentType.getValue());
			sb.append("</ebl:PaymentType>");
		}
		if( PaymentDetails != null ) {
			sb.append("<ebl:PaymentDetails>");
			sb.append(PaymentDetails.toXMLString());
			sb.append("</ebl:PaymentDetails>");
		}
		if( CreditCard != null ) {
			sb.append("<ebl:CreditCard>");
			sb.append(CreditCard.toXMLString());
			sb.append("</ebl:CreditCard>");
		}
		if( IPAddress != null ) {
			sb.append("<ebl:IPAddress>").append(IPAddress);
			sb.append("</ebl:IPAddress>");
		}
		if( MerchantSessionId != null ) {
			sb.append("<ebl:MerchantSessionId>").append(MerchantSessionId);
			sb.append("</ebl:MerchantSessionId>");
		}
		if( ReqConfirmShipping != null ) {
			sb.append("<ebl:ReqConfirmShipping>").append(ReqConfirmShipping);
			sb.append("</ebl:ReqConfirmShipping>");
		}
		if( SoftDescriptor != null ) {
			sb.append("<ebl:SoftDescriptor>").append(SoftDescriptor);
			sb.append("</ebl:SoftDescriptor>");
		}
		return sb.toString();
	}

}

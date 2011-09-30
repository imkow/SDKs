
/**
 * Auto generated code
 */

package urn.ebay.apis.eBLBaseComponents;

import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.CreditCardDetailsType;


/**
 */
public class DoNonReferencedCreditRequestDetailsType {

	/**
	 */
	private BasicAmountType Amount;
	public BasicAmountType getAmount() {
		return Amount;
	}
	public void setAmount(BasicAmountType value) {
		this.Amount = value;
	}

	/**
	 */
	private BasicAmountType NetAmount;
	public BasicAmountType getNetAmount() {
		return NetAmount;
	}
	public void setNetAmount(BasicAmountType value) {
		this.NetAmount = value;
	}

	/**
	 */
	private BasicAmountType TaxAmount;
	public BasicAmountType getTaxAmount() {
		return TaxAmount;
	}
	public void setTaxAmount(BasicAmountType value) {
		this.TaxAmount = value;
	}

	/**
	 */
	private BasicAmountType ShippingAmount;
	public BasicAmountType getShippingAmount() {
		return ShippingAmount;
	}
	public void setShippingAmount(BasicAmountType value) {
		this.ShippingAmount = value;
	}

	/**
	 */
	private CreditCardDetailsType CreditCard;
	public CreditCardDetailsType getCreditCard() {
		return CreditCard;
	}
	public void setCreditCard(CreditCardDetailsType value) {
		this.CreditCard = value;
	}

	/**
	 */
	private String ReceiverEmail;
	public String getReceiverEmail() {
		return ReceiverEmail;
	}
	public void setReceiverEmail(String value) {
		this.ReceiverEmail = value;
	}

	/**
	 */
	private String Comment;
	public String getComment() {
		return Comment;
	}
	public void setComment(String value) {
		this.Comment = value;
	}



	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( Amount != null ) {
			sb.append("<cc:Amount>");
			sb.append(Amount.toXMLString());
			sb.append("</cc:Amount>");
		}
		if( NetAmount != null ) {
			sb.append("<cc:NetAmount>");
			sb.append(NetAmount.toXMLString());
			sb.append("</cc:NetAmount>");
		}
		if( TaxAmount != null ) {
			sb.append("<cc:TaxAmount>");
			sb.append(TaxAmount.toXMLString());
			sb.append("</cc:TaxAmount>");
		}
		if( ShippingAmount != null ) {
			sb.append("<cc:ShippingAmount>");
			sb.append(ShippingAmount.toXMLString());
			sb.append("</cc:ShippingAmount>");
		}
		if( CreditCard != null ) {
			sb.append("<ebl:CreditCard>");
			sb.append(CreditCard.toXMLString());
			sb.append("</ebl:CreditCard>");
		}
		if( ReceiverEmail != null ) {
			sb.append("<ebl:ReceiverEmail>").append(ReceiverEmail);
			sb.append("</ebl:ReceiverEmail>");
		}
		if( Comment != null ) {
			sb.append("<ebl:Comment>").append(Comment);
			sb.append("</ebl:Comment>");
		}
		return sb.toString();
	}

}

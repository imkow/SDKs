
/**
 * Auto generated code
 */

package urn.ebay.apis.eBLBaseComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import urn.ebay.apis.eBLBaseComponents.AuctionInfoType;
import urn.ebay.apis.eBLBaseComponents.PaymentItemType;
import urn.ebay.apis.eBLBaseComponents.SubscriptionInfoType;


/**
 * PaymentItemInfoType
 * Information about a PayPal item.
 */
public class PaymentItemInfoType {

	/**
	 * Invoice number you set in the original transaction.
	 * Character length and limitations: 127 single-byte alphanumeric
	 * characters
	 */
	private String InvoiceID;
	public String getInvoiceID() {
		return InvoiceID;
	}
	public void setInvoiceID(String value) {
		this.InvoiceID = value;
	}

	/**
	 * Custom field you set in the original transaction.
	 * Character length and limitations: 127 single-byte alphanumeric
	 * characters
	 */
	private String Custom;
	public String getCustom() {
		return Custom;
	}
	public void setCustom(String value) {
		this.Custom = value;
	}

	/**
	 * Memo entered by your customer in PayPal Website Payments note
	 * field.
	 * Character length and limitations: 255 single-byte alphanumeric
	 * characters
	 */
	private String Memo;
	public String getMemo() {
		return Memo;
	}
	public void setMemo(String value) {
		this.Memo = value;
	}

	/**
	 * Amount of tax charged on transaction	 */
	private String SalesTax;
	public String getSalesTax() {
		return SalesTax;
	}
	public void setSalesTax(String value) {
		this.SalesTax = value;
	}

	/**
	 * Details about the indivudal purchased item	 */
	private List<PaymentItemType> PaymentItem = new ArrayList<PaymentItemType>();
	public List<PaymentItemType> getPaymentItem() {
		return PaymentItem;
	}
	public void setPaymentItem(List<PaymentItemType> value) {
		this.PaymentItem = value;
	}

	/**
	 * Information about the transaction if it was created via PayPal Subcriptions
	 */
	private SubscriptionInfoType Subscription;
	public SubscriptionInfoType getSubscription() {
		return Subscription;
	}
	public void setSubscription(SubscriptionInfoType value) {
		this.Subscription = value;
	}

	/**
	 * Information about the transaction if it was created via an auction
	 */
	private AuctionInfoType Auction;
	public AuctionInfoType getAuction() {
		return Auction;
	}
	public void setAuction(AuctionInfoType value) {
		this.Auction = value;
	}


	public PaymentItemInfoType() {
	}
	 private  boolean isWhitespaceNode(Node n) {
		 if (n.getNodeType() == Node.TEXT_NODE) { 
				String val = n.getNodeValue();
				return val.trim().length() == 0; 
		 } else {
				return false;
		 } 
	 } 
	 private String convertToXML(Node node){ 
		 StringBuffer bf = new StringBuffer(); 
		 do{ 
		 if (node.getChildNodes().getLength() == 1 && node.getChildNodes().item(0).getNodeType()==Node.TEXT_NODE) { 
				bf.append("<" + node.getNodeName() + ">" + node.getTextContent()+ "</" + node.getNodeName() + ">"); 
				return bf.toString(); 
			} 
			bf.append("<" + node.getNodeName() + ">"); 
			NodeList childNode = node.getChildNodes(); 
			for (int j = 0; j < childNode.getLength(); j++) { 
				Node offspring = childNode.item(j); 
				if (offspring.getChildNodes().getLength() == 1) { 
					if (!isWhitespaceNode(offspring)) { 
						bf.append("<" + offspring.getNodeName() + ">"+ offspring.getTextContent() + "</"+ offspring.getNodeName() + ">");
					}
				} else {
					bf.append(convertToXML(offspring));
				}
			}
			bf.append("</" + node.getNodeName() + ">");
			return bf.toString();
		 }while(true);
		}
	 public PaymentItemInfoType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("InvoiceID").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("InvoiceID").item(0))){ 
		 this.InvoiceID =(String)document.getElementsByTagName("InvoiceID").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("Custom").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("Custom").item(0))){ 
		 this.Custom =(String)document.getElementsByTagName("Custom").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("Memo").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("Memo").item(0))){ 
		 this.Memo =(String)document.getElementsByTagName("Memo").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("SalesTax").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("SalesTax").item(0))){ 
		 this.SalesTax =(String)document.getElementsByTagName("SalesTax").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("PaymentItem").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("PaymentItem").item(0))){ 
		 nodeList = document.getElementsByTagName("PaymentItem");
		 for(int i=0; i<nodeList.getLength(); i++) {
			 xmlString = convertToXML(nodeList.item(i)); 
				this.PaymentItem.add(new PaymentItemType(xmlString));
			}

}
	}
		 if(document.getElementsByTagName("Subscription").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("Subscription").item(0))){ 
		 nodeList = document.getElementsByTagName("Subscription");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.Subscription =  new SubscriptionInfoType(xmlString);

}
	}
		 if(document.getElementsByTagName("Auction").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("Auction").item(0))){ 
		 nodeList = document.getElementsByTagName("Auction");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.Auction =  new AuctionInfoType(xmlString);

}
	}
	}
}

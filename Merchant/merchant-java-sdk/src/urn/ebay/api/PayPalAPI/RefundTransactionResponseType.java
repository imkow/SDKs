
/**
 * Auto generated code
 */

package urn.ebay.api.PayPalAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AbstractResponseType;


/**
 * Unique transaction ID of the refund.
 * Character length and limitations:17 single-byte characters
 */
public class RefundTransactionResponseType extends AbstractResponseType{

	/**
	 * Unique transaction ID of the refund.
	 * Character length and limitations:17 single-byte characters
	 */
	private String RefundTransactionID;
	public String getRefundTransactionID() {
		return RefundTransactionID;
	}
	public void setRefundTransactionID(String value) {
		this.RefundTransactionID = value;
	}

	/**
Amount subtracted from PayPal balance of
	 * original recipient of payment to make this refund
	 */
	private BasicAmountType NetRefundAmount;
	public BasicAmountType getNetRefundAmount() {
		return NetRefundAmount;
	}
	public void setNetRefundAmount(BasicAmountType value) {
		this.NetRefundAmount = value;
	}

	/**
Transaction fee refunded to original recipient
	 * of payment 
	 */
	private BasicAmountType FeeRefundAmount;
	public BasicAmountType getFeeRefundAmount() {
		return FeeRefundAmount;
	}
	public void setFeeRefundAmount(BasicAmountType value) {
		this.FeeRefundAmount = value;
	}

	/**
Amount of money refunded to original payer
	 */
	private BasicAmountType GrossRefundAmount;
	public BasicAmountType getGrossRefundAmount() {
		return GrossRefundAmount;
	}
	public void setGrossRefundAmount(BasicAmountType value) {
		this.GrossRefundAmount = value;
	}

	/**
Total of all previous refunds	 */
	private BasicAmountType TotalRefundedAmount;
	public BasicAmountType getTotalRefundedAmount() {
		return TotalRefundedAmount;
	}
	public void setTotalRefundedAmount(BasicAmountType value) {
		this.TotalRefundedAmount = value;
	}


	public RefundTransactionResponseType() {
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
	 public RefundTransactionResponseType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 super(xmlSoap); 
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("RefundTransactionID").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("RefundTransactionID").item(0))){ 
		 this.RefundTransactionID =(String)document.getElementsByTagName("RefundTransactionID").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("NetRefundAmount").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("NetRefundAmount").item(0))){ 
		 nodeList = document.getElementsByTagName("NetRefundAmount");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.NetRefundAmount =  new BasicAmountType(xmlString);

}
	}
		 if(document.getElementsByTagName("FeeRefundAmount").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("FeeRefundAmount").item(0))){ 
		 nodeList = document.getElementsByTagName("FeeRefundAmount");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.FeeRefundAmount =  new BasicAmountType(xmlString);

}
	}
		 if(document.getElementsByTagName("GrossRefundAmount").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("GrossRefundAmount").item(0))){ 
		 nodeList = document.getElementsByTagName("GrossRefundAmount");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.GrossRefundAmount =  new BasicAmountType(xmlString);

}
	}
		 if(document.getElementsByTagName("TotalRefundedAmount").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("TotalRefundedAmount").item(0))){ 
		 nodeList = document.getElementsByTagName("TotalRefundedAmount");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.TotalRefundedAmount =  new BasicAmountType(xmlString);

}
	}
	}
}

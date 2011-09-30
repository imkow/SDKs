
/**
 * Auto generated code
 */

package urn.ebay.apis.eBLBaseComponents;

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
import urn.ebay.apis.eBLBaseComponents.MerchantPullInfoType;
import urn.ebay.apis.eBLBaseComponents.PayerInfoType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;


/**
 * MerchantPullPaymentResponseType
 * Response data from the merchant pull.
 */
public class MerchantPullPaymentResponseType {

	/**
	 * information about the customer	 */
	private PayerInfoType PayerInfo;
	public PayerInfoType getPayerInfo() {
		return PayerInfo;
	}
	public void setPayerInfo(PayerInfoType value) {
		this.PayerInfo = value;
	}

	/**
Information about the transaction 	 */
	private PaymentInfoType PaymentInfo;
	public PaymentInfoType getPaymentInfo() {
		return PaymentInfo;
	}
	public void setPaymentInfo(PaymentInfoType value) {
		this.PaymentInfo = value;
	}

	/**
	 * Specific information about the preapproved payment 	 */
	private MerchantPullInfoType MerchantPullInfo;
	public MerchantPullInfoType getMerchantPullInfo() {
		return MerchantPullInfo;
	}
	public void setMerchantPullInfo(MerchantPullInfoType value) {
		this.MerchantPullInfo = value;
	}


	public MerchantPullPaymentResponseType() {
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
	 public MerchantPullPaymentResponseType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("PayerInfo").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("PayerInfo").item(0))){ 
		 nodeList = document.getElementsByTagName("PayerInfo");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.PayerInfo =  new PayerInfoType(xmlString);

}
	}
		 if(document.getElementsByTagName("PaymentInfo").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("PaymentInfo").item(0))){ 
		 nodeList = document.getElementsByTagName("PaymentInfo");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.PaymentInfo =  new PaymentInfoType(xmlString);

}
	}
		 if(document.getElementsByTagName("MerchantPullInfo").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("MerchantPullInfo").item(0))){ 
		 nodeList = document.getElementsByTagName("MerchantPullInfo");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.MerchantPullInfo =  new MerchantPullInfoType(xmlString);

}
	}
	}
}

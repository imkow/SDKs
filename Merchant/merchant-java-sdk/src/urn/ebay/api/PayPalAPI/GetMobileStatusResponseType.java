
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
import urn.ebay.apis.eBLBaseComponents.AbstractResponseType;


/**
 * Indicates whether the phone is activated for mobile payments
 */
public class GetMobileStatusResponseType extends AbstractResponseType{

	/**
	 * Indicates whether the phone is activated for mobile payments
	 *
	 * @Required
	 */
	private Integer IsActivated;
	public Integer getIsActivated() {
		return IsActivated;
	}
	public void setIsActivated(Integer value) {
		this.IsActivated = value;
	}

	/**
	 * Indicates whether there is a payment pending from the phone
	 *
	 * @Required
	 */
	private Integer PaymentPending;
	public Integer getPaymentPending() {
		return PaymentPending;
	}
	public void setPaymentPending(Integer value) {
		this.PaymentPending = value;
	}


	public GetMobileStatusResponseType() {
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
	 public GetMobileStatusResponseType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 super(xmlSoap); 
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("IsActivated").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("IsActivated").item(0))){ 
		 this.IsActivated =Integer.valueOf(document.getElementsByTagName("IsActivated").item(0).getTextContent());

}
	}
		 if(document.getElementsByTagName("PaymentPending").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("PaymentPending").item(0))){ 
		 this.PaymentPending =Integer.valueOf(document.getElementsByTagName("PaymentPending").item(0).getTextContent());

}
	}
	}
}

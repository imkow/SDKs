
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


/**
 * Response information resulting from opt-in
 * operation or current login bypass status.
 */
public class ExternalRememberMeStatusDetailsType {

	/**
	 * Required field that reports status of opt-in or
	 * login bypass attempt.
	 * 0 = Success - successful opt-in or
	 * ExternalRememberMeID specified in SetExpressCheckout
	 * is valid.
	 * 1 = Invalid ID - ExternalRememberMeID specified in
	 * SetExpressCheckout is invalid.
	 * 2 = Internal Error - System error
	 * or outage during opt-in or login bypass. Can retry
	 * opt-in or login bypass next time. Flow will force full authentication
	 * and allow buyer
	 * to complete transaction.
	 * -1 = None - the return value does not
	 * signify any valid remember me status.
	 *
	 * @Required
	 */
	private Integer ExternalRememberMeStatus;
	public Integer getExternalRememberMeStatus() {
		return ExternalRememberMeStatus;
	}
	public void setExternalRememberMeStatus(Integer value) {
		this.ExternalRememberMeStatus = value;
	}

	/**
	 * Identifier returned on external-remember-me-opt-in
	 * to allow the merchant to request
	 * bypass of PayPal login through
	 * external remember me on behalf of the buyer in future
	 * transactions. The ExternalRememberMeID is a 17-character
	 * alphanumeric (encrypted)
	 * string. This field has meaning only to
	 * the merchant.
	 */
	private String ExternalRememberMeID;
	public String getExternalRememberMeID() {
		return ExternalRememberMeID;
	}
	public void setExternalRememberMeID(String value) {
		this.ExternalRememberMeID = value;
	}


	public ExternalRememberMeStatusDetailsType() {
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
	 public ExternalRememberMeStatusDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("ExternalRememberMeStatus").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ExternalRememberMeStatus").item(0))){ 
		 this.ExternalRememberMeStatus =Integer.valueOf(document.getElementsByTagName("ExternalRememberMeStatus").item(0).getTextContent());

}
	}
		 if(document.getElementsByTagName("ExternalRememberMeID").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ExternalRememberMeID").item(0))){ 
		 this.ExternalRememberMeID =(String)document.getElementsByTagName("ExternalRememberMeID").item(0).getTextContent();

}
	}
	}
}

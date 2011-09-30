
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
import urn.ebay.api.PayPalAPI.DoAuthorizationResponseType;
import urn.ebay.apis.eBLBaseComponents.UATPDetailsType;


/**
 * Auth Authorization Code.
 */
public class DoUATPAuthorizationResponseType extends DoAuthorizationResponseType{

	/**
	 *
	 * @Required
	 */
	private UATPDetailsType UATPDetails;
	public UATPDetailsType getUATPDetails() {
		return UATPDetails;
	}
	public void setUATPDetails(UATPDetailsType value) {
		this.UATPDetails = value;
	}

	/**
	 * Auth Authorization Code.
	 *
	 * @Required
	 */
	private String AuthorizationCode;
	public String getAuthorizationCode() {
		return AuthorizationCode;
	}
	public void setAuthorizationCode(String value) {
		this.AuthorizationCode = value;
	}

	/**
	 * Invoice ID. A pass through.
	 */
	private String InvoiceID;
	public String getInvoiceID() {
		return InvoiceID;
	}
	public void setInvoiceID(String value) {
		this.InvoiceID = value;
	}


	public DoUATPAuthorizationResponseType() {
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
	 public DoUATPAuthorizationResponseType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 super(xmlSoap); 
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("UATPDetails").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("UATPDetails").item(0))){ 
		 nodeList = document.getElementsByTagName("UATPDetails");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.UATPDetails =  new UATPDetailsType(xmlString);

}
	}
		 if(document.getElementsByTagName("AuthorizationCode").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("AuthorizationCode").item(0))){ 
		 this.AuthorizationCode =(String)document.getElementsByTagName("AuthorizationCode").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("InvoiceID").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("InvoiceID").item(0))){ 
		 this.InvoiceID =(String)document.getElementsByTagName("InvoiceID").item(0).getTextContent();

}
	}
	}
}

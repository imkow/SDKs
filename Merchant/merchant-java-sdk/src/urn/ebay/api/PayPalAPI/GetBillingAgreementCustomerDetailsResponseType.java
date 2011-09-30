
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
import urn.ebay.apis.eBLBaseComponents.GetBillingAgreementCustomerDetailsResponseDetailsType;


/**
 */
public class GetBillingAgreementCustomerDetailsResponseType extends AbstractResponseType{

	/**
	 *
	 * @Required
	 */
	private GetBillingAgreementCustomerDetailsResponseDetailsType GetBillingAgreementCustomerDetailsResponseDetails;
	public GetBillingAgreementCustomerDetailsResponseDetailsType getGetBillingAgreementCustomerDetailsResponseDetails() {
		return GetBillingAgreementCustomerDetailsResponseDetails;
	}
	public void setGetBillingAgreementCustomerDetailsResponseDetails(GetBillingAgreementCustomerDetailsResponseDetailsType value) {
		this.GetBillingAgreementCustomerDetailsResponseDetails = value;
	}


	public GetBillingAgreementCustomerDetailsResponseType() {
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
	 public GetBillingAgreementCustomerDetailsResponseType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 super(xmlSoap); 
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("GetBillingAgreementCustomerDetailsResponseDetails").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("GetBillingAgreementCustomerDetailsResponseDetails").item(0))){ 
		 nodeList = document.getElementsByTagName("GetBillingAgreementCustomerDetailsResponseDetails");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.GetBillingAgreementCustomerDetailsResponseDetails =  new GetBillingAgreementCustomerDetailsResponseDetailsType(xmlString);

}
	}
	}
}

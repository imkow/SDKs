
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
 * The first name of the User.
 * Character length and limitations: 127 single-byte alphanumeric
 * characters
 */
public class GetAuthDetailsResponseDetailsType {

	/**
	 * The first name of the User.
	 * Character length and limitations: 127 single-byte alphanumeric
	 * characters
	 */
	private String FirstName;
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String value) {
		this.FirstName = value;
	}

	/**
	 * The Last name of the user.
	 * Character length and limitations: 127 single-byte alphanumeric
	 * characters
	 */
	private String LastName;
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String value) {
		this.LastName = value;
	}

	/**
	 * The email address of the user.
	 * Character length and limitations: 256 single-byte alphanumeric
	 * characters.
	 */
	private String Email;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String value) {
		this.Email = value;
	}

	/**
	 * Encrypted PayPal customer account identification number.
	 * Required
	 * Character length and limitations: 127 single-byte characters.
	 */
	private String PayerID;
	public String getPayerID() {
		return PayerID;
	}
	public void setPayerID(String value) {
		this.PayerID = value;
	}


	public GetAuthDetailsResponseDetailsType() {
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
	 public GetAuthDetailsResponseDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("FirstName").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("FirstName").item(0))){ 
		 this.FirstName =(String)document.getElementsByTagName("FirstName").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("LastName").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("LastName").item(0))){ 
		 this.LastName =(String)document.getElementsByTagName("LastName").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("Email").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("Email").item(0))){ 
		 this.Email =(String)document.getElementsByTagName("Email").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("PayerID").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("PayerID").item(0))){ 
		 this.PayerID =(String)document.getElementsByTagName("PayerID").item(0).getTextContent();

}
	}
	}
}

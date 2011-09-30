
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
 */
public class BMCreateButtonResponseType extends AbstractResponseType{

	/**
	 *
	 * @Required
	 */
	private String Website;
	public String getWebsite() {
		return Website;
	}
	public void setWebsite(String value) {
		this.Website = value;
	}

	/**
	 */
	private String Email;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String value) {
		this.Email = value;
	}

	/**
	 */
	private String Mobile;
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String value) {
		this.Mobile = value;
	}

	/**
	 */
	private String HostedButtonID;
	public String getHostedButtonID() {
		return HostedButtonID;
	}
	public void setHostedButtonID(String value) {
		this.HostedButtonID = value;
	}


	public BMCreateButtonResponseType() {
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
	 public BMCreateButtonResponseType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 super(xmlSoap); 
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("Website").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("Website").item(0))){ 
		 this.Website =(String)document.getElementsByTagName("Website").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("Email").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("Email").item(0))){ 
		 this.Email =(String)document.getElementsByTagName("Email").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("Mobile").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("Mobile").item(0))){ 
		 this.Mobile =(String)document.getElementsByTagName("Mobile").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("HostedButtonID").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("HostedButtonID").item(0))){ 
		 this.HostedButtonID =(String)document.getElementsByTagName("HostedButtonID").item(0).getTextContent();

}
	}
	}
}

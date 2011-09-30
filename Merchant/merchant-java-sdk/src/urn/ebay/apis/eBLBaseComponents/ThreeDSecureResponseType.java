
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
 * 3DS remaining fields.
 */
public class ThreeDSecureResponseType {

	/**
	 */
	private String Vpas;
	public String getVpas() {
		return Vpas;
	}
	public void setVpas(String value) {
		this.Vpas = value;
	}

	/**
	 */
	private String EciSubmitted3DS;
	public String getEciSubmitted3DS() {
		return EciSubmitted3DS;
	}
	public void setEciSubmitted3DS(String value) {
		this.EciSubmitted3DS = value;
	}


	public ThreeDSecureResponseType() {
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
	 public ThreeDSecureResponseType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("Vpas").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("Vpas").item(0))){ 
		 this.Vpas =(String)document.getElementsByTagName("Vpas").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("EciSubmitted3DS").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("EciSubmitted3DS").item(0))){ 
		 this.EciSubmitted3DS =(String)document.getElementsByTagName("EciSubmitted3DS").item(0).getTextContent();

}
	}
	}
}

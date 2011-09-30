
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
import urn.ebay.apis.eBLBaseComponents.ThreeDSecureRequestType;
import urn.ebay.apis.eBLBaseComponents.ThreeDSecureResponseType;


/**
 * 3DSecureInfoType
 * Information about 3D Secure parameters.
 */
public class ThreeDSecureInfoType {

	/**
	 */
	private ThreeDSecureRequestType ThreeDSecureRequest;
	public ThreeDSecureRequestType getThreeDSecureRequest() {
		return ThreeDSecureRequest;
	}
	public void setThreeDSecureRequest(ThreeDSecureRequestType value) {
		this.ThreeDSecureRequest = value;
	}

	/**
	 */
	private ThreeDSecureResponseType ThreeDSecureResponse;
	public ThreeDSecureResponseType getThreeDSecureResponse() {
		return ThreeDSecureResponse;
	}
	public void setThreeDSecureResponse(ThreeDSecureResponseType value) {
		this.ThreeDSecureResponse = value;
	}


	public ThreeDSecureInfoType() {
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
	 public ThreeDSecureInfoType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("ThreeDSecureRequest").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ThreeDSecureRequest").item(0))){ 
		 nodeList = document.getElementsByTagName("ThreeDSecureRequest");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.ThreeDSecureRequest =  new ThreeDSecureRequestType(xmlString);

}
	}
		 if(document.getElementsByTagName("ThreeDSecureResponse").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ThreeDSecureResponse").item(0))){ 
		 nodeList = document.getElementsByTagName("ThreeDSecureResponse");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.ThreeDSecureResponse =  new ThreeDSecureResponseType(xmlString);

}
	}
	}
}

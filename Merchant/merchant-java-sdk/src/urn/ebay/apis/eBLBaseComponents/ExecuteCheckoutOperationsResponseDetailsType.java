
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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import urn.ebay.apis.eBLBaseComponents.AuthorizationResponseType;
import urn.ebay.apis.eBLBaseComponents.SetDataResponseType;


/**
 */
public class ExecuteCheckoutOperationsResponseDetailsType {

	/**
	 *
	 * @Required
	 */
	private SetDataResponseType SetDataResponse;
	public SetDataResponseType getSetDataResponse() {
		return SetDataResponse;
	}
	public void setSetDataResponse(SetDataResponseType value) {
		this.SetDataResponse = value;
	}

	/**
	 */
	private AuthorizationResponseType AuthorizationResponse;
	public AuthorizationResponseType getAuthorizationResponse() {
		return AuthorizationResponse;
	}
	public void setAuthorizationResponse(AuthorizationResponseType value) {
		this.AuthorizationResponse = value;
	}


	public ExecuteCheckoutOperationsResponseDetailsType() {
	}
	 private  boolean isWhitespaceNode(Node n) {
		 if (n.getNodeType() == Node.TEXT_NODE) { 
				String val = n.getNodeValue();
				return val.trim().length() == 0; 
		 } else {
				return false;
		 } 
	 } 
	 private String convertToXML(Node n){ 
		 String name = n.getNodeName();
		 short type = n.getNodeType();
		 if (Node.CDATA_SECTION_NODE == type) {
			  return "<![CDATA[" + n.getNodeValue() + "]]&gt;";
		 } 
		 if (name.startsWith("#")) {
			  return "";
		} 
		 StringBuffer sb = new StringBuffer();
		 sb.append('<').append(name);
		 NamedNodeMap attrs = n.getAttributes();
		 if (attrs != null) { 
		  for (int i = 0; i < attrs.getLength(); i++) { 
			    Node attr = attrs.item(i);
			    sb.append(' ').append(attr.getNodeName()).append("=\"").append(attr.getNodeValue()).append("\"");
		  }
		 } 
		 String textContent = null; 
		 NodeList children = n.getChildNodes(); 
		 if (children.getLength() == 0) { 
		  if ((textContent = n.getTextContent()) != null && !"".equals(textContent)) {
		    sb.append(textContent).append("</").append(name).append('>'); 
		  } else { 
		    sb.append("/>"); 
		  } 
		 } else { 
		  sb.append('>'); 
		  boolean hasValidChildren = false;
		  for (int i = 0; i < children.getLength(); i++) { 
		    String childToString = convertToXML(children.item(i));
		    if (!"".equals(childToString)) {
		      sb.append(childToString); 
		      hasValidChildren = true; 
		    } 
		  } 
		  if (!hasValidChildren && ((textContent = n.getTextContent()) != null)) { 
		    sb.append(textContent); 
		 }
		  sb.append("</").append(name).append('>');
		 }
		 return sb.toString();
	 } 
	 public ExecuteCheckoutOperationsResponseDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("SetDataResponse").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("SetDataResponse").item(0))){ 
		 nodeList = document.getElementsByTagName("SetDataResponse");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.SetDataResponse =  new SetDataResponseType(xmlString);

}
	}
		 if(document.getElementsByTagName("AuthorizationResponse").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("AuthorizationResponse").item(0))){ 
		 nodeList = document.getElementsByTagName("AuthorizationResponse");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.AuthorizationResponse =  new AuthorizationResponseType(xmlString);

}
	}
	}
}

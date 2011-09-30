
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
 */
public class ButtonSearchResultType {

	/**
	 */
	private String HostedButtonID;
	public String getHostedButtonID() {
		return HostedButtonID;
	}
	public void setHostedButtonID(String value) {
		this.HostedButtonID = value;
	}

	/**
	 */
	private String ButtonType;
	public String getButtonType() {
		return ButtonType;
	}
	public void setButtonType(String value) {
		this.ButtonType = value;
	}

	/**
	 */
	private String ItemName;
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String value) {
		this.ItemName = value;
	}

	/**
	 */
	private String ModifyDate;
	public String getModifyDate() {
		return ModifyDate;
	}
	public void setModifyDate(String value) {
		this.ModifyDate = value;
	}


	public ButtonSearchResultType() {
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
	 public ButtonSearchResultType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("HostedButtonID").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("HostedButtonID").item(0))){ 
		 this.HostedButtonID =(String)document.getElementsByTagName("HostedButtonID").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("ButtonType").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ButtonType").item(0))){ 
		 this.ButtonType =(String)document.getElementsByTagName("ButtonType").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("ItemName").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ItemName").item(0))){ 
		 this.ItemName =(String)document.getElementsByTagName("ItemName").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("ModifyDate").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ModifyDate").item(0))){ 
		 this.ModifyDate =(String)document.getElementsByTagName("ModifyDate").item(0).getTextContent();

}
	}
	}
}

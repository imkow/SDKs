
/**
 * Auto generated code
 */

package urn.ebay.api.PayPalAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import urn.ebay.api.PayPalAPI.OptionSelectionDetailsType;


/**
 * Option Name.
 * Optional
 */
public class OptionDetailsType {

	/**
	 * Option Name.
	 * Optional
	 *
	 * @Required
	 */
	private String OptionName;
	public String getOptionName() {
		return OptionName;
	}
	public void setOptionName(String value) {
		this.OptionName = value;
	}

	/**
	 */
	private List<OptionSelectionDetailsType> OptionSelectionDetails = new ArrayList<OptionSelectionDetailsType>();
	public List<OptionSelectionDetailsType> getOptionSelectionDetails() {
		return OptionSelectionDetails;
	}
	public void setOptionSelectionDetails(List<OptionSelectionDetailsType> value) {
		this.OptionSelectionDetails = value;
	}


	public OptionDetailsType(String OptionName) {
		this.OptionName = OptionName;
	}
	public OptionDetailsType() {
	}

	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( OptionName != null ) {
			sb.append("<urn:OptionName>").append(OptionName);
			sb.append("</urn:OptionName>");
		}
		if( OptionSelectionDetails != null ) {
			for(int i=0; i<OptionSelectionDetails.size(); i++) {
				sb.append("<urn:OptionSelectionDetails>");
				sb.append(OptionSelectionDetails.get(i).toXMLString());
				sb.append("</urn:OptionSelectionDetails>");
			}
		}
		return sb.toString();
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
	 public OptionDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("OptionName").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("OptionName").item(0))){ 
		 this.OptionName =(String)document.getElementsByTagName("OptionName").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("OptionSelectionDetails").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("OptionSelectionDetails").item(0))){ 
		 nodeList = document.getElementsByTagName("OptionSelectionDetails");
		 for(int i=0; i<nodeList.getLength(); i++) {
			 xmlString = convertToXML(nodeList.item(i)); 
				this.OptionSelectionDetails.add(new OptionSelectionDetailsType(xmlString));
			}

}
	}
	}
}

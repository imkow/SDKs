
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
 * UATP Card Details Type 
 */
public class UATPDetailsType {

	/**
UATP Card Number	 */
	private String UATPNumber;
	public String getUATPNumber() {
		return UATPNumber;
	}
	public void setUATPNumber(String value) {
		this.UATPNumber = value;
	}

	/**
	 * UATP Card expirty month	 */
	private Integer ExpMonth;
	public Integer getExpMonth() {
		return ExpMonth;
	}
	public void setExpMonth(Integer value) {
		this.ExpMonth = value;
	}

	/**
	 * UATP Card expirty year	 */
	private Integer ExpYear;
	public Integer getExpYear() {
		return ExpYear;
	}
	public void setExpYear(Integer value) {
		this.ExpYear = value;
	}


	public UATPDetailsType() {
	}

	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( UATPNumber != null ) {
			sb.append("<ebl:UATPNumber>").append(UATPNumber);
			sb.append("</ebl:UATPNumber>");
		}
		if( ExpMonth != null ) {
			sb.append("<ebl:ExpMonth>").append(ExpMonth);
			sb.append("</ebl:ExpMonth>");
		}
		if( ExpYear != null ) {
			sb.append("<ebl:ExpYear>").append(ExpYear);
			sb.append("</ebl:ExpYear>");
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
	 public UATPDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("UATPNumber").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("UATPNumber").item(0))){ 
		 this.UATPNumber =(String)document.getElementsByTagName("UATPNumber").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("ExpMonth").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ExpMonth").item(0))){ 
		 this.ExpMonth =Integer.valueOf(document.getElementsByTagName("ExpMonth").item(0).getTextContent());

}
	}
		 if(document.getElementsByTagName("ExpYear").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ExpYear").item(0))){ 
		 this.ExpYear =Integer.valueOf(document.getElementsByTagName("ExpYear").item(0).getTextContent());

}
	}
	}
}

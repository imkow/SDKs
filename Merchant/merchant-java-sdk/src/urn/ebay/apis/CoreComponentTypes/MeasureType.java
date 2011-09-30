
/**
 * Auto generated code
 */

package urn.ebay.apis.CoreComponentTypes;

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
public class MeasureType {

	/**
	 *
	 * @Required
	 */
	private Double value;
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 *
	 * @Required
	 */
	private String unit;
	public String getUnit() {
		return unit;
	}
	public void setUnit(String value) {
		this.unit = value;
	}


	public MeasureType(Double value, String unit) {
		this.value = value;
		this.unit = unit;
	}
	public MeasureType() {
	}

	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( value != null ) {
			sb.append("<cc:value>").append(value);
			sb.append("</cc:value>");
		}
		if( unit != null ) {
			sb.append("<cc:unit>").append(unit);
			sb.append("</cc:unit>");
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
	 public MeasureType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("value").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("value").item(0))){ 
		 this.value =Double.valueOf(document.getElementsByTagName("value").item(0).getTextContent());

}
	}
		 if(document.getElementsByTagName("unit").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("unit").item(0))){ 
		 this.unit =(String)document.getElementsByTagName("unit").item(0).getTextContent();

}
	}
	}
}

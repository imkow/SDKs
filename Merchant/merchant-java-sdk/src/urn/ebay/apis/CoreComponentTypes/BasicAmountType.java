
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
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;


/**
 * On requests, you must set the currencyID attribute to one of the
 * three-character currency codes for any of the supported PayPal
 * currencies.
 * Limitations: Must not exceed $10,000 USD in any currency. No
 * currency symbol. Decimal separator must be a period (.), and the
 * thousands separator must be a comma (,).
 */
public class BasicAmountType {

	/**
	 *
	 * @Required
	 */
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 *
	 * @Required
	 */
	private CurrencyCodeType currencyID;
	public CurrencyCodeType getCurrencyID() {
		return currencyID;
	}
	public void setCurrencyID(CurrencyCodeType value) {
		this.currencyID = value;
	}


	public BasicAmountType(String value, CurrencyCodeType currencyID) {
		this.value = value;
		this.currencyID = currencyID;
	}
	public BasicAmountType() {
	}

	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( value != null ) {
			sb.append("<cc:value>").append(value);
			sb.append("</cc:value>");
		}
		if( currencyID != null ) {
			sb.append("<ebl:currencyID>").append( currencyID.getValue());
			sb.append("</ebl:currencyID>");
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
	 public BasicAmountType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("value").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("value").item(0))){ 
		 this.value =(String)document.getElementsByTagName("value").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("currencyID").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("currencyID").item(0))){ 
		 this.currencyID = CurrencyCodeType.fromValue(document.getElementsByTagName("currencyID").item(0).getTextContent());

}
	}
	}
}

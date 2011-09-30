
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
 * Details about the payer's tax info passed in by the merchant or
 * partner.
 * Optional.
 */
public class TaxIdDetailsType {

	/**
	 * The payer's Tax ID type; CNPJ/CPF for BR country.
	 */
	private String TaxIdType;
	public String getTaxIdType() {
		return TaxIdType;
	}
	public void setTaxIdType(String value) {
		this.TaxIdType = value;
	}

	/**
	 * The payer's Tax ID
	 */
	private String TaxId;
	public String getTaxId() {
		return TaxId;
	}
	public void setTaxId(String value) {
		this.TaxId = value;
	}


	public TaxIdDetailsType() {
	}

	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( TaxIdType != null ) {
			sb.append("<ebl:TaxIdType>").append(TaxIdType);
			sb.append("</ebl:TaxIdType>");
		}
		if( TaxId != null ) {
			sb.append("<ebl:TaxId>").append(TaxId);
			sb.append("</ebl:TaxId>");
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
	 public TaxIdDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("TaxIdType").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("TaxIdType").item(0))){ 
		 this.TaxIdType =(String)document.getElementsByTagName("TaxIdType").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("TaxId").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("TaxId").item(0))){ 
		 this.TaxId =(String)document.getElementsByTagName("TaxId").item(0).getTextContent();

}
	}
	}
}

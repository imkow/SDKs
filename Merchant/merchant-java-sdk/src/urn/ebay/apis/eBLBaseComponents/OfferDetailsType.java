
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
import urn.ebay.apis.eBLBaseComponents.BMLOfferInfoType;


/**
 * OfferDetailsType
 * Specific information for an offer.
 */
public class OfferDetailsType {

	/**
	 * Code used to identify the promotion offer.
	 */
	private String OfferCode;
	public String getOfferCode() {
		return OfferCode;
	}
	public void setOfferCode(String value) {
		this.OfferCode = value;
	}

	/**
	 * Specific infromation for BML, Similar structure could be added
	 * for sepcific
	 * promotion needs like CrossPromotions
	 */
	private BMLOfferInfoType BMLOfferInfo;
	public BMLOfferInfoType getBMLOfferInfo() {
		return BMLOfferInfo;
	}
	public void setBMLOfferInfo(BMLOfferInfoType value) {
		this.BMLOfferInfo = value;
	}


	public OfferDetailsType() {
	}

	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( OfferCode != null ) {
			sb.append("<ebl:OfferCode>").append(OfferCode);
			sb.append("</ebl:OfferCode>");
		}
		if( BMLOfferInfo != null ) {
			sb.append("<ebl:BMLOfferInfo>");
			sb.append(BMLOfferInfo.toXMLString());
			sb.append("</ebl:BMLOfferInfo>");
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
	 public OfferDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("OfferCode").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("OfferCode").item(0))){ 
		 this.OfferCode =(String)document.getElementsByTagName("OfferCode").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("BMLOfferInfo").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("BMLOfferInfo").item(0))){ 
		 nodeList = document.getElementsByTagName("BMLOfferInfo");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.BMLOfferInfo =  new BMLOfferInfoType(xmlString);

}
	}
	}
}

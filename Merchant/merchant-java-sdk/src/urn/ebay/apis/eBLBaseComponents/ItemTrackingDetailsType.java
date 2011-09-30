
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
 * Item Number.
 * Required
 */
public class ItemTrackingDetailsType {

	/**
	 * Item Number.
	 * Required
	 */
	private String ItemNumber;
	public String getItemNumber() {
		return ItemNumber;
	}
	public void setItemNumber(String value) {
		this.ItemNumber = value;
	}

	/**
	 * Option Quantity.
	 * Optional
	 */
	private String ItemQty;
	public String getItemQty() {
		return ItemQty;
	}
	public void setItemQty(String value) {
		this.ItemQty = value;
	}

	/**
	 * Item Quantity Delta.
	 * Optional
	 */
	private String ItemQtyDelta;
	public String getItemQtyDelta() {
		return ItemQtyDelta;
	}
	public void setItemQtyDelta(String value) {
		this.ItemQtyDelta = value;
	}

	/**
	 * Item Alert.
	 * Optional
	 */
	private String ItemAlert;
	public String getItemAlert() {
		return ItemAlert;
	}
	public void setItemAlert(String value) {
		this.ItemAlert = value;
	}

	/**
	 * Item Cost.
	 * Optional
	 */
	private String ItemCost;
	public String getItemCost() {
		return ItemCost;
	}
	public void setItemCost(String value) {
		this.ItemCost = value;
	}


	public ItemTrackingDetailsType() {
	}

	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( ItemNumber != null ) {
			sb.append("<ebl:ItemNumber>").append(ItemNumber);
			sb.append("</ebl:ItemNumber>");
		}
		if( ItemQty != null ) {
			sb.append("<ebl:ItemQty>").append(ItemQty);
			sb.append("</ebl:ItemQty>");
		}
		if( ItemQtyDelta != null ) {
			sb.append("<ebl:ItemQtyDelta>").append(ItemQtyDelta);
			sb.append("</ebl:ItemQtyDelta>");
		}
		if( ItemAlert != null ) {
			sb.append("<ebl:ItemAlert>").append(ItemAlert);
			sb.append("</ebl:ItemAlert>");
		}
		if( ItemCost != null ) {
			sb.append("<ebl:ItemCost>").append(ItemCost);
			sb.append("</ebl:ItemCost>");
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
	 public ItemTrackingDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("ItemNumber").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ItemNumber").item(0))){ 
		 this.ItemNumber =(String)document.getElementsByTagName("ItemNumber").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("ItemQty").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ItemQty").item(0))){ 
		 this.ItemQty =(String)document.getElementsByTagName("ItemQty").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("ItemQtyDelta").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ItemQtyDelta").item(0))){ 
		 this.ItemQtyDelta =(String)document.getElementsByTagName("ItemQtyDelta").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("ItemAlert").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ItemAlert").item(0))){ 
		 this.ItemAlert =(String)document.getElementsByTagName("ItemAlert").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("ItemCost").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ItemCost").item(0))){ 
		 this.ItemCost =(String)document.getElementsByTagName("ItemCost").item(0).getTextContent();

}
	}
	}
}

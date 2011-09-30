
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
import urn.ebay.apis.eBLBaseComponents.AddressType;


/**
 * Subscriber name - if missing, will use name in buyer's account
 */
public class RecurringPaymentsProfileDetailsType {

	/**
	 * Subscriber name - if missing, will use name in buyer's account
	 */
	private String SubscriberName;
	public String getSubscriberName() {
		return SubscriberName;
	}
	public void setSubscriberName(String value) {
		this.SubscriberName = value;
	}

	/**
	 * Subscriber address - if missing, will use address in buyer's account
	 */
	private AddressType SubscriberShippingAddress;
	public AddressType getSubscriberShippingAddress() {
		return SubscriberShippingAddress;
	}
	public void setSubscriberShippingAddress(AddressType value) {
		this.SubscriberShippingAddress = value;
	}

	/**
	 * When does this Profile begin billing?
	 *
	 * @Required
	 */
	private String BillingStartDate;
	public String getBillingStartDate() {
		return BillingStartDate;
	}
	public void setBillingStartDate(String value) {
		this.BillingStartDate = value;
	}

	/**
	 * Your own unique invoice or tracking number.
	 * Optional
	 * Character length and limitations: 127 single-byte alphanumeric
	 * characters
	 */
	private String ProfileReference;
	public String getProfileReference() {
		return ProfileReference;
	}
	public void setProfileReference(String value) {
		this.ProfileReference = value;
	}


	public RecurringPaymentsProfileDetailsType(String BillingStartDate) {
		this.BillingStartDate = BillingStartDate;
	}
	public RecurringPaymentsProfileDetailsType() {
	}

	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( SubscriberName != null ) {
			sb.append("<ebl:SubscriberName>").append(SubscriberName);
			sb.append("</ebl:SubscriberName>");
		}
		if( SubscriberShippingAddress != null ) {
			sb.append("<ebl:SubscriberShippingAddress>");
			sb.append(SubscriberShippingAddress.toXMLString());
			sb.append("</ebl:SubscriberShippingAddress>");
		}
		if( BillingStartDate != null ) {
			sb.append("<ebl:BillingStartDate>").append(BillingStartDate);
			sb.append("</ebl:BillingStartDate>");
		}
		if( ProfileReference != null ) {
			sb.append("<ebl:ProfileReference>").append(ProfileReference);
			sb.append("</ebl:ProfileReference>");
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
	 public RecurringPaymentsProfileDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("SubscriberName").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("SubscriberName").item(0))){ 
		 this.SubscriberName =(String)document.getElementsByTagName("SubscriberName").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("SubscriberShippingAddress").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("SubscriberShippingAddress").item(0))){ 
		 nodeList = document.getElementsByTagName("SubscriberShippingAddress");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.SubscriberShippingAddress =  new AddressType(xmlString);

}
	}
		 if(document.getElementsByTagName("BillingStartDate").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("BillingStartDate").item(0))){ 
		 this.BillingStartDate =(String)document.getElementsByTagName("BillingStartDate").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("ProfileReference").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ProfileReference").item(0))){ 
		 this.ProfileReference =(String)document.getElementsByTagName("ProfileReference").item(0).getTextContent();

}
	}
	}
}

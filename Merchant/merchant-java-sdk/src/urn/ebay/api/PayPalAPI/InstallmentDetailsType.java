
/**
 * Auto generated code
 */

package urn.ebay.api.PayPalAPI;

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
import urn.ebay.apis.eBLBaseComponents.BillingPeriodType;


/**
 * Installment Period.
 * Optional
 */
public class InstallmentDetailsType {

	/**
	 * Installment Period.
	 * Optional
	 */
	private BillingPeriodType BillingPeriod;
	public BillingPeriodType getBillingPeriod() {
		return BillingPeriod;
	}
	public void setBillingPeriod(BillingPeriodType value) {
		this.BillingPeriod = value;
	}

	/**
	 * Installment Frequency.
	 * Optional
	 */
	private Integer BillingFrequency;
	public Integer getBillingFrequency() {
		return BillingFrequency;
	}
	public void setBillingFrequency(Integer value) {
		this.BillingFrequency = value;
	}

	/**
	 * Installment Cycles.
	 * Optional
	 */
	private Integer TotalBillingCycles;
	public Integer getTotalBillingCycles() {
		return TotalBillingCycles;
	}
	public void setTotalBillingCycles(Integer value) {
		this.TotalBillingCycles = value;
	}

	/**
	 * Installment Amount.
	 * Optional
	 */
	private String Amount;
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String value) {
		this.Amount = value;
	}

	/**
	 * Installment Amount.
	 * Optional
	 */
	private String ShippingAmount;
	public String getShippingAmount() {
		return ShippingAmount;
	}
	public void setShippingAmount(String value) {
		this.ShippingAmount = value;
	}

	/**
	 * Installment Amount.
	 * Optional
	 */
	private String TaxAmount;
	public String getTaxAmount() {
		return TaxAmount;
	}
	public void setTaxAmount(String value) {
		this.TaxAmount = value;
	}


	public InstallmentDetailsType() {
	}

	public String toXMLString()  {
		StringBuilder sb = new StringBuilder();
		if( BillingPeriod != null ) {
			sb.append("<ebl:BillingPeriod>").append( BillingPeriod.getValue());
			sb.append("</ebl:BillingPeriod>");
		}
		if( BillingFrequency != null ) {
			sb.append("<urn:BillingFrequency>").append(BillingFrequency);
			sb.append("</urn:BillingFrequency>");
		}
		if( TotalBillingCycles != null ) {
			sb.append("<urn:TotalBillingCycles>").append(TotalBillingCycles);
			sb.append("</urn:TotalBillingCycles>");
		}
		if( Amount != null ) {
			sb.append("<urn:Amount>").append(Amount);
			sb.append("</urn:Amount>");
		}
		if( ShippingAmount != null ) {
			sb.append("<urn:ShippingAmount>").append(ShippingAmount);
			sb.append("</urn:ShippingAmount>");
		}
		if( TaxAmount != null ) {
			sb.append("<urn:TaxAmount>").append(TaxAmount);
			sb.append("</urn:TaxAmount>");
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
	 public InstallmentDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("BillingPeriod").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("BillingPeriod").item(0))){ 
		 this.BillingPeriod = BillingPeriodType.fromValue(document.getElementsByTagName("BillingPeriod").item(0).getTextContent());

}
	}
		 if(document.getElementsByTagName("BillingFrequency").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("BillingFrequency").item(0))){ 
		 this.BillingFrequency =Integer.valueOf(document.getElementsByTagName("BillingFrequency").item(0).getTextContent());

}
	}
		 if(document.getElementsByTagName("TotalBillingCycles").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("TotalBillingCycles").item(0))){ 
		 this.TotalBillingCycles =Integer.valueOf(document.getElementsByTagName("TotalBillingCycles").item(0).getTextContent());

}
	}
		 if(document.getElementsByTagName("Amount").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("Amount").item(0))){ 
		 this.Amount =(String)document.getElementsByTagName("Amount").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("ShippingAmount").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ShippingAmount").item(0))){ 
		 this.ShippingAmount =(String)document.getElementsByTagName("ShippingAmount").item(0).getTextContent();

}
	}
		 if(document.getElementsByTagName("TaxAmount").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("TaxAmount").item(0))){ 
		 this.TaxAmount =(String)document.getElementsByTagName("TaxAmount").item(0).getTextContent();

}
	}
	}
}

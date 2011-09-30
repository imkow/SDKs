
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
import urn.ebay.apis.eBLBaseComponents.RiskFilterListType;


/**
 * Thes are filters that could result in
 * accept/deny/pending action.
 */
public class FMFDetailsType {

	/**
	 */
	private RiskFilterListType AcceptFilters;
	public RiskFilterListType getAcceptFilters() {
		return AcceptFilters;
	}
	public void setAcceptFilters(RiskFilterListType value) {
		this.AcceptFilters = value;
	}

	/**
	 */
	private RiskFilterListType PendingFilters;
	public RiskFilterListType getPendingFilters() {
		return PendingFilters;
	}
	public void setPendingFilters(RiskFilterListType value) {
		this.PendingFilters = value;
	}

	/**
	 */
	private RiskFilterListType DenyFilters;
	public RiskFilterListType getDenyFilters() {
		return DenyFilters;
	}
	public void setDenyFilters(RiskFilterListType value) {
		this.DenyFilters = value;
	}

	/**
	 */
	private RiskFilterListType ReportFilters;
	public RiskFilterListType getReportFilters() {
		return ReportFilters;
	}
	public void setReportFilters(RiskFilterListType value) {
		this.ReportFilters = value;
	}


	public FMFDetailsType() {
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
	 public FMFDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("AcceptFilters").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("AcceptFilters").item(0))){ 
		 nodeList = document.getElementsByTagName("AcceptFilters");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.AcceptFilters =  new RiskFilterListType(xmlString);

}
	}
		 if(document.getElementsByTagName("PendingFilters").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("PendingFilters").item(0))){ 
		 nodeList = document.getElementsByTagName("PendingFilters");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.PendingFilters =  new RiskFilterListType(xmlString);

}
	}
		 if(document.getElementsByTagName("DenyFilters").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("DenyFilters").item(0))){ 
		 nodeList = document.getElementsByTagName("DenyFilters");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.DenyFilters =  new RiskFilterListType(xmlString);

}
	}
		 if(document.getElementsByTagName("ReportFilters").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("ReportFilters").item(0))){ 
		 nodeList = document.getElementsByTagName("ReportFilters");
			 xmlString = convertToXML(nodeList.item(0)); 
			 this.ReportFilters =  new RiskFilterListType(xmlString);

}
	}
	}
}

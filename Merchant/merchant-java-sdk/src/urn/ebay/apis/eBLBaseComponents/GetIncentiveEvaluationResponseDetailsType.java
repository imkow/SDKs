
/**
 * Auto generated code
 */

package urn.ebay.apis.eBLBaseComponents;

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
import urn.ebay.apis.eBLBaseComponents.IncentiveDetailType;


/**
 */
public class GetIncentiveEvaluationResponseDetailsType {

	/**
	 */
	private List<IncentiveDetailType> IncentiveDetails = new ArrayList<IncentiveDetailType>();
	public List<IncentiveDetailType> getIncentiveDetails() {
		return IncentiveDetails;
	}
	public void setIncentiveDetails(List<IncentiveDetailType> value) {
		this.IncentiveDetails = value;
	}

	/**
	 */
	private String RequestId;
	public String getRequestId() {
		return RequestId;
	}
	public void setRequestId(String value) {
		this.RequestId = value;
	}


	public GetIncentiveEvaluationResponseDetailsType() {
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
	 public GetIncentiveEvaluationResponseDetailsType(Object xmlSoap) throws IOException,SAXException,ParserConfigurationException	{
		 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = builderFactory.newDocumentBuilder();
		 InputSource inStream = new InputSource(); 
		 inStream.setCharacterStream(new StringReader((String)xmlSoap));
		 Document document = builder.parse(inStream);
		 NodeList nodeList= null; 
		 String xmlString ="";
		 if(document.getElementsByTagName("IncentiveDetails").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("IncentiveDetails").item(0))){ 
		 nodeList = document.getElementsByTagName("IncentiveDetails");
		 for(int i=0; i<nodeList.getLength(); i++) {
			 xmlString = convertToXML(nodeList.item(i)); 
				this.IncentiveDetails.add(new IncentiveDetailType(xmlString));
			}

}
	}
		 if(document.getElementsByTagName("RequestId").getLength()!=0){		 if(!isWhitespaceNode(document.getElementsByTagName("RequestId").item(0))){ 
		 this.RequestId =(String)document.getElementsByTagName("RequestId").item(0).getTextContent();

}
	}
	}
}

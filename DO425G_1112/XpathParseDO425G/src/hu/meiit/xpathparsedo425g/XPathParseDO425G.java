package hu.meiit.xpathparsedo425g;

import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathParseDO425G {

	public static void main(String[] args) {
		
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setNamespaceAware(true);
	        DocumentBuilder builder;
	        Document doc = null;
	        try {
	            builder = factory.newDocumentBuilder();
	            doc = builder.parse("studentDO425G.xml");
	            doc.getDocumentElement().normalize();

	            NodeList nList = doc.getElementsByTagName("student");
				
				for(int i=0; i<nList.getLength(); i++) {
					Node nNode = nList.item(i);
					System.out.println("\nCurrent Element: "+ nNode.getNodeName());
					
					if(nNode.getNodeType()==Node.ELEMENT_NODE) {
						Element nElement = (Element)nNode;
						System.out.println("Student roll no: "+ nElement.getAttribute("rollno"));
						
						System.out.println("First Name: "+ nElement.getElementsByTagName("firstname").item(0).getTextContent());
						System.out.println("Last Name: "+ nElement.getElementsByTagName("lastname").item(0).getTextContent());
						System.out.println("Nick name:  "+ nElement.getElementsByTagName("nickname").item(0).getTextContent());
						System.out.println("Marks: "+ nElement.getElementsByTagName("marks").item(0).getTextContent());
					}
					
				}

	        } catch (ParserConfigurationException | SAXException | IOException e) {
	            e.printStackTrace();
	        }
	    }

	

	}

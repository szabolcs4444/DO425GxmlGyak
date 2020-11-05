package dom425g;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.*;

public class DomParserDO425G {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(new File("student.xml"));
			dom.getDocumentElement().normalize();
			NodeList nList = dom.getElementsByTagName("student");
			System.out.println("Root element" + dom.getDocumentElement().getNodeName());
			
System.out.println("           ");
			
			for(int i = 0;i<nList.getLength();i++) {
				Node nNode = nList.item(i);
				System.out.println("\nCurrent Element: " + nNode.getNodeName());
				
				
				if(nNode.getNodeType()== Node.ELEMENT_NODE) {
					Element nElement = (Element)nNode;
					System.out.println("Student roll no: "+ nElement.getAttribute("rollno"));
					System.out.println("First Name:"+ nElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last  Name:"+ nElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick  Name:"+ nElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Age       :"+ nElement.getElementsByTagName("age").item(0).getTextContent());
				}
				
			}
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}

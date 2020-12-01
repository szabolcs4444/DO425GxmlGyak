package hu.domparse.do425g;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;


public class DOMModifyDO425G {

	public static void main(String[] args) {
		NodeList nodelist;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			// F�jl beolvas�sa
			Document document = builder.parse(new File("XMLDO425G.xml"));
			document.getDocumentElement().normalize();
			// Aktu�lis elem meghat�roz�sa
			nodelist = document.getElementsByTagName("szalloda");
			for(int i = 0;i<nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktu�lis elem:"+ node.getNodeName());
				//Sz�lloda adatainak ki�rat�sa
				if(node.getNodeType()== Node.ELEMENT_NODE) {
					Element element = (Element) node;
					
					
					System.out.println("Sz�lloda ad�sz�ma:"+ element.getAttribute("szalloda_adoszam"));
					System.out.println("Sz�lloda szobasz�m:"+ element.getAttribute("ref_szoba"));
					System.out.println("Sz�lloda vend�g szem�lyigazolv�ny sz�ma:"+ element.getAttribute("ref_vendeg"));
					System.out.println("Sz�lloda alkalmazott szem�lyigazolv�ny sz�ma:"+ element.getAttribute("ref_alkalmazott"));
					Node nodecim = nodelist.item(i);
					//Sz�lloda bel�li lakc�m adatok ki�rat�sa
					if(nodecim.getNodeType()==Node.ELEMENT_NODE) {
						Element elementcim = (Element) node;
						//Sz�lloda ad�sz�m vizsg�lata, ha egyezik akkor az adatok m�dos�t�sa
						if(element.getAttribute("szalloda_adoszam").equals("12345678-2-25")) {
							 elementcim.getElementsByTagName("irsz").item(0).setTextContent("3700");
							 elementcim.getElementsByTagName("telepules").item(0).setTextContent("Kazincbarcika");
							elementcim.getElementsByTagName("utca").item(0).setTextContent("�p�t�k utca");
							 elementcim.getElementsByTagName("hsz").item(0).setTextContent("44");
						}
							System.out.println(
									"Ir�ny�t�sz�m: " + element.getElementsByTagName("irsz").item(0).getTextContent());
							System.out.println(
									"Telep�l�s: " + element.getElementsByTagName("telepules").item(0).getTextContent());
							System.out.println("Utca: " + element.getElementsByTagName("utca").item(0).getTextContent());
							System.out.println("H�zsz�m: " + element.getElementsByTagName("hsz").item(0).getTextContent());
						}
					}
				}
			//m�dos�tott xml f�jl l�trehoz�sa
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Source input = new DOMSource(document);
			Result output = new StreamResult(new File("XMLDO425GModify.xml"));
			transformer.transform(input, output);
			}catch(ParserConfigurationException pce) {
				pce.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}

	}

}

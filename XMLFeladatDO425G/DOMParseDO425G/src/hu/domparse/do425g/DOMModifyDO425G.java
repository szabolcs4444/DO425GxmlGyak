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
			// Fájl beolvasása
			Document document = builder.parse(new File("XMLDO425G.xml"));
			document.getDocumentElement().normalize();
			// Aktuális elem meghatározása
			nodelist = document.getElementsByTagName("szalloda");
			for(int i = 0;i<nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktuális elem:"+ node.getNodeName());
				//Szálloda adatainak kiíratása
				if(node.getNodeType()== Node.ELEMENT_NODE) {
					Element element = (Element) node;
					
					
					System.out.println("Szálloda adószáma:"+ element.getAttribute("szalloda_adoszam"));
					System.out.println("Szálloda szobaszám:"+ element.getAttribute("ref_szoba"));
					System.out.println("Szálloda vendég személyigazolvány száma:"+ element.getAttribute("ref_vendeg"));
					System.out.println("Szálloda alkalmazott személyigazolvány száma:"+ element.getAttribute("ref_alkalmazott"));
					Node nodecim = nodelist.item(i);
					//Szálloda belüli lakcím adatok kiíratása
					if(nodecim.getNodeType()==Node.ELEMENT_NODE) {
						Element elementcim = (Element) node;
						//Szálloda adószám vizsgálata, ha egyezik akkor az adatok módosítása
						if(element.getAttribute("szalloda_adoszam").equals("12345678-2-25")) {
							 elementcim.getElementsByTagName("irsz").item(0).setTextContent("3700");
							 elementcim.getElementsByTagName("telepules").item(0).setTextContent("Kazincbarcika");
							elementcim.getElementsByTagName("utca").item(0).setTextContent("Építõk utca");
							 elementcim.getElementsByTagName("hsz").item(0).setTextContent("44");
						}
							System.out.println(
									"Irányítószám: " + element.getElementsByTagName("irsz").item(0).getTextContent());
							System.out.println(
									"Település: " + element.getElementsByTagName("telepules").item(0).getTextContent());
							System.out.println("Utca: " + element.getElementsByTagName("utca").item(0).getTextContent());
							System.out.println("Házszám: " + element.getElementsByTagName("hsz").item(0).getTextContent());
						}
					}
				}
			//módosított xml fájl létrehozása
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

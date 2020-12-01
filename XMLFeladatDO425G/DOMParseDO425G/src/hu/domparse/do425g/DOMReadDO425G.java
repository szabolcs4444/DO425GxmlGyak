package hu.domparse.do425g;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class DOMReadDO425G {

	public static void main(String[] args) {
		NodeList nodelist;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			//fájl beolvasása
			Document document = builder.parse(new File("XMLDO425G.xml"));
			document.getDocumentElement().normalize();
			//Gyökér elem keresése
			System.out.println("Root element:" + document.getDocumentElement().getNodeName());
			System.out.println("_______________________");
			//Aktuális elem meghatározása
			nodelist = document.getElementsByTagName("szalloda");

			for (int i = 0; i < nodelist.getLength(); i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktuális elem: " + node.getNodeName());
				//Szálloda adatainak kiíratása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Szálloda adószáma: " + element.getAttribute("szalloda_adoszam"));
					System.out.println("Szállodához tartozó szobaszám: " + element.getAttribute("ref_szoba"));
					System.out.println("Szállodához tartozó vendég személyigazolvány szám: " + element.getAttribute("ref_vendeg"));
					System.out.println("Szálloda Alkalmazott személyigazolvány száma: " + element.getAttribute("ref_alkalmazott"));
					System.out
							.println("Szálloda Neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
					//Szállodán belüli cím kiíratása
					Node nodecim = nodelist.item(i);
					if (nodecim.getNodeType() == Node.ELEMENT_NODE) {
						Element elementcim = (Element) node;
						System.out.println(
								"Irányítószám: " + element.getElementsByTagName("irsz").item(0).getTextContent());
						System.out.println(
								"Település: " + element.getElementsByTagName("telepules").item(0).getTextContent());
						System.out.println("Utca: " + element.getElementsByTagName("utca").item(0).getTextContent());
						System.out.println("Házszám: " + element.getElementsByTagName("hsz").item(0).getTextContent());
					}
				}
			}
			//Aktuális elem meghatározása
			nodelist = document.getElementsByTagName("szoba");
			for(int i = 0; i < nodelist.getLength(); i++ ) {
				Node node = nodelist.item(i);
				System.out.println("\nAktuális elem: "+ node.getNodeName());
				//Szoba adatainak kiíratása
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Szoba ajtószáma: " + element.getAttribute("szoba_ajtoszam"));
					System.out.println("Szálloda adószáma: " + element.getAttribute("ref_szalloda"));
					System.out.println("Szoba mérete: " + element.getElementsByTagName("meret").item(0).getTextContent());
					System.out.println("Szoba ára: " + element.getElementsByTagName("ar").item(0).getTextContent());
					System.out.println("Szoba típusa: " + element.getElementsByTagName("tipus").item(0).getTextContent());
				}
					
			}
			//Aktuális elem meghatározása
			nodelist = document.getElementsByTagName("vendeg");
			for(int i = 0;i< nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktuális elem: "+ node.getNodeName());
				//Vendég adatainak kiíratása
				if(node.getNodeType()== Node.ELEMENT_NODE) {
					Element element =(Element) node;
					System.out.println("Vendég Személyigazolvány száma: " + element.getAttribute("vendeg_szigsz"));
					System.out.println("Szálloda adószáma: " + element.getAttribute("ref_szalloda"));
					System.out.println("Vendég Neve: " + element.getElementsByTagName("vendegnev").item(0).getTextContent());
					Node nodecim = nodelist.item(i);
					//Vendégeken belüli címek kiíratása
					if (nodecim.getNodeType() == Node.ELEMENT_NODE) {
						Element elementcim = (Element) node;
						System.out.println(
								"Irányítószám: " + element.getElementsByTagName("irsz").item(0).getTextContent());
						System.out.println(
								"Település: " + element.getElementsByTagName("telepules").item(0).getTextContent());
						System.out.println("Utca: " + element.getElementsByTagName("utca").item(0).getTextContent());
						System.out.println("Házszám: " + element.getElementsByTagName("hsz").item(0).getTextContent());
					}
					System.out.println("Vendég telefonszáma: " + element.getElementsByTagName("telefonszam").item(0).getTextContent());
					
				}
			}
			//Aktuális elem meghatározása
			nodelist = document.getElementsByTagName("alkalmazott");
			for(int i = 0;i< nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktuális elem: "+ node.getNodeName());
				//Alkalmazott adatainak kiíratása
				if(node.getNodeType()== Node.ELEMENT_NODE) {
					Element element =(Element) node;
					System.out.println("Alkalmazott Személyigazolvány száma: " + element.getAttribute("alkalmazott_szigsz"));
					System.out.println("Szálloda száma: " + element.getAttribute("ref_szalloda"));
					System.out.println("Alkalmazott kora: " + element.getElementsByTagName("kor").item(0).getTextContent());
					//Alkalmazotton belüli születési adatok kiíratása
					Node nodeszuletesdatum = nodelist.item(i);
					if (nodeszuletesdatum.getNodeType() == Node.ELEMENT_NODE) {
						Element elementcim = (Element) node;
						System.out.println("Születési idõ: " + element.getElementsByTagName("ido").item(0).getTextContent());
						System.out.println(
								"Születési hely: " + element.getElementsByTagName("hely").item(0).getTextContent());
			
					}
				}
			}
			//Aktuális elem meghatározása
			nodelist = document.getElementsByTagName("vegzettsegek");
			for(int i = 0;i< nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktuális elem: "+ node.getNodeName());
				//Vegzettségek adatainak kiíratása
				if(node.getNodeType()== Node.ELEMENT_NODE) {
					Element element =(Element) node;
					System.out.println("Végzettséggel rendelkezõ Személyigazolvány száma: " + element.getAttribute("ref_szigsz"));	
					System.out.println("Végzettség: " + element.getElementsByTagName("vegzettseg").item(0).getTextContent());
				}
			}
			//Aktuális elem meghatározása
			nodelist = document.getElementsByTagName("dolgozik");
			for(int i = 0;i< nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktuális elem: "+ node.getNodeName());
				//Dolgozik adatainak kiíratása
				if(node.getNodeType()== Node.ELEMENT_NODE) {
					Element element =(Element) node;
					System.out.println("Dolgozói Személyigazolvány szám: " + element.getAttribute("ref_szigsz"));
					System.out.println("Dolgozói Szálloda száma: " + element.getAttribute("ref_szalloda"));
					System.out.println("Munkavégzés idõtartama: " + element.getElementsByTagName("idotartam").item(0).getTextContent());
				}
			}

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

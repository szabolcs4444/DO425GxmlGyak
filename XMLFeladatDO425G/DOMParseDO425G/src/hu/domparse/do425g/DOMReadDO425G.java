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
			//f�jl beolvas�sa
			Document document = builder.parse(new File("XMLDO425G.xml"));
			document.getDocumentElement().normalize();
			//Gy�k�r elem keres�se
			System.out.println("Root element:" + document.getDocumentElement().getNodeName());
			System.out.println("_______________________");
			//Aktu�lis elem meghat�roz�sa
			nodelist = document.getElementsByTagName("szalloda");

			for (int i = 0; i < nodelist.getLength(); i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktu�lis elem: " + node.getNodeName());
				//Sz�lloda adatainak ki�rat�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Sz�lloda ad�sz�ma: " + element.getAttribute("szalloda_adoszam"));
					System.out.println("Sz�llod�hoz tartoz� szobasz�m: " + element.getAttribute("ref_szoba"));
					System.out.println("Sz�llod�hoz tartoz� vend�g szem�lyigazolv�ny sz�m: " + element.getAttribute("ref_vendeg"));
					System.out.println("Sz�lloda Alkalmazott szem�lyigazolv�ny sz�ma: " + element.getAttribute("ref_alkalmazott"));
					System.out
							.println("Sz�lloda Neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
					//Sz�llod�n bel�li c�m ki�rat�sa
					Node nodecim = nodelist.item(i);
					if (nodecim.getNodeType() == Node.ELEMENT_NODE) {
						Element elementcim = (Element) node;
						System.out.println(
								"Ir�ny�t�sz�m: " + element.getElementsByTagName("irsz").item(0).getTextContent());
						System.out.println(
								"Telep�l�s: " + element.getElementsByTagName("telepules").item(0).getTextContent());
						System.out.println("Utca: " + element.getElementsByTagName("utca").item(0).getTextContent());
						System.out.println("H�zsz�m: " + element.getElementsByTagName("hsz").item(0).getTextContent());
					}
				}
			}
			//Aktu�lis elem meghat�roz�sa
			nodelist = document.getElementsByTagName("szoba");
			for(int i = 0; i < nodelist.getLength(); i++ ) {
				Node node = nodelist.item(i);
				System.out.println("\nAktu�lis elem: "+ node.getNodeName());
				//Szoba adatainak ki�rat�sa
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Szoba ajt�sz�ma: " + element.getAttribute("szoba_ajtoszam"));
					System.out.println("Sz�lloda ad�sz�ma: " + element.getAttribute("ref_szalloda"));
					System.out.println("Szoba m�rete: " + element.getElementsByTagName("meret").item(0).getTextContent());
					System.out.println("Szoba �ra: " + element.getElementsByTagName("ar").item(0).getTextContent());
					System.out.println("Szoba t�pusa: " + element.getElementsByTagName("tipus").item(0).getTextContent());
				}
					
			}
			//Aktu�lis elem meghat�roz�sa
			nodelist = document.getElementsByTagName("vendeg");
			for(int i = 0;i< nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktu�lis elem: "+ node.getNodeName());
				//Vend�g adatainak ki�rat�sa
				if(node.getNodeType()== Node.ELEMENT_NODE) {
					Element element =(Element) node;
					System.out.println("Vend�g Szem�lyigazolv�ny sz�ma: " + element.getAttribute("vendeg_szigsz"));
					System.out.println("Sz�lloda ad�sz�ma: " + element.getAttribute("ref_szalloda"));
					System.out.println("Vend�g Neve: " + element.getElementsByTagName("vendegnev").item(0).getTextContent());
					Node nodecim = nodelist.item(i);
					//Vend�geken bel�li c�mek ki�rat�sa
					if (nodecim.getNodeType() == Node.ELEMENT_NODE) {
						Element elementcim = (Element) node;
						System.out.println(
								"Ir�ny�t�sz�m: " + element.getElementsByTagName("irsz").item(0).getTextContent());
						System.out.println(
								"Telep�l�s: " + element.getElementsByTagName("telepules").item(0).getTextContent());
						System.out.println("Utca: " + element.getElementsByTagName("utca").item(0).getTextContent());
						System.out.println("H�zsz�m: " + element.getElementsByTagName("hsz").item(0).getTextContent());
					}
					System.out.println("Vend�g telefonsz�ma: " + element.getElementsByTagName("telefonszam").item(0).getTextContent());
					
				}
			}
			//Aktu�lis elem meghat�roz�sa
			nodelist = document.getElementsByTagName("alkalmazott");
			for(int i = 0;i< nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktu�lis elem: "+ node.getNodeName());
				//Alkalmazott adatainak ki�rat�sa
				if(node.getNodeType()== Node.ELEMENT_NODE) {
					Element element =(Element) node;
					System.out.println("Alkalmazott Szem�lyigazolv�ny sz�ma: " + element.getAttribute("alkalmazott_szigsz"));
					System.out.println("Sz�lloda sz�ma: " + element.getAttribute("ref_szalloda"));
					System.out.println("Alkalmazott kora: " + element.getElementsByTagName("kor").item(0).getTextContent());
					//Alkalmazotton bel�li sz�let�si adatok ki�rat�sa
					Node nodeszuletesdatum = nodelist.item(i);
					if (nodeszuletesdatum.getNodeType() == Node.ELEMENT_NODE) {
						Element elementcim = (Element) node;
						System.out.println("Sz�let�si id�: " + element.getElementsByTagName("ido").item(0).getTextContent());
						System.out.println(
								"Sz�let�si hely: " + element.getElementsByTagName("hely").item(0).getTextContent());
			
					}
				}
			}
			//Aktu�lis elem meghat�roz�sa
			nodelist = document.getElementsByTagName("vegzettsegek");
			for(int i = 0;i< nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktu�lis elem: "+ node.getNodeName());
				//Vegzetts�gek adatainak ki�rat�sa
				if(node.getNodeType()== Node.ELEMENT_NODE) {
					Element element =(Element) node;
					System.out.println("V�gzetts�ggel rendelkez� Szem�lyigazolv�ny sz�ma: " + element.getAttribute("ref_szigsz"));	
					System.out.println("V�gzetts�g: " + element.getElementsByTagName("vegzettseg").item(0).getTextContent());
				}
			}
			//Aktu�lis elem meghat�roz�sa
			nodelist = document.getElementsByTagName("dolgozik");
			for(int i = 0;i< nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				System.out.println("\nAktu�lis elem: "+ node.getNodeName());
				//Dolgozik adatainak ki�rat�sa
				if(node.getNodeType()== Node.ELEMENT_NODE) {
					Element element =(Element) node;
					System.out.println("Dolgoz�i Szem�lyigazolv�ny sz�m: " + element.getAttribute("ref_szigsz"));
					System.out.println("Dolgoz�i Sz�lloda sz�ma: " + element.getAttribute("ref_szalloda"));
					System.out.println("Munkav�gz�s id�tartama: " + element.getElementsByTagName("idotartam").item(0).getTextContent());
				}
			}

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

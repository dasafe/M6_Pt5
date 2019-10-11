package practica;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("personas.xml");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = dBuilder.parse(file);
			NodeList nList = doc.getElementsByTagName("Persona");
			System.out.println("Número de personas: " + nList.getLength());
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("\nNombre: " + eElement.getTextContent());
					System.out.println("Edad: " + eElement.getAttribute("edad"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

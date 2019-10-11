package practica;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GenerarXML {

	public static void main(String args[]) {

		FileInputStream entrada = null;
		DataInputStream fis = null;
		Document doc = null;

		try {
			entrada = new FileInputStream("myPeople.dat");
			fis = new DataInputStream(entrada);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();

			// Leemos el .dat y creamos la estructura del XML
			Element departamento = doc.createElement("Personas");
			doc.appendChild(departamento);
			Attr attr = doc.createAttribute("Nombre");
			while (true) {
				Element nombre = doc.createElement("Persona");
				Attr attrType = doc.createAttribute("edad");
				nombre.appendChild(doc.createTextNode(fis.readUTF()));
				departamento.appendChild(nombre);
				attrType.setValue(Integer.toString(fis.readInt()));
				nombre.setAttributeNode(attrType);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (EOFException e) {
			System.out.println("Fichero .dat leido con exito");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (entrada != null) {
					entrada.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		try {
			// Creamos el XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("personas.xml"));
			transformer.transform(source, result);
			System.out.println("XML creado con exito");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package practica;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GernerarDat {

	public static void main(String[] args) {
		ArrayList<Personas> personas = new ArrayList<Personas>();
		personas.add(new Personas("María López", 36));
		personas.add(new Personas("Gustavo Gómez", 1));
		personas.add(new Personas("Irene Salas", 36));
		personas.add(new Personas("Roberto Morgade", 63));
		personas.add(new Personas("Graciela Iglesias", 60));

		// Crea el archivo con los datos
		try {
			FileOutputStream archivo = new FileOutputStream("myPeople.dat");
			DataOutputStream fos = new DataOutputStream(archivo);
			for (Personas p : personas) {
				fos.writeUTF(p.getNomrbe());
				fos.writeInt(p.getEdad());
			}
			fos.flush();
			fos.close();
			System.out.println("Archivo creado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package practica;

import java.io.Serializable;

public class Personas implements Serializable {
	private String nomrbe;
	private int edad;

	public Personas(String nomrbe, int edad) {
		super();
		this.nomrbe = nomrbe;
		this.edad = edad;
	}

	public Personas() {

	}

	public String getNomrbe() {
		return nomrbe;
	}

	public void setNomrbe(String nomrbe) {
		this.nomrbe = nomrbe;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}

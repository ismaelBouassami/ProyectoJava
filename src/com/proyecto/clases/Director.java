package com.proyecto.clases;

import java.io.Serializable;

public class Director implements Serializable {

	/// ATRIBUTOS DIRECTOR ///
	private static int countIdDirector = 0;
	private int idDirector;
	private String nombreDirector;
	private String apellidoDirector;
	private int edadDirector;
	private boolean goyas;

	/// CONSTRUCTOR ///
	public Director(String nombreDirector, String apellidoDirector, int edadDirector, boolean goyas) {
		super();
		countIdDirector++;
		this.idDirector = countIdDirector; // ID AUTOINCREMENTADO
		this.nombreDirector = nombreDirector;
		this.apellidoDirector = apellidoDirector;
		this.edadDirector = edadDirector;
		this.goyas = goyas;
	}

	/// GETTERS Y SETTERS ///
	public int getIdDirector() {
		return idDirector;
	}

//	public void setIdDirector(int idDirector) {
//		this.idDirector = idDirector;
//	}

	public String getNombreDirector() {
		return nombreDirector;
	}

	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}

	public String getApellidoDirector() {
		return apellidoDirector;
	}

	public void setApellidoDirector(String apellidoDirector) {
		this.apellidoDirector = apellidoDirector;
	}

	public int getEdadDirector() {
		return edadDirector;
	}

	public void setEdadDirector(int edadDirector) {
		this.edadDirector = edadDirector;
	}

	public boolean isGoyas() {
		return goyas;
	}

	public void setGoyas(boolean goyas) {
		this.goyas = goyas;
	}

	@Override
	public String toString() {
		return "Id Director: " + idDirector + "\nNombre: " + nombreDirector + "\nApellido: " + apellidoDirector
				+ "\nEdad: " + edadDirector + "\nGoyas: " + goyas;
	}

}

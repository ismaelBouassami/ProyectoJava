package com.proyecto.clases;

import java.io.Serializable;

public class Actor implements Serializable {

	/// ATRIBUTOS ACTORES ///
	private static int countIdActor = 0;
	private int idActor;
	private String nombreActor;
	private String apellidoActor;
	private int edadActor;
	private String nacionalidadActor;

	/// CONSTRUCTOR ///
	public Actor(String nombreActor, String apellidoActor, int edadActor, String nacionalidadActor) {
		super();
		countIdActor++;
		this.idActor = countIdActor; // ID AUTOINCREMENTADO
		this.nombreActor = nombreActor;
		this.apellidoActor = apellidoActor;
		this.edadActor = edadActor;
		this.nacionalidadActor = nacionalidadActor;
	}

	/// GETTERS Y SETTERS ///
	public int getIdActor() {
		return idActor;
	}

//	public void setIdActor(int idActor) {
//		this.idActor = idActor;
//	}

	public String getNombreActor() {
		return nombreActor;
	}

	public void setNombreActor(String nombreActor) {
		this.nombreActor = nombreActor;
	}

	public String getApellidoActor() {
		return apellidoActor;
	}

	public void setApellidoActor(String apellidoActor) {
		this.apellidoActor = apellidoActor;
	}

	public int getEdadActor() {
		return edadActor;
	}

	public void setEdadActor(int edadActor) {
		this.edadActor = edadActor;
	}

	public String getNacionalidadActor() {
		return nacionalidadActor;
	}

	public void setNacionalidadActor(String nacionalidadActor) {
		this.nacionalidadActor = nacionalidadActor;
	}

	@Override
	public String toString() {
		return "Id Actor: " + idActor + "\nNombre: " + nombreActor + "\nApellidos: " + apellidoActor + "\nEdad: "
				+ edadActor + "\nNacionalidad: " + nacionalidadActor;
	}

}

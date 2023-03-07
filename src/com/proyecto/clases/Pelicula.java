package com.proyecto.clases;

import java.io.Serializable;

public class Pelicula implements Serializable {

	/// ATRIBUTOS PELICULAS ///
	private static int countIdPelicula = 0;
	private int idPelicula;
	private String nombrePelicula;
	private int duracion;
	private String anioEmision;
	private String genero;

	/// CONSTRUCTOR ///
	public Pelicula(String nombrePelicula, int duracion, String anioEmision, String genero) {
		super();
		countIdPelicula++;
		this.idPelicula = countIdPelicula; // ID AUTOINCREMENTADO
		this.nombrePelicula = nombrePelicula;
		this.duracion = duracion;
		this.anioEmision = anioEmision;
		this.genero = genero;
	}

	/// GETTERS Y SETTERS ///
	public int getIdPelicula() {
		return idPelicula;
	}

//	public static void setIdPelicula(int idPelicula) {
//		 Pelicula.idPelicula = idPelicula;
//	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public static int getCountIdPelicula() {
		return countIdPelicula;
	}

	public static void setCountIdPelicula(int countIdPelicula) {
		Pelicula.countIdPelicula = countIdPelicula;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getAnioEmision() {
		return anioEmision;
	}

	public void setAnioEmision(String anioEmision) {
		this.anioEmision = anioEmision;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return idPelicula + ".- " + nombrePelicula;
	}

}

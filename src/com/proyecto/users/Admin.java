package com.proyecto.users;

import java.util.List;

import com.proyecto.clases.Actor;
import com.proyecto.clases.Director;
import com.proyecto.clases.Pelicula;

public class Admin extends User {

	private List<Actor> actores;
	private List<Director> directores;
	private List<Pelicula> peliculas;

	/// CONSTRUCTOR ///
	public Admin(int id,String nombre, String apellidos, String contrasenia, String email, String poblacion, Rol rol,
			String fechaNacimiento, List<Actor> actores, List<Director> directores, List<Pelicula> peliculas) {
		super(id,nombre, apellidos, contrasenia, email, poblacion, rol, fechaNacimiento);
		this.actores = actores;
		this.directores = directores;
		this.peliculas = peliculas;
	}
	

	/// GETTERS Y SETTERS
	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

	public List<Director> getDirectores() {
		return directores;
	}

	public void setDirectores(List<Director> directores) {
		this.directores = directores;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public void visualizarClientes(Cliente idCliente) {

	}

	public void eliminarClientes(Cliente idCliente) {

	}

}

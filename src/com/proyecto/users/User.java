package com.proyecto.users;

import com.proyecto.clases.Director;
import com.proyecto.clases.Pelicula;

public class User {

	// ATRIBUTOS //
	protected static int countId = 0;
	protected int id;
	protected String nombre;
	protected String apellidos;
	protected String contrasenia;
	protected String email;
	protected String poblacion;
	protected String rol;
	protected String fechaNacimiento;

	/// CONTRUCTOR ///
	public User(String nombre, String apellidos, String contrasenia, String email, String poblacion, String rol,
			String fechaNacimiento) {

		super();
		countId++; // CONTADOR DEL ID PARA QUE SE AUTOINCREMENTE
		this.id = countId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasenia = contrasenia;
		this.email = email;
		this.poblacion = poblacion;
		this.rol = rol;
		this.fechaNacimiento = fechaNacimiento;
	}

	/// GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	// NO NECESITAMOS EL setId porque se autoincrementa solo
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/// FUNCIONES AÑADIR, VER LISTAS PERSONALES Y GLOBALES ///
	// LISTAS PERSONALES DE CADA USUARIO //
	public void addPeliculaListaPersonal(Pelicula idPeli) {

	}

	public void visualizarPeliculaListaPersonal(Pelicula idPeli) {

	}

	public void addDirectorListaPersonal(Director idDirector) {

	}

	public void visualizarDirectorListaPersonal(Director idDirector) {
	}

	public void addActorListaPersonal(Pelicula idPeli) {

	}

	public void visualizarActorListaPersonal(Pelicula idPeli) {

	}

	/// LISTAS GLOBALES ///
	public void addPeliculaListaGlobal(Pelicula idPeli) {

	}

	public void visualizarPeliculaListaGlobal(Pelicula idPeli) {

	}

	public void addDirectorListaGlobal(Director idDirector) {

	}

	public void visualizarDirectorListaGlobal(Director idDirector) {

	}

	public void addActorListaGlobal(Pelicula idPeli) {

	}

	public void visualizarActorListaGlobal(Pelicula idPeli) {

	}

	/// TOSTRING -> PARA MOSTRAR LA INFORMACION ///
	@Override
	public String toString() {
		return "Id: " + id + "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nContraseña: " + contrasenia
				+ "\nEmail: " + email + "\nPoblacion: " + poblacion + "\nRol: " + rol + "\nFecha Nacimiento: "
				+ fechaNacimiento;
	}

}

package com.proyecto.users;

import java.util.Date;

public class User {
	protected String nombre;
	protected String apellidos;
	protected String email;
	protected String contraseña;
	protected String poblacion;
	protected String rol;
	protected String fechaNacimiento;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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

	public User(String nombre, String apellidos, String email, String contraseña, String poblacion, String rol,
			String fechaNacimiento2) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contraseña = contraseña;
		this.poblacion = poblacion;
		this.rol = rol;
		this.fechaNacimiento = fechaNacimiento2;
	}

	public void crearLista() {

	}

	public void consultarLista() {

	}

	public void modificarLista() {

	}

	public void eliminarLista() {

	}
}

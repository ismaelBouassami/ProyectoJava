package com.proyecto.users;

import java.util.Date;

public class Admin extends User {
	
	private String rol;
	private String fechaAlta;

	
	
	
	
	
	public Admin(String nombre, String apellidos, String email, String contraseña, String poblacion, String rol,
			String fechaNacimiento2, String rol2, String fechaAlta) {
		super(nombre, apellidos, email, contraseña, poblacion, rol, fechaNacimiento2);
		rol = rol2;
		this.fechaAlta = fechaAlta;
	}

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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	

	public void crearLista() {

	}

	public void consultarLista() {

	}

	public void modificarLista() {

	}

	public void eliminarLista() {

	}

	public void consultarUsuarios() {

	}

	public void eliminarUsuarios() {

	}
}

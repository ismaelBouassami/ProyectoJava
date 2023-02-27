package com.proyecto.users;

import java.util.Date;

public class Admin extends User {
	private String nombre;
	private String apellidos;
	private String email;
	private String contraseña;
	private String rol;
	private Date fechaAlta;

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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Admin(String nombre, String apellidos, String email, String contraseña, String poblacion, String rol,
			Date fechaNacimiento, String nombre2, String apellidos2, String email2, String contraseña2, String rol2,
			Date fechaAlta) {
		super(nombre, apellidos, email, contraseña, poblacion, rol, fechaNacimiento);
		nombre = nombre2;
		apellidos = apellidos2;
		email = email2;
		contraseña = contraseña2;
		rol = rol2;
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

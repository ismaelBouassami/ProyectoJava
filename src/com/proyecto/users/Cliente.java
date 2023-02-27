package com.proyecto.users;

import java.util.Date;

public class Cliente extends User {

	private String nombre;
	private String apellidos;
	private String email;
	private String contraseña;
	private String poblacion;
	private String rol;
	private Date fechaNacimiento;
	private int id;

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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente(String nombre, String apellidos, String email, String contraseña, String poblacion, String rol,
			Date fechaNacimiento, String nombre2, String apellidos2, String email2, String contraseña2,
			String poblacion2, String rol2, Date fechaNacimiento2, int id) {
		super(nombre, apellidos, email, contraseña, poblacion, rol, fechaNacimiento);
		nombre = nombre2;
		apellidos = apellidos2;
		email = email2;
		contraseña = contraseña2;
		poblacion = poblacion2;
		rol = rol2;
		fechaNacimiento = fechaNacimiento2;
		this.id = id;
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

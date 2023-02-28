package com.proyecto.users;

import java.util.Date;

public class Cliente extends User {
	private int id=0;

	
	
	
	
	
	
	//pendiente de arreglar id

	public Cliente(String nombre, String apellidos, String email, String contraseña, String poblacion, String rol,
			String fechaNacimiento,int id) {
		super(nombre, apellidos, email, contraseña, poblacion, rol, fechaNacimiento);
		
		
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


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", contraseña=" + contraseña + ", poblacion=" + poblacion + ", rol=" + rol + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	
}

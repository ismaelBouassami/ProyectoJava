package com.proyecto.utils;

import java.util.Scanner;

import com.proyecto.users.Cliente;
import com.proyecto.users.User;

public class Funciones {
	static Scanner leer = new Scanner(System.in);

	// REGISTRO USUARIO //
	public static void registrarUsuario() {
		int conId=1;
		System.out.println("Introduce tu nombre de usuario");
		String usuario = ControlErrores.validarString();

		System.out.println("Introduce los apellidos");
		String apellidos = ControlErrores.validarString();
		
		System.out.println("Introduce tu email");
		String email = ControlErrores.validarEmail();
		
		
		System.out.println("Introduce tu poblacion¨: ");
		String poblacion = ControlErrores.validarString();
		System.out.println("Introduce tu fecha de nacimiento: ");
		String fecha = ControlErrores.validarString();
		
		// pedir contraseña
		String contraseña = ControlErrores.pedirContraseña();
		
		//registro finish
		System.out.println("Registro completado");
		
		Cliente N1= new Cliente(usuario, apellidos, email, contraseña, poblacion, "ROL_USUARIO",fecha, conId);
		conId++;
		System.out.println(N1.toString());
	}

	// LOGIN USUARIO //

	// ELIMINAR USUARIO //

	// ETC ETC //

}

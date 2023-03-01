package com.proyecto.main;

import com.proyecto.utils.ControlErrores;
import com.proyecto.utils.Funciones;

public class Main {

	public static void main(String[] args) {

		// MENU PRINCIPAL //
		System.out.println(
				"¿Que desea hacer? \n-> Para registrar un usuario pulse 1 \n-> Para loguear un usuario pulse 2 \n-> Pulse -1 para salir.");
		int n = ControlErrores.validarInt();

		switch (n) {
		case 1:
			///// AQUI IRA LA FUNCION DE registrarUser() ///////////
			System.out.println("Registro");
			System.out.println("Para hacer posible el registro de usuario deberas de proporcionarnos ciertos datos");
			
			Funciones.registrarUsuario();
			break;
		case 2:
			///// AQUI IRA LA FUNCION DE loginUser() ///////////
			System.out.println("Login");
			break;
		default:
			System.out.println("Salir"); // PARA SALIR INTRODUCIR -1
		}

	}
}

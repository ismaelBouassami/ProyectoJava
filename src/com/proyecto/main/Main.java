package com.proyecto.main;

import com.proyecto.utils.ControlErrores;

public class Main {

	public static void main(String[] args) {

		// MENU PRINCIPAL //
		System.out.println(
				"¿Que desea hacer? -> Para registrar un usuario pulse 1 | Para loguear un usuario pulse 2 | Pulse -1 para salir.");
		int n = ControlErrores.validarInt();

		switch (n) {
		case 1:
			///// AQUI IRA LA FUNCION DE registrarUser() ///////////
			System.out.println("Registro");
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

package com.proyecto.utils;

import java.util.Scanner;

public class ControlErrores {

	// VALIDAR UN INTEGER //
	public static int validarInt() {
		int n = 0;
		boolean correcto = false;
		Scanner entrada = new Scanner(System.in);

		do {
			if (!entrada.hasNextInt()) {
				System.out.println("Error: No has introducido un numero.");
				entrada.nextLine();
			} else {
				n = entrada.nextInt();
				if (n == -1 || n == 1 || n == 2) {
					correcto = true;
				} else {
					System.out.println("Error: El numero introducido debe ser : 1, 2  o -1.");
					entrada.nextLine();
				}
			}
		} while (!correcto);

		return n;
	}

	// VALIDAR UN FLOAT //

	// VALIDAR UN STRING //

	// VALIDAR PASSWORD //
	public static String pedirContraseña() {
		Scanner entrada = new Scanner(System.in);
		String password = "", passwordRep = "";
		boolean verdad = false;

		do {
			System.out.println("Introduce la nueva contraseña:");
			password = entrada.nextLine().trim().replace("\t", " ").replace(" ", "");

			if (password.equals("")) {
				System.out.println("La contraseña no puede estar vacia.");

			} else if (password.length() < 5 || password.length() > 8) {
				System.out.println("La contraseña debe ser minimo de 5 caracteres y maximo de 8.");
			} else {
				System.out.println("Repite la contraseña: ");
				passwordRep = entrada.nextLine().trim().replace("\t", " ").replace(" ", "");
				if (password.equals(passwordRep)) {
					verdad = true;
				} else {
					System.out.println("Error: No ha introducido la misma contraseña. Vuelva a introducirla.");
				}
			}
		} while (!verdad);

		return password;
	}

	// VALIDAR UN FILE //

	// ETC ETC //
}

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
	
	
	// VALIDAR UN FILE //
	
	
	// ETC ETC //
}

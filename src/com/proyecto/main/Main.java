package com.proyecto.main;

import com.proyecto.edu.MostrarNombre;
import com.proyecto.joseluis.MostraNom;

public class Main {

	public static void main(String[] args) {
		
		// Joselu
		MostraNom nom1 = new MostraNom();
		nom1.mostrar();
		// Edu
		MostrarNombre alumno2 = new MostrarNombre();
		System.out.println(alumno2.toString());
	}

}

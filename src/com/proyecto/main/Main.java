package com.proyecto.main;

import com.proyecto.joseluis.MostrarNombreJoselu;
import com.proyecto.edu.MostrarNombreEdu;


public class Main {

	public static void main(String[] args) {
		
		// Joselu
		MostrarNombreJoselu alumno1 = new MostrarNombreJoselu();
		System.out.println(alumno1.toString());
		// Edu
		MostrarNombreEdu alumno2 = new MostrarNombreEdu();
		System.out.println(alumno2.toString());
	}

}

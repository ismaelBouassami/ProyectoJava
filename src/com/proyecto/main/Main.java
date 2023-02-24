package com.proyecto.main;

import com.proyecto.joseluis.MostrarNombreJoselu;
import com.proyecto.Ismael.MostrarNombreIsma;
import com.proyecto.edu.MostrarNombreEdu;


public class Main {

	public static void main(String[] args) {
		
		// Joselu
		MostrarNombreJoselu alumno1 = new MostrarNombreJoselu();
		System.out.println(alumno1.toString());
		System.out.println("prueba nueva en rama");
		// Edu
		MostrarNombreEdu alumno2 = new MostrarNombreEdu();
		System.out.println(alumno2.toString());
		
		MostrarNombreIsma alumno3 = new MostrarNombreIsma();
		System.out.println(alumno3.toString());
	}

}

package com.proyecto.main;

import com.proyecto.joseluis.MostrarNombreJoselu;
import com.proyecto.Ismael.MostrarNombreIsma;
import com.proyecto.edu.MostrarNombreEdu;
import com.proyecto.hrisi.MostrarnombreHrisi;
import com.proyecto.javier.MostrarNombreJavier;


public class Main {

	public static void main(String[] args) {
		
		// Joselu
		MostrarNombreJoselu alumno1 = new MostrarNombreJoselu();
		System.out.println(alumno1.toString());
		// Edu
		MostrarNombreEdu alumno2 = new MostrarNombreEdu();
		System.out.println(alumno2.toString());
		// Ismael
		MostrarNombreIsma alumno3 = new MostrarNombreIsma();
		System.out.println(alumno3.toString());
		// Hrisi
		MostrarnombreHrisi alumno4 = new MostrarnombreHrisi();
		System.out.println(alumno4.toString());
		// Javier
		MostrarNombreJavier alumno5 = new MostrarNombreJavier();
		System.out.println(alumno5.toString());
		
	}
}

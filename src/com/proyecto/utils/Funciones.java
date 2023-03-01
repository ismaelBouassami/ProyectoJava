package com.proyecto.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.proyecto.users.Cliente;

public class Funciones {
	static Scanner leer = new Scanner(System.in);

	// Fuera del metodo para no reinicializar
	public static  int conId = 1;

	
	
	// REGISTRO USUARIO //
	public static void registrarUsuario() {
		System.out.println("Introduce tu nombre de usuario:");
		String usuario = ControlErrores.validarString();

		System.out.println("Introduce los apellidos:");
		String apellidos = ControlErrores.validarString();

		System.out.println("Introduce tu email:");
		String email = ControlErrores.validarEmail();

		System.out.println("Introduce tu poblacion:");
		String poblacion = ControlErrores.validarString();

		System.out.println("Introduce tu fecha de nacimiento:");
		String fecha = ControlErrores.validarString();

		// pedir contraseña
		String contraseña = ControlErrores.pedirContraseña();

		// Usuarios registrados con rol
		String rol = "ROL_USUARI";

		// registro finish
		System.out.println("Registro completado");

		// Array List (Actor, Director, Peliculas) como null, para guardar solo la
		// información de los usuarios
		Cliente N1 = new Cliente(usuario, apellidos, contraseña, email, poblacion, rol, fecha, null, null, null);
		
		
		
		try {
			  int numeroId=0;
			 numeroId=
			ultimoNumero("src/com/proyecto/utils/idUser.txt");
			//Con este metodo podremos ver cual fue el ultimo id utilizado, ahora simplemente debemos aumentar 1 en el id para el siguiente use
			conId=numeroId+1;
			retornarId(conId, "src/com/proyecto/utils/idUser.txt");
		} catch (Exception e) {
			System.out.println("No se ha podido crear tu id");
		}
		System.out.println(N1.toString());
		// Pasamos los parametros del objeto a la funcíon guardar usuarios
		guardarUsuario(conId, usuario, apellidos, email, contraseña, poblacion, rol, fecha);
		
	}
	//Crear archivo id
	public static void retornarId(int numero, String rutaArchivo) throws IOException {
        // Crear un objeto File para el archivo en la ruta especificada
        File archivo = new File(rutaArchivo);
        // Crear un objeto Scanner para leer el archivo
        Scanner scanner = new Scanner(archivo);


        boolean estaVacio = !scanner.hasNext();

        // Verificar si el número ya existe en el archivo
        boolean existeNumero = false;
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num == numero) {
                existeNumero = true;
                break;
            }
        }

        // Si el número no existe en el archivo, agregarlo al final
        if (!existeNumero) {
            // Crear un objeto FileWriter con la opción de agregar al final del archivo
            FileWriter writer = new FileWriter(archivo,!estaVacio);
            
            writer.write(" "+numero + " ");
         
            writer.close();
        }

       
        scanner.close();
    }
	//Ultimo num id
	  public static int ultimoNumero(String rutaArchivo) throws IOException {
	        // Crear un objeto File para el archivo en la ruta especificada
	        File archivo = new File(rutaArchivo);
	        
	        Scanner scanner = new Scanner(archivo);

	        int ultimo = 0;
	        while (scanner.hasNextInt()) {
	            ultimo = scanner.nextInt();
	        }

	     
	        scanner.close();

	        return ultimo;
	    }
	// GUARDAR USUARIOS EN FICHERO TXT
	public static void guardarUsuario(int conID, String nombre, String apellidos, String email, String contraseña,
			String poblacion, String rol, String fecha) {
		try {
			File file = new File("src/com/proyecto/utils/usersGuardados.txt");
			
			PrintWriter escriureUser = new PrintWriter(new FileWriter(file, true));

			// Escribir los datos del usuario en un formato fijo
			String datos = String.format("%-3d|%-18s|%-18s|%-30s|%-18s|%-13s|%-12s|%-14s", conID, nombre, apellidos,
					email, contraseña, poblacion, rol, fecha);

			// Comprobar  si el archivo está vacío para escribir el encabezado
			if (file.length() == 0) {
				escriureUser.println(
						"ID | Nombre           | Apellidos        | Email                        | Contraseña       | Población   | Rol        | Fecha        ");
				escriureUser.println(
						"---+------------------+------------------+------------------------------+------------------+-------------+------------+--------------");
			}

			// Escribir los datos del usuario en el archivo
			escriureUser.println(datos);
			escriureUser.close();

			System.out.println("\nUsuario guardado correctamente.");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	// LOGIN USUARIO //

	// ELIMINAR USUARIO //

	// ETC ETC //
	public static int getConId() {
		return conId;
	}
	public static void setConId(int conId) {
		Funciones.conId = conId;
	}
	
}

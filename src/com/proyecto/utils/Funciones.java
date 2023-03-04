package com.proyecto.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.proyecto.users.Cliente;

public class Funciones {
	static Scanner leer = new Scanner(System.in);

	// Fuera del metodo para no reinicializar
	public static int conId = 1;
	public static int finalId = 1;

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

		// Con este metodo podremos ver cual fue el ultimo id utilizado, ahora
		// simplemente debemos aumentar 1 en el id para el siguiente use
		try {

			int numeroId = 0;
			numeroId = ultimoNumero("src/com/proyecto/utils/idUser.txt");

			conId = numeroId + 1;
			finalId = conId;
			retornarId(conId, "src/com/proyecto/utils/idUser.txt");
		} catch (Exception e) {
			System.out.println("No se ha podido crear tu id");
		}

		// Array List (Actor, Director, Peliculas) como null, para guardar solo la
		// información de los usuarios
		Cliente N1 = new Cliente(finalId, usuario, apellidos, contraseña, email, poblacion, rol, fecha, null, null,
				null);
		System.out.println("\n" + N1.toString());

		// Pasamos los parametros del objeto a la funcíon guardar usuarios
		guardarUsuario(finalId, usuario, apellidos, email, contraseña, poblacion, rol, fecha);

		crearCarpeta(finalId, email);

	}

	public static void crearCarpeta(int id, String email) {
		String nombreCarpeta = "";
		int posFinal = email.lastIndexOf("@");
		// String emailComproba=email;
		email = email.substring(0, posFinal);

		nombreCarpeta = "" + id + email;

		try {
			File NuevaCarpeta = new File("src/com/proyecto/usuariosCarpetas/" + nombreCarpeta);
			boolean creado = NuevaCarpeta.mkdir();
			if (creado == true) {
				File listACtor = new File("src/com/proyecto/usuariosCarpetas/" + nombreCarpeta + "/actor.llista");
				File listDirector = new File("src/com/proyecto/usuariosCarpetas/" + nombreCarpeta + "/director.llista");
				File listPelicula = new File("src/com/proyecto/usuariosCarpetas/" + nombreCarpeta + "/pelicula.llista");

				listACtor.createNewFile();
				listDirector.createNewFile();
				listPelicula.createNewFile();

				System.out.println("Se ha creado correctamente");
			} else {
				System.out.println("No se ha podido crear(quizas el usuario ya existe)");
				System.out.println("Vuelve a registrar tu usuario ");
				Funciones.registrarUsuario();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	// Crear archivo id
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
			FileWriter writer = new FileWriter(archivo, !estaVacio);

			writer.write(" " + numero + " ");
			writer.close();
		}
		scanner.close();
	}

	// Ultimo num id
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
	public static void guardarUsuario(int ID, String nombre, String apellidos, String email, String contraseña,
			String poblacion, String rol, String fecha) {
		try {
			File file = new File("src/com/proyecto/utils/usersGuardados.txt");
			PrintWriter escriureUser = new PrintWriter(new FileWriter(file, true));

			// Escribir los datos del usuario en un formato fijo
			String datos = String.format("%03d|%-18s|%-18s|%-30s|%-18s|%-13s|%-12s|%-14s", ID, nombre, apellidos, email,
					contraseña, poblacion, rol, fecha);

			// Comprobar si el archivo está vacío para escribir el encabezado
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
	public static boolean validaUsuario() {

		try {
			File f=new File("src/com/proyecto/utils/usersGuardados.txt");
			FileReader fr= new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			System.out.println("Introduce el nombre de usuario: ");
			String usr = ControlErrores.validarString();
			
			System.out.println("Introduce la contraseña: ");
			String pwd = ControlErrores.validarString();
			
			String linia=br.readLine(); linia=br.readLine();
			boolean trobat=false;
			boolean login=false;
			while((linia=br.readLine())!=null && !trobat) {
				String[] dades=linia.split("[|]");
				dades[1]=dades[1].trim();
				dades[4]=dades[4].trim();
				if(dades[1].equals(usr)) {
					trobat=true;
					if(dades[4].equals(pwd)) {
						System.out.println("Login satisfactorio para el usuario "+usr);
						login=true;
					}else {
						trobat=true;
						System.out.println("ERROR. Contraseña errónea para el usuario "+usr);
					}
				}
			}
			br.close();
			return login;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	// ELIMINAR USUARIO //

	// ETC ETC //

}

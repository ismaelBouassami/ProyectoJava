package com.proyecto.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.proyecto.clases.Actor;
import com.proyecto.clases.Director;
import com.proyecto.clases.Pelicula;
import com.proyecto.users.Cliente;
import com.proyecto.users.User;
import com.proyecto.users.User.Rol;

public class Funciones {
	static Scanner leer = new Scanner(System.in);

	// Fuera del metodo para no reinicializar
	public static int conId = 1;
	public static int finalId = 1;

	// Varible nombre usuario
	public static String nomUser = "";
	public static String userCarpeta = "";

	// Variable para crear listas personales
	public static String nomUserFinal;

	// Listas generales
	public static ArrayList<Pelicula> PelisGeneral = new ArrayList<Pelicula>();
	public static ArrayList<Director> DirectorGeneral = new ArrayList<Director>();
	public static ArrayList<Actor> ActorGeneral = new ArrayList<Actor>();

	// Listas personales
	public static ArrayList<Pelicula> PelisPersonal = new ArrayList<Pelicula>();
	public static ArrayList<Director> DirectorPersonal = new ArrayList<Director>();
	public static ArrayList<Actor> ActorPersonal = new ArrayList<Actor>();

	// REGISTRO USUARIO //
	public static void registrarUsuario() {
		System.out.println("Introduce tu nombre:");
		String usuario = ControlErrores.validarString();

		System.out.println("Introduce los apellidos:");
		String apellidos = ControlErrores.validarString();

		System.out.println("Introduce tu email:");
		String email = ControlErrores.validarEmail();

		System.out.println("Introduce tu poblacion:");
		String poblacion = ControlErrores.validarString();

		System.out.println("Introduce tu fecha de nacimiento (dd/mm/aaaa):");
		String fecha = ControlErrores.validarFecha();

		// pedir contraseña
		String contraseña = ControlErrores.pedirContraseña();

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

		// Creamos el usuario con la funcion
		nomUser = obtenerNomUser(finalId, email);

		// Array List (Actor, Director, Peliculas) como null, para guardar solo la
		// información de los usuarios
		Cliente N1 = new Cliente(finalId, usuario, apellidos, contraseña, email, poblacion, User.Rol.USUARIO, fecha,
				null, null, null);

		// Mostramos los datos del cliente y su numro de usuario
		System.out.println("\n" + N1.toString());
		System.out.println("Tu nombre de usuario es: " + nomUser);

		// Pasamos los parametros del objeto a la funcíon guardar usuarios
		guardarUsuario(nomUser, finalId, usuario, apellidos, email, contraseña, poblacion, User.Rol.USUARIO, fecha);
		// Pasamos el parametro usuario para crear carpeta
		crearCarpeta(nomUser);

	}

	// OBTENER NOMBRE USUARIO //
	public static String obtenerNomUser(int id, String email) {
		int posFinal = email.lastIndexOf("@");
		email = email.substring(0, posFinal);
		return nomUser = "" + id + email;
	}

	// CREAR CARPETA USUARIO Y LISTAS //
	public static String crearCarpeta(String nomUser) {

		try {
			File NuevaCarpeta = new File("src/com/proyecto/usuariosCarpetas/" + nomUser);
			boolean creado = NuevaCarpeta.mkdir();
			if (creado == true) {
				File listACtor = new File("src/com/proyecto/usuariosCarpetas/" + nomUser + "/actor.llista");
				File listDirector = new File("src/com/proyecto/usuariosCarpetas/" + nomUser + "/director.llista");
				File listPelicula = new File("src/com/proyecto/usuariosCarpetas/" + nomUser + "/pelicula.llista");

				listACtor.createNewFile();
				listDirector.createNewFile();
				listPelicula.createNewFile();

				//System.out.println("El usuario se ha creado correctamente");
			} else {
				System.out.println("No se ha podido crear el usuario (quizas el usuario ya existe)");
				System.out.println("Vuelve a registrar tu usuario: ");
				Funciones.registrarUsuario();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return nomUser;
	}// ---------------------------------------------------------------------------------------------------------------

	// CREAR ARCHIVO ID //
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

	// OBTENER NUMERO ID //
	public static int ultimoNumero(String rutaArchivo) {
		// Crear un objeto File para el archivo en la ruta especificada
		int ultimo = 0;
		try {
			File archivo = new File(rutaArchivo);
			Scanner scanner = new Scanner(archivo);

			while (scanner.hasNextInt()) {
				ultimo = scanner.nextInt();
			}
			scanner.close();

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return ultimo;

	}// ---------------------------------------------------------------------------------------------------------------

	// GUARDAR USUARIOS EN FICHERO TXT
	public static void guardarUsuario(String nomUser, int ID, String nombre, String apellidos, String email,
			String contraseña, String poblacion, Rol rol, String fecha) {
		try {
			File file = new File("src/com/proyecto/utils/usersGuardados.txt");
			PrintWriter escriureUser = new PrintWriter(new FileWriter(file, true));

			// Escribir los datos del usuario en un formato fijo
			String datos = String.format("%-17s|%03d|%-18s|%-18s|%-30s|%-18s|%-13s|%-12s|%-14s", nomUser, ID, nombre,
					apellidos, email, contraseña, poblacion, rol, fecha);

			// Comprobar si el archivo está vacío para escribir el encabezado
			if (file.length() == 0) {
				escriureUser.println(
						"USUARIO          |ID | Nombre           | Apellidos        | Email                        | Contraseña       | Población   | Rol        | Fecha        ");
				escriureUser.println(
						"-----------------+---+------------------+------------------+------------------------------+------------------+-------------+------------+--------------");
			}

			// Escribir los datos del usuario en el archivo
			escriureUser.println(datos);
			escriureUser.close();

			System.out.println("\nUsuario guardado correctamente" + " \u2714" + "\n");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}// ---------------------------------------------------------------------------------------------------------------

	// LOGIN USUARIO //
	public static boolean validaUsuario() {
		try {
			File f = new File("src/com/proyecto/utils/usersGuardados.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			System.out.println("Introduce el nombre de usuario: ");
			String usr = ControlErrores.validarString();
			devolverNombreUser(usr);

			System.out.println("Introduce la contraseña: ");
			String pwd = ControlErrores.validarString();

			String linia = br.readLine();
			linia = br.readLine();
			boolean trobat = false;
			boolean login = false;
			while ((linia = br.readLine()) != null && !trobat) {
				String[] dades = linia.split("[|]");
				dades[0] = dades[0].trim();
				dades[5] = dades[5].trim();
				if (dades[0].equals(usr)) {
					trobat = true;
					if (dades[5].equals(pwd)) {
						System.out.println("\nHola " + usr + ", has iniciado sesion " + "\u2714");
						// missatge benvinguda, nom apellido
						System.out.println(nomUser);
						login = true;
					} else {
						trobat = true;
						System.out.println("ERROR. Contraseña errónea para el usuario " + usr);
					}
				}
			}
			if (!trobat) {
				System.out.println("ERROR. No se encontró un usuario con el nombre: " + usr);
			}
			br.close();
			return login;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// GUARDAR EL USUARIO PARA LISTAS PERSONALES
	public static String devolverNombreUser(String usr) {
		return nomUserFinal = usr;
	}

	// PEDIR Y GUARDAR DATOS LISTAS GENERALES
	// ---------------------------------------------------------------------------------------------------------------

	// PEDIR DATOS LISTA PELICULA GENERAL
	public static void pedirListaGeneralPelicula() {
		System.out.println("Introduce el nombre de la pelcula:");
		String pelicula = ControlErrores.validarString();

		System.out.println("Introduce la duración:");
		int duracio = ControlErrores.validarInt();

		System.out.println("Introduce la fecha de emision:");
		String fechaEmisio = ControlErrores.validarString();

		System.out.println("Introduce el genero:");
		String genero = ControlErrores.validarString();

		registrarListaGeneralPelicula(pelicula, duracio, fechaEmisio, genero);
		System.out.println("Se ha guardado correctamente " + "\u2714");
	}

	// GUARDAR DATOS PELICULA GENERAL
	public static void registrarListaGeneralPelicula(String pelicula, int duracio, String fechaEmisio, String genero) {
		Pelicula.setCountIdPelicula(PelisGeneral.size());
		Pelicula peliculasCreadas = new Pelicula(pelicula, duracio, fechaEmisio, genero);
		System.out.println(PelisGeneral.size());
		PelisGeneral.add(peliculasCreadas);

		// serialització
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			// obrim el fitxer per escriure, sense afegir
			// només tindrem un ArrayList d'objectes

			// Guardar antes de crear el usuario la longitud del arrayList
//			Pelicula.setCountIdPelicula(PelisGeneral.size
			System.out.println("Va a guardar con variable: " + PelisGeneral.size());

			fout = new FileOutputStream("src/com/proyecto/listasPeliculas/peliculas.llista", false);
			oos = new ObjectOutputStream(fout);
			// escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(PelisGeneral);
			oos.flush();
			oos.close();

			System.out.println(PelisGeneral.size());

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}// ---------------------------------------------------------------------------------------------------------------

	// PEDIR DATOS LISTA ACTOR GENERAL
	public static void pedirListaGeneralActor() {
		System.out.println("Introduce el nombre del actor:");
		String nom = ControlErrores.validarString();

		System.out.println("Introduce los apellidos del actor:");
		String apellidos = ControlErrores.validarString();

		System.out.println("Introduce la edad del actor:");
		int edad = ControlErrores.validarInt();

		System.out.println("Introduce la nacionalidad del actor:");
		String nacionalidad = ControlErrores.validarString();

		registrarListaGeneralActor(nom, edad, apellidos, nacionalidad);
		System.out.println("Se ha guardado correctamente " + "\u2714");
	}

	// GUARDAR DATOS LISTA ACTOR GENERAL
	public static void registrarListaGeneralActor(String pelicula, int duracio, String fechaEmisio, String genero) {
		Pelicula peliculasCreadas = new Pelicula(pelicula, duracio, fechaEmisio, genero);
		System.out.println(ActorGeneral.size());
		PelisGeneral.add(peliculasCreadas);

		// serialització
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			// obrim el fitxer per escriure, sense afegir
			// només tindrem un ArrayList d'objectes

			// Guardar antes de crear el usuario la longitud del arrayList
			Pelicula.setCountIdPelicula(PelisGeneral.size());

			fout = new FileOutputStream("src/com/proyecto/listasPeliculas/actores.llista", false);
			oos = new ObjectOutputStream(fout);
			// escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(ActorGeneral);
			oos.flush();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}// ---------------------------------------------------------------------------------------------------------------

	// PEDIR DATOS LISTA DIRECTOR GENERAL
	public static void pedirListaGeneralDirector() {
		System.out.println("Introduce el nombre del director:");
		String nom = ControlErrores.validarString();

		System.out.println("Introduce los apellidos del director:");
		String apellidos = ControlErrores.validarString();

		System.out.println("Introduce la edad del director:");
		int edad = ControlErrores.validarInt();

		System.out.println("Introduce los goyas del director:");
		String goyas = ControlErrores.validarString();

		registrarListaGeneralDirector(nom, edad, apellidos, goyas);
		System.out.println("Se ha guardado correctamente " + "\u2714");
	}

	// GUARDAR DATOS LISTA DIRECTOR GENERAL
	public static void registrarListaGeneralDirector(String pelicula, int duracio, String fechaEmisio, String genero) {
		Pelicula peliculasCreadas = new Pelicula(pelicula, duracio, fechaEmisio, genero);
		System.out.println(DirectorGeneral.size());
		PelisGeneral.add(peliculasCreadas);

		// serialització
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			// obrim el fitxer per escriure, sense afegir
			// només tindrem un ArrayList d'objectes

			// Guardar antes de crear el usuario la longitud del arrayList
			Pelicula.setCountIdPelicula(PelisGeneral.size());

			fout = new FileOutputStream("src/com/proyecto/listasPeliculas/directores.llista", false);
			oos = new ObjectOutputStream(fout);
			// escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(DirectorGeneral);
			oos.flush();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	// MOSTRAR LISTAS GENERALES
	// ---------------------------------------------------------------------------------------------------------------

	// MOSTRAR DATOS LISTA ACTOR GENERAL
	public static void mostrarListaGeneralPelicula() {
		File vacio = new File("src/com/proyecto/listasPeliculas/peliculas.llista");
		if (vacio.length() < 0 || vacio.length() == 0) {
			System.out.println("No hay nada que mostrar");
		} else {

			try {
				// obrim fitxer per a lectura
				FileInputStream file = new FileInputStream("src/com/proyecto/listasPeliculas/peliculas.llista");
				ObjectInputStream reader = new ObjectInputStream(file);
				try {
					// llegim l'objecte que hi ha al fitxer (1 sol array List)
					PelisGeneral = (ArrayList<Pelicula>) reader.readObject();
					System.out.println("La lista general de pelicules es");
					for (Pelicula peli : PelisGeneral) {
						System.out.println(peli.toString());
						System.out.println();
					}
				} catch (Exception ex) {
					System.err.println("Se ha mostrado correctamente");
				}

				reader.close();
				file.close();
			} catch (Exception ex) {
				System.err.println("Error en llegir peliculas.llista " + ex);
			}
		}
	}

	// MOSTRAR LISTA GENERAL ACTOR
	public static void mostrarListaGeneralActor() {
		File vacio = new File("src/com/proyecto/listasPeliculas/actores.llista");
		if (vacio.length() < 0 || vacio.length() == 0) {
			System.out.println("No hay nada que mostrar");
		} else {
			try {
				// obrim fitxer per a lectura
				FileInputStream file = new FileInputStream("src/com/proyecto/listasPeliculas/actores.llista");
				ObjectInputStream reader = new ObjectInputStream(file);
				try {
					// llegim l'objecte que hi ha al fitxer (1 sol array List)
					ActorGeneral = (ArrayList<Actor>) reader.readObject();
					System.out.println("La lista general de pelicules es");
					for (Actor actor : ActorGeneral) {
						System.out.println(actor.toString());
						System.out.println();
					}
				} catch (Exception ex) {
					System.err.println("Se ha mostrado correctamente");
				}

				reader.close();
				file.close();
			} catch (Exception ex) {
				System.err.println("Error en llegir actores.llista " + ex);
			}

		}
	}

	// MOSTRAR LISTA GENERAL DIRECTOR
	public static void mostrarListaGeneralDirector() {
		File vacio = new File("src/com/proyecto/listasPeliculas/directores.llista");
		if (vacio.length() < 0 || vacio.length() == 0) {
			System.out.println("No hay nada que mostrar");
		} else {
			try {
				// obrim fitxer per a lectura
				FileInputStream file = new FileInputStream("src/com/proyecto/listasPeliculas/directores.llista");
				ObjectInputStream reader = new ObjectInputStream(file);
				try {
					// llegim l'objecte que hi ha al fitxer (1 sol array List)
					DirectorGeneral = (ArrayList<Director>) reader.readObject();
					System.out.println("La lista general de pelicules es");
					for (Director director : DirectorGeneral) {
						System.out.println(director.toString());
						System.out.println();
					}
				} catch (Exception ex) {
					System.err.println("Se ha mostrado correctamente");
				}

				reader.close();
				file.close();
			} catch (Exception ex) {
				System.err.println("Error en llegir directores.llista " + ex);
			}
		}
	}

	// PEDIR Y GUARDAR DATOS LISTAS PERSONALES
	// ---------------------------------------------------------------------------------------------------------------

	// PEDIR DATO A GUARDAR LISTA PELICULA PERSONAL
	public static void pedirListaPersonalPelicula() {
		File vacio = new File("src/com/proyecto/listasPeliculas/peliculas.llista");
		if (vacio.length() < 0 || vacio.length() == 0) {
			System.out.println("No puedes añadir nada ya que la lista general esta vacia");
		} else {
			System.out.println("Introduce el numero de la pelicula que quieres coger:");
			for (Pelicula i : PelisGeneral) {
				System.out.println(i.toString());
			}
			int numPeliACopiar = ControlErrores.validarInt();

			if (numPeliACopiar > PelisGeneral.size()) {
				System.out.println("El numero que has puesto no esta en la lista");
			} else {
				Pelicula personal = PelisGeneral.get(numPeliACopiar - 1);
//			Pelicula.setCountIdPelicula(PelisPersonal.size() + 1);
//			System.out.println("pelispersonal id =" + PelisPersonal.size());
				PelisPersonal.add(personal);
				registrarListaPersonalPelicula();
			}
		}
	}

	// GUARDAR DATOS PELICULA LISTA PERSONAL
	public static void registrarListaPersonalPelicula() {
		// serialització
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			// obrim el fitxer per escriure, sense afegir
			// només tindrem un ArrayList d'objectes

			// Guardar antes de crear el usuario la longitud del arrayList
			Pelicula.setCountIdPelicula(PelisPersonal.size());
//			System.out.println("-"+getNomUser()+"-"+nomUser+"-"+userCarpeta+"-"+getUserCarpeta());

			fout = new FileOutputStream("src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/pelicula.llista",
					false);
			oos = new ObjectOutputStream(fout);
			// escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(PelisPersonal);
			oos.flush();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	// PEDIR DATO A GUARDAR LISTA ACTOR PERSONAL
	public static void pedirListaPersonalActor() {

		File vacio = new File("src/com/proyecto/listasPeliculas/actores.llista");
		if (vacio.length() < 0 || vacio.length() == 0) {
			System.out.println("No puedes añadir nada ya que la lista general esta vacia");
		} else {
			System.out.println("Introduce el numero del Actor/a que quieres coger:");
			for (Actor i : ActorGeneral) {
				System.out.println(i.toString());
			}
			int numPeliACopiar = ControlErrores.validarInt();

			if (numPeliACopiar > PelisGeneral.size()) {
				System.out.println("El numero que has puesto no esta en la lista");
			} else {
				Actor personal = ActorGeneral.get(numPeliACopiar - 1);
//			Pelicula.setCountIdPelicula(PelisPersonal.size() + 1);
//			System.out.println("pelispersonal id =" + PelisPersonal.size());
				ActorPersonal.add(personal);
				registrarListaPersonalActor();

			}
		}
	}

	// GUARDAR DATOS ACTOR LISTA PERSONAL
	public static void registrarListaPersonalActor() {
		// serialització
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			// obrim el fitxer per escriure, sense afegir
			// només tindrem un ArrayList d'objectes

			// Guardar antes de crear el usuario la longitud del arrayList
			Actor.setCountIdActor(ActorPersonal.size());
//					System.out.println("-"+getNomUser()+"-"+nomUser+"-"+userCarpeta+"-"+getUserCarpeta());

			fout = new FileOutputStream("src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/actor.llista", false);
			oos = new ObjectOutputStream(fout);
			// escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(ActorPersonal);
			oos.flush();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	// PEDIR DATO A GUARDAR LISTA DIRECTOR PERSONAL
	public static void pedirListaPersonalDirector() {
		File vacio = new File("src/com/proyecto/listasPeliculas/directores.llista");
		if (vacio.length() < 0 || vacio.length() == 0) {
			System.out.println("No puedes añadir nada ya que la lista general esta vacia");
		} else {
			System.out.println("Introduce el numero del Director/a que quieres coger:");
			for (Director i : DirectorGeneral) {
				System.out.println(i.toString());
			}
			int numPeliACopiar = ControlErrores.validarInt();

			if (numPeliACopiar > DirectorGeneral.size()) {
				System.out.println("El numero que has puesto no esta en la lista");
			} else {
				Director personal = DirectorGeneral.get(numPeliACopiar - 1);
//			Pelicula.setCountIdPelicula(PelisPersonal.size() + 1);
//			System.out.println("pelispersonal id =" + PelisPersonal.size());
				DirectorPersonal.add(personal);
				registrarListaPersonalDirector();
			}
		}
	}

	// GUARDAR DATOS DIRECTOR LISTA PERSONAL
	public static void registrarListaPersonalDirector() {
		// serialització
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			// obrim el fitxer per escriure, sense afegir
			// només tindrem un ArrayList d'objectes

			// Guardar antes de crear el usuario la longitud del arrayList
			Director.setCountIdDirector(DirectorPersonal.size());
//			System.out.println("-"+getNomUser()+"-"+nomUser+"-"+userCarpeta+"-"+getUserCarpeta());

			fout = new FileOutputStream("src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/director.llista",
					false);
			oos = new ObjectOutputStream(fout);
			// escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(DirectorPersonal);
			oos.flush();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	// MOSTRAR LISTAS PERSONALES
	// ---------------------------------------------------------------------------------------------------------------

	// MOSTRAR LISTA PERSONAL PELICULA
	public static void mostrarListaPelicuPersonal() {
		File vacio = new File("src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/pelicula.llista");

		if (vacio.length() < 0 || vacio.length() == 0) {
			System.out.println("No hay nada que mostrar");
		} else {

			try {
				// obrim fitxer per a lectura
				FileInputStream file = new FileInputStream(
						"src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/pelicula.llista");
				ObjectInputStream reader = new ObjectInputStream(file);
				try {
					// llegim l'objecte que hi ha al fitxer (1 sol array List)
					PelisPersonal = (ArrayList<Pelicula>) reader.readObject();
					System.out.println("La lista general de peliculas es:");
					for (Pelicula direc : PelisPersonal) {
						System.out.println(direc.toString());
						System.out.println();
					}
				} catch (Exception ex) {
					System.err.println("Se ha mostrado correctamente");
				}

				reader.close();
				file.close();
			} catch (Exception ex) {
				System.err.println("Error en llegir peliculas.llista " + ex);
			}

		}
	}

	// MOSTRAR LISTA PERSONAL ACTOR
	public static void mostrarListaActorPersonal() {
		File vacio = new File("src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/actor.llista");

		if (vacio.length() < 0 || vacio.length() == 0) {
			System.out.println("No hay nada que mostrar");
		} else {

			try {
				// obrim fitxer per a lectura
				FileInputStream file = new FileInputStream(
						"src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/actor.llista");
				ObjectInputStream reader = new ObjectInputStream(file);
				try {
					// llegim l'objecte que hi ha al fitxer (1 sol array List)
					ActorPersonal = (ArrayList<Actor>) reader.readObject();
					System.out.println("La lista general de pelicules es");
					for (Actor act : ActorPersonal) {
						System.out.println(act.toString());
						System.out.println();
					}
				} catch (Exception ex) {
					System.err.println("Se ha mostrado correctamente");
				}

				reader.close();
				file.close();
			} catch (Exception ex) {
				System.err.println("Error en llegir actor.llista " + ex);
			}

		}
	}

	// MOSTRAR LISTA PERSONAL DIRECTOR
	public static void mostrarListaDirectorPersonal() {
		File vacio = new File("src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/director.llista");

		if (vacio.length() < 0 || vacio.length() == 0) {
			System.out.println("No hay nada que mostrar");
		} else {

			try {
				// obrim fitxer per a lectura
				FileInputStream file = new FileInputStream(
						"src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/director.llista");
				ObjectInputStream reader = new ObjectInputStream(file);
				try {
					// llegim l'objecte que hi ha al fitxer (1 sol array List)
					DirectorPersonal = (ArrayList<Director>) reader.readObject();
					System.out.println("La lista general de pelicules es");
					for (Director direc : DirectorPersonal) {
						System.out.println(direc.toString());
						System.out.println();
					}
				} catch (Exception ex) {
					System.err.println("Se ha mostrado correctamente");
				}

				reader.close();
				file.close();
			} catch (Exception ex) {
				System.err.println("Error en llegir director.llista " + ex);
			}

		}
	} // ---------------------------------------------------------------------------------------------------------------

	// Cargar los arrayList al principio del programa
	public static void cargarArrayslist() {
		// cargar listageneralPelis
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("src/com/proyecto/listasPeliculas/peliculas.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				// llegim l'objecte que hi ha al fitxer (1 sol array List)
				PelisGeneral = (ArrayList<Pelicula>) reader.readObject();
			} catch (Exception ex) {
				System.err.println("Se ha mostrado correctamente");
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
		}
		// cargar listageneralActor
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("src/com/proyecto/listasPeliculas/actores.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				// llegim l'objecte que hi ha al fitxer (1 sol array List)
				ActorGeneral = (ArrayList<Actor>) reader.readObject();

			} catch (Exception ex) {
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
		}
		// cargar listagenralDirector
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("src/com/proyecto/listasPeliculas/directores.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {

			} catch (Exception ex) {
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
		}
		// cargarlistaspersonales
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream(
					"src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/director.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {

			} catch (Exception ex) {
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
		}

		//
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream(
					"src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/pelicula.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {

			} catch (Exception ex) {
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
		}

		//
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream(
					"src/com/proyecto/usuariosCarpetas/" + nomUserFinal + "/actor.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {

			} catch (Exception ex) {
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
		}
	}
	// ELIMINAR USUARIO //

	// ETC ETC //

}

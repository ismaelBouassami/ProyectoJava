package com.proyecto.main;

import com.proyecto.utils.ControlErrores;
import com.proyecto.utils.Funciones;

public class Main {

	public static void main(String[] args) {

		int menuPrincipal = 0, menuSecundario = 0, menuTerciario = 0;
		// MENU PRINCIPAL //

		do {
			System.out.println("Escoja una opcion: \n-> 1. Registrar Usuario \n-> 2. Login \n-> 3. Salir");
			menuPrincipal = ControlErrores.validarMenuPrincipal();
			switch (menuPrincipal) {
			case 1:
				///// AQUI IRA LA FUNCION DE registrarUser() ///////////
				System.out.println("-----Registrar Usuario-----");
				Funciones.registrarUsuario();
				break;
			case 2:
				///// AQUI IRA LA FUNCION DE loginUser() ///////////
				System.out.println("-----Iniciar Sesion-----");
				if(Funciones.validaUsuario()) {
					do {
						System.out.println(
								"\n-> 1. Ver lista general \n-> 2. Ver lista personal \n-> 3. Añadir nuevo elemento a lista general \n-> 4. Añadir nuevo elemento a lista personal \n-> 5. Salir");
						menuSecundario = ControlErrores.validarSecundario();
						switch (menuSecundario) {
						 
						case 1:
							System.out.println("-----Ver lista GENERAL-----");

							do {
								System.out.println(
										"\n-> 1. Ver Peliculas \n-> 2. Ver Actores \n-> 3. Ver Directores \n-> 4. Salir");
								menuTerciario = ControlErrores.validarTerciario();
								switch (menuTerciario) {
								case 1:
									System.out.println("-----Ver Peliculas (Lista GENERAL)-----");
									Funciones.mostrarListaGeneralPelicula();
									break;
								case 2:
									System.out.println("-----Ver Actores (Lista GENERAL)-----");
									Funciones.mostrarListaGeneralActor();
									break;
								case 3:
									System.out.println("-----Ver Directores (Lista GENERAL)-----");
									Funciones.mostrarListaGeneralDirector();
									break;
								default:
									System.out.println("Salir");
								}
							} while (menuTerciario != 4);

							System.out.println(menuTerciario);
							break;
						case 2:
							System.out.println("-----Ver lista PERSONAL-----");

							do {
								System.out.println(
										"\n-> 1. Ver Peliculas \n-> 2. Ver Actores \n-> 3. Ver Directores \n-> 4. Salir");
								menuTerciario = ControlErrores.validarTerciario();
								switch (menuTerciario) {
								case 1:
									System.out.println("-----Ver Peliculas (Lista PERSONAL)-----");
									Funciones.mostrarListaPelicuPersonal();
									break;
								case 2:
									System.out.println("-----Ver Actores (Lista PERSONAL)-----");
									Funciones.mostrarListaActorPersonal();
									break;
								case 3:
									System.out.println("-----Ver Directores (Lista PERSONAL)-----");
									Funciones.mostrarListaDirectorPersonal();
									break;
								default:
									System.out.println("Salir");
								}
							} while (menuTerciario != 4);

							break;
						case 3:
							System.out.println("-----Añadir elemento a lista GENERAL-----");

							do {
								System.out.println(
										"\n-> 1. Añadir Peliculas \n-> 2. Añadir Actores \n-> 3. Añadir Directores \n-> 4. Salir");
								menuTerciario = ControlErrores.validarTerciario();
								switch (menuTerciario) {
								case 1:
									System.out.println("-----Añádir Peliculas (Lista GENERAL)-----");
									Funciones.pedirListaGeneralPelicula();
									break;
								case 2:
									System.out.println("-----Añádir Actores (Lista GENERAL)-----");
									Funciones.pedirListaGeneralActor();
									break;
								case 3:
									System.out.println("-----Añádir Directores (Lista GENERAL)-----");
									Funciones.pedirListaGeneralDirector();
									break;
								default:
									System.out.println("Salir");
								}
							} while (menuTerciario != 4);

							break;
						case 4:
							System.out.println("-----Añadir elemento a lista PERSONAL-----");

							do {
								System.out.println(
										"\n-> 1. Añadir Peliculas \n-> 2. Añadir Actores \n-> 3. Añadir Directores \n-> 4. Salir");
								menuTerciario = ControlErrores.validarTerciario();
								switch (menuTerciario) {
								case 1:
									System.out.println("-----Añádir Peliculas (Lista PERSONAL)-----");
									Funciones.pedirListaPersonalPelicula();
									break;
								case 2:
									System.out.println("-----Añádir Actores (Lista PERSONAL)-----");
									Funciones.pedirListaPersonalActor();
									break;
								case 3:
									System.out.println("-----Añádir Directores (Lista PERSONAL)-----");
									Funciones.pedirListaPersonalDirector();
									break;
								default:
									System.out.println("Salir");
								}
							} while (menuTerciario != 4);

							break;
						default:
							System.out.println("Salir");
						}
					} while (menuSecundario != 5);
				}
				

				break;
			default:
				System.out.println("Has cerrado el programa maquina");
			}

		} while (menuPrincipal != 3);

	}
}

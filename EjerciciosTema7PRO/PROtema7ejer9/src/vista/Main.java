package vista;

import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int option = -1;
		do {
			try {
				System.out.println("Seleccione una opci�n del men�: ");
				System.out.println("1. Gestionar alumnado.");
				System.out.println("0. Volver.");
				option = Integer.parseInt(scan.nextLine());
				switch (option) {
				case 1:
					AlumnoVista.gestionAlumnos();
					break;
				case 0:
					System.out.println("Fin del programa.");
					break;
				default:
					System.out.println("Por favor, seleccione una opci�n disponible.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un n�mero.");
			}
		} while (option != 0);
	}

}

package vista;

import java.sql.Date;
import java.util.Scanner;

import bbdd.BDConnection;
import controlador.AlumnoController;
import modelo.Alumno;

public class AlumnoVista {
	private static AlumnoController controlador;
	private static Scanner scan = new Scanner(System.in);

	public static void gestionAlumnos() {
		int option = -1;
		controlador = new AlumnoController();
		String dni;
		do {
			try {
				System.out.println("Seleccione una opción del menú: ");
				System.out.println("1. Mostrar alumnos.");
				System.out.println("2. Ver en detalle un alumno.");
				System.out.println("3. Añadir un nuevo alumno.");
				System.out.println("4. Modificar un alumno existente.");
				System.out.println("5. Eliminar un alumno existente.");
				System.out.println("0. Volver.");
				option = Integer.parseInt(scan.nextLine());
				switch (option) {
				case 1:
					controlador.mostrarAlumnos();
					break;
				case 2:
					controlador.mostrarAlumnosSimple();
					System.out.println("Introduzca el DNI del alumno que quiere ver en detalle: ");
					dni = scan.nextLine();
					controlador.verAlumno(dni);
					break;
				case 3:
					controlador.addAlumno(nuevoAlumno());
					break;
				case 4:
					controlador.mostrarAlumnosSimple();
					System.out.println("Introduzca el DNI del alumno que quiere ver en detalle: ");
					dni = scan.nextLine();
					editAlumno(dni);
					break;
				case 5:
					controlador.mostrarAlumnosSimple();
					System.out.println("Introduzca el DNI del alumno que quiere ver en detalle: ");
					dni = scan.nextLine();
					if(controlador.deleteAlumno(dni)) {
						System.out.println("Alumno borrado correctamente.");
					} else {
						System.out.println("No se encuentra el alumno en la base de datos.");
					}
					break;
				case 0:
					System.out.println("Volviendo al menú principal.");
					BDConnection.endConnection();
					break;
				default:
					System.out.println("Por favor, seleccione una opción disponible.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un número.");
			}
		} while (option != 0);
	}

	private static void editAlumno(String dni) {
		int option = -1;
		controlador = new AlumnoController();
		do {
			try {
				System.out.println("Seleccione una opción del menú: ");
				System.out.println("1. Editar Nombre.");
				System.out.println("2. Editar Primer Apellido.");
				System.out.println("3. Editar Segundo Apellido.");
				System.out.println("4. Editar Fecha de Nacimiento.");
				System.out.println("5. Editar teléfono.");
				System.out.println("0. Volver.");
				option = Integer.parseInt(scan.nextLine());
				switch (option) {
				case 1:
					System.out.println("Introduzca el Nombre del alumno: ");
					String nombre = scan.nextLine();
					controlador.editNombreAlumno(dni, nombre);
					break;
				case 2:
					System.out.println("Introduzca el Primer Apellido del alumno: ");
					String ap1 = scan.nextLine();
					controlador.editAp1Alumno(dni, ap1);
					break;
				case 3:
					System.out.println("Introduzca el Segundo Apellido del alumno: ");
					String ap2 = scan.nextLine();
					controlador.editAp2Alumno(dni, ap2);
					break;
				case 4:
					Date date = pedirFechaCorrecta();
					controlador.editFNacAlumno(dni, date);
					break;
				case 5:
					System.out.println("Introduzca el teléfono del alumno: ");
					String telf = scan.nextLine();
					controlador.editTelfAlumno(dni, telf);
					break;
				case 0:
					System.out.println("Volviendo al menú de gestión de alumnos.");
					break;
				default:
					System.out.println("Por favor, seleccione una opción disponible.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un número.");
			}
		} while (option != 0);
	}

	private static Alumno nuevoAlumno() {
		System.out.println("Introduzca el DNI del alumno: ");
		String dni = scan.nextLine();
		System.out.println("Introduzca el Nombre del alumno: ");
		String nombre = scan.nextLine();
		System.out.println("Introduzca el Primer Apellido del alumno: ");
		String ap1 = scan.nextLine();
		System.out.println("Introduzca el Segundo Apellido del alumno: ");
		String ap2 = scan.nextLine();
		Date date = pedirFechaCorrecta();
		System.out.println("Introduzca el teléfono del alumno: ");
		String telf = scan.nextLine();
		Alumno toret = new Alumno(dni, nombre, ap1, ap2, date, telf);
		return toret;
	}
	
	public static Date pedirFechaCorrecta() {
		boolean fechaCorrecta;
		int dia = 0, mes = 0, ano = 0;
		do {
			try {
				fechaCorrecta = true;
				System.out.println("Introduzca el día de nacimiento del alumno: ");
				dia = Integer.parseInt(scan.nextLine());
				System.out.println("Introduzca el mes de nacimiento del alumno: ");
				mes = Integer.parseInt(scan.nextLine());
				System.out.println("Introduzca el año de nacimiento del alumno: ");
				ano = Integer.parseInt(scan.nextLine());
				if(dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 0) {
					fechaCorrecta = false;
					System.out.println("Debe introducir una fecha válida.");
				} else if ((mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31) {
					fechaCorrecta = false;
					System.out.println("Debe introducir una fecha válida.");
				} else if (mes == 2 && dia == 30) {
					fechaCorrecta = false;
					System.out.println("Debe introducir una fecha válida.");
				}else if(mes == 2 && dia == 29 && !((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0)))) {
					fechaCorrecta = false;
					System.out.println("Debe introducir una fecha válida.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir números");
				fechaCorrecta = false;
			}
		} while (!fechaCorrecta);
		@SuppressWarnings("deprecation")
		Date date = new Date(ano-1900,mes-1,dia);
		return date;
	}
}

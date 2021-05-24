import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// Damos permiso para la utilización de prepared statements
	private static final String URL = "jdbc:mysql://localhost:3306/escuela?useServerPrepStmts=true";
	private static final String USER = "root";
	private static final String PASS = "admin";
	private static Scanner scan = new Scanner(System.in);


	public static void mostrarAlumnosBD(Statement s) throws SQLException {
		// Inicializamos una variable de control para comprobar las filas
		// devueltas
		int rowsCounter = 0;
		String query;

		System.out.println("Obtener todos los alumnos");
		query = "SELECT * FROM alumnos";
		ResultSet rs = s.executeQuery(query);
		System.out.println("\t Query: " + query + " \n");
		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		while (rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
					+ "\t\t" + rs.getDate(5));
			rowsCounter++;
		}
		System.out.println("\n" + rowsCounter + " filas recuperadas\n");
		rowsCounter = 0; // Reinicializamos el contador de filas
		rs.close();
	}
	
	private static ArrayList<Integer> ciclosNombreId(Statement s) throws SQLException {
		String query = "SELECT ID, NOMBRE FROM ciclos";
		ResultSet rs = s.executeQuery(query);
		ArrayList<Integer> ids = new ArrayList<Integer>();
		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		while (rs.next()) {
			System.out.println("id: " + rs.getInt(1) + ". Ciclo: " + rs.getString(2));
			ids.add(rs.getInt(1));
		}
		return ids;
	}
	
	private static int ultimoId(String tabla, Statement s) throws SQLException {
		String query;
		query = "SELECT ID FROM "+ tabla;
		ResultSet rs = s.executeQuery(query);
		int id = 0;
		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		while (rs.next()) {
			id = rs.getInt(1);
		}
		rs.close();
		return id;
	}
	
	private static void addModuloBD(Connection conexion, String nombre, int idCiclo, int curso, int horas) throws SQLException {
		PreparedStatement ps  = conexion.prepareStatement("INSERT INTO modulos (ID, NOMBRE, ID_CICLO, CURSO, HORAS) VALUES (?,?,?,?,?)");
		int id = ultimoId("modulos", conexion.createStatement()) + 1;
		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setInt(3, idCiclo);
		ps.setInt(4, curso);
		ps.setInt(5, horas);
		ps.executeUpdate();
		ps.close();
	}
	
	private static void pedirDatosNuevoModulo(Connection conexion) throws SQLException {
		System.out.println("Introduce el nombre del modulo: ");
		String nombre = scan.nextLine();
		boolean cicloOk;
		int idCiclo = 0;
		do {
			try {
				System.out.println("Introduce el id del ciclo al que pertenece el módulo: ");
				ArrayList<Integer> ids = ciclosNombreId(conexion.createStatement());
				idCiclo = Integer.parseInt(scan.nextLine());
				if(ids.contains(idCiclo)) {
				cicloOk = true;
				} else {
					System.out.println("Seleccione un ciclo existente.");
					cicloOk = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("Introduzca un numero entero.");
				cicloOk = false;
			}
		} while (!cicloOk);
		boolean cursosOk;
		int curso = 0;
		do {
			try {
				System.out.println("Introduce el curso al que pertenece el módulo: ");
				curso = Integer.parseInt(scan.nextLine());
				cursosOk = true;
			} catch (NumberFormatException e) {
				System.out.println("Introduzca un numero entero.");
				cursosOk = false;
			}
		} while (!cursosOk);
		boolean horasOk;
		int horas = 0;
		do {
			try {
				System.out.println("Introduce el número de horas del módulo: ");
				horas = Integer.parseInt(scan.nextLine());
				horasOk = true;
			} catch (NumberFormatException e) {
				System.out.println("Introduzca un numero entero.");
				horasOk = false;
			}
		} while (!horasOk);
		addModuloBD(conexion, nombre, idCiclo, curso, horas);
	}
	
	private static void addCicloBD(Connection conexion, String nombre, String nivel, int cursos) throws SQLException {
		PreparedStatement ps = conexion.prepareStatement("INSERT INTO ciclos (ID, NOMBRE, NIVEL, CURSOS) VALUES (?,?,?,?)");
		int id = ultimoId("ciclos", conexion.createStatement()) + 1;
		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setString(3, nivel);
		ps.setInt(4, cursos);
		ps.executeUpdate();
		ps.close();
	}
	
	private static void pedirDatosNuevoCiclo(Connection conexion) throws SQLException {
		System.out.println("Introduce el nombre del ciclo: ");
		String nombre = scan.nextLine();
		System.out.println("Introduce el nivel del ciclo (basico, medio o superior): ");
		String nivel = scan.nextLine();
		boolean correcto;
		int cursos = 0;
		do {
			try {
				System.out.println("Introduce el número de cursos del ciclo: ");
				cursos = Integer.parseInt(scan.nextLine());
				correcto = true;
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un número entero.");
				correcto = false;
			}
		} while (!correcto);
		addCicloBD(conexion, nombre, nivel, cursos);
	}
	
	private static void addAlumnoBD(Connection conexion, String dni, String nombre, String ap1, String ap2, int dia, int mes, int ano, String telf) throws SQLException {
		PreparedStatement ps = conexion.prepareStatement("INSERT INTO alumnos (DNI, NOMBRE, APELLIDO1, APELLIDO2, FECHA_NACIMIENTO, TELF) VALUES (?,?,?,?,?,?)");
		ps.setString(1, dni);
		ps.setString(2, nombre);
		ps.setString(3, ap1);
		ps.setString(4, ap2);
		@SuppressWarnings("deprecation")
		Date date = new Date(ano,mes,dia);
		ps.setDate(5, date);
		ps.setString(6, telf);
		ps.executeUpdate();
		ps.close();
	}
	
	private static void pedirDatosNuevoAlumno(Connection conexion) throws SQLException {
		System.out.println("Introduzca el DNI del alumno: ");
		String dni = scan.nextLine();
		System.out.println("Introduzca el Nombre del alumno: ");
		String nombre = scan.nextLine();
		System.out.println("Introduzca el Primer Apellido del alumno: ");
		String ap1 = scan.nextLine();
		System.out.println("Introduzca el Segundo Apellido del alumno: ");
		String ap2 = scan.nextLine();
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
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir números");
				fechaCorrecta = false;
			}
		} while (!fechaCorrecta);
		System.out.println("Introduzca el teléfono del alumno: ");
		String telf = scan.nextLine();
		addAlumnoBD(conexion, dni, nombre, ap1, ap2, dia, mes, ano, telf);
	}
	
	// Ejercicio 6: Escritura de las excepciones SQL en un fichero de errores
	private static void escribirErrBD(SQLException e) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("BD_err.log", true);
			bw = new BufferedWriter(fw);
			bw.write("\n" + e.getMessage());
			bw.flush();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		Connection conexion = null;
		try {
			// Cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Se obtiene una conexión con la base de datos.
			// En este caso nos conectamos a la base de datos prueba
			// con el usuario root y contraseña admin definidos en constantes
			conexion = DriverManager.getConnection(URL, USER, PASS);

			Statement s = conexion.createStatement();

			// Ejercicio 4
			mostrarAlumnosBD(s);

			pedirDatosNuevoAlumno(conexion);

			// Se muestran los alumnos de nuevo para comprobar los cambios
			mostrarAlumnosBD(s);
			
			pedirDatosNuevoCiclo(conexion);
			
			pedirDatosNuevoModulo(conexion);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// Ejercicio 6
			escribirErrBD(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally { // Se cierra la conexión con la base de datos.
			try {
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				escribirErrBD(ex);
			}
			scan.close();
		}
	}
}

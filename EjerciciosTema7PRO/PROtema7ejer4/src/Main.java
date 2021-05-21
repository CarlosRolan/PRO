import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DB = "escuela";
	private static final String USER = "root";
	private static final String PASS = "admin";

	// Ejercicio 4: Obtener todos los alumnos
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
		}
	}
}

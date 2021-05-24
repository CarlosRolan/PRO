import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	// Damos permiso para la utilización de prepared statements
	private static final String URL = "jdbc:mysql://localhost:3306/escuela";
	private static final String USER = "root";
	private static final String PASS = "admin";
	private static Scanner scan = new Scanner(System.in);

	
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

	/* Ejercicio 8: Implementar un método que imprima todos los campos devueltos por una consulta, precediendo
	el valor por el nombre del campo. A mayores, este método debe funcionar para cualquiera que sea el número
	de campos que devuelve la consulta.
	*/
	private static void printSelect(Statement s, String query) throws SQLException {
		ResultSet rs = s.executeQuery(query);
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
			System.out.print(rs.getMetaData().getColumnName(i) + "\t");
		System.out.println();
		while (rs.next()) {
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println("");
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
			
			System.out.println("Introduzca la query a ejecutar.");
			String query = scan.nextLine();

			printSelect(s, query);

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

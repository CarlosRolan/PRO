package bbdd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
	private static Connection conexion;
	// Damos permiso para la utilización de prepared statements
	private static final String URL = "jdbc:mysql://localhost:3306/escuela?useServerPrepStmts=true";
	private static final String USER = "root";
	private static final String PASS = "admin";
	
	public BDConnection() {
		startConnection();
	}
	
	public void startConnection() {
		conexion = null;
		try {
			// Cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Se obtiene una conexión con la base de datos.
			// En este caso nos conectamos a la base de datos prueba
			// con el usuario root y contraseña admin definidos en constantes
			conexion = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// Ejercicio 6
			escribirErrBD(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void endConnection() {
		try {
			if (conexion != null) {
				conexion.close();
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			escribirErrBD(ex);
		}
	}
	
	
	
	public Connection getConexion() {
		return conexion;
	}

	public static void escribirErrBD(SQLException e) {
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
}

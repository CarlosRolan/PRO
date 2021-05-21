import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Main {
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DB = "escuela";
	private static final String USER = "root";
	private static final String PASS = "admin";

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
				if(fw != null) {
					fw.close();
				}
				if(bw !=null) {
					bw.close();
				}
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		Connection conexion = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			// Cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Se obtiene una conexión con la base de datos.
			// En este caso nos conectamos a la base de datos prueba
			// con el usuario root y contraseña admin definidos en constantes
			conexion = DriverManager.getConnection(URL, USER, PASS);
			
			Statement s = conexion.createStatement();
			
			// Ejercicio 3: para la creación de la BD se ejecuta el código sql del archivo "escuelaWithData.sql"
			fr = new FileReader("escuelaWithData.sql");
			br = new BufferedReader(fr);
			String line;
			ArrayList<String> lines = new ArrayList<String>();
			while((line = br.readLine()) != null){
				if(line.startsWith("--") || line.equals("")) continue;
				lines.add(line);
			}		
			
				String query = "";
				for (String linea : lines) {
					query = query + linea;
					if (query.endsWith(";")) {
						s.executeUpdate(query);
						query="";
					}
				}
		
		} catch	(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//Ejercicio 6
			escribirErrBD(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally { // Se cierra la conexión con la base de datos.
			try {
				if (conexion != null) {
					conexion.close();
				}
				if(fr != null) {
					fr.close();
				}
				if(br!=null) {
					br.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				escribirErrBD(ex);
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
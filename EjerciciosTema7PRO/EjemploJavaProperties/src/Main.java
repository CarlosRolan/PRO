import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
	private static final String USER = "root";
	private static final String PASS = "1234";
	private static final String URL = "localhost";
	private static final String PORT = "80";

	
	public static void main(String[] args) {
		// Creación y guardado del archivo de propiedades
		Properties escribiendo = new Properties();
		escribiendo.setProperty("username", USER);
		escribiendo.setProperty("password", PASS);
		escribiendo.setProperty("url", URL);
		escribiendo.setProperty("port", PORT);
		try {
			escribiendo.store(new FileOutputStream("configuracion.props"), "Fichero de configuración.");
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
		
		// Lectura y cargado de propiedades desde el archivo de propiedades
		Properties leyendo = new Properties();
		try {
			leyendo.load(new FileInputStream("configuracion.props"));
			String user = leyendo.getProperty("username");
			String pass = leyendo.getProperty("password");
			String ruta = leyendo.getProperty("url") + ":" + leyendo.getProperty("port");
			System.out.println("Nombre de usuario: " + user);
			System.out.println("Contraseña: " + pass);
			System.out.println("Ruta: " + ruta);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}

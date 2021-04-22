import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	FileReader fich;

	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.err.println("Faltan argumentos en main.");
			return;
		}

		for (int i = 0; i < args.length; i++) {
			File fichero = new File(args[i]); // declarar fichero
			if (fichero.exists()) {
				FileReader fich = new FileReader(fichero); // crear el flujo de entrada
				System.out.println("El fichero existe.");
				System.out.println("El fichero tiene: " + contarPalabras(fich) + " palabras.");
			} else
				System.out.printf("El fichero [%s] no existe...%n", args[i]);
		}

	}// Fin main

	static int contarPalabras(FileReader fich) throws IOException {
		int palabras = 0;
		BufferedReader lee = new BufferedReader(fich);
		String linea;

		while ((linea = lee.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(linea);
			while (st.hasMoreTokens()) {
				String palabra = st.nextToken();
				palabras++;
			}
		} // while

		lee.close();
		return palabras;
	}// ContarPalabras

}
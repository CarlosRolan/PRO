import java.sql.*;

public class Main {
	private static final String URL = "jdbc:mysql://localhost:3306/escuela";
	private static final String USER = "root";
	private static final String PASS = "admin";

	public static void main(String[] args) {
		Connection conexion = null;
		try {
			// Cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Se obtiene una conexi�n con la base de datos.
			// En este caso nos conectamos a la base de datos prueba
			// con el usuario root y contrase�a admin definidos en constantes
			conexion = DriverManager.getConnection(URL, USER, PASS);
			
			// Se crea un Statement, para realizar la consulta
			Statement s = conexion.createStatement();
			//Inicializamos una variable de control para comprobar las filas devueltas
			int rowsCounter = 0;
			String query;

			// Apartado 1: Obtener todos los alumnos que no tengan tel�fono registrado
			System.out.println("Obtener todos los alumnos que no tengan tel�fono registrado");
			query = "SELECT * FROM alumnos WHERE telf=''";
			ResultSet rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) +
						" " + rs.getString(3) + " " + rs.getString(4) + 
						"\t\t" + rs.getDate(5));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 2: Obtener el DNI de todos los alumnos matriculados en el 2018
			System.out.println("Obtener el DNI de todos los alumnos matriculados en el 2018");
			query = "SELECT DNI FROM matriculas WHERE ANO=2018;";
			rs = s.executeQuery(query);
			System.out.println("\t Query: "+ query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 3: Obtener el DNI de los alumnos matriculados en acceso a datos el a�o 2017
			System.out.println("Obtener el DNI de los alumnos matriculados en acceso a datos el a�o 2017");
			query = "SELECT DNI FROM matriculas WHERE ID_MODULO=(SELECT ID FROM modulos WHERE NOMBRE=\"ACCESO A DATOS\") AND ANO=2017";
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 4: Obtener el nombre y primer apellido de los alumnos matriculados en acceso a datos el a�o 2017
			System.out.println("Obtener el nombre y primer apellido de los alumnos matriculados en acceso a datos el a�o 2017");
			query = "SELECT NOMBRE, APELLIDO1 FROM alumnos, matriculas WHERE alumnos.DNI=matriculas.DNI AND ID_MODULO=(SELECT ID FROM modulos WHERE NOMBRE=\"ACCESO A DATOS\") AND ANO=2017;";
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 5: Obtener el todos los m�dulos pertenecientes a ciclos de nivel superior
			System.out.println("Obtener el nombre de todos los m�dulos pertenecientes a ciclos de nivel superior");
			query = "SELECT modulos.NOMBRE FROM modulos, ciclos where modulos.ID_CICLO=ciclos.ID AND ciclos.NIVEL=\"SUPERIOR\";";
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 6: Obtener el nombre y primer apellido de todos los alumnos matriculados en DAM. (Pueden repetirse)
			System.out.println("Obtener el nombre y primer apellido de todos los alumnos matriculados en DAM. (Pueden repetirse)");
			query = "SELECT alumnos.NOMBRE, alumnos.APELLIDO1 FROM alumnos, matriculas, modulos, ciclos WHERE alumnos.DNI=matriculas.DNI AND matriculas.ID_MODULO=modulos.ID AND modulos.ID_CICLO=ciclos.ID AND ciclos.NOMBRE=\"DESARROLLO DE APLICACIONES MULTIPLATAFORMA\";";
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 6b: Obtener el nombre y primer apellido de todos los alumnos matriculados en DAM. (Sin repetirse)
			System.out.println("Obtener el nombre y primer apellido de todos los alumnos matriculados en DAM. (Sin repetirse)");
			query = "SELECT DISTINCT alumnos.NOMBRE, alumnos.APELLIDO1 FROM alumnos, matriculas, modulos, ciclos WHERE alumnos.DNI=matriculas.DNI AND matriculas.ID_MODULO=modulos.ID AND modulos.ID_CICLO=ciclos.ID AND ciclos.NOMBRE=\"DESARROLLO DE APLICACIONES MULTIPLATAFORMA\";";
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 7: Obtener el nombre de los alumnos matriculados en el ciclo de Sistemas Microinform�ticos y Redes y el a�o en
			 // el que se matricularon
			System.out.println("Obtener el nombre de los alumnos matriculados en el ciclo de Sistemas Microinform�ticos y Redes y el a�o en\r\n"
					+ "el que se matricularon");
			query = "SELECT DISTINCT alumnos.NOMBRE, matriculas.ANO FROM alumnos, matriculas, modulos, ciclos WHERE alumnos.DNI=matriculas.DNI AND matriculas.ID_MODULO=modulos.ID AND modulos.ID_CICLO=ciclos.ID AND ciclos.NOMBRE=\"SISTEMAS MICROINFORM�TICOS Y REDES\";";
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getInt(2));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 8: Obtener el nombre, tel�fono y nota de todos los alumnos que hayan suspendido PSP en el 2017
			System.out.println("Obtener el nombre y primer apellido de todos los alumnos matriculados en DAM. (Sin repetirse)");
			//Se tiene en cuenta que la NOTA est� almacenada como un VARCHAR() por lo tanto se pone una condici�n para cuando la nota es una cadena vac�a, que no la tenga en cuenta
			query = "SELECT DISTINCT alumnos.NOMBRE, alumnos.TELF, matriculas.NOTA FROM alumnos, matriculas, modulos WHERE alumnos.DNI=matriculas.DNI AND matriculas.ID_MODULO=modulos.ID AND modulos.NOMBRE=\"PROGRAMACI�N DE SERVICIOS Y PROCESOS\" AND matriculas.NOTA<5 AND matriculas.NOTA!=\"\";";
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 9: Obtener el DNI, nombre, apellidos y edad de todos los alumnos mayores de 21 a�os 
			System.out.println("Obtener el DNI, nombre, apellidos y edad de todos los alumnos mayores de 21 a�os");
			query= "SELECT DNI, NOMBRE, APELLIDO1, APELLIDO2, YEAR(CURDATE())-YEAR(alumnos.FECHA_NACIMIENTO) + IF(DATE_FORMAT(CURDATE(),'%d-%m') > DATE_FORMAT(alumnos.FECHA_NACIMIENTO,'%d-%m'), 0 , -1 ) AS `EDAD_ACTUAL` FROM alumnos WHERE YEAR(CURDATE())-YEAR(alumnos.FECHA_NACIMIENTO) + IF(DATE_FORMAT(CURDATE(),'%d-%m') > DATE_FORMAT(alumnos.FECHA_NACIMIENTO,'%d-%m'), 0 , -1 )>21;";
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " Edad: " + rs.getString(5));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 10: Obtener todos los alumnos que est�n o han estado matriculados en el m�dulo de AD.
			System.out.println("Obtener todos los alumnos que est�n o han estado matriculados en el m�dulo de AD.");
			query ="SELECT alumnos.* FROM alumnos, matriculas, modulos WHERE alumnos.DNI=matriculas.DNI AND matriculas.ID_MODULO=modulos.ID AND modulos.NOMBRE=\"ACCESO A DATOS\";"; 
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getDate(5)+ " " + rs.getString(6));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 11: Obtener todos los alumnos que han aprobado PMDM en el curso 2017
			System.out.println("Obtener todos los alumnos que han aprobado PMDM en el curso 2017");
			query = "SELECT alumnos.*, matriculas.NOTA FROM alumnos, matriculas, modulos WHERE alumnos.DNI=matriculas.DNI AND matriculas.ID_MODULO=modulos.ID AND modulos.NOMBRE=\"PROGRAMACI�N MULTIMEDIA Y DISPOSITIVOS M�VILES\" AND matriculas.NOTA>=5;";
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getDate(5)+ " " + rs.getString(6) + " Nota: " + rs.getString(7));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();
			
			// Apartado 12: Obtener todos los alumnos que cursan alg�n m�dulo de 2o curso de DAM en el a�o 2018
			System.out.println("Obtener todos los alumnos que cursan alg�n m�dulo de 2o curso de DAM en el a�o 2018");
			query = "SELECT DISTINCT alumnos.* FROM alumnos, matriculas, modulos, ciclos WHERE alumnos.DNI=matriculas.DNI AND matriculas.ID_MODULO=modulos.ID AND modulos.ID_CICLO=ciclos.ID AND ciclos.NOMBRE=\"DESARROLLO DE APLICACIONES MULTIPLATAFORMA\" AND modulos.CURSO=2 AND matriculas.ANO=2018;";
			rs = s.executeQuery(query);
			System.out.println("\t Query: " + query + " \n");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getDate(5)+ " " + rs.getString(6));
				rowsCounter++;
			}
			System.out.println("\n"+ rowsCounter + " filas recuperadas\n");
			rowsCounter = 0; //Reinicializamos el contador de filas
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally { // Se cierra la conexi�n con la base de datos.
			try {
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}

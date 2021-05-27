package controlador;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import bbdd.BDConnection;
import modelo.Alumno;

public class AlumnoController {
	private static ArrayList<Alumno> alumnos;
	private static BDConnection conexion;
	
	public AlumnoController() {
		conexion = new BDConnection();
		alumnos = new ArrayList<Alumno>();
		try {
			recuperarAlumnosBD();
		} catch (SQLException e) {
			System.out.println("Problema al recuperar los datos del alumnado.");
		}
	}
	
	private static void recuperarAlumnosBD() throws SQLException {
		Statement s = conexion.getConexion().createStatement();
		String query = "SELECT * FROM alumnos";
		ResultSet rs = s.executeQuery(query);
		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		while (rs.next()) {
			Alumno a = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6));
			alumnos.add(a);
		}
		rs.close();
	}
	


	public void mostrarAlumnos() {
		for( Alumno alumno: alumnos) {
			System.out.println(alumno.toString());
		}
	}

	public void verAlumno(String dni) {
		for( Alumno alumno: alumnos) {
			if(alumno.getDni().equals(dni)) {
				System.out.println(alumno.toString());
				break;
			}
		}
	}

	public void addAlumno(Alumno a) {
		alumnos.add(a);
		try {
			PreparedStatement ps = conexion.getConexion().prepareStatement("INSERT INTO alumnos (DNI, NOMBRE, APELLIDO1, APELLIDO2, FECHA_NACIMIENTO, TELF) VALUES (?,?,?,?,?,?)");
			ps.setString(1, a.getDni());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getAp1());
			ps.setString(4, a.getAp2());
			ps.setDate(5, a.getfNac());
			ps.setString(6, a.getTelf());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			BDConnection.escribirErrBD(e);
		}

	}

	public void editAp1Alumno(String dni, String ap1) {
		Alumno aux = null;
		int index = 0;
		for( Alumno alumno: alumnos) {
			if(alumno.getDni().equals(dni)) {
				aux = alumno;
				break;
			}
			index++;
		}
		if(aux!=null) {
			aux.setAp1(ap1);
			alumnos.set(index, aux);
			try {
				Statement s = conexion.getConexion().createStatement();
				s.executeUpdate("UPDATE alumnos SET APELLIDO1=" + ap1 + " WHERE DNI=" + dni);
				s.close();
			} catch (SQLException e) {
				BDConnection.escribirErrBD(e);
			}
		}
	}
	
	public void editAp2Alumno(String dni, String ap2) {
		Alumno aux = null;
		int index = 0;
		for( Alumno alumno: alumnos) {
			if(alumno.getDni().equals(dni)) {
				aux = alumno;
				break;
			}
			index++;
		}
		if(aux!=null) {
			aux.setAp2(ap2);
			alumnos.set(index, aux);
			try {
				Statement s = conexion.getConexion().createStatement();
				s.executeUpdate("UPDATE alumnos SET APELLIDO2=" + ap2 + " WHERE DNI=" + dni);
				s.close();
			} catch (SQLException e) {
				BDConnection.escribirErrBD(e);
			}
		}
	}
	
	public void editFNacAlumno(String dni, Date fNac) {
		Alumno aux = null;
		int index = 0;
		for( Alumno alumno: alumnos) {
			if(alumno.getDni().equals(dni)) {
				aux = alumno;
				break;
			}
			index++;
		}
		if(aux!=null) {
			aux.setfNac(fNac);
			alumnos.set(index, aux);
			try {
				Statement s = conexion.getConexion().createStatement();
				s.executeUpdate("UPDATE alumnos SET FECHA_NACIMIENTO=" + fNac + " WHERE DNI=" + dni);
				s.close();
			} catch (SQLException e) {
				BDConnection.escribirErrBD(e);
			}
		}
	}
	
	public void editTelfAlumno(String dni, String telf) {
		Alumno aux = null;
		int index = 0;
		for( Alumno alumno: alumnos) {
			if(alumno.getDni().equals(dni)) {
				aux = alumno;
				break;
			}
			index++;
		}
		if(aux!=null) {
			aux.setTelf(telf);
			alumnos.set(index, aux);
			try {
				Statement s = conexion.getConexion().createStatement();
				s.executeUpdate("UPDATE alumnos SET TELF=" + telf + " WHERE DNI=" + dni);
				s.close();
			} catch (SQLException e) {
				BDConnection.escribirErrBD(e);
			}
		}
	}
	
	public void editNombreAlumno(String dni, String nombre) {
		Alumno aux = null;
		int index = 0;
		for( Alumno alumno: alumnos) {
			if(alumno.getDni().equals(dni)) {
				aux = alumno;
				break;
			}
			index++;
		}
		if(aux!=null) {
			aux.setNombre(nombre);
			alumnos.set(index, aux);
			try {
				Statement s = conexion.getConexion().createStatement();
				s.executeUpdate("UPDATE alumnos SET NOMBRE=" + nombre + " WHERE DNI=" + dni);
				s.close();
			} catch (SQLException e) {
				BDConnection.escribirErrBD(e);
			}
		}
	}

	public boolean deleteAlumno(String dni) {
		boolean del = false;
		for( Alumno alumno: alumnos) {
			if(alumno.getDni().equals(dni)) {
				alumnos.remove(alumno);
				try {
					Statement s = conexion.getConexion().createStatement();
					s.executeUpdate("DELETE FROM alumnos WHERE DNI=" + dni);
					s.close();
				} catch (SQLException e) {
					BDConnection.escribirErrBD(e);
				}
				del = true;
				break;
			}
		}
		return del;
	}

	public void mostrarAlumnosSimple() {
		for( Alumno alumno: alumnos) {
			System.out.println(alumno.toStringSimple());
		}		
	}

}

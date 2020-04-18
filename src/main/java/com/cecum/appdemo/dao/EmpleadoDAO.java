package com.cecum.appdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cecum.appdemo.entity.Empleado;

public class EmpleadoDAO {

	private String mensaje="";
	public String agregarEmpleado(Connection conn, Empleado emp) {
		PreparedStatement pst = null;
		String sql = "INSERT INTO EMPLEADO (IDEMPLEADO,NOMBRES,APELLIDOS,DNI,ESTADO_CIVIL,GENERO,EDAD) VALUES(EMPLEADO_SEQ.NEXTVAL,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getNombres());
			pst.setString(2, emp.getApellidos());
			pst.setString(3, emp.getDni());
			pst.setString(4, emp.getEstadoCivil()+"");
			pst.setString(5, emp.getGenero()+"");
			pst.setInt(6, emp.getEdad());
			mensaje = "guardado correctamente";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			mensaje = "no se pudo guardar \n " + e.getMessage();
		}
		return mensaje;
	}
	public String modificarEmpleado(Connection conn, Empleado emp) {
		PreparedStatement pst = null;
		String sql = "UPDATE EMPLEADO SET NOMBRES=?,APELLIDOS=?,DNI=?,ESTADO_CIVIL=?,GENERO=?,EDAD=?" 
				+ "WHERE IDEMPLEADO = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getNombres());
			pst.setString(2, emp.getApellidos());
			pst.setString(3, emp.getDni());
			pst.setString(4, emp.getEstadoCivil()+"");
			pst.setString(5, emp.getGenero()+"");
			pst.setInt(6, emp.getEdad());
			pst.setInt(7, emp.getIdEmpleado());
			mensaje = "actualizado correctamente";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			mensaje = "no se pudo actualizar \n " + e.getMessage();
		}
		return mensaje;
	}
	public String elminarEmpleado(Connection conn, int id) {
		PreparedStatement pst = null;
		String sql = "DELETE FROM EMPLEADO WHERE IDEMPLEADO = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			mensaje = "eliminado correctamente";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			mensaje = "no se pudo eliminar \n " + e.getMessage();
		}
		return mensaje;
	}
	public List<Empleado> listarEmpleado(Connection conn) {
		PreparedStatement pst = null;
		String sql = "SELECT * FROM EMPLEADO";
		Statement st = null;
		ResultSet rs = null;
		
		List<Empleado> empleados = new ArrayList<>();
		 try {
			 st = conn.createStatement();
			 rs = st.executeQuery(sql);
			 while (rs.next()) {
				 Empleado emp = new Empleado(
						 rs.getInt("IDEMPLEADO"),
						 rs.getString("NOMBRES"),
						 rs.getString("APELLIDOS"),
						 rs.getString("DNI"),
						 rs.getString("ESTADO_CIVIL").charAt(0),
						 rs.getString("GENERO").charAt(0),
						 rs.getInt("EDAD")
						);
				 System.out.println(emp.getApellidos());
				 empleados.add(emp);
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		 return empleados;
	}
}

package com.cecum.appdemo.bo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.cecum.appdemo.dao.EmpleadoDAO;
import com.cecum.appdemo.db.Conexion;
import com.cecum.appdemo.entity.Empleado;

public class EmpleadoBO {

	private String mensaje = "";
	private EmpleadoDAO edao = new EmpleadoDAO();
	
	
	public String agregarEmpleado(Empleado emp) {
		Connection conn = Conexion.getConnection();
		try {
			mensaje = edao.agregarEmpleado(conn, emp);
			//conn.rollback();
			
		} catch (Exception e) {
			mensaje = mensaje + " " + e.getMessage();
		} finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				mensaje = mensaje + " " + e.getMessage();
			}
		}
		return mensaje;
	}
	public String modificarEmpleado(Empleado emp) {
		Connection conn = Conexion.getConnection();
		try {
			mensaje = edao.modificarEmpleado(conn, emp);
			//conn.rollback();
			
		} catch (Exception e) {
			mensaje = mensaje + " " + e.getMessage();
		} finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				mensaje = mensaje + " " + e.getMessage();
			}
		}
		return mensaje;
	}
	public String elminarEmpleado(int id) {
		Connection conn = Conexion.getConnection();
		try {
			mensaje = edao.elminarEmpleado(conn, id);
			//conn.rollback();
			
		} catch (Exception e) {
			mensaje = mensaje + " " + e.getMessage();
		} finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				mensaje = mensaje + " " + e.getMessage();
			}
		}
		return mensaje;
	}
	public List<Empleado> listarEmpleado() {
		List<Empleado> result = new ArrayList<>(); 
		Connection conn = Conexion.getConnection();
		try {
			result = edao.listarEmpleado(conn);
			
		} catch (Exception e) {
			mensaje = mensaje + " " + e.getMessage();
		} finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				mensaje = mensaje + " " + e.getMessage();
			}
		}
		return result;
	}
}

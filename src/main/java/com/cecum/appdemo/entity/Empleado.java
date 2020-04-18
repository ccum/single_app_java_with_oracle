package com.cecum.appdemo.entity;

public class Empleado {

	private int idEmpleado;
	private String nombres;
	private String apellidos;
	private String dni;
	private char estadoCivil;
	private char genero;
	private int edad;
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(int idEmpleado, String nombres, String apellidos, String dni, char estadoCivil, char genero,
			int edad) {
		this.idEmpleado = idEmpleado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.estadoCivil = estadoCivil;
		this.genero = genero;
		this.edad = edad;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public char getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(char estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni="
				+ dni + ", estadoCivil=" + estadoCivil + ", genero=" + genero + ", edad=" + edad + "]";
	}
	
	
}

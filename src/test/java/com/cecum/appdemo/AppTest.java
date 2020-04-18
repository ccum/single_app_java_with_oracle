package com.cecum.appdemo;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.cecum.appdemo.bo.EmpleadoBO;
import com.cecum.appdemo.entity.Empleado;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	EmpleadoBO ebo = new EmpleadoBO();
    Empleado emp = new Empleado();
    String mensaje = "";
    
    @Test
    public void shouldInsertar()
    {	
    	emp.setNombres("Cesar");
    	emp.setApellidos("Cueva");
    	emp.setDni("12342345");
    	emp.setGenero('M');
    	emp.setEstadoCivil('S');
    	emp.setEdad(30);
        mensaje = ebo.agregarEmpleado(emp);
        assertEquals(mensaje, "guardado correctamente");   
    }
    @Test
    public void shouldModificar()
    {	
    	emp.setIdEmpleado(5);
    	emp.setNombres("Cesar");
    	emp.setApellidos("Mendoza");
    	emp.setDni("12342345");
    	emp.setGenero('M');
    	emp.setEstadoCivil('S');
    	emp.setEdad(30);
        mensaje = ebo.modificarEmpleado(emp);
        assertEquals(mensaje, "actualizado correctamente");   
    }
    @Test
    public void shouldEliminar()
    {	
    	mensaje = ebo.elminarEmpleado(3);
        assertEquals(mensaje, "eliminado correctamente");   
    }
    
    @Test
    public void shouldListar()
    {	
    	List<Empleado> empleados = ebo.listarEmpleado();
        assertEquals(empleados.size(),22);   
    }
}

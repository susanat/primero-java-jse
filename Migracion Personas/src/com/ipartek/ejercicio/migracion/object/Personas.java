package com.ipartek.ejercicio.migracion.object;

import java.util.LinkedList;

import com.ipartek.ejercicio.migracion.Constantes;
import com.ipartek.ejercicio.migracion.Validations;
import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;

public class Personas {
    
    /**
     * Save the posible errors in data
     */
    private LinkedList<eErrorCause> errors = null;
    
    

    private String nombre;
    private String apellido1;
    private String poblacion;
    private int edad;
    private String email;
    private String dni;
    private String cargo;
    
    /**
     * Get all type errors ocurred in object 
     * @return
     */
    public LinkedList<eErrorCause> getErrors(){
	return errors;
    }
    
    
    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	if(!Validations.isUTF8MisInterpreted(nombre)){
	    errors.add(eErrorCause.UTF8);
	}
		
	this.nombre = nombre;
    }

    public String getApellido1() {
	return apellido1;
    }

    public void setApellido1(String apellido1) {
	if(!Validations.isUTF8MisInterpreted(apellido1)){
	    errors.add(eErrorCause.UTF8);
	}
		
	this.apellido1 = apellido1;
    }

    public String getPoblacion() {
	return poblacion;
    }

    public void setPoblacion(String poblacion) {
	if(!Validations.isUTF8MisInterpreted(poblacion)){
	    errors.add(eErrorCause.UTF8);
	}
		
	this.poblacion = poblacion;
    }

    public int getEdad() {
	return edad;
    }

    public void setEdad(String edad) {
	
	try{
	    //check validations 
	    if(!Validations.isValidEdad(edad)){
		errors.add(eErrorCause.EDAD);		
	    }
	    //save the edad
	    this.edad = Integer.valueOf(edad);
	}catch(Exception ex){
	    //error in edad passed, save -1
	    this.edad = -1;
	}	
	
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	
	if(!Validations.isValidEmail(email)){
	    errors.add(eErrorCause.EMAIL);
	}
	
	this.email = email;
    }

    public String getDni() {
	return dni;
    }

    public void setDni(String dni) {
	if(!Validations.isValidDNI(dni)){
	    errors.add(eErrorCause.DNI);
	}
	
	this.dni = dni;
    }

    public String getCargo() {
	return cargo;
    }

    public void setCargo(String cargo) {
	
	if(!Validations.isUTF8MisInterpreted(cargo)){
	    errors.add(eErrorCause.UTF8);
	}
		
	this.cargo = cargo;	
    }

    /*
    public Personas(String nombre, String apellido1, String poblacion,
	    String edad, String email, String dni, String cargo) {
	super();
	
	//initialize list of errors
	errors = new LinkedList<eErrorCause>();
	
	
	this.setNombre(nombre);
	this.setApellido1(apellido1);
	this.setPoblacion(poblacion);
	this.setEdad(edad);
	this.setEmail(email);
	this.setDni(dni);
	this.setCargo(cargo);
    }
    */
    public Personas(){
	//initialize list of errors
	errors = new LinkedList<eErrorCause>();
    }
    
    public boolean hasErrors(){
	if(errors.size() > 0) return true;
		
	return false;		
    }
    

    @Override
    public String toString() {
	return "Personas [nombre=" + nombre + ", apellido1=" + apellido1
		+ ", poblacion=" + poblacion + ", edad=" + edad + ", email="
		+ email + ", dni=" + dni + ", cargo=" + cargo + "]";
    }

}

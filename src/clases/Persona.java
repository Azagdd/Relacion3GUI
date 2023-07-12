package clases;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNac;
	
	
	public Persona() {
		this.dni="";
		this.nombre="";
		this.dni="";
		this.fechaNac=LocalDate.now();
	}


	public Persona(String dni, String nombre, String apellidos, LocalDate fechaNac) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
	}
	
	public Persona(String dni, String nombre, String apellidos, 
			int dia, int mes, int anio) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = LocalDate.of(anio, mes, dia);
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public LocalDate getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}


	@Override
	public String toString() {
		return "Dni: " + dni + "\nNombre: " + nombre + "\nApellidos: " 
					+ apellidos + "\nFechaNac=" + fechaNac
				+ "\n";
	}


	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}


	


	


	
	
	
	
	
	
	
}

package personas10k;

public class Persona {
	String nombre;
	String apellido;
	String direccion;
	int edad;
	String email;
	String dni;
	String categoria;

	public Persona(String nombre, String apellido, String direccion, int edad,
			String email, String dni, String categoria) {
		setNombre(nombre);
		setApellido(apellido);
		setDireccion(direccion);
		setEdad(edad);
		setDni(dni);
		setCategoria(categoria);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return getNombre() + ',' + getApellido() + ',' + getDireccion() + ','
				+ getEdad() + ',' + getEmail() + ',' + getDni() + ','
				+ getCategoria();
	}

}

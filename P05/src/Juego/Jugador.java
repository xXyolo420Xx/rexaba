package Juego;

public class Jugador {
	
	private String nombre;
	private String apellido;
	private int edad;
	private int puntos;
	
	public Jugador() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getEdad() {
		return edad;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}

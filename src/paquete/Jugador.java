package paquete;



public class Jugador {
	private String nombre;
	private int puntaje;
	private int puntajeActual;
	public Jugador(String nombre, int puntaje) {
		this.nombre = nombre;
		this.puntaje = puntaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public int getPuntajeActual() {
		return puntajeActual;
	}
	public void setPuntajeActual(int puntaje) {
		this.puntaje = puntaje;
	}
	
}

	


package paquete;

import las_interfaces.VisitorMinijuego;
import monstruos.HombreLobo;
import monstruos.Momia;
import monstruos.Vampiro;
import monstruos.Zombi;

public class Minijuego implements VisitorMinijuego{
	private int puntaje;
	private double potencial ;
	private double multiplicador;
	private boolean jugado = false;
	private String registro;
	public Minijuego() {
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public double getPotencial() {
		return potencial;
	}
	public void setPotencial(double potencial) {
		this.potencial = potencial;
	}
	public double getMultiplicador() {
		return multiplicador;
	}
	public void setMultiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}
	public boolean isJugado() {
		return jugado;
	}
	public void setJugado(boolean jugado) {
		this.jugado = jugado;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	public double visitar(Zombi zombi) { return 0;};
	public double visitar(Vampiro vampiro) { return 0;};
	public double visitar(Momia momia) { return 0;};
	public double visitar(HombreLobo hombrelobo) { return 0;};
	
}

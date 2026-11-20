package monstruos;

import las_interfaces.VisitorMinijuego;

public class monstruo {
    private String tipo;
    private int vida;
    private int velocidad;
    private int fuerza;
    private int resistencia;

    public monstruo(String tipo, int vida, int velocidad, int fuerza, int resistencia){
        this.tipo = tipo;
        this.vida = vida;
        this.velocidad = velocidad;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        
    }
    public void revisarRango(int objetivo, int max){
        if(objetivo >max){
            objetivo = max;
        }else if(objetivo< 1){
            objetivo = 1;
        }
    }
    public String getTipo(){
        return tipo;
    }
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	public int getResistencia() {
		return resistencia;
	}
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String[] getEspecial() {
		return null;
	}
    
	public int getEspecial1(){
        return 0;
    }
	
	public int getEspecial2(){
        return 0;
    }
    
	public void accept(VisitorMinijuego mini) {
		
	}
}

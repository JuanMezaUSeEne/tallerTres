package monstruos;

import las_interfaces.VisitorMinijuego;

public class Zombi extends monstruo{
    private int Fmordida;
    private String[] especial = {"Mordida "};

    public Zombi(String tipo, int vida, int velocidad, int fuerza, int resistencia, int Fmordida){
        super(tipo, vida, velocidad, fuerza, resistencia);
        this.Fmordida = revisarRango(Fmordida, 100);;
    }
    public int getmordida(){
        return Fmordida;
    }
    
    @Override
    public String[] getEspecial() {
    	return especial;
    }
    
    @Override
    public int getEspecial1(){
        return getmordida();
    }
    
    @Override
    public void accept(VisitorMinijuego mini) {
    	mini.visitar(this);
	}
}
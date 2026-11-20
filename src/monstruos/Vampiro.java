package monstruos;

import las_interfaces.VisitorMinijuego;

public class Vampiro extends monstruo{
    private int VelocidadDeVuelo;
    private int ResistenciaAlSol;
    private String[] especial = { "Vuelo ","Sol "};

    public Vampiro(String tipo, int vida, int velocidad, int fuerza, int resistencia, int VelocidadDeVuelo, int ResistenciaAlSol){
        super(tipo, vida, velocidad, fuerza, resistencia);
        this.VelocidadDeVuelo = revisarRango(VelocidadDeVuelo, 100);
        this.ResistenciaAlSol = revisarRango(ResistenciaAlSol, 100);
    }

	public int getVelocidadDeVuelo() {
		return VelocidadDeVuelo;
	}

	public int getResistenciaAlSol() {
		return ResistenciaAlSol;
	}
	
	@Override
	public String[] getEspecial() {
		return especial;
	}
    
	@Override
	public int getEspecial1(){
        return getVelocidadDeVuelo();
    }
	
	@Override
	public int getEspecial2(){
        return getResistenciaAlSol();
    }
	
	@Override
    public void accept(VisitorMinijuego mini) {
    	mini.visitar(this);
	}
	
}
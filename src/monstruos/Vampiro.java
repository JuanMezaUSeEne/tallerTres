package monstruos;

import las_interfaces.Mordedor;
import las_interfaces.VisitorMinijuego;
import las_interfaces.Volador;

public class Vampiro extends monstruo implements Mordedor, Volador{
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
	public double accept(VisitorMinijuego mini) {
    	return mini.visitar(this);
	}

	@Override
	public String volar() {
		// TODO Auto-generated method stub
		return "Volar";
	}

	@Override
	public String morder() {
		// TODO Auto-generated method stub
		return "Morder";
	}
	
}
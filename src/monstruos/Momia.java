package monstruos;

import las_interfaces.Furioso;
import las_interfaces.Regenerable;
import las_interfaces.VisitorMinijuego;

public class Momia extends monstruo implements Regenerable, Furioso{
    private int LongitudVendajes;
    private String[] especial = {"Vendajes "};
    
    public Momia(String tipo, int vida, int velocidad, int fuerza, int resistencia, int LongitudVendajes){
        super(tipo, vida, velocidad, fuerza, resistencia);
        this.LongitudVendajes = revisarRango(LongitudVendajes, 300);
    }
    
	public int getLongitudVendajes() {
		return LongitudVendajes;
	}
    
	
	@Override
	public String[] getEspecial() {
    	return especial;
    }
	
	@Override
	public int getEspecial1(){
        return getLongitudVendajes();
    }
	@Override
	public double accept(VisitorMinijuego mini) {
    	return mini.visitar(this);
	}

	@Override
	public String enfurecerse() {
		// TODO Auto-generated method stub
		return "Enfurecerse";
	}

	@Override
	public String regenerarse() {
		// TODO Auto-generated method stub
		return "Regenerarse";
	}
}
package monstruos;

import las_interfaces.Furioso;
import las_interfaces.Mordedor;
import las_interfaces.VisitorMinijuego;

public class HombreLobo extends monstruo implements Mordedor, Furioso{
    private int Ferocidad;
    private int FaseLunar;
    private String[] especial = {"Ferocidad ", "Luna "};
    
    public HombreLobo(String tipo, int vida, int velocidad, int fuerza, int resistencia, int Ferocidad, int FaseLunar){
        super(tipo, vida, velocidad, fuerza, resistencia);
        this.Ferocidad = revisarRango(Ferocidad, 100);
        
        this.FaseLunar = revisarRango(FaseLunar, 4);
    }
    public int getFerocidad(){
        return Ferocidad;
    }
    public int getFaseLunar(){
        return FaseLunar;
    }
    
    @Override
    public String[] getEspecial() {
    	return especial;
    }
    
    @Override
    public int getEspecial1(){
        return getFerocidad();
    }
    
    @Override
    public int getEspecial2(){
        return getFaseLunar();
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
	public String morder() {
		// TODO Auto-generated method stub
		return "Morder";
	}
}
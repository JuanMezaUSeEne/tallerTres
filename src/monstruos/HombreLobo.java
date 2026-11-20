package monstruos;

public class HombreLobo extends monstruo{
    private int Ferocidad;
    private int FaseLunar;
    private String[] especial = {"Ferocidad ", "Luna "};
    
    public HombreLobo(String tipo, int vida, int velocidad, int fuerza, int resistencia, int Ferocidad, int FaseLunar){
        super(tipo, vida, velocidad, fuerza, resistencia);
        this.Ferocidad = Ferocidad;
        this.FaseLunar = FaseLunar;
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
}
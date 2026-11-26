package subclasesMinijuegos;

import monstruos.HombreLobo;
import monstruos.Momia;
import monstruos.Vampiro;
import monstruos.Zombi;
import paquete.Minijuego;

public class Caceria extends Minijuego {
private String nombre= "Caceria de Calabazas";
	
	
	public Caceria() {
		super();
		setSkillPremiadaSub();
	}
	
	public void setSkillPremiadaSub() {
		super.setSkillPremiada("Morder");
	}
	

	@Override
	public double visitar(Zombi zombi) { 
		System.out.println("se ejecuto la caceria visitor en un "+ zombi.getTipo());
		int Vida = zombi.getVida();
		int Resistencia = zombi.getResistencia();
		int FuerzaDeMordida = zombi.getmordida();
		
		double potencial = FuerzaDeMordida * Vida / 100 + Resistencia / 2;
		
		return potencial;
		}
	
	@Override
	public double visitar(Vampiro vampiro) { 
		System.out.println("se ejecuto la caceria visitor en un "+ vampiro.getTipo());
		int Velocidad = vampiro.getVelocidad();
		int Fuerza = vampiro.getFuerza();
		
		double potencial = (Fuerza + Velocidad) / 3;
		
		return potencial;
		}
	
	@Override
	public double visitar(Momia momia) { 
		System.out.println("se ejecuto la caceria visitor en una "+ momia.getTipo());
		
		int Fuerza = momia.getFuerza();
		int LongitudVendajes = momia.getLongitudVendajes();
		
		double potencial = 	LongitudVendajes * Fuerza / 200;
		
		return potencial;
		}
	
	@Override
	public double visitar(HombreLobo hombrelobo) { 
		System.out.println("se ejecuto la caceria visitor en un "+ hombrelobo.getTipo());
		
		int Velocidad = hombrelobo.getVelocidad();
		int Ferocidad = hombrelobo.getFerocidad();
		int FaseLunar = hombrelobo.getFaseLunar();
		
		double potencial = Ferocidad * FaseLunar / 4 + Velocidad / 4;
		
		return potencial;
		}
}

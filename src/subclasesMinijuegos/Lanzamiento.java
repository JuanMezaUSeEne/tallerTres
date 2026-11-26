package subclasesMinijuegos;

import monstruos.HombreLobo;
import monstruos.Momia;
import monstruos.Vampiro;
import monstruos.Zombi;
import paquete.Minijuego;

public class Lanzamiento extends Minijuego{
	private String nombre= "Lanzamiento de lapidas";
	
	
	public Lanzamiento() {
		super();
		setSkillPremiadaSub();
	}

	public void setSkillPremiadaSub() {
		super.setSkillPremiada("Enfurecerse");
	}
	
	@Override
	public double visitar(Zombi zombi) { 
		System.out.println("se ejecuto el lanzamiento visitor en un "+ zombi.getTipo());
		
		int Fuerza = zombi.getFuerza();
		int Resistencia = zombi.getResistencia();
		
		double potencial=Fuerza * Resistencia / 100;
		
		return potencial;
		}
	
	@Override
	public double visitar(Vampiro vampiro) { 
		System.out.println("se ejecuto el lanzamiento visitor en un "+ vampiro.getTipo());

		int Fuerza = vampiro.getFuerza();
		int VelocidadDeVuelo = vampiro.getVelocidadDeVuelo();
		
		double potencial=Fuerza + VelocidadDeVuelo / 4;
		
		return potencial;
		}
	
	@Override
	public double visitar(Momia momia) { 
		System.out.println("se ejecuto el lanzamiento visitor en una "+ momia.getTipo());
		
		int Fuerza = momia.getFuerza();
		int LongitudVendajes = momia.getLongitudVendajes();
		
		double potencial=Fuerza + LongitudVendajes / 10;
		
		return potencial;
		}
	
	@Override
	public double visitar(HombreLobo hombrelobo) { 
		System.out.println("se ejecuto el lanzamiento visitor en un "+ hombrelobo.getTipo());
		int Fuerza = hombrelobo.getFuerza();
		int Ferocidad = hombrelobo.getFerocidad();
		int FaseLunar = hombrelobo.getFaseLunar();
		
		double potencial=Fuerza + Ferocidad * FaseLunar / 8;
		
		return potencial;
		}
}

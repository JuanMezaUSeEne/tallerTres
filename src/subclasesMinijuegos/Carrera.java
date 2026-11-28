package subclasesMinijuegos;

import monstruos.HombreLobo;
import monstruos.Momia;
import monstruos.Vampiro;
import monstruos.Zombi;
import paquete.Minijuego;

public class Carrera extends Minijuego {
	private String nombre= "Carrera del cementerio";
	
	
	
	public Carrera() {
		super();
		setSkillPremiadaSub();
	}
	
	public void setSkillPremiadaSub() {
		super.setSkillPremiada("Volar");
	}

	public String getNombre(){
		return nombre;
	}

	public String getDescripcion(){
		return nombre+ ": Recorre el cementerio de punta a punta antes de que el sepulturero te vea.";
	}

	@Override
	public double visitar(Zombi zombi) { 
		System.out.println("se ejecuto la caceria visitor en un "+ zombi.getTipo());
		int Velocidad = zombi.getVelocidad();
		int Resistencia = zombi.getResistencia();
		
		double potencial = Velocidad * Resistencia / 100;
		
		return potencial;
		}
	
	@Override
	public double visitar(Vampiro vampiro) { 
		//System.out.println("se ejecuto la caceria visitor en un "+ vampiro.getTipo());
		int Velocidad = vampiro.getVelocidad();
		int VelocidadDeVuelo = vampiro.getVelocidadDeVuelo();
		
		double potencial = (Velocidad + 2 * VelocidadDeVuelo) / 2;
		
		return potencial;
		}
	
	@Override
	public double visitar(Momia momia) { 
		//System.out.println("se ejecuto la caceria visitor en una "+ momia.getTipo());
		
		int Velocidad = momia.getVelocidad();
		int LongitudVendajes = momia.getLongitudVendajes();
		
		double potencial = Velocidad * 100 / (100 + LongitudVendajes);
		
		return potencial;
		}
	
	@Override
	public double visitar(HombreLobo hombrelobo) { 
		//System.out.println("se ejecuto la caceria visitor en un "+ hombrelobo.getTipo());
		
		int Velocidad = hombrelobo.getVelocidad();
		int Ferocidad = hombrelobo.getFerocidad();
		int FaseLunar = hombrelobo.getFaseLunar();
		
		double potencial = (Velocidad + Ferocidad / 5) * FaseLunar / 4;
		
		return potencial;
		}
}

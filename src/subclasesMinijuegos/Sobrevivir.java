package subclasesMinijuegos;

import monstruos.HombreLobo;
import monstruos.Momia;
import monstruos.Vampiro;
import monstruos.Zombi;
import paquete.Minijuego;

public class Sobrevivir extends Minijuego {
private String nombre= "Lanzamiento de lapidas";
	
	
	public Sobrevivir() {
		super();
		setSkillPremiadaSub();
	}

	
	public void setSkillPremiadaSub() {
		super.setSkillPremiada("Regenerarse");
	}

	public String getNombre(){
		return nombre;
	}

	public String getDescripcion(){
		return nombre+ ": Aguanta en pie cuando salgan los primeros rayos de sol.";
	}	
	
	@Override
	public double visitar(Zombi zombi) { 
		System.out.println("se ejecuto el lanzamiento visitor en un "+ zombi.getTipo());
		int Vida = zombi.getVida();
		int Resistencia = zombi.getResistencia();
		
		double potencial=Resistencia * Vida / 100;
		
		return potencial;
		}
	
	@Override
	public double visitar(Vampiro vampiro) { 
		System.out.println("se ejecuto el lanzamiento visitor en un "+ vampiro.getTipo());
		
		int Resistencia = vampiro.getResistencia();
		int ResistenciaAlSol = vampiro.getResistenciaAlSol();
		
		double potencial=	Resistencia * ResistenciaAlSol / 100;
		
		return potencial;
		}
	
	@Override
	public double visitar(Momia momia) { 
		System.out.println("se ejecuto el lanzamiento visitor en una "+ momia.getTipo());
		
		int Resistencia = momia.getResistencia();
		int Vida = momia.getVida();
		int LongitudVendajes = momia.getLongitudVendajes();
		
		double potencial=	(Resistencia + Vida) / 2 * (1 + LongitudVendajes / 300);
		
		return potencial;
		}
	
	@Override
	public double visitar(HombreLobo hombrelobo) { 
		System.out.println("se ejecuto el lanzamiento visitor en un "+ hombrelobo.getTipo());
		
		int Resistencia = hombrelobo.getResistencia();
		int FaseLunar = hombrelobo.getFaseLunar();
		int Vida = hombrelobo.getVida();
		
		double potencial=(Resistencia + Vida) / 2 * (5 - FaseLunar) / 4;
		
		return potencial;
		}
}

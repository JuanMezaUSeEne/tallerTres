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
	}

	@Override
	public double visitar(Zombi zombi) { 
		System.out.println("se ejecuto la carrera visitor en un "+ zombi.getTipo());
		return 0;};
	
	@Override
	public double visitar(Vampiro vampiro) { 
		System.out.println("se ejecuto la carrera visitor en un "+ vampiro.getTipo());
		return 0;};
	
	@Override
	public double visitar(Momia momia) { 
		System.out.println("se ejecuto la carrera visitor en una "+ momia.getTipo());
		return 0;};
	
	@Override
	public double visitar(HombreLobo hombrelobo) { 
		System.out.println("se ejecuto la carrera visitor en un "+ hombrelobo.getTipo());
		return 0;};
}

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
	}

	@Override
	public double visitar(Zombi zombi) { 
		System.out.println("se ejecuto la caceria visitor en un "+ zombi.getTipo());
		return 0;};
	
	@Override
	public double visitar(Vampiro vampiro) { 
		System.out.println("se ejecuto la caceria visitor en un "+ vampiro.getTipo());
		return 0;};
	
	@Override
	public double visitar(Momia momia) { 
		System.out.println("se ejecuto la caceria visitor en una "+ momia.getTipo());
		return 0;};
	
	@Override
	public double visitar(HombreLobo hombrelobo) { 
		System.out.println("se ejecuto la caceria visitor en un "+ hombrelobo.getTipo());
		return 0;};
}

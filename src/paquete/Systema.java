package paquete;

import java.util.ArrayList;
import java.util.List;

import las_interfaces.Furioso;
import las_interfaces.Mordedor;
import las_interfaces.Regenerable;
import las_interfaces.Volador;
import monstruos.HombreLobo;
import monstruos.Momia;
import monstruos.Vampiro;
import monstruos.Zombi;
import monstruos.monstruo;
import subclasesMinijuegos.Caceria;
import subclasesMinijuegos.Carrera;
import subclasesMinijuegos.Lanzamiento;
import subclasesMinijuegos.Sobrevivir;

public class Systema {
	
	private static List<Jugador> jugadores = new ArrayList<>();
	private static List<monstruo> monstruos = new ArrayList<>();
	private static Jugador playerActual;
	private static List<String> historial = new ArrayList<>();
	
	private static Minijuego m1= new Carrera();
	private static Minijuego m2= new Caceria();
	private static Minijuego m3= new Lanzamiento();
	private static Minijuego m4= new Sobrevivir();
	
	
	private static Minijuego[] minijuegos = {m1,m2,m3,m4};
	
	
	
	public Systema() {
		
	}
	
	
	
	public static void ingresarJugador(String nombreJ) {
    	playerActual = new Jugador(nombreJ, 0);
		jugadores.add(playerActual);
    }

	public static void setPlayerActual(Jugador playerActual) {
		Systema.playerActual = playerActual;
	}

	public static Jugador getPlayerActual() {
		return playerActual;
	}
	
	
	public static boolean registroJu(String nombre) {
		//por ahora no se hace nada, luego se implementara el metodo para leer y agregar registro
		return true;
	}
	
	public List<Jugador> getlista(){
		return jugadores;
	}
	
	public List<monstruo> getlista2(){
		return monstruos;
	}
	
	public List<String> getlista3(){
		return historial;
	}
	
	public Minijuego[] verMinijuegos() {
		return minijuegos;
	}
	
	//METODOS NO GETTERS/SETTERS=================================================================================
	
	
	public static void AnalisisLinea(String[] linea, int inicioTipo) {
		//System.out.println("se inicia el metodo EN "+ inicioTipo+" "+ linea[inicioTipo]);
	
		
		
		
		
		
	    int formato;
	    int[] aux = {-1};
	    int formato2;
	    monstruo Auxm = null;
	    
	    
	    switch(linea[inicioTipo]){
	        case "Zombi": 
	            //System.out.println("se va a ejecutar el metodo analisisdatos() con zombies");
	            formato = 6;
	            
	            
	    	    
	           
	            
	    	   if(inicioTipo+formato <= linea.length) { 
	    		   formato2 = inicioTipo +formato;
		            aux = analisisdatos(linea, inicioTipo,formato2);
		    	    //System.out.println(aux);
		            
		            //System.out.println("largo de aux "+ (aux.length-inicioTipo)+(aux.length-inicioTipo == formato));
	        		if(aux.length == formato) {
	        			//System.out.println("print del Zombi: "+" "+ aux[0]+" "+ aux[1]+" "+ aux[2]+" "+ aux[3]);
	        			Auxm = new Zombi("Zombi     ", aux[1], aux[2], aux[3], aux[4],aux[5]);
	        		}else formato2 = aux.length + inicioTipo;
	            
		            
	    	   }else formato2 = inicioTipo +1;
	    	    
	            break; //BREAK CASE ZOMBI---------------------------------------------
	            
	            
	        case "Vampiro":
	            
	            formato = 7;
	            //System.out.println("se inicia con vampiro"); 
	    	    
	            if(inicioTipo+formato <= linea.length) { 
	            	formato2 = inicioTipo +formato;
	            	aux = analisisdatos(linea, inicioTipo,formato2);
	            	//System.out.println(); System.out.println(aux.length); System.out.println();
	            	if(aux.length == formato) {
	        			//System.out.println("print del Zombi: "+" "+ aux[0]+" "+ aux[1]+" "+ aux[2]+" "+ aux[3]);
	        			Auxm = new Vampiro("Vampiro   ", aux[1], aux[2], aux[3], aux[4],aux[5],aux[6]);
	        		}else formato2 = aux.length + inicioTipo;
	            	
	    	    }else formato2 = inicioTipo +1;
	    	    
	            break; //BREAK CASE VAMPIRO---------------------------------------------
	            
	        case "Momia":
	        	formato = 6;
	        	
	    	    
	        	if(inicioTipo+formato <= linea.length) { 
	        		formato2 = inicioTipo +formato;
	        		aux = analisisdatos(linea, inicioTipo,formato2);
	        		//System.out.println(aux);
	        		if(aux.length == formato) {
	        			//System.out.println("print del Zombi: "+" "+ aux[0]+" "+ aux[1]+" "+ aux[2]+" "+ aux[3]);
	        			Auxm = new Momia("Momia     ", aux[1], aux[2], aux[3], aux[4],aux[5]);
	        			
	        		}else formato2 = aux.length + inicioTipo;
	        		
	    	    }else formato2 = inicioTipo +1;
	    	    
	        	break;//BREAK CASE MOMIA ---------------------------------------------
	        	
	        case "HombreLobo":
	        	formato = 7;
	        	
	    	    
	        	if(inicioTipo+formato <= linea.length) {
	        		formato2 = inicioTipo +formato;
	        		aux = analisisdatos(linea, inicioTipo,formato2);
	        		//System.out.println(aux);
	        		//System.out.println("largo de aux"+ aux.length);
	        		if(aux.length == formato) {
	        			//System.out.println("print del Hombre Lobo: "+" "+ aux[0]+" "+ aux[1]+" "+ aux[2]+" "+ aux[3]+" "+ aux[4]+" "+ aux[5]+" "+ aux[6]);
	        			Auxm = new HombreLobo("HombreLobo", aux[1], aux[2], aux[3], aux[4],aux[5],aux[6]);
	        		}else formato2 = aux.length + inicioTipo;
	            
	            
	    	    }else formato2 = inicioTipo +1;
	    	    break; //BREAK CASE HOMBRELOBO---------------------------------------------
	    	
	            
            default:
            	//System.out.println("linea ["+ inicioTipo + "] = "+ linea[inicioTipo] + ". el formato es invalido, se omite");
	            formato = 1;
	            formato2 = inicioTipo +formato;
	            aux = analisisdatos(linea, inicioTipo,formato2);
	            
            break;
	    }//CERRANDO EL SWITCH=================================================================
	    
	    

	    aux = new int[3];
	    //System.out.println(Auxm+ " en el indice "+ formato2);
	    
	    
	    if(Auxm != null) {
        	
        	monstruos.add(Auxm);
        	
        }
	    //System.out.println(formato2);
	    //CONDICIONAL PARA INICIAR METODO RECURSIVO PARA ANALIZAR MAS DATOS EN CASO DE TENER MAS FUERA DEL FORMATO ENCONTRADO
	    if(linea.length > formato2){
	        //System.out.println("aqui se inicia de nuevo");
	        
	    	AnalisisLinea(linea,formato2);
	    }
	    //System.out.println("se termino de ejecutar el metodo");
	}
	
	
	
	
	
	
	
	
	
	
	public static int[] analisisdatos(String[] linea,int inicio, int largoFormato){
	    
	    int[] lista = new int[largoFormato- inicio];
	    int a = 0;
	    
	    try{
	        //System.out.println("aqui va desde "+ (inicio+1)+ " a "+ largoFormato+" aqui se ve que estan comparando "+ largoFormato+" "+ linea.length+ (largoFormato<= linea.length));
            
	    	
	    	//se comprueba si la linea tiene menos indices que los que corresponden al formato de cada monstruo
            if(largoFormato<= linea.length){
                
                
                for(a = inicio +1 ; a<largoFormato; a++){
                	//System.out.println(a+" "+linea[a]);
                    lista[a-inicio] = Integer.valueOf(linea[a]);
                    
            }
            }else{
                int ju = Integer.valueOf("aqui estoy forzando el error para saltar al catch");
            }
            
        }catch(NumberFormatException e){
        	//System.out.println("el formato es invalido "+a);
            lista = new int[a-inicio]; //con esto se hace que la comprobacion de que lo que devuelve el metodo no es informacion suficiente para iniciar el constructor en el metodo AnalisisLinea()
            return lista;

        }
        //System.out.println(lista[0]); System.out.println(lista[1]); System.out.println(lista[2]); System.out.println(lista[3]); System.out.println(lista[4]); System.out.println(lista[5]); System.out.println(lista[6]); 
        return lista;
	    
	}
	
	
	
	//
	
	
	public static void AnalisisLinea(String[] linea, int inicioTipo, String parametroExtraquesolosirveparahacerlasobrecargadeparametrosequisde) {
		//System.out.println("se esta iniciando el otro"+linea.length +" "+ inicioTipo +" "+(linea.length - inicioTipo >= 2));
		if(linea.length - inicioTipo >= 2) {
			try {
				
				//System.out.println(linea[inicioTipo]+" "+linea[inicioTipo+1]);
				String nombreJ = linea[inicioTipo];
				int puntos = Integer.valueOf(linea[inicioTipo+1]);
				Jugador player = new Jugador(nombreJ, puntos);
				jugadores.add(player);
				
				
			}catch(NumberFormatException e){
				//System.out.println("esta malo, se omite.");
			}
			AnalisisLinea(linea, inicioTipo+2, "si");
		}
	}
	//
	//
	public static void ordenardesdeMax(List<Jugador> lalista){
        for(int i =0; i < lalista.size()-1; i++){
            for(int o =i; o < lalista.size(); o++){
                if (lalista.get(i).getPuntaje() < lalista.get(o).getPuntaje()){
                    intercambiar(lalista,i,o);
                }
            }
        }
    }
    //
    public static void intercambiar(List<Jugador> lista, int a, int b){
        Jugador aux = lista.get(a);
        lista.set(a, lista.get(b));
        lista.set(b, aux);
    }
    //
    
	
	//prueba de los metodos
	
	/*
	public static void main(String[] args){
	    String a = "Zombi;100;20;70;60;90;Zombi;100;20;70;60;90";
	    String c = "Zombi;100;20;70;60;90;Vampiro;90;80;55;30;70;20;0;Zombi";
	    String[] b = c.split(";");
	   
	    for(int i = 0; i< b.length; i++){
	        System.out.println(b[i]);
	    }
	    AnalisisLinea(b,0);
	}
	*/
    public String ordenarhabilidades(int indicemonstruo) {
    	String frase = "";
    	
    	for (int i = 0; i < monstruos.size(); i++) {
    	    System.out.println("Índice " + i + ": " + monstruos.get(i));
    	}
    	System.out.println("se estan viendo las habilidades de un "+ monstruos.get(indicemonstruo));
    	
    	monstruo monstruoaux = monstruos.get(indicemonstruo-1);
    	if(monstruoaux instanceof Furioso) {
    		frase += ((Furioso) monstruoaux).enfurecerse()+",";
    	}
    	if(monstruoaux instanceof Mordedor) {
    		frase += ((Mordedor) monstruoaux).morder()+",";
    	}
    	if(monstruoaux instanceof Regenerable) {
    		frase+= ((Regenerable) monstruoaux).regenerarse()+",";
    	}
    	if(monstruoaux instanceof Volador) {
    		frase += ((Volador) monstruoaux).volar()+",";
    	}
    	String[] frase2 = frase.split(",");
    	frase = "";
    	for(int i = 0; i<frase2.length; i++) {
    		frase += String.valueOf(i+1)+") "+ frase2[i]+",";
    	}
    	frase+= "0) No usar una habilidad";
    	return frase;
    }
    //
	public String jugarMinijuego(int numerodelMinijuego, int indicemonstruo, String habilidadUsada) {
		//System.out.println(numerodelMinijuego+" "+monstruos.get(indicemonstruo-1).getTipo()+ " "+(numerodelMinijuego) );
		
		
		
		
		double multiplicador=1;
		
		double potencial= monstruos.get(indicemonstruo-1).accept(minijuegos[numerodelMinijuego-1]);
		
		//System.out.println("el potencial es: "+ potencial);
		
		
		String habilidadpremiada = minijuegos[numerodelMinijuego-1].getSkillPremiada().strip();
		//System.out.println("esto tendria que ser la habilidadUsada: "+habilidadUsada+" "+minijuegos[numerodelMinijuego-1].getSkillPremiada()+" "+(habilidadUsada.equalsIgnoreCase(habilidadpremiada.strip())));
		String habilidadUsadaLimpia = habilidadUsada.strip();
		String habilidadPremiadaLimpia = habilidadpremiada.strip();

		if (habilidadUsadaLimpia.equalsIgnoreCase(habilidadPremiadaLimpia)) {
		    multiplicador = 1.5;
		}
		
		int puntaje = (int) Math.round(potencial * 10 * multiplicador );
		
		System.out.println("puntaje obtenido: "+ puntaje);

		monstruos.get(indicemonstruo-1).setUsado();

		minijuegos[numerodelMinijuego-1].setJugado(puntaje);

		desplazarHastaAtras(indicemonstruo);


		playerActual.setPuntajeActual(playerActual.getPuntajeActual()+ puntaje);
		return "el potencial es: "+ String.valueOf(potencial)+"\n puntaje obtenido: "+ String.valueOf(puntaje);
		}
	
	//
	public void desplazarHastaAtras(int indice) {
		for( int i = indice-1; i< monstruos.size()-1; i++) {
			//System.out.println(i);
			monstruo aux = monstruos.get(i);
			monstruos.set(i, monstruos.get(i+1));
			monstruos.set(i+1, aux);
			//System.out.println(monstruos.get(0).getTipo()+", "+monstruos.get(1).getTipo()+", "+monstruos.get(2).getTipo()+", "+monstruos.get(3).getTipo()+", "+monstruos.get(4).getTipo());
				
			
		}
	}

	public static void reiniciarSesion(){
		List<String> historial = new ArrayList<>();
	
		
		
		
		minijuegos = new Minijuego[] { new Carrera(), new Caceria(), new Lanzamiento(), new Sobrevivir() };

		for(int i =0; i <monstruos.size(); i++){
			monstruos.get(i).ResetUsado();
		}
	}
	
}


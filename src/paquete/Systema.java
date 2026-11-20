package paquete;

import java.util.ArrayList;
import java.util.List;

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
	        			//System.out.println("print del Zombi: "+" "+ aux[0]+" "+ aux[1]+" "+ aux[2]+" "+ aux[3]);
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
	
	
	
	//este AnalisisLinea es para la carga de jugadores
	
	
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
	
	
	public static void ordenardesdeMax(List<Jugador> lalista){
        for(int i =0; i < lalista.size()-1; i++){
            for(int o =i; o < lalista.size(); o++){
                if (lalista.get(i).getPuntaje() < lalista.get(o).getPuntaje()){
                    intercambiar(lalista,i,o);
                }
            }
        }
    }
    
    public static void intercambiar(List<Jugador> lista, int a, int b){
        Jugador aux = lista.get(a);
        lista.set(a, lista.get(b));
        lista.set(b, aux);
    }
    
    
	
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
	public void jugarMinijuego(int numerodelMinijuego, int indicemonstruo) {
		System.out.println(numerodelMinijuego+" "+monstruos.get(indicemonstruo-1).getTipo()+ " "+(numerodelMinijuego) );
		
		monstruos.get(indicemonstruo-1).accept(minijuegos[numerodelMinijuego-1]);
	}
	
}


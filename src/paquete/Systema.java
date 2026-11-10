package paquete;

import java.util.ArrayList;
import java.util.List;

public class Systema {
	
	private static List<Jugador> jugadores = new ArrayList<>();
	
	
	
	
	public Systema() {
		
	}
	public static void AnalisisLinea(String[] linea, int inicioTipo) {
	    //System.out.println("se inicia el metodo");
		
		
	    int formato;
	    int[] aux = {-1};
	    int formato2;
	    
	    switch(linea[inicioTipo]){
	        case "Zombi": 
	            //System.out.println("se va a ejecutar el metodo analisisdatos() con zombies");
	            formato = 6;
	            
	            formato2 = inicioTipo +formato;
	    	    
	    	   if(inicioTipo+formato <= linea.length) { 
		            aux = analisisdatos(linea, inicioTipo,formato2);
		    	    //System.out.println(aux);
		            
		            System.out.println("largo de aux"+ aux.length);
	        		if(aux.length == formato) {
	        			System.out.println("si esto sale en pantalla se cumple el formato");
	        		}
	            
		            
	    	   }
	    	    
	            break;
	            
	            
	        case "Vampiro":
	            //System.out.println("se inicia con vampiro");
	            formato = 7;
	            formato2 = inicioTipo +formato;
	    	    
	            if(inicioTipo+formato <= linea.length) { 
	            	aux = analisisdatos(linea, inicioTipo,formato2);
	            	//System.out.println(aux);
	    	    }
	    	    
	            break;
	        case "Momia":
	        	formato = 6;
	        	formato2 = inicioTipo +formato;
	    	    
	        	if(inicioTipo+formato <= linea.length) { 
	        		aux = analisisdatos(linea, inicioTipo,formato2);
	        		//System.out.println(aux);
	    	    }
	    	    
	        	break;
	        case "HombreLobo":
	        	formato = 7;
	        	formato2 = inicioTipo +formato;
	    	    
	        	if(inicioTipo+formato <= linea.length) { 
	        		aux = analisisdatos(linea, inicioTipo,formato2);
	        		//System.out.println(aux);
	        		System.out.println("largo de aux"+ aux.length);
	        		if(aux.length == formato) {
	        			System.out.println("si esto sale en pantalla se cumple el formato");
	        		}
	            
	            
	    	    }
	    	    break;
	    	
	            
            default:
	            System.out.println("linea ["+ inicioTipo + "] = "+ linea[inicioTipo] + ". el formato es invalido, se omite");
	            formato = 1;
	            formato2 = inicioTipo +formato;
	            aux = analisisdatos(linea, inicioTipo,formato2);
            break;
	    }//CERRANDO EL SWITCH
	    
	    
	    
	    aux = new int[3];
	    //System.out.println(aux.length);
	    
	    if(linea.length > formato2){
	        //System.out.println("aqui se inicia de nuevo");
	        AnalisisLinea(linea,formato2);
	    }
	    //System.out.println("se termino de ejecutar el metodo");
	}
	
	
	
	
	
	
	
	
	
	
	public static int[] analisisdatos(String[] linea,int inicio, int largoFormato){
	    
	    int[] lista = new int[largoFormato];
	    
	    try{
	        //System.out.println("aqui va desde "+ (inicio+1)+ " a "+ largoFormato+" aqui se ve que estan comparando "+ largoFormato+" "+ linea.length+ (largoFormato<= linea.length));
            
	    	
	    	//se comprueba si la linea tiene menos indices que los que corresponden al formato de cada monstruo
            if(largoFormato<= linea.length){
                lista[largoFormato-1] = 1;
                for(int a = inicio +1 ; a<largoFormato; a++){
                    //System.out.println(a+" "+linea[a]);
                    lista[a] = Integer.valueOf(linea[a]);
                    
            }
            }else{
                int ju = Integer.valueOf("aqui estoy forzando el error para saltar al catch");
            }
            
        }catch(NumberFormatException e){
            System.out.println("el formato es invalido");
            lista = new int[1]; //con esto se hace que la comprobacion de que lo que devuelve el metodo no es informacion suficiente para iniciar el constructor en el metodo AnalisisLinea()
            return lista;

        }
        //System.out.println(lista[0]); System.out.println(lista[1]); System.out.println(lista[2]); System.out.println(lista[3]); System.out.println(lista[4]); System.out.println(lista[5]); System.out.println(lista[6]); 
        return lista;
	    
	}
	
	
	
	//este AnalisisLinea es para la carga de jugadores
	
	
	public static void AnalisisLinea(String[] linea, int inicioTipo, String parametroExtraquesolosirveparahacerlasobrecargadeparametrosequisde) {
		System.out.println("se esta iniciando el otro"+linea.length +" "+ inicioTipo +" "+(linea.length - inicioTipo >= 2));
		if(linea.length - inicioTipo >= 2) {
			try {
				
				System.out.println(linea[inicioTipo]+" "+linea[inicioTipo+1]);
				String nombreJ = linea[inicioTipo];
				int puntos = Integer.valueOf(linea[inicioTipo+1]);
				Jugador player = new Jugador(nombreJ, puntos);
				jugadores.add(player);
				
				
			}catch(NumberFormatException e){
				System.out.println("esta malo, se omite.");
			}
			AnalisisLinea(linea, inicioTipo+2, "si");
		}
	}
	
	
	
	
	public static boolean registroJu(String nombre) {
		//por ahora no se hace nada, luego se implementara el metodo para leer y agregar registro
		return true;
	}
	
	public List<Jugador> getlista(){
		return jugadores;
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
	
	
}


package paquete;

public class Systema {
	
	
	
	
	
	
	public Systema() {
		
	}
	public static void AnalisisLinea(String[] linea, int inicioTipo) {
	    //System.out.println("se inicia el metodo");
	    int formato;
	    int[] aux;
	    int formato2;
	    
	    switch(linea[inicioTipo]){
	        case "Zombi": 
	            System.out.println("se va a ejecutar el metodo analisisdatos() con zombies");
	            formato = 6;
	            
	            formato2 = inicioTipo +formato;
	    	    
	    	   if(inicioTipo+formato <= linea.length) { 
		            aux = analisisdatos(linea, inicioTipo,formato2);
		    	    System.out.println(aux);
	    	   }
	    	    
	            break;
	            
	            
	        case "Vampiro":
	            System.out.println("se inicia con vampiro");
	            formato = 7;
	            formato2 = inicioTipo +formato;
	    	    
	            if(inicioTipo+formato <= linea.length) { 
	            aux = analisisdatos(linea, inicioTipo,formato2);
	    	    System.out.println(aux);
	    	    }
	    	    
	            break;
	        case "Momia":
	        	formato = 6;
	        	formato2 = inicioTipo +formato;
	    	    
	        	if(inicioTipo+formato <= linea.length) { 
	            aux = analisisdatos(linea, inicioTipo,formato2);
	    	    System.out.println(aux);
	    	    }
	    	    
	        	break;
	        case "HombreLobo":
	        	formato = 7;
	        	formato2 = inicioTipo +formato;
	    	    
	        	if(inicioTipo+formato <= linea.length) { 
	            aux = analisisdatos(linea, inicioTipo,formato2);
	    	    System.out.println(aux);
	    	    }
	    	    break;
	    	    
            default:
	            System.out.println("linea ["+ inicioTipo + "] = "+ linea[inicioTipo] + ". el formato es invalido, se omite");
	            formato = 1;
	            formato2 = inicioTipo +formato;
	            aux = analisisdatos(linea, inicioTipo,formato2);
            break;
	    }
	    aux = new int[3];
	    System.out.println(aux.length);
	    
	    if(linea.length > formato2){
	        System.out.println("aqui se inicia de nuevo");
	        AnalisisLinea(linea,formato2);
	    }
	    System.out.println("se termino de ejecutar el metodo");
	}
	public static int[] analisisdatos(String[] linea,int inicio, int largoFormato){
	    
	    int[] lista = new int[largoFormato+1];
	    
	    try{
	        System.out.println("aqui va desde "+ (inicio+1)+ " a "+ largoFormato+" aqui se ve que estan comparando "+ largoFormato+" "+ linea.length+ (largoFormato< linea.length));
            
            if(largoFormato< linea.length){
                lista[largoFormato-1] = 1;
                for(int a = inicio +1 ; a<largoFormato; a++){
                    System.out.println("dentro del for"+linea[a]);
                    lista[a] = Integer.valueOf(linea[a]);
            }
            }else{
                int ju = Integer.valueOf("aqui estoy forzando el error para saltar al catch");
            }
            
        }catch(NumberFormatException e){
            System.out.println("el formato es invalido");
            return lista;

        }
        System.out.println("si se pudo");
        return lista;
	    
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

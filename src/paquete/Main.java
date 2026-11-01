package paquete;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Main {
	public static void main(String[] args)throws IOException {
		
		
		String r1 = "C:/Users/Juan/eclipse-workspace/tallerTres/src/ayayay.txt";
		String r2 = "C:/Users/Juan/eclipse-workspace/tallerTres/src/Monstruos - copia.txt";
		
		Systema s = new Systema();
		
		Archivo arch2 = new Archivo(r2);
		while(arch2.getLectura().hasNextLine()) {
			s.AnalisisLinea(arch2.li(), 0);
		}
		
		Archivo arch1 = new Archivo(r1);
		while(arch1.getLectura().hasNextLine()){
			arch1.li();
			
			
		}
		
		
		
		
		//menuSelect("Jugar un minijuego,Ver catálogo de monstruos,Ver historial de la sesión,Ver ranking de jugadores,Terminar sesión,Salir", "0");
		
		
	}

	
	
	public static String menuSelect(String textos, String salida){
	    Scanner sc = new Scanner(System.in);
	    String opcion;
	    String[] lista = textos.split(",");
	    int largoLista = lista.length;
	    int i = 0;
	    boolean comprobador = false; 
	    do{
	    for(i = 1; i<=largoLista;i++){
	        System.out.println(lista[i-1]);
	    }
	    opcion = sc.nextLine().strip();
	    for (i = 0;i<largoLista;i++){
	        if( opcion.equals(String.valueOf(i))|| opcion.equals(salida)){
	        	comprobador = true;
	            break;
	        }
	        
	    }
	    if( !opcion.equals(String.valueOf(i))){
	            
	        
	    	System.out.println("no funciono, intenta otra vez");
	    }
	    }while(comprobador == false);
	    return opcion;
	}
	
}

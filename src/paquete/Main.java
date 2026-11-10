//juan Ignacio Meza Alvarez - 21297106-6 
//Carrera: ICCI
//Profesor: Alejandro Paolini

package paquete;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Main {
	public static void main(String[] args)throws IOException {
		
		
		String r1 = "C:/Users/Juan/eclipse-workspace/tallerTres/src/ayayay.txt";
		String r2 = "C:/Users/Juan/eclipse-workspace/tallerTres/src/Monstruos.txt";
		
		Systema s = new Systema();
		
		System.out.println("Cargando archivos...");
		
		Archivo arch2 = new Archivo(r2);
		while(arch2.getLectura().hasNextLine()) {
			s.AnalisisLinea(arch2.li(), 0);
			
			
		}
		
		Archivo arch1 = new Archivo(r1);
		while(arch1.getLectura().hasNextLine()){
			arch1.li();
			
			
		}
		
		
		System.out.println("> "+"una cantidad que aun no se determina de "+ " monstruos cargados desde "+ "NOMBRE DEL ARCHIVO");
		
		System.out.println("> "+"una cantidad que aun no se determina de "+ " jugadores cargados desde "+ "NOMBRE DEL ARCHIVO"); System.out.println();
		
		System.out.println("=========================================");
		System.out.println("             SPOOKY SEASON");
		System.out.println("========================================="); System.out.println();
		
		sesion();
		
		String op1= "5";
		
		
		
		while(!op1.equals("6")) {
		op1 =menuSelect("1) Jugar un minijuego,2) Ver catálogo de monstruos,3) Ver historial de la sesión,4) Ver ranking de jugadores,5) Terminar sesión,6) Salir", "0","opcion no valida, intente de nuevo");
		System.out.println("aqui se imprime algo");
			switch (op1){
				case "5":
					sesion();
					break;
					
			}
			
		}
		
		
		
	}

	
	
	public static String menuSelect(String textos, String salida, String mensajeError){
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
		    for (i = 1;i<largoLista+1;i++){
		    	
		    	if( opcion.equals(String.valueOf(i))|| opcion.equals(salida)){
		        	
		        	comprobador = true;
		            break;
		        }
		        
		    }
		    if( !opcion.equals(String.valueOf(i))){
		            
		        
		    	System.out.println(mensajeError);
		    }
	    }while(comprobador == false);

	    return opcion;
	}
	
	public static void sesion() {
		Scanner in = new Scanner(System.in);
		String nom = "";
		while(nom.equals("")) {
			System.out.print("Ingrese su nombre de usuario: ");
			nom = in.nextLine();
			if(nom.equals("")) {
				System.out.println("el nombre no puede ser vacio, intentelo de nuevo");
			}
		}
	}
	
}

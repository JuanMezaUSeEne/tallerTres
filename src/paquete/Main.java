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
			s.AnalisisLinea(arch1.li(), 0 ,"si");
			
			
		}
		
		
		System.out.println("> "+"una cantidad que aun no se determina de "+ " monstruos cargados desde "+ "NOMBRE DEL ARCHIVO");
		
		System.out.println("> "+"una cantidad que aun no se determina de "+ " jugadores cargados desde "+ "NOMBRE DEL ARCHIVO"); System.out.println();
		
		System.out.println("=========================================");
		System.out.println("             SPOOKY SEASON");
		System.out.println("========================================="); System.out.println();
		
		sesion();
		
		String op1= "5";
		
		
		
		while(!op1.equals("6")) {
			
			System.out.println();System.out.println("------ MENÚ PRINCIPAL ("+ "nombre del jugadore que mas rato voy a poner"+") ------");
			
			op1 =menuSelect("1) Jugar un minijuego,2) Ver catálogo de monstruos,3) Ver historial de la sesión,4) Ver ranking de jugadores,5) Terminar sesión,6) Salir", "0","opcion no valida, intente de nuevo");
			
				switch (op1){
					case "1":
						System.out.println();System.out.println("------ MINIJUEGOS ------");
						String op2 = menuSelect("1) Carrera del Cementerio   "+"[PENDIENTE]"+",2) Caza de Calabazas        "+"[PENDIENTE]"+",3) Lanzamiento de Lápidas   "+"[PENDIENTE]"+",4) Sobrevivir al Amanecer   "+"[PENDIENTE]"+",0) Volver", "0","[!] opcion fuera de rango, intente nuevamente");
						switch(op2) {
							case "1":
								break;
							case "2":
								break;
							case "3":
								break;
							case "4":
								break;
							case "0":
								break;
							default:
								break;
						}	
							//saliendo de un while que comprobara que el minijuego no este jugado
						
						System.out.println("Elige el monstruo en el que te transformaras:");
						
						String op3 = menuSelect("1) Zombi      | Vida 100 | Vel 20 | Fue 70 | Res 60 | Mordida 90,2) Momia      | Vida 120 | Vel 30 | Fue 45 | Res 85 | Vendajes 180,3) HombreLobo | Vida 110 | Vel 60 | Fue 90 | Res 50 | Ferocidad 75 | Luna 4,0) Volver", "0", "error fuera de rango, intentelo de nuevo");
							
						break;//break de op1 case "1"
					
					case "2":
						System.out.println(); System.out.println("------ HISTORIAL DE LA SESIÓN ------");
						
						break;//break de op1 case "2"
						
					case "3":
						
						break;//break de op1 case "3"
					case "4":
						System.out.println("------ RANKING ------");
						
						//for para mostrar un ranking
						
						for(int i = 0;i < s.getlista().size();i++) {
							String nomAux = s.getlista().get(i).getNombre();
							int puntajeAux = s.getlista().get(i).getPuntaje();
							System.out.print(i+1+". "+ nomAux);
							
							
							for(int u = 0; u <(15-nomAux.length());u++) {System.out.print(" "); };
							System.out.println(puntajeAux);
						}
						
						
						System.out.println();
						break;
					case "5":
						System.out.println("sesion terminada. Puntaje total: "+ "aqui va el puntaje"+" puntos:");
						
						if(true) {
							System.out.println("No superaste tu récord ("+7600+"). ¡Suerte para la próxima!");
						}else {
							System.out.println("terrible choro ahora si te paseaste tu record antiguo con "+ 0+ " puntos.");
						}
						
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
		    System.out.print("> ");
		    opcion = sc.nextLine().strip();
		    for (i = 1;i<largoLista+1;i++){
		    	
		    	if( opcion.equals(String.valueOf(i))|| opcion.equals(salida)){
		        	//System.out.println(opcion+ salida+ opcion.equals(salida));
		        	comprobador = true;
		            return opcion;
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
			}else if(buscar(nom) != -1) {
				String persona = "";
				System.out.println("Bienvenido de vuelta "+ persona);
			}
		}
	}
	
	public static int buscar(String objetivo) {
		return -1;
	}
	
}

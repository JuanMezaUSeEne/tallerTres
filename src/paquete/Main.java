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
		
		//RUTAS: R1-ARCHIVO DE LOS JUGADORES, R2-ARCHIVO DE LOS MONSTRUOS
		String r1 = "C:/Users/Juan/eclipse-workspace/tallerTres/src/ayayay.txt";
		String r2 = "C:/Users/Juan/eclipse-workspace/tallerTres/src/Monstruos.txt";
		
		Systema s = new Systema();
		

		String op1= "";
		
		int numa = 0;
				
				
		System.out.println("Cargando archivos...");
		
		Archivo arch1 = new Archivo(r1);
		Archivo arch2 = new Archivo(r2);
		
		if(arch1.getArch() != null && arch2.getArch() != null) {
			while(arch1.getLectura().hasNextLine()){
				s.AnalisisLinea(arch1.li(), 0 ,"si");
				
				
			}
		
			
			System.out.println("> "+s.getlista().size()+ " jugadores cargados desde "+ "NOMBRE DEL ARCHIVO"); 
			
		
		while(arch2.getLectura().hasNextLine()) {
			s.AnalisisLinea(arch2.li(), 0);
			
			

		}

		System.out.println("> "+s.getlista2().size()+ " monstruos cargados desde "+ "NOMBRE DEL ARCHIVO");System.out.println();

		numa = 0;
		
		
		
		
		
		
		
		
		
		
		System.out.println("=========================================");
		System.out.println("             SPOOKY SEASON");
		System.out.println("========================================="); 
		

		String jugadorActual =sesion(s);
		
		
		//MENU ABRE=====================================================================================================
		
		while(!op1.equals("6")) {
			
			String frase="";
			s.ordenardesdeMax(s.getlista());
			
			
			System.out.println();System.out.println("------ MENÚ PRINCIPAL ("+ jugadorActual+") ------");
			
			op1 =menuSelect("1) Jugar un minijuego,2) Ver catálogo de monstruos,3) Ver historial de la sesión,4) Ver ranking de jugadores,5) Terminar sesión,6) Salir", "0","opcion no valida, intente de nuevo");
			
			String op2 = "";
				switch (op1){
					case "1":
						System.out.println();System.out.println("------ MINIJUEGOS ------");
						op2 = menuSelect("1) Carrera del Cementerio   "+"[PENDIENTE]"+",2) Caza de Calabazas        "+"[PENDIENTE]"+",3) Lanzamiento de Lápidas   "+"[PENDIENTE]"+",4) Sobrevivir al Amanecer   "+"[PENDIENTE]"+",0) Volver", "0","[!] opcion fuera de rango, intente nuevamente");
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
						if(!op2.equals("0")) {
							System.out.println("Elige el monstruo en el que te transformaras:");
							
							 frase = ordenarMonstruos(s);
							
							
							String op3 = menuSelect(frase, "0", "[!] accion no valida, intentar de nuevo"); 
						}
						break;//break de op1 case "1" ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					
					case "2":
						System.out.println();System.out.println("largo de lista de monstruos: "+s.getlista2().size());
						
						 frase = ordenarMonstruos(s);
						
						
						op2 = menuSelect(frase, "0", "[!] accion no valida, intentar de nuevo"); 
						
						
						
						break;//break de op1 case "2"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						
					case "3":
						String l = menuSelect("", "5","");
						String prueba = s.getlista().get(Integer.valueOf(l)).getNombre();
						System.out.println(prueba);
						
						break;//break de op1 case "3"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
						break;// break de op1 case "4"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					case "5":
						
						
						
						System.out.println("sesion terminada. Puntaje total: "+ s.getPlayerActual().getPuntaje()+" puntos.");
						
						if(true) {
							System.out.println("No superaste tu récord ("+7600+"). ¡Suerte para la próxima!");
						}else {
							System.out.println("terrible choro ahora si te paseaste tu record antiguo con "+ 0+ " puntos.");
						}
						for(int i = 0; i< s.getlista().size(); i++) {
							String elnombre =s.getlista().get(i).getNombre();
							int elpuntaje = s.getlista().get(i).getPuntaje();
							if(i==0) {
								arch1.escribir(elnombre, elpuntaje, false);

							}else {
								arch1.escribir(elnombre, elpuntaje, true);
							}
						}
						jugadorActual =sesion(s);
						break;//break de op1 case"5"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						
				}
			}//MENU CIERRA==================================================================================================================================================
		}else System.out.println("no se encontraron los archivos. finalizando programa...");
		
		
		
	}

	//METODOS--------------------------------------------------------------------------------------------------------------------------------------------
	
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
	
	
	
	
	
	
	public static String sesion(Systema s) {
		Scanner in = new Scanner(System.in);
		String nom = "";
		while(nom.equals("")) {
			System.out.print("Ingrese su nombre de usuario: ");
			nom = in.nextLine().strip();
			int lugarnom =buscar(nom, s);
			
			if(nom.equals("")) {
				System.out.println("el nombre no puede ser vacio, intentelo de nuevo");
			}else if(lugarnom != -1) {
				String persona = s.getlista().get(lugarnom).getNombre();
				int puntaje = s.getlista().get(lugarnom).getPuntaje();
				s.setPlayerActual(s.getlista().get(lugarnom));
				System.out.println("Bienvenido de vuelta "+ persona+ " tu puntaje es: "+ puntaje); System.out.println();
				return persona;
			}else {
				s.ingresarJugador(nom);
				System.out.println("Usuario registrado con exito eskereeeeee"); System.out.println();
				
			}
		}
		return nom;
	}
	
	
	
	
	
	
	
	public static int buscar(String objetivo, Systema s) {
		boolean comprobador = false;
		int i= 0;
		for( i = 0;i < s.getlista().size();i++) {
			String nomAux = s.getlista().get(i).getNombre();
			int puntajeAux = s.getlista().get(i).getPuntaje();
			if(nomAux.equals(objetivo)) {
				comprobador = true;
				break;
			}
			
		}
		if(comprobador == true) {
			return i;
		}else {
			return -1;
	
		}
	}
	
	
	
	
	
	
	
	
	
	public static String ordenarMonstruos(Systema s) {
		String frase = "";
		for (int o = 0; o<s.getlista2().size(); o++) {
			
			String tipodemonstruo = s.getlista2().get(o).getTipo();
			int vidaMonstruo = s.getlista2().get(o).getVida();
			int velMonstruo = s.getlista2().get(o).getVelocidad();
			int fueMonstruo = s.getlista2().get(o).getFuerza();
			int resMonstruo = s.getlista2().get(o).getResistencia();
			String[] especiales = s.getlista2().get(o).getEspecial();
			int especial1 = s.getlista2().get(o).getEspecial1();
			
			
			
			frase +=(o+1)+ ") "+ tipodemonstruo+ " | " + mostrarOrdenado("vida",String.valueOf(vidaMonstruo),8) +" | "+ mostrarOrdenado("Vel",String.valueOf(velMonstruo),7)+" | "+ mostrarOrdenado("Fue",String.valueOf(fueMonstruo),7)+" | "+mostrarOrdenado("Res",String.valueOf(resMonstruo),7)+" | "+especiales[0]+String.valueOf(especial1);
			
			if (especiales.length == 2) {
				int especial2 = s.getlista2().get(o).getEspecial1();
				frase+=" | " + especiales[1]+ String.valueOf(especial2)+",";
			}else frase += ",";
			
			
		}
		frase += "0) volver";
		
		return frase;
	}
	
	
	
	
	
	
	public static String mostrarOrdenado(String frase1, String frase2, int espaciomax){
	    String finall ="";
	    String inicio =frase1+ " "+ frase2;
	    while (inicio.length() < espaciomax){
	        inicio+= " ";
	    }
	    return inicio;
	}
}

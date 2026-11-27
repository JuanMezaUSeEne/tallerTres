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
		String r1 = "Jugadores.txt";
		String r2 = "Monstruos.txt";
		
		Systema s = new Systema();
		

		String op1= "";
		
		int numa = 0;
				
				
		System.out.println("Cargando archivos...");
		
		Archivo arch1 = new Archivo(r1);
		Archivo arch2 = new Archivo(r2);
		
		if(arch1.getArch() != null) {
			while(arch1.getLectura().hasNextLine()){
				s.AnalisisLinea(arch1.li(), 0 ,"si");
				
				
			}
		}else {System.out.println("registros de jugadores no encontrados, iniciando sin marcador...");}
		
		System.out.println("> "+s.getlista().size()+ " jugadores cargados desde "+ r1); 
		
		
		if(arch2.getArch() != null) {
			
		
		while(arch2.getLectura().hasNextLine()) {
			s.AnalisisLinea(arch2.li(), 0);
			
			

		}

		System.out.println("> "+s.getlista2().size()+ " monstruos cargados desde "+ r2);System.out.println();

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
			
			op1 =menuSelect("1) Jugar un minijuego,2) Ver catálogo de monstruos,3) Ver historial de la sesión,4) Ver ranking de jugadores,5) Terminar sesión,6) Salir", "6","opcion no valida, intente de nuevo");
			
			String op2 = "";
				switch (op1){
					case "1":
						System.out.println();System.out.println("------ MINIJUEGOS ------");

						String menuMinijuegos = "1) Carrera del Cementerio   "+s.verMinijuegos()[0].getJugado()+",2) Caza de Calabazas        "+s.verMinijuegos()[1].getJugado()+",3) Lanzamiento de Lápidas   "+s.verMinijuegos()[2].getJugado()+",4) Sobrevivir al Amanecer   "+s.verMinijuegos()[3].getJugado()+",0) Volver";
						
						
						
						do{
							op2 = menuSelect(menuMinijuegos, "0","[!] opcion fuera de rango, intente nuevamente");

							
							if(op2.equals("0")) {
								break;
							}else if(!s.verMinijuegos()[Integer.valueOf(op2)-1].getJugado().equals("[PENDIENTE]")){
									System.out.println("[!] Ya jugaste "+ s.verMinijuegos()[0].getNombre()+ " en esta sesion.");
							} 
						}while(!s.verMinijuegos()[Integer.valueOf(op2)-1].getJugado().equals("[PENDIENTE]"));
							
						if(!op2.equals("0")) {
							
							
							System.out.println("Elige el monstruo en el que te transformaras:");
							
							 frase = ordenarMonstruos(s, true);
							
							
							String op3 = menuSelect(frase, "0", "[!] accion no valida, intentar de nuevo");
							
							
							
							if(!op3.equals("0")){
								String habilidades = s.ordenarhabilidades(Integer.valueOf(op3));
								
							
								System.out.println();System.out.println("¿Quieres usar alguna habilidad?");
								System.out.println("imprime algo conchatumadre");

								String op4 = menuSelect(habilidades, "0", "[!] accion no valida, intentar de nuevo");
								String habilidadUsada = ""; 
								if(!op4.equals("0")){
								habilidadUsada = habilidades.split(",")[Integer.valueOf(op4)-1].split("\\)")[1];
								}
								String resultado= s.jugarMinijuego(Integer.valueOf(op2), Integer.valueOf(op3), habilidadUsada);
								System.out.println(resultado);
							}
							
								
							
						}
						break;//break de op1 case "1" ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					
					case "2":
						System.out.println();System.out.println("largo de lista de monstruos: "+s.getlista2().size());
						
						 frase = ordenarMonstruos(s, false);
						
						
						op2 = menuSelect(frase, "0", "[!] accion no valida, intentar de nuevo"); 
						
						
						
						break;//break de op1 case "2"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						
					case "3":
						
						if(s.getlista3().size()== 0) {
							System.out.println(); System.out.println("No hay minijuegos jugados aun, tiene que jugar alguno.");
							
						}else {
							for(int i = 0; i< s.getlista3().size();i++) {
								String[] historialaux =  s.getlista3().get(i).split(",");
								System.out.println((i+1)+". "+mostrarOrdenado(historialaux[0],"", 26)+ "| "+ mostrarOrdenado(historialaux[1],"",11)+" | "+ mostrarOrdenado(historialaux[2],"",24)+" | "+mostrarOrdenadoReves(historialaux[3],"",8));
							}
						}
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
						int puntos;
						System.out.println(s.getPlayerActual().getPuntajeActual()+" "+ s.getPlayerActual().getPuntaje() );
						if(s.getPlayerActual().getPuntajeActual() <= s.getPlayerActual().getPuntaje()) {
							puntos = s.getPlayerActual().getPuntaje();
							System.out.println("No superaste tu récord ("+puntos+"). ¡Suerte para la próxima!");
						}else {
							System.out.println("terrible choro ahora si te paseaste tu record antiguo con "+ 0+ " puntos.");
							puntos = s.getPlayerActual().getPuntajeActual();
						}
						for(int i = 0; i< s.getlista().size(); i++) {
							String elnombre =s.getlista().get(i).getNombre();
							int elpuntaje = puntos;
							if(i==0) {
								arch1.escribir(elnombre, elpuntaje, false);

							}else {
								arch1.escribir(elnombre, elpuntaje, true);
							}
						}
						s.reiniciarSesion();
						System.out.println("");
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
		    for (i = 1;i<largoLista;i++){
		    	//System.out.println(opcion+ salida+ opcion.equals(salida));
		    	if( opcion.equals(String.valueOf(i))|| opcion.equals(salida)){
		        	
		        	comprobador = true;
		            return opcion;
		        }
		        
		    }
			//System.out.println("valor de la opcion: "+ opcion+ " valor de i: "+ i+ "son iguales: "+opcion.equals(String.valueOf(i)));
			//System.out.println(opcion+" "+ i+!opcion.equals(String.valueOf(i)));

		    if( comprobador == false){
		            
		        
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
	
	
	
	
	
	
	
	
	
	public static String ordenarMonstruos(Systema s, boolean ocultar) {
		String frase = "";
		int numeroMenu = 0;
		
		for (int o = 0; o<s.getlista2().size(); o++) {
			
			if(s.getlista2().get(o).getUsado().equals("sin usar") || ocultar == false){

				String tipodemonstruo = s.getlista2().get(o).getTipo();
				int vidaMonstruo = s.getlista2().get(o).getVida();
				int velMonstruo = s.getlista2().get(o).getVelocidad();
				int fueMonstruo = s.getlista2().get(o).getFuerza();
				int resMonstruo = s.getlista2().get(o).getResistencia();
				String[] especiales = s.getlista2().get(o).getEspecial();
				int especial1 = s.getlista2().get(o).getEspecial1();
				
				
				
				frase +=(o+1-numeroMenu)+ ") "+ tipodemonstruo+ " | " + mostrarOrdenado("vida",String.valueOf(vidaMonstruo),8) +" | "+ mostrarOrdenado("Vel",String.valueOf(velMonstruo),7)+" | "+ mostrarOrdenado("Fue",String.valueOf(fueMonstruo),7)+" | "+mostrarOrdenado("Res",String.valueOf(resMonstruo),7)+" | "+especiales[0]+String.valueOf(especial1);
				
				if (especiales.length == 2) {
					int especial2 = s.getlista2().get(o).getEspecial2();
					frase+=" | " + especiales[1]+ String.valueOf(especial2);
				}
				if(ocultar == false){frase += " | estado: "+ s.getlista2().get(o).getUsado();}
				frase += ",";
					
				
			}else{
				numeroMenu++;
			}
			
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
	public static String mostrarOrdenadoReves(String frase1, String frase2, int espaciomax){
	    String finall ="";
	    String inicio =frase1+ " "+ frase2;
	    while (inicio.length() < espaciomax){
	        inicio= " "+inicio;
	    }
	    return inicio;
	}
}

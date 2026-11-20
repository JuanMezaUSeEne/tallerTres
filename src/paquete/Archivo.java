package paquete;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


public class Archivo  {
	private File arch;
	private Scanner lectura;
	private String linea;
	private String ruta;

	
	
	public Archivo(String ruta) throws IOException  {
		this.ruta = ruta;
		try {
		this.arch = new File(ruta);
		
		this.lectura = new Scanner(arch);
		}catch(FileNotFoundException e) {
			//System.out.println("no se encontro el archivo"+ ruta);
			this.arch = null;
			this.ruta = null;
		}
	}



	public String[] li() throws IOException {
		linea = lectura.nextLine();
		//System.out.println(linea);
		return linea.split(";");
		
	}



	public File getArch() {
		return arch;
	}



	public void setArch(File arch) {
		this.arch = arch;
	}



	public Scanner getLectura() {
		return lectura;
	}



	public void setLectura(Scanner lectura) {
		this.lectura = lectura;
	}



	public String getLinea() {
		return linea;
	}



	public void setLinea(String linea) {
		this.linea = linea;
	}



	public String getRuta() {
		return ruta;
	}



	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	
	public void escribir(String nombre, int Puntaje, Boolean borrar) {
		try (BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta, borrar))){
			
			escribir.write(nombre + ";"+Puntaje);
			escribir.newLine();
			System.out.println("registro añadido con exito");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

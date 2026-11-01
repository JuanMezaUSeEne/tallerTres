package paquete;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


public class Archivo  {
	private File arch;
	private Scanner lectura;
	private String linea;
	private String ruta;

	
	
	public Archivo(String ruta) throws IOException {
		this.ruta = ruta;
		this.arch = new File(ruta);
		this.lectura = new Scanner(arch);

	}



	public String[] li() throws IOException {
		linea = lectura.nextLine();
		System.out.println(linea);
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
	
	
	
}

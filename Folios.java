package folios;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

	public class Folios {

		public static void main(String[] args)  {
		
		String directorioActual = System.getProperty("user.dir");
		String archivo = directorioActual + "/" + "folios.txt";
		List<String> listafolios = leerFolios(archivo);
		
		String folionuevo = crearFolio();
		listafolios.add(folionuevo);
		guardarArchivo(listafolios, archivo);			
	
		}
		
		
		
		//Metodo para leer el contenido existente del archivo
		private static List<String> leerFolios(String ubicacion){
			
		List<String> listafolios = new ArrayList<String>();
		
		try {
			File txt = new File(ubicacion);
			if(!txt.exists()) {
				txt.createNewFile();
			}
			
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(ubicacion));
				String linea = br.readLine();
				while(linea!=null) {
					listafolios.add(linea);
					linea = br.readLine();
				}
			}
			catch (IOException e) {
                e.printStackTrace();
            }
			finally {
                if (br != null) {
                    br.close();
                }
            }	
		}
		 catch (IOException e){}
		 return listafolios;
}
		
		
		
		//Metodo para guardar el folio dentro del archivo
		private static void guardarArchivo(List<String> listafolios, String ubicacion) {
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(ubicacion));
				for(String linea:listafolios) {
					bw.write(linea.toString() + "\r\n");
				}
				bw.close();
			}
			catch (IOException e) {}			
		}
		
		
		
		//Metodo para crear el folio
		private static String crearFolio() {
		char arr1[] = {'A', 'B', 'C', 'D', 'E', 'F'};
		int rand = 0;
		char folio[] = new char[26];
		String newfolio = new String(folio);
		for (int i = 0; i < 26; i++) {
			if (i == 9 || i == 18) {
				folio[i] = '-';
				}
			else if(i%2==0) {
				rand = (int)(Math.random()*9);
				folio[i] =(char)(rand+48);
			}else{
				rand = (int) (Math.random()*5);
				folio[i] = arr1[rand];
				}	
		}
		newfolio = new String(folio);
		return newfolio;	
	}
}



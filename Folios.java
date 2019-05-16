package folios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Folios {

	public static void main(String[] args)  {
		
		char arr1[] = {'A', 'B', 'C', 'D', 'E', 'F'};
		int rand = 0;
		char folio[] = new char[26];
		FileWriter file;
				
		for (int i = 0; i < 26; i++) {
			
			if (i == 9 || i == 18) {
				folio[i] = '-';
			}
			else if(i%2==0) {
				rand = (int)(Math.random()*9);
				folio[i] =(char)(rand+48);
			}else {
				rand = (int) (Math.random()*5);
				folio[i] = arr1[rand];
			}
		}
		for (char output:folio) {
			System.out.print(output);
		}
		
		try {
		file = new FileWriter("C:/Users/ijlq_/Desktop/nueva/file.txt");
		for(char output:folio) {
				file.write(output);
		}
		file.close();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}

	}
}
	
	
	



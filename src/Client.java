package soket;

//Yasin Torun.

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {

	public static void main(String[] args) {
		
		Socket s = null;
		
		Scanner scanf = new Scanner(System.in);
		
		int num, result = 0;
		
		//		 0	  1	   2	    3		4			
		String[] str = {"err", "doðru", "düþür", "yükselt", "yanlýþ-"};
		try {
			s = new Socket("localhost", 3333);

			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			
			while(result != 1 && result != 4)
			{
				System.out.print("1-10 Arasi Sayi girin: ");
				num = scanf.nextInt();
					
				pw.println(num);
				
				result = Integer.parseInt(br.readLine());
				
				if(result == 4)
					str[result] += br.readLine();
				
				System.out.println(str[result]);
				
			}
			scanf.close();
			s.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}

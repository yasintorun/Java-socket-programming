package soket;

//Yasin Torun.

import java.io.*;
import java.net.*;
import java.util.Random;
public class Server {

	public static void main(String[] args) {
	
		ServerSocket ss = null;
		
		int num, randomNumber, counter = 0;
		
		Random rand = new Random();
		
		randomNumber = rand.nextInt(10) + 1;
		
		try {
			ss = new ServerSocket(3333);
			Socket s = ss.accept();

			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			
			int r = 0;
			while(counter < 3 && r != 1)  {
				
				num = Integer.parseInt(br.readLine());
				
				if(num == randomNumber)
					r = 1;
				else
					if(counter == 2)
						r = 4;
					else
						r = num > randomNumber ? 2 : 3;

				pw.println(r);
				if(r == 4) // return true number for client.
					pw.println(randomNumber);
				
				counter++;
				
			}	
			s.close();
			ss.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

}

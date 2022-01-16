package Mypack;
import java.io.*;
import java.util.Scanner;

public class show
{
	Scanner sc = new Scanner (System.in);
	public void sh()
	{
		try{
			int t ;
			System.out.print("			Enter Your id -->> ");
			t = sc.nextInt();
			boolean f=false , j =true;
			while(j){
				BufferedReader r = new BufferedReader(new FileReader("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/Combined/Data.txt"));
				String temp = "";
		
				while((temp=r.readLine()) !=null)
				{
			
					String ref = temp;
					double k=0;
					String ss[]=ref.split("[#]",0);
					if(Integer.parseInt(ss[0]) == t)
					{
						try{new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();}catch(Exception e ){}
						j=false;
						f=true;
						System.out.println("			-----------------------------------------------------------");
						System.out.println("			| Name -->> " + ss[1]);
						System.out.println("			| ID -->> " + t);
						System.out.println("			| Phone Number -->> " + ss[2]);
						System.out.println("			| Adress -->> " + ss[3]);
						System.out.println("			| Working Hours -->> " + ss[4]);
						System.out.println("			| Grade -->> " + ss[5]);
						if(ss[5].charAt(0) == 'A')
						{
							A g = new A();
							k=g.calculate(Integer.parseInt(ss[4]));
						}
						else if(ss[5].charAt(0) == 'B')
						{
							B g = new B();
							k=g.calculate(Integer.parseInt(ss[4]));
						}
						else if(ss[5].charAt(0) == 'C')
						{
							C g = new C();
							k=g.calculate(Integer.parseInt(ss[4]));
						}
						System.out.println("			| Salary based on Over time and ETF and EPS is -->> " + k);
						System.out.println("			-----------------------------------------------------------");
						break;
					}
			
				}
				if(f) break;
				else 
				{
					System.out.println("			-------------------------------------------------------------------");
					System.out.print("			Not Found Please Enter Again -->>");
					t = sc.nextInt();
				}
			}
		}catch(Exception e) {}
	}
}
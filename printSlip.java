package Mypack;
import java.io.*;
import java.util.Scanner;

public class printSlip
{
	public void print(){
		Scanner sc = new Scanner (System.in);
		try{
			int t ;
			System.out.print("			Enter Your id -->>");
			t = sc.nextInt();
			boolean f=false , j =true;
			while(j){
				BufferedReader r = new BufferedReader(new FileReader("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/Combined/Data.txt"));
				String temp="";
				while((temp=r.readLine()) !=null)
				{
					String ref = temp;
					double sal=0;
					String ss[]=ref.split("[#]",0);
					if(Integer.parseInt(ss[0]) == t)
					{
						try{new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();}catch(Exception e ){}
						double k=0;
						File file  = new File ("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/EmployeeSlips/"+t+".txt");
						if(!file.exists()) 
							file.createNewFile();
						FileWriter writer = new FileWriter("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/EmployeeSlips/"+t+".txt");
						if(ss[5].charAt(0) == 'A')
						{
							A g = new A();
							k=g.calculate(Integer.parseInt(ss[4]));
							sal = 90000;
						}
						else if(ss[5].charAt(0) == 'B')
						{
							B g = new B();
							k=g.calculate(Integer.parseInt(ss[4]));
							sal = 75000;
						}
						else if(ss[5].charAt(0) == 'C')
						{
							C g = new C();
							k=g.calculate(Integer.parseInt(ss[4]));
							sal = 60000;
						}
						double overtime = Integer.parseInt(ss[4]) - (8*20);
						if(overtime <=0 ) 
						overtime=0;
             	writer.write("|----------------------------------------------------------------------------------------------------------------------------------|\n"+
             				 "|                                                                          XYZ  COMPANY                                                              |\n"+
             				 "|----------------------------------------------------------------------------------------------------------------------------------|\n"+
             				 "Name                       :- "+ss[1]+"\n"+
             				 "ID                             :- "+t+"\n"+
             			     "Phone Number       :- "+ss[2]+"\n"+
             				 "Address                  :- "+ss[3]+"\n"+
             				 "Working Hours      :- "+ss[4]+"\n"+			
             				 "Grade                     :- "+ss[5]+"\n\n"+
             				 "|----------------------------------------------------------------------------------------------------------------------------------|\n"+      
             				 "   Salary             :- \n\n"+
             				 "    		               Add                    Deduction\n\n"+
             				 "                           Over Time :-"+overtime * (double)(sal/(8*20))+"            ETF :-     "+ (sal*0.09)+"\n"+
             				 "                                                                      EPF :-     "+ (sal*0.03)+"\n\n"+
             				 "                                                   Final Salary "+ k );
                writer.close();
                System.out.println("		---------------------------------------------------");
                System.out.println("				Slip Successfully Made");
                System.out.println("		---------------------------------------------------");
                f=true;
                j=false;
                break;
			}
		}
		if(f) break;
			else 
			{
				System.out.println("			--------------------------------------");
				System.out.print("			Not Found Please Enter Again -->>");
				t = sc.nextInt();
			}
		}
		}catch(Exception e) {} 
		}		
}
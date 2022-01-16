package Mypack;
import java.io.*;
import java.util.Scanner;

public class employee implements EmpMeth
{
	    Scanner sc = new Scanner(System.in);

		protected String name,address,phNo;
		protected int workingHours,id;
		protected char grade;
		public void management()
		{
				try{new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();}catch(Exception e ){}
				while(true)
				{
					
					System.out.println("			---------------------------------------");
					System.out.println("			|           Enter your choice         |");
					System.out.println("			---------------------------------------");
					System.out.println("			| 1. Add                              |");
					System.out.println("			| 2. Modify                           |");
					System.out.println("			| 3. Delete                           |");
					System.out.println("			| 4. Go Back To Menu                  |");
					System.out.println("			---------------------------------------");
					System.out.print("			Your Input :: ");
					int ch = sc.nextInt();
					System.out.println();
					if(ch == 1){
							Add();
					}
					else if(ch == 2){
							Mod();
					}
					else if(ch == 3){
							Del();
					}
					else if(ch == 4){
							try{new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();}catch(Exception e ){}
							break;
					}
					else 
					{
						System.out.println("			Invalid Choice Enter Again ): -->>");
						System.out.println("			---------------------------------------");
					}
					
				}
		}
		public void Add()
		{
			System.out.println("			-------------------------------------------------");
			System.out.print  ("			Enter Name -->> ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.print  ("			Id -->> ");
			id = sc.nextInt();
			boolean ref9=true;
			try{
				while(ref9)
				{
					BufferedReader r = new BufferedReader(new FileReader("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/Combined/Data.txt"));
					String temp="";
					while((temp=r.readLine()) !=null)
					{
						String kp = temp;
						String ss[]=kp.split("[#]",0);
						if(Integer.parseInt(ss[0]) == id)
						{
							ref9=false;
							break;
						}
					}
					if(!ref9)
					{
						System.out.println("			-------------------------------------------------");
						System.out.print  ("			This ID is Already Exists Please Enter Again -->>");
						id = sc.nextInt();
						ref9 = true;
					}
					else break;

				} 
			}
			catch(Exception e){}
			System.out.print  ("			Phone Number -->> ");
			sc.nextLine();
			boolean ref = true;
			while(ref)
			{
				try{

					phNo = sc.nextLine();
					if(phNo.length() == 10) ref=false;
					else throw new InvalidNumberException("");
				}
				catch(InvalidNumberException e)
				{
					System.out.println("			-------------------------------------------------");
					System.out.print("			Not Valid (10 digits Only) Please Enter Again -->> ");
				}
				if(!ref) break;
			}
			System.out.print("			Address -->> ");
			address = sc.nextLine();
			System.out.print("			Working Hours -->> ");
			ref = true;
			while(ref)
			{
				try{
					workingHours = sc.nextInt();
					if(workingHours > 226) throw new InvalidWorkingHoursException ("");
					else ref = false;
				}
				catch(InvalidWorkingHoursException e)
				{
					System.out.println("			-------------------------------------------------");
					System.out.print("			Invalid Hours Please Enter Again -->> ");
				}
				if(!ref) break; 
			}
			System.out.print("			Enter Grade -->> ");
			ref = true;
			while(ref)
			{
				try{
					grade = sc.next().charAt(0);
					if(grade != 'A' && grade != 'B' && grade !='C') throw new InvalidGradeException("");
					else ref = false;
				}
				catch(InvalidGradeException e)
				{
					System.out.println("			-------------------------------------------------");
					System.out.print("			Invalid Grade (Only A,B and C) Enter Again -->> ");
				}
				if(!ref) break;
			}
			
			try
			{
				File file = new File("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/Combined/Data.txt");
				if(!file.exists()) 
					file.createNewFile();
				BufferedWriter p = new BufferedWriter(new FileWriter(file,true));
				String f = id+"#"+name+"#"+phNo+"#"+address+"#"+workingHours+"#"+grade+"#"+"\n";
				p.write(f);

				p.close();
				try{new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();}catch(Exception e ){}
				System.out.println("			---------------------------------------");
				System.out.println("				Susccessfully Added");
				System.out.println("			---------------------------------------");
			}
			catch(Exception e) {}
		}
		public void Mod()
		{

			try{
		
				System.out.print("			Enter Your id -->> ");
				int t;
				t = sc.nextInt();
				boolean as=false,as1=true;
				while(as1)
				{
					BufferedReader r = new BufferedReader(new FileReader("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/Combined/Data.txt"));
					String temp = "";
					String oldText="";
					String nt="";
					while((temp=r.readLine()) !=null)
					{
						oldText+=temp+"\n";
						String ref = temp;
						if(Integer.parseInt(ref.split("[#]",0)[0])==t) 
						{
							nt+=temp+"\n";
							as = true;
							as1= false;
						}
					}
					if(as)
					{
						System.out.print("			Enter New Name -->> ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.print("			Phone Number -->> ");
						boolean ref = true;
						while(ref)
						{
							try{

								phNo = sc.nextLine();
								if(phNo.length() == 10) ref=false;
								else throw new InvalidNumberException("");
							}
							catch(InvalidNumberException e)
							{
								System.out.println("		-------------------------------------------------");
								System.out.print("			Not Valid (Only 10 digits) Please Enter Again -->> ");
							}
						if(!ref) break;
						}
						System.out.print("			Address -->> ");
						String address = sc.nextLine();
						System.out.print("			Working Hours -->> ");
						ref = true;
						while(ref)
						{
							try{
								workingHours = sc.nextInt();
								if(workingHours > 226) throw new InvalidWorkingHoursException ("");
								else ref = false;
							}
							catch(InvalidWorkingHoursException e)
							{
								System.out.println("			-------------------------------------------------");
								System.out.print("			Invalid Hours Please Enter Again -->> ");
							}
							if(!ref) break; 
						}
						System.out.print("			Enter Grade -->> ");
						ref = true;
						while(ref)
						{
							try{
								grade = sc.next().charAt(0);
								if(grade != 'A' && grade != 'B' && grade !='C') throw new InvalidGradeException("");
								else ref = false;
							}
							catch(InvalidGradeException e)
							{
								System.out.println("			-------------------------------------------------");
								System.out.print("			Invalid Grade (Only A,B and C) Enter Again -->> ");
							}
							if(!ref) break;
						}
			
						String newText = t+"#"+name+"#"+phNo+"#"+address+"#"+workingHours+"#"+grade+"#"+"\n";
						newText = oldText.replace(nt,newText); 
						FileWriter writer = new FileWriter("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/Combined/Data.txt");
   				        writer.write(newText);
   			   		    writer.close();
    		        	r.close();
    		        	try{new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();}catch(Exception e ){}
    		        	System.out.println("			---------------------------------------");
    		        	System.out.println("				Successfully Updated");
    		        	System.out.println("			---------------------------------------");
    		    	}
        			else 
        			{
        				System.out.println("			-------------------------------------------------");
        				System.out.print ("			Not Found Please Enter Again -->> ");
        				t=sc.nextInt();
        			}
				}
			}catch(Exception e) {}
		}
		public void Del()
		{
			try{
				boolean as=false,as1=true;
				System.out.print("			Enter Your id -->> ");
				int t;
				t = sc.nextInt();
				while(as1)
				{
					BufferedReader r = new BufferedReader(new FileReader("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/Combined/Data.txt"));
					String temp = "";
					String oldText="";
					while((temp=r.readLine()) !=null)
					{
						String ref = temp;
						if(Integer.parseInt(ref.split("[#]",0)[0]) != t) 
						{
							oldText+=temp+"\n";
						}	
						else 
						{
							as = true;
							as1 = false;
						}	 
					}
					if(as)
					{
						FileWriter writer = new FileWriter("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/Combined/Data.txt");
             			writer.write(oldText);
            			writer.close();
           				r.close();
            			File file  =  new File("C:/Users/ASIM VORA/Desktop/fpayroll/All Data/EmployeeSlips/"+t+".txt");
           		 		if(file.exists()) file.delete();
           		 		try{new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();}catch(Exception e ){}
           		 		System.out.println("			---------------------------------------");
          		 		System.out.println("				Successfully Deleted");
            			System.out.println("			---------------------------------------");
         			}
         			else 
         			{
         				System.out.println("			-------------------------------------------------");
         				System.out.print("			Not Found Please Enter Again -->> ");
        				t=sc.nextInt();	
         			}
				}
			}catch(Exception e) {}
		}
}
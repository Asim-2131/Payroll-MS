package Mypack1;
import java.io.*;
import java.util.Scanner;
import Mypack.*;

public class Payroll
{
	public static void clrscr()
	{
		try{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();}catch(Exception e ){}
	}
	public static void main(String[] args) {
		clrscr();
		System.out.println("	  ----------------------------------------------------------------");
		System.out.println("			 Welcome To Payroll Management System");
		System.out.println("	  ----------------------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		
		boolean u = true;
		while(u)
		{
			System.out.println("			---------------------------------------");
			System.out.println("			|    __Enter choice what you want__   |");
			System.out.println("			---------------------------------------");
			System.out.println("			| 1.  <<--  Manage Employee  -->>>    |");
			System.out.println("			| 2.  <<--  Show Report  -->>>        |");
			System.out.println("			| 3.  <<--  Print Slip  -->>>         |");
			System.out.println("			| 4.  <<--  Close  -->>>              |");
			System.out.println("			---------------------------------------");
			System.out.print("			Your Input :: ");
			int ch = sc.nextInt();
			switch(ch){
			case 1:
			{
					employee e = new employee();
					e.management();
					break;
			}
			case 2:
			{
					show s = new show();
					s.sh();
					break;
			}
			case 3:
			{
					printSlip p= new printSlip();
					p.print();
					break;
			}
			case 4:
			{
				u = false;
				break;
			}
			default: 
			{
				System.out.println("			Invalid Choice Please Enter Again ): -->> ");
				System.out.println("			---------------------------------------");
				break;
			}
			}
		}
	}
}
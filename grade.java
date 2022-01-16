package Mypack;
import java.io.*;
import java.util.Scanner;

public class grade
{
	double epf;
	double etf;
	int oth;
	double otr, ot;
	double result;
	void calculate(int  p,double f)
	{
		epf = 0.09 * f;
		etf = 0.03 * f;
		oth = p - 8*20;
		otr = f / (8*20);
		if(oth > 0)  ot = (double)(oth*otr);
		else 
		{
			ot =0;
			oth= 0;
		}
		result = f-(etf+epf) + ot;
	}
}



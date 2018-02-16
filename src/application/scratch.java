package application;

import java.util.Scanner;

public class scratch {
	public static void main(String...strings ){
		System.out.println(operate(-9838));
	}
	
	public static double operate(double in) {
		if(in%1 != 0) throw new ArithmeticException();
		String d;
	
		
			d = String.valueOf((int)Math.abs((int)in));
		
		StringBuilder db = new StringBuilder();
		for(int i=d.length()-1; i>=0 ; i-- ){
			db.append(d.charAt(i));
		}
		
		if(in>=0) return Double.parseDouble(new String(db));
		else return Double.parseDouble(new String(db))*-1;
	}
	
}

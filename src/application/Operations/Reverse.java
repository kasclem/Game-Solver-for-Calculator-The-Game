package application.Operations;

public class Reverse implements Operations{
	
	public Reverse(){
		
	}
	@Override
	public double operate(double in) {
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
	public String toString(){
		return "Reverse";
	}

}

package application.Operations;

public class Append implements Operations {
	private String appendage;
	
	public Append( int appendage){
		
		this.appendage = String.valueOf(appendage);
	}
	
	@Override
	public double operate(double in) {
		// TODO Auto-generated method stub
		if(in%1 != 0) throw new ArithmeticException();
		return Double.parseDouble( String.valueOf( (int)in ).concat(appendage)  );
	}
	

	public String toString(){
		return String.format("append %s", appendage);
	}

}

package application.Operations;

public class NegToggle implements Operations {
		
	public NegToggle(){
		
	}
	@Override
	public double operate(double in) {
		// TODO Auto-generated method stub
		return in*-1;
	}
	
	public String toString(){
		return "negate";
	}
	
}

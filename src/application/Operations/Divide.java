package application.Operations;

public class Divide implements Operations {
	private int divisor;
	
	public Divide(int divisor){
		
		this.divisor = divisor;
		
	}

	@Override
	public double operate(double in) {
		// TODO Auto-generated method stub
		return in/divisor;
	}
	

	public String toString(){
		return String.format("divide by %d", divisor);
	}

}

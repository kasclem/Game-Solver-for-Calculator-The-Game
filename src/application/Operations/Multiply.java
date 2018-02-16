package application.Operations;

public class Multiply implements Operations {
	int factor;
	
	public Multiply(int factor){
		this.factor = factor;
		
	}

	@Override
	public double operate(double in) {
		// TODO Auto-generated method stub
		return factor*in;
	}

	public String toString(){
		return String.format("multiply by %d", factor);
	}

	
}

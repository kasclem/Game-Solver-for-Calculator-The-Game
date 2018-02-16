package application.Operations;

public class Exponent implements Operations {
	private int exp;
	public Exponent(int exp){
		this.exp = exp;
	}
	@Override
	public double operate(double in) {
		return  Math.pow(in, exp);
	}
	
	public String toString(){
		return String.format("raise to %s", exp);
	}
	
}

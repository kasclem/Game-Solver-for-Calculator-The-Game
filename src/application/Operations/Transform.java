package application.Operations;

public class Transform implements Operations{
	private String from, to;
	
	public Transform(int from, int to){
		this.from = String.valueOf(from);
		this.to = String.valueOf(to);
		
	}
	@Override
	public double operate(double in) {
		if(in%1 != 0) throw new ArithmeticException();
		String input = String.valueOf(in);
		return Double.parseDouble(input.replaceAll(from, to));
	}
	
	public String toString(){
		return String.format("Transform %s to %s", from, to);
	}
	

}

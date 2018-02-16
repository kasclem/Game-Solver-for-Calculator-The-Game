package application.Operations;

public class Add implements Operations {
	int addend;
	
	public Add(int addend){
		this.addend = addend;		
	}
	
	@Override
	public double operate(double in) {
		// TODO Auto-generated method stub
		return in + addend;
	}
	

	public String toString(){
		return String.format("add %d", addend);
	}

}

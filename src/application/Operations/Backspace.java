package application.Operations;

public class Backspace implements Operations {
	
	
	public Backspace(){

	}


	@Override
	public double operate(double in) {
		// TODO Auto-generated method stub
		return (int)in/10;
	}
	

	public String toString(){
		return "backspace";
	}

}

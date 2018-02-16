package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import application.Operations.Add;
import application.Operations.Append;
import application.Operations.Backspace;
import application.Operations.Divide;
import application.Operations.Exponent;
import application.Operations.Multiply;
import application.Operations.NegToggle;
import application.Operations.Operations;
import application.Operations.Reverse;
import application.Operations.Transform;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    private CheckBox cBoxNegToggle;

    @FXML
    private CheckBox cBoxBackspace;

    @FXML
    private CheckBox cBoxAdd;

    @FXML
    private CheckBox cBoxMult;

    @FXML
    private CheckBox cBoxDiv;

    @FXML
    private CheckBox cBoxAppend;

    @FXML
    private TextField txtAdd;

    @FXML
    private TextField txtMultiply;

    @FXML
    private TextField txtDivide;
    
    @FXML
    private CheckBox cBoxExp;
    
    @FXML
    private TextField txtExp;
    
    @FXML
    private TextField txtAppend;

    @FXML
    private CheckBox cBoxTransform;

    @FXML
    private Button btnAddTransform;

    @FXML
    private Button btnDelTrans;
    
    @FXML
    private VBox transformPane;

    @FXML
    private TextField txtGoal;

    @FXML
    private TextField txtStart;

    @FXML
    private Spinner<Integer> spnMoves;
    
    @FXML
    private CheckBox cBoxReverse;
    
  
    @FXML
    private Button btnSolve;

    @FXML
    private TextArea areaOutput;
    
    
    private List<Operations> list = new ArrayList<>();
    private Stack<Operations> orderedMoves = new Stack<>();
    int movesOrig;
    
    public Controller() {
    		
	}
    
    @FXML
	void initialize() {
    		initButtons();
    		SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, 1, 1);		
		factory.setValue(1);
		spnMoves.setValueFactory(factory);    		
    		
    }
    
    private void initButtons() {
    	
    		btnAddTransform.setOnAction(e -> {
    			new TransformBox(transformPane);
    		});
    		btnDelTrans.setOnAction(e -> {
    			transformPane.getChildren().remove(transformPane.getChildren().size()-1);
    		});
    		btnSolve.setOnAction(e->{
    			list.clear();
    			orderedMoves.clear();
    			areaOutput.clear();
    			
    			addAll();
    			int goal = Integer.parseInt(txtGoal.getText());
    			double start = Double.parseDouble(txtStart.getText());
    			movesOrig = spnMoves.getValue();
    			int moves = movesOrig;
    			try {
					if(!search(goal, start, moves, 0)){
						areaOutput.setText("No moves found");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    			while(!orderedMoves.isEmpty()){
    				areaOutput.appendText("\n"+orderedMoves.pop().toString());
    			}
    			clearAll(txtAdd, txtAppend, txtDivide, txtExp, txtMultiply, cBoxAdd, cBoxAppend, cBoxBackspace, cBoxDiv
    					, cBoxExp, cBoxMult, cBoxNegToggle, cBoxReverse, cBoxTransform);
    		});
	}
    
    
	private void clearAll(Node...nodes) {
		for(Node x : nodes){
			if(x instanceof CheckBox){
				((CheckBox) x).setSelected(false);
			}if(x instanceof TextField){
				((TextField) x).clear();
			}
		}
	}

	private boolean search(int goal, double start, int moves, int i) throws IOException {		
		try{
		if(goal == start) return true;
		if(moves == 0) return false;
		if(i> list.size()*movesOrig) return false;
		
		int index = i%list.size();
		Operations operation = list.get(index);
		
		if(search(goal, operation.operate(start), moves-1, i+1) ){
			orderedMoves.push(operation);
			return true;
		}
		if(search(goal, start, moves, i+1)) return true;
		
		
		return false;
		}
		catch(Exception e){
			return false;
		}
	}

	public void addAll(){
    		Scanner sc = null;
    		System.out.println(cBoxTransform.isSelected());
    		if(cBoxAdd.isSelected()){
    			sc = new Scanner(txtAdd.getText());
    			while( sc.hasNext() ){
    				list.add(new Add(sc.nextInt()));
    			}
    		}
    		if(cBoxReverse.isSelected()){
    			list.add(new Reverse());
    		}
    		if(cBoxExp.isSelected()){
    			sc = new Scanner(txtExp.getText());
    			while(sc.hasNext()){
    				list.add(new Exponent(sc.nextInt()));
    			}
    		}
    		if(cBoxAppend.isSelected()){
    			sc = new Scanner(txtAppend.getText());
    			while(sc.hasNextInt()){
    				list.add(new Append(sc.nextInt()));
    			}
    		}
    		
    		if(cBoxBackspace.isSelected()){
    			list.add(new Backspace());
    		}
    		if(cBoxDiv.isSelected()){
    			sc = new Scanner(txtDivide.getText());
    			while(sc.hasNextInt()){
    				list.add(new Divide(sc.nextInt()));
    			}
    		}
    		
    		if(cBoxMult.isSelected()){
    			sc = new Scanner(txtMultiply.getText());
    			while(sc.hasNext()){
    				list.add(new Multiply(sc.nextInt()));
    			}
    		}
    		
    		if(cBoxNegToggle.isSelected()){
    			list.add(new NegToggle());
    		}
    		if(cBoxTransform.isSelected()){
    			for(Node x : transformPane.getChildren()){
    				int from = Integer.parseInt(((TransformBox)x).from.getText());
    				int to = Integer.parseInt(((TransformBox)x).to.getText());
    				list.add(new Transform(from, to));
    			}
    		}
    		try{
    		sc.close();}
    		catch(NullPointerException e){
    			
    		}
    }

    
	public void setMainApp(Main main) {
		
	}

}

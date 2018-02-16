package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TransformBox extends HBox {
	TextField from, to;
	Label arrow = new Label("=>");
	VBox parent;
	public TransformBox(VBox parent){		
		this.parent = parent;
		from = new TextField();
		from.setPrefWidth(75);
		to = new TextField();
		to.setPrefWidth(75);
		arrow.setPrefWidth(20);
		this.getChildren().addAll(from, arrow, to);
		this.setMargin(arrow, new Insets(0, 5, 0, 5));
		parent.getChildren().add(this);
	}
	
	public void deleteBox(){
		parent.getChildren().remove(this);
	}
}

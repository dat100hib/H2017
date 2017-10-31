package no.hvl.dat100.utsyn.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditArea {

	public EditArea() {
	
		VBox rightvbox = new VBox();
		rightvbox.setPadding(new Insets(10, 0, 0, 10));
		GridPane gridpane = new GridPane();
		TextField gnsfield = new TextField();
		TextField bnsfield = new TextField();
		gnsfield.setPrefWidth(800);
		bnsfield.setPrefWidth(80);
		
		TextField eierfield = new TextField();
		TextField nabofield = new TextField();
		
		Label gnslabel = new Label("GNS");
		Label bnslabel = new Label("BNS");
		Label eierlabel = new Label("Eier");
		Label nabolabel = new Label("Nabo");
		
		gridpane.add(gnslabel, 0, 0);
		gridpane.add(gnsfield, 1, 0);
		
		gridpane.add(bnslabel, 0, 1);
		gridpane.add(bnsfield, 1, 1);
		
		gridpane.add(eierlabel, 0, 2);
		gridpane.add(eierfield, 1, 2);
		
		gridpane.add(nabolabel, 0, 3);
		gridpane.add(nabofield, 1, 3);
		// TODO Auto-generated constructor stub
		

		HBox buttonhbox = new HBox();
		buttonhbox.setPadding(new Insets(10, 0, 0, 10));
		
		Button newbutton = new Button("New");
		Button editbutton = new Button("Edit");
		Button deletebutton = new Button("Delete");
		
		buttonhbox.getChildren().addAll(newbutton,editbutton,deletebutton);
		
		rightvbox.getChildren().addAll(label,gridpane,buttonhbox);
		hbox.getChildren().addAll(elist, rightvbox);
	}

}

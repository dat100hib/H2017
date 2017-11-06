package no.hvl.dat100.utsyn.gui;

import java.util.Collection;
import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Separator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import no.hvl.dat100.kontroll.Kontroll;
import no.hvl.dat100.modell.Eiendom;

public class EditArea {

	private Kontroll kontroll = null;
	
	public EditArea(HBox hbox, Kontroll kontroll) {
	
		this.kontroll = kontroll;
		
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 0, 0, 10));
		
		GridPane eiendomgp = new GridPane();
		eiendomgp.setPadding(new Insets(10, 10, 10, 10));
		eiendomgp.setHgap(10); 
		eiendomgp.setVgap(10);
		
		Label gnslabel = new Label("gns");
		Label bnslabel = new Label("bns");
		
		TextField gnsfield = new TextField();
		TextField bnsfield = new TextField();
		bnsfield.setPrefWidth(50);
		gnsfield.setPrefWidth(50);
		
		HBox gnsbnshbox = new HBox();
		//gnsbnshbox.setPadding(new Insets(10, 10, 10, 10));
		gnsbnshbox.setSpacing(5);
		
		gnsbnshbox.getChildren().addAll(gnsfield,bnslabel,bnsfield);
		
		eiendomgp.add(gnslabel, 0, 0);
		eiendomgp.add(gnsbnshbox, 1, 0);
		
		Separator separator1 = new Separator();
		
		TextField navnfield = new TextField();
		Label navnlabel = new Label("Navn");
		
		eiendomgp.add(navnlabel, 0, 1);
		eiendomgp.add(navnfield, 1, 1);
		
		TextField fodselsnrfield = new TextField();
		Label fodselnrlabel = new Label("Fødnr");
		eiendomgp.add(fodselnrlabel, 0, 2);
		eiendomgp.add(fodselsnrfield, 1, 2);
				
		Separator separator2 = new Separator();
		
		TextField veinrfield = new TextField();
		Label veinrlabel = new Label("Nr");
		veinrfield.setPrefWidth(50);
		
		TextField veinavnfield = new TextField();
		Label veinavnlabel = new Label("Vei");
		
		HBox veihbox = new HBox(veinavnfield,veinrfield,veinrlabel);
		veihbox.setSpacing(5);
		
		eiendomgp.add(veinavnlabel, 0, 3);
		eiendomgp.add(veihbox, 1, 3);
		
		TextField byfield = new TextField();
		Label bylabel = new Label("By");
		
		TextField postfield = new TextField();
		Label postlabel = new Label("Postnr");
		postfield.setPrefWidth(50);
		
		HBox byhbox = new HBox(byfield,postfield,postlabel);
	    byhbox.setSpacing(5);
		
		eiendomgp.add(bylabel, 0, 4);
		eiendomgp.add(byhbox, 1, 4);
		
		TextField landfield = new TextField();
		Label landlabel = new Label("Land");
	
		eiendomgp.add(landlabel, 0, 5);
		eiendomgp.add(landfield, 1, 5);
		
		Separator separator3 = new Separator();
		
		RadioButton utleiebtn = new RadioButton("Utleieeiendom");
        RadioButton neringsbtn = new RadioButton("Næringseiendom");
 
        ToggleGroup radioGroup = new ToggleGroup();

        utleiebtn.setToggleGroup(radioGroup);
        neringsbtn.setToggleGroup(radioGroup);
        utleiebtn.setPadding(new Insets(10, 10, 10, 10));
        neringsbtn.setPadding(new Insets(10, 10, 10, 10));
        
        HBox typehbox = new HBox(utleiebtn, neringsbtn);
        
        GridPane typepane = new GridPane();
        
		TextField leiefield = new TextField();
		Label leielabel = new Label("Leie");
		
		TextField fodnrfield = new TextField();
		Label fodnrlabel = new Label("Fødnr");
		
		TextField orgnrfield = new TextField();
		Label orgnrlabel = new Label("Orgnr");
		
		typepane.add(leielabel, 0, 0);
		typepane.add(leiefield, 1, 0);
		typepane.add(fodnrlabel, 0, 1);
		typepane.add(fodnrfield, 1, 1);
		typepane.add(orgnrlabel, 0, 2);
		typepane.add(orgnrfield, 1, 2);
		typepane.setPadding(new Insets(10, 10, 10, 10));
		typepane.setHgap(10); 
		typepane.setVgap(10);
		
		HBox buttonhbox = new HBox();
		buttonhbox.setSpacing(10);
		buttonhbox.setPadding(new Insets(10, 10, 10, 10));
		
		Button newbutton = new Button("New");
		newbutton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	
		    	System.out.println("New");

		    	// clear all fields
		    }
		});
		
		Button editbutton = new Button("Edit");
		editbutton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	
		    	System.out.println("Edit");
		    	// alle elementer editerbare
		    	
		    }
		});

		Button okbutton = new Button("OK");
		okbutton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	
		    	System.out.println("OK");
		    	// les data
		    	
		    }
		});
		
		buttonhbox.getChildren().addAll(newbutton,editbutton,okbutton);
		
		
		
		vbox.getChildren().addAll(separator1,
				                  eiendomgp,separator2,
				                  typehbox,
								  typepane,separator3,
				                  buttonhbox);
		hbox.getChildren().addAll(vbox);	
		
	}

}

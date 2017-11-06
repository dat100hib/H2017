package no.hvl.dat100.utsyn.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import no.hvl.dat100.kontroll.Kontroll;
import no.hvl.dat100.modell.Eiendom;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class OverviewArea {

	private Kontroll kontroll;
	private ListView<String> elist;
	
	public OverviewArea(HBox hbox, Kontroll kontroll) {
	
		this.kontroll = kontroll;
		
		elist = new ListView<String>();
		
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 0, 0, 10));
				
		elist.setPrefHeight(500);
		Button updatebtn = new Button("Update");
		
		updatebtn.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	
		    	System.out.println("Update pressed");
		    	 
		    	update();
		    	
		    }
		});
		
		elist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        
		    	if (newValue != null) { // selection changed also triggered on clear
		    	Scanner sc = new Scanner(newValue);
		    	int gns = sc.nextInt();
		    	int bns = sc.nextInt();
		    	
		    	sc.close();
		    	
		    	System.out.println(gns + " " + bns);
		    	}
		    	// TODO: kall metode i EditArea
		    	//Eiendom eiendom = kontroll.finnEiendom(gns, bns);
		    	
		    	
		    }
		});
		
		vbox.getChildren().addAll(elist,updatebtn);
		hbox.getChildren().add(vbox);
	}
	
	public void update() {
		
		Collection<Eiendom> eiendommer = kontroll.getEiendommer();
	       
        Iterator<Eiendom> eit = eiendommer.iterator();
        System.out.println("update: " + eiendommer.size());
        elist.getItems().clear();
        //TODO: clear also editarea
        while (eit.hasNext()) {
        	Eiendom e = eit.next();
        	int gns = e.getGns();
        	int bns = e.getBns();
        	elist.getItems().add(gns + " " + bns);
        }
	}
}

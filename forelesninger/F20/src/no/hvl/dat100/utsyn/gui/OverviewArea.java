package no.hvl.dat100.utsyn.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import no.hvl.dat100.kontroll.Kontroll;
import no.hvl.dat100.modell.Eiendom;
import java.util.Collection;
import java.util.Iterator;

public class OverviewArea {

	private Kontroll kontroll;
	
	public OverviewArea(HBox hbox, Kontroll kontroll) {
	
		this.kontroll = kontroll;
		
		ListView<String> elist = new ListView<String>();
		
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 0, 0, 10));
		
		Label label = new Label("Eiendommer");
		
		elist.getItems().add("Item 1");
		elist.getItems().add("Item 2");
		elist.getItems().add("Item 3");
    
		Button updatebtn = new Button("Update");
		
		updatebtn.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	
		    	System.out.println("Update pressed");
		    	 
		    	Collection<Eiendom> eiendommer = kontroll.getEiendommer();
		       
		        Iterator<Eiendom> eit = eiendommer.iterator();
		        
		        while (eit.hasNext()) {
		        	Eiendom e = eit.next();
		        	int gns = e.getGns();
		        	int bns = e.getBns();
		        	elist.getItems().add(gns + " " + bns);
		        }
		    	
		    }
		});
		
		vbox.getChildren().addAll(label,elist,updatebtn);
		hbox.getChildren().add(vbox);
	}
}

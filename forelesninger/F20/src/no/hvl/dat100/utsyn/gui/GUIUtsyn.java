package no.hvl.dat100.utsyn.gui;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import no.hvl.dat100.kontroll.Kontroll;

public class GUIUtsyn extends Application {

	private static String CSSFILE = "Dark.css";
	private Kontroll kontroll;
	
	public void setKontroll(Kontroll kontroll) {
		this.kontroll = kontroll;
	}
		
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Eiendomsregister App");

		this.kontroll = new Kontroll();
		
		// hbox for holding the overview and the edit area
		HBox hbox = new HBox();
		
		// setup the overview area
		OverviewArea oarea = new OverviewArea(hbox,kontroll);
		
		EditArea earea = new EditArea(hbox,kontroll,oarea);
		oarea.setEArea(earea);
		
		// setup the menus
		Menus menus = new Menus(kontroll,stage,oarea,earea);
		MenuBar menuBar = menus.getMenuBar();

		// create the scene
		VBox vbox = new VBox(menuBar, hbox); 
		
		Scene scene = new Scene(vbox, 700, 600);
		stage.setScene(scene);
		
		// styling the look-and-feel of the UI
		scene.getStylesheets().add(getClass().getResource(CSSFILE).toExternalForm());
		
		// show the scene
		stage.show();

	}
}
package no.hvl.dat100.utsyn.gui;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.MenuBar;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import no.hvl.dat100.kontroll.Kontroll;
import no.hvl.dat100.main.IUtsyn;

public class GUIUtsyn extends Application implements IUtsyn {

	private static String CSSFILE = "Dark.css";
	private Kontroll kontroll;
	
	public void setKontroll(Kontroll kontroll) {
		this.kontroll = kontroll;
	}
	
	public void kjor() {
		String[] args = null;
		Application.launch(args);
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Eiendomsregister App");

		this.kontroll = new Kontroll();
		
		VBox vbox = new VBox(); // TODO: directly use HBOX?
		Scene scene = new Scene(vbox, 600, 400);
		
		//scene.getStylesheets().add(getClass().getResource(CSSFILE).toExternalForm());
		
		AnchorPane anchorpane = new AnchorPane();
		
		HBox hbox = new HBox();
		
		OverviewArea oarea = new OverviewArea(hbox,kontroll);
		EditArea earea = new EditArea(hbox,kontroll);
		
		anchorpane.getChildren().addAll(hbox);

		Menus menus = new Menus(kontroll,stage);
		MenuBar menuBar = menus.getMenuBar();

		((VBox) scene.getRoot()).getChildren().addAll(menuBar, anchorpane);

		stage.setScene(scene);
		stage.show();

	}
}
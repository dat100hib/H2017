package no.hvl.dat100.utsyn.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import no.hvl.dat100.modell.Eiendom;
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
		
		VBox vbox = new VBox();
		Scene scene = new Scene(vbox, 600, 400);
		//scene.getStylesheets().add(getClass().getResource(CSSFILE).toExternalForm());
		
		AnchorPane anchorpane = new AnchorPane();
		
		// HBOX 
		HBox hbox = new HBox();
		
		// https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
		/*	
		TableColumn<Eiendom,Integer> gnsCol = new TableColumn<Eiendom,Integer>("Gårdsnummer");
		TableColumn<Eiendom,Integer> bnsCol = new TableColumn<Eiendom,Integer>("Bruksnummer");

		TableView<Eiendom> table = new TableView<Eiendom>();

		table.getColumns().addAll(gnsCol, bnsCol);
*/
		ListView elist = new ListView();
		
		elist.getItems().add("Item 1");
        elist.getItems().add("Item 2");
        elist.getItems().add("Item 3");
        
	    //elist.setOnMouseClicked(value);
	 
		VBox rightvbox = new VBox();
		rightvbox.setPadding(new Insets(10, 0, 0, 10));
		
		Label label = new Label("Eiendom");

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
		
		HBox buttonhbox = new HBox();
		buttonhbox.setPadding(new Insets(10, 0, 0, 10));
		
		Button newbutton = new Button("New");
		Button editbutton = new Button("Edit");
		Button deletebutton = new Button("Delete");
		
		buttonhbox.getChildren().addAll(newbutton,editbutton,deletebutton);
		
		rightvbox.getChildren().addAll(label,gridpane,buttonhbox);
		hbox.getChildren().addAll(elist, rightvbox);

		anchorpane.getChildren().addAll(hbox);

		Menus menus = new Menus(kontroll);
		MenuBar menuBar = menus.getMenuBar();

		((VBox) scene.getRoot()).getChildren().addAll(menuBar, anchorpane);

		stage.setScene(scene);
		stage.show();

	}
}
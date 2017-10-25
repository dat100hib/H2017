package no.hvl.dat100.utsyn.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GUI extends Application {

	private static String CSSFILE = "Dark.css";
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Eiendomsregister App");

		VBox vbox = new VBox();
		Scene scene = new Scene(vbox, 400, 350);
		scene.getStylesheets().add(getClass().getResource(CSSFILE).toExternalForm());
		
		AnchorPane anchorpane = new AnchorPane();
		HBox hbox = new HBox();

		TableColumn firstNameCol = new TableColumn("First Name");
		TableColumn lastNameCol = new TableColumn("Last Name");
		TableColumn emailCol = new TableColumn("Email");

		TableView table = new TableView();

		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

		Label label = new Label("My Label");

		hbox.getChildren().addAll(table, label);

		anchorpane.getChildren().addAll(hbox);

		//
		MenuBar menuBar = new MenuBar();

		// --- File Menu
		Menu menuFile = new Menu("File");

		MenuItem newItem = new MenuItem("New...");

		EventHandler<ActionEvent> newhandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("TODO: New ...");
			}
		};
		
		newItem.setOnAction(newhandler);
		
		MenuItem importItem = new MenuItem("Import...");
		EventHandler<ActionEvent> importhandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("TODO: Import ...");
			}
		};
		newItem.setOnAction(importhandler);
		
		MenuItem exportItem = new MenuItem("Export...");
		
		EventHandler<ActionEvent> exporthandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("TODO: Importing file...");
			}
		};

		exportItem.setOnAction(exporthandler);

		menuFile.getItems().addAll(newItem, importItem, exportItem);

		// --- Menu About
		Menu menuHelp = new Menu("Help");
		
		MenuItem aboutItem = new MenuItem("About");
		
		EventHandler<ActionEvent> abouthandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("About");
				alert.setHeaderText("Version 1.0");
				alert.setContentText("Eiendomsregister applikasjon");

				alert.showAndWait();
			}
		};
		
		aboutItem.setOnAction(abouthandler);
		
		menuHelp.getItems().add(aboutItem);
		
		menuBar.getMenus().addAll(menuFile, menuHelp);

		
		
		((VBox) scene.getRoot()).getChildren().addAll(menuBar, anchorpane);

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
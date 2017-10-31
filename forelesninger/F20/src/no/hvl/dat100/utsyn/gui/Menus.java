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
import javafx.scene.control.TextInputDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Optional;

import no.hvl.dat100.kontroll.Kontroll;

public class Menus {

	private MenuBar menuBar;
	
	private Kontroll kontroll;

	public Menus(Kontroll kontroll) {

		menuBar = new MenuBar();
		this.kontroll = kontroll;
		
		// File Menu
		Menu menuFile = new Menu("File");

		MenuItem newItem = new MenuItem("New...");

		EventHandler<ActionEvent> newhandler = new EventHandler<ActionEvent>() {
			
			// private Kontroll hkontroll = kontroll;
			
			@Override
			public void handle(ActionEvent e) {
				
				TextInputDialog dialog = new TextInputDialog("");
				dialog.setTitle("Nytt register");
				dialog.setHeaderText("Kommune");
				dialog.setContentText("Navn:");

				Optional<String> result = dialog.showAndWait();
				
				if (result.isPresent()){
					String kommune = result.get();
					System.out.println(kommune);
					kontroll.nyttRegister(kommune);
				}
				
			}
		};

		newItem.setOnAction(newhandler);

		MenuItem importItem = new MenuItem("Import...");
		EventHandler<ActionEvent> importhandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("TODO: Importing ...");
			}
		};
		
		importItem.setOnAction(importhandler);

		MenuItem exportItem = new MenuItem("Export...");

		EventHandler<ActionEvent> exporthandler = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				System.out.println("TODO: Exporting ...");
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
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}
}

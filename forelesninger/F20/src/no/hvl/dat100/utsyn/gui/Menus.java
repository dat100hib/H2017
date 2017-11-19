package no.hvl.dat100.utsyn.gui;


import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;

import javafx.scene.control.TextInputDialog;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Optional;
import java.io.File;

import no.hvl.dat100.kontroll.Kontroll;

public class Menus {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/lagring/";
	
	private MenuBar menuBar;

	private Kontroll kontroll;
	private Stage stage;
    private OverviewArea oarea;
    private EditArea earea;
    
	public Menus(Kontroll kontroll, Stage stage, OverviewArea oarea, EditArea earea) {

		menuBar = new MenuBar();
		this.kontroll = kontroll;
		this.stage = stage;
		this.oarea = oarea;
		this.earea = earea;
		
		// File Menu
		Menu menuFile = new Menu("File");

		MenuItem newItem = new MenuItem("New...");

		EventHandler<ActionEvent> newhandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				TextInputDialog dialog = new TextInputDialog("");
				dialog.setTitle("Nytt register");
				dialog.setHeaderText("Kommune");
				dialog.setContentText("Navn:");

				Optional<String> result = dialog.showAndWait();

				if (result.isPresent()) {
					String kommune = result.get();
					System.out.println(kommune);
					kontroll.nyttRegister(kommune);
					oarea.update();
				}

			}
		};

		newItem.setOnAction(newhandler);

		MenuItem importItem = new MenuItem("Import...");
		EventHandler<ActionEvent> importhandler = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {

				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Importer register datafil");
				File filedir = new File(MAPPE);
				fileChooser.setInitialDirectory(filedir);
				fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Data Files", "*.dat"));
				
				File selectedFile = fileChooser.showOpenDialog(stage);

				if (selectedFile != null) {
					System.out.println(selectedFile.getAbsolutePath());
					kontroll.importerRegister(selectedFile.getAbsolutePath());
					oarea.update();
					earea.clearFields();

				}
			}
		};

		importItem.setOnAction(importhandler);

		MenuItem exportItem = new MenuItem("Export...");

		EventHandler<ActionEvent> exporthandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Eksporter register datafil");
				File filedir = new File(MAPPE);
				fileChooser.setInitialDirectory(filedir);
				fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Data Files", "*.dat"));
				
				File selectedFile = fileChooser.showSaveDialog(stage);

				if (selectedFile != null) {
					System.out.println(selectedFile.getAbsolutePath());
					kontroll.eksporterRegister(selectedFile.getAbsolutePath());
				}
			}
		};

		exportItem.setOnAction(exporthandler);
		
		MenuItem exitItem = new MenuItem("Exit");

		EventHandler<ActionEvent> exithandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				Platform.exit();
				
			}
		};

		exitItem.setOnAction(exithandler);

		menuFile.getItems().addAll(newItem, importItem, exportItem,exitItem);

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

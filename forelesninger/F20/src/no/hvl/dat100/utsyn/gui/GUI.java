package no.hvl.dat100.utsyn.gui;

import javafx.application.Application;
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

public class GUI extends Application {

    @Override
        public void start(Stage stage) throws Exception {
        stage.setTitle("Eiendomsregister App");

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 400, 350);
        
        AnchorPane anchorpane = new AnchorPane();
        HBox hbox = new HBox();
        
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        
        TableView table = new TableView();
        
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        
        Label label = new Label("My Label");
        
        hbox.getChildren().addAll(table,label);
        
        anchorpane.getChildren().addAll(hbox);
        
        //
        MenuBar menuBar = new MenuBar();
 
        // --- Menu File
        Menu menuFile = new Menu("File");
 
        MenuItem openItem = new MenuItem("Open...");
        MenuItem saveItem = new MenuItem("Save...");
        MenuItem exitItem = new MenuItem("Exit");
        
        menuFile.getItems().addAll(openItem,saveItem,exitItem);
        
        // --- Menu Statistics
        Menu menuStat = new Menu("Statistics");
 
        // --- Menu View
        Menu menuAbout = new Menu("About");
 
        menuBar.getMenus().addAll(menuFile, menuStat, menuAbout);
 
 
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar,anchorpane);
 
        stage.setScene(scene);
        stage.show();
  
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
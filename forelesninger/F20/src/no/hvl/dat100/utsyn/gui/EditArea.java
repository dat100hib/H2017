package no.hvl.dat100.utsyn.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Separator;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import no.hvl.dat100.kontroll.Kontroll;

public class EditArea {

	private Kontroll kontroll = null;
	
	public EditArea(HBox hbox, Kontroll kontroll) {
	
		this.kontroll = kontroll;
		
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 0, 0, 10));
		
		Label gnslabel = new Label("gns");
		Label bnslabel = new Label("bns");
		
		TextField gnsfield = new TextField();
		TextField bnsfield = new TextField();
		bnsfield.setPrefWidth(80);
		gnsfield.setPrefWidth(80);
		
		HBox gnsbnshbox = new HBox();
		gnsbnshbox.setPadding(new Insets(10, 10, 10, 10));
		
		gnsbnshbox.getChildren().addAll(gnslabel,gnsfield,bnslabel,bnsfield);
		
		TextField navnfield = new TextField();
		Label navnlabel = new Label("Navn");
		HBox navnhbox = new HBox(navnlabel,navnfield);
		navnhbox.setPadding(new Insets(10, 10, 10, 10));
		
		TextField fodselsnrfield = new TextField();
		Label fodselnrlabel = new Label("Fødselsnummer");
		
		HBox fodselsnrhbox = new HBox(fodselnrlabel,fodselsnrfield);
		fodselsnrhbox.setPadding(new Insets(10, 10, 10, 10));
		
		TextField veinrfield = new TextField();
		Label veinrlabel = new Label("Nr");
		veinrfield.setPrefWidth(80);
		
		TextField veinavnfield = new TextField();
		Label veinavnlabel = new Label("Vei");
		
		HBox veihbox = new HBox(veinavnlabel,veinavnfield,veinrlabel,veinrfield);
		veihbox.setPadding(new Insets(10, 10, 10, 10));
		
		TextField byfield = new TextField();
		Label bylabel = new Label("By");
		HBox byhbox = new HBox(bylabel,byfield);
		byhbox.setPadding(new Insets(10, 10, 10, 10));
		
		TextField landfield = new TextField();
		Label landlabel = new Label("Land");
		
		HBox landhbox = new HBox(landlabel,landfield);
		landhbox.setPadding(new Insets(10, 10, 10, 10));
		
		
		
		Separator separator1 = new Separator();
		
		TextField leiefield = new TextField();
		Label leielabel = new Label("Leie");
		
		HBox leiehbox = new HBox(leielabel,leiefield);
		leiehbox.setPadding(new Insets(10, 10, 10, 10));
		
		TextField fodnrfield = new TextField();
		Label fodnrlabel = new Label("Fødnr");
		
		HBox fodnrhbox = new HBox(fodnrlabel,fodnrfield);
		fodnrhbox.setPadding(new Insets(10, 10, 10, 10));
		
		Separator separator2 = new Separator();
		
		TextField orgnrfield = new TextField();
		Label orgnrlabel = new Label("Orgnr");
		HBox orgnrhbox = new HBox(orgnrlabel,orgnrfield);
		orgnrhbox.setPadding(new Insets(10, 10, 10, 10));
		
		Separator separator3 = new Separator();
		
		HBox buttonhbox = new HBox();
		buttonhbox.setPadding(new Insets(10, 10, 10, 10));
		
		Button newbutton = new Button("New");
		Button editbutton = new Button("Edit");
		Button deletebutton = new Button("Delete");
		buttonhbox.getChildren().addAll(newbutton,editbutton,deletebutton);
		
		vbox.getChildren().addAll(gnsbnshbox,navnhbox,fodselsnrhbox,veihbox,byhbox,landhbox,separator1,
				                  leiehbox,fodnrhbox,separator2,
				                  orgnrhbox,separator3,
				                  buttonhbox);
		hbox.getChildren().addAll(vbox);	
		/*
		rightvbox.getChildren().addAll(label,gridpane,buttonhbox);
		hbox.getChildren().addAll(elist, rightvbox);*/
	}

}

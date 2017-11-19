package no.hvl.dat100.utsyn.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NewBtnHandler implements EventHandler<ActionEvent> {

	private EditArea earea;
	
	public NewBtnHandler(EditArea earea) {
		this.earea = earea;
	}

	@Override
    public void handle(ActionEvent actionEvent) {
    	
    	System.out.println("New");
    	
    	earea.clearFields();
    	earea.setEditable(true);
    }
}

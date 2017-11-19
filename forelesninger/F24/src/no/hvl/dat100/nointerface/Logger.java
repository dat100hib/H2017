package no.hvl.dat100.nointerface;

import java.util.ArrayList;

public class Logger {

	private ArrayList<String> arkiv;
	
	public Logger() {
		arkiv = new ArrayList<String>();
	}
	
	public void onMessage(String message) {
		arkiv.add(message);
	}
	
	public void show () {
		
		for (String s : arkiv) {
			System.out.println(s);
		}
	}
}

package no.hvl.dat100.withinterface;

import java.util.ArrayList;

public class Logger implements IFollower {

	private ArrayList<String> arkiv;
	
	public Logger() {
		arkiv = new ArrayList<String>();
	}
	
	public void onMessage(String message) {
		arkiv.add(message);
	}
	
	public void show () {
		
		System.out.println("---- arkiv ----");
		
		for (String s : arkiv) {
			System.out.println(s);
		}
		
		System.out.println("---- ----- ----");
		
	}
}

package no.hvl.dat100.withinterface;

public class Display implements IFollower {
	
	public void onMessage(String message) {
		System.out.println("DISPLAY: " + message);
	}
}

package no.hvl.dat100.withinterface;

public class User implements IFollower {
	
	String me;
	public User (String identity) {
		me = identity;
	}
	public void onMessage(String message) {
		System.out.println(me + "! " + "du har fått en melding: " + message);
	}
}

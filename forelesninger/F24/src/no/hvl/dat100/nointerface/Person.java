package no.hvl.dat100.nointerface;

public class Follower {

	private String identity;
	
	public Follower(String identity) {
		this.identity = identity;
	}
	
	public void onMessage (String message) {
		System.out.print(identity + " received : ");
		System.out.println(message);
	}
}

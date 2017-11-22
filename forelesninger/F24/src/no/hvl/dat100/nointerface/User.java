package no.hvl.dat100.nointerface;

public class User {

	private String identity;
	
	public User(String identity) {
		this.identity = identity;
	}
	
	public void onMessage (String message) {
		System.out.print(identity + " received : ");
		System.out.println(message);
	}
}

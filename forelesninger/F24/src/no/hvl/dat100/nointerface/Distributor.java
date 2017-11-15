package no.hvl.dat100.nointerface;

import java.util.ArrayList;

public class Distributor {

	private ArrayList<Follower> followers;
	
	public Distributor() {
		followers = new ArrayList<Follower>();
	}

	public void follow(Follower follower) {
		followers.add(follower);
	}
	
	public void unfollow(Follower follower) {
		followers.remove(follower);
	}
	
	public void publish(String message) {
		
		for (Follower follower : followers) {
			follower.onMessage(message);
		}
	}
} 

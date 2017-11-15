package no.hvl.dat100.withinterface;

import java.util.ArrayList;

public class Distributor {

private ArrayList<IFollower> followers;
	
	public Distributor() {
		followers = new ArrayList<IFollower>();
	}

	public void follow(IFollower follower) {
		followers.add(follower);
	}
	
	public void unfollow(IFollower follower) {
		followers.remove(follower);
	}
	
	public void publish(String message) {
		
		for (IFollower follower : followers) {
			follower.onMessage(message);
		}
	}
}

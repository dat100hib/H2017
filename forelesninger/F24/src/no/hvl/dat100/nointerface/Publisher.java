package no.hvl.dat100.nointerface;

public class Publisher {
	
	public static void main(String args[]) {
		
		Distributor distributor = new Distributor();
		
		Follower follower1 = new Follower("X");
		Follower follower2 = new Follower("Y");
		
		distributor.publish("1. melding");
		System.out.println("------------");	
		
		distributor.follow(follower1);
		distributor.publish("2. melding");
		System.out.println("------------");	
		
		distributor.follow(follower2);
		distributor.publish("3. melding");
		System.out.println("------------");	
		
		distributor.unfollow(follower2);
		distributor.publish("4. melding");
		System.out.println("------------");	
	}
}

package no.hvl.dat100.nointerface;

public class Main {

public static void main(String args[]) {
		
		Distributor distributor = new Distributor();
		Publisher publisher = new Publisher(distributor);
		
		Follower follower1 = new Follower("X");
		Follower follower2 = new Follower("Y");
		
		publisher.publish("1. melding");
		System.out.println("------------");	
		
		distributor.follow(follower1);
		
		publisher.publish("2. melding");
		System.out.println("------------");	
		
		distributor.follow(follower2);
		
		publisher.publish("3. melding");
		System.out.println("------------");	
		
		distributor.unfollow(follower2);
		
		publisher.publish("4. melding");
		System.out.println("------------");	
	}
}

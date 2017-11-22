package no.hvl.dat100.nointerface;

public class Main {

public static void main(String args[]) {
		
		Distributor distributor = new Distributor();
		Publisher publisher = new Publisher(distributor);
		
		Follower p1 = new Follower("Person 1");
		Follower p2 = new Follower("Person 2");
		
		publisher.publish("1. melding");
		System.out.println("------------");	
		
		distributor.follow(p1);
		
		publisher.publish("2. melding");
		System.out.println("------------");	
		
		distributor.follow(p2);
		
		publisher.publish("3. melding");
		System.out.println("------------");	
		
		distributor.unfollow(p2);
		
		publisher.publish("4. melding");
		System.out.println("------------");	
	}
}

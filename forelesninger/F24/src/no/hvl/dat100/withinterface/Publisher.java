package no.hvl.dat100.withinterface;

public class Publisher {
	
	public static void main(String args[]) {
		
		Distributor distributor = new Distributor();
		
		Display display = new Display();
		User user = new User("Erna");
		
		distributor.publish("1. melding");
		System.out.println("------------");	
		
		distributor.follow(display);
		
		distributor.publish("2. melding");
		System.out.println("------------");	
		
		distributor.follow(user);
		
		distributor.publish("3. melding");
		System.out.println("------------");	
		
		distributor.unfollow(user);
		
		distributor.publish("4. melding");
		System.out.println("------------");	
	}
}

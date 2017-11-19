package no.hvl.dat100.withinterface;

public class Main {

	public static void main(String args[]) {
		
		Distributor distributor = new Distributor();
		Publisher publisher = new Publisher(distributor);
		
		Logger logger = new Logger();
		Display display = new Display();
		User user = new User("Erna");
		
		distributor.follow(logger);
		
		publisher.publish("1. melding");
		System.out.println("------------");	
		
		distributor.follow(display);
		
		publisher.publish("2. melding");
		System.out.println("------------");	
		
		distributor.follow(user);
		
		publisher.publish("3. melding");
		System.out.println("------------");	
		
		distributor.unfollow(user);
		
		publisher.publish("4. melding");
		System.out.println("------------");	
		
		logger.show();
	}
}

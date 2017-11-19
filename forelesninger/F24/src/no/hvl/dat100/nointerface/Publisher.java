package no.hvl.dat100.nointerface;

public class Publisher {
	
	private Distributor distributor;
	
	public Publisher(Distributor distributor) {
		this.distributor = distributor;
	}
	
	public void publish(String message) {
		distributor.publish(message);
	}
}
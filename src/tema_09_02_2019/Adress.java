package tema_09_02_2019;

public class Adress {
	
	//ar mai fi mers adaugate niste detalii la adresa asta
	private String country;
	private String city;
	private String street;
	private int postalCode;
	private int streetNumber;
	private String block;
	
	public Adress(String country) {
		super();
		this.country = country;
	}
	@Override
	public String toString() {
		return country;
	}
}

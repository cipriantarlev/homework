package tema_06_04_2019;

import java.util.List;

public class Movie {
	
	private String id;
	private String name;
	private List<Actor> actorList;
	private List<Producer> producerList;
	private Rental rental;
	
	public Movie() {
		
	}

	public Movie(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Rental getRental() {
		return rental;
	}
	
	public void setRental(Rental rental) {
		this.rental = rental;
	}
	
	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	public List<Producer> getProducerList() {
		return producerList;
	}

	public void setProducerList(List<Producer> producerList) {
		this.producerList = producerList;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Movie name: " + name;
	}
}

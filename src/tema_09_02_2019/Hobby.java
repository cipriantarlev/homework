package tema_09_02_2019;

import java.util.*;

public class Hobby {
	
	private String name;
	private int frequency;
	private List<Adrese> adrese = new ArrayList<>();
	
	public Hobby(String name, int frequency,List<Adrese> adrese) {
		super();
		this.name = name;
		this.frequency = frequency;
		this.adrese = adrese;
	}
	
	@Override
	public String toString() {
		return "Hobby: " + name + adrese;
	}
	
	
}

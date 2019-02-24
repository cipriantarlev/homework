package tema_09_02_2019;

import java.util.*;

public class Hobby {
	
	private String name;
	private int frequency;
	private List<Adress> adrese = new ArrayList<>();
	
	public Hobby(String name, int frequency,List<Adress> adrese) {
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

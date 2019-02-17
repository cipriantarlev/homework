package tema_09_02_2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapApplication {

	public static void main(String[] args) {
		
		Map<Person,List<Hobby>> map = new HashMap<>();
		
		List<Hobby> hoby1 = new ArrayList<>();
		List<Hobby> hoby2 = new ArrayList<>();
		List<Hobby> hoby3 = new ArrayList<>();
		List<Hobby> hoby4 = new ArrayList<>();
		List<Hobby> hoby5 = new ArrayList<>();
		
		List<Adrese> swiming = new ArrayList<>();
		swiming.add(new Adrese("Italy"));
		swiming.add(new Adrese("Romania"));
		
		List<Adrese> cycling = new ArrayList<>();
		cycling.add(new Adrese("Romania"));
		cycling.add(new Adrese("Germany"));
		cycling.add(new Adrese("Austria"));
		
		List<Adrese> skating = new ArrayList<>();
		skating.add(new Adrese("USA"));
		
		List<Adrese> walking = new ArrayList<>();
		walking.add(new Adrese("Romania"));
		walking.add(new Adrese("Bulgari"));
		walking.add(new Adrese("Slovakia"));
		walking.add(new Adrese("Denmark"));
		
		
		hoby1.add(new Hobby("swiming", 5,swiming));
		hoby1.add(new Hobby("cycling", 6, cycling));
		
		hoby2.add(new Hobby("skating", 4, skating));
		hoby2.add(new Hobby("cycling", 9, cycling));
		
		hoby3.add(new Hobby("swiming", 12,swiming));
		hoby3.add(new Hobby("skating", 18, skating));
		
		hoby4.add(new Hobby("walking", 34, walking));
		hoby4.add(new Hobby("swiming", 4,swiming));
		
		hoby5.add(new Hobby("cycling", 19, cycling));
		hoby5.add(new Hobby("walking", 45,walking));
		
		
		
		map.put(new Person("Ion"), hoby1);
		map.put(new Person("Vasile"), hoby2);
		map.put(new Person("Paul"), hoby3);
		map.put(new Person("Adi"), hoby4);
		map.put(new Person("Mihai"), hoby5);
		
		
		for (Person person : map.keySet()) {
			String key = person.toString();
			String value = map.get(person).toString();
			System.out.println(key + " " + value);
			
		}
	}

}

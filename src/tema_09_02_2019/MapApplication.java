package tema_09_02_2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapApplication {

	public static void main(String[] args) {
		
		Map<Person,List<Hobby>> map = new HashMap<>();
		
		List<Hobby> hobbies1 = new ArrayList<>();
		List<Hobby> hobbies2 = new ArrayList<>();
		List<Hobby> hobbies3 = new ArrayList<>();
		List<Hobby> hobbies4 = new ArrayList<>();
		List<Hobby> hobbies5 = new ArrayList<>();
		
		List<Adress> swimingAdresses = new ArrayList<>();
		swimingAdresses.add(new Adress("Italy"));
		swimingAdresses.add(new Adress("Romania"));
		
		List<Adress> cyclingAdresses = new ArrayList<>();
		cyclingAdresses.add(new Adress("Romania"));
		cyclingAdresses.add(new Adress("Germany"));
		cyclingAdresses.add(new Adress("Austria"));
		
		List<Adress> skatingAdresses = new ArrayList<>();
		skatingAdresses.add(new Adress("USA"));
		
		List<Adress> walkingAdresses = new ArrayList<>();
		walkingAdresses.add(new Adress("Romania"));
		walkingAdresses.add(new Adress("Bulgari"));
		walkingAdresses.add(new Adress("Slovakia"));
		walkingAdresses.add(new Adress("Denmark"));
		
		
		hobbies1.add(new Hobby("swiming", 5,swimingAdresses));
		hobbies1.add(new Hobby("cycling", 6, cyclingAdresses));
		
		hobbies2.add(new Hobby("skating", 4, skatingAdresses));
		hobbies2.add(new Hobby("cycling", 9, cyclingAdresses));
		
		hobbies3.add(new Hobby("swiming", 12,swimingAdresses));
		hobbies3.add(new Hobby("skating", 18, skatingAdresses));
		
		hobbies4.add(new Hobby("walking", 34, walkingAdresses));
		hobbies4.add(new Hobby("swiming", 4,swimingAdresses));
		
		hobbies5.add(new Hobby("cycling", 19, cyclingAdresses));
		hobbies5.add(new Hobby("walking", 45,walkingAdresses));
		
		
		
		map.put(new Person("Ion"), hobbies1);
		map.put(new Person("Vasile"), hobbies2);
		map.put(new Person("Paul"), hobbies3);
		map.put(new Person("Adi"), hobbies4);
		map.put(new Person("Mihai"), hobbies5);
		
		
		for (Person person : map.keySet()) {
			String key = person.toString();
			String value = map.get(person).toString();
			System.out.println(key + " " + value);
			
		}
	}

}

package tema_09_02_2019;

public class Person {

	//la fel si aici, ar fi mers mai multe detalii despre persoana
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person " + name +":" ;
	}
	
}

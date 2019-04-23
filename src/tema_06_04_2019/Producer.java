package tema_06_04_2019;


public class Producer {

	private String id;
	private String name;
	public Producer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Producer [name=" + name + "]";
	}
}

package tema_06_04_2019;

import lombok.Data;

@Data
public class Actor {

	private String id;
	private String name;
	private String gender;
	
	
	
	public Actor(String id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Actor [name=" + name + ", gender=" + gender + "]";
	}
	
}

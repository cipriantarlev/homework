package tema_23_03_2019;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private int age;
	private boolean male;

	public User(Integer age) {
		this.age = age;
	}

	public User(String name) {
		this.name = name;
	}

	public User(String name, boolean male) {
		this.name = name;
		this.male = male;
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public User(String name, int age, boolean male) {
		this.name = name;
		this.age = age;
		this.male = male;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public boolean isMale() {
		return male;
	}

	public static List<User> getUsersWithAge(int... ages) {
		List<User> users = new ArrayList<>();
		for (Integer age : ages) {
			users.add(new User(age));
		}
		return users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (male ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (age != other.age) {
			return false;
		}
		if (male != other.male) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", male=" + male + "]";
	}
	
	
	
}

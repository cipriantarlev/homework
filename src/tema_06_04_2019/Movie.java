package tema_06_04_2019;

public class Movie {
	
	private String id;
	private String name;
	private int year;
	private int rating;

	public Movie(String id, String name, int year, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rating = rating;
	}

	public Movie() {

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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", year=" + year + ", rating=" + rating + "]";
	}
}

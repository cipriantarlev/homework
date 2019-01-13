package tema_15_12_2018;

public class Novel extends Book {
	
	private String type;

	public Novel(String bookName, int newPageNumber, String type) {
		super(bookName, newPageNumber);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType (String type) {
		this.type = type;
	}

	@Override
	public String showBook() {
		
		return "Cartea " + bookName + " are " + pageNumber + " de pagini, si este de tipul " + type;
	}
}

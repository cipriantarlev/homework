package tema_15_12_2018;

public abstract class Book {

	protected String bookName;
	protected int pageNumber;
	
	public Book (String bookName, int newPageNumber) {
		this.bookName = bookName;
		pageNumber = newPageNumber;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	public void setBookName (String bookName) {
		this.bookName = bookName;
	}
	
	public void setPageNumber (int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public abstract String showBook();
}

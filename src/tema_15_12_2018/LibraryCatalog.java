package tema_15_12_2018;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {

	private List<Book> bookList = new ArrayList<>();
	
	void addBook (Book book) {
		bookList.add(book);
	}
	
	boolean deleteBookByName (String bookName1) {
//		for(Book intermediateBook : bookList) {
//			if (intermediateBook.getBookName() == bookName) {
//				bookList.remove(intermediateBook);
//				return true;
//			}
//		}
//		return false;
		Book x = findByName(bookName1);
		
		if (x != null) {
			bookList.remove(x);
			return true;
		}else {
			return false;
		}
	}
	
	Book findByName (String bookName) {
		for (Book intermediateBook : bookList) {
			if (intermediateBook.getBookName() == bookName) {
				return intermediateBook;
			}
		}
		return null;
	}
	
	void printAllBooks () {
		System.out.println("Lista de carti:");
		for(Book intermediateBook : bookList) {
			System.out.println(intermediateBook.showBook());
		}
	}
}

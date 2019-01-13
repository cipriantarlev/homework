package tema_15_12_2018;

public class ArtAlbum extends Book {

	private String paperQuality;
	
	public ArtAlbum(String bookName, int newPageNumber, String paperQuality) {
		super(bookName, newPageNumber);
		this.paperQuality = paperQuality;
		
	}
	
	public String getPaperQuality () {
		return paperQuality;
	}
	
	public void setPaperQuality (String paperQuality) {
		this.paperQuality = paperQuality;
	}

	@Override
	public String showBook() {
		
		return "Cartea " + bookName + " are " + pageNumber + " de pagini, si calitatea paginilor este " + paperQuality;
	}
}


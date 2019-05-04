package tema_06_04_2019;

public class Rental {
	
	private int cid;
	private String movieID;
	private String status;
	private int rentedTimes;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRentedTimes() {
		return rentedTimes;
	}
	public void setRentedTimes(int rentedTimes) {
		this.rentedTimes = rentedTimes;
	}
	@Override
	public String toString() {
		return "Rental status: " + status;
	}
}

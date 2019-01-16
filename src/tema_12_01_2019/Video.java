package tema_12_01_2019;

import java.util.ArrayList;
import java.util.List;

public class Video {

	protected String title;
	protected Boolean isCheckedOut;
	protected double userAverageRating;

	List<Double> usersRatings = new ArrayList<>();
	
	public Video (String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public double getUserAverageRating() {
		return userAverageRating;
	}
	
	public Boolean checkingOut (){
		System.out.println("This Video " + title + " is checked out");
		return isCheckedOut = true;
	}
	public Boolean returningVideo () {
		System.out.println("This Video " + title +  " is returned");
		return isCheckedOut = false;
	}

	
	public void receivingRating (double userRating) {
		usersRatings.add(userRating);
		double sum = 0;
		for (Double intermediateRating : usersRatings) {
			sum += intermediateRating;
			
	}
		userAverageRating = sum / usersRatings.size();
		
	}

	@Override
	public String toString() {
		String s;
		if (isCheckedOut == true) {
			s = "checked out";
		}else {
			s = "returned";
		}
		return "Video [title= " + title + ", status= " + s + ", user average rating= " + userAverageRating
				+ "]";
	}

	
	
}

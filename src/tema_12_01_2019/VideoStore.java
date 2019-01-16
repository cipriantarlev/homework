package tema_12_01_2019;

import java.util.ArrayList;
import java.util.List;

public class VideoStore {

	List<Video> videosList = new ArrayList<>();
	
	public void addVideo(String title) {
		Video video = new Video(title);
		videosList.add(video);
	}
	
	public void checkOut(String title) {
		for (Video intermediateVideo : videosList) {
			if (intermediateVideo.getTitle() == title) {
				intermediateVideo.checkingOut();
			}
		}
	}
	
	public void returnVideo(String title) {
		for (Video intermediateVideo : videosList) {
			if (intermediateVideo.getTitle() == title) {
				intermediateVideo.returningVideo();
			}
		}
	}
	
	public void receiveRating(String title, int userRating) {
		for (Video intermediateVideo : videosList) {
			if (intermediateVideo.getTitle() == title) {
				intermediateVideo.receivingRating(userRating);
			}
		}
	}
	
	public void listInventory () {
		for (Video intermediateVideo : videosList) {
			System.out.println(intermediateVideo.toString());
		}
	}
}

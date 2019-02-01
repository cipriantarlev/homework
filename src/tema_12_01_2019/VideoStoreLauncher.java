package tema_12_01_2019;

public class VideoStoreLauncher {

	public static void main(String[] args) {
		
		VideoStore videoStore = new VideoStore();
		
		String theMatrix = "The Matrix";
		String godfatherII = "Godfather II";
		String starWars = "Star Wars Episode IV: A New Hope";
		
		videoStore.addVideo(theMatrix);
		
		videoStore.addVideo(godfatherII);
		videoStore.addVideo(starWars);
		
		videoStore.receiveRating(theMatrix, 7);
		videoStore.receiveRating(theMatrix, 8);
		videoStore.receiveRating(theMatrix, 6);
		videoStore.receiveRating(theMatrix, 9);
		videoStore.receiveRating(godfatherII, 10);
		videoStore.receiveRating(starWars, 8);
		
		videoStore.checkOut(theMatrix);
		videoStore.checkOut(godfatherII);
		videoStore.returnVideo(theMatrix);
		videoStore.checkOut(starWars);
		
		videoStore.listInventory();
		
		
	}

}

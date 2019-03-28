

public class Match {
	private String profileName; 
	private String dogBreed;
	private double matchScore = 0.0;
	private String matchedImage;
	

	// default constructor
	public Match() {
	}
	
	public Match(String dogBreed1, double matchScore1, String matchedImage1) {
		dogBreed = dogBreed1;
		matchScore = matchScore1;
		matchedImage = matchedImage1;
	}
	
	public String getMatchedImage() {
		return matchedImage;
	}
	
	
	public String getDogBreed() {
		return dogBreed;
	}
	
	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}
	
	public double getMatchScore() {
		return matchScore;
	}
	
	public void setMatchScore(double matchScore) {
		this.matchScore = matchScore;
	}

	public String toString() {
		return dogBreed + ": " + matchScore;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

//	public ArrayList<Double> getListOfMatchScores() {
//		return listOfMatchScores;
//	}
//
//	public void setListOfMatchScores(ArrayList<Double> listOfMatchScores) {
//		this.listOfMatchScores = listOfMatchScores;
//	}
	
	
}

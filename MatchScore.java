/***
 * This object contains the dog breed name, dog breed image that is matched the humans. 
 * All dogs get a MatchScore with the human. The MatchScores are what is compared and then used to 
 * find the corresponding breed name and image URL.
 * @author Team-9
 */
public class MatchScore {
	 
	public String matchedDogBreed;
	public double DHScore = 0.0;
	public String matchedImage;
	
	// default constructor
	public MatchScore() {}
	
	public MatchScore(String matchedDogBreed1, double DHScore1, String matchedImage1) {
		matchedDogBreed = matchedDogBreed1;
		DHScore = DHScore1;
		matchedImage = matchedImage1;
	}
	
	/**
	 * Gets the image to the corresponding matched dog
	 * @return String matched image file/URL
	 */
	public String getMatchedImage() {
		return matchedImage;
	}
	/**
	 * Gets the dog breed name to the corresponding matched dog
	 * @return String matched dog breed name
	 */
	public String getMatchedDogBreed() {
		return matchedDogBreed;
	}
	
	/***
	 * Gets the matched score between the dog and human
	 * @return the dog-human match score
	 */
	public double getDHScore() {
		return DHScore;
	}
	
	/**
	 * Sets the matched scores between the dog and human
	 * @param DHScore
	 */
	public void setDHScore(double DHScore) {
		this.DHScore = DHScore;
	}

	
}

import java.util.ArrayList;
/***
 * Human extends from class called Traits. It contains the logic for creating human matches with dogs
 * and match scores. 
 * It also stores the human's best dog matches (1,2 & 3).
 * @author Team-9
 *
 */
public class Human extends Traits {
	// variable to hold the Human's name, human's best dog match and the image of the best dog match
	public String name;
	
	// public HumanDogMatches matches;
	public String perfectDogMatch = "No dog matched";
	public String secondDogMatch = "No dog matched";
	public String thirdDogMatch = "No dog matched";
	public String pDogImage = "file:defaultimage.png";
	public String dog2Image = "file:defaultimage.png";
	public String dog3Image = "file:defaultimage.png";
	public double perfectDogMatchScore = 26.0;
	public double secondDogMatchScore = 26.0;
	public double thirdDogMatchScore = 26.0;
	
	// list to hold all the MatchScore the human has with the dog
	public ArrayList<MatchScore> matchScores = new ArrayList<MatchScore>();
	
	// default constructor
	public Human() {}
	
	// constructor for just a name
	public Human(String aName) {
		name = aName;
	}
	
	// constructor for name and all traits
	public Human(String aName, double newOwn, double friendly, double groom, double health, double size, double train, double bark,
			double exercise) {
		super(newOwn, friendly, groom, health, size, train, bark, exercise);
		this.name = aName;
	}
	
	// copy constructor 
	public Human(Human aProfile) {
		super(aProfile);
		name = aProfile.name;
	}
	
	/**
	 * Sets the name of the human
	 * @param aName name of the Human
	 */
	public void setName(String aName) {
		name = aName;
	}
	/**
	 * Returns the name of the human
	 * @return the name of the human
	 */
	public String getName() {
		return name;
	}
	/***
	 * Sets an ArrayList to the MatchScores list (in Human).
	 * @param ArrayList that has all the MatchScores in it
	 */
	public void setListOfMatchScores(ArrayList<MatchScore> aList) {
		matchScores = aList;
	}

	/***
	 * Creates a match score between the human and every dog.
	 * @param Lists that contain list of dogs and their associated traits, name and image
	 */
	public void createMatchScores(Lists theLists) {
		
		ArrayList<DogBreed> listToCompare = theLists.listOfDogs;
		ArrayList<MatchScore> listOfMatchScores = new ArrayList<MatchScore>();
		
		for (DogBreed dog : listToCompare) {
			
			double matchScore = 0.0;
			double score = 0.0;

			score = Math.abs(this.newOwn - dog.getNewOwn());
			matchScore = matchScore + score;

			score = Math.abs(this.friendly - dog.getFriendly());
			matchScore = matchScore + score;

			score = Math.abs(this.groom - dog.getGroom());
			matchScore = matchScore + score;

			score = Math.abs(this.health - dog.getHealth());
			matchScore = matchScore + score;

			score = Math.abs(this.train - dog.getTrain());
			matchScore = matchScore + score;

			score = Math.abs(this.bark - dog.getBark());
			matchScore = matchScore + score;

			score = Math.abs(this.exercise - dog.getExercise());
			matchScore = matchScore + score;

			if (this.getSize() != dog.getSize()) {
				matchScore = matchScore + 1;
			}
			// create an object matchScore
			MatchScore newMatchScore = new MatchScore(dog.getDog(), matchScore, dog.getImage());
			
			// add the created match score to the list
			listOfMatchScores.add(newMatchScore);
		}
		
		matchScores = listOfMatchScores;
	}
	
	/***
	 * Returns the perfect dog match for the human 
	 * @return String name of the name of the perfect dog match
	 */
	public String getPerfectMatch() {
		double bestMatchScore = 26.0;
		for (MatchScore i : matchScores) {
			if (i.getDHScore() < bestMatchScore) {
				bestMatchScore = i.getDHScore();
				perfectDogMatch = i.getMatchedDogBreed();
			}
		}
		return perfectDogMatch;
	}
	
	/**
	 * Returns the URL for the perfect dog image match for the human 
	 * @return String name of the image name/URL of the perfect dog match
	 */
	public String getPerfectMatchImage() {
		double bestMatchScore = 26.0;
		for (MatchScore i : matchScores) {
			if (i.getDHScore() < bestMatchScore) {
				bestMatchScore = i.getDHScore();
				perfectDogMatch = i.getMatchedDogBreed();
				pDogImage = i.getMatchedImage();
				perfectDogMatchScore = i.getDHScore();
			}
		}
		return pDogImage;
	}
	
	/***
	 * Returns the second best dog match for the human 
	 * @return String name of the name of the second best dog match
	 */
	public String getSecondMatch() {
		for (MatchScore i: matchScores) {
			if (i.getDHScore() >= perfectDogMatchScore && i.getDHScore() <= secondDogMatchScore) {
				secondDogMatchScore = i.getDHScore();
				secondDogMatch = i.getMatchedDogBreed();
				dog2Image = i.getMatchedImage();
			}
		}
		return secondDogMatch;
	}
	
	/**
	 * Returns the URL for the second best dog image match for the human 
	 * @return String name of the image name/URL of the second best dog match
	 */
	public String getdog2Image() {
		for (MatchScore i : matchScores) {
			if (i.getDHScore() >= perfectDogMatchScore && i.getDHScore() <= secondDogMatchScore) {
				secondDogMatchScore = i.getDHScore();
				secondDogMatch = i.getMatchedDogBreed();
				dog2Image = i.getMatchedImage();
			}
		}
		return dog2Image;
	}	
	
	/***
	 * Returns the third best dog match for the human 
	 * @return String name of the name of the third best dog match
	 */
	public String getThirdMatch() {
		for (MatchScore i: matchScores) {
			if (i.getDHScore() >= perfectDogMatchScore && i.getDHScore() < thirdDogMatchScore) {
				thirdDogMatchScore = i.getDHScore();
				thirdDogMatch = i.getMatchedDogBreed();
				dog3Image = i.getMatchedImage();
			}
		}
		return thirdDogMatch;
	}
	
	/**
	 * Returns the URL for the third best dog image match for the human 
	 * @return String name of the image name/URL of the third best dog match
	 */
	public String getdog3Image() {
		for (MatchScore i : matchScores) {
			if (i.getDHScore() >= perfectDogMatchScore && i.getDHScore() < thirdDogMatchScore) {
				thirdDogMatchScore = i.getDHScore();
				secondDogMatch = i.getMatchedDogBreed();
				dog2Image = i.getMatchedImage();
			}
		}
		return dog3Image;
	}
	
	
	
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DogFinder {
	public ArrayList<DogBreed> dogs = new ArrayList<DogBreed>();
	//private ArrayList<Human> humans = new ArrayList<Human>();
	public Scanner keyboard = new Scanner(System.in);
	public ArrayList<Match> listOfScores = new ArrayList<Match>();
	public Human humanToCompare;
	public String theBestDogBreed;
	public String theBestDogBreedImage;
	
	public DogFinder(Human aHuman) throws IOException {
		humanToCompare = aHuman;
		loadDogs();
		//loadDogs();
		//humanProfile();
		//compareHumanToDogs(humanToCompare);
		//System.out.println("Awesome " + humans.get(0).getName()
		//		+ "! It looks like your best match is a(n) " + compareScores() + "!");
	}
	
	
	public void humanProfile() {
		Human human1 = new Human();
		
		System.out.print("What is your name? ");
		String profileName = keyboard.nextLine();
		human1.setName(profileName);
		
		
		System.out.print("Have you ever owned a dog? Enter Y or N: ");
		char newOwner = keyboard.nextLine().charAt(0);
		if (newOwner == 'Y') {
			human1.setNewOwn(1);
		} else if (newOwner == 'N') {
			human1.setNewOwn(0);
		}
		
		System.out.println("The following questions require your answer on a scale of 1 to 5. "
				+ "\n 1 - strongly disagree. \n 2 - disagree \n 3 - neither disagree or agree"
				+ "\n 4 - agree \n 5 - strongly agree");
		System.out.println("Please enter a value of 1-5 for each question.");
		System.out.println("Please answer honestly so we can find the right match for you!");
		
		System.out.print("I like to socialize: ");
		double social = keyboard.nextDouble();
		human1.setFriendly(social);
		
		
		System.out.print("I don't mind cleaning a lot: ");
		double clean = keyboard.nextDouble();
		human1.setGroom(clean);
		
		System.out.print("I would be okay if my dog's breed had a history of health problems as"
				+ "long as the dog is right for me: ");
		double health = keyboard.nextDouble();
		human1.setHealth(health);
		
		System.out.print("I would put a lot of time into training my dog: ");
		double training = keyboard.nextDouble();
		human1.setTrain(training);
		
		
		System.out.print("I do not mind if my dog barks: ");
		double bark = keyboard.nextDouble();
		human1.setBark(bark);
		
		System.out.print("I would put a lot of time into exercising my dog: ");
		double exercise = keyboard.nextDouble();
		human1.setExercise(exercise);
		
		System.out.print("For this question, please enter: \n 1 if you prefer small dogs "
				+ "\n 3 if you prefer medium dogs \n 5 if you prefer large dogs \n");
		double size = keyboard.nextDouble();
		human1.setSize(size);
		
		//humans.add(human1);
		
		System.out.println("Thanks for answering! Finding the best match for you!");
		
	}
	
	public void compareHumanToDogs(Human humanProfile) {
		humanToCompare = humanProfile;
		
		for (DogBreed dog : dogs) {
			double matchScore = 0.0;
			double score = 0.0;
			score = Math.abs(humanToCompare.getNewOwn() - dog.getNewOwn());
			matchScore = matchScore + score;
			
			score = Math.abs(humanToCompare.getFriendly() - dog.getFriendly());	
			matchScore = matchScore + score;
			
			score = Math.abs(humanToCompare.getGroom() - dog.getGroom());
			matchScore = matchScore + score;
			
			score = Math.abs(humanToCompare.getHealth() - dog.getHealth());
			matchScore = matchScore + score;
			
			score = Math.abs(humanToCompare.getTrain() - dog.getTrain());
			matchScore = matchScore + score;
			
			score = Math.abs(humanToCompare.getBark() - dog.getBark());
			matchScore = matchScore + score;
			
			score = Math.abs(humanToCompare.getExercise() - dog.getExercise());
			matchScore = matchScore + score;
			
			if (humanToCompare.getSize() != dog.getSize()) {
				matchScore = matchScore + 1;
			}
			
			Match newMatchScore = new Match(dog.getBreed(), matchScore, dog.getImage());
			System.out.println("Printing out matchscores: " + newMatchScore.getDogBreed() + newMatchScore.getMatchScore()
								+ newMatchScore.getMatchedImage());
			
			listOfScores.add(newMatchScore);
			
		}
		
	}

	// gets best dog name as a string
	public String compareScores() {
		double bestMatchScore = 26.0;	
		String bestDog = "";
		for (Match i: listOfScores) {
			if (i.getMatchScore() < bestMatchScore) {
				bestMatchScore = i.getMatchScore();
				bestDog = i.getDogBreed();
				System.out.println("Best Match Score:" + bestMatchScore + "Best Dog:" + bestDog);
			}
		}
		
		return bestDog;
	}
	

	// gets best dog image (also returned as string)
	public String getImage() {
		double bestMatchScore = 26.0;
		String bestDogImage = "";
		for (Match i: listOfScores) {
			if (i.getMatchScore() < bestMatchScore) {
				bestMatchScore = i.getMatchScore();
				bestDogImage = i.getMatchedImage();
			}
		}
		return bestDogImage;
	}
	
	// gets 2ND best dog name as a string
	public String compareScores2() {
		double bestMatchScore = 26.0;	
		double secondBest = 26.0;
		String bestDog = "";
		String bestDog2 = "";
		for (Match i: listOfScores) {
			if (i.getMatchScore() < bestMatchScore) {
				bestMatchScore = i.getMatchScore();
				bestDog = i.getDogBreed();
				System.out.println("Best Match Score:" + bestMatchScore + "Best Dog:" + bestDog);
			}
			if (i.getMatchScore() < secondBest && i.getMatchScore() > bestMatchScore) {
				secondBest = i.getMatchScore();
				bestDog2 = i.getDogBreed();
			}
		}
		
		return bestDog2;
	}

	// gets SECOND best dog IMAGE (also returned as string)
	public String getImage2() {
		double bestMatchScore = 26.0;
		double secondBest = 26.0;
		String bestDogImage2 = "";
		for (Match i: listOfScores) {
			if (i.getMatchScore() < bestMatchScore) {
				bestMatchScore = i.getMatchScore();
			}
			if (i.getMatchScore() < secondBest && i.getMatchScore() > bestMatchScore) {
				secondBest = i.getMatchScore();
				bestDogImage2 = i.getMatchedImage();
			}
		}
		
		return bestDogImage2;
	}

	// gets 3RD best dog name as a string
	public String compareScores3() {
		double bestMatchScore = 26.0;	
		double secondBest = 26.0;
		double thirdBest = 26.0;
		String bestDog3 = "";

		for (Match i: listOfScores) {
			if (i.getMatchScore() < bestMatchScore) {
				bestMatchScore = i.getMatchScore();
			}
			if (i.getMatchScore() < secondBest && i.getMatchScore() > bestMatchScore) {
				secondBest = i.getMatchScore();
				
			}
			if (i.getMatchScore() < thirdBest && i.getMatchScore() > secondBest){
				thirdBest = i.getMatchScore();
				bestDog3 = i.getDogBreed();
			}
		}
		
		return bestDog3;
	}

	// gets THIRD best dog IMAGE (also returned as string)
	public String getImage3() {
		double bestMatchScore = 26.0;
		double secondBest = 26.0;
		double thirdBest = 26.0;

		String bestDogImage3 = "";

		for (Match i: listOfScores) {
			if (i.getMatchScore() < bestMatchScore) {
				bestMatchScore = i.getMatchScore();
			}
			if (i.getMatchScore() < secondBest && i.getMatchScore() > bestMatchScore) {
				secondBest = i.getMatchScore();
				
			}
			if (i.getMatchScore() < thirdBest && i.getMatchScore() > secondBest){
				thirdBest = i.getMatchScore();
				bestDogImage3 = i.getMatchedImage();
			}
		}
		
		return bestDogImage3;
	}


	public void loadDogs() throws IOException {

		BufferedReader fileReader = new BufferedReader(new FileReader("DogDataset.txt"));
		String line = fileReader.readLine();
		while (line != null) {

			String[] fields = line.split(",");

			dogs.add(new DogBreed(fields[0], Double.parseDouble(fields[1]), Double.parseDouble(fields[2]),
					Double.parseDouble(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]),
					Double.parseDouble(fields[6]), Double.parseDouble(fields[7]), Double.parseDouble(fields[8]), fields[9]));

			line = fileReader.readLine();

		}
		fileReader.close();
	}

	public void printDogs() {

		for (DogBreed i : dogs) {
			System.out.println(i);
			System.out.println(i.getBreed());
		}
		System.out.println("");
	}
//	
//	private void printHumans() {
//
//		for (Human i : humans) {
//			System.out.println(i);
//		}
//	}
}

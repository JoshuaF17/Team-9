import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/***
 * This object holds the list of dog objects, the questions being asked to the user
 * and the dogNames that are listed on the possible dogs page.
 * @author Team-9
 *
 */
public class Lists {
	protected ArrayList<DogBreed> listOfDogs = new ArrayList<DogBreed>();
	protected ArrayList<String> listOfQuestions = new ArrayList<String>();
	protected ArrayList<String> dogNames = new ArrayList<String>();
	// protected ArrayList<HumanProfile> listOfHumans = new ArrayList<HumanProfile>();
	
	
	// default constructor
	public Lists() {}
	
	/***
	 * Takes a text file, reads it and parses out the text (by ","), so they can be used to create
	 * a dog object.
	 * @param String dataset URl
	 * @throws IOException
	 */
	public void loadDogs(String dataset) throws IOException {

		BufferedReader fileReader = new BufferedReader(new FileReader(dataset));
		String line = fileReader.readLine();
		while (line != null) {

			String[] fields = line.split(",");

			listOfDogs.add(new DogBreed(fields[0], Double.parseDouble(fields[1]), Double.parseDouble(fields[2]),
					Double.parseDouble(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]),
					Double.parseDouble(fields[6]), Double.parseDouble(fields[7]), Double.parseDouble(fields[8]), 
					fields[9]));
			
			line = fileReader.readLine();

		}
		fileReader.close();
	} 
	
	/***
	 * Loads the dog names for the "dogNames.txt" file.
	 * Necessary for the possibleDogsPage object.
	 * @throws IOException
	 */
	public void loadDogNames() throws IOException {
		
		BufferedReader fileReader = new BufferedReader(new FileReader("dogNames.txt"));
		String line = fileReader.readLine();
		while (line != null) {
			dogNames.add(line);
			line = fileReader.readLine();
		}
		fileReader.close();
	}
	

	
	/***
	 * Loads the questions from a text file to use and display in the GUI
	 * @param fileName name of the file that contains the questions, called "Questions.txt"
	 * @throws IOException
	 */
	public void loadQuestions(String fileName) throws IOException {
		BufferedReader fileR = new BufferedReader(new FileReader(fileName));
		String line = fileR.readLine();
		while (line != null) {
			listOfQuestions.add(line);
			line = fileR.readLine();
		}
		fileR.close();
	}
	
	
	
}

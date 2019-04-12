/***
 * DogBreed class extends from Traits, creates an object that holds all the traits of the dog
 * including the image associated with the dog breed in the DogFinder program.
 * @author Team-9
 *
 */
public class DogBreed extends Traits {
		public String dog;
		public String imgName; 
		
		// default constructor
		public DogBreed() {};
		
		// constructor
		
		public DogBreed(String aDog, double newOwn, double friendly, double groom, double health, double size, double train, double bark,
			double exercise, String img) {
			super(newOwn, friendly, groom, health, size, train, bark, exercise);
			this.dog = aDog;
			this.imgName = img;
		}
		
		// copy constructor 
		public DogBreed(DogBreed aDogBreed) {
			super(aDogBreed);
			dog = aDogBreed.dog;
		}
		
		/***
		 * Retrieves the string of the dog breed's image
		 * @return the image of the dog breed
		 */
		public String getImage() {
			return imgName;
		}
		/***
		 * Sets the dog breed name
		 * @param the dog name
		 */
		public void setDog(String aDogBreed) {
			dog = aDogBreed;
		}
		
		/***
		 * Gets the dog breed
		 * @return dog breed
		 */
		public String getDog() {
			return dog;
		}
}

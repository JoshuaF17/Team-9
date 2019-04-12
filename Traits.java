/***
 * This object contains the values for traits (both applicable to Humans and Dogbreeds).
 * Both Human and DogBreed extend from this class.
 * @author Team-9
 */
public class Traits {

	// instance variables;

	public double newOwn = 0;
	public double friendly = 0;
	public double groom = 0;
	public double health = 0;
	public double size = 0;
	public double train = 0;
	public double bark = 0;
	public double exercise = 0;
	

	// default constructor
	public Traits() {}
	
	public Traits(double newOwn, double friendly, double groom, double health, double size, double train, double bark,
			double exercise) {
		this.newOwn = newOwn;
		this.friendly = friendly;
		this.groom = groom;
		this.health = health;
		this.size = size;
		this.train = train;
		this.bark = bark;
		this.exercise = exercise;
	}
	
	// copy constructor
	public Traits(Traits newTraits) {
		this.newOwn = newTraits.newOwn;
		this.friendly = newTraits.friendly;
		this.groom = newTraits.groom;
		this.health = newTraits.health;
		this.size = newTraits.size;
		this.train = newTraits.train;
		this.bark = newTraits.bark;
		this.exercise = newTraits.exercise;
		
	}
	
	/**
	 * Gets the training trait value
	 * @return a double of the training trait value
	 */
	public double getTrain(){
	   return train;   
	}
	
	/***
	 * Sets a value (type double) to the training trait
	 * @param double value of the training trait
	 */
	public void setTrain(double train1){
	   train = train1;
	}
	
	/**
	 * Gets the friendly trait value
	 * @return a double of the friendly trait value
	 */
	public double getFriendly(){
	   return friendly;   
	}
	
	/***
	 * Sets a value (type double) to the friendly trait
	 * @param double value of the friendly trait
	 */
	public void setFriendly(double friendly1){
	   friendly = friendly1;
	}
	
	/**
	 * Gets the new owner trait value
	 * @return a double of the new owner trait value
	 */
	public double getNewOwn(){
	   return newOwn;   
	}
	
	/***
	 * Sets a value (type double) to the new owner trait
	 * @param double value of the new owner trait
	 */
	public void setNewOwn(double newOwn1){
	   newOwn = newOwn1;
	}
	
	/**
	 * Gets the groom trait value
	 * @return a double of the groom trait value
	 */
	public double getGroom(){
	   return groom;   
	}
	
	/***
	 * Sets a value (type double) to the groom trait
	 * @param double value of the groom trait
	 */	
	public void setGroom(double groom1){
	   groom = groom1;
	}
	
	/**
	 * Gets the health trait value
	 * @return a double of the health trait value
	 */
	public double getHealth(){
	   return health;   
	}
	
	/***
	 * Sets a value (type double) to the health trait
	 * @param double value of the health trait
	 */

	public void setHealth(double health1){
	   health = health1;
	}
	
	/**
	 * Gets the size trait value
	 * @return a double of the size trait value
	 */
	public double getSize(){
	   return size;   
	}
	
	/***
	 * Sets a value (type double) to the size trait
	 * @param double value of the size trait
	 */
	public void setSize(double size1){
	   size = size1;
	}
	/**
	 * Gets the bark trait value
	 * @return a double of the bark trait value
	 */
	public double getBark(){
	   return bark;   
	}
	
	/***
	 * Sets a value (type double) to the bark trait
	 * @param double value of the bark trait
	 */
	public void setBark(double bark1){
	  bark = bark1;
	}
	
	/**
	 * Gets the exercise trait value
	 * @return a double of the exercise trait value
	 */
	public double getExercise() {
		return exercise;
	}
	
	/***
	 * Sets a value (type double) to the exercise trait
	 * @param double value of the exercise trait
	 */
	public void setExercise(double exercise1) {
		exercise = exercise1;
	}
	
	/**
	 * 
	 */
	public String toString() {
		
		return " | New Owner: " + newOwn + ", Friendly: " + friendly + ", Groom: " + groom
				+ ", Health: " + health + ", Size: " + size + ", Train: " + train + ", Bark: " + bark + ", Exercise: "
				+ exercise;
	}
	
}

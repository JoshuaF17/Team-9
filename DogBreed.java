public class DogBreed {

	// instance variables;
	private String breed = "";
	private double newOwn = 0;
	private double friendly = 0;
	private double groom = 0;
	private double health = 0;
	private double size = 0;
	private double train = 0;
	private double bark = 0;
	private double exercise = 0;
	private String imgName; 
	// default constructor
	public DogBreed() {
	}
	
	// constructor with all variables in order to pair dog with potential candidates
	
	public DogBreed(String breed, double newOwn, double friendly, double groom, double health, double size, double train, double bark,
			double exercise, String img) {
		this.breed = breed;
		this.newOwn = newOwn;
		this.friendly = friendly;
		this.groom = groom;
		this.health = health;
		this.size = size;
		this.train = train;
		this.bark = bark;
		this.exercise = exercise;
		this.imgName = img;
	}
	
	// getter/setter method

	public String getImage() {
		return imgName;
	}
	
	public String getBreed() {
		return breed;
	}
	
	public void setBreed(String breedType) {
		breed = breedType;
	}
	
	public double getTrain(){
	   return train;   
	}
	
	public void setTrain(double train1){
	   train = train1;
	}
	public double getFriendly(){
	   return friendly;   
	}
	public void setFriendly(double friendly1){
	   friendly = friendly1;
	}
	public double getNewOwn(){
	   return newOwn;   
	}
	public void setNewOwn(double newOwn1){
	   newOwn = newOwn1;
	}
	public double getGroom(){
	   return groom;   
	}
	public void setGroom(double groom1){
	   groom = groom1;
	}
	public double getHealth(){
	   return health;   
	}
	public void setHealth(double health1){
	   health = health1;
	}
	public double getSize(){
	   return size;   
	}
	public void setSize(double size1){
	   size = size1;
	}
	public double getBark(){
	   return bark;   
	}
	public void setBark(double bark1){
	  bark = bark1;
	}
	
	public double getExercise() {
		return exercise;
	}
	
	public void setExercise(double exercise1) {
		exercise = exercise1;
	}

	
	public String toString() {
		return "Dog breed: " + breed + ", New Owner: " + newOwn + ", Friendly: " + friendly + ", Groom: " + groom
				+ ", Health: " + health + ", Size: " + size + ", Train: " + train + ", Bark: " + bark + ", Exercise: "
				+ exercise;
	}
	
	public static String dognames(){
		String names = " Akita, Australian Shepherd, Beagle";
		return names;
	}
	public static String dognames1(){
		String names =" Bernese Mountain Dog, Border Collie" ;
		return names;
	}
	public static String dognames2(){
		String names = " Boston Terrier, Boxer, Bulldog" ;
		return names;
	}
	public static String dognames3(){
		String names = " Chihuahua & Chow Chow";
		return names;
	}
	public static String dognames4(){
		String names = " The following are the possible candidates";
		return names;
	}
	public static String dognames5(){
		String names = "you may match with once finishing the survery.";
		return names;
	}
	public static String dognames6(){
		String names = " Take the survey to find the best match for you!";
		return names;
	}
	
		
}


public class Human extends DogBreed {
	/**
	 * 
	 */
	
	// instance variables
	private String name = "";
		
	public Human() {
		super();
	}

	/**
	 * @param t
	 * @param n
	 * @param f
	 * @param g
	 * @param h
	 * @param s
	 * @param b
	 */
	
	// constructors
	public Human(String breed, double t, double n, double f, double g, double h, double s, double b, double e, String img) {
		super(breed, t, n, f, g, h, s, b, e, img);
		this.name = name;
	}
	
	public Human (String personName) {
		name = personName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Profile:" + name + ", New Owner: " + getNewOwn() + ", Friendly: " + getFriendly() 
				+ ", Groom: " + getGroom() + ", Health: " + getHealth() + ", Size: " + getSize() 
				+ ", Train: " + getTrain() + ", Bark: " + getBark() + ", Exercise: " + getExercise() + getImage();
	}
	
	
	
	
}

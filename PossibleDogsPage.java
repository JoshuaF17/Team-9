import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
/***
 * This object contains the necessary details to create the Possible Dogs page of the program.
 * @author Team-9
 */

public class PossibleDogsPage {
	// instance variable for the lists (where we get our text from):
	public Lists theLists;
	
	public PossibleDogsPage() {}
	
	public PossibleDogsPage(Lists aLists) {
		theLists = aLists;
	}
	
	/***
	 * Gets the root (that contains all the javafx code to create the possible dogs page).
	 * @return Pane type root
	 */
	public Pane getPossibleDogsRoot() throws IOException {
		
		Rectangle whiteRectangle1 = new Rectangle(450,200);
		whiteRectangle1.setFill(Color.WHITE);
		
		Rectangle orangeRectangle1 = new Rectangle(450,500);
		orangeRectangle1.setLayoutX(0);
		orangeRectangle1.setLayoutY(200);
		orangeRectangle1.setFill(Color.ORANGE);
		
		Label dogs2 = new Label(theLists.dogNames.get(0));
		dogs2.setLayoutX(0);
		dogs2.setLayoutY(200);
		dogs2.setTextFill( Color.BLACK );
		dogs2.setFont(Font.font ("Trajan", 25));
		
		Label dogs3 = new Label(theLists.dogNames.get(1));
		dogs3.setLayoutX(0);
		dogs3.setLayoutY(250);
		dogs3.setTextFill( Color.BLACK );
		dogs3.setFont(Font.font ("Trajan", 25));
		
		Label dogs4 = new Label(theLists.dogNames.get(2));
		dogs4.setLayoutX(0);
		dogs4.setLayoutY(300);
		dogs4.setTextFill( Color.BLACK );
		dogs4.setFont(Font.font ("Trajan", 25));
		
		Label dogs5 = new Label(theLists.dogNames.get(3));
		dogs5.setLayoutX(0);
		dogs5.setLayoutY(350);
		dogs5.setTextFill( Color.BLACK );
		dogs5.setFont(Font.font ("Trajan", 25));
		
		Label dogs6 = new Label(theLists.dogNames.get(4));
		dogs6.setLayoutX(0);
		dogs6.setLayoutY(0);
		dogs6.setTextFill( Color.BLACK );
		dogs6.setFont(Font.font ("Trajan", 20));
		
		Label dogs7 = new Label(theLists.dogNames.get(5));
		dogs7.setLayoutX(7);
		dogs7.setLayoutY(50);
		dogs7.setTextFill( Color.BLACK );
		dogs7.setFont(Font.font ("Trajan", 20));
		
		Label dogs8 = new Label(theLists.dogNames.get(6));
		dogs8.setLayoutX(0);
		dogs8.setLayoutY(100);
		dogs8.setTextFill( Color.BLACK );
		dogs8.setFont(Font.font ("Trajan", 20));
		
		//creating dogs pane/root
		Pane possibleDogsRoot = new Pane();
		
		// adding all dogs to the root
		possibleDogsRoot.getChildren().add(whiteRectangle1);
		possibleDogsRoot.getChildren().add(orangeRectangle1);
		possibleDogsRoot.getChildren().add(dogs2);
		possibleDogsRoot.getChildren().add(dogs3);
		possibleDogsRoot.getChildren().add(dogs4);
		possibleDogsRoot.getChildren().add(dogs5);
		possibleDogsRoot.getChildren().add(dogs6);
		possibleDogsRoot.getChildren().add(dogs7);
		possibleDogsRoot.getChildren().add(dogs8);
	
		return possibleDogsRoot;
	}
	
	/***
	 * Creates and gets the button to go back from the possible dogs page to the starting survey page (pg2)
	 * @return a button 
	 */	
	public Button getPreviousBtn() {
		// creating the button
		Button backBtn = new Button("Previous Page");
		backBtn.setFont(Font.font("Verdana", 15));
		backBtn.setLayoutX(0);
		backBtn.setLayoutY(670);
		
		return backBtn;
	}
}

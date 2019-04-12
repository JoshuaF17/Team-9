import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/***
 * This object contains the necessary details to create the fifth page of the program.
 * @author Team-9
 *
 */
public class FifthPage {
	
	/***
	 * Gets the root (that contains all the javafx code to create the fifth page).
	 * @return a Pane type root
	 */
	public Pane getPage5Root() {
		Pane page5Root = new Pane();

		Rectangle r5 = new Rectangle(450, 200);
		r5.setFill(Color.WHITE);

		Rectangle r6 = new Rectangle(450, 500);
		r6.setLayoutX(0);
		r6.setLayoutY(200);
		r6.setFill(Color.ORANGE);
		
		page5Root.getChildren().add(r5);
		page5Root.getChildren().add(r6);

		return page5Root;
	}
	
	public Button getRestartSurveyBtn() {
		Button restartButton = new Button("Restart Survey");
		restartButton.setFont(Font.font("Verdana", 15));
		restartButton.setLayoutX(0);
		restartButton.setLayoutY(670);
		
		return restartButton;
	}
	
	/***
	 * Creates and gets the button to go from the fifth page to the perfect match page
	 * @return the button
	 */
	public Button getPerfectMatchBtn() {
		Button perfectButton = new Button("Find Perfect Match!");
		perfectButton.setFont(Font.font("Verdana", 30));
		perfectButton.setLayoutX(70);
		perfectButton.setLayoutY(480);
		
		return perfectButton;
	}
	/***
	 * Creates and gets the button to go from the fifth page to the Top3Matches page
	 * @return the button
	 */
	public Button getTop3MatchesButton() {
		Button top3MatchesButton = new Button("Find 3 Best Matches!");
		top3MatchesButton.setFont(Font.font("Verdana", 28));
		top3MatchesButton.setLayoutX(70);
		top3MatchesButton.setLayoutY(300);
		
		return top3MatchesButton;
	}
	


}



import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
/***
 * This object contains the necessary details to create the Perfect Match page of the program.
 * @author Team-9
 */

public class PerfectMatchPage {
	public Human currentH;
	public String bestDog = "No dog matched";
	public String bDogImage = "file: defaultimage.png";

	public PerfectMatchPage() {}
	
	/***
	 * Gets the root (that contains all the javafx code to create the perfect match page).
	 * @return Pane type root
	 */
	public Pane getBestMatchPageRoot(Human currentH, Lists currentLists) {
		
		currentH.createMatchScores(currentLists);
		
		
		// add perfect dog string to bdog1
		bestDog = currentH.getPerfectMatch();
		bDogImage = "file:" + currentH.getPerfectMatchImage();
		
		// create the page 
		Pane finalRoot = new Pane();
		
		Rectangle whiteRectangle = new Rectangle(450, 200);
		whiteRectangle.setFill(Color.WHITE);

		Rectangle orangeRectangle = new Rectangle(450, 500);
		orangeRectangle.setLayoutX(0);
		orangeRectangle.setLayoutY(200);
		orangeRectangle.setFill(Color.ORANGE);

		Label labelPerfect1 = new Label("Perfect Match");
		labelPerfect1.setLayoutX(82);
		labelPerfect1.setLayoutY(30);
		labelPerfect1.setTextFill(Color.BLACK);
		labelPerfect1.setFont(Font.font("Impact", 50));

		Label labelPerfect2 = new Label("Perfect Match");
		labelPerfect2.setLayoutX(90);
		labelPerfect2.setLayoutY(30);
		labelPerfect2.setTextFill(Color.ORANGE);
		labelPerfect2.setFont(Font.font("Impact", 50));

		Label perfectDog = new Label(bestDog);
		perfectDog.setLayoutX(110);
		perfectDog.setLayoutY(520);
		perfectDog.setTextFill(Color.BLACK);
		perfectDog.setFont(Font.font("Impact", 35));

		Image image3 = new Image(bDogImage);
		ImageView bestDogImageView = new ImageView(image3);
		bestDogImageView.setLayoutX(58);
		bestDogImageView.setLayoutY(130);
		bestDogImageView.setFitHeight(290);
		bestDogImageView.setFitWidth(340);

		// creating the perfect match page
		finalRoot.getChildren().add(whiteRectangle);
		finalRoot.getChildren().add(orangeRectangle);
		finalRoot.getChildren().add(labelPerfect1);
		finalRoot.getChildren().add(labelPerfect2);
		finalRoot.getChildren().add(perfectDog);
		finalRoot.getChildren().add(bestDogImageView);	
		
		return finalRoot;
	}
	
	/***
	 * Creates and gets the button to go back from the perfect page to the fifth page
	 * @return a button 
	 */	
	public Button getBackBtnOnBestMatchPg() {
		// Back button and handler for best match page
		Button backb = new Button("Previous Page");
		backb.setFont(Font.font("Verdana", 15));
		backb.setLayoutX(0);
		backb.setLayoutY(670);
		return backb;
	}
	

}

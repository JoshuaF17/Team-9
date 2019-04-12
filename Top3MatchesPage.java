import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
/***
 * This object contains the necessary details to create the top 3 matches page of the program.
 * @author Team-9
 */
public class Top3MatchesPage {
	public String bdog1 = "";
	public String bdog2 = ""; 
	public String bdog3 = "";
	public String bdogimage1 = "";
	public String bdogimage2 = "";
	public String bdogimage3 = "";
	
	public Top3MatchesPage() {}
	
	
	/***
	 * Gets the root (that contains all the javafx code to create the top 3 matches page).
	 * @return Pane type root
	 */
	public Pane getTop3MatchesPage(Human currentH, Lists currentLists) {
		
		currentH.createMatchScores(currentLists);
		
		bdog1 = currentH.getPerfectMatch();
		bdogimage1 = "file:" + currentH.getPerfectMatchImage();
		
		bdog2 = currentH.getSecondMatch();
		bdogimage2 = "file:" + currentH.getdog2Image();
		
		bdog3 = currentH.getThirdMatch();
		bdogimage3 = "file:" + currentH.getdog3Image();

		
		Rectangle whiteRectangle2 = new Rectangle(450, 200);
		whiteRectangle2.setFill(Color.WHITE);

		Rectangle orangeRectangle2 = new Rectangle(450, 500);
		orangeRectangle2.setLayoutX(0);
		orangeRectangle2.setLayoutY(200);
		orangeRectangle2.setFill(Color.ORANGE);

		Label threeBestMatches = new Label(" 3 Best Matches ");
		threeBestMatches.setLayoutX(82);
		threeBestMatches.setLayoutY(30);
		threeBestMatches.setTextFill(Color.BLACK);
		threeBestMatches.setFont(Font.font("Impact", 50));

		Label threeBestMatches2 = new Label(" 3 Best Matches ");
		threeBestMatches2.setLayoutX(90);
		threeBestMatches2.setLayoutY(30);
		threeBestMatches2.setTextFill(Color.ORANGE);
		threeBestMatches2.setFont(Font.font("Impact", 50));

		Label bestDog1 = new Label(bdog1);
		bestDog1.setLayoutX(0);
		bestDog1.setLayoutY(330);
		bestDog1.setTextFill(Color.BLACK);
		bestDog1.setFont(Font.font("Impact", 30));

		Label bestDog2 = new Label(bdog2);
		bestDog2.setLayoutX(270);
		bestDog2.setLayoutY(330);
		bestDog2.setTextFill(Color.BLACK);
		bestDog2.setFont(Font.font("Impact", 30));

		Label bestDog3 = new Label(bdog3);
		bestDog3.setLayoutX(155);
		bestDog3.setLayoutY(620);
		bestDog3.setTextFill(Color.BLACK);
		bestDog3.setFont(Font.font("Impact", 30));

		Image bestDogImage1 = new Image(bdogimage1);
		ImageView bestDogImageView1 = new ImageView(bestDogImage1);
		bestDogImageView1.setLayoutX(0);
		bestDogImageView1.setLayoutY(120);
		bestDogImageView1.setFitHeight(200);
		bestDogImageView1.setFitWidth(210);

		Image bestDogImage2 = new Image(bdogimage2);
		ImageView bestDogImageView2 = new ImageView(bestDogImage2);
		bestDogImageView2.setLayoutX(250);
		bestDogImageView2.setLayoutY(120);
		bestDogImageView2.setFitHeight(200);
		bestDogImageView2.setFitWidth(210);

		Image bestDogImage3 = new Image(bdogimage3);
		ImageView bestDogImageView3 = new ImageView(bestDogImage3);
		bestDogImageView3.setLayoutX(120);
		bestDogImageView3.setLayoutY(400);
		bestDogImageView3.setFitHeight(210);
		bestDogImageView3.setFitWidth(200);

		// creating the three best matches page
		Pane finalRoot1 = new Pane();
		
		finalRoot1.getChildren().add(whiteRectangle2);
		finalRoot1.getChildren().add(orangeRectangle2);
		finalRoot1.getChildren().add(threeBestMatches);
		finalRoot1.getChildren().add(threeBestMatches2);
		finalRoot1.getChildren().add(bestDog1);
		finalRoot1.getChildren().add(bestDogImageView1);
		finalRoot1.getChildren().add(bestDog2);
		finalRoot1.getChildren().add(bestDog3);
		finalRoot1.getChildren().add(bestDogImageView2);
		finalRoot1.getChildren().add(bestDogImageView3);
		
		return finalRoot1;
		
	}
	
	/***
	 * Creates and gets the button to go back to the finished/fifth page
	 * @return a button 
	 */
	public Button getBackBtnTop3Pg() {
		// Back button and handler for 3 best matches page
		Button backb1 = new Button("Previous Page");
		backb1.setFont(Font.font("Verdana", 15));
		backb1.setLayoutX(0);
		backb1.setLayoutY(670);
		
		return backb1;
	}
}

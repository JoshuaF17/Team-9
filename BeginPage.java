import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/***
 * This is the object that contains the necessary details to create the first window that the user is greeted with
 * @author Team-9
 */

public class BeginPage {
	public Scene scene1;
	
	public BeginPage() {}

	/***
	 * @return root that makes up the first window
	 */
	public Pane getPage1Root() {
		Pane page1Root = new Pane();

		Rectangle r = new Rectangle(450, 200);
		r.setFill(Color.WHITE);
		page1Root.getChildren().add(r);

		Rectangle r1 = new Rectangle(450, 500);
		r1.setLayoutX(0);
		r1.setLayoutY(200);
		r1.setFill(Color.ORANGE);
		page1Root.getChildren().add(r1);

		Label label1 = new Label("Dog Finder");
		label1.setLayoutX(100);
		label1.setLayoutY(30);
		label1.setFont(Font.font("Verdana", 50));
		page1Root.getChildren().add(label1);

		Image image1 = new Image("file:kid.png");
		ImageView view1 = new ImageView(image1);
		view1.setLayoutX(58);
		view1.setLayoutY(170);
		view1.setFitHeight(290);
		view1.setFitWidth(340);
		page1Root.getChildren().add(view1);
		
		return page1Root;
	}
	
	/***
	 * @return a button for first page, used to go to the second page
	 */
	public Button getButtonPage1() {
		Button b1 = new Button("Let's begin");
		b1.setLayoutX(120);
		b1.setLayoutY(560);
		b1.setFont(Font.font("Verdana", 30));
		
		return b1;
	}
	
	


}

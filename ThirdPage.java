import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/***
 * This object contains the necessary details to create the third page of the program.
 * @author Team-9
 */

public class ThirdPage {
	public Human currentH;
	
	public ThirdPage() {}
	
	public ThirdPage (Human aHuman) {
		currentH = aHuman;
	}
	
	/***
	 * Gets the root (that contains all the javafx code to create the third page).
	 * @return VBox type root
	 */
	public VBox getPage3Root() {
		
		Text info = new Text("For the following questions\nplease refer to this scale\n5 - strongly agree"
				+ "\n4 - agree\n3 - neutral\n2 - disagree\n1 - strongly disagree");
		info.setFont(Font.font("Verdana", 15));

		ComboBox<String> select = new ComboBox<String>();
		select.getItems().addAll("1", "2", "3", "4", "5");

		Label q1 = new Label("I like to socialize.");
		q1.setAlignment(Pos.CENTER);
		q1.setFont(Font.font("Verdana", 20));

		EventHandler<ActionEvent> friendEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				currentH.setFriendly(Double.parseDouble(select.getValue()));
			}
		};
		select.setOnAction(friendEvent);

		ComboBox<String> select2 = new ComboBox<String>();
		select2.getItems().addAll("1", "2", "3", "4", "5");

		Label q2 = new Label("I don't mind cleaning a lot. ");
		q2.setAlignment(Pos.CENTER);
		q2.setFont(Font.font("Verdana", 20));

		EventHandler<ActionEvent> groomEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				currentH.setGroom(Double.parseDouble(select2.getValue()));
			}
		};
		select2.setOnAction(groomEvent);

		ComboBox<String> select3 = new ComboBox<String>();
		select3.getItems().addAll("1", "2", "3", "4", "5");

		Label q3 = new Label("I would be okay if my dog's\n" + "breed had a history of health\nproblems as "
				+ "long as\nthe dog is right for me:\n");
		q3.setAlignment(Pos.CENTER);
		q3.setFont(Font.font("Verdana", 20));

		EventHandler<ActionEvent> healthEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				currentH.setHealth(Double.parseDouble(select3.getValue()));

			}
		};
		select3.setOnAction(healthEvent);

		// Creating third page
		VBox page3Root = new VBox();
		page3Root.getChildren().add(info);
		page3Root.getChildren().add(q1);
		page3Root.getChildren().add(select);
		page3Root.getChildren().add(q2);
		page3Root.getChildren().add(select2);
		page3Root.getChildren().add(q3);
		page3Root.getChildren().add(select3);
		page3Root.setSpacing(15);
		page3Root.setAlignment(Pos.CENTER);
		
		return page3Root;
	}
	
	/***
	 * Creates and gets the button to go to the fourth page
	 * @return a button 
	 */
	public Button getPage3Button() {
		Button pg3BtnToPg4 = new Button("Next");
		return pg3BtnToPg4;
	}

}

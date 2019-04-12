import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/***
 * This object contains the necessary details to create the fourth page of the program.
 * @author Team-9
 */

public class FourthPage {
	public Human currentH;
	
	public FourthPage() {}
	
	public FourthPage(Human aHuman) {
		currentH = aHuman;
	}
	
	/***
	 * Gets the root (that contains all the javafx code to create the fourth page).
	 * @return VBox type root
	 */
	public VBox getPage4Root() {
		
		ComboBox<String> select4 = new ComboBox<String>();
		select4.getItems().addAll("1", "2", "3", "4", "5");

		Label q4 = new Label("I would put a lot\nof time into training\nmy dog");
		q4.setAlignment(Pos.CENTER);
		q4.setFont(Font.font("Verdana", 20));

		EventHandler<ActionEvent> trainEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				currentH.setTrain(Double.parseDouble(select4.getValue()));
				
			}
		};
		
		select4.setOnAction(trainEvent);

		ComboBox<String> select5 = new ComboBox<String>();
		select5.getItems().addAll("1", "2", "3", "4", "5");

		Label q5 = new Label("I do not mind if my\ndog barks");
		q5.setAlignment(Pos.CENTER);
		q5.setFont(Font.font("Verdana", 20));

		EventHandler<ActionEvent> barkEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				currentH.setBark(Double.parseDouble(select5.getValue()));
				
			}
		};
		select5.setOnAction(barkEvent);

		ComboBox<String> select6 = new ComboBox<String>();
		select6.getItems().addAll("1", "2", "3", "4", "5");

		Label q6 = new Label("I would put a lot\nof time into exercising\nmy dog");
		q6.setAlignment(Pos.CENTER);
		q6.setFont(Font.font("Verdana", 20));

		EventHandler<ActionEvent> exerciseEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				currentH.setExercise(Double.parseDouble(select6.getValue()));
				
			}
		};
		select6.setOnAction(exerciseEvent);

		Label sizeQ = new Label("What size of dog\ndo you prefer?");
		sizeQ.setFont(Font.font("Verdana", 20));

		RadioButton rbSmall = new RadioButton();
		rbSmall.setText("Small");
		rbSmall.setUserData("1");

		RadioButton rbMedium = new RadioButton();
		rbMedium.setText("Medium");
		rbMedium.setUserData("3");

		RadioButton rbLarge = new RadioButton();
		rbLarge.setText("Large");
		rbLarge.setUserData("5");

		ToggleGroup sizeToggleGroup = new ToggleGroup();

		rbSmall.setToggleGroup(sizeToggleGroup);
		rbMedium.setToggleGroup(sizeToggleGroup);
		rbLarge.setToggleGroup(sizeToggleGroup);

		// add listener to toggleGroup
		sizeToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				if (sizeToggleGroup != null) {
					if (sizeToggleGroup.getSelectedToggle().getUserData().toString() == "1") {
						currentH.setSize(1);
					} else if (sizeToggleGroup.getSelectedToggle().getUserData().toString() == "3") {
						currentH.setSize(3);
					} else if (sizeToggleGroup.getSelectedToggle().getUserData().toString() == "5") {
						currentH.setSize(5);
					}
				}
			}

		});
		

		// Creating the fourth page
		VBox page4Root = new VBox();
		page4Root.getChildren().add(q4);
		page4Root.getChildren().add(select4);
		page4Root.getChildren().add(q5);
		page4Root.getChildren().add(select5);
		page4Root.getChildren().add(q6);
		page4Root.getChildren().add(select6);
		page4Root.getChildren().add(sizeQ);
		page4Root.getChildren().add(rbSmall);
		page4Root.getChildren().add(rbMedium);
		page4Root.getChildren().add(rbLarge);
		page4Root.setSpacing(15);
		page4Root.setAlignment(Pos.CENTER);
		
		return page4Root;
		
	}
	/***
	 * Creates and gets the button to go from the fourth page to the fifth page, indicating the user is finished
	 * with the survey.
	 * @return a button 
	 */
	public Button getPage4Button() {
		Button finishedBtn = new Button("I'm finished!");
		return finishedBtn;
	}

}

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/***
 * This object contains the necessary details to create the second page of the program.
 * @author Team-9
 */
public class SecondPage {
	public Human currentH;
	
	public SecondPage() {}
	// constructor for SecondPage
	public SecondPage(Human aHuman) {
		currentH = aHuman;
	}
	
	/***
	 * Gets the root (that contains all the javafx code to create the second page).
	 * @return VBox type root
	 */
	public VBox getPage2Root(Human aHuman) {
		currentH = aHuman;
		VBox page2Root = new VBox(20);


		Label ownerQ = new Label("Have you ever owned a dog before?");
		ownerQ.setFont(Font.font("Verdana", 20));

		// Create radio buttons for yes or no to new owner question
		RadioButton rbYes = new RadioButton();
		rbYes.setText("Yes");
		rbYes.setUserData("1");

		RadioButton rbNo = new RadioButton();
		rbNo.setText("No");
		rbNo.setUserData("0");

		ToggleGroup newToggleGroup = new ToggleGroup();

		rbYes.setToggleGroup(newToggleGroup);
		rbNo.setToggleGroup(newToggleGroup);

		// add listener to toggleGroup
		newToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				if (newToggleGroup != null) {
					if (newToggleGroup.getSelectedToggle().getUserData().toString() == "1") {
						currentH.setNewOwn(1);
					} 
					else if (newToggleGroup.getSelectedToggle().getUserData().toString() == "0") {
						currentH.setNewOwn(0);
				}
			}
			}
		});

		page2Root.getChildren().add(ownerQ);
		page2Root.getChildren().add(rbYes);
		page2Root.getChildren().add(rbNo);
		
		// aligning the root
		page2Root.setAlignment(Pos.CENTER);
		
		return page2Root;
	}
	
	/***
	 * Creates and gets the button to go to possible dogs page
	 * @return a button 
	 */
	public Button getPg2DogsBtn() {
		Button viewDogsBtn = new Button("View Possible Dogs");
		viewDogsBtn.setFont(Font.font("Trajan", 25));
		viewDogsBtn.setLayoutX(220);
		viewDogsBtn.setLayoutY(0);
		
		return viewDogsBtn;
	}
	/***
	 * Creates and gets the button to go to the third page
	 * @return a button 
	 */
	public Button getPg2ContinueBtn() {
		Button nextPgBtn = new Button("Continue to next page");
		return nextPgBtn;
	}

}

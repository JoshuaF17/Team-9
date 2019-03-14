import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DropdownMenu extends Application {

	public void start(Stage primaryStage) {

		// Resources:
		// https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
		// http://www.java2s.com/Tutorials/Java/JavaFX/0590__JavaFX_ComboBox.htm
		// https://www.geeksforgeeks.org/javafx-combobox-with-examples/
		// http://www.learningaboutelectronics.com/Articles/How-to-create-multiple-scenes-and-switch-between-scenes-in-JavaFX.php

		// Resources:
		// widgetDemo.java in dropbox folder by Nathaly Veerwal
		// https://stackoverflow.com/questions/46486750/javafx-center-button-in-vbox?rq=1
		// https://www.tutorialspoint.com/javafx/javafx_colors.htm\

		// Create profile to store values in
		Human profile1 = new Human();
		
		// Creating the first(Q) page
		VBox root = new VBox();
		TextField nameField = new TextField();
		VBox page1Box = new VBox(10);
		
		// FIRST PAGE
		Pane gRoot = new Pane();

		Rectangle r = new Rectangle(450, 200);
		r.setFill(Color.WHITE);
		gRoot.getChildren().add(r);

		Rectangle r1 = new Rectangle(450, 500);
		r1.setLayoutX(0);
		r1.setLayoutY(200);
		r1.setFill(Color.ORANGE);
		gRoot.getChildren().add(r1);

		Label label1 = new Label("Dog Finder");
		label1.setLayoutX(100);
		label1.setLayoutY(30);
		label1.setFont(Font.font("Verdana", 50));
		gRoot.getChildren().add(label1);

		Image image1 = new Image("Kid.png");
		ImageView view1 = new ImageView(image1);
		view1.setLayoutX(58);
		view1.setLayoutY(170);
		view1.setFitHeight(290);
		view1.setFitWidth(340);
		gRoot.getChildren().add(view1);
					
		Button b1 = new Button("Let's begin");
		b1.setLayoutX(120);
		b1.setLayoutY(560);
		b1.setFont(Font.font("Verdana", 30));
		gRoot.getChildren().add(b1);
						
		// Creating and showing the FIRST(G) page
		Scene scene1 = new Scene(gRoot, 450, 700);
		primaryStage.setTitle("Dog Finder");
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		// Going to page 2
		Scene firstScene = new Scene(page1Box, 450, 700);
		b1.setOnAction(e -> primaryStage.setScene(firstScene));
		
		// SECOND PAGE
		EventHandler<ActionEvent> nameEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (nameField != null) {
					profile1.setName(nameField.getText());
					System.out.println(profile1.getName());
				}
			}
		};

		nameField.setOnAction(nameEvent);
		
		Label profileName = new Label("Name (press enter to confirm):");
		profileName.setFont(Font.font("Verdana", 15));
	
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
						profile1.setNewOwn(1);
					} 
					else if (newToggleGroup.getSelectedToggle().getUserData().toString() == "0") {
						profile1.setNewOwn(0);
				}
			}
			}
		});

		Button nextPgBtn = new Button("Continue to next page");
		
		// Creating the second page
		page1Box.getChildren().add(profileName);
		page1Box.getChildren().add(nameField);
		page1Box.getChildren().add(ownerQ);
		page1Box.getChildren().add(rbYes);
		page1Box.getChildren().add(rbNo);
		page1Box.getChildren().add(nextPgBtn);
		page1Box.setAlignment(Pos.CENTER);

		// Going to page 3
		Scene newScene = new Scene(root, 450, 700);
		nextPgBtn.setOnAction(e -> primaryStage.setScene(newScene));
		
		// THIRD PAGE
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
				profile1.setFriendly(Double.parseDouble(select.getValue()));
				System.out.println("Friendly Score: " + profile1.getFriendly());
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
				profile1.setGroom(Double.parseDouble(select2.getValue()));
				System.out.println("Groom score: " + profile1.getGroom());
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
				profile1.setHealth(Double.parseDouble(select3.getValue()));
				System.out.println("Health Score: " + profile1.getHealth());
			}
		};
		select3.setOnAction(healthEvent);

		// Creating third page
		root.getChildren().add(info);
		root.getChildren().add(q1);
		root.getChildren().add(select);
		root.getChildren().add(q2);
		root.getChildren().add(select2);
		root.getChildren().add(q3);
		root.getChildren().add(select3);
		Button nextPage = new Button("Next");
		root.getChildren().add(nextPage);
		root.setSpacing(15);
		root.setAlignment(Pos.CENTER);
		
		// Going to page 4
		VBox root2 = new VBox();
		Scene scene2 = new Scene(root2, 450, 700);
		nextPage.setOnAction(e -> primaryStage.setScene(scene2));


		// FOURTH PAGE
		ComboBox<String> select4 = new ComboBox<String>();
		select4.getItems().addAll("1", "2", "3", "4", "5");

		Label q4 = new Label("I would put a lot\nof time into training\nmy dog");
		q4.setAlignment(Pos.CENTER);
		q4.setFont(Font.font("Verdana", 20));

		EventHandler<ActionEvent> trainEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				profile1.setTrain(Double.parseDouble(select4.getValue()));
				System.out.println("Training Score: " + profile1.getTrain());
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
				profile1.setBark(Double.parseDouble(select5.getValue()));
				System.out.println("Bark Score: " + profile1.getBark());
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
				profile1.setExercise(Double.parseDouble(select6.getValue()));
				System.out.println("Exercise Score: " + profile1.getExercise());
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
						profile1.setSize(1);
					} else if (sizeToggleGroup.getSelectedToggle().getUserData().toString() == "3") {
						profile1.setSize(3);
					} else if (sizeToggleGroup.getSelectedToggle().getUserData().toString() == "5") {
						profile1.setSize(5);
					}
					// System.out.println(sizeToggleGroup.getSelectedToggle().getUserData().toString());
					// System.out.println(profile.getNewOwn());
				}
			}

		});
		
		Button finished = new Button("I'm finished!");
		
		// Creating the fourth page
		root2.getChildren().add(q4);
		root2.getChildren().add(select4);
		root2.getChildren().add(q5);
		root2.getChildren().add(select5);
		root2.getChildren().add(q6);
		root2.getChildren().add(select6);
		root2.getChildren().add(sizeQ);
		root2.getChildren().add(rbSmall);
		root2.getChildren().add(rbMedium);
		root2.getChildren().add(rbLarge);
		root2.getChildren().add(finished);
		root2.setSpacing(15);
		root2.setAlignment(Pos.CENTER);
		
		// Going to the final (5) page
		VBox root3 = new VBox();
		Scene scene3 = new Scene(root3, 450, 700);
		finished.setOnAction(e -> primaryStage.setScene(scene3));
		
		// FINAL PAGE



	}

}

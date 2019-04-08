import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;

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

	public class DropdownMenu1 extends Application {
		
		public void start(Stage primaryStage) {

			// Resources:
			// Help from a friend: Mason Lieu
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
			VBox page1Box = new VBox(20);

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
			
			Button viewdogs = new Button("View Possible Dogs");
			viewdogs.setFont(Font.font("Trajan", 25));
			viewdogs.setLayoutX(220);
			viewdogs.setLayoutY(0);
			
			//dogs page
			Pane dogs = new Pane();
			Scene dogs1 = new Scene(dogs, 450, 700);
			viewdogs.setOnAction(e -> primaryStage.setScene(dogs1));
			
			Rectangle whiteRectangle1 = new Rectangle(450,200);
			whiteRectangle1.setFill(Color.WHITE);
			
			Rectangle orangeRectangle1 = new Rectangle(450,500);
			orangeRectangle1.setLayoutX(0);
			orangeRectangle1.setLayoutY(200);
			orangeRectangle1.setFill(Color.ORANGE);
			
			Label dogs2 = new Label(DogBreed.dognames());
			dogs2.setLayoutX(0);
			dogs2.setLayoutY(200);
			dogs2.setTextFill( Color.BLACK );
			dogs2.setFont(Font.font ("Trajan", 25));
			
			Label dogs3 = new Label(DogBreed.dognames1());
			dogs3.setLayoutX(0);
			dogs3.setLayoutY(250);
			dogs3.setTextFill( Color.BLACK );
			dogs3.setFont(Font.font ("Trajan", 25));
			
			Label dogs4 = new Label(DogBreed.dognames2());
			dogs4.setLayoutX(0);
			dogs4.setLayoutY(300);
			dogs4.setTextFill( Color.BLACK );
			dogs4.setFont(Font.font ("Trajan", 25));
			
			Label dogs5 = new Label(DogBreed.dognames3());
			dogs5.setLayoutX(0);
			dogs5.setLayoutY(350);
			dogs5.setTextFill( Color.BLACK );
			dogs5.setFont(Font.font ("Trajan", 25));
			
			Label dogs6 = new Label(DogBreed.dognames4());
			dogs6.setLayoutX(0);
			dogs6.setLayoutY(0);
			dogs6.setTextFill( Color.BLACK );
			dogs6.setFont(Font.font ("Trajan", 20));
			
			Label dogs7 = new Label(DogBreed.dognames5());
			dogs7.setLayoutX(7);
			dogs7.setLayoutY(50);
			dogs7.setTextFill( Color.BLACK );
			dogs7.setFont(Font.font ("Trajan", 20));
			
			Label dogs8 = new Label(DogBreed.dognames6());
			dogs8.setLayoutX(0);
			dogs8.setLayoutY(100);
			dogs8.setTextFill( Color.BLACK );
			dogs8.setFont(Font.font ("Trajan", 20));
			
			Button backB = new Button("Previous Page");
			backB.setFont(Font.font("Verdana", 15));
			backB.setLayoutX(0);
			backB.setLayoutY(670);
			backB.setOnAction(f -> primaryStage.setScene(firstScene));
			
			
			//creating dogs page
			dogs.getChildren().add(whiteRectangle1);
			dogs.getChildren().add(orangeRectangle1);
			dogs.getChildren().add(dogs2);
			dogs.getChildren().add(dogs3);
			dogs.getChildren().add(dogs4);
			dogs.getChildren().add(dogs5);
			dogs.getChildren().add(dogs6);
			dogs.getChildren().add(dogs7);
			dogs.getChildren().add(dogs8);
			dogs.getChildren().add(backB);
			
			// Creating the second page
			page1Box.getChildren().add(viewdogs);
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
			
			
			finished.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					DogFinder aDogFinder;
					String bdog1 = "", bdog2 = "", bdog3= "";
					String bdogimage1 ="", bdogimage2="", bdogimage3="";
					
					try {
						
						aDogFinder = new DogFinder(profile1);
						System.out.println("Check to see if profile updated their traits: "
								+ "Exercise score: " + profile1.getExercise() + "Bark Score: "+ profile1.getBark());
						aDogFinder.compareHumanToDogs(profile1);
						bdog1 = aDogFinder.compareScores();
						bdogimage1 = aDogFinder.getImage();
						bdog2 = aDogFinder.compareScores2();
						bdogimage2 = aDogFinder.getImage2();
						bdog3 = aDogFinder.compareScores3();
						bdogimage3 = aDogFinder.getImage3();
						
						
						System.out.println(bdog1 + bdog2);
						//setBdog(bdog1, bdog2);
						
					} catch (IOException e1) {
						e1.printStackTrace();	
					}
					
					Pane root3 = new Pane();
			
			        Rectangle r5 = new Rectangle(450, 200);
					r5.setFill(Color.WHITE);
			
					Rectangle r6 = new Rectangle(450, 500);
					r6.setLayoutX(0);
					r6.setLayoutY(200);
					r6.setFill(Color.ORANGE);
			
					Button reButton = new Button("Restart Survey");
					reButton.setFont(Font.font("Verdana", 15));
					reButton.setLayoutX(0);
					reButton.setLayoutY(670);
					reButton.setOnAction(f -> primaryStage.setScene(scene1));
			
					Button perfectButton = new Button("Find Perfect Match!");
					perfectButton.setFont(Font.font("Verdana", 30));
					perfectButton.setLayoutX(70);
					perfectButton.setLayoutY(480);
		
					Button threeBestMatchButton = new Button("Find 3 Best Matches!");
					threeBestMatchButton.setFont(Font.font("Verdana", 28));
					threeBestMatchButton.setLayoutX(70);
					threeBestMatchButton.setLayoutY(300);
					
					root3.getChildren().add(r5);
					root3.getChildren().add(r6);
					root3.getChildren().add(reButton);
					root3.getChildren().add(perfectButton);
					root3.getChildren().add(threeBestMatchButton);
					
					Scene scene3 = new Scene(root3, 450, 700);
			        primaryStage.setScene(scene3);
			        primaryStage.setTitle("Dog Finder");
			        primaryStage.show();
					
					Pane finalRoot = new Pane();
					Pane finalRoot1 = new Pane();
			
					//Going to perfect match page
					Scene scene4 = new Scene(finalRoot, 450, 700);
					perfectButton.setOnAction(f -> primaryStage.setScene(scene4));
					
					// Going to three best matches page
					Scene scene5 = new Scene(finalRoot1, 450, 700);
					threeBestMatchButton.setOnAction(f -> primaryStage.setScene(scene5));
					
					
					// PERFECT MACTH PAGE
					Rectangle whiteRectangle = new Rectangle(450,200);
					whiteRectangle.setFill(Color.WHITE);
				  
					Rectangle orangeRectangle = new Rectangle(450,500);
					orangeRectangle.setLayoutX(0);
					orangeRectangle.setLayoutY(200);
					orangeRectangle.setFill(Color.ORANGE);
					
					Label labelPerfect1 = new Label(" Perfect Match ");
					labelPerfect1.setLayoutX(82);
					labelPerfect1.setLayoutY(30);
					labelPerfect1.setTextFill( Color.BLACK );
					labelPerfect1.setFont(Font.font ("Impact", 50));
					
					Label labelPerfect2 = new Label(" Perfect Match ");
					labelPerfect2.setLayoutX(90);
					labelPerfect2.setLayoutY(30);
					labelPerfect2.setTextFill(Color.ORANGE);
					labelPerfect2.setFont(Font.font ("Impact", 50));
					
					Label perfectDog = new Label(bdog1);
					perfectDog.setLayoutX(110);
					perfectDog.setLayoutY(520);
					perfectDog.setTextFill(Color.BLACK);
					perfectDog.setFont(Font.font ("Impact", 35));
					
					// Back button and handler for best match page
					Button backb = new Button("Previous Page");
			        backb.setFont(Font.font("Verdana", 15));
			        backb.setLayoutX(0);
			        backb.setLayoutY(670);
					backb.setOnAction(f -> primaryStage.setScene(scene3));

					System.out.println("###: " + bdog1 + bdog2);
					
					Image image3 = new Image(bdogimage1);
					ImageView bestDogImageView = new ImageView (image3);
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
					finalRoot.getChildren().add(backb);
					
					// 3 BEST MATCHES PAGE
					Rectangle whiteRectangle2 = new Rectangle(450,200);
					whiteRectangle2.setFill(Color.WHITE);
				  
					Rectangle orangeRectangle2 = new Rectangle(450,500);
					orangeRectangle2.setLayoutX(0);
					orangeRectangle2.setLayoutY(200);
					orangeRectangle2.setFill(Color.ORANGE);
					
					Label threeBestMatches = new Label(" 3 Best Matches ");
					threeBestMatches.setLayoutX(82);
					threeBestMatches.setLayoutY(30);
					threeBestMatches.setTextFill( Color.BLACK );
					threeBestMatches.setFont(Font.font ("Impact", 50));
					
					Label threeBestMatches2 = new Label(" 3 Best Matches ");
					threeBestMatches2.setLayoutX(90);
					threeBestMatches2.setLayoutY(30);
					threeBestMatches2.setTextFill(Color.ORANGE);
					threeBestMatches2.setFont(Font.font ("Impact", 50));
					
					Label bestDog1 = new Label(bdog1);
					bestDog1.setLayoutX(0);
					bestDog1.setLayoutY(330);
					bestDog1.setTextFill(Color.BLACK);
					bestDog1.setFont(Font.font ("Impact", 30));
					
					Label bestDog2 = new Label(bdog2);
					bestDog2.setLayoutX(270);
					bestDog2.setLayoutY(330);
					bestDog2.setTextFill(Color.BLACK);
					bestDog2.setFont(Font.font ("Impact", 30));
					
					Label bestDog3 = new Label(bdog3);
					bestDog3.setLayoutX(155);
					bestDog3.setLayoutY(620);
					bestDog3.setTextFill(Color.BLACK);
					bestDog3.setFont(Font.font ("Impact", 30));
					
					// Back button and handler for 3 best matches page
					Button backb1 = new Button("Previous Page");
			        backb1.setFont(Font.font("Verdana", 15));
			        backb1.setLayoutX(0);
			        backb1.setLayoutY(670);
					backb1.setOnAction(f -> primaryStage.setScene(scene3));
			        
					System.out.println("###: " + bdog1 + bdogimage1);
					
					Image bestDogImage1 = new Image(bdogimage1);
					ImageView bestDogImageView1 = new ImageView (bestDogImage1);
					bestDogImageView1.setLayoutX(0);
					bestDogImageView1.setLayoutY(120);
					bestDogImageView1.setFitHeight(200);
					bestDogImageView1.setFitWidth(210);
					
					Image bestDogImage2 = new Image(bdogimage2);
					ImageView bestDogImageView2 = new ImageView (bestDogImage2);
					bestDogImageView2.setLayoutX(250);
					bestDogImageView2.setLayoutY(120);
					bestDogImageView2.setFitHeight(200);
					bestDogImageView2.setFitWidth(210);
					
					Image bestDogImage3 = new Image(bdogimage3);
					ImageView bestDogImageView3 = new ImageView (bestDogImage3);
					bestDogImageView3.setLayoutX(120);
					bestDogImageView3.setLayoutY(400);
					bestDogImageView3.setFitHeight(210);
					bestDogImageView3.setFitWidth(200);

					// creating the three best matches page
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
					finalRoot1.getChildren().add(backb1);
					
					
				}
			});
		}
	}

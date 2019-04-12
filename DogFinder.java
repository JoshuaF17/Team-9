import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
/***
 * DogFinder runs the application and creates the necessary windows. It also sets actions to the 
 * buttons on all the windows. 
 * @author Team-9
 *
 */
public class DogFinder extends Application {
	// variable to hold the current stage
	Stage currentStage;
	
	// human object
	Human currentHuman = new Human();
	
	// new set of lists
	Lists currentLists = new Lists();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		currentStage = primaryStage;
		 
		// load all lists
		currentLists.loadDogs("DogDataset.txt");
		currentLists.loadDogNames();
		currentLists.loadQuestions("Questions.txt");
		
		// create the first page
		BeginPage page1 = new BeginPage();
		Pane page1Root = page1.getPage1Root();
		Button pg1BtnToPg2 = page1.getButtonPage1();
		page1Root.getChildren().add(pg1BtnToPg2);
		Scene page1Scene = new Scene(page1Root, 450, 700);
		
		// create the second page
		SecondPage page2 = new SecondPage();
		VBox page2Root = page2.getPage2Root(currentHuman);
		Button pg2BtnToPg3 = page2.getPg2ContinueBtn();
		Button pg2BtnToDogsPg = page2.getPg2DogsBtn();
		page2Root.getChildren().addAll(pg2BtnToPg3, pg2BtnToDogsPg);
		Scene page2Scene = new Scene(page2Root, 450, 700);
		
		// create the third page
		ThirdPage page3 = new ThirdPage(currentHuman);
		VBox page3Root = page3.getPage3Root();
		Button pg3BtnToPg4 = page3.getPage3Button();
		page3Root.getChildren().add(pg3BtnToPg4);
		Scene page3Scene = new Scene(page3Root, 450, 700);
		
		// create the possible dogs page
		PossibleDogsPage pdPage = new PossibleDogsPage(currentLists);
		Pane pdPageRoot = pdPage.getPossibleDogsRoot();
		Button pdPgPrevBtn = pdPage.getPreviousBtn();
		pdPageRoot.getChildren().add(pdPgPrevBtn);
		Scene pdScene = new Scene (pdPageRoot, 450, 700);
		
		// create the fourth page
		FourthPage page4 = new FourthPage(currentHuman);
		VBox page4Root = page4.getPage4Root();
		Button pg4BtnToPg5 = page4.getPage4Button();
		page4Root.getChildren().add(pg4BtnToPg5);
		Scene page4Scene = new Scene(page4Root, 450, 700);
		
		// create the fifth page
		FifthPage page5 = new FifthPage();
		Pane page5Root = page5.getPage5Root();
		Button restartSurveyBtn = page5.getRestartSurveyBtn();
		Button pg5ToBestMatchPg = page5.getPerfectMatchBtn();
		Button pg5ToTop3MatchesPg = page5.getTop3MatchesButton();
		page5Root.getChildren().addAll(restartSurveyBtn, pg5ToBestMatchPg, pg5ToTop3MatchesPg);
		Scene page5Scene = new Scene(page5Root, 450, 700);
		
		
		// create bestMatchPage
		PerfectMatchPage perfectMatchPg = new PerfectMatchPage();
		Pane perfectMatchPgRoot = perfectMatchPg.getBestMatchPageRoot(currentHuman, currentLists);
		Button goBackToPg5 = perfectMatchPg.getBackBtnOnBestMatchPg();
		perfectMatchPgRoot.getChildren().add(goBackToPg5);
		Scene perfectMatchPgScene = new Scene(perfectMatchPgRoot, 450, 700);
		
		
		// create top3matches page
		Top3MatchesPage top3MatchPg = new Top3MatchesPage();
		Pane top3MatchPgRoot = top3MatchPg.getTop3MatchesPage(currentHuman, currentLists);
		Button top3PgBackBtn = top3MatchPg.getBackBtnTop3Pg();
		top3MatchPgRoot.getChildren().add(top3PgBackBtn);
		Scene top3MatchesPgScene = new Scene(top3MatchPgRoot, 450, 700);
		
		// set actions to all buttons to redirect to correct scenes 
		pg1BtnToPg2.setOnAction(a -> currentStage.setScene(page2Scene));
		pg2BtnToPg3.setOnAction(b -> currentStage.setScene(page3Scene));
		pg2BtnToDogsPg.setOnAction(c -> currentStage.setScene(pdScene));
		pdPgPrevBtn.setOnAction(d -> currentStage.setScene(page2Scene));
		pg3BtnToPg4.setOnAction(e -> currentStage.setScene(page4Scene));
		pg4BtnToPg5.setOnAction(f -> currentStage.setScene(page5Scene));
		restartSurveyBtn.setOnAction(g -> currentStage.setScene(page2Scene));
		pg5ToBestMatchPg.setOnAction(z ->currentStage.setScene(perfectMatchPgScene));
		pg5ToTop3MatchesPg.setOnAction(i -> currentStage.setScene(top3MatchesPgScene));
		goBackToPg5.setOnAction(j -> currentStage.setScene(page5Scene));
		top3PgBackBtn.setOnAction(k -> currentStage.setScene(page5Scene));
		
		// start the program with first scene
		currentStage.setTitle("Dog Finder");
		currentStage.setScene(page1Scene);
		currentStage.show();
	}
	
	// launch the program
	public static void main(String[] args) throws Exception {
		launch(args);
	}
}
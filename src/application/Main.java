package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.application.Timers;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Type Racer Clone");
			
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(2, 10, 10, 10));
			
			Text scenetitle = new Text("Race On!");
			//specify where to add (col, row, colspan, rowspan)
			grid.add(scenetitle, 0, 0, 2, 1);
			
			TextField timeDisp = new TextField();
			
			Timers timer = new Timers(timeDisp);
			timeDisp.setEditable(false);
			timer.start();
			grid.add(timeDisp, 3,0 );
			
			TextField textDisp = new TextField();
			textDisp.setEditable(false);
			textDisp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			textDisp.setText( "Oi matey!");
			grid.add(textDisp, 0, 2);
			
			TextField textInput = new TextField();
			boolean completed = false;
			textInput.setOnKeyReleased(new EventHandler<InputEvent>() {
				String currentUserIn;
				String currentTextProgress;
				@Override
				public void handle(InputEvent arg0) {
					currentUserIn = textInput.getText();
					if (currentUserIn.length() >= textDisp.getText().length() && completed == true) {
						System.out.println("youre done");
						timer.stopCounting();
						return;
					}
					
					currentTextProgress = textDisp.getText().substring(0, currentUserIn.length());
					
					
					if (currentUserIn.equals(currentTextProgress) == false) {
						//textInput.setStyle("-fx-text-inner-color: red");
						System.out.println("!");
					}
					
					
				}
				
			});
			grid.add(textInput, 0, 3);
			
			
			Scene scene = new Scene(grid, 300, 275);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public int wpmCalc(int seconds, int numChars) {
		float secToMin = seconds/60;
		float numWords = numChars/5;
		return Math.round(numWords/secToMin);
	}
	
	public String getRaceString(File file) {
		String text = "temp";
		return text;
	}
	
}

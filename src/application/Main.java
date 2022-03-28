package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//Author Name: Bijan Amirzadehasl
//Date: 3/5/2022
//Program Name: Amirzadehasl_GUI_Occurences_Word
//Purpose: Create a Gui that accepts a user text file and displays
// the top 20 words based on number of occurrences

/**
 * 
 * @author Andrew Amirzadehasl
 * @version 03/28/2022
 *
 */
public class Main extends Application{

	@Override
	public void start(Stage stage) {

		Group root = new Group();
		Scene scene = new Scene(root, 600,600, Color.BLACK);
		stage.setTitle("Word Occurrences GUI");

		TextField textfield = new TextField();
		textfield.setLayoutX(110);
		textfield.setPrefWidth(450);
		textfield.setLayoutY(20);

		Text output = new Text();
		output.setFill(Color.LIMEGREEN);
		output.setLayoutX(25);
		output.setLayoutY(70);

		Button button1 = new Button();
		button1.setText("Choose your file");
		button1.setLayoutY(20);
		button1.setLayoutX(5);

		FileChooser fc = new FileChooser();

		button1.setOnAction(e -> {
			File file = fc.showOpenDialog(stage);
			if (file != null) {
				textfield.setText(file.getAbsolutePath());
				try {
					Scanner reader = new Scanner(file);
					TreeMap<String, Integer> tm = new TreeMap<>();
					while (reader.hasNext()) {
						String word = reader.next().toLowerCase();
						Integer count = tm.get(word);
						if(count != null)
							count++;
						else
							count = 1;
						tm.put(word, count);
					}
					Set<Map.Entry<String, Integer>> set = tm.entrySet();
					List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(set);
					Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>()
							{
						@Override
						public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b )
						{
							return (b.getValue()).compareTo( a.getValue() );
						}
							} );

					StringBuilder messageContent = new StringBuilder("");

					int forCounter = 0;
					for(Map.Entry<String, Integer> i:sortedList){

						messageContent.append(i.getKey() + " occurs this many times: "+ i.getValue());
						messageContent.append("\n");
						forCounter++;
						if (forCounter >= 20) {
							break;
						}

						reader.close();
					}

					output.setText("The top twenty words are: \n\n" + messageContent.toString() + "\n" + sayThankYou());



				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					output.setText("File not found! :(");
					//e1.printStackTrace();
				}
			}
			else {
				textfield.setText("Please insert a file...");
			}

		});

		root.getChildren().addAll(button1, textfield, output);
		Image icon = new Image("Index.png");
		stage.getIcons().add(icon);


		stage.setScene(scene);
		stage.show();
	}
/**
 * 
 * @param args generated for javafx
 */
	public static void main(String[] args) {
		launch(args);
	}
	/**
	 * 
	 * @return method to run satisfy test requirements
	 */
	public static String sayThankYou() {
		return "Thank you for using the program Professor Shah!";
	}
	/**
	 * 
	 * @param x
	 * @return
	 */
	public static int countUniqueWords(Map<String, Integer> x) {
		int count = 0;
		/**
		 * for each loop with count being the incrementer if it is found
		 */
		for (Map.Entry<String, Integer> i : x.entrySet()) {
			count++;
		}
		
		return count;
	}
	
	public static double squareNum(double x) {
		return x * x;
	}


}

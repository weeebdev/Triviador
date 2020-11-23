package sample;
import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.geometry.*;

public class QuestionAdder
{
	public void start()
	{
		Stage primaryStage = new Stage();
		GridPane pane = new GridPane();
		Label labelForDes = new Label("Description: ");
		labelForDes.setFont(Font.font("Verdana",15));
		Label labelForAns = new Label("Answer: ");
		labelForAns.setFont(Font.font("Verdana",15));
		Label labelForOp1 = new Label("Option 1: ");
		labelForOp1.setFont(Font.font("Verdana",15));
		Label labelForOp2 = new Label("Option 2: ");
		labelForOp2.setFont(Font.font("Verdana",15));
		Label labelForOp3 = new Label("Option 3: ");
		labelForOp3.setFont(Font.font("Verdana",15));

		TextField fieldForDes = new TextField();
		TextField fieldForAns = new TextField();
		TextField fieldForOp1 = new TextField();
		TextField fieldForOp2 = new TextField();
		TextField fieldForOp3 = new TextField();

		pane.add(labelForDes, 0, 0);
		pane.add(fieldForDes, 1, 0);
		pane.add(labelForAns, 0, 1);
		pane.add(fieldForAns, 1, 1);
		pane.add(labelForOp1, 0, 2);
		pane.add(labelForOp2, 0, 3);
		pane.add(labelForOp3, 0, 4);
		pane.add(fieldForOp1, 1, 2);
		pane.add(fieldForOp2, 1, 3);
		pane.add(fieldForOp3, 1, 4);
		pane.setVgap(5);

		Button btAdd = new Button("ADD");
		HBox hbox = new HBox();
		hbox.getChildren().add(btAdd);
		hbox.setAlignment(Pos.CENTER);

		Stage stage = new Stage();
		StackPane paneForStage = new StackPane();
		Text text = new Text();
		text.setFont(Font.font("Verdana", 15));
		paneForStage.getChildren().add(text);

		Scene scene2 = new Scene(paneForStage);
		stage.setScene(scene2);

		btAdd.setOnAction(e -> {
			if(fieldForDes.getText().equals(""))
			{
				text.setText("Description field is empty!");
				stage.show();
			}
			else if(fieldForAns.getText().isEmpty())
			{
				text.setText("Answer field is empty!");
				stage.show();
			}
			else if(fieldForOp1.getText().isEmpty())
			{
				text.setText("Option 1 field is empty!");
				stage.show();
			}
			else if(fieldForOp2.getText().isEmpty())
			{
				text.setText("Option 2 field is empty!");
				stage.show();
			}
			else if(fieldForOp3.getText().isEmpty())
			{
				text.setText("Option 3 field is empty!");
				stage.show();
			}
			else
			{
				try
				{
					FileWriter fw = new FileWriter("src/sample/assets/Questions.txt", true);
					PrintWriter output = new PrintWriter(fw);
					File file = new File("src/sample/assets/Questions.txt");
					Scanner ch = new Scanner(file);

					if(!ch.hasNext())
					{
						output.println(fieldForDes.getText());
						output.println(fieldForAns.getText());
						output.println(fieldForOp1.getText());
						output.println(fieldForOp2.getText());
						output.println(fieldForOp3.getText());
					}
					else
					{
						output.println();
						output.println(fieldForDes.getText());
						output.println(fieldForAns.getText());
						output.println(fieldForOp1.getText());
						output.println(fieldForOp2.getText());
						output.println(fieldForOp3.getText());
					}
					output.close();

					fieldForOp3.setText("");
					fieldForOp2.setText("");
					fieldForOp1.setText("");
					fieldForAns.setText("");
					fieldForDes.setText("");

					text.setText("The question has been added");
					stage.show();
				}
				catch(IOException i)
				{
					System.out.println("Some error happeneds");
				}

			}
		});

		BorderPane mainPane = new BorderPane();
		mainPane.setCenter(pane);
		mainPane.setBottom(hbox);
		mainPane.setPadding(new Insets(5,5,5,5));

		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Add question");
		primaryStage.show();
	}
	public static void main(String[] args) throws IOException
	{
		Application.launch(args);
	}
}
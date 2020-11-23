package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.*;
import javafx.stage.Stage;

public class Menu {

    @FXML
    private Button playButton;

    @FXML
    private TextField redPlayerName;

    @FXML
    private Label blueLabel;

    @FXML
    private Label redLabel;
    @FXML
    private Button redPlayerButton;
    @FXML
    private Button questionManager;
    @FXML
    private TextField bluePlayerName;

    @FXML
    private Button options;

    @FXML
    private Button bluePlayerButton;

    @FXML
    void bluePlayer_akt(ActionEvent event) {
        Main.bluePlayerN=bluePlayerName.getText();
        blueLabel.setText(Main.bluePlayerN);
    }

    @FXML
    void options_akt(ActionEvent event) {
        options.setText(String.valueOf(Integer.parseInt(options.getText())+1));
    }
    @FXML
    void redPlayer_akt(ActionEvent event) {
        Main.redPlayerN=redPlayerName.getText();
        redLabel.setText(Main.redPlayerN);
    }
    @FXML
    void questionManager_akt(ActionEvent event) {
        QuestionAdder ques = new QuestionAdder();
        ques.start();
    }
    @FXML
    void playButton_akt(ActionEvent event) throws Exception {
        Controller.quiz.shuffle();
        Main.counter=0;
        Main.pointsBlue=0;
        Main.pointsRed=0;
        Stage primaryStage = new Stage();
        Parent rootMenu = FXMLLoader.load(getClass().getResource("sample.fxml"));




        primaryStage.setTitle("Gravity");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(rootMenu, 800, 600));
        primaryStage.show();
        if(Main.counter>30){
            primaryStage.close();
        }
    }
}

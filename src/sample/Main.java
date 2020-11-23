package sample;
import javafx.scene.text.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;



public class Main extends Application {
    private int n;
    static int counter = 0;
    static int pointsRed = 0;
    static int pointsBlue = 0;
    static String redPlayerN = "Player 1";
    static String bluePlayerN = "Player 2";
    static boolean flag = true;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent rootMenu = FXMLLoader.load(getClass().getResource("menu_style.fxml"));




        primaryStage.setTitle("Gravity");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(rootMenu, 800, 600));
        primaryStage.show();
    }


    public static boolean addCity(){
        return (counter)%2==0;
    }
    public static void main(String[] args) {
        launch(args);
    }

}

package sample;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.stage.Stage;

import java.util.ArrayList;

import static sample.Main.*;


public class Controller {
    ArrayList<Button> red = new ArrayList<>();
    ArrayList<Button> blue = new ArrayList<>();
    Button city;
    int ques = 0;
    boolean pressed = true;
    static Quiz quiz=Quiz.loadFromFile("src/sample/assets/law.txt");
    Test question;
    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Button krg;

    @FXML
    private Button ala;

    @FXML
    private Button zmb;

    @FXML
    private Button trk;

    @FXML
    private Button kzl;

    @FXML
    private Button akt;

    @FXML
    private Button mng;

    @FXML
    private Button atr;

    @FXML
    private Button zko;

    @FXML
    private Button kst;

    @FXML
    private Button sko;

    @FXML
    private Button vko;

    @FXML
    private Button nur;

    @FXML
    private Button pvl;


    @FXML
    private Text questionText;

    @FXML
    private RadioButton op1;

    @FXML
    private RadioButton op2;

    @FXML
    private RadioButton op3;

    @FXML
    private RadioButton op4;

    @FXML
    private Button accept;
    @FXML
    private Label p1_nickname;

    @FXML
    private Label p1_point;

    @FXML
    private Label p2_nickname;

    @FXML
    private Label p2_point;

    @FXML
    private Text turn_text;

    @FXML
    private Label round;

    public void turn(){
        pressed = false;
        if(Main.counter==30){
            Stage winStage = new Stage();
            StackPane pane = new StackPane();
            Text winText;
            if(pointsRed>pointsBlue) {
                winText = new Text(100, 100, String.format("%s won!!!",Main.redPlayerN));
            }else if(pointsRed<pointsBlue){
                winText = new Text(100, 100, String.format("%s won!!!", bluePlayerN));
            }else{
                winText = new Text(10, 100, "DRAW");
            }
            winText.setFont(Font.font("Verdana",20));
            winText.setTextAlignment(TextAlignment.CENTER);
            pane.getChildren().add(winText);
            Scene scene = new Scene(pane,200,200);

            winStage.setTitle("Gravity");
            winStage.setResizable(false);
            winStage.setScene(scene);
            winStage.show();
            Main.counter = 0;
            Stage stage = (Stage) nur.getScene().getWindow();
            stage.close();
        }
        round.setText(String.format("Round %d",Main.counter+1 ));

        question = (Test)quiz.getQuestion(ques++);
        questionText.setText(question.getDescription());
        ToggleGroup group = new ToggleGroup();
        op1.setToggleGroup(group);
        op2.setToggleGroup(group);
        op3.setToggleGroup(group);
        op4.setToggleGroup(group);
        op1.setText(question.getOptionAt(0));
        op2.setText(question.getOptionAt(1));
        op3.setText(question.getOptionAt(2));
        op4.setText(question.getOptionAt(3));

    }

    void checkAdd(Button citya){
        if(!pressed){
            Main.counter++;
        }
        p1_nickname.setText(Main.redPlayerN);
        p2_nickname.setText(Main.bluePlayerN);
        city = citya;
        if(!red.contains(citya) && !blue.contains(citya)){
            op1.setVisible(true);
            op2.setVisible(true);
            op3.setVisible(true);
            round.setVisible(true);
            op4.setVisible(true);
            questionText.setVisible(true);
            accept.setVisible(true);
            turn();
        }else if(red.contains(citya) && !addCity()){

            op1.setVisible(true);
            op2.setVisible(true);
            op3.setVisible(true);
            op4.setVisible(true);
            round.setVisible(true);
            questionText.setVisible(true);
            accept.setVisible(true);
            turn();
        }else if(blue.contains(citya) && addCity()){

            op1.setVisible(true);
            op2.setVisible(true);
            op3.setVisible(true);
            round.setVisible(true);
            op4.setVisible(true);
            questionText.setVisible(true);
            accept.setVisible(true);
            turn();
        }

    }

    @FXML
    void accept_act(ActionEvent event) {
        if(op1.isSelected()){
            if(op1.getText().equals(question.getAnswer())){
                if(addCity()){
                    red.add(city);
                    city.setStyle("-fx-background-color: red;");
                    if(blue.contains(city)){
                        blue.remove(city);
                        pointsBlue--;
                    }
                    pointsRed++;
                }else{
                    blue.add(city);
                    city.setStyle("-fx-background-color: blue;");
                    if(red.contains(city)){
                        red.remove(city);
                        pointsRed--;
                    }
                    pointsBlue++;
                }
            }
        }else
        if(op2.isSelected()){
            if(op2.getText().equals(question.getAnswer())){

                if(addCity()){
                    red.add(city);
                    city.setStyle("-fx-background-color: red;");
                    if(blue.contains(city)){
                        blue.remove(city);
                        pointsBlue--;
                    }
                    pointsRed++;
                }else{
                    blue.add(city);
                    city.setStyle("-fx-background-color: blue;");
                    if(red.contains(city)){
                        red.remove(city);
                        pointsRed--;
                    }
                    pointsBlue++;
                }

            }
        }else
        if(op3.isSelected()){
            if(op3.getText().equals(question.getAnswer())){

                if(addCity()){
                    red.add(city);
                    city.setStyle("-fx-background-color: red;");
                    if(blue.contains(city)){
                        blue.remove(city);
                        pointsBlue--;
                    }
                    pointsRed++;
                }else{
                    blue.add(city);
                    city.setStyle("-fx-background-color: blue;");
                    if(red.contains(city)){
                        red.remove(city);
                        pointsRed--;
                    }
                    pointsBlue++;
                }

            }

        }else
        if(op4.isSelected()){

            if(op4.getText().equals(question.getAnswer())){

                if(addCity()){
                    red.add(city);
                    city.setStyle("-fx-background-color: red;");
                    if(blue.contains(city)){
                        blue.remove(city);
                        pointsBlue--;
                    }
                    pointsRed++;
                }else{
                    blue.add(city);
                    city.setStyle("-fx-background-color: blue;");
                    if(red.contains(city)){
                        red.remove(city);
                        pointsRed--;
                    }
                    pointsBlue++;
                }
            }

        }
        pressed = true;


        if(!Main.addCity()){
            turn_text.setText(String.format("%s's turn", redPlayerN));
        }else{
            turn_text.setText(String.format("%s's turn", bluePlayerN));
        }
        p1_point.setText(String.valueOf(pointsRed));
        p2_point.setText(String.valueOf(pointsBlue));

        Main.counter++;
        questionText.setText("");
        op1.setSelected(false);
        op2.setSelected(false);
        op3.setSelected(false);
        op4.setSelected(false);
        op1.setVisible(false);
        op2.setVisible(false);
        op3.setVisible(false);
        op4.setVisible(false);
        round.setVisible(false);
        questionText.setVisible(false);
        accept.setVisible(false);
    }

    @FXML
    void akt_act(MouseEvent event) {
        checkAdd(akt);
    }

    @FXML
    void ala_act(MouseEvent event) {
        checkAdd(ala);
    }

    @FXML
    void atr_act(MouseEvent event) {
        checkAdd(atr);
    }

    @FXML
    void krg_act(MouseEvent event) {
        checkAdd(krg);
    }

    @FXML
    void kst_act(MouseEvent event) {
        checkAdd(kst);
    }

    @FXML
    void kzl_act(MouseEvent event) {
        checkAdd(kzl);
    }

    @FXML
    void mng_act(MouseEvent event) {
        checkAdd(mng);
    }

    @FXML
    void nur_act(MouseEvent event) {
        checkAdd(nur);
    }

    @FXML
    void pvl_act(MouseEvent event) {
        checkAdd(pvl);
    }

    @FXML
    void sko_act(MouseEvent event) {
        checkAdd(sko);
    }

    @FXML
    void trk_act(MouseEvent event) {
        checkAdd(trk);
    }

    @FXML
    void vko_act(MouseEvent event) {
        checkAdd(vko);
    }

    @FXML
    void zko_act(MouseEvent event) {
        checkAdd(zko);
    }

    @FXML
    void zmb_act(MouseEvent event) {
        checkAdd(zmb);
    }

}


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.event.*;
import java.util.Arrays;
import javafx.scene.text.*;
 
/**
*
* Beschreibung
*
* @version 1.0 vom 30.03.2022
* @author
*/
public class test32 extends Application {
// Anfang Attribute
  private Text text1 = new Text();
// Ende Attribute
  private int r=7;
  private int c=6;
  Circle [][] bu = new Circle [r][c];
  Button [] buttonList = new Button[7];
  private Rectangle rectangle1 = new Rectangle();
  private int i=0;
  vierGewinnt t1 = new vierGewinnt(6,7,1);

  public void start(Stage primaryStage) {
    Pane root = new Pane();
    
    Scene scene = new Scene(root, 698, 703);
    // Anfang Komponenten
    rectangle1.setX(50);
    rectangle1.setY(140);
    
    rectangle1.setWidth(550);
    rectangle1.setHeight(500);
    rectangle1.setFill(Color.BLUE);
    rectangle1.setStroke(Color.BLACK);
    root.getChildren().add(rectangle1);
    
    
    t1.fillboard();
    
    buttonList[i] = new Button();
    buttonList[i].setLayoutX(75*i+75);
    buttonList[i].setLayoutY(65);
    buttonList[i].setPrefHeight(49);
    buttonList[i].setPrefWidth(50);
    buttonList[i].setOnAction(
    (event) -> {button1_Action(event);}
    );
    buttonList[i].setVisible(true);
    root.getChildren().add(buttonList[i]);
    i +=1;
    buttonList[i] = new Button();
    buttonList[i].setLayoutX(75*i+75);
    buttonList[i].setLayoutY(65);
    buttonList[i].setPrefHeight(49);
    buttonList[i].setPrefWidth(50);
    buttonList[i].setOnAction(
    (event) -> {button2_Action(event);}
    );
    buttonList[i].setVisible(true);
    root.getChildren().add(buttonList[i]);
    i +=1;
    buttonList[i] = new Button();
    buttonList[i].setLayoutX(75*i+75);
    buttonList[i].setLayoutY(65);
    buttonList[i].setPrefHeight(49);
    buttonList[i].setPrefWidth(50);
    buttonList[i].setOnAction(
    (event) -> {button3_Action(event);}
    );
    buttonList[i].setVisible(true);
    root.getChildren().add(buttonList[i]);
    i +=1;
    buttonList[i] = new Button();
    buttonList[i].setLayoutX(75*i+75);
    buttonList[i].setLayoutY(65);
    buttonList[i].setPrefHeight(49);
    buttonList[i].setPrefWidth(50);
    buttonList[i].setOnAction(
    (event) -> {button4_Action(event);}
    );
    buttonList[i].setVisible(true);
    root.getChildren().add(buttonList[i]);
    i +=1;
    buttonList[i] = new Button();
    buttonList[i].setLayoutX(75*i+75);
    buttonList[i].setLayoutY(65);
    buttonList[i].setPrefHeight(49);
    buttonList[i].setPrefWidth(50);
    buttonList[i].setOnAction(
    (event) -> {button5_Action(event);}
    );
    buttonList[i].setVisible(true);
    root.getChildren().add(buttonList[i]);
    i +=1;
    buttonList[i] = new Button();
    buttonList[i].setLayoutX(75*i+75);
    buttonList[i].setLayoutY(65);
    buttonList[i].setPrefHeight(49);
    buttonList[i].setPrefWidth(50);
    buttonList[i].setOnAction(
    (event) -> {button6_Action(event);}
    );
    buttonList[i].setVisible(true);
    root.getChildren().add(buttonList[i]);
    i +=1;
    buttonList[i] = new Button();
    buttonList[i].setLayoutX(75*i+75);
    buttonList[i].setLayoutY(65);
    buttonList[i].setPrefHeight(49);
    buttonList[i].setPrefWidth(50);
    buttonList[i].setOnAction(
    (event) -> {button7_Action(event);}
    );
    buttonList[i].setVisible(true);
    root.getChildren().add(buttonList[i]);
    
    
    for(int i = 0; i<r; i++) {
      for (int j=0;j<c ;j++ ) {
        bu[i][j] = new Circle();//Adding this line to prevent NPE on circArray[i]
        bu[i][j].setRadius(30);
        bu[i][j].setCenterX(75*i+100);
        bu[i][j].setCenterY(75*j+200);
        bu[i][j].setFill(Color.BLACK);
      }
    }
    text1.setX(107);
    text1.setY(677);
    text1.setFont(new Font(40));
    text1.setWrappingWidth(1000);
    root.getChildren().add(text1);
    // Ende Komponenten
    for(int i = 0; i<r; i++) {
      for (int j=0;j<c ;j++ ) {
        root.getChildren().add(bu[i][j]);
      }
    }
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("test28");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public test32

// Anfang Methoden


  public static void main(String[] args) {
    launch(args);
  } // end of main

  public void updateBoard()
  {
    for (int a = 0; a < c; a++) {
      for (int b = 0; b < r; b++) {
        if (t1.board[a][b]<3&&t1.board[a][b]>1) {
          bu[b][5-a].setFill(Color.RED);
        } // end of if
        if (t1.board[a][b]<2&&t1.board[a][b]>0) {
          bu[b][5-a].setFill(Color.YELLOW);
        } // end of if
        if (t1.board[a][b]<1) {
          bu[b][5-a].setFill(Color.BLACK);
        } // end of if
      } // end of for
    } // end of for
  }

  public void gewinner()
  {
    if (t1.checkwinner()<3&&t1.checkwinner()>1) {
      text1.setText("Rot Gewinnt!");
    } // end of if
    if (t1.checkwinner()<2&&t1.checkwinner()>0) {
      text1.setText("Gelb Gewinnt!");
    } // end of if
  }

  public void button1_Action(Event evt) {
    t1.throwcoin(0);
    updateBoard();
    t1.setplayer();
    gewinner();
  }
// end of button1_Action

  public void button2_Action(Event evt) {
    t1.throwcoin(1);
    t1.setplayer();
    updateBoard();
    gewinner();
  } // end of button1_Action

  public void button3_Action(Event evt) {
    t1.throwcoin(2);
    t1.setplayer();
    updateBoard();
    gewinner();
  } // end of button1_Action

  public void button4_Action(Event evt) {
    t1.throwcoin(3);
    t1.setplayer();
    updateBoard();
    gewinner();
  } // end of button1_Action

  public void button5_Action(Event evt) {
    t1.throwcoin(4);
    t1.setplayer();
    updateBoard();
    gewinner();
  } // end of button1_Action

  public void button6_Action(Event evt) {
    t1.throwcoin(5);
    t1.setplayer();
    updateBoard();
    gewinner();
  } // end of button1_Action

  public void button7_Action(Event evt) {
    t1.throwcoin(6);
    t1.setplayer();
    updateBoard();
    gewinner();
    t1.printboard();
  } // end of button1_Action
// Ende Methoden
} // end of class test32


package kane.movingblock;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import static javafx.scene.input.KeyCode.*;

/**
 * This class is the Driver class for the JavaFX application.
 *
 * This class ia reference for any code involving movement. Will be a reference for a snake game.
 *
 * Author: Kane Du
 * Last Updated: 3/16/19
 */
public class Driver extends Application {
    /**
     * Main method to launch the Java application.
     * @param args Command line inputs.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Abstract method from Application.
     * @param primaryStage Stage to be shown.
     */
    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;
        //GridPane that shows each block, including the background and user.
        GridPane root = new GridPane();
        Map map = new Map(root, 20, 20);
        Scene scene = new Scene(root);
        //Takes in key input for movement. Each key input changes the index of userblock and updates the map.
        EventHandler<KeyEvent> keyEvent = e->{
            if(e.getCode()==UP){
                map.setUserCol(map.getUserCol()-1);
                map.updateMap();
            }
            if(e.getCode()==DOWN){
                map.setUserCol(map.getUserCol()+1);
                map.updateMap();
            }
            if(e.getCode()==RIGHT){
                map.setUserRow(map.getUserRow()+1);
                map.updateMap();
            }
            if(e.getCode()==LEFT){
                map.setUserRow(map.getUserRow()-1);
                map.updateMap();
            }
        };
        scene.setOnKeyPressed(keyEvent);
        window.setScene(scene);
        window.show();
    }
}

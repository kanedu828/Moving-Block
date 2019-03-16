package kane.movingblock;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This class represents what is shown on the screen. This includes the block the user is moving ({@code userblock},
 * and the background of the map ({@code whiteblock}.
 */
public class Map {
    private ImageView[][] map;
    private int width;
    private int height;
    private int userRow;
    private int userCol;
    private static Image whiteblock;
    private static Image userblock;

    /**
     * Initializes the map by setting every block to be a {@code whiteblock} and the center block as the
     * {@code userblock}
     * @param root This GridPane is passed in so each index of the GridPane can be set to an ImageView.
     * @param width Width of the map
     * @param height Height of the map
     */
    public Map( GridPane root, int width, int height){
        //Initializing {@code whiteblock} to a simple white square and {@code userblock} to be a simple red square.
        try {
            whiteblock = new Image(new FileInputStream("resources/whitesquare.jpg"));
            userblock = new Image(new FileInputStream("resources/redsquare.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Sets to coordinates of the default location of {@code userblock} to be half of the width and height (center).
        userRow = width/2;
        userCol = height/2;
        //Initializes the dimensions to be to specified width and height.
        this.width = width;
        this.height = height;
        //Sets map to be an array of ImageView for ease of access. Makes it easy to coordinate the images to GridPane.
        map = new ImageView[width][height];
        //Initializes each GridPane block to the map.
        for(int row = 0; row<width; row++){
            for(int col = 0; col<height; col++){
                map[row][col] = new ImageView(whiteblock);
                //Sets userblock on GridPane. Background is set first, then overriden by userblock.
                if(row==userRow&&col==userCol){
                    map[row][col].setImage(userblock);
                }
                //Makes sure the dimensions of each index in GridPane is reasonable. 50x50 pixels
                map[row][col].setFitHeight(50);
                map[row][col].setFitWidth(50);
                //Adds each ImageView to the GridPane
                root.add(map[row][col], row, col);
            }
        }
    }

    /**
     * Returns the {@code map} array.
     * @return An ImageView[][] array, {@code map}.
     */
    public ImageView[][] getMap(){
        return map;
    }

    /**
     * Returns the row index of where the {@code userblock} is.
     * @return Integer that represents the row of {@code userblock}
     */
    public int getUserRow(){
        return userRow;
    }
    /**
     * Returns the col index of where the {@code userblock} is.
     * @return Integer that represents the col of {@code userblock}
     */
    public int getUserCol(){
        return userCol;
    }

    /**
     * Sets the row index of {@code userblock}
     * @param row the desired row index to be set.
     */
    public void setUserRow(int row){
        userRow = row;
    }
    /**
     * Sets the row index of {@code userblock}
     * @param col the desired row index to be set.
     */
    public void setUserCol(int col){
        userCol = col;
    }

    /**
     * This method updates the ImageView so GridPane is also updated. Allows changes to be seen on the JavaFX
     * application.
     */
    public void updateMap(){
        for(int row = 0; row<width; row++){
            for(int col = 0; col<height; col++){
                //Updates ImageView
                map[row][col].setImage(whiteblock);
                //Updates ImageView for the userblock
                if(row==userRow&&col==userCol){
                    map[row][col].setImage(userblock);
                }
                //Corrects dimensions.
                map[row][col].setFitHeight(50);
                map[row][col].setFitWidth(50);
            }
        }
    }
}

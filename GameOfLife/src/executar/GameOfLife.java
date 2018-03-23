package executar;

import java.util.HashMap;
import java.util.Map;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameOfLife extends Application {
    
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static final int BOARD_SIZE = 500;//1600;
    
    private Map<String, StackPane> boardMap = new HashMap<>();
    private GameBoard board = new GameBoard(BOARD_SIZE/5);
    
    @Override
    public void start(Stage primaryStage) {
        final Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new EventHandler() {
            @Override
            public void handle(Event event) {
                iterateBoard();
            }
        }), new KeyFrame(Duration.millis(100)));
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        
        board.initGameBoard(0.3);
        
        Pane root = new Pane();
        Scene scene = new Scene(root, BOARD_SIZE, BOARD_SIZE);
        String css = getClass().getResource("/gol.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        // Create a board with dead cells
        for (int x = 0; x < BOARD_SIZE; x = x + WIDTH) {
            for (int y = 0; y < BOARD_SIZE; y = y + HEIGHT) {
                StackPane cell = StackPaneBuilder.create().layoutX(x).layoutY(y).prefHeight(HEIGHT).prefWidth(WIDTH).styleClass("dead-cell").build();
                root.getChildren().add(cell);
                 
                //Store the cell in a HashMap for fast access 
                //in the iterateBoard method.
                boardMap.put(x + " " + y, cell);
            }
        }
        
        primaryStage.setTitle("Jogo da Vida");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        timeline.play();
    }
 
    private void iterateBoard() {
        board.proximaPopulacao();
        for (int x = 0; x < board.getTamanho(); x++) {
            for (int y = 0; y < board.getTamanho(); y++) {
                StackPane pane = boardMap.get(x * WIDTH + " " + y * HEIGHT);
                pane.getStyleClass().clear();
                // If the cell at (x,y) is a alive use css styling 'alive-cell'
                // otherwise use the styling 'dead-cell'.
                if (board.getField(x, y) == 1) {
                    pane.getStyleClass().add("alive-cell");
                } else {
                    pane.getStyleClass().add("dead-cell");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
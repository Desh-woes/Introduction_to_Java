import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import java.awt.*;


public class ticTac extends Application{

    GridPane grid;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("O_X Game");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
//        grid.setGridLinesVisible(true);

        Button[] button_arr = new Button[9];

        // Create an array of buttons
        for (int i = 0; i<button_arr.length; i++){
            button_arr[i] = new Button();
        }

        // Add buttons to the grid.
        int count = 0;
        int counter = 0;

        for (int j = 0; j<3; j++){
            for (int k = 0; k<3; k++){
                grid.add(button_arr[count], j, k);
                int finalCount = count;
                int finalCounter = counter;
                button_arr[count].setOnAction(event -> btn_clicked(finalCounter, button_arr[finalCount], button_arr));
//                button_arr[count].setOnAction(event -> game_won(button_arr));
                count++;
                counter++;
            }
        }


        if (game_won(button_arr)){
            System.out.println("There is a winner");
        }

        // Reset Button
        Button btn_reset = new Button("Reset");
        HBox hb_reset = new HBox(10);
        hb_reset.setAlignment(Pos.CENTER);
        hb_reset.getChildren().add(btn_reset);
        grid.add(hb_reset, 0, 4, 3, 1);
        btn_reset.setOnAction(event -> reset(button_arr));

    }

    // Function that decides which text to display
    public static void btn_clicked(int value, Button clicked_btn, Button[] arr_button) {
        if (value%2 == 0){
            clicked_btn.setText("X");
        }
        else {
            clicked_btn.setText("O");
        }

        game_won(arr_button);
    }

    public static boolean game_won(Button[] arr_btn){
//        int counter = 0;
        if (arr_btn[0].getText().equals(arr_btn[1].getText()) && arr_btn[0].getText().equals(arr_btn[2].getText()) && !arr_btn[0].getText().equals("")){
            System.out.println("There is a winner");
            return true;
        }
        else if (arr_btn[3].getText().equals(arr_btn[4].getText()) && arr_btn[3].getText().equals(arr_btn[5].getText())&& !arr_btn[5].getText().equals("")){
            System.out.println("There is a winner");
            return true;
        }
        else if (arr_btn[6].getText().equals(arr_btn[7].getText()) && arr_btn[6].getText().equals(arr_btn[8].getText())&& !arr_btn[8].getText().equals("")){
            System.out.println("There is a winner");
            return true;
        }
        else if (arr_btn[0].getText().equals(arr_btn[3].getText()) && arr_btn[0].getText().equals(arr_btn[6].getText())&& !arr_btn[6].getText().equals("")){
            System.out.println("There is a winner");
            return true;
        }
        else if (arr_btn[1].getText().equals(arr_btn[4].getText()) && arr_btn[1].getText().equals(arr_btn[7].getText())&& !arr_btn[7].getText().equals("")){
            System.out.println("There is a winner");
            return true;
        }
        else if (arr_btn[2].getText().equals(arr_btn[5].getText()) && arr_btn[2].getText().equals(arr_btn[8].getText())&& !arr_btn[8].getText().equals("")){
            System.out.println("There is a winner");
            return true;
        }
        else if (arr_btn[0].getText().equals(arr_btn[4].getText()) && arr_btn[0].getText().equals(arr_btn[8].getText())&& !arr_btn[8].getText().equals("")){
            System.out.println("There is a winner");
            return true;
        }
        else if (arr_btn[2].getText().equals(arr_btn[4].getText()) && arr_btn[2].getText().equals(arr_btn[6].getText())&& !arr_btn[6].getText().equals("")){
            System.out.println("There is a winner");
            return true;
        }

        else return false;
    }

    // Function that resets the text on screen
    public static void reset(Button[] arr_btn){
        for (int i =0; i< arr_btn.length; i++){
            arr_btn[i].setText("");
        }
    }
}
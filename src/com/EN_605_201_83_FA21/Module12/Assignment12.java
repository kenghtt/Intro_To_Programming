
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Assignment12 extends Application {
    public void start(Stage myStage) {
        myStage.setTitle("Jeremy's Calculator");

        // Create a GridPane and set its properties
        GridPane rootNode = new GridPane();
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPadding(new Insets(30));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        Scene myScene = new Scene(rootNode, 400, 200);

        // Create TextField Variables
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField sum = new TextField();

        // Add labels and text fields to grid pane
        rootNode.add(new Label("First Value:"), 0, 0);
        rootNode.add(textField1, 1, 0);

        rootNode.add(new Label("Second Value:"), 0, 1);
        rootNode.add(textField2, 1, 1);

        rootNode.add(new Label("Sum is:"), 0, 2);
        rootNode.add(sum, 1, 2);

        // Add button to grid pane
        Button calculateButton = new Button("Calculate");
        rootNode.add(calculateButton, 1, 3);

        // On click will calculate text fields
        calculateButton.setOnAction(e -> {
            int value1 = Integer.parseInt(textField1.getText());
            int value2 = Integer.parseInt(textField2.getText());
            int r = value1 + value2;
            sum.setText(Integer.toString(r));
        });

        // Set Scene and show
        myStage.setScene(myScene);
        myStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

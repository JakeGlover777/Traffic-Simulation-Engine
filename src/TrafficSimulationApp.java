import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TrafficSimulationApp extends Application
{
    @Override
    public void start(Stage stage)
    {
        Label title = new Label("Traffic Simulation Engine");

        BorderPane root = new BorderPane();
        root.setCenter(title);

        Scene scene = new Scene(root, 1000, 500);

        stage.setTitle("Traffic Simulation Engine");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
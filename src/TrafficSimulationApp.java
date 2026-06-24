import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TrafficSimulationApp extends Application
{
    @Override
    public void start(Stage stage)
    {
        Pane root = new Pane();

        Rectangle road = new Rectangle(
                0,
                220,
                1000,
                60
        );

        road.setFill(Color.GRAY);

        root.getChildren().add(road);

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
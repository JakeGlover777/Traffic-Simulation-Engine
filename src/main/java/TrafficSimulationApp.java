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

        Rectangle vehicle = new Rectangle(
                50,
                235,
                30,
                20
        );

        vehicle.setFill(Color.BLUE);

        root.getChildren().add(road);
        root.getChildren().add(vehicle);

        Scene scene = new Scene(
                root,
                1000,
                500
        );

        stage.setTitle("Traffic Simulation Engine");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TrafficSimulationApp extends Application
{
    private SimulationEngine engine;
    private Pane root;
    private Timeline timeline;

    @Override
    public void start(Stage stage)
    {
        root = new Pane();

        SimulationConfig config = new SimulationConfig(200.0, 100,
                2, 2.0, 5.0);

        engine = new SimulationEngine(config);

        renderRoad();
        renderVehicles();

        Scene scene = new Scene(root, 1000, 500);

        stage.setTitle("Traffic Simulation Engine");
        stage.setScene(scene);
        stage.show();

        timeline = new Timeline(
                new KeyFrame(Duration.millis(100), e -> updateSimulation()));

        timeline.setCycleCount(Timeline.INDEFINITE);

        engine.start();

        timeline.play();
    }

    private void updateSimulation()
    {
        if (!engine.isRunning())
        {
            timeline.stop();
            return;
        }

        engine.tick();

        root.getChildren().clear();

        renderRoad();
        renderVehicles();

        if (!engine.isRunning())
        {
            timeline.stop();
        }
    }

    private void renderRoad()
    {
        Rectangle road = new Rectangle(0, 220, 1000, 60);

        road.setFill(Color.GRAY);

        root.getChildren().add(road);
    }

    private void renderVehicles()
    {
        for (Vehicle vehicle : engine.getRoad().getVehicles())
        {
            Rectangle vehicleShape = new Rectangle(50 + vehicle.getPosition() * 4,
                    235, 30, 20);

            vehicleShape.setFill(Color.BLUE);

            root.getChildren().add(vehicleShape);
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

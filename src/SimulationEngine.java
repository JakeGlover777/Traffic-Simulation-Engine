import java.util.List;
import java.util.ArrayList;

public class SimulationEngine
{
    private List<Vehicle> vehicles;

    private int currentTick = 0;
    private boolean running = false;

    public void start(int maxTicks)
    {
        running = true;

        while (running && currentTick < maxTicks)
        {
            tick();
            currentTick++;
        }
    }

    private void tick()
    {
        System.out.println("Tick: " + currentTick);

        for (Vehicle v : vehicles)
        {
            v.update();
            System.out.println("Position: " + v.getPosition());
        }
    }

    public SimulationEngine()
    {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }
}

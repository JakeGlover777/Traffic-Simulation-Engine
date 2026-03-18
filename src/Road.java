import java.util.List;
import java.util.ArrayList;

public class Road
{
    private static final double SPAWN_BUFFER = 5.0;

    private List<Vehicle> vehicles;
    private double roadLength;

    public Road(double roadLength)
    {
        this.vehicles = new ArrayList<>();
        this.roadLength = roadLength;
    }

    public void addVehicle(Vehicle vehicle)
    {
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles()
    {
        return new ArrayList<>(vehicles);
    }

    public void update()
    {
        for (Vehicle vehicle : vehicles)
        {
            vehicle.update();
        }

        vehicles.removeIf(vehicle -> vehicle.getPosition() > roadLength);
    }

    public Vehicle getVehicleAhead(Vehicle currentVehicle)
    {
        Vehicle closestAhead = null;

        for (Vehicle vehicle : vehicles)
        {
            if(vehicle.getPosition() > currentVehicle.getPosition())
            {
                if(closestAhead == null|| vehicle.getPosition() < closestAhead.getPosition())
                {
                    closestAhead = vehicle;
                }
            }
        }
        return closestAhead;
    }

    public boolean canSpawnVehicle()
    {
        for (Vehicle vehicle : vehicles)
        {
            if (vehicle.getPosition() < SPAWN_BUFFER)
            {
                return false;
            }
        }
        return true;
    }
}

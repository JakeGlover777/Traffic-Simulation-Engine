import java.util.ArrayList;
import java.util.List;

public class Road
{
    private static final double SPAWN_BUFFER = 8.0;

    private final List<Vehicle> vehicles;
    private final double roadLength;

    public Road(double roadLength)
    {
        this.vehicles = new ArrayList<>();
        this.roadLength = roadLength;
    }

    public void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }

    public int update()
    {
        int nearCollisionsThisTick = 0;

        for (Vehicle vehicle : vehicles)
        {
            boolean nearCollisionDetected =
                    vehicle.update();

            if (nearCollisionDetected)
            {
                nearCollisionsThisTick++;
            }
        }

        return nearCollisionsThisTick;
    }

    public int removeCompletedVehicles()
    {
        int before = vehicles.size();

        vehicles.removeIf(vehicle -> vehicle.getPosition() > roadLength);

        return before - vehicles.size();
    }

    public Vehicle getVehicleAhead(Vehicle currentVehicle)
    {
        Vehicle closestAhead = null;

        for (Vehicle vehicle : vehicles)
        {
            if (vehicle == currentVehicle)
            {
                continue;
            }

            if (vehicle.getPosition() > currentVehicle.getPosition())
            {
                if (closestAhead == null ||
                        vehicle.getPosition() < closestAhead.getPosition())
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

    public List<Vehicle> getVehicles()
    {
        return new ArrayList<>(vehicles);
    }

    public double getRoadLength()
    {
        return roadLength;
    }

    public int getVehicleCount()
    {
        return vehicles.size();
    }
}

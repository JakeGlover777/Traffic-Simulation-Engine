import java.util.List;
import java.util.ArrayList;

public class Road
{
    private List<Vehicle> vehicles;

    public Road()
    {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle)
    {
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles()
    {
        return vehicles;
    }

    public void update()
    {
        for (Vehicle vehicle : vehicles)
        {
            vehicle.update();
        }
    }
}
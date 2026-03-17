public class SimulationEngine
{
    private int currentTick = 0;
    private boolean running = false;
    private Road road;
    private int nextVehicleId = 4;

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

        if (currentTick % 3 == 0)
        {
            Vehicle newVehicle = new Vehicle(1,3.0,nextVehicleId , this.road);
            addVehicle(newVehicle);
            nextVehicleId ++;

        }

        road.update();

        for (Vehicle vehicle : road.getVehicles())
        {
            System.out.println("Vehicle " + vehicle.getId() +
                    " Position: " + vehicle.getPosition());
        }
    }

    public SimulationEngine()
    {
        this.road = new Road(100);
    }

    public void addVehicle(Vehicle vehicle)
    {
        road.addVehicle(vehicle);

        if (vehicle.getId() >= nextVehicleId)
        {
            nextVehicleId = vehicle.getId() + 1;
        }
    }


    public Road getRoad()
    {
        return road;
    }
}


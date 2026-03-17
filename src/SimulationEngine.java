public class SimulationEngine
{
    private int currentTick = 0;
    private boolean running = false;
    private Road road;

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
        road.update();

        for (Vehicle vehicle : road.getVehicles())
        {
            System.out.println("Vehicle " + vehicle.getId() +
                    " Position: " + vehicle.getPosition());
        }
    }

    public SimulationEngine()
    {
        this.road = new Road();
    }

    public void addVehicle(Vehicle vehicle)
    {
        road.addVehicle(vehicle);
    }


    public Road getRoad()
    {
        return road;
    }
}


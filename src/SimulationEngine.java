public class SimulationEngine
{
    private Vehicle vehicle;

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
        vehicle.update();
        System.out.println(
                "Tick: " + currentTick +
                        " Position: " +
                        vehicle.getPosition());
    }

    public SimulationEngine(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }
}
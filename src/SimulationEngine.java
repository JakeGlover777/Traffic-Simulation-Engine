public class SimulationEngine
{
    private static final double MIN_SPEED = 2.0;
    private static final double MAX_SPEED = 5.0;

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

    private double randomSpeed()
    {
        return MIN_SPEED + Math.random() * (MAX_SPEED - MIN_SPEED);
    }

    private void tick()
    {
        System.out.println("Tick: " + currentTick);

        if (currentTick % 3 == 0 && road.canSpawnVehicle())
        {
            double maxSpeed = randomSpeed();
            double initialSpeed = Math.min(randomSpeed(), maxSpeed);

            Vehicle newVehicle = new Vehicle(initialSpeed, maxSpeed, nextVehicleId, this.road);
            addVehicle(newVehicle);
            nextVehicleId++;

        }

        road.update();

        for (Vehicle vehicle : road.getVehicles())
        {
            System.out.println("Vehicle " + vehicle.getId() +
                    " Position: " + String.format("%.2f", vehicle.getPosition()));
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


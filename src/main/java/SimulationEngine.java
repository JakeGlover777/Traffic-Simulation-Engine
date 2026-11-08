public class SimulationEngine
{
    private final SimulationConfig config;
    private final Road road;
    private final SimulationStats stats;

    private static final double LOW_CONGESTION_THRESHOLD = 0.03;
    private static final double MODERATE_CONGESTION_THRESHOLD = 0.06;

    private int currentTick;
    private int nextVehicleId;
    private boolean running;

    public SimulationEngine(SimulationConfig config)
    {
        this.config = config;
        this.road = new Road(config.getRoadLength());
        this.stats = new SimulationStats();

        this.currentTick = 0;
        this.nextVehicleId = 1;
        this.running = false;
    }

    public void start()
    {
        if (currentTick < config.getMaxTicks())
        {
            running = true;
        }
    }

    public void tick()
    {
        if (!running || currentTick >= config.getMaxTicks())
        {
            return;
        }

        spawnVehicleIfPossible();

        int nearCollisionsThisTick = road.update();

        stats.recordNearCollisions(nearCollisionsThisTick);

        int completedVehicles = road.removeCompletedVehicles();

        if (completedVehicles > 0)
        {
            System.out.println("Event: " + completedVehicles
                    + " vehicle(s) completed the road");
        }

        for (int i = 0; i < completedVehicles; i++)
        {
            stats.recordCompletedVehicle();
        }

        for (Vehicle vehicle : road.getVehicles())
        {
            stats.recordSpeed(vehicle.getSpeed());
        }

        printTickData();

        currentTick++;

        if (currentTick >= config.getMaxTicks())
        {
            running = false;
            printFinalStats();
        }
    }
    private void spawnVehicleIfPossible()
    {
        if (currentTick % config.getSpawnInterval() != 0)
        {
            return;
        }

        if (!road.canSpawnVehicle())
        {
            return;
        }

        VehicleType type = getRandomVehicleType();

        Vehicle vehicle = new Vehicle(nextVehicleId, type, road);

        road.addVehicle(vehicle);
        stats.recordSpawnedVehicle();

        System.out.println("Event: Vehicle " + vehicle.getId()
                        + " spawned as " + vehicle.getType());

        nextVehicleId++;
    }

    private VehicleType getRandomVehicleType()
    {
        VehicleType[] types = VehicleType.values();

        int randomIndex = (int) (Math.random() * types.length);

        return types[randomIndex];
    }

    public int getCurrentTick()
    {
        return currentTick;
    }

    public boolean isRunning()
    {
        return running;
    }

    private void printTickData()
    {
        System.out.println("Tick: " + currentTick);

        for (Vehicle vehicle : road.getVehicles())
        {
            System.out.println("Vehicle " + vehicle.getId()
                            + " | Type: " + vehicle.getType()
                            + " | Position: " + String.format("%.2f", vehicle.getPosition())
                            + " | Speed: " + String.format("%.2f", vehicle.getSpeed()));
        }

        System.out.println("Traffic density: "
                        + String.format("%.3f", calculateTrafficDensity()));

        System.out.println("Congestion level: " + getCongestionLevel());

        System.out.println();
    }

    private void printFinalStats()
    {
        System.out.println("Simulation finished.");
        System.out.println("Vehicles spawned: " + stats.getVehiclesSpawned());
        System.out.println("Vehicles completed: " + stats.getVehiclesCompleted());
        System.out.println("Average speed: " + String.format("%.2f", stats.getAverageSpeed()));
        System.out.println("Near collisions: " + stats.getNearCollisions());
        System.out.println("Final congestion level: " + getCongestionLevel());
    }

    public Road getRoad()
    {
        return road;
    }

    public SimulationStats getStats()
    {
        return stats;
    }

    private double calculateTrafficDensity()
    {
        return road.getVehicleCount() / road.getRoadLength();
    }

    private String getCongestionLevel()
    {
        double density = calculateTrafficDensity();

        if (density < LOW_CONGESTION_THRESHOLD)
        {
            return "Low";
        }

        if (density < MODERATE_CONGESTION_THRESHOLD)
        {
            return "Moderate";
        }

        return "Heavy";
    }
}

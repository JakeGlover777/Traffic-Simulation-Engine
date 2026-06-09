public class SimulationEngine
{
    private final SimulationConfig config;
    private final Road road;
    private final SimulationStats stats;

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
        running = true;

        while (running && currentTick < config.getMaxTicks())
        {
            tick();
            currentTick++;
        }

        printFinalStats();
    }

    public void tick()
    {
        spawnVehicleIfPossible();

        road.update();

        int completedVehicles = road.removeCompletedVehicles();

        for (int i = 0; i < completedVehicles; i++)
        {
            stats.recordCompletedVehicle();
        }

        for (Vehicle vehicle : road.getVehicles())
        {
            stats.recordSpeed(vehicle.getSpeed());
        }

        printTickData();
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

        Vehicle vehicle = new Vehicle(
                nextVehicleId,
                type,
                road
        );

        road.addVehicle(vehicle);
        stats.recordSpawnedVehicle();

        nextVehicleId++;
    }

    private VehicleType getRandomVehicleType()
    {
        VehicleType[] types = VehicleType.values();

        int randomIndex = (int) (Math.random() * types.length);

        return types[randomIndex];
    }

    private void printTickData()
    {
        System.out.println("Tick: " + currentTick);

        for (Vehicle vehicle : road.getVehicles())
        {
            System.out.println(
                    "Vehicle " + vehicle.getId()
                            + " | Type: " + vehicle.getType()
                            + " | Position: " + String.format("%.2f", vehicle.getPosition())
                            + " | Speed: " + String.format("%.2f", vehicle.getSpeed())
            );
        }

        System.out.println();
    }

    private void printFinalStats()
    {
        System.out.println("Simulation finished.");
        System.out.println("Vehicles spawned: " + stats.getVehiclesSpawned());
        System.out.println("Vehicles completed: " + stats.getVehiclesCompleted());
        System.out.println("Average speed: " + String.format("%.2f", stats.getAverageSpeed()));
    }

    public Road getRoad()
    {
        return road;
    }

    public SimulationStats getStats()
    {
        return stats;
    }
}
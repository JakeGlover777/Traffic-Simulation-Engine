package com.jakeglover.trafficsimulation.engine;

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

        for (int i = 0; i < completedVehicles; i++)
        {
            stats.recordCompletedVehicle();
        }

        for (Vehicle vehicle : road.getVehicles())
        {
            stats.recordSpeed(vehicle.getSpeed());
        }

        currentTick++;

        if (currentTick >= config.getMaxTicks())
        {
            running = false;
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

        nextVehicleId++;
    }

    private VehicleType getRandomVehicleType()
    {
        VehicleType[] types = VehicleType.values();

        int randomIndex = (int) (Math.random() * types.length);

        return types[randomIndex];
    }

    public Road getRoad()
    {
        return road;
    }

    public SimulationStats getStats()
    {
        return stats;
    }

    public int getCurrentTick()
    {
        return currentTick;
    }

    public boolean isRunning()
    {
        return running;
    }

    public double getTrafficDensity()
    {
        return calculateTrafficDensity();
    }

    public String getCongestionLevel()
    {
        return calculateCongestionLevel();
    }

    private double calculateTrafficDensity()
    {
        return road.getVehicleCount() / road.getRoadLength();
    }

    private String calculateCongestionLevel()
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
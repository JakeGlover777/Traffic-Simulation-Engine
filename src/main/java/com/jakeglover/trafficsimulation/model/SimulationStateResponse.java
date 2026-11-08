package com.jakeglover.trafficsimulation.model;

public class SimulationStateResponse
{
    private final int currentTick;
    private final boolean running;
    private final int vehicleCount;
    private final double trafficDensity;
    private final String congestionLevel;
    private final int vehiclesSpawned;
    private final int vehiclesCompleted;
    private final double averageSpeed;
    private final int nearCollisions;

    public SimulationStateResponse(
            int currentTick,
            boolean running,
            int vehicleCount,
            double trafficDensity,
            String congestionLevel,
            int vehiclesSpawned,
            int vehiclesCompleted,
            double averageSpeed,
            int nearCollisions)
    {
        this.currentTick = currentTick;
        this.running = running;
        this.vehicleCount = vehicleCount;
        this.trafficDensity = trafficDensity;
        this.congestionLevel = congestionLevel;
        this.vehiclesSpawned = vehiclesSpawned;
        this.vehiclesCompleted = vehiclesCompleted;
        this.averageSpeed = averageSpeed;
        this.nearCollisions = nearCollisions;
    }

    public int getCurrentTick()
    {
        return currentTick;
    }

    public boolean isRunning()
    {
        return running;
    }

    public int getVehicleCount()
    {
        return vehicleCount;
    }

    public double getTrafficDensity()
    {
        return trafficDensity;
    }

    public String getCongestionLevel()
    {
        return congestionLevel;
    }

    public int getVehiclesSpawned()
    {
        return vehiclesSpawned;
    }

    public int getVehiclesCompleted()
    {
        return vehiclesCompleted;
    }

    public double getAverageSpeed()
    {
        return averageSpeed;
    }

    public int getNearCollisions()
    {
        return nearCollisions;
    }
}
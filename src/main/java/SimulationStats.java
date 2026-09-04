public class SimulationStats
{
    private int vehiclesSpawned;
    private int vehiclesCompleted;

    private double totalSpeed;
    private int speedSamples;
    private int nearCollisions;

    public void recordSpawnedVehicle()
    {
        vehiclesSpawned++;
    }

    public void recordCompletedVehicle()
    {
        vehiclesCompleted++;
    }

    public void recordSpeed(double speed)
    {
        totalSpeed += speed;
        speedSamples++;
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
        if (speedSamples == 0)
        {
            return 0;
        }

        return totalSpeed / speedSamples;
    }

    public void recordNearCollisions(int count)
    {
        nearCollisions += count;
    }

    public int getNearCollisions()
    {
        return nearCollisions;
    }
}

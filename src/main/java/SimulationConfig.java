public class SimulationConfig
{
    private final double roadLength;
    private final int maxTicks;
    private final int spawnInterval;
    private final double minSpeed;
    private final double maxSpeed;

    public SimulationConfig(double roadLength,
                            int maxTicks,
                            int spawnInterval,
                            double minSpeed,
                            double maxSpeed)
    {
        this.roadLength = roadLength;
        this.maxTicks = maxTicks;
        this.spawnInterval = spawnInterval;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    public double getRoadLength()
    {
        return roadLength;
    }

    public int getMaxTicks()
    {
        return maxTicks;
    }

    public int getSpawnInterval()
    {
        return spawnInterval;
    }

    public double getMinSpeed()
    {
        return minSpeed;
    }

    public double getMaxSpeed()
    {
        return maxSpeed;
    }
}
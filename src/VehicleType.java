public enum VehicleType
{
    CAR(5.0, 0.5, 4.5),
    BUS(3.5, 0.3, 10.0),
    TRUCK(3.0, 0.25, 8.0);

    private final double maxSpeed;
    private final double maxAcceleration;
    private final double length;

    VehicleType(double maxSpeed, double maxAcceleration, double length)
    {
        this.maxSpeed = maxSpeed;
        this.maxAcceleration = maxAcceleration;
        this.length = length;
    }

    public double getMaxSpeed()
    {
        return maxSpeed;
    }

    public double getMaxAcceleration()
    {
        return maxAcceleration;
    }

    public double getLength()
    {
        return length;
    }
}
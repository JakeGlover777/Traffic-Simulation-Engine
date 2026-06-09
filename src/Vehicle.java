public class Vehicle
{
    private static final double MAX_DECELERATION = 1.0;
    private static final double REACTION_TIME = 1.5;
    private static final double MINIMUM_GAP = 3.0;

    private final int id;
    private final VehicleType type;
    private final Road road;

    private double position;
    private double speed;
    private double acceleration;

    public Vehicle(int id, VehicleType type, Road road)
    {
        this.id = id;
        this.type = type;
        this.road = road;

        this.position = 0;
        this.speed = type.getMaxSpeed() * 0.5;
        this.acceleration = 0;
    }

    public void update()
    {
        acceleration = type.getMaxAcceleration();

        Vehicle vehicleAhead = road.getVehicleAhead(this);

        if (vehicleAhead != null)
        {
            double distanceToVehicleAhead =
                    vehicleAhead.getPosition() - this.position;

            double safeDistance =
                    calculateSafeFollowingDistance();

            if (distanceToVehicleAhead < safeDistance)
            {
                acceleration = -MAX_DECELERATION;
            }
        }

        updateSpeed();
        updatePosition();
    }

    private double calculateSafeFollowingDistance()
    {
        return (speed * REACTION_TIME) + type.getLength() + MINIMUM_GAP;
    }

    private void updateSpeed()
    {
        speed += acceleration;

        if (speed > type.getMaxSpeed())
        {
            speed = type.getMaxSpeed();
        }

        if (speed < 0)
        {
            speed = 0;
        }
    }

    private void updatePosition()
    {
        position += speed;
    }

    public int getId()
    {
        return id;
    }

    public VehicleType getType()
    {
        return type;
    }

    public double getPosition()
    {
        return position;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getAcceleration()
    {
        return acceleration;
    }
}
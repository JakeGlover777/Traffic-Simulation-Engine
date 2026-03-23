public class Vehicle
{
    private static final double MAX_ACCELERATION = 0.5;
    private static final double MAX_DECELERATION = 1.0;
    private static final double STOP_DISTANCE = 3.0;
    private static final double BRAKING_DISTANCE = 6.0;
    private final Road road;

    private double acceleration;
    private double position;
    private double speed;
    private double maxSpeed;
    private int id;


    public Vehicle(double initialSpeed, double maxSpeed, int id, Road road)
    {
        this.position = 0;
        this.speed = initialSpeed;
        this.maxSpeed = maxSpeed;
        this.id = id;
        this.road = road;
    }

    public void update()
    {
        acceleration = MAX_ACCELERATION;

        Vehicle ahead = road.getVehicleAhead(this);

        if (ahead != null)
        {
            double distanceApart = ahead.getPosition() - position;

            if (distanceApart < STOP_DISTANCE)
            {
                acceleration = -MAX_DECELERATION;
            }
            else if (distanceApart < BRAKING_DISTANCE)
            {
                acceleration = -MAX_DECELERATION / 2;
            }
        }

        speed += acceleration;
        
        if (speed > maxSpeed)
        {
            speed = maxSpeed;
        }

        if (speed < 0)
        {
            speed = 0;
        }

        position += speed;
    }

    public double getPosition()
    {
        return position;
    }

    public int getId()
    {
        return id;
    }
}
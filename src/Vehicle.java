public class Vehicle
{
    private static final double STOP_DISTANCE = 3.0;
    private static final double BRAKING_DISTANCE = 6.0;
    private final Road road;

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
        speed = maxSpeed;
        Vehicle ahead = road.getVehicleAhead(this);

        if (ahead != null)
        {
            double distanceApart = ahead.getPosition()
                    - position;

            if (distanceApart < STOP_DISTANCE)
            {
                speed = 0;
            }

            else if (distanceApart < BRAKING_DISTANCE)
            {
                speed = maxSpeed* 0.5;
            }
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
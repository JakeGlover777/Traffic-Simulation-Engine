public class Vehicle
{
    private double position;
    private double speed;
    private double maxSpeed;
    private int id;
    private Road road;

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
                    - this.getPosition();

            if (distanceApart < 3)
            {
                speed = 0;
            }

            else if (distanceApart < 6)
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
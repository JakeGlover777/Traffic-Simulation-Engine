public class Vehicle
{

    private double position;
    private double speed;

    public Vehicle(double initialSpeed)
    {
        this.position = 0;
        this.speed = initialSpeed;
    }

    public void update()
    {
        position += speed;
    }

    public double getPosition()
    {
        return position;
    }
}
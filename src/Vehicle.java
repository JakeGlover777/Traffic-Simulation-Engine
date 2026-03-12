public class Vehicle
{
    private double position;
    private double speed;
    private int id;

    public Vehicle(double initialSpeed, int id)
    {
        this.position = 0;
        this.speed = initialSpeed;
        this.id = id;
    }

    public void update()
    {
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
public class Main
{
    public static void main(String[] args)
    {
        Vehicle car = new Vehicle(10);
        SimulationEngine engine = new SimulationEngine(car);
        engine.start(10);
    }
}
public class Main
{
    public static void main(String[] args)
    {
        SimulationEngine engine = new SimulationEngine();

        Vehicle car1 = new Vehicle(1.5);
        Vehicle car2 = new Vehicle(1.0);
        Vehicle car3 = new Vehicle(2.0);

        engine.addVehicle(car1);
        engine.addVehicle(car2);
        engine.addVehicle(car3);

        engine.start(10);
    }
}
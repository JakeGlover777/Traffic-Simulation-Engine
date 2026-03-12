public class Main
{
    public static void main(String[] args)
    {
        SimulationEngine engine = new SimulationEngine();

        Vehicle car1 = new Vehicle(1.5,1);
        Vehicle car2 = new Vehicle(1.0,2);
        Vehicle car3 = new Vehicle(2.0,3);

        engine.addVehicle(car1);
        engine.addVehicle(car2);
        engine.addVehicle(car3);

        engine.start(10);
    }
}
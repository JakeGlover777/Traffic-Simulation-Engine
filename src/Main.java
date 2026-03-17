public class Main
{
    public static void main(String[] args)
    {
        SimulationEngine engine = new SimulationEngine();

        Road road = engine.getRoad();

        Vehicle car1 = new Vehicle(1.5,3,1, road);
        Vehicle car2 = new Vehicle(1.0,4,2, road);
        Vehicle car3 = new Vehicle(2.0,2,3, road);

        engine.addVehicle(car1);
        engine.addVehicle(car2);
        engine.addVehicle(car3);

        engine.start(50);
    }
}
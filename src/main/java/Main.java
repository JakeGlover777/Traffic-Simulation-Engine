public class Main
{
    public static void main(String[] args)
    {
        SimulationConfig config = new SimulationConfig(200.0, 100, 2,
                2.0, 5.0);

        SimulationEngine engine = new SimulationEngine(config);

        engine.start();
    }
}

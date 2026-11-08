import com.jakeglover.trafficsimulation.engine.SimulationConfig;
import com.jakeglover.trafficsimulation.engine.SimulationEngine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationEngineTest
{
    @Test
    public void newSimulationStartsAtTickZero()
    {
        SimulationConfig config = new SimulationConfig(
                200.0, 10, 2, 2.0, 5.0);

        SimulationEngine engine = new SimulationEngine(config);

        assertEquals(0, engine.getCurrentTick());
        assertFalse(engine.isRunning());
    }

    @Test
    public void startSetsSimulationToRunning()
    {
        SimulationConfig config = new SimulationConfig(
                200.0, 10, 2, 2.0, 5.0);

        SimulationEngine engine = new SimulationEngine(config);

        engine.start();

        assertTrue(engine.isRunning());
    }

    @Test
    public void tickAdvancesSimulationByOne()
    {
        SimulationConfig config = new SimulationConfig(
                200.0, 10, 2, 2.0, 5.0);

        SimulationEngine engine = new SimulationEngine(config);

        engine.start();
        engine.tick();

        assertEquals(1, engine.getCurrentTick());
    }

    @Test
    public void tickDoesNothingBeforeSimulationStarts()
    {
        SimulationConfig config = new SimulationConfig(
                200.0, 10, 2, 2.0, 5.0);

        SimulationEngine engine = new SimulationEngine(config);

        engine.tick();

        assertEquals(0, engine.getCurrentTick());
        assertFalse(engine.isRunning());
    }

    @Test
    public void simulationStopsAtMaximumTicks()
    {
        SimulationConfig config = new SimulationConfig(
                200.0, 3, 2, 2.0, 5.0);

        SimulationEngine engine = new SimulationEngine(config);

        engine.start();

        engine.tick();
        engine.tick();
        engine.tick();

        assertEquals(3, engine.getCurrentTick());
        assertFalse(engine.isRunning());
    }

    @Test
    public void completedSimulationCannotRestart()
    {
        SimulationConfig config = new SimulationConfig(
                200.0, 1, 2, 2.0, 5.0);

        SimulationEngine engine = new SimulationEngine(config);

        engine.start();
        engine.tick();

        engine.start();

        assertFalse(engine.isRunning());
        assertEquals(1, engine.getCurrentTick());
    }
}
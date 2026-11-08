package com.jakeglover.trafficsimulation.service;

import com.jakeglover.trafficsimulation.engine.SimulationConfig;
import com.jakeglover.trafficsimulation.engine.SimulationEngine;
import org.springframework.stereotype.Service;

@Service
public class SimulationService
{
    private final SimulationEngine engine;

    public SimulationService()
    {
        SimulationConfig config = new SimulationConfig(
                200.0,
                100,
                2,
                2.0,
                5.0);

        this.engine = new SimulationEngine(config);
    }

    public SimulationEngine getEngine()
    {
        return engine;
    }

    public void startSimulation()
    {
        engine.start();
    }

    public void tickSimulation()
    {
        engine.tick();
    }
}
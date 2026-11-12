package com.jakeglover.trafficsimulation.service;

import com.jakeglover.trafficsimulation.engine.SimulationConfig;
import com.jakeglover.trafficsimulation.engine.SimulationEngine;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

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

    @Scheduled(fixedRate = 100)
    public void updateSimulation()
    {
        if (engine.isRunning())
        {
            engine.tick();
        }
    }
}
package com.jakeglover.trafficsimulation.service;

import com.jakeglover.trafficsimulation.engine.SimulationConfig;
import com.jakeglover.trafficsimulation.engine.SimulationEngine;
import com.jakeglover.trafficsimulation.engine.SimulationStats;
import com.jakeglover.trafficsimulation.entity.SimulationRun;
import com.jakeglover.trafficsimulation.repository.SimulationRunRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

import java.time.LocalDateTime;

@Service
public class SimulationService
{
    private final SimulationRunRepository simulationRunRepository;

    private LocalDateTime startedAt;
    private boolean resultSaved;
    private SimulationEngine engine;

    public SimulationService(SimulationRunRepository simulationRunRepository)
    {
        this.simulationRunRepository = simulationRunRepository;
        this.engine = createEngine();
    }

    public SimulationEngine getEngine()
    {
        return engine;
    }

    public SimulationRun getSimulationRun(Long id)
    {
        return simulationRunRepository.findById(id)
                .orElseThrow();
    }

    public void startSimulation()
    {
        if (engine.isRunning())
        {
            return;
        }

        if (engine.getCurrentTick() >= engine.getMaxTicks())
        {
            engine = createEngine();
        }

        startedAt = LocalDateTime.now();
        resultSaved = false;

        engine.start();
    }

    public void tickSimulation()
    {
        engine.tick();
    }

    private void saveSimulationResult()
    {
        SimulationStats stats = engine.getStats();

        SimulationRun simulationRun = new SimulationRun(
                startedAt,
                LocalDateTime.now(),
                stats.getVehiclesSpawned(),
                stats.getVehiclesCompleted(),
                stats.getAverageSpeed(),
                stats.getNearCollisions(),
                engine.getCongestionLevel());

        simulationRunRepository.save(simulationRun);
    }

    private SimulationEngine createEngine()
    {
        SimulationConfig config = new SimulationConfig(
                200.0,
                100,
                2,
                2.0,
                5.0);

        return new SimulationEngine(config);
    }

    public List<SimulationRun> getSimulationHistory()
    {
        return simulationRunRepository.findAll();
    }

    @Scheduled(fixedRate = 100)
    public void updateSimulation()
    {
        if (engine.isRunning())
        {
            engine.tick();

            if (!engine.isRunning() && !resultSaved)
            {
                saveSimulationResult();
                resultSaved = true;
            }
        }
    }
}
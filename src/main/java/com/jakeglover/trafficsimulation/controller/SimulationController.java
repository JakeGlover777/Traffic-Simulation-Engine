package com.jakeglover.trafficsimulation.controller;

import com.jakeglover.trafficsimulation.engine.SimulationEngine;
import com.jakeglover.trafficsimulation.model.SimulationStateResponse;
import com.jakeglover.trafficsimulation.service.SimulationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jakeglover.trafficsimulation.entity.SimulationRun;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/simulations")
public class SimulationController
{
    private final SimulationService simulationService;

    public SimulationController(SimulationService simulationService)
    {
        this.simulationService = simulationService;
    }

    @GetMapping("/current")
    public SimulationStateResponse getCurrentSimulation()
    {
        return buildResponse();
    }

    @PostMapping("/start")
    public SimulationStateResponse startSimulation()
    {
        simulationService.startSimulation();

        return buildResponse();
    }

    @PostMapping("/tick")
    public SimulationStateResponse tickSimulation()
    {
        simulationService.tickSimulation();

        return buildResponse();
    }

    private SimulationStateResponse buildResponse()
    {
        SimulationEngine engine = simulationService.getEngine();

        return new SimulationStateResponse(
                engine.getCurrentTick(),
                engine.isRunning(),
                engine.getRoad().getVehicleCount(),
                engine.getTrafficDensity(),
                engine.getCongestionLevel(),
                engine.getStats().getVehiclesSpawned(),
                engine.getStats().getVehiclesCompleted(),
                engine.getStats().getAverageSpeed(),
                engine.getStats().getNearCollisions());
    }

    @GetMapping("/{id}")
    public SimulationRun getSimulationRun(@PathVariable Long id)
    {
        return simulationService.getSimulationRun(id);
    }

    @GetMapping("/history")
    public List<SimulationRun> getSimulationHistory()
    {
        return simulationService.getSimulationHistory();
    }
}
package com.jakeglover.trafficsimulation.model;

public class SimulationStatusResponse
{
    private final String status;

    public SimulationStatusResponse(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
}
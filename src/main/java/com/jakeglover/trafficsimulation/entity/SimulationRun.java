package com.jakeglover.trafficsimulation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class SimulationRun
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startedAt;
    private LocalDateTime completedAt;

    private int vehiclesSpawned;
    private int vehiclesCompleted;

    private double averageSpeed;

    private int nearCollisions;

    private String congestionLevel;

    public SimulationRun()
    {
    }

    public SimulationRun(
            LocalDateTime startedAt,
            LocalDateTime completedAt,
            int vehiclesSpawned,
            int vehiclesCompleted,
            double averageSpeed,
            int nearCollisions,
            String congestionLevel)
    {
        this.startedAt = startedAt;
        this.completedAt = completedAt;
        this.vehiclesSpawned = vehiclesSpawned;
        this.vehiclesCompleted = vehiclesCompleted;
        this.averageSpeed = averageSpeed;
        this.nearCollisions = nearCollisions;
        this.congestionLevel = congestionLevel;
    }

    public Long getId()
    {
        return id;
    }

    public LocalDateTime getStartedAt()
    {
        return startedAt;
    }

    public LocalDateTime getCompletedAt()
    {
        return completedAt;
    }

    public int getVehiclesSpawned()
    {
        return vehiclesSpawned;
    }

    public int getVehiclesCompleted()
    {
        return vehiclesCompleted;
    }

    public double getAverageSpeed()
    {
        return averageSpeed;
    }

    public int getNearCollisions()
    {
        return nearCollisions;
    }

    public String getCongestionLevel()
    {
        return congestionLevel;
    }
}
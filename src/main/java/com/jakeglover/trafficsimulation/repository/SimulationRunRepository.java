package com.jakeglover.trafficsimulation.repository;

import com.jakeglover.trafficsimulation.entity.SimulationRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationRunRepository extends JpaRepository<SimulationRun, Long>
{
}
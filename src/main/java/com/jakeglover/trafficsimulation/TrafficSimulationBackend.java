package com.jakeglover.trafficsimulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrafficSimulationBackend
{
    public static void main(String[] args)
    {
        SpringApplication.run(TrafficSimulationBackend.class, args);
    }
}
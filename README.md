# Traffic Simulation Engine

A Java-based traffic simulation engine featuring real-time JavaFX visualisation, vehicle behaviour modelling, and traffic analytics.

---

## Overview

The Traffic Simulation Engine is an object-oriented Java application that simulates vehicles travelling along a road while collecting useful traffic statistics. The project has evolved from a console-based simulation into a real-time JavaFX visualisation and is being developed incrementally using Git and Maven.

This project was built to strengthen my understanding of software engineering principles including object-oriented design, simulation systems, data modelling, and desktop application development.

---

## Features

- ✅ Real-time JavaFX visualisation
- ✅ com.jakeglover.trafficsimulation.engine.Vehicle spawning system
- ✅ Multiple vehicle types (Car, Bus, Truck)
- ✅ com.jakeglover.trafficsimulation.engine.Vehicle acceleration and deceleration
- ✅ Safe following distance logic
- ✅ Near-collision detection
- ✅ Traffic density calculation
- ✅ Congestion level reporting
- ✅ Event logging
- ✅ Simulation statistics
- ✅ Maven project structure

---

## Technologies

- Java 25
- JavaFX
- Maven
- Git
- GitHub
- Object-Oriented Programming (OOP)

---

## Project Structure

```
TrafficSimulationApp
        │
        ▼
com.jakeglover.trafficsimulation.engine.SimulationEngine
        │
 ┌──────┴──────┐
 ▼             ▼
com.jakeglover.trafficsimulation.engine.Road      com.jakeglover.trafficsimulation.engine.SimulationStats
 │
 ▼
com.jakeglover.trafficsimulation.engine.Vehicle
 │
 ▼
com.jakeglover.trafficsimulation.engine.VehicleType
```

---

## Current Simulation

The simulation currently models:

- com.jakeglover.trafficsimulation.engine.Vehicle spawning at configurable intervals
- Different vehicle types with unique driving characteristics
- Safe following behaviour
- com.jakeglover.trafficsimulation.engine.Vehicle movement across the road
- Vehicles leaving the simulation when they reach the end of the road
- Real-time rendering using JavaFX

---

## Running the Project

### Requirements

- Java 25
- Maven

### Run

```bash
mvn javafx:run
```

---

## Planned Features

- [ ] com.jakeglover.trafficsimulation.engine.Vehicle colours based on type
- [ ] Lane markings
- [ ] Statistics dashboard
- [ ] Start/Pause controls
- [ ] Multiple lanes
- [ ] Traffic lights
- [ ] com.jakeglover.trafficsimulation.engine.Road intersections
- [ ] Corner and waypoint routing
- [ ] Adjustable simulation speed
- [ ] Save and load simulation states

---

## Repository

This project is actively developed using a feature-based workflow. New functionality is implemented on the development branch before being merged into the main branch as stable releases.

---

## License

This project is licensed under the MIT License.

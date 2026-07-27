Traffic Simulation Engine
A Java-based traffic simulation engine featuring real-time JavaFX visualisation, vehicle behaviour modelling, and traffic analytics.

Overview
The Traffic Simulation Engine is an object-oriented Java application that simulates vehicles travelling along a road while collecting useful traffic statistics. The project has evolved from a console based simulation into a real-time JavaFX visualisation and is being developed incrementally using Git and Maven.

This project was built to strengthen my understanding of software engineering principles including object-oriented design, simulation systems, data modelling, and desktop application development.

Features
✅ Real-time JavaFX visualisation
✅ Vehicle spawning system
✅ Multiple vehicle types (Car, Bus, Truck)
✅ Vehicle acceleration and deceleration
✅ Safe following distance logic
✅ Near-collision detection
✅ Traffic density calculation
✅ Congestion level reporting
✅ Event logging
✅ Simulation statistics
✅ Maven project structure
Technologies
Java 25
JavaFX
Maven
Project Structure
TrafficSimulationApp
        │
        ▼
SimulationEngine
        │
 ┌──────┴──────┐
 ▼             ▼
Road      SimulationStats
 │
 ▼
Vehicle
 │
 ▼
VehicleType
Current Simulation
The simulation currently models:

Vehicle spawning at configurable intervals
Different vehicle types with unique driving characteristics
Safe following behaviour
Vehicle movement across the road
Vehicles leaving the simulation when they reach the end of the road
Real-time rendering using JavaFX
Running the Project
Requirements
Java 25
Maven
Run
mvn javafx:run
Planned Features
Vehicle colours based on type
Lane markings
Statistics dashboard
Start/Pause controls
Multiple lanes
Traffic lights
Road intersections
Corner and waypoint routing
Adjustable simulation speed
Save and load simulation states
Repository
This project is actively developed using a feature-based workflow. New functionality is implemented on the development branch before being merged into the main branch as stable releases.

License
This project is licensed under the MIT License.

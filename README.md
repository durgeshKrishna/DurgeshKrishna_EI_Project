<<<<<<< HEAD
BEHAVIOURAL DESIGN PATTERN
1. News Agency - Observer Pattern
Use Case
This application simulates a news agency that distributes news to multiple subscribers. When the agency publishes a new story, all registered subscribers are notified instantly and automatically, ensuring they receive the latest updates without having to poll the agency.

Design Pattern
The application uses the Observer Design Pattern. This pattern defines a one-to-many dependency between objects so that when one object (the subject) changes state, all its dependents (the observers) are notified and updated automatically.

How it Relates to the Use Case
Subject: The NewsAgency class, which maintains the list of subscribers and the latest news story.
Observers: Any class implementing the Observer interface. In this case, the Subscriber class receives notifications.

Classes
Subject: Interface defining methods for attaching, detaching, and notifying observers.
NewsAgency: The concrete subject that manages observers and notifies them of new latestNews.
Observer: Interface for all subscribers that need to be notified of news updates.
Subscriber: A concrete implementation of the Observer interface that prints the news it receives.
ObserverPattern: The main class that runs the simulation.

2. E-commerce Payment System - Strategy Pattern
Use Case
This application demonstrates a payment processing system for an e-commerce platform. It allows a user to select from various payment methods (e.g., Credit Card, PayPal, UPI) at checkout. The system processes the payment using the selected method without changing the core checkout logic.

Design Pattern
The Strategy Pattern is used to define a family of algorithms, encapsulate each one, and make them interchangeable. This lets the algorithm vary independently from the clients that use it.

How it Relates to the Use Case
Context: The PaymentContext class, which holds a reference to a payment strategy and uses it to execute the payment.
Strategy: The PaymentStrategy interface, which defines a common pay method for all payment algorithms.
Concrete Strategies: CreditCardPayment, PayPalPayment, and UPIPayment are concrete implementations of the PaymentStrategy interface, each providing a different way to pay.

Classes
PaymentStrategy: The interface for all payment algorithms.
CreditCardPayment: A concrete strategy for paying via credit card.
PayPalPayment: A concrete strategy for paying via PayPal.
UPIPayment: A concrete strategy for paying via UPI.
PaymentContext: The class that uses a PaymentStrategy to process a payment.
StrategyPattern: The main class that demonstrates the selection and use of different payment strategies.

CREATIONAL DESIGN PATTERN
1. Database Connection Manager - Singleton Pattern
Use Case
This application simulates a system that requires a single, globally accessible point for database connections. To conserve resources and ensure a consistent connection state, the application must guarantee that only one instance of the database connection object is ever created.

Design Pattern
The Singleton Pattern ensures a class has only one instance and provides a global point of access to it. This is useful for managing shared resources like database connections or loggers.

How it Relates to the Use Case
The pattern is used to ensure that the DatabaseConnection class can only be instantiated once. The static getInstance() method provides the single,
shared instance to any part of the application that needs it.

Classes
DatabaseConnection: The Singleton class with a private constructor and a static getInstance() method that returns the sole instance of the class.
It uses double-checked locking for thread safety.

SingletonPattern: The main class that demonstrates that multiple calls to getInstance() return the exact same object instance.

2. Notification Service - Factory Pattern
Use Case
This application provides a notification service that can send different types of notifications, such as Email and SMS. The client code that requests a notification doesn't need to know the specific details of how each notification object is created.

Design Pattern
The Factory Pattern defines an interface for creating an object but lets subclasses alter the type of objects that will be created. It decouples the client from the concrete classes it needs to instantiate.

How it Relates to the Use Case
Factory: NotificationFactory is an abstract class that declares the factory method. EmailNotificationFactory and SMSNotificationFactory are concrete factories that create specific notification objects.
Product: The Notification interface defines the object that the factory method creates. EmailNotification and SMSNotification are concrete products.

Classes
Notification: The interface for notification products.
EmailNotification, SMSNotification: Concrete implementations of Notification.
NotificationFactory: The abstract factory class.
EmailNotificationFactory, SMSNotificationFactory: Concrete factories for creating specific notification types.

FactoryPattern: The main class that uses the factories to create and send notifications.

STRUCTURAL DESIGN PATTERN
1. Car Dealership System - Adapter Pattern
Use Case
A car dealership's software system is designed to work with Car objects that have specific methods (getName, getBrand, getPrice). The dealership starts sourcing foreign cars, but the data for these cars comes from a ForeignCar class with a different interface (getCarName, getCarBrand, getBrandPrice). The system needs to display all cars uniformly.

Design Pattern
The Adapter Pattern allows objects with incompatible interfaces to collaborate. It acts as a wrapper between two objects, catching calls for one object and transforming them into a format and interface recognizable by the second.

How it Relates to the Use Case
Target: The Car interface, which the client system expects.
Adaptee: The ForeignCar class, which has the incompatible interface.
Adapter: The ForeignCarAdapter class, which wraps a ForeignCar object and implements the Car interface, translating the method calls.

Classes
Car: The target interface that the client code uses.
IndianCar: An existing class that already conforms to the Car interface.
ForeignCar: The adaptee class with a different interface.
ForeignCarAdapter: The adapter that makes ForeignCar compatible with the Car interface.\
CarDealerClient: The client class that works with objects of the Car interface.
AdapterPattern: The main class that demonstrates how the adapter allows the client to work with both car types seamlessly.

2. Tea Shop Customizer - Decorator Pattern
Use Case

This application models a tea shop where customers can customize their drinks. A customer starts with a SimpleTea and can dynamically add extra ingredients like Masala, Ginger, or Cardamom. Each addition modifies the final description and price of the tea.

Design Pattern

The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

How it Relates to the Use Case
Component: The Tea interface defines the common methods for the objects being decorated.
Concrete Component: SimpleTea is the basic object to which new functionalities can be added.
Decorator: TeaDecorator is an abstract class that holds a reference to a Tea object and conforms to the Tea interface.
Concrete Decorators: MasalaTeaDecorator, GingerTeaDecorator, and CardamomTeaDecorator are classes that add specific functionalities (and cost) to the Tea object they wrap.

Classes
Tea: The component interface.
SimpleTea: The concrete component.
TeaDecorator: The abstract decorator.
MasalaTeaDecorator, GingerTeaDecorator, CardamomTeaDecorator: Concrete decorator classes.

DecoratorPattern: The main class that shows how a simple tea can be decorated with multiple additions.


🏠 Smart Home System
Use Case Overview
The Smart Home System is a console-based application designed to simulate the backend of a smart home environment. It allows users to manage and control various smart devices (lights, door locks, thermostats) through a central hub. The system supports scheduling device operations, automating tasks with triggers, grouping devices for simultaneous control, and viewing system logs.

Functionalities
Device Management: Add, remove, and control individual smart devices.

Scheduling: Set commands for devices to execute at a specified time.

Automation: Create triggers that perform an action when a condition is met.

Group Control: Create groups of devices to turn them all on or off with a single command.

Status Reporting: View the current status of all connected devices.

System Logging: View a log of all actions performed in the system.

🧩 Design Patterns Used
1. Factory Method Pattern
Purpose: To create instances of various device types without exposing the instantiation logic to the client. This pattern provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.

Relation to Use Case: The SmartHomeHub uses the DeviceFactory to dynamically create Light, DoorLock, or Thermostat objects based on user input, which decouples the hub from concrete device classes.

Classes Involved: DeviceFactory, Device, Light, DoorLock, Thermostat.

2. Proxy Pattern
Purpose: To provide a surrogate or placeholder for another object to control access to it. The proxy wraps the real object and can add functionality like logging, access control, or lazy loading.

Relation to Use Case: Every device added to the SmartHomeHub is wrapped in a DeviceProxy. This controls access to the real device and can be extended to add features like permission checks without modifying the device's code.

Classes Involved: DeviceProxy, Device.

3. Observer Pattern
Purpose: To define a subscription mechanism to notify multiple objects about any events that happen to the object they are observing.

Relation to Use Case: The structure is in place for devices to be updated on system changes. Each Device implements the DeviceObserver interface, allowing it to receive updates and react accordingly, such as the Thermostat checking its temperature.

Classes Involved: DeviceObserver, Device.

4. Command Pattern (Implicit)
Purpose: Encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

Relation to Use Case: Schedule and Trigger objects encapsulate a request (e.g., "turn on device 1") and its context (time or condition). The SmartHomeHub stores and manages these command objects, decoupling the request from the immediate execution logic.

Classes Involved: Schedule, Trigger, SmartHomeHub.

🗂️ Classes and Their Responsibilities
Device.java: Abstract base class defining common properties and methods for all devices; also implements the DeviceObserver interface.

Light.java: Concrete implementation of Device for light devices.

Thermostat.java: Concrete implementation of Device for thermostat devices.

DoorLock.java: Concrete implementation of Device for door lock devices.

DeviceFactory.java: Factory class for creating various device instances based on type.

DeviceProxy.java: Proxy class that wraps around real devices to control access.

DeviceObserver.java: The observer interface for device status updates.

SmartHomeHub.java: The central hub for managing all devices, schedules, triggers, and groups.

Schedule.java: Represents scheduling information for a device command.

Trigger.java: Represents a trigger that automates a device action based on a condition.

DeviceGroup.java: Represents a collection of devices that can be controlled together.

Main.java: The entry point of the application for handling all user interaction.

🛠️ Compiling and Executing
To compile and execute the project, navigate to the root directory (EXERCISE_2/Smart Home System/) and use the following commands.

Compile all source files:

Bash

javac */*.java *.java
Run the application:

Bash

java Main
🛠️ Tech Stack
Programming Language
Java: The primary language used for implementing the Smart Home System. Java's object-oriented principles and robust ecosystem perfectly support the design patterns and architecture used in this project.

JDK Version
JDK 17: The project is developed and tested using Java Development Kit (JDK) version 17, which provides a stable and feature-rich environment.

Build and Execution
Java Compiler (javac): Used to compile the Java source code into bytecode.

Java Runtime (java): Executes the compiled Java bytecode to run the application.

Version Control
Git: Used for version control, allowing for tracking changes and managing the codebase.

📞 Contact Information
Gmail: durgeshkrishna615@gmail.com

GitHub: durgeshKrishna
=======
# Exercise 1 (Problem Statement on Design Patterns)

# BEHAVIOURAL DESIGN PATTERN

## 1) News Agency - Observer Pattern 📰
   
This project is a Java implementation of the **Observer Design Pattern**. It demonstrates how an object (the **Subject**) can notify a list of dependent objects (the **Observers**) automatically when its state changes, promoting loose coupling.

The use case simulates a news agency that distributes news to multiple subscribers. When the agency publishes a new story, all registered subscribers are notified instantly and automatically, ensuring they receive the latest updates without having to poll the agency.

#### Implementation Details

* **`Subject` (Interface):** Defines the contract for the object being observed, with methods to attach, detach, and notify observers.
* **`Observer` (Interface):** Defines the contract for subscribers, with an `update()` method that the Subject calls during notification.
* **`NewsAgency` (Class):** The concrete **Subject**. It maintains a list of `Observer`s and triggers notifications when new news is published via its `setNews()` method.
* **`Subscriber` (Class):** The concrete **Observer**. It implements the `update()` method to handle the notification (e.g., printing the news received).
* **`ObserverPattern` (Class):** The entry point that wires everything together and demonstrates the notification flow.

## 2) E-commerce Payment System - Strategy Pattern 💳

This project is an implementation of the **Strategy Design Pattern**. It defines a family of algorithms (payment methods), encapsulates each one, and makes them interchangeable. This lets the algorithm vary independently from clients that use it.

The use case demonstrates a payment processing system for an e-commerce platform. It allows a user to select from various payment methods (e.g., Credit Card, PayPal, UPI) at checkout. The system processes the payment using the selected method without changing the core checkout logic.

#### Implementation Details

* **`PaymentStrategy` (Interface):** The **Strategy** interface that declares the common `pay()` operation for all supported payment algorithms.
* **`CreditCardPayment`, `PayPalPayment` & `UPIPayment` (Classes):** The concrete **Strategies**. Each one implements the `pay()` method with a specific payment algorithm.
* **`PaymentContext` (Class):** The **Context** that holds a reference to a payment strategy object. It delegates the payment task to the current strategy, remaining independent of the actual algorithm used.
* **`StrategyPattern` (Class):** The entry point that creates and assigns different strategies to the context to show the dynamic behavior.

# CREATIONAL DESIGN PATTERN

## 1) Database Connection Manager - Singleton Pattern 🔗

This project demonstrates the **Singleton Design Pattern**. This creational pattern ensures that a class has only one instance and provides a global point of access to that single instance.

The use case simulates a system that requires a single, globally accessible point for database connections. To conserve resources and ensure a consistent connection state, the application must guarantee that only one instance of the database connection object is ever created.

#### Implementation Details

* **`DatabaseConnection` (Class):** The **Singleton** class. It features a `private` constructor to prevent direct instantiation and a `public static getInstance()` method that controls access to the single instance using double-checked locking for thread safety.
* **`SingletonPattern` (Class):** The client code that retrieves the singleton instance multiple times and verifies that all references point to the exact same object.

## 2) Notification Service - Factory Pattern 📧

This project is a classic implementation of the **Factory Method Design Pattern**. This creational pattern provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.

The use case features a notification service that can send different types of notifications, such as Email and SMS. The client code that requests a notification doesn't need to know the specific details of how each notification object is created.

#### Implementation Details

* **`Notification` (Interface):** The **Product** interface, which defines the common methods for all concrete notification types.
* **`EmailNotification` & `SMSNotification` (Classes):** The **Concrete Products** that implement the `Notification` interface.
* **`NotificationFactory` (Abstract Class):** The **Creator**. It contains the abstract `createNotification()` factory method.
* **`EmailNotificationFactory` & `SMSNotificationFactory` (Classes):** The **Concrete Creators**. Each class overrides the `createNotification()` method to produce and return a specific type of notification.
* **`FactoryPattern` (Class):** The client code that uses the factories to create and send notifications.

# STRUCTURAL DESIGN PATTERN

## 1) Car Dealership System - Adapter Pattern 🚗

This project demonstrates the **Adapter Design Pattern**. This structural pattern allows objects with incompatible interfaces to collaborate. It acts as a bridge between two incompatible interfaces by converting the interface of a class into another interface a client expects.

The use case features a car dealership's software system designed to work with `Car` objects that have specific methods (`getName`, `getBrand`, `getPrice`). The dealership starts sourcing foreign cars, but the data for these cars comes from a `ForeignCar` class with a different interface (`getCarName`, `getCarBrand`, `getBrandPrice`). The adapter makes this integration possible without changing the existing code.

#### Implementation Details

* **`Car` (Interface):** The **Target Interface**. This is the interface that the client system expects to use for displaying car information.
* **`IndianCar` (Class):** An existing class that already conforms to the `Car` interface.
* **`ForeignCar` (Class):** The **Adaptee**. This is the existing class with an incompatible interface that we need to integrate into our system.
* **`ForeignCarAdapter` (Class):** The **Adapter**. This class implements the `Car` interface and internally wraps an instance of the `ForeignCar`, translating calls from the target interface to the adaptee's interface.
* **`CarDealerClient` (Class):** The client class that works with objects of the `Car` interface.
* **`AdapterPattern` (Class):** The entry point that demonstrates how the adapter allows the client to work with both car types seamlessly.

## 2) Tea Shop Customizer - Decorator Pattern 🍵

This project demonstrates the **Decorator Design Pattern**. This structural pattern allows you to attach new behaviors to objects dynamically by placing them inside special wrapper objects that contain the behaviors.

The use case models a tea shop where customers can customize their drinks. A customer starts with a `SimpleTea` and can dynamically add extra ingredients like Masala, Ginger, or Cardamom. Each addition modifies the final description and price of the tea, providing a flexible alternative to subclassing for extending functionality.

#### Implementation Details

* **`Tea` (Interface):** The **Component**. This is the common interface for both the base object (the tea) and the decorators (the extras).
* **`SimpleTea` (Class):** The **Concrete Component**. This is the basic object that we will dynamically add responsibilities to.
* **`TeaDecorator` (Abstract Class):** The base **Decorator**. It implements the `Tea` interface and holds a reference to a `Tea` object, which it "wraps".
* **`MasalaTeaDecorator`, `GingerTeaDecorator` & `CardamomTeaDecorator` (Classes):** The **Concrete Decorators**. These classes extend the base decorator and add their own functionality (cost and description) to the wrapped object.
* **`DecoratorPattern` (Class):** The client code that assembles the tea order by wrapping a simple tea with multiple decorators.

# Exercise 2
# Smart Home System 🏠

## Overview
This is a Java-based console application that simulates the backend of a smart home environment. It allows users to manage and control various smart devices (lights, door locks, thermostats) through a central hub. The system supports scheduling device operations, automating tasks with triggers, grouping devices for simultaneous control, and viewing system logs.

## Core Features
* **Device Management:** Add, remove, and control individual smart devices (lights, door locks, thermostats).

* **Scheduling:** Set commands for devices to execute at a specified time.

* **Automation:** Create triggers that perform an action when a condition is met (e.g., turn on lights when temperature drops).

* **Group Control:** Create groups of devices to turn them all on or off with a single command.

* **Status Reporting:** View the current status of all connected devices in the system.

* **System Logging:** View a comprehensive log of all actions performed in the system.

## Technical Design

### Design Patterns Used

* **Factory Method Pattern:** The `DeviceFactory` creates instances of various device types (`Light`, `DoorLock`, `Thermostat`) without exposing the instantiation logic to the client. This decouples the `SmartHomeHub` from concrete device classes, making the system easily extensible with new device types.

* **Proxy Pattern:** Every device added to the `SmartHomeHub` is wrapped in a `DeviceProxy`. This controls access to the real device and can be extended to add features like logging, permission checks, or lazy loading without modifying the device's code.

* **Observer Pattern:** The structure is in place for devices to be updated on system changes. Each `Device` implements the `DeviceObserver` interface, allowing it to receive updates and react accordingly (e.g., the Thermostat checking its temperature).

* **Command Pattern (Implicit):** `Schedule` and `Trigger` objects encapsulate a request (e.g., "turn on device 1") and its context (time or condition). The `SmartHomeHub` stores and manages these command objects, decoupling the request from the immediate execution logic.

### SOLID Principles

* **Single Responsibility Principle:** Each class has one clear responsibility. The `SmartHomeHub` manages devices, `DeviceFactory` creates devices, and individual device classes handle their own state.

* **Open/Closed Principle:** The system is open for extension but closed for modification. New device types can be added by creating new classes that extend `Device` without altering existing code.

* **Liskov Substitution Principle:** All device types can be substituted for the base `Device` class without breaking functionality.

* **Interface Segregation Principle:** Interfaces are kept focused and specific (e.g., `DeviceObserver` only contains update methods).

* **Dependency Inversion Principle:** High-level modules (like `SmartHomeHub`) depend on abstractions (`Device` interface) rather than concrete implementations.

## Classes and Their Responsibilities

* **`Device.java`:** Abstract base class defining common properties and methods for all devices; implements the `DeviceObserver` interface.

* **`Light.java`:** Concrete implementation of `Device` for light devices with on/off functionality.

* **`Thermostat.java`:** Concrete implementation of `Device` for thermostat devices with temperature control.

* **`DoorLock.java`:** Concrete implementation of `Device` for door lock devices with lock/unlock functionality.

* **`DeviceFactory.java`:** Factory class for creating various device instances based on type string input.

* **`DeviceProxy.java`:** Proxy class that wraps around real devices to control access and add cross-cutting concerns.

* **`DeviceObserver.java`:** The observer interface for device status updates and system notifications.

* **`SmartHomeHub.java`:** The central hub for managing all devices, schedules, triggers, and groups.

* **`Schedule.java`:** Represents scheduling information for a device command with time-based execution.

* **`Trigger.java`:** Represents a trigger that automates a device action based on specific conditions.

* **`DeviceGroup.java`:** Represents a collection of devices that can be controlled together as a unit.

* **`Main.java`:** The entry point of the application for handling all user interaction and menu navigation.

## Getting Started

### Prerequisites
* Java Development Kit (JDK) 17 or higher.

### Compile and Run
Open a terminal in the project directory (`EXERCISE_2/Smart Home System/`) and execute the following commands:

```bash
// Compile all .java files
javac */*.java *.java

// Run the application
java Main
```

## Usage Guide

The application provides an interactive menu-driven interface. Below are the main menu options:

#### 1) Add Device
Add a new smart device to the system by specifying its type (Light, DoorLock, Thermostat) and unique ID.

#### 2) Remove Device
Remove an existing device from the system using its device ID.

#### 3) Turn Device On/Off
Control individual devices by turning them on or off using their device ID.

#### 4) Schedule Device Command
Schedule a device to turn on or off at a specific time.

#### 5) Create Trigger
Set up automation rules that trigger device actions based on conditions.

#### 6) Create Device Group
Group multiple devices together for simultaneous control.

#### 7) Control Device Group
Turn all devices in a group on or off with a single command.

#### 8) View Device Status
Display the current status of all connected devices.

#### 9) View System Logs
Show a comprehensive log of all system activities and commands executed.

#### 10) Exit
Exit the application.

## Tech Stack

* **Programming Language:** Java 17
* **Design Approach:** Object-Oriented Programming with Design Patterns
* **Build Tool:** Java Compiler (javac)
* **Version Control:** Git

## Compilation Commands for Other Patterns

### Behavioral Patterns
```bash
// Observer Pattern
javac ObserverPattern.java
java ObserverPattern

// Strategy Pattern
javac StrategyPattern.java
java StrategyPattern
```

### Creational Patterns
```bash
// Singleton Pattern
javac SingletonPattern.java
java SingletonPattern

// Factory Pattern
javac FactoryPattern.java
java FactoryPattern
```

### Structural Patterns
```bash
// Adapter Pattern
javac AdapterPattern.java
java AdapterPattern

// Decorator Pattern
javac DecoratorPattern.java
java DecoratorPattern
```

## Contact

**Email:** durgeshkrishna615@gmail.com

**GitHub:** [durgeshKrishna](https://github.com/durgeshKrishna)

For any questions or suggestions, feel free to reach out!
>>>>>>> a0ce823 (Readme file updated)

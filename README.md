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

The pattern is used to ensure that the DatabaseConnection class can only be instantiated once. The static getInstance() method provides the single, shared instance to any part of the application that needs it.

Classes

DatabaseConnection: The Singleton class with a private constructor and a static getInstance() method that returns the sole instance of the class. It uses double-checked locking for thread safety.

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

ForeignCarAdapter: The adapter that makes ForeignCar compatible with the Car interface.

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

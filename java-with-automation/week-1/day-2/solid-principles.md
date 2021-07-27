# SOLID Principles

- S: Single Responsibility Principle
    - "A class should have one and only one reason to change, meaning that a class should have only one job"

```java
public class Book {
    private String bookName;
    private String author;
    private String text;

    public boolean findByAuthor(String authName) {
        return author.contains(authName);
    }

    public boolean findByName(String bookName) {
        return bookName.contains(bookName);
    }

    // Printing it on Console
    void printTextToConsole() {
        // Breaking SRP
    }
}

class BookPrinter {
    void printTextToConsole(String text) {

    }

    // Share text to other medium like Logger, Email
    void shareTextToOtherMedium(String text) {

    }
}
```

- O: Open-closed Principle
    - "You should be able to extend the classes behavior, without modifying it"
```java
public class Operation {
    public double calculate(double a1, double a2, String operationType) {
        switch(operationType) {
            case "+": {
                return a1 + a2;
            }
            case "-": {
                return a1 - a2;
            }
            default:
        }

        return 0;
    }
}
```

```java
public interface Operation {
    public double calculate(double a1, double a2);
}

class AddOperation implements Operation {

    @Override
    public double calculate(double a1, double a2) {
        return a1 + a2;
    }

}

class DivisionOperation implements Operation {

    @Override
    public double calculate(double a1, double a2) {
        return a1/a2;
    }

}
```

- L: Liskov Substitution Principle
    - "Derived classes must be substitutable for their base classes"
    - If S is a subtype of T, then objects of type T may be replaced (or substituted) with objects of type S
```java
public class Vehicle {

    public void startEngine() {
    }

}

class Car extends Vehicle {
    @Override
    public void startEngine() {
    }
}

class Bicycle extends Vehicle {
    @Override
    public void startEngine() {
        throw new EngineNotFoundException("Engine missing");
    }
}

class VehicleMonitor {
    public void startVehicles() {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        Vehicle car = new Car();
        Vehicle bike = new Bicycle();

        vehicles.add(car);
        vehicles.add(bike);

        vehicles.forEach(vehicle -> vehicle.startEngine());
    }
}

// VehicleWithoutEngine -> Bicycle
// VehicleWithEngine -> Car
```

- I: Interface Segregation Principle
    - "Make fine grained interfaces that are client specific"
```java
public interface Shape {

    double calculateArea();
    double calculateVolume();

}

class Cuboid implements Shape {
    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public double calculateVolume() {
        return 0;
    }
}

class Square implements Shape {
    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public double calculateVolume() {
        return 0;
    }
}

// Segregate into TwoDimShape
// Segregate into ThreeDimShape
```

- D: Dependency Inversion Principle
    - High-level modules should not depend on low-level modules. Both should depend on abstractions
    - Abstractions should not depend on details. Details should depend on abstractions
```java
public class Desktop {

    private Monitor monitor;
    private Keyboard keyboard;

    public Desktop(Keyboard keyboard, Monitor monitor) {
        this.monitor = monitor;
        this.keyboard = keyboard;
    }
}

interface Keyboard {}

class Monitor {}
class QwertyKeyboard implements Keyboard {}
```

## Benefits of SOLID Principles
- Loose - Coupling
- Code Maintainability
- Dependency Management
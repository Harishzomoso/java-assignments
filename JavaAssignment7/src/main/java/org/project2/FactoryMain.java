package org.project2;

interface Cycle {
    void ride();
}

class Unicycle implements Cycle {
    public void ride() {
        System.out.println("Riding a Unicycle");
    }
}

class Bicycle implements Cycle {
    public void ride() {
        System.out.println("Riding a Bicycle");
    }
}

class Tricycle implements Cycle {
    public void ride() {
        System.out.println("Riding a Tricycle");
    }
}

interface CycleFactory {
    Cycle getCycle();
}

class UnicycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Tricycle();
    }
}

public class FactoryMain {
    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.ride();
    }

    public static void main(String[] args) {
        rideCycle(new UnicycleFactory());
        rideCycle(new BicycleFactory());
        rideCycle(new TricycleFactory());
    }
}

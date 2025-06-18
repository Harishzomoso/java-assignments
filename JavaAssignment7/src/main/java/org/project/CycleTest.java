package org.project;

class Cycle {

}

class Unicycle extends Cycle {
    void balance() {
        System.out.println("Balancing Unicycle");
    }
}

class Bicycle extends Cycle {
    void balance() {
        System.out.println("Balancing Bicycle");
    }
}

class Tricycle extends Cycle {
    // No balance method
}

public class CycleTest {
    public static void main(String[] args) {
        Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};

        // Try calling balance() (this will not compile)
        // cycles[0].balance(); // Compile error!

        // Downcast to call balance
        if (cycles[0] instanceof Unicycle)
            ((Unicycle) cycles[0]).balance();

        if (cycles[1] instanceof Bicycle)
            ((Bicycle) cycles[1]).balance();

        if (cycles[2] instanceof Tricycle)
            System.out.println("Tricycle has no balance method");
    }
}

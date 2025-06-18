package org.project;

abstract class Rodent {
    Rodent() {
        System.out.println("Rodent created");
    }

    abstract void eat();
    abstract void run();
    abstract void sleep();
}

class Mouse extends Rodent {
    Mouse() {
        System.out.println("Mouse created");
    }

    void eat() {
        System.out.println("Mouse eats cheese");
    }

    void run() {
        System.out.println("Mouse runs quickly");
    }

    void sleep() {
        System.out.println("Mouse sleeps in hole");
    }
}

class Gerbil extends Rodent {
    Gerbil() {
        System.out.println("Gerbil created");
    }

    void eat() {
        System.out.println("Gerbil eats grains");
    }

    void run() {
        System.out.println("Gerbil runs on wheel");
    }

    void sleep() {
        System.out.println("Gerbil sleeps in nest");
    }
}

class Hamster extends Rodent {
    Hamster() {
        System.out.println("Hamster created");
    }

    void eat() {
        System.out.println("Hamster eats seeds");
    }

    void run() {
        System.out.println("Hamster runs in tunnel");
    }

    void sleep() {
        System.out.println("Hamster sleeps in burrow");
    }
}

public class RodentMain {
    public static void main(String[] args) {
        Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster()};
        for (Rodent r : rodents) {
            r.eat();
            r.run();
            r.sleep();
            System.out.println();
        }
    }
}


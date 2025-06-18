package org.project2;

class Outer1 {
    class Inner {
        Inner(String msg) {
            System.out.println("Outer1.Inner Constructor: " + msg);
        }
    }
}

class Outer2 {
    class SubInner extends Outer1.Inner {
        SubInner(Outer1 outer, String msg) {
            outer.super(msg); // Must use outer.super when extending inner class
            System.out.println("Outer2.SubInner Constructor");
        }
    }
}

public class InnerClassTest {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        Outer2 outer2 = new Outer2();
        Outer2.SubInner subInner = outer2.new SubInner(outer1, "Hello from Inner");
    }
}


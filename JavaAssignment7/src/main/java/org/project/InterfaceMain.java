package org.project;

interface A {
    void a1();
    void a2();
}

interface B {
    void b1();
    void b2();
}

interface C {
    void c1();
    void c2();
}

interface Combined extends A, B, C {
    void combinedMethod();
}

class ConcreteClass {
    void baseMethod() {
        System.out.println("Method from ConcreteClass");
    }
}

class Implementor extends ConcreteClass implements Combined {
    public void a1() { System.out.println("a1 implemented"); }
    public void a2() { System.out.println("a2 implemented"); }
    public void b1() { System.out.println("b1 implemented"); }
    public void b2() { System.out.println("b2 implemented"); }
    public void c1() { System.out.println("c1 implemented"); }
    public void c2() { System.out.println("c2 implemented"); }
    public void combinedMethod() { System.out.println("combinedMethod implemented"); }
}

public class InterfaceMain {
    static void takeA(A a) {
        a.a1(); a.a2();
    }
    static void takeB(B b) { b.b1(); b.b2(); }
    static void takeC(C c) { c.c1(); c.c2(); }
    static void takeCombined(Combined c) { c.combinedMethod(); }

    public static void main(String[] args) {
        Implementor obj = new Implementor();
        takeA(obj);
        takeB(obj);
        takeC(obj);
        takeCombined(obj);
        obj.baseMethod();
    }
}

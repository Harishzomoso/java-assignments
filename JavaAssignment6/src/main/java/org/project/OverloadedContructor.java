package org.project;

class OverloadedConstructor {
    int a;
    String b;

    public OverloadedConstructor() {
        this(42, "Hello");
        System.out.println("Default constructor called");
    }

    public OverloadedConstructor(int a, String b) {
        this.a = a;
        this.b = b;
        System.out.println("Parameterized constructor: a = " + a + ", b = " + b);
    }
}
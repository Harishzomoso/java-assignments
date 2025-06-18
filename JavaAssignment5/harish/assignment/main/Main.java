package JavaAssignment5.harish.assignment.main;

import JavaAssignment5.harish.assignment.data.DataClass;
import JavaAssignment5.harish.assignment.singleton.SingletonClass;

public class Main {
    public static void main(String[] args) {

        DataClass data = new DataClass();
        data.printInstanceVariables();
        data.printLocalVariables();

        SingletonClass singleton = SingletonClass.createInstance("Hello, Singleton!");
        singleton.printString();
    }
}
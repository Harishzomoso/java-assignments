package org.project;

public class ConstructorMessage {
    public ConstructorMessage(String msg) {
        System.out.println("Constructor called with message: " + msg);
    }

    public static void main(String[] args) {
        ConstructorMessage[] refs = new ConstructorMessage[5];
        // No constructor calls here since objects are not created

        for (int i = 0; i < refs.length; i++) {
            refs[i] = new ConstructorMessage("Object " + i);
        }
    }
}
package JavaAssignment5.harish.assignment.data;

public class DataClass {
    int intVar;         // default value: 0
    char charVar;       // default value: '\u0000'

    public void printInstanceVariables() {
        System.out.println(" intVar: " + intVar);
        System.out.println(" charVar: [" + charVar + "]");  // char may appear empty due to null char
    }

    public void printLocalVariables() {
        // Local variables must be initialized before use.
        // The below lines would cause a compile-time error in Java.

        /*
        int localInt;
        char localChar;
        System.out.println("localInt: " + localInt); // Error: variable localInt might not have been initialized
        System.out.println("localChar: " + localChar); // Error: variable localChar might not have been initialized
        */

        System.out.println("Cannot print local variables without initialization in Java.");
    }
}
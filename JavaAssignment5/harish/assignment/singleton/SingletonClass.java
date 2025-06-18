package JavaAssignment5.harish.assignment.singleton;

public class SingletonClass {
    private String str;

    private SingletonClass(String str) {
        this.str = str;
    }

    public static SingletonClass createInstance(String input) {
        return new SingletonClass(input);
    }

    public void printString() {
        System.out.println("str: " + str);
    }
    //This class will not have compile time error
}

package JavaAssignment8;

// Three custom checked exceptions
class CustomExceptionOne extends Exception {
    public CustomExceptionOne(String message) {
        super(message);
    }
}

class CustomExceptionTwo extends Exception {
    public CustomExceptionTwo(String message) {
        super(message);
    }
}

class CustomExceptionThree extends Exception {
    public CustomExceptionThree(String message) {
        super(message);
    }
}

public class ErrorHandlingExample {

    // Method that throws all three custom exceptions or a NullPointerException
    public static void throwExceptions(int choice) throws CustomExceptionOne, CustomExceptionTwo, CustomExceptionThree {
        switch (choice) {
            case 1:
                throw new CustomExceptionOne("Custom Exception One occurred.");
            case 2:
                throw new CustomExceptionTwo("Custom Exception Two occurred.");
            case 3:
                throw new CustomExceptionThree("Custom Exception Three occurred.");
            case 4:
                String str = null;
                System.out.println(str.length()); // This throws NullPointerException
                break;
            default:
                System.out.println("No exception thrown.");
        }
    }

    public static void main(String[] args) {
        try {
            // Change the number to 1-4 to test different exceptions
            throwExceptions(4);
        } catch (Exception e) {
            // Single catch clause for all exceptions, including NullPointerException
            System.out.println("Caught exception: " + e);
        } finally {
            // This block always executes
            System.out.println("Finally block executed.");
        }
    }
}


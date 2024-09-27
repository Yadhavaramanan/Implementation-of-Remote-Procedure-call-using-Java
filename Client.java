package exp66;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Locate the RMI registry
            Registry registry = LocateRegistry.getRegistry("localhost", 200);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            // Create a Scanner object to take input from the user
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Perform operations
            System.out.println("Addition Result: " + calculator.add(num1, num2));
            System.out.println("Subtraction Result: " + calculator.subtract(num1, num2));
            System.out.println("Multiplication Result: " + calculator.multiply(num1, num2));

            try {
                System.out.println("Division Result: " + calculator.divide(num1, num2));
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
            

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

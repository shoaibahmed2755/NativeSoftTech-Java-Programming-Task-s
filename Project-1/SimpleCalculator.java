import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Print the welcome message and instructions
        System.out.println("Simple Calculator");
        System.out.println("Select operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        
        try {
            // Get the user's choice for operation
            System.out.print("Enter operation number (1/2/3/4): ");
            int operation = scanner.nextInt();
            
            // Get two numbers from the user
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            // Perform the operation based on the user's choice
            double result = 0;
            switch (operation) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    // Check for division by zero
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Invalid operation choice.");
                    return;
            }
            
            // Display the result
            System.out.println("The result is: " + result);
            
        } catch (Exception e) {
            // Handle invalid inputs (non-numeric)
            System.out.println("Invalid input! Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}
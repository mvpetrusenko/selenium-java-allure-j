package tests.UI.tests;

import java.util.Scanner;

public class SimpleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter some text:"); // Prompt the user for input

        String input = scanner.nextLine(); // Read the user input as a string
        System.out.println("You entered: " + input); // Print the user input

        scanner.close(); // Close the scanner
    }
}

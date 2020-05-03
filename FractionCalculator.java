import java.util.*;

public class FractionCalculator
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        boolean done = false;
        String operation;
        String response;
        Fraction first;
        Fraction second;

        // Introduction
        System.out.println("Welcome to Fraction Calculator!");
        System.out.println("Fraction Calculator can add, subtract, multiply, and divide fractions.");
        System.out.println("Press Q if you want to quit out of Fraction Calculator.");
        System.out.println("Please enter fractions in the format a/b where a and b are both integers.");
        System.out.println("-------------------------------------------------------------------------");

        // Operations
        while(!done)
        {
            // Prompt operation
            System.out.print("Please enter an operation (+, -, *, /, = or Q to Quit): ");
            operation = kb.next();

            switch (operation)
            {
                case "+":
                    System.out.print("Please enter a fraction (a/b) or integer (a): ");
                    response = kb.next();
                    if (response.length() == 3)
                    {
                        first = new Fraction(Character.getNumericValue(response.charAt(0)), Character.getNumericValue(response.charAt(2)));
                    }
                    else
                    {
                        first = new Fraction(Character.getNumericValue(response.charAt(0)));
                    }
                    System.out.print("Please enter a fraction (a/b) or integer (a): ");
                    response = kb.next();
                    if (response.length() == 3)
                    {
                        second = new Fraction(Character.getNumericValue(response.charAt(0)), Character.getNumericValue(response.charAt(2)));
                    }
                    else
                    {
                        second = new Fraction(Character.getNumericValue(response.charAt(0)));
                    }
                    System.out.println(first + " + " + second + " is " + first.add(second));
                    break;
                case "-":
                    System.out.print("Please enter a fraction (a/b) or integer (a): ");
                    response = kb.next();
                    if (response.length() == 3)
                    {
                        first = new Fraction(Character.getNumericValue(response.charAt(0)), Character.getNumericValue(response.charAt(2)));
                    }
                    else
                    {
                        first = new Fraction(Character.getNumericValue(response.charAt(0)));
                    }
                    System.out.print("Please enter a fraction (a/b) or integer (a): ");
                    response = kb.next();
                    if (response.length() == 3)
                    {
                        second = new Fraction(Character.getNumericValue(response.charAt(0)), Character.getNumericValue(response.charAt(2)));
                    }
                    else
                    {
                        second = new Fraction(Character.getNumericValue(response.charAt(0)));
                    }
                    System.out.println(first + " - " + second + " is " + first.subtract(second));
                    break;
                case "*":
                case "/":
                case "=":
                case "Q":
                    done = true;
                    break;
            }
        }
    }
}
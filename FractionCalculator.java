import java.util.*;

public class FractionCalculator
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        boolean done = false;
        String operation;
        Fraction one = new Fraction(1);
        Fraction two = new Fraction(1);
        Fraction result;

        // Introduction
        System.out.println("Welcome to Fraction Calculator!");
        System.out.println("Fraction Calculator can add, subtract, multiply, and divide fractions.");
        System.out.println("Press Q if you want to quit out of Fraction Calculator.");
        System.out.println("Please enter fractions in the format a/b where a and b are both integers.");
        System.out.println("-------------------------------------------------------------------------");

        // Operations
        while(!done)
        {
            // get operation
            operation = getOperation(kb);
            // if the user did not quit
            if (!operation.equals("q") && !operation.equals("Q"))
            {
                // get both fractions
                one = getFraction(kb);
                two = getFraction(kb);
                // switch based on input
                switch (operation)
                {
                    // add fractions
                    case "+":
                        result = one.add(two);
                        System.out.println(one + " + " + two + " is " + result);
                        break;
                    // subtract fractions
                    case "-":
                        result = one.subtract(two);
                        System.out.println(one + " - " + two + " is " + result);
                        break;
                    // multiply fractions
                    case "*":
                        result = one.multiply(two);
                        System.out.println(one + " * " + two + " is " + result);
                        break;
                    // divide fractions
                    case "/":
                        result = one.divide(two);
                        System.out.println(one + " / " + two + " is " + result);
                        break;
                    // compare fractions
                    case "=":
                        if (one.equals(two))
                        {
                            System.out.println(one + " = " + two + " is true");
                        }
                        else
                        {
                            System.out.println(one + " = " + two + " is not true");
                        }
                        break;
                }
            }
            // if the user quits
            else
            {
                System.out.println("Goodbye!");
                done = true;
            }
        }
    }

    public static String getOperation(Scanner kb)
    {
        // String of operations
        String operation = "-+/*=qQ";
        // Prompt user
        System.out.print("Please enter an operation (+, -, *, /, = or Q to Quit): ");
        String input = kb.next();
        // If the user correctly put in an operation
        if (input.length() == 1 && operation.indexOf(input.substring(0,1)) >= 0)
        {
            return input;
        }
        // if not, invalid operation
        else
        {
            System.out.println("Invalid operation...");
            return getOperation(kb);
        }
    }

    public static boolean validFraction(String input)
    {
        // checks to see if denominator is negative
        if ((input.indexOf("-") > input.indexOf("/")))
        {
            return false;
        }
        // if the user inputs a double
        if (input.indexOf(".") != -1)
        {
            return false;
        }
        // check for a negative and letters
        for (int i = 0, n = input.length(); i < n; i++)
        {
            if (Character.isLetter(input.charAt(i)))
            {
                return false;
            }
            if (i > 0 && input.charAt(i) == '-')
            {
                return false;
            }
        }
        return true;
    }

    public static Fraction getFraction(Scanner kb)
    {
        int numerator;
        int denominator;
        String response;

        // prompts for fraction
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        response = kb.next();

        // if the fraction is valid
        if (validFraction(response))
        {
            // if it's a fraction and not a whole number
            if (response.indexOf("/") != -1)
            {
                int location = response.indexOf("/");
                numerator = Integer.parseInt(response.substring(0, location));
                denominator = Integer.parseInt(response.substring(location + 1, response.length()));
                return new Fraction(numerator, denominator);
            }
            // if it's a whole number
            else
            {
                numerator = Integer.parseInt(response.substring(0));
                return new Fraction(numerator);
            }
        }
        // if the fraction is not valid
        else
        {
            System.out.println("Invalid Fraction...");
            return getFraction(kb);
        }
    }
}
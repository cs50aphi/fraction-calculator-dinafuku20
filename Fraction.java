public class Fraction
{
    // Instance variables
    int num;
    int denom;

    //Methods

    // Takes in input for numerator and denominator
    public Fraction(int numerator, int denominator)
    {
        try
        {
            int quotient = numerator / denominator;
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Denominator can't be zero...");
            return;
        }

        if (denominator < 0 && numerator > 0)
        {
            numerator = -numerator;
            denominator = Math.abs(denominator);
        }
        else if (denominator < 0 && numerator < 0)
        {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }

        num = numerator;
        denom = denominator;
    }
    // Takes in one input only for numerator
    public Fraction(int num)
    {
        this.num = num;
        denom = 1;
    }
    // Takes in no input
    public Fraction()
    {
        num = 0;
        denom = 1;
    }
    // reutnr numerator
    public int getNumerator()
    {
        return num;
    }
    // return denominator
    public int getDenominator()
    {
        return denom;
    }
    // overrides toString method when printing a fraction
    public String toString()
    {
        if (denom == 1)
        {
            return Integer.toString(num);
        }
        return num+"/"+denom;
    }
    // converts fraciton to double
    public Double toDouble()
    {
        return (double)(num / denom);
    }
    // adds fraction by multiplying num by the other fractions denom, then multiply the denom together to get LCD
    public Fraction add(Fraction other)
    {
        int newNum = num*other.getDenominator() + denom*other.getNumerator();
        int newDenom = other.getDenominator() * denom;
        Fraction result = new Fraction(newNum,newDenom);
        result.toLowestTerms();
        return result;
    }
    // subtracts fraction by multiplying num by the other fractions denom, then multiply the denom together to get LCD
    public Fraction subtract(Fraction other)
    {
        int newNum = num*other.getDenominator() - denom*other.getNumerator();
        int newDenom = other.getDenominator() * denom;
        Fraction result = new Fraction(newNum,newDenom);
        result.toLowestTerms();
        return result;
    }
    // multiplies fractions by multiplying numerators and denominators
    public Fraction multiply(Fraction other)
    {
        int newNum = num*other.getNumerator();
        int newDenom = denom*other.getDenominator();
        Fraction result = new Fraction(newNum,newDenom);
        result.toLowestTerms();
        return result;
    }
    // divides fractions by multiplying num by denom and vise versa
    public Fraction divide(Fraction other)
    {
        try
        {
            int newNum = num*other.getDenominator();
            int newDenom = denom*other.getNumerator();
            Fraction result = new Fraction(newNum,newDenom);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Can't divide by zero...");
        }
        int newNum = num*other.getDenominator();
        int newDenom = denom*other.getNumerator();
        Fraction result = new Fraction(newNum,newDenom);
        result.toLowestTerms();
        return result;
    }

    public boolean equals(Object other)
    {
        // cast object other to a fraction
        Fraction a = (Fraction)other;
        // make numerators and denominators doubles
        double first = (double)(num);
        double second = (double)(denom);
        double otherOne = (double)(a.getNumerator());
        double otherTwo = (double)(a.getDenominator());
        // if the decimal value of the fractions are the same, return true, else false
        if ((first / second) == (otherOne / otherTwo))
        {
            return true;
        }
        return false;
    }
    // converts to lowest terms
    public void toLowestTerms()
    {
        int number = gcd(num, denom);
        num = num / number;
        denom = denom / number;
    }
    // gets the gcd
    public static int gcd(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        return gcd(b, a%b);
    }
}
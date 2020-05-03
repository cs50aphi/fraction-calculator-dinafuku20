public class Fraction
{
    // Instance variables
    int num;
    int denom;

    //Methods

    // Takes in input for numerator and denominator
    public Fraction(int num, int denom)
    {
        try
        {
            int quotient = num / denom;
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Denominator can't be zero...");
            return;
        }

        if (denom < 0 && num > 0)
        {
            this.num = -num;
            this.denom = Math.abs(denom);
        }
        else if (denom < 0 && num < 0)
        {
            this.num = Math.abs(num);
            this.denom = Math.abs(denom);
        }
        else
        {
            this.num = num;
            this.denom = denom;
        }
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
        Fraction result = new Fraction(num,denom);
        result.toLowestTerms();
        return result;
    }
    // subtracts fraction by multiplying num by the other fractions denom, then multiply the denom together to get LCD
    public Fraction subtract(Fraction other)
    {
        int newNumum = num*other.getDenominator() - denom*other.getNumerator();
        int newDenom = other.getDenominator() * denom;
        Fraction result = new Fraction(num, denom);
        result.toLowestTerms();
        return result;
    }
    // multiplies fractions by multiplying numerators and denominators
    public Fraction multiply(Fraction other)
    {
        int newNum = num*other.getNumerator();
        int newDenom = denom*other.getDenominator();
        Fraction result = new Fraction(num, denom);
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
            Fraction result = new Fraction(num,denom);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Can't divide by zero...");
        }
        int newNum = num*other.getDenominator();
        int newDenom = denom*other.getNumerator();
        Fraction result = new Fraction(num,denom);
        result.toLowestTerms();
        return result;
    }

    public boolean equals(Object other)
    {
        // cast object other to a fraction
        Fraction a = (Fraction)other;
        if (toDouble() == (double)(a.getNumerator() / a.getDenominator()))
        {
            return true;
        }
        return false;
    }
    // converts to lowest terms
    public void toLowestTerms()
    {
        num = num / gcd(num,denom);
        denom = denom / gcd(num,denom);
    }
    // gets the gcd
    public static int gcd(int a, int b)
    {
        int remainder;
        while (a != 0 && b != 0)
        {
            remainder = a & b;
            a = b;
            b = remainder;
        }
        return a;
    }
}
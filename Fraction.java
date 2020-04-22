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

    public int getNumerator()
    {
        return num;
    }

    public int getDenominator()
    {
        return denom;
    }

    public String toString()
    {
        if (denom == 1)
        {
            return Integer.toString(num);
        }
        return num+"/"+denom;
    }

    public Double toDouble()
    {
        return (double)(num / denom);
    }

    public Fraction add(Fraction other)
    {

        int result = (num + other.getNumerator())/(other.getDenominator() * denom);
        return (Fraction)(result);
    }

    public Fraction subtract(Fraction other)
    {
        int result = (num - other.getNumerator())/(other.getDenominator() * denom);
        return (Fraction)(result);
    }

    public Fraction multiply(Fraction other)
    {
        int result = (num*other.getNumerator())/(denom*other.getDenominator());
        return (Fraction)(result);
    }

    public Fraction divide(Fraction other)
    {
        try
        {
           Fraction quotient = (num*other.getDenominator())/(denom*other.getNumerator());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Can't divide by zero...");
        }
        return (Fraction)((num*other.getDenominator())/(denom*other.getNumerator()));
    }

    public boolean equals(Object other)
    {
        Fraction a = (Fraction)other;
        if ((double)(num / denom) == (double)(a.getNumerator() / a.getDenominator()))
        {
            return true;
        }
        return false;
    }

    public void toLowestTerms()
    {
        num = num / gcd(num,denom);
        denom = denom / gcd(num,denom);
    }

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
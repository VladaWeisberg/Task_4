package Project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int n = readInt("number of members of a series");

        while (n <= 0)
        {
            n = readInt("another number n");
        }

        double x = readDouble("x");

        double sum = findSumSeriesWithRoot(n, x);
        double multi = findMultiplicationSeriesWithSin(n, x);

        System.out.printf("The sum of the first series is %1f\n" +
                          "The multiplication of the second series is %2f\n", sum, multi);
    }


    private static double findSumSeriesWithRoot(int n, double x)
    {
        double sum = 0;
        double roots = findSquareRootX(x) * n;

        for (int i = 1; i <= n; i++)
        {
            double fact = findInverseFactorial(i);

            sum = sum + fact;
        }

        return sum + roots;
    }

    private static double findMultiplicationSeriesWithSin(int n, double x)
    {
        double multi = 1;

        for (int i = 1; i <= n; i++)
        {
            double sin = findSin(i, x);
            double fact = findInverseFactorial(i);

            multi = multi * (1 + sin * fact);
        }

        return  multi;
    }

    private static double findInverseFactorial(int n)
    {
        int fact = 1;

        for(int i = 1; i <= n; i++)
        {
            fact = fact * i;
        }

        return 1.0 / fact;
    }

    private static double findSquareRootX(double x)
    {
        return Math.sqrt(Math.abs(x));
    }

    private static double findSin(int n, double x)
    {
        return Math.sin(n * x);
    }

    private static int readInt(String name)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s ", name);
        return scanner.nextInt();
    }

    private static double readDouble(String name)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s ", name);
        return scanner.nextDouble();
    }

}

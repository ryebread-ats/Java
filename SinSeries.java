//TO-DO: format document to class coding standards

import java.util.Scanner;

/**
 *
 * @author Ryan
 */
public class SinSeries 
{
    //recursive function to handle factorial calculations

    /**
     *
     * @param factorial
     * @return
     */
    public int calculateFactorial(int factorial) 
    {
        if (factorial == 1)
        {
            return 1;
        }
        return factorial * calculateFactorial(factorial - 1);
    }
    
    //recursive function calculating the value of sin

    /**
     *
     * @param radian
     * @param calculationCounter
     * @param result
     * @return
     */
    public double calculateSin(double radian, int calculationCounter, double result) 
    {
        //iterations of the formula, must be > 1 (higher = more precise)
        int precision = 6; 
        //check to end recursion
        if (calculationCounter == precision)
        {
            return 0;
        }
        //applies Maclaurins theorem for the formula
        result = ((Math.pow(-1, calculationCounter) * Math.pow(radian, (2 * calculationCounter + 1))) / ((calculateFactorial(2 * calculationCounter + 1))));
        //increment counter to keep track of iterations
        calculationCounter++;
        
        return result + calculateSin(radian, calculationCounter, result);
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) 
    {
        //instance creation
        SinSeries self = new SinSeries();
        Scanner input  = new Scanner(System.in);
        
        //prompt user for input and store
        System.out.print("-sin calculation-\nEnter a degree of angle: ");
        double degree = input.nextFloat();
        
        //convert user input to radians, calculate result using sin as a series
        double radian = degree * Math.PI / 180;
        double result = self.calculateSin(radian, 0, radian);
        
        //print results
        System.out.printf("radian: %.3f\n", radian);
        System.out.printf("result: %.3f", result);
    }
}


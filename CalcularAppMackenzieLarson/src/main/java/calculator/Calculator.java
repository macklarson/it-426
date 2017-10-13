/*
 * Mackenzie Larson
 * 10/6/2017
 * Calculator App Part 2
 * Calculator.java
 */

package calculator;

/**
 * @author Mackenzie Larson
 * @version 1.0
 * Calculator.java
 *
 * The logic for operating the calculator
 */
public class Calculator
{
    private int firstNumber;
    private int nextNumber;
    private String operator;
    private int solution;

    /**
     * Stores the first number in the equation
     * @param firstNumber first number typed into calculator
     */
    public void storeFirstNumber(int firstNumber)
    {
        this.firstNumber = firstNumber;
    }

    /**
     * Stores the operator of the equation
     * @param operator +, -, *, /
     */
    public void storeOperator(String operator)
    {
        this.operator = operator;
    }

    /**
     * Stores the number after the operator has been pressed
     * @param nextNumber
     */
    public void storeNextNumber(int nextNumber)
    {
        this.nextNumber = nextNumber;
    }

    /**
     * Solves the math problem
     * @return solution of the equation
     */
    public int math()
    {
        if (operator.equals("+"))
        {
            solution = firstNumber + nextNumber;
        }
        else if (operator.equals("-"))
        {
            solution = firstNumber - nextNumber;
        }
        else if (operator.equals("*"))
        {
            solution = firstNumber * nextNumber;
        }
        else if (operator.equals("/"))
        {
            solution = firstNumber / nextNumber;
        }

        return solution;
    }
}

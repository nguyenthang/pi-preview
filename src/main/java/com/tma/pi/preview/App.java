package com.tma.pi.preview;

import java.util.Scanner;

import com.tma.pi.preview.formula.strategy.FormulaStategyImpl;
import com.tma.pi.preview.formula.strategy.IFormulaStrategy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	IFormulaStrategy formulaStrategy = new FormulaStategyImpl();
    	Scanner scanner = new Scanner(System.in);
        System.out.print( "Enter the limit no!");
        
        long size = scanner.nextLong();
        
        long startTime = System.currentTimeMillis();
        
        System.out.println(formulaStrategy.calculate(0, 1000000000));
        
        System.out.print("En" + (System.currentTimeMillis() - startTime));
    }
}

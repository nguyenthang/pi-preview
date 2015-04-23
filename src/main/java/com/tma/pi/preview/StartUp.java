package com.tma.pi.preview;

import java.util.concurrent.ExecutionException;

import com.tma.pi.preview.execution.FactoryManager;
import com.tma.pi.preview.formula.FormulaService;
import com.tma.pi.preview.formula.IFormulaStrategy;
import com.tma.pi.preview.io.ConsoleManager;
import com.tma.pi.preview.io.IConsoleIO;

public class StartUp 
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {    	
        IConsoleIO consoleIO = ConsoleManager.getConsoleInstance();
        IFormulaStrategy formulaStrategy = FormulaService.getFormulaStrategy();
        
        FactoryManager thManager = new FactoryManager(consoleIO.getInputNumber(),formulaStrategy);
        
        long startTime = System.currentTimeMillis();
        thManager.countPiNumber();        
        System.out.print("Result" + thManager.prinfResult());
        
        System.out.print("Count time: " + (System.currentTimeMillis() - startTime));
    }
}

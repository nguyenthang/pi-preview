package com.tma.pi.preview.service;

import java.util.concurrent.Callable;

import com.tma.pi.preview.formula.strategy.FormulaStategyImpl;
import com.tma.pi.preview.formula.strategy.IFormulaStrategy;

public class FormulaService implements Callable<Double> {
	
	private IFormulaStrategy formulaStrategy;
	
	private int startNo;
	
	private int endNo;
	
	public FormulaService(int startNo, int endNo){
		this.startNo = startNo;
		this.endNo = endNo;
	}
	
	public static IFormulaStrategy getFormulaService(){	
		return new FormulaStategyImpl();
		
	}

	public Double call() throws Exception {
		return formulaStrategy.calculate(startNo, endNo);
	}

}

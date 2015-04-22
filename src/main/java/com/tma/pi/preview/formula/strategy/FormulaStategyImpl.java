package com.tma.pi.preview.formula.strategy;


public class FormulaStategyImpl implements IFormulaStrategy{

	public FormulaStategyImpl(){}
	
	public double calculate(int startNo, int endNo) {
		
		double pi = 0;
	      double denominator = 1;
	  
	      for (int x = startNo; x <= endNo; x++) {
	  
	         if (x % 2 == 0) {
	            pi = pi + (1 / denominator);
	         } else {
	            pi = pi - (1 / denominator);
	         }
	         denominator = denominator + 2;
	      }
	      
	      pi = pi * 4;
		
		return pi;
	}

}

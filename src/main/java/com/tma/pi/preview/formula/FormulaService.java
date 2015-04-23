package com.tma.pi.preview.formula;

public class FormulaService {

	private static IFormulaStrategy INSTANCE = new FormulaStategyImpl();
	
	public static IFormulaStrategy getFormulaStrategy(){
		return INSTANCE;
	}
	
}

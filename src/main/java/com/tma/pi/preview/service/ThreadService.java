package com.tma.pi.preview.service;

import java.util.concurrent.Callable;

import com.tma.pi.preview.formula.IFormulaStrategy;


/**
 * @author thangnguyen
 *
 */
public class ThreadService implements Callable<Double> {
	
	private IFormulaStrategy formulaStrategy;
	
	private long startNo;
	
	private long endNo;
	
	/**
	 * @param startNo
	 * @param endNo
	 * @param formulaStategy
	 */
	public ThreadService(long startNo, long endNo, IFormulaStrategy formulaStategy){
		this.startNo = startNo;
		this.endNo = endNo;
		this.formulaStrategy = formulaStategy;
	}
	
	public Double call() throws Exception {
		return formulaStrategy.calculate(startNo, endNo);
	}

	public IFormulaStrategy getFormulaStrategy() {
		return formulaStrategy;
	}

	public void setFormulaStrategy(IFormulaStrategy formulaStrategy) {
		this.formulaStrategy = formulaStrategy;
	}

	public long getStartNo() {
		return startNo;
	}

	public void setStartNo(long startNo) {
		this.startNo = startNo;
	}

	public long getEndNo() {
		return endNo;
	}

	public void setEndNo(long endNo) {
		this.endNo = endNo;
	}
	
	

}

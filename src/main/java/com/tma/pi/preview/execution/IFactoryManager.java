package com.tma.pi.preview.execution;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface IFactoryManager {

	public double countPiNumber() throws InterruptedException, ExecutionException;
	
	public long getTaskNumber(long n);
	
	public double SumofPi(List<Future<Double>> resultList) throws InterruptedException, ExecutionException;
	
	public double prinfResult() throws InterruptedException, ExecutionException;
}

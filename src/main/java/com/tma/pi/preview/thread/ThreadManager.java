package com.tma.pi.preview.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.tma.pi.preview.service.FormulaService;

public class ThreadManager {
	
	private static int nrThreads = Runtime.getRuntime().availableProcessors();
	
	ArrayList<Future<Double>> helperList = new ArrayList<Future<Double>>();
	
	public double countPiNumber(int startNo, int endNo) throws InterruptedException, ExecutionException{
		
		int count = 0;
		int startFrom = 0;
		
		int numberPerThreads = (endNo - startFrom)/ ThreadManager.nrThreads;
		
		ExecutorService eService = Executors.newFixedThreadPool(ThreadManager.nrThreads);
		Future<Double> countHelper = null;
		
		for(int i = 0 ; i < ThreadManager.nrThreads;i ++){
			countHelper =eService.submit(new FormulaService(startNo, endNo + nrThreads));
			startFrom += numberPerThreads + 1;
			helperList.add(countHelper);
		}
		
		eService.shutdown();
		
		count = (int)SumofPi(helperList);
		return count;
	}
	
	public double SumofPi(List<Future<Double>> resultList) throws InterruptedException, ExecutionException{
		int count = 0;
		for(Future<Double> helper : helperList){
			count += helper.get();
		}
		return count;
	}

}

package com.tma.pi.preview.execution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.tma.pi.preview.bean.Number;
import com.tma.pi.preview.formula.IFormulaStrategy;
import com.tma.pi.preview.service.ThreadService;

public class FactoryManager implements IFactoryManager {
	
	private int nrThreads = Runtime.getRuntime().availableProcessors();
	
	ArrayList<Future<Double>> helperList = new ArrayList<Future<Double>>();
	
	private IFormulaStrategy formulaStrategy;
	
	private int RANGE_PI_NO = 5000000;
	
	private long No;
	
	private boolean stopFlag = false;
	
	private List<Number> numbers;
	
	public FactoryManager(long n, IFormulaStrategy formulaStrategy){
		this.No = n;
		this.formulaStrategy = formulaStrategy;
	}
	
	public double countPiNumber() throws InterruptedException, ExecutionException{
		
		double count = 0;
		long startFrom = 0;
		
		long numberPerThreads =  getTaskNumber(No);
		
		ExecutorService eService = Executors.newFixedThreadPool(nrThreads);
		Future<Double> countHelper = null;
		
		for(int i = 0 ; i < numberPerThreads;i++){
			
			countHelper =eService.submit(new ThreadService(startFrom, (i != (numberPerThreads - 1) ? (startFrom += RANGE_PI_NO) : No), formulaStrategy));			
			startFrom += 1;
			helperList.add(countHelper);
			
		}
		
		count = (double)SumofPi(helperList);
		eService.shutdown();
		
		return count;
	}
	
	public void isStopped(){
		stopFlag = true;
	}
	
	public List<ThreadService> getCalcTasks(){
		List<ThreadService> threadServices = new ArrayList<ThreadService>();
		
		for(Number n : numbers){
			try{
				threadServices.add(new ThreadService(n.getStartNo(), n.getEndNo(), formulaStrategy));	
			}catch(NullPointerException e){
				System.out.println("there is no task to created.");
			}			
		}
		
		return threadServices;
	}
	
	public long getTaskNumber(long n){
		long noTask = 0;
		
		if(nrThreads != 0){
			if(No % RANGE_PI_NO == 0){
				noTask = No / RANGE_PI_NO;
			}else {
				noTask = (No / RANGE_PI_NO) + 1;
			}
		}
		
		return noTask;
	}
	
	public double SumofPi(List<Future<Double>> resultList) throws InterruptedException, ExecutionException{
		double piNumbers = 0;
		
		for(Future<Double> helper : helperList){
			piNumbers += helper.get();
		}
		
		return piNumbers;
	}

	public double prinfResult() throws InterruptedException, ExecutionException{
		return SumofPi(helperList);
	}
	
	
	public class CalculationStop extends Thread{
		
		public CalculationStop(){
			setDaemon(true);
		}
		
		@Override
		public void run(){
			Scanner scan = new Scanner(System.in);
			while (true) {
				try {
					scan.nextLine();
					scan.close();
					isStopped();
				} catch (Exception e) {

				}
			}
		}
	}
}

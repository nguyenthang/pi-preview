package com.tma.pi.preview.io;

import java.util.Scanner;

public class ConsoleIOImpl implements IConsoleIO{

	private Scanner scanner;
	
	private long lengthOfPi;
	
	public long getInputNumber() {
		String outputValue;
		scanner = new Scanner(System.in);
		outputValue = scanner.nextLine();		
		while(true){			
			try{
				lengthOfPi = convertLongNo(outputValue);
				return lengthOfPi;
			}catch(Exception e){
				continue;
			}
		}		
	}

	public long convertLongNo(String no) {
		long returnValue;
		
		try{
			if(no.length() > 10)
				returnValue = -2;			
			returnValue = Long.parseLong(no);
		}catch(Exception e){
			System.out.printf("Ozz! Your input number must be greater than %d and less than %d", -1, 10);
			returnValue = -1;
		}
		
		return returnValue;
	}

	public void displayResult(double result) {
		System.out.print("Expected PI Number is: " +  Math.PI + "\n");
		System.out.print("Calculating... please waiting...");
		System.out.print("Calculate Result PI Number is: " +  result + "\n");
	}

}

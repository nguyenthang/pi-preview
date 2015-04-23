package com.tma.pi.preview.io;

public class ConsoleManager {

	private static IConsoleIO INSTANCE = new ConsoleIOImpl();
	
	public static IConsoleIO getConsoleInstance(){
		
		if(INSTANCE == null){
			return new ConsoleIOImpl();
		}
		
		return INSTANCE;
	}
}

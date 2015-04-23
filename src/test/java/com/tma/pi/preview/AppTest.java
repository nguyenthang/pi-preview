package com.tma.pi.preview;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tma.pi.preview.bean.Number;


/**
 * @author thangnguyen
 *
 */

public class AppTest 
   
{
	List<Number> listNumbers;
	
	@Before
	public void setUp() throws Exception{
		listNumbers = new ArrayList<Number>();
	}
	
	@After
	public void tearDown() throws Exception{
		listNumbers = null;
	}
	
	@Test
	public void testBlockNumber(){
		
	}
}

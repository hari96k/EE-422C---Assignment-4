package assignment4;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.junit.Test;

public class BlackBoxTesting {

	Assign4Driver Driver;
	ArrayList<String> wordDictionary = new ArrayList<String>();
	
	protected void setUp() throws Exception{
		Dictionary wordDict = new Dictionary();
	      wordDictionary = wordDict.getDictionary("src/A4-words.txt");
       
    }
	

	@Test
	/*Test For No Results between angels and devils*/
	public void noResult() throws Exception 
		{
		
		setUp();
		Assignment4Interface wordLadderSolver = new WordLadderSolver();
		wordLadderSolver.setDictionary(wordDictionary);
		List<String> result = wordLadderSolver.computeLadder("angel","devil");
		
		assertNull(result);
	
	    }
	
	@Test
	/*Test between known true results*/
	public void trueResult() throws Exception 
	{
	setUp();
	Assignment4Interface wordLadderSolver = new WordLadderSolver();
	wordLadderSolver.setDictionary(wordDictionary);
	List<String> result = wordLadderSolver.computeLadder("heads","tails");
	Collections.reverse(result);
	boolean correct = wordLadderSolver.validateResult("heads","tails",result);
	Driver.printResult(result);
	assertTrue(correct);
	
	}

}

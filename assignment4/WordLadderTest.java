package assignment4;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.junit.Test;

public class WordLadderTest {

	
	@Test
	public void test1() throws NoSuchLadderException 
		{
		Assignment4Interface wordLadderSolver = new WordLadderSolver();
		
		List<String> result = wordLadderSolver.computeLadder("angel","devil");
		
		assertNull(result);
	
	    }
	
	@Test
	public void test() throws NoSuchLadderException 
	{
	 ArrayList<String> Dictionary = new ArrayList<String>();
	 Dictionary.add("heads");
	 Dictionary.add("heals");
	 Dictionary.add("veals");
	 Dictionary.add("veils");
	 Dictionary.add("vails");
	 Dictionary.add("tails");
	Assignment4Interface wordLadderSolver = new WordLadderSolver();
	wordLadderSolver.setDictionary(Dictionary);
	List<String> result = wordLadderSolver.computeLadder("heads","tails");
	Collections.reverse(result);
	boolean correct = wordLadderSolver.validateResult("heads","tails",result);
	assertTrue(correct);

    }
	
	   
		
	}




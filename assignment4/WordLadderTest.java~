package assignment4;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class WordLadderTest {

	@Test
	public void test() throws NoSuchLadderException 
		{
		
		Assignment4Interface wordLadderSolver = new WordLadderSolver();
		
		List<String> result = wordLadderSolver.computeLadder("angel","devil");
		
		assertNull(result);
	
	    }
	
	
	public void test1() throws NoSuchLadderException 
	{
	
	Assignment4Interface wordLadderSolver = new WordLadderSolver();
	
	List<String> result = wordLadderSolver.computeLadder("money","smart");
	
	boolean correct = wordLadderSolver.validateResult("money","smart",result);
	assertTrue(correct);

    }
		
	}



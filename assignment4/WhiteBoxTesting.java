package assignment4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class WhiteBoxTesting {
	Assign4Driver Driver;
	ArrayList<String> wordDictionary = new ArrayList<String>();
	
	protected void setUp() throws Exception{
		Dictionary wordDict = new Dictionary();
	      wordDictionary = wordDict.getDictionary("src/A4-words.txt");
       
    }
	

	@Test
	/*Test For No Results between angels and devils*/
	public void testforNull() throws Exception 
		{
		
		String[] start = {null,null,"heads"};
		String [] end = {null,"tails",null};
		Assignment4Interface wordLadderSolver = new WordLadderSolver();
		wordLadderSolver.setDictionary(wordDictionary);
		
		for(int i =0; i <3; i++){
		List<String> result = wordLadderSolver.computeLadder(start[i],end[i]);
		assertNull(result);
		}
	
	    }
	
	@Test
	public void testforShortWords() throws Exception 
	{
	
	String[] start = {"abc","123","che"};
	String [] end = {"sho","tais","nop"};
	Assignment4Interface wordLadderSolver = new WordLadderSolver();
	wordLadderSolver.setDictionary(wordDictionary);
	
	for(int i =0; i <3; i++){
	List<String> result = wordLadderSolver.computeLadder(start[i],end[i]);
	assertNull(result);
	}

    }
	
	@Test
	public void testforLongWords() throws Exception 
	{
	
	String[] start = {"abasfsadfasfc","12asdfdsf3","cheasdfsfd"};
	String [] end = {"sasdfsfho","taiasdfsdfs","noasdfsfp"};
	Assignment4Interface wordLadderSolver = new WordLadderSolver();
	wordLadderSolver.setDictionary(wordDictionary);
	
	for(int i =0; i <3; i++){
	List<String> result = wordLadderSolver.computeLadder(start[i],end[i]);
	assertNull(result);
	}
	
	}
}

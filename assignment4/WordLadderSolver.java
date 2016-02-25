/*
    ADD YOUR HEADER HERE
 */

package assignment4;

import java.util.List;
import java.util.*;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
    // delcare class members here.

	public static ArrayList<String> Dictionary = new ArrayList<String>();
	
	
    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
	
	public void wordLadderSolver()
	{
	this.Dictionary = Assign4Driver.Dictionary;	
	}
	
		
    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException 
    {
    	ArrayList<String> diffbyOneWords = new ArrayList<String>();
    	
    	for(String each: Dictionary )
    	{
    		if(diffbyOne(startWord,each)){diffbyOneWords.add(each);} //if the words differ by one add it in
    	}
    	
        // implement this method
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) 
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    // add additional methods here
    
    public boolean diffbyOne(String str1, String str2){
    	
    	if (str1.length() != str2.length())
            return false;
        int same = 0;
        for (int i = 0; i < str1.length(); ++i) {
            if (str1.charAt(i) == str2.charAt(i))
                same++;
        }
        return same == str1.length() - 1;
    }
    	

    
    
}


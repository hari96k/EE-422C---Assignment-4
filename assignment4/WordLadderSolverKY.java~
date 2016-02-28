/*
 WordLadder Solver Class
 Solves EE422C programming assignment #4
 @author Hari (), Kevin Yee (kjy252)
 @version 1.00 2016-02-025
 */
 

package assignment4;

import java.util.List;
import java.util.*;

// do not change class name or interface it implements
public class WordLadderSolverKY implements Assignment4Interface
{
    // delcare class members here.

	
	public static  ArrayList<String> Dictionary = new ArrayList<String>();
	public static ArrayList<String> SolutionsList = new ArrayList<String>();
	public static char[] eachLetter = new char[5];
	
    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
	

	
	public void setLetter(String start){
		this.eachLetter[0] = start.charAt(0);
		this.eachLetter[1] = start.charAt(1);
		this.eachLetter[2] = start.charAt(2);
		this.eachLetter[3] = start.charAt(3);
		this.eachLetter[4] = start.charAt(4);
	}
		
    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException 
    {
    HashMap<String,Integer> ladder = new HashMap<>();
    HashMap<String,ArrayList<String>> graph = new HashMap<>();
    Queue<String> Q = new LinkedList<String>();
    	
    ladder.put(startWord, 1);
    Q.add(startWord);
    int min = Integer.MAX_VALUE;
    
    //BFS
    while(!Q.isEmpty()){
    	String word = Q.remove();
    	setLetter(word);
    	if(word == endWord){
    		min = ladder.get(word);
    		continue;
    	}
    	
    	int dis = ladder.get(word) + 1;
    	
    	if(dis>min){break;}
    	
    	for(int i =0; i <5; i++){
    		char[] temp = new char[5];
    		temp = Arrays.copyOf(eachLetter, 5);
    		for(char c = 'a'; c <= 'z'; c++)
    		{
    			temp[i] = c;
    			String tempString = new String(temp);
    			if(!getDictionary().contains(tempString)){continue;}
    			
    			if(!ladder.containsKey(tempString)){
    				ladder.put(tempString, dis);
    				Q.add(tempString);
    				ArrayList<String> wordGraph = new ArrayList<String>();
    				wordGraph.add(word);
    				graph.put(tempString, wordGraph);
    				continue;
    			}
    			
    			if(ladder.get(tempString) < dis)continue;
    			else if(ladder.get(tempString) == dis)
    				graph.get(tempString).add(word);
    		}
    	}
    }
    
  ArrayList<String> builder = new ArrayList<>();
  if(!graph.containsKey(endWord)){System.out.println("No path found");
  return SolutionsList;}
    
    buildResult(endWord, startWord,min-1,builder,graph);
    
    SolutionsList = builder;
    return SolutionsList;
    }
    
    public boolean found = false;
   public ArrayList<String> buildResult(String end, String startWord,int step,ArrayList<String> builder,HashMap<String,ArrayList<String>>graph){
        if (end.equals(startWord)){
            builder.add(end);
            found = true;
            return builder;
        }
        if(found){
        	return builder;
        }
        builder.add(end);
        if (end.equals(startWord)){
            builder.add(end);
            return builder;
        }
        for (String s: graph.get(end)){
        	if (end.equals(startWord)){
                break;
             }
        	try{
        	 buildResult(s, startWord,step-1,builder,graph);
        	}
        	catch(NullPointerException e){
        		SolutionsList = builder;
        		return builder;
        	}
        	 
        }
        return builder;
    }
        // implement this method
    
    

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


	public static ArrayList<String> getDictionary() {
		return Dictionary;
	}


	public  void setDictionary(ArrayList<String> dictionary) {
		Dictionary = dictionary;
	}
    	

    
    
}

/*
 Assign4Driver Class
 Solves EE422C programming assignment #4
 @author Hari (), Kevin Yee (kjy252)
 @version 1.00 2016-02-025
 */
 


package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class Assign4Driver
{
	public static  ArrayList<String> wordDictionary;
	
	/*Function: processCommands
     * *****************************
     * Process word pairs to solve
     * @params file name
     ******************************/	
	public static void processCommands (String filename) throws Exception 
    {
        try 
        {
            // Read file 
            FileReader freader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(freader);
            
            // Iterate over and process each line of file
            for (String s = reader.readLine(); s != null; s = reader.readLine()) 
            {
                String[] inputs = new String[2];
                inputs = s.split("\\s+");							
                solveLadder(inputs); //solves each word ladder
            } 
        }
            
        catch (FileNotFoundException e) 
        {
            System.err.println ("Error: File not found. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) 
        {
            System.err.println ("Error: IO exception. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }
        return;
    }
	    
    
	/*Function: processDictionary
     * *****************************
     * Process word pairs to solve
     * @params fileName
     ******************************/ 
	public static void processDictionary (String filename) throws Exception 
    {
      Dictionary wordDict = new Dictionary();
      wordDictionary = wordDict.getDictionary(filename);
      return;
    }
	
    /*Function: solveLadder
     * *****************************
     * Solves the WordLadder 
     * @param inputs  Strings to build ladder from
     * @return void
     ******************************/  
    public static void solveLadder(String[] inputs)
    {
        Assignment4Interface wordLadderSolver = new WordLadderSolver();

        try 
        {
        	wordLadderSolver.setDictionary(wordDictionary);
            List<String> result = wordLadderSolver.computeLadder(inputs[0], inputs[1]);
            if(result != null){printResult(result);}
    
            boolean correct = true;
            if(result != null){correct = wordLadderSolver.validateResult(inputs[0], inputs[1], result);}
     
            if(!correct){System.out.println("Wrong");}
        } 
        catch (NoSuchLadderException e) 
        {
            e.printStackTrace();
        }
    }
    
    /* Function: printResult
     * ****************************
     * Prints Item in Results Array
     * @param result    result of Word Ladder
     * @return void
     ******************************/  
    
    public static void printResult(List<String> result)
    {
    	Collections.reverse(result);
    	Iterator<String> i = result.iterator();
        while (i.hasNext())
        {
            String temp = i.next();  // grab next item                                                         
            System.out.println(temp);
        }
        
        System.out.println("**********"); 
     
    }
    
    
    /* Function: main
     * ****************************
     * main inputs
     ******************************/  
    public static void main(String[] args) throws Exception
    {
            if (args.length != 2)
            {
                System.err.println ("Error: Incorrect number of command line arguments");
                System.exit(-1);
            }
            processDictionary (args[0]);//dictionary in arg 0
            processCommands(args[1]);//commands in arg 1

    }
    
   
}

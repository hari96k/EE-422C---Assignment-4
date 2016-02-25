package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Assign4Driver
{
	
	public static ArrayList<String> Dictionary = new ArrayList<String>();
	
	public static void processDictionary (String filename) throws Exception 
    {
        Assign4Driver driver = new Assign4Driver();
        try 
        {
            // Read file 
            FileReader freader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(freader);
            
            // Iterate over and process each line of file
            for (String s = reader.readLine(); s != null; s = reader.readLine()) 
            {
                Dictionary.add(s);             // output corresponding output
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
	
	
	public static void processCommands (String filename) throws Exception 
    {
        Assign4Driver driver = new Assign4Driver();
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
                solveLadder(inputs);
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
    public static void main(String[] args) throws Exception
    {
    	
    	
            if (args.length != 1)
            {
                System.err.println ("Error: Incorrect number of command line arguments");
                System.exit(-1);
            }
            processDictionary (args[0]);
            processCommands(args[1]);

    }
    
    public static void solveLadder(String[] inputs){
        // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver();

        try 
        {
        	
            List<String> result = wordLadderSolver.computeLadder(inputs[0], inputs[1]);
            boolean correct = wordLadderSolver.validateResult("money", "honey", result);
        } 
        catch (NoSuchLadderException e) 
        {
            e.printStackTrace();
        }
    }
}


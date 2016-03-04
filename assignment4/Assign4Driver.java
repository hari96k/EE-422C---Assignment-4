/*
 WordLadder Solver Class
 Solves EE422C programming assignment #4
 @author Hari (hk8663), Kevin Yee (kjy252)
 @version 1.01 2016-03-03
 */

package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Assign4Driver {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.err.println("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		processDictionary("A4-words.txt");			// Dictionary will be in the same folder as main (I think)
		processCommands(args[0]);					// args[0] contains test file

	}



	/* Function: processDictoinary
	 * 		Puts Dictionary into ArrayList
	 */
	public static void processDictionary(String filename) throws Exception {
		BufferedReader reader = null;		// Outside try block to ensure that reader is closed in the finally block
		try {
			// Read file
			FileReader freader = new FileReader("src/assignment4/" + filename);
			reader = new BufferedReader(freader);

			// Iterate over and process each line of file
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				if (!s.startsWith("*")) {
					WordLadderSolver.getDictionary().add(s.substring(0, 5)); // add words to dictionary
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
		finally {
			if (reader != null) 
				reader.close();
		}
		return;
	}

	/* Function: processCommands 
	 * 		Process word pairs to solve
	*/

	public static void processCommands(String filename) throws Exception {
		BufferedReader reader = null;		// Outside try block to ensure that reader is closed in the finally block
		try {
			// Read file
			FileReader freader = new FileReader("src/assignment4/" + filename);
			reader = new BufferedReader(freader);

			// Iterate over and process each line of file
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				String[] inputs = new String[2];
				inputs = s.split("\\s+");
				solveLadder(inputs); // solves each word ladder
			}
		}

		catch (FileNotFoundException e) {
			System.err.println("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
		finally {
			if (reader != null) 
				reader.close();
		}
		return;
	}

	/*
	 * Function: solveLadder ***************************** Solves the WordLadder
	 * 
	 * @param inputs Strings to build ladder from
	 * 
	 * @return void
	 ******************************/
	public static void solveLadder(String[] inputs) {
		Assignment4Interface wordLadderSolver = new WordLadderSolver();

		try {
			List<String> result = wordLadderSolver.computeLadder(inputs[0], inputs[1]);
			if (result != null) {
				printResult(result);
			}

			boolean correct = true;
			if (result != null) {
				correct = wordLadderSolver.validateResult(inputs[0], inputs[1], result);
			}
			if (!correct) {
				System.out.println("Wrong");
			}
		} catch (NoSuchLadderException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function: printResult **************************** Prints Item in Results
	 * Array
	 * 
	 * @param result result of Word Ladder
	 * 
	 * @return void
	 ******************************/

	public static void printResult(List<String> result) {
		Collections.reverse(result);
		Iterator<String> i = result.iterator();
		while (i.hasNext()) {
			String temp = i.next(); // grab next item
			System.out.println(temp);
		}

		System.out.println("**********");

	}

}

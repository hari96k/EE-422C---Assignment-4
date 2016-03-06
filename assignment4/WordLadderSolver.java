/*
 WordLadder Solver Class
 Solves EE422C programming assignment #4
 @author Hari (hk8663), Kevin Yee (kjy252)
 @version 1.01 2016-03-03
 */

package assignment4;

import java.util.List;
import java.util.*;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface {

	private static ArrayList<String> Dictionary = new ArrayList<String>();
	private static ArrayList<String> SolutionsList = new ArrayList<String>();
	private static char[] eachLetter = new char[5];

	/*
	 * Function: setLetter ***************************** Turns start into
	 * individual chars to check
	 * 
	 * @params start
	 * 
	 * @return void
	 ******************************/

	private void setLetter(String start) {
		eachLetter[0] = start.charAt(0);
		eachLetter[1] = start.charAt(1);
		eachLetter[2] = start.charAt(2);
		eachLetter[3] = start.charAt(3);
		eachLetter[4] = start.charAt(4);
	}

	/*
	 * Function: computeLadder ***************************** Find all Paths
	 * Using BFS
	 * 
	 * @params startWord
	 * 
	 * @params endWord
	 * 
	 * @return result List
	 ******************************/
	public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException {

		
		/* If the String is not of length 5 return error */
		if (startWord.length() != 5 || endWord.length() != 5) {
			printError(startWord, endWord);
			return null;
		}
		

		if (diffbyOne(startWord, endWord)) {
			SolutionsList.add(endWord);
			SolutionsList.add(startWord);
			return SolutionsList;
		}
		
		if (startWord.equals(endWord)) {
			SolutionsList.add(endWord);
			SolutionsList.add(startWord);
			return SolutionsList;
		}

		HashMap<String, Integer> ladder = new HashMap<>(); // ladder from one word to another
		HashMap<String, ArrayList<String>> graph = new HashMap<>(); // graph of all possibilities
		Queue<String> Q = new LinkedList<String>();

		ladder.put(startWord, 1);
		Q.add(startWord);

		// BFS
		while (!Q.isEmpty()) {
			String word = Q.remove();
			setLetter(word); // allows for easier conversions of char

			if (word.equals(endWord)) {
				// minSteps = ladder.get(word); //we've found our word and can exit
				break;
			}

			int count = ladder.get(word) + 1; // one step from each previous word. keeps track of duplicates
			// if(count>minSteps){break;}

			for (int i = 0; i < 5; i++) {
				char[] temp = new char[5];
				temp = Arrays.copyOf(eachLetter, 5);
				for (char c = 'a'; c <= 'z'; c++) {
					/* Iterate through ever possible differOne combos */
					temp[i] = c;
					String tempString = new String(temp);
					if (!Dictionary.contains(tempString)) {
						continue;
					} // if not in dictionary, ignore

					if (!ladder.containsKey(tempString)) { // if in dictionary, but not in our ladder, put it in.
						ladder.put(tempString, count);
						Q.add(tempString);
						ArrayList<String> wordGraph = new ArrayList<String>();
						wordGraph.add(word);
						graph.put(tempString, wordGraph); // put in the first word as tempString, wordGraph holds ArrayList of all differ ones
						continue;
					}

					if (ladder.get(tempString) < count)
						continue; // check if word is existing
					else if (ladder.get(tempString) == count) // word doesn't exist in arraylist yet, put it in
						graph.get(tempString).add(word);
				}
			}
		}

		ArrayList<String> result = new ArrayList<>();
		if (!graph.containsKey(endWord)) {
			printError(startWord, endWord);
			return null;
		}

		buildResult(endWord, startWord, result, graph);

		SolutionsList = result;
		return SolutionsList;
	}

	public boolean found = false;
	/*
	 * Function: buildResult ***************************** buildResult from BFS
	 * using DFS
	 * 
	 * @params end
	 * 
	 * @params startWord
	 * 
	 * @params result
	 * 
	 * @params graph
	 * 
	 * @return result List
	 ******************************/

	private ArrayList<String> buildResult(String end, String startWord, ArrayList<String> result,
			HashMap<String, ArrayList<String>> graph) {
		if (end.equals(startWord)) {
			result.add(end);
			found = true;
			return result;
		}
		if (found) {
			return result;
		}
		result.add(end);
		if (end.equals(startWord)) {
			result.add(end);
			return result;
		}
		for (String s : graph.get(end)) {
			if (end.equals(startWord)) {
				break;
			}
			try {
				buildResult(s, startWord, result, graph);
			} catch (NullPointerException e) {
				SolutionsList = result;
				return result;
			}

		}
		return result;
	}
	// implement this method

	@Override
	public boolean validateResult(String startWord, String endWord, List<String> wordLadder) {

		if (!wordLadder.get(0).equals(startWord) && !wordLadder.get(wordLadder.size() - 1).equals(endWord)) {
			return false;
		}

		int i = 0;
		while (!wordLadder.get(i + 1).equals(endWord)) {
			if (!diffbyOne(wordLadder.get(i), wordLadder.get(i + 1))) {
				return false;
			}
			i++;
		}
		return true;
	}

	private boolean diffbyOne(String str1, String str2) {

		if (str1.length() != str2.length())
			return false;
		int same = 0;
		for (int i = 0; i < str1.length(); ++i) {
			if (str1.charAt(i) == str2.charAt(i))
				same++;
		}
		return same == str1.length() - 1;
	}

	private void printError(String startWord, String endWord) {
		
		System.out.println("For the input words " + startWord + " and " + endWord + ":\nThere is no word ladder between " + startWord + " and " + endWord + "!");
		System.out.println("**********");
		return;
	}

	public static ArrayList<String> getDictionary() {
		return Dictionary;
	}

	public void setDictionary(ArrayList<String> dictionary) {
		Dictionary = dictionary;
	}

}

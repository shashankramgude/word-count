package wordCount.driver;

import wordCount.treesForStrings.AVLTree;
import wordCount.util.FileProcessor;
import wordCount.visitors.GrepVisitor;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.WordCountVisitor;

/**
 * @author Shashank Ramgude and Nikhil Bagde
 * @version 1.0
 * @since 04-19-2016
 */
public class Driver {

	public static void main(String[] args) { // input.txt output.txt
												// NUM_ITERATION
												// search-string
		String INPUT_FILE_NAME = null;
		String OUTPUT_FILE_NAME = null;
		int NUM_ITERATION;
		String SEARCH_STRING = null;

		FileProcessor inputFileProcessor = null;
		FileProcessor outputFileProcessor = null;

		try {
			if (args.length != 4) {
				System.err.println("Invalid number of argumnets.");
				System.exit(1);
			}
			INPUT_FILE_NAME = args[0];
			OUTPUT_FILE_NAME = args[1];
			NUM_ITERATION = Integer.parseInt(args[2]);
			SEARCH_STRING = args[3];
			long startTime = System.currentTimeMillis();

			for (int i = 0; i < NUM_ITERATION; i++) {
				try {
					inputFileProcessor = new FileProcessor(INPUT_FILE_NAME, "R");
					outputFileProcessor = new FileProcessor(OUTPUT_FILE_NAME,
							"W");

					AVLTree avlTree = new AVLTree();

					TreeProcessingVisitorI treeProcessingVisitor = new PopulateTreeVisitor(
							inputFileProcessor);
					avlTree.accept(treeProcessingVisitor);

					treeProcessingVisitor = new WordCountVisitor(
							outputFileProcessor);
					avlTree.accept(treeProcessingVisitor);

					treeProcessingVisitor = new GrepVisitor(
							outputFileProcessor, SEARCH_STRING);
					avlTree.accept(treeProcessingVisitor);
				} finally {
					if (inputFileProcessor != null) {
						inputFileProcessor.closeBufferedReader();
					}
					if (outputFileProcessor != null) {
						outputFileProcessor.closeBufferedWriter();
					}
				}
			}
			long finishTime = System.currentTimeMillis();
			long totalTime = (finishTime - startTime) / NUM_ITERATION;
			System.out.println("Total time utilized: " + totalTime);
		} catch (NumberFormatException e) {
			System.err.println("Error in reading the arguments.");
			e.printStackTrace();
			System.exit(1);
		} finally {
			// outputFileProcessor.closeBufferedWriter();
			// inputFileProcessor.closeBufferedReader();
		}
	}
}

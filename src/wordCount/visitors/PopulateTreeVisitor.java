
package wordCount.visitors;

import java.io.IOException;
import wordCount.treesForStrings.AVLTree;
import wordCount.util.FileProcessor;

/**
 * @author Shashank Ramgude and Nikhil Bagde
 * 
 */
public class PopulateTreeVisitor implements TreeProcessingVisitorI {

	private FileProcessor fileProcessor;
	public PopulateTreeVisitor() {

	}

	/**
	 * Constructor
	 * @param fileProcessorIn
     */
	public PopulateTreeVisitor(FileProcessor fileProcessorIn) {
		fileProcessor = fileProcessorIn;
	}

	/**
	 * Reading of file
	 * @param avlTree
	 */
	@Override
	public void visit(AVLTree avlTree) {
		String input = null;
		try{
			while ((input = fileProcessor.readLineFromFile()) != null) {
				String[] tokens = input.split("\\s+");
				for (int i = 0; i < tokens.length; i++)
					if (tokens[i].length() != 0 && tokens[i] != null)
						avlTree.insert(tokens[i]);
			}
		} catch (IOException e) {
			System.err.println("Error in file reading.");
			e.printStackTrace();
			System.exit(1);	
		} finally{
			
		}
	}
}

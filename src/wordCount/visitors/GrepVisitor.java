
package wordCount.visitors;

import java.io.IOException;
import wordCount.treesForStrings.AVLTree;
import wordCount.util.FileProcessor;

/**
 * @author Shashank Ramgude and Nikhil Bagde
 *
 */
public class GrepVisitor implements TreeProcessingVisitorI {

	private FileProcessor fileProcessor;
    private String searchString;
    
	public GrepVisitor(){
		
	}
	
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchStringIn) {
		searchString = searchStringIn;
	}

	
	@Override
	public String toString() {
		return "GrepVisitor [Search String=" + searchString + "]";
	}

	/**
	 * Constrcutor
	 * @param fileProcessorIn
	 * @param searchStringIn
     */
	public GrepVisitor(FileProcessor fileProcessorIn, String searchStringIn){
		fileProcessor = fileProcessorIn;
		searchString = searchStringIn;
	}

	/**
	 * It gives frequency of search string
	 * @param avlTree
	 */
	@Override
	public void visit(AVLTree avlTree) {
		try {
			if(avlTree.getMax() == -1){
				fileProcessor.writeLineToFile("The word "+ searchString + " occurs the following times: 0");
			} else{
				fileProcessor.writeLineToFile("The word "+ searchString + " occurs the following times: " + avlTree.search(searchString).getWordCount());
			}	
		} catch (IOException e) {
			System.err.println("Error in file reading.");
			e.printStackTrace();
			System.exit(1);
		} finally{
			
		}
	}
}

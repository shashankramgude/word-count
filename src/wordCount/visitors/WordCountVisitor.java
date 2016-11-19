package wordCount.visitors;

import java.io.IOException;
import wordCount.treesForStrings.AVLTree;
import wordCount.util.FileProcessor;

/**
 * @author Shashank Ramgude and Nikhil Bagde
 *
 */
public class WordCountVisitor implements TreeProcessingVisitorI {
	private FileProcessor fileProcessor;
	public WordCountVisitor(){
		
	}

	/**
	 * Constructor
	 * @param fileProcessorIn
     */
	public WordCountVisitor(FileProcessor fileProcessorIn){
		fileProcessor = fileProcessorIn;
	}

	/**
	 * This method gives total number of words
	 * @param avlTree
	 */
	@Override
	public void visit(AVLTree avlTree) {
		try{
			StringBuilder output = new StringBuilder();
			avlTree.generateFileStatistics();
			output.append("The Total number of words is: ");
			output.append(avlTree.getTotalWords());
			if(avlTree.getMax() == -1){
				output.append("\nNo most frequently used word exists.");
				output.append("\nThe frequency of the most frequently used word is: 0");
			}else{
				output.append("\nThe most frequently used word is: ");
				for(int i = 0;i < avlTree.getFreqWords().size();i++){
					output.append(avlTree.getFreqWords().get(i));
					if(i != avlTree.getFreqWords().size() - 1){
						output.append(" , ");
					}
				}
				output.append("\nThe frequency of the most frequently used word is: ");
				output.append(avlTree.getMax());
			}
			output.append("\nThe number of characters (without whitespaces) is: ");
			output.append(avlTree.getTotalChars());
			fileProcessor.writeLineToFile(output.toString());
		}catch (IOException e) {
			System.err.println("Error in file writing.");
			e.printStackTrace();
			System.exit(1);
		}finally{
			
		}
	}
}

package wordCount.visitors;

import wordCount.treesForStrings.AVLTree;

/**
 * @author Shashank Ramgude and Nikhil Bagde
 *
 */
public interface TreeProcessingVisitorI {
	public void visit(AVLTree avlTree);
}

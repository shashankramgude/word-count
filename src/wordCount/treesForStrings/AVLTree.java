package wordCount.treesForStrings;

import java.util.ArrayList;
import java.util.List;
import wordCount.visitors.TreeProcessingVisitorI;

/**
 * @author Shashank Ramgude and Nikhil Bagde
 * 
 */
public class AVLTree {
	private AVLNode root;
	private int totalWords;
	private int totalChars;
	private int max;
	private List<String> freqWords;

	@Override
	public String toString() {
		return "AVLTree [root=" + root + ", total words=" + totalWords
				+ ", total chars=" + totalChars + ", max=" + max
				+ ", most frequent words=" + freqWords + "]";
	}

	public List<String> getFreqWords() {
		return freqWords;
	}

	public void setFreqWords(List<String> freqWords) {
		this.freqWords = freqWords;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public AVLNode getRoot() {
		return root;
	}

	public void setRoot(AVLNode rootIn) {
		root = rootIn;
	}

	public int getTotalWords() {
		return totalWords;
	}

	public void setTotalWords(int totalWordsIn) {
		totalWords = totalWordsIn;
	}

	public int getTotalChars() {
		return totalChars;
	}

	public void setTotalChars(int totalCharsIn) {
		totalChars = totalCharsIn;
	}

	/**
	 * default constructor
	 */
	public AVLTree() {
		root = null;
		max = -1;
		totalWords = 0;
		totalChars = 0;
		freqWords = new ArrayList<String>();
	}

	
	/**
	 * Function to insert data
	 * @param data
	 */
	public void insert(String data) {
		root = insert(data, root);
	}

	/**
	 * Function to get height of node
	 * @param node
	 * @return
	 */
	private int height(AVLNode node) {
		if (node == null) {
			return -1;
		}
		return node.getHeight();
	}

	/**
	 * Function to max of left/right node
	 * @param left
	 * @param right
	 * @return
	 */
	private int max(int left, int right) {
		return left > right ? left : right;
	}

	/**
	 * Function to insert data recursively
	 * @param word
	 * @param node
	 * @return
	 */
	private AVLNode insert(String word, AVLNode node) {
		if (node == null)
			node = new AVLNode(word);
		else if (word.compareTo(node.getWord()) < 0) {
			node.setLeftChild(insert(word, node.getLeftChild()));
			if (height(node.getLeftChild()) - height(node.getRightChild()) == 2)
				if (word.compareTo(node.getLeftChild().getWord()) < 0)
					node = singleRotationLeftChild(node);
				else
					node = doubleRotationLeftChild(node);
		} else if (word.compareTo(node.getWord()) > 0) {
			node.setRightChild(insert(word, node.getRightChild()));
			if (height(node.getRightChild()) - height(node.getLeftChild()) == 2)
				if (word.compareTo(node.getRightChild().getWord()) > 0)
					node = singleRotationRightChild(node);
				else
					node = doubleRotationRightChild(node);
		} else {
			node.setWordCount(node.getWordCount() + 1);
		}
		node.setHeight(max(height(node.getLeftChild()),
				height(node.getRightChild())) + 1);
		return node;
	}

	/**
	 * Rotate binary tree node with left child
	 * @param nodeIn
	 * @return
	 */
	private AVLNode singleRotationLeftChild(AVLNode nodeIn) {
		AVLNode leftChild = nodeIn.getLeftChild();
		nodeIn.setLeftChild(leftChild.getRightChild());
		leftChild.setRightChild(nodeIn);
		nodeIn.setHeight(max(height(nodeIn.getLeftChild()),
				height(nodeIn.getRightChild())) + 1);
		leftChild.setHeight(max(height(leftChild.getLeftChild()),
				nodeIn.getHeight()) + 1);
		return leftChild;
	}

	/**
	 * Rotate binary tree node with right child
	 * @param nodeIn
	 * @return
	 */
	private AVLNode singleRotationRightChild(AVLNode nodeIn) {
		AVLNode rightChild = nodeIn.getRightChild();
		nodeIn.setRightChild(rightChild.getLeftChild());
		rightChild.setLeftChild(nodeIn);
		nodeIn.setHeight(max(height(nodeIn.getLeftChild()),
				height(nodeIn.getRightChild())) + 1);
		rightChild.setHeight(max(height(rightChild.getRightChild()),
				nodeIn.getHeight()) + 1);
		return rightChild;
	}

	/**
	 * Double rotate binary tree node: first left child with its right
	 * child; then node with new left child
	 * @param node
	 * @return
	 */
	private AVLNode doubleRotationLeftChild(AVLNode node) {
		node.setLeftChild(singleRotationRightChild(node.getLeftChild()));
		return singleRotationLeftChild(node);
	}

	/**
	 * Double rotate binary tree node: first right child with its left
	 * child; then node with new right child
	 * @param node
	 * @return
	 */
	private AVLNode doubleRotationRightChild(AVLNode node) {
		node.setRightChild(singleRotationLeftChild(node.getRightChild()));
		return singleRotationRightChild(node);
	}

	/**
	 * Functions to search for an element
	 * @param input
	 * @return
	 */
	public AVLNode search(String input) {
		return search(root, input);
	}

	/**
	 * Searching of node
	 * @param root
	 * @param input
	 * @return
	 */
	private AVLNode search(AVLNode root, String input) {
		AVLNode found = null;
		while ((root != null) && (found == null)) {
			String rootWord = root.getWord();
			if (input.compareTo(rootWord) < 0)
				root = root.getLeftChild();
			else if (input.compareTo(rootWord) > 0)
				root = root.getRightChild();
			else {
				found = root;
				break;
			}
			found = search(root, input);
		}
		return found;
	}

	/**
	 * accept method to accept from driver code and delegate to visitor
	 * @param visitor
     */
	public void accept(TreeProcessingVisitorI visitor) {
		visitor.visit(this);
	}

	public void generateFileStatistics() {
		totalWords = 0;
		totalChars = 0;
		traverse(root);
	}

	/**
	 * This method traverses Inorder 
	 * 
	 * @param AVLNode
	 *            node
	 * @return Nothing
	 * @exception Nothing
	 */
	private void traverse(AVLNode node) {
		if (node != null) {
			traverse(node.getLeftChild());
			totalWords = totalWords + node.getWordCount();
			totalChars = totalChars + (node.getWordCount() * node.getWord().length());
			if (node.getWordCount() > max) {
				max = node.getWordCount();
				freqWords.clear();
				freqWords.add(node.getWord());
			} else if ((node.getWordCount() == max) && (!freqWords.contains(node.getWord()))) {
				freqWords.add(node.getWord());
			}
			traverse(node.getRightChild());
		}
	}
	
}

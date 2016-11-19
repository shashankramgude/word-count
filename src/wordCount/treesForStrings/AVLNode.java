package wordCount.treesForStrings;

public class AVLNode {
	private AVLNode leftChild;
	private AVLNode rightChild;
	private String word;
	private int wordCount;
	private int height;
	
	public AVLNode() {
		leftChild = null;
		rightChild = null;
		wordCount = 1;
		height = 0;
	}

	public AVLNode(String wordIn) {
		this();
		word = wordIn;
	}

	public AVLNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(AVLNode leftChildIn) {
		leftChild = leftChildIn;
	}

	public AVLNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(AVLNode rightChildIn) {
		rightChild = rightChildIn;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String wordIn) {
		word = wordIn;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCountIn) {
		wordCount = wordCountIn;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int heightIn) {
		height = heightIn;
	}

	@Override
	public String toString() {
		return "AVLNode [word=" + word + ", wordCount=" + wordCount
				+ ", height=" + height + "]";
	}
	
	
}

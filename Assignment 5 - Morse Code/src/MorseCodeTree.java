import java.util.ArrayList;

/**
 * Class that represent a tree for morse code
 * @author Alex Matos
 *
 */
public class MorseCodeTree extends Object implements LinkedConverterTreeInterface<String>{

	TreeNode<String> root = new TreeNode("");
	String letter2;
	
	/**
	 * Constructor that builds the tree when called
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * Gets the root of the MorseCodeTree
	 */
	@Override
	public TreeNode<String> getRoot() {
		// TODO Auto-generated method stub
		return this.root;
	}

	/**
	 * Sets the root of the morse code tree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		// TODO Auto-generated method stub
		this.root = newNode;
	}

	/**
	 * Used to insert morse code nodes in tree
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		// TODO Auto-generated method stub
		addNode(root,code,result);
		return this;
	}

	/**
	 * Adds a node to the tree using the code
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// TODO Auto-generated method stub
		// If there is only one character in the morse code
		if (code.length()==0+1) {
			if (code.equals("."))
				root.leftChild = new TreeNode(letter);
			if (code.equals("-"))
				root.rightChild = new TreeNode(letter);
			return ;
		} else {
			if (code.substring(0,1).equals("."))
				addNode(root.leftChild,code.substring(1),letter);
			
			if (code.substring(0,1).equals("-"))
				addNode(root.rightChild,code.substring(1),letter);
		}
	}

	/**
	 * Fetches a letter using the code and recursive method fetchNode()
	 */
	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		
		return fetchNode(root,code);
	}

	/**
	 * Method is used in fetch() to fetch a node
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// TODO Auto-generated method stub
		if (code.length() == 1) {
			if (code.equals("."))
				letter2 = root.leftChild.data;
			if (code.equals("-"))
				letter2 = root.rightChild.data;
		} else {
			if (code.substring(0, 1).equals("."))
				fetchNode(root.leftChild,code.substring(1));
			if (code.substring(0, 1).equals("-"))
				fetchNode(root.rightChild,code.substring(1));
		}
		return letter2;
		
	}

	/**
	 * Method is unsupported
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * method is unsupported
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * method to build a tree of morse code nodes
	 */
	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
		// level two
				insert(".","e");
				insert("-","t");
				// level three
				insert("..","i");
				insert(".-","a");
				insert("-.","n");
				insert("--","m");
				// level four
				insert("...","s");
				insert("..-","u");
				insert(".-.","r");
				insert(".--","w");
				insert("-..","d");
				insert("-.-","k");
				insert("--.","g");
				insert("---","o");
				// level five
				insert("....","h");
				insert("...-","v");
				insert("..-.","f");
				insert(".-..","l");
				insert(".--.","p");
				insert(".---","j");
				insert("-...","b");
				insert("-..-","x");
				insert("-.-.","c");
				insert("-.--","y");
				insert("--..","z");
				insert("--.-","q");
		
	}

	/**
	 * Makes a arraylist inorder traversal
	 */
	@Override
	public ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		ArrayList<String> treeLNR = new ArrayList<String>();
		LNRoutputTraversal(root, treeLNR);
		return treeLNR;
	}

	/**
	 * recursive method used for toArrayList()
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if (root != null) {
			LNRoutputTraversal(root.leftChild, list);
			list.add(root.getData());
			LNRoutputTraversal(root.rightChild, list);
		}
	}
	
}
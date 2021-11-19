
/**
 * Basic Tree Node for morse code tree
 * @author Alex Matos
 *
 * @param <T>
 */
public class TreeNode<T> extends Object {

	TreeNode<T> leftChild, rightChild;
	T data;
	
	public TreeNode (T data) {
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
	
	public TreeNode(TreeNode<T> tree) {
		this.data = tree.data;
		this.leftChild = tree.leftChild;
		this.rightChild = tree.rightChild;
	}
	
	public T getData() {
		return this.data;
	}
	
}

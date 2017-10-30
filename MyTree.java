
public class MyBinaryTree {
	
	private static class BinaryTreeNode {
		public int data;
				
		public BinaryTreeNode left;
		
		public BinaryTreeNode right;
	}
	
	private int size;
	
	private BinaryTreeNode parentNode;
	
	public void addTreeNode(int data) {
		BinaryTreeNode node = new BinaryTreeNode();
		node.data = data;
		size++;
		if (parentNode == null) {
			parentNode = node;
			return;
		}
		
		if (parentNode.left == null && parentNode.right == null && parentNode.data < data) {
			node.left = parentNode;
			parentNode = node;
			return;
		}
		
		add(node, parentNode);
	}
	
	private void add(BinaryTreeNode node, BinaryTreeNode parentNode) {
		BinaryTreeNode leftChild = parentNode.left;
		BinaryTreeNode rightChild = parentNode.right;
		if (node.data <= parentNode.data && leftChild == null) {
			parentNode.left = node;
			return;
		}
		if (node.data <= parentNode.data && node.data > leftChild.data && leftChild.left == null) {
			node.left = leftChild;
			parentNode.left = node;
			return;
		}
		if (node.data <= parentNode.data) {
			add(node, leftChild);
			return;
		}
		if (node.data > parentNode.data && rightChild == null) {
			parentNode.right = node;
			return;
		}
		if (node.data > parentNode.data) {
			add(node, rightChild);
			return;
		}
	}
	
	public int get(int index) {
		
		return 0;
	}
	
	public void iteratorTree() {
		printNode(parentNode);
	}
	
	private void printNode(BinaryTreeNode node) {
		if (node.left != null) {
			printNode(node.left);
		}
		System.out.println(node.data);
		if (node.right != null) {
			printNode(node.right);
		}
	}
	
	public int size() {
		return size;
	}
	
}

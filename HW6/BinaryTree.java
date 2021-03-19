import java.io.Serializable;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * @author zafer
 *
 * @param <E>
 */
public class BinaryTree<E> implements Serializable {
	
	protected static class Node<E> implements Serializable{
		public Node<E> right;
		public Node<E> left;
		E data;
		
		public Node(E dataitem) {
			data=dataitem;
		}
		public String toString(){
			return data.toString();
		}
	}
	
	protected Node<E> root;
	
	public BinaryTree(){
		root=null;
	}
	protected BinaryTree(Node<E> ref){
		root=ref;
	}
	public BinaryTree(E dataitem,BinaryTree<E> lefttree,BinaryTree<E> righttree) {
	
			root=new Node<>(dataitem);
			if(lefttree==null) {
				root.left=null;
			}else {
				root.left=lefttree.root;
			}
			if(righttree==null) {
				root.right=null;
			}else {
				root.right=righttree.root;
			}
			
	}

	public BinaryTree<E> getLeftSubtree(){
		if(root!=null && root.left!=null)
		return new BinaryTree<>(root.left);
		
		return null;
	}
	public BinaryTree<E> getRightSubtree(){
		if(root!=null && root.right!=null)
		return new BinaryTree<>(root.right);
		
		return null;
	}	

	public boolean isLeaf() {
		return (root.left==null && root.right==null);
	}
	
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		toString(root,sb,1);
		return sb.toString();		
		
	}
	
	private void toString(Node<E> root,StringBuilder sb,int depth) {
		for(int i=0;i<depth;i++) {
			sb.append(" ");
		}
		if(root==null) {
			sb.append("null \n");
		}else {
			sb.append(root.toString());
			sb.append("\n");
			toString(root.left,sb,depth+1);
			toString(root.right,sb,depth+1);
		}
	}
	
	public static BinaryTree<String> readBinaryTree(Scanner scan){
		String data=scan.nextLine().trim();
		if(data.equals("null")) {
			return null;
		}else {
			BinaryTree<String> left=readBinaryTree(scan);
			BinaryTree<String> right=readBinaryTree(scan);
			return new BinaryTree<>(data,left,right);
		}
		
	}
	public void preOrderTraverse(BiConsumer<E, Integer> consumer) {
		preOrderTraverse(root,1,consumer);
	}
	private void preOrderTraverse(Node<E> node,int depth,BiConsumer<E,Integer> consumer) {
		if(node==null) {
			consumer.accept(null, depth);
		}else {
			consumer.accept(node.data, depth);
			preOrderTraverse(node.left,depth+1,consumer);
			preOrderTraverse(node.right,depth+1,consumer);
		}
	}
}

import java.util.Scanner;
import java.util.function.BiConsumer;



/**
 * @author zafer
 *A special class that takes Generic type parameters
 * @param <E>
 */
public class ExpressionTree<E> extends BinaryTree<E> {

	private BinaryTree<String> head;

	
	/**
	 * The method that matches the input it receives with the scanner object
	 * @param input is an expression
	 * 
	 */
	public ExpressionTree(String input){
		
		Scanner scan=new Scanner(input.toString());
		head=readBinaryTree(scan);
		
	}
	/**
	 * Reads the scanner by whitespaces.
	 * Creates an array of string.Every element is an expression that number or operators.Match the string it creates with a new scanner and sends it to a private method
	 * @param scan is scanner type object
	 * @return expression tree
	 * 
	 */
	public static BinaryTree<String> readBinaryTree(Scanner scan){
		StringBuilder sb=new StringBuilder();
		while(scan.hasNext()) {
			sb.append(scan.next());
			sb.append(" ");
		}
		if(Character.isDigit(sb.toString().charAt(0))){
			String []tokens=sb.toString().split(" ");
			StringBuilder sbb=new StringBuilder();
			for(int i=tokens.length-1;i>-1;i--) {
				sbb.append(tokens[i].toString());
				sbb.append(" ");
			}
			Scanner scann=new Scanner(sbb.toString());
			return readBinaryTree(scann,0);
		}else {
			Scanner scann=new Scanner(sb.toString());
			return readBinaryTree(scann,0);
		}
	}
	
	/**
	 * If the item read by the scanner is a number, a new node is created.If not, the element read creates the left and right children respectively.
	 * @param scan is type of scanner object
	 * @param x number is unnecessary parameter used to separate two methdoes of the same name
	 * @return new binaryTree
	 */
	private static BinaryTree<String> readBinaryTree(Scanner scan,int x){  
		String data=scan.next();
		if(Character.isDigit(data.charAt(0))) {
			return new BinaryTree<String>(new Node<String>(data.toString()));
		}else {
			BinaryTree<String> left=readBinaryTree(scan,0);
			BinaryTree<String> right=readBinaryTree(scan,0);
			return new BinaryTree<>(data,left,right);
		}	
	}
	
	
	
	/**
	 *Starter method of preorder traversal
	 *@param consumer an object that instantiates
	 *theBiConsumer inetface.Its method implemenets abstract method apply
	 */
	@Override
	public void preOrderTraverse(BiConsumer<E,Integer> consumer) {
		preOrderTraverse((Node<E>) head.root,1,consumer);
	}
	/**
	 * Performs a recursive  pre-order traversal of tree,applying the action specified in the consumer object.
	 * @param node
	 * @param depth
	 * @param consumer object whose acept method specifies the action to be performed on each node
	 */
	private void preOrderTraverse(Node<E> node,int depth,BiConsumer<E,Integer> consumer) {
		if(node==null) {
			
		}else {
			consumer.accept(node.data,depth);
			preOrderTraverse(node.left,depth+1,consumer);
			preOrderTraverse(node.right,depth+1,consumer);
		}
	}

	
	/**
	 *Creates a stringBuilder object by applying the Preorder traverse method
	 */
	@Override
	public String toString(){
		
		final StringBuilder sb=new StringBuilder();
		preOrderTraverse((e,d)->{
			sb.append(e);
			sb.append(" ");
		});
		return sb.toString();	
		
	}
	
	
	/**
	 * Creates a stringBuilder object by applying the Postorder traverse method
	 * @return string of stringBuilder
	 */
	public String toString2(){	
		final StringBuilder sb=new StringBuilder();
		postOrderTraverse((e,d)->{
			sb.append(e);
			sb.append(" ");
		});
		return sb.toString();		
		
	}
	/**
	 * 	
	 *Starter method of postorder traversal
	 *@param consumer an object that instantiates
	 *theBiConsumer inetface.Its method implemenets abstract method apply
	 */
	 
	@SuppressWarnings("unchecked")
	public void postOrderTraverse(BiConsumer<E,Integer> consumer) {
		postOrderTraverse((Node<E>) head.root,consumer);
	}
	
	/**
	 * Performs a recursive  post-order traversal of tree,applying the action specified in the consumer object.
	 * @param node
	 * @param consumer object whose acept method specifies the action to be performed on each node
	 */
	private void postOrderTraverse(Node<E> node,BiConsumer<E,Integer> consumer) {
		if(node==null) {
		}else {
			postOrderTraverse(node.left,consumer);
			postOrderTraverse(node.right,consumer);
			consumer.accept(node.data,0);
		}
	}
	
/**
 * Starter eval function
 * @return
 */
@SuppressWarnings("unchecked")
public int eval() {
	return eval((Node<E>) head.root);
}
	
/**
 * Makes operations by preorder the nodes of the tree.It returns if node data is a number, .if the node data is operator, it working again for the children to the left and right
 * @param ref is refetrence type of node
 * @return result of tree
 */
private int eval(Node<E> ref)  
{  
	if(Character.isDigit(ref.data.toString().charAt(0))) {
		return Integer.parseInt(ref.data.toString());
	}else {
		int left=eval(ref.left);
		int right=eval(ref.right);
		
		
		if(ref.data.toString().charAt(0)=='+') {
			return left+right;
		}
		else if(ref.data.toString().charAt(0)=='-') {
			return left-right;
		}
		else if(ref.data.toString().charAt(0)=='*') {
			return left*right;
		}else {
			return left/right;
		}
	}
}
 

}

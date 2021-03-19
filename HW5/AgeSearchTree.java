

/**
 * @author zafer
 *Class that creates SearchTree with generic objects
 * @param <E> is generic type class.
 */
public class AgeSearchTree<E extends Comparable<E>> extends BinarySearchTree<E>{

	int counter;
	Node<E> root;
	E deleted;
	public AgeSearchTree(E item) {
		
		root=new Node<>(item);
	}
	/**
	 *If root is null, it will root the parameter it takes, if not, send it to the private method
	 */
	@Override
	public boolean add(E data) {
		if(root==null)
			root=new Node<>(data);
		else
		   root=add(root,data);
		
		return true;
	}
	/**
	 * If our reference is null, it returns a node whose data is an item.
	 * If it is not null, the data of the item and the reference are compared.
	 * if the result of the comparison is less than 0, the function works again for the left child of the referral,else if result is greather than 0
	 * the function works again for the right child of the referral,else age num of reference increases by 1
	 * @param root is reference that type of Node
	 * @param item is generic type object
	 * @return the root reference
	 */
	private Node<E> add(Node<E> root,E item){
		if(root==null) {
			return new Node<>(item);
		}
		 int x=item.compareTo(root.data);
		 if(x<0) {
			 root.left=add(root.left,item);
		 }
		 else if(x>0) {
			 root.right=add(root.right,item);
		 }
		 else {
			 if(root.data instanceof AgeData) {
				AgeData xx;
				 xx=(AgeData)root.data;
				 xx.increaseAgeNum();
			 }
			 
		 }
		 return root;
	}
	
	/**
	 *Send the root and the parameter to the private find method
	 */
	@Override
	public E find(E item) {
		return find(root,item);
	}
	/**
	 * Compares using the compareTo method.
	 * if the result is greater than zero, it will work again for the right child of the root
	 * if the result is less than zero, it will work again for the right child of the root
	 * if the result is 0,return root reference
	 * if the reference is null, the item is not in the tree
	 * 
	 * @param root is a referral of type node
	 * @param data is generic type data
	 * @return correct node
	 */
	private E find(Node<E> root,E data) {
		if(root==null) {
			System.out.println("The item was not found");
			return null;
		}
		if(data.compareTo(root.data)==0) {
			return root.data;
		}
		else if(data.compareTo(root.data)<0) {
			return find(root.left,data);
		}
		else {
			return find(root.right,data);
		}
	}
	
	
	/**
	 * Send data and reference to root to private olderThan class
	 * @param data is wanted age
	 * @return count of older than data
	 */
	@SuppressWarnings("unchecked")
	public int olderThan(int data) {
		counter=0;
		olderThan((E)new AgeData(data),root);
		return counter;		
	}
	/**
	 * If item is smaller than data of reference root, counter increases by numAge of reference.
	 * Has special condition to avoid unnecessary calls
	 * 
	 * @param data is wanted age
	 * @param ref is a referral of type node
	 */
	private void olderThan(E data,Node<E> ref) {
		if(ref==null) {
			   return;
			}
		AgeData x=new AgeData(0);
		if(ref.data instanceof AgeData) {
			x=(AgeData) ref.data;
			if(data.compareTo(ref.data)<0) {
				counter=counter+x.getAgeNum();
			}
		}
	
			if(ref.left!=null)
			  if(!(data.compareTo(ref.left.data)>0 && ref.left.right==null))
			    olderThan(data,ref.left);
			olderThan(data,ref.right);		
	}
	
	
	/**
	 * Send data and reference to root to private youngerThan class
	 * @param data is wanted age
	 * @return count of older than data
	 */
	@SuppressWarnings("unchecked")
	public int youngerThan(int data) {
		counter=0;
		youngerThan((E)new AgeData(data),root);
		return counter;
	}
	/**
	 *  If item is greather than data of reference root, counter increases by numAge of reference.
	 * Has special condition to avoid unnecessary calls
	 * @param data is wanted age
	 * @param ref is a referral of type node
	 */
	private void youngerThan(E data,Node<E> ref) {
		if(ref==null) {
		   return;
		}
		AgeData x=new AgeData(0);
		if(ref.data instanceof AgeData) {
			x=(AgeData) ref.data;
			if(data.compareTo(ref.data)>0) {
				counter=counter+x.getAgeNum();
			}
		}
		youngerThan(data,ref.left);
		if(ref.right!=null)
		 if(!(data.compareTo(ref.right.data)<0 && ref.right.left==null))
		   youngerThan(data,ref.right);
		
	}
	/**
	 *Calls the private remove class
	 */
	@Override
	public E remove(E item){
		
		remove(item,root);
		return deleted;
	}
	
	/**
	 *  Function proceed to the correct node by making a comparison and calling again for the right root if item is big or calling again the left if item is small. 
     *If age num of correct node is bigger than 1 ,it decrease ageNumby 1. 
     * If the right node has only one child, it set deleted to root data and return child.If node has 2 child. 
     *If right of left of root is null,it set the deleted to root data,set the data of root to root left data and root left shows left of root left.So the structure of the BinarySearchTree is intact. 
     *But If not,it set the delete to root data  and  calls recursive findMax method.  It proceeded to the correct node by making a comparison and calling again for the right root if item is big or calling again the left if item is small. 
     * If age num of correct node is bigger than 1 ,funcyion decrease ageNum. 
     *If the right node has only one child, It set deleted to root data and returns child.If node has 2 child. 
     *If right of left of root is null,It set the deleted to root data,sets the data of root to root left data and root left shows left of root left.So the structure of the BinarySearchTree is intact. 
     *But If not,it set the deleted to root data  and calls recursive findMax method. 
	 * 
	 * @param item is age to be wiped
	 * @param root is reference type of Node
	 * @return correct node
	 */
	private Node<E> remove(E item,Node<E> root){
		if(root==null) {
			return null;
		}
		int comp=item.compareTo(root.data);
		if(comp<0) {
			root.left=remove(item,root.left);
		}
		else if(comp>0) {
			root.right=remove(item,root.right);
		}
		else {
			AgeData x=new AgeData(0);
			if(root.data instanceof AgeData) {
				x=(AgeData) root.data;	
			}
			if(x.getAgeNum()>1) {
				x.decreaseAgeNum();
			}
			else {
				if(root.left==null) {
					deleted=root.data;
					return root.right;
				}
				else if(root.right==null) {
					deleted=root.data;
					return root.left;
				}
				else {
					if(root.left.right==null) {
						deleted=root.data;
						root.data=root.left.data;
						root.left=root.left.left;
					}
					else {
						deleted=root.data;
						root.data=findMax(root.left);
					}
				}
			}
		}
		return root;
	}
	
	
	/**
	 * Finds the highest element in the sent tree
	 * @param root is type of node
	 * @return max element
	 */
	private E findMax(Node<E> root) {
		if(root.right.right==null) {
			E temp=root.right.data;
			root.right=root.right.left;
			return temp;
		}
		return findMax(root.right);
	}
	
	/**
	 *The method that prints the tree structure as a preorder
	 */
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		toString(root,sb);
		return sb.toString();
	}
	private void toString(Node<E> root,StringBuilder sb) {

		if(root==null) {
			sb.append("null \n");
		}else {			
			if(root.data instanceof AgeData) {
				sb.append(root.toString());
			}
			else {
				sb.append(root.toString());
			}
			sb.append("\n");
			toString(root.left,sb);
			toString(root.right,sb);
		}
	}

}

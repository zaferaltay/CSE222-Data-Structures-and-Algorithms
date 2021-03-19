/**
 * @author zafer
 *
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>{

	protected boolean addReturn;
	protected E deleteReturn;
	


	public E find(E item) {
		return find(root,item);
	}
	private E find(Node<E> root,E item) {
		if(root==null) {
			return null; //bulunamadý
		}
		int comp=item.compareTo(root.data);
		if(comp<0) {
			return find(root.left,item);
		}
		else if(comp>0) {
			return find(root.right,item);
		}
		else {
			return root.data;
		}
	}
	


	public boolean add(E item) {
		root=add(root,item);
		return addReturn;
	}
	private Node<E> add(Node<E> root,E item){
		if(root==null) {
			addReturn=true;
			return new Node<>(item);
		}
		else if(item.compareTo(root.data)<0) {
			root.left=add(root.left,item);
		}
		else if(item.compareTo(root.data)>0) {
			root.right=add(root.right,item);				
		}
		else {
			addReturn=false;
		}
		return root;
	}

	public E delete(E item) {
		root=delete(root,item);
		return deleteReturn;
	}
	private Node<E> delete(Node<E> root,E item) {
		if(root==null) {
			deleteReturn=null;
		}
		int comp=item.compareTo(root.data);
		
		if(comp<0) {
			root.left=delete(root.left,item);
		}
		else if(comp>0) {
			root.right=delete(root.right,item);
		}
		else {
			if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			else {
				if(root.left.right==null) {
					root.data=root.left.data;
					root.left=root.left.left;
				}
				else {
					root.data=findLargestChild(root.left);
				}
			}
		}
		return root;
	}
	private E findLargestChild(Node<E> root) {
		
		if(root.right.right==null) {
			E temp=root.right.data;
			root.right=root.right.left;
			return temp;
		}
		return findLargestChild(root.right);
	}
	@Override
	public E remove(E item) {
		
		return null;
	}
	
}

package tests.visual;

import javax.swing.tree.DefaultMutableTreeNode;

import treeUtils.BinaryTreeNode;

public class DynamicTreeNode<E> extends DefaultMutableTreeNode
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean isLeft = true;
	protected BinaryTreeNode<E>  data;
	/** Have the children of this node been loaded yet? */
	protected boolean           hasLoaded;

	/**
	 * Constructs a new DynamicTreeNode instance with o as the user
	 * object.
	 */
	public DynamicTreeNode(Object o,boolean isLeft) {
		super(((BinaryTreeNode<E>) o).getInfo());
		data = (BinaryTreeNode<E>) o;
		this.isLeft = isLeft;

	}
	
	
	public boolean isLeft() {
		return isLeft;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
			return String.valueOf(data.getInfo());
		
	}

	public boolean isLeaf() {
		if(data.degree()==0)
			return true;
		return false;
	}

	/**
	 * If hasLoaded is false, meaning the children have not yet been
	 * loaded, loadChildren is messaged and super is messaged for
	 * the return value.
	 */
	public int getChildCount() {
		if(!hasLoaded) {
			loadChildren();
		}
		
		return data.degree();
	}

	/**
	 * Messaged the first time getChildCount is messaged.  Creates
	 * children with random names from names.
	 */
	protected void loadChildren() {
		DynamicTreeNode             newNode;
		BinaryTreeNode<E>   datas = null;
		
		int count = 0;
		if(data.degree()>0)
		{	
			
			if(data.getLeft()!=null)
			{
				datas = data.getLeft();
				newNode = new DynamicTreeNode(datas,true);


				insert(newNode, count++);
			}
			if(data.getRight()!=null)
			{
				datas = data.getRight();
				newNode = new DynamicTreeNode(datas,false);


				insert(newNode, count++);
			}
		}
		/* This node has now been loaded, mark it so. */
		hasLoaded = true;
	}
}

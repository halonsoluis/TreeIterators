package treeUtils;

import java.util.List;

import treeIterators.IIterableTree;

public interface IGeneralTree<E>{
	
	public TreeNode<E> getRoot();
	
	public boolean isEmpty();

	public int totalNodes();

	public E deleteGeneralNode(BinaryTreeNode<E> node);

	public BinaryTreeNode<E> getGeneralFather(BinaryTreeNode<E> node);

	public List<BinaryTreeNode<E>> getGeneralLeaves();

	public List<BinaryTreeNode<E>> getGeneralSons(BinaryTreeNode<E> node);

	public List<E> getGeneralSonsInfo(BinaryTreeNode<E> node);

	public boolean insertNode(BinaryTreeNode<E> node, BinaryTreeNode<E> father);
	
	public boolean insertFirstSonNode(BinaryTreeNode<E> node, BinaryTreeNode<E> father);

	/// recorridos
	public void postOrderForEach(TreeNode<E> cursor, Daemon<E> daemon,Object reference); 
	
	public void postOrderInvertedForEach(TreeNode<E> cursor, Daemon<E> daemon, Object reference); 
	
	public TreeNode<E> preOrderFirstThat(TreeNode<E> cursor, Daemon<E> daemon, Object reference); 

	public void preOrderForEach(TreeNode<E> cursor, Daemon<E> daemon, Object reference); 
	
	public void symmetricForEach(TreeNode<E> cursor, Daemon<E> daemon, Object reference);

	public int generalTreeLevel();
}

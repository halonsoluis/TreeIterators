package treeUtils;

import java.util.List;

import treeIterators.IIterableTree;

public interface IBinaryTree<E> extends IIterableTree<E>{
	
	public TreeNode<E> getRoot();
	
	public boolean isEmpty();

	public E deleteNode(BinaryTreeNode<E> node);

	public boolean divideTree(BinaryTreeNode<E> node, BinaryTree<E> treeA,
			BinaryTree<E> treeB);

	public BinaryTreeNode<E> getFather(BinaryTreeNode<E> node);

	public List<BinaryTreeNode<E>> getLeaves();

	public List<BinaryTreeNode<E>> getSons(BinaryTreeNode<E> node);

	public List<BinaryTreeNode<E>> getSubTree(BinaryTreeNode<E> node, char type);

	public boolean insertNode(BinaryTreeNode<E> node, char type,
			BinaryTreeNode<E> father);

	public int nodeLevel(BinaryTreeNode<E> node);

	public void postOrderForEach(TreeNode<E> cursor, Daemon<E> daemon,
			Object reference);

	public void postOrderInvertedForEach(TreeNode<E> cursor,
			Daemon<E> daemon, Object reference);

	public BinaryTreeNode<E> preOrderFirstThat(TreeNode<E> cursor,
			Daemon<E> daemon, Object reference);

	public void preOrderForEach(TreeNode<E> cursor, Daemon<E> daemon,
			Object reference);

	public void symmetricForEach(TreeNode<E> cursor, Daemon<E> daemon,
			Object reference);

	public int totalNodes();

	public int treeLevel();

}

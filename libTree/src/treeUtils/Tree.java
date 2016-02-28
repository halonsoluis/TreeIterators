package treeUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
abstract public class Tree<E> {
	
	@XmlElement(name="root")
	protected BinaryTreeNode<E> root;
	
	public Tree() {
		root = null;
	}

	public Tree(BinaryTreeNode<E> root) {
		this.root = root;
	}
	
	public BinaryTreeNode<E> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<E> root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return root == null;
	}
}

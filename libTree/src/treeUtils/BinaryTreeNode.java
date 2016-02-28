package treeUtils;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class BinaryTreeNode<E> extends TreeNode<E> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name="left")
	protected BinaryTreeNode<E> left;
	@XmlElement(name="right")
	protected BinaryTreeNode<E> right;
		
	public BinaryTreeNode() {
		this.info = null;
		this.left = null;
		this.right = null;
	}
	
	public BinaryTreeNode(E info) {
		this.info = info;
		this.left = null;
		this.right = null;
	}
	
	public int degree() {
		int degree = 0;
		if (left != null)
			degree++;
		if (right != null)
			degree++;
		return degree;
	}
	@XmlElement(name="info")
	public E getInfo() {
		return info;
	}
	
	@XmlAttribute(name="infoDescription")
	public String getStringDescriptionOfNode()
	{
		return info.toString();
		
	}
    public void setInfo(E info) {
		this.info = info;
	}
    
    public boolean isLeaf() {
    	return (degree() == 0);
    }  
    
    public BinaryTreeNode<E> getLeft() {
		return left;
	}
    
    public void setLeft(BinaryTreeNode<E> left) {
		this.left = left;
	}
    
    public BinaryTreeNode<E> getRight() {
		return right;
	}
    
    public void setRight(BinaryTreeNode<E> right) {
		this.right = right;
	}
    
}

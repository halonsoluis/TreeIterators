package treeIterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import treeUtils.BinaryTreeNode;
import treeUtils.IBinaryTree;
/**
 * 
 * @author Hugo Alonso Luis
 *
 * @param <E>
 */
public abstract class TreeIterator<E> implements ITreeIterator<E>{

	protected Deque<BinaryTreeNode<E>> pendingNodes;
	protected BinaryTreeNode<E> previo;
	protected IBinaryTree<E> tree;
	protected Deque<BinaryTreeNode<E>> previousNodes;
	protected int previoID;

	protected TreeIterator (IBinaryTree<E> tree2){
		tree=tree2;
		pendingNodes= new ArrayDeque<BinaryTreeNode<E>>();
		previo=null;
		previousNodes= new ArrayDeque<BinaryTreeNode<E>>();
		previoID = -1;
	}



	//--------------------------------------------------------------------

	public int nextIndex() {
		return previoID+1;
	}
	public int previousIndex() {
		return previoID;
	}

	public boolean hasPrevious() {
		if(previoID==-1)	
			return false;	//si estoy antes de la ra�z 
		return true;
	}

	public E set(E info){	//imposible llamarlo luego de eliminar o si no ha empezado el recorrido
		if(previo==null) throw new NoSuchElementException();

		E oldInfo = previo.getInfo();
		previo.setInfo(info); //cambio la informacion contenida en el ultimo nodo visitado

		return  oldInfo;
	}


	public void add(E info, boolean insertAtLeft) {

		if(tree.isEmpty() || previoID==-1) //si el �rbol est� vac�o
			tree.insertNode(new BinaryTreeNode<E>(info),'R',null); //inserto la ra�z
		else
		{
			if(previo==null) throw new NoSuchElementException(); //garantizando que anteriormente no se haya hecho una eliminaci�n
			char pos;
			if(insertAtLeft)
				pos ='L';
			else
				pos = 'G';

			tree.insertNode(new BinaryTreeNode<E>(info), pos,previo); //sino inserto un nodo a la derecha o izquierda del ultimo visitado
		}
	}

	protected void reachNode(BinaryTreeNode<E> goal) {
		previousNodes.clear();
		previoID=-1;
		pendingNodes.clear();
		while(previo!=goal)
			next();
	};

	public E nextInfo()
	{
		return next().getInfo();
	}
	public E previousInfo()
	{
		return previous().getInfo();
	}
}
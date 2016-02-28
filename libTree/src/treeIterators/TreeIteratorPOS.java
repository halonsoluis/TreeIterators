/**
 * 
 */
package treeIterators;

import java.util.NoSuchElementException;

import treeUtils.BinaryTreeNode;
import treeUtils.IBinaryTree;

/**
 * TreeIterator en PosOrden <br><br>
 *  Izquierda - Derecha - Raiz<br>
 * 
 * @author Hugo Alonso Luis
 *
 * @param <E> el tipo de datos de la info del arbol
 */
public class TreeIteratorPOS<E> extends TreeIterator<E> {

	/**
	 * Inicializa un nuevo TreeIterator en PosOrden <br><br>
	 *  Izquierda - Derecha - Raiz<br>
	 */
	public TreeIteratorPOS(IBinaryTree<E> binaryTree) {
		super(binaryTree);
	}

	//-----------------------------Implementaciones Propias------------------------

	public boolean hasNext() {
		if(pendingNodes.isEmpty() && !previousNodes.isEmpty())
		{	
			return false;
		}else
			if (tree.isEmpty())	//existe la ra�z?
				return false;
		return true;
	}

	public BinaryTreeNode<E> next() {
		//IDR

		if(previousNodes.isEmpty())
		{
			previo = (BinaryTreeNode<E>) tree.getRoot();
			while(!previo.isLeaf())
			{
				pendingNodes.push(previo);
				if(previo.getLeft()!=null)
					previo = previo.getLeft();
				else
					previo = previo.getRight();
			}

		}
		else 
		{
			previo = previousNodes.peek();
			if(pendingNodes.peek().getRight() == previo)
			{
				previo = pendingNodes.pop();

			}else
			{
				if(pendingNodes.peek().getLeft() == previo)
				{
					if(pendingNodes.peek().getRight() != null)
					{
						previo = pendingNodes.peek().getRight();
						while(!previo.isLeaf())
						{
							pendingNodes.push(previo);
							previo = previo.getLeft();
						}
					}else
					{
						previo = pendingNodes.pop();
					}
				}
			}

		}
		previousNodes.push(previo);
		previoID++;
		return previo;
	}


	public BinaryTreeNode<E> previous() {

		previo = previousNodes.pop();

		if(!previo.isLeaf())
			pendingNodes.push(previo);

		if(previousNodes.isEmpty())
			pendingNodes.clear();


		previoID--;  //actualizo el cursor
		return previo;
	}


	public E remove() {
		if (previo==null) throw new NoSuchElementException();


		E toReturn = previo.getInfo();
		BinaryTreeNode<E> borrar = previo;
		if(!previousNodes.isEmpty())
			previous();
		if(!pendingNodes.isEmpty() && pendingNodes.peek()==borrar)
			pendingNodes.pop();


		if(tree instanceof IBinaryTree<?>)
			tree.deleteNode(borrar);	//elimino el ultimo nodo visitado del arbol


		if(!pendingNodes.isEmpty() && pendingNodes.peek().isLeaf())
			pendingNodes.pop();
		previo=null;				//elimino todo rastro del nodo (necesario para tratar errores en el ADD y SET)

		return toReturn;
	}

	public void add(E info, boolean insertAtLeft) 
	{
		super.add(info,insertAtLeft);
		if(!previousNodes.isEmpty())
			reachNode(previousNodes.peek());
	}
}


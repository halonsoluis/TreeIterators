/**
 * 
 */
package treeIterators;

import java.util.NoSuchElementException;

import treeUtils.BinaryTreeNode;
import treeUtils.IBinaryTree;

/**
 * TreeIterator en orden Simetrico o EntreOrden <br><br>
 *  Izquierda - Raiz - Derecha<br>
 * 
 * @author Hugo Alonso Luis
 *
 * @param <E> el tipo de datos de la info del arbol
 */
public class TreeIteratorENTRE<E> extends TreeIterator<E> {

	/**
	 * Inicializa un nuevo TreeIterator en orden Simetrico o EntreOrden <br><br>
	 *  Izquierda - Raiz - Derecha<br>
	 */
	public TreeIteratorENTRE(IBinaryTree<E> binaryTree) {
		super(binaryTree);
	}

	//-----------------------------Implementaciones Propias------------------------


	public BinaryTreeNode<E> next() {
		if(previousNodes.isEmpty())					//estoy antes de la ra�z? :el pr�ximo ser� la ra�z
			previo = null;

		if(previousNodes.peek()==null)
		{	
			if(pendingNodes.isEmpty())
			{
				previo = (BinaryTreeNode<E>) tree.getRoot();

				while(previo.getLeft()!=null)
				{
					pendingNodes.push(previo);
					previo = previo.getLeft();
				}


				previousNodes.push(previo);

			}
		}else
		{
			if(previousNodes.peek().getRight()==null)
			{
				if(!pendingNodes.isEmpty())
				{
					previo = pendingNodes.pop();
					previousNodes.push(previo);

				}
			}else
			{
				//buscar el prox

				previo = previousNodes.peek().getRight();
				while(previo.getLeft()!=null)
				{
					pendingNodes.push(previo);
					previo = previo.getLeft();
				}
				previousNodes.push(previo);

			}
		}
		previoID++;
		return previo;

	}


	public BinaryTreeNode<E> previous() 
	{

		previo=previousNodes.pop();	// el anterior sera la cima de los nodos previos (ya visitados)


		if(previo.getLeft()!=null)
		{	pendingNodes.push(previo);
		}else
		{
			if(!pendingNodes.isEmpty() && pendingNodes.peek().getLeft() == previo)
			{
				BinaryTreeNode<E> rem = pendingNodes.pop();
				while(!pendingNodes.isEmpty() && rem == pendingNodes.peek().getLeft())
				{
					rem = pendingNodes.pop();
				}
			}
		}

		previoID--;  //actualizo el cursor

		return previo;	//devuelvo el anterior

	}

	public E remove(){
		if (previo==null) throw new NoSuchElementException();

		E toReturn = previo.getInfo();
		BinaryTreeNode<E> borrar = previo;
		if(!previousNodes.isEmpty())
			previous();
		if(pendingNodes.peek()==borrar)
			pendingNodes.pop();

		if(tree instanceof IBinaryTree<?>)
			tree.deleteNode(borrar);	//elimino el ultimo nodo visitado del arbol


		if(borrar.getRight()!=null)
		{
			BinaryTreeNode<E> goal = previousNodes.peek();
			reachNode(goal);
		}
		previo=null;				//elimino todo rastro del nodo (necesario para tratar errores en el ADD y SET)




		return toReturn;

	}


	public boolean hasNext() {

		if ((pendingNodes.isEmpty()) && (previousNodes.peek()!=null) && (previousNodes.peek().getRight()==null))
		{		return false; //si no hay nodos pendientes, y es un nodo terminal
		}
		else
			if (tree.isEmpty())	//existe la ra�z?
				return false;

		return true;
	}


	public void add(E info, boolean insertAtLeft) 
	{
		super.add(info,insertAtLeft);
		if(!previousNodes.isEmpty())
			reachNode(previousNodes.peek());
	}


}


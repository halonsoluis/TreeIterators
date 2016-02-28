package treeIterators;

import treeUtils.BinaryTreeNode;
import treeUtils.IBinaryTree;


/**
 * TreeIterator en PreOrden <br><br>
 * Raiz - Izquierda - Derecha<br>
 * 
 * @author Hugo Alonso Luis
 *
 * @param <E> el tipo de datos de la info del arbol
 */
public class TreeIteratorPRE<E> extends TreeIterator<E> {

	/**
	 * Inicializa un nuevo TreeIterator en PreOrden <br><br>
	 * Raiz - Izquierda - Derecha<br>
	 */
	public TreeIteratorPRE(IBinaryTree<E> tree){
		super(tree);
	}

	public BinaryTreeNode<E> next(){

		if(previousNodes.isEmpty())					//estoy antes de la ra�z? :el pr�ximo ser� la ra�z
		{				
			previo=(BinaryTreeNode<E>)tree.getRoot();

		}else
		{
			if (previousNodes.peek().getLeft()!=null)	//tiene hijo izquierdo?
			{
				previo=previousNodes.peek().getLeft(); 
			}
			else	//no tiene hijo izquierdo
				if (previousNodes.peek().getRight()!=null) 	//tiene hijo derecho?
				{
					previo=previousNodes.peek().getRight();		//el pr�ximo ser� el hijo derecho
					if(pendingNodes.peek()==previousNodes.peek())
						pendingNodes.pop();
				}
				else if (!pendingNodes.isEmpty())		//es una hoja; hay nodos pendientes?
					previo=pendingNodes.pop().getRight();	//el pr�ximo ser� el hijo derecho del nodo cima de los pendientes
		}


		if(previo.getRight()!=null)
			pendingNodes.push(previo);

		previoID++;
		previousNodes.push(previo);
		return previo;	
	}


	public BinaryTreeNode<E> previous(){

		previo=previousNodes.pop();	// el anterior ser� la cima de los nodos previos(ya visitados)


		if (previo==pendingNodes.peek()) //si el anterior es la cima de los nodos pendientes
			pendingNodes.pop();	//lo elimino de esta pila

		BinaryTreeNode<E> padre =tree.getFather(previo);
		if((padre!=null) 	//si el padre del anterior existe y
				&& (padre.getRight()==previo)	//es su hijo derecho y 
				&& (padre.getLeft()!=null))	//tiene hijo izquierdo:
			if (pendingNodes.peek()!=padre)	//si el padre no est� en los pendientes:
				pendingNodes.push(padre); 	//lo agrego

		previoID--;  //actualizo el cursor

		return previo;	//devuelvo el anterior
	}


	public E remove(){


		E toReturn = previo.getInfo();
		BinaryTreeNode<E> borrar = previo;
		if(pendingNodes.peek()==borrar)
			pendingNodes.pop();
		if(!previousNodes.isEmpty())
			previous();

		if(tree instanceof IBinaryTree)
			tree.deleteNode(borrar);	//elimino el ultimo nodo visitado del arbol

		previo=null;				//elimino todo rastro del nodo (necesario para tratar errores en el ADD y SET)


		return toReturn;
	}



	public boolean hasNext() {

		if ((pendingNodes.isEmpty()) && (previousNodes.peek()!=null) && (previousNodes.peek().isLeaf()))
		{		return false; //si no hay nodos pendientes, y es un nodo terminal
		}
		else
			if (tree.isEmpty())	//existe la ra�z?
				return false;

		return true;
	}




}





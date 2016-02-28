package treeIterators;

import java.util.NoSuchElementException;

import treeUtils.BinaryTreeNode;


/**
 * Interface a implementar si se desean crear nuevos iteradores de arbol
 * <br><br>
 * Presenta las funcionalidades basicas para la creacion de los treeIterators
 * <br>
 * @author Hugo Alonso Luis
 *
 * @param <E> El tipo de dato contenido en el arbol
 */
public interface ITreeIterator<E>{

	/**
	 * Inserta un nuevo nodo tomando el actual como padre y reajusta el recorrido
	 * @param info  el contenido que tendra el nuevo nodo
	 * @param insertAtLeft si el nodo se debe insertar a la izquierda 
	 */
	public void add(E info, boolean insertAtLeft);
	/**
	 * Determina si existe algun nodo pendiente de visitar en el recorrido actual. <br>
	 *  Usado para descubrir si es viable hacer una llamada a next()
	 *  @return true si es posible
	 */
	public boolean hasNext();
	/**
	 * Determina si existe algun nodo previamente visitado. <br>
	 *  Usado para descubrir si es viable hacer una llamada a previous()
	 *  @return true si es posible
	 */
	public boolean hasPrevious();
	/**
	 * Realiza un movimiento hacia adelante en el recorrido seleccionado
	 * <br><br>
	 * No debe ser invocado si no se tiene seguridad de que sea posible realizar dicho movimiento
	 * @return el nodo visitado
	 */
	public BinaryTreeNode<E> next();
	/**
	 * Realiza un movimiento hacia adelante en el recorrido seleccionado
	 * <br><br>
	 * No debe ser invocado si no se tiene seguridad de que sea posible realizar dicho movimiento
	 * @return el contenido del nodo visitado
	 */
	public E nextInfo();
	/**
	 * Devuelve la posicion del proximo nodo a visitar 
	 * @return la posicion del proximo nodo a visitar 
	 */
	public int nextIndex();
	/**
	 * Realiza un movimiento hacia atras en el recorrido seleccionado
	 * <br><br>
	 * No debe ser invocado si no se tiene seguridad de que sea posible realizar dicho movimiento
	 * @return el nodo visitado
	 */
	public BinaryTreeNode<E> previous();
	/**
	 * Realiza un movimiento hacia atras en el recorrido seleccionado
	 * <br><br>
	 * No debe ser invocado si no se tiene seguridad de que sea posible realizar dicho movimiento
	 * @return el contenido del nodo visitado
	 */
	public E previousInfo();
	/**
	 * Devuelve la posicion del nodo previamente visitado
	 * @return la posicion del nodo previamente visitado
	 */
	public int previousIndex();
	/**
	 * Elimina el nodo actual del arbol original y reajusta el recorrido
	 * 
	 * @throws NoSuchElementException <br> 
	 * 	Si se intenta eliminar un nodo que no existe,<br>
	 *  una posible causa seria llamar 2 veces seguidas a esta funcion
	 * @return el contenido del nodo eliminado
	 */
	public E remove();
	/**
	 * Sobreescribe el contenido del nodo actual
	 * 
	 * @param info nuevo contenido a colocar en este nodo
	 * @return el contenido previamente existente en este nodo
	 * @throws NoSuchElementException si el nodo no existe
	 */
	public E set(E info);


}

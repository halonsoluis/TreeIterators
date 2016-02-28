package treeIterators;

/**
 * Interface a implementar por la implementacion de arbol para usar correctamente los iteradores
 * @author Hugo Alonso Luis
 *	
 * @param <E> el tipo de dato del arbol
 */
public interface IIterableTree<E> {

	/**
	 * Crea e inicializa un nuevo iterador para este arbol
	 * @param orden el tipo de recorrido deseado
	 * @return El iterador deseado
	 */
	public ITreeIterator<E> treeIterator(TreeIteratorOrden orden);


}

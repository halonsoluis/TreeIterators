package util;

import java.util.LinkedList;

import treeIterators.ITreeIterator;
import treeIterators.TreeIteratorOrden;
import treeUtils.BinaryTree;
import treeUtils.BinaryTreeNode;
import treeUtils.Daemon;
import treeUtils.IBinaryTree;
import treeUtils.IGeneralTree;
import treeUtils.Tree;
import treeUtils.TreeNode;

public abstract class UtilFunctions {

	public static <E> IGeneralTree<Character> buildATestCharacterTree()
	{
		Daemon daemon = new Daemon()
		{
			@Override
			public boolean actionFirstThat(TreeNode cursor, Object reference) {
				BinaryTreeNode<Character> node = (BinaryTreeNode<Character>) cursor;

				if(node.getInfo().equals(reference))
					return true;
				return false;
			}

		};

		IGeneralTree<Character> arbol = new BinaryTree<Character>(new BinaryTreeNode<Character>('A'));
		arbol.insertNode(new  BinaryTreeNode<Character>('B'),  (BinaryTreeNode<Character>) arbol.getRoot());
		arbol.insertNode(new  BinaryTreeNode<Character>('C'), (BinaryTreeNode<Character>) arbol.getRoot());
		arbol.insertNode(new  BinaryTreeNode<Character>('D'), (BinaryTreeNode<Character>) arbol.getRoot());

		BinaryTreeNode<Character> padre = (BinaryTreeNode<Character>) arbol.preOrderFirstThat(arbol.getRoot(), daemon, 'B');

		arbol.insertNode(new  BinaryTreeNode<Character>('E'), padre);
		arbol.insertNode(new  BinaryTreeNode<Character>('G'), padre);

		padre = (BinaryTreeNode<Character>) arbol.preOrderFirstThat(arbol.getRoot(), daemon, 'E');
		arbol.insertNode(new  BinaryTreeNode<Character>('F'), padre);

		padre = (BinaryTreeNode<Character>) arbol.preOrderFirstThat(arbol.getRoot(), daemon, 'C');
		arbol.insertNode(new  BinaryTreeNode<Character>('H'), padre);

		padre = (BinaryTreeNode<Character>) arbol.preOrderFirstThat(arbol.getRoot(), daemon, 'H');
		arbol.insertNode(new  BinaryTreeNode<Character>('I'), padre);

		padre = (BinaryTreeNode<Character>) arbol.preOrderFirstThat(arbol.getRoot(), daemon, 'D');
		arbol.insertNode(new  BinaryTreeNode<Character>('K'), padre);



		return arbol;
	}

	public static <E> IGeneralTree<String> buildATestStringTree()
	{
		Daemon daemon = new Daemon()
		{
			@Override
			public boolean actionFirstThat(TreeNode cursor, Object reference) {
				BinaryTreeNode<String> node = (BinaryTreeNode<String>) cursor;

				if(node.getInfo().equals(reference))
					return true;
				return false;
			}

		};

		IGeneralTree<String> arbol = new BinaryTree<String>(new BinaryTreeNode<String>("A"));
		arbol.insertNode(new  BinaryTreeNode<String>("B"),  (BinaryTreeNode<String>) arbol.getRoot());
		arbol.insertNode(new  BinaryTreeNode<String>("C"), (BinaryTreeNode<String>) arbol.getRoot());
		arbol.insertNode(new  BinaryTreeNode<String>("D"), (BinaryTreeNode<String>) arbol.getRoot());

		BinaryTreeNode<String> padre = (BinaryTreeNode<String>) arbol.preOrderFirstThat(arbol.getRoot(), daemon, 'B');

		arbol.insertNode(new  BinaryTreeNode<String>("E"), padre);
		arbol.insertNode(new  BinaryTreeNode<String>("G"), padre);

		padre = (BinaryTreeNode<String>) arbol.preOrderFirstThat(arbol.getRoot(), daemon, "E");
		arbol.insertNode(new  BinaryTreeNode<String>("F"), padre);

		padre = (BinaryTreeNode<String>) arbol.preOrderFirstThat(arbol.getRoot(), daemon, "C");
		arbol.insertNode(new  BinaryTreeNode<String>("H"), padre);

		padre = (BinaryTreeNode<String>) arbol.preOrderFirstThat(arbol.getRoot(), daemon, "H");
		arbol.insertNode(new  BinaryTreeNode<String>("I"), padre);

		padre = (BinaryTreeNode<String>) arbol.preOrderFirstThat(arbol.getRoot(), daemon, "D");
		arbol.insertNode(new  BinaryTreeNode<String>("K"), padre);



		return arbol;
	}
	/**
	 * @param arbol
	 * @return
	 */
	public static IBinaryTree<Character> getBinTree()
	{	
		IGeneralTree<Character> arbol = buildATestCharacterTree();
		IBinaryTree<Character> bin = new BinaryTree<Character>(arbol.getRoot());
		return bin;
	}

	public static IBinaryTree<String> getStringBinTree()
	{	
		IGeneralTree<String> arbol = buildATestStringTree();
		IBinaryTree<String> bin = new BinaryTree<String>(arbol.getRoot());
		return bin;
	}

	public static void testNextIterator(ITreeIterator<Character> iter) {

		for(int i=0; i<10;i++)
			System.out.print(iter.next());

	}

	/**
	 * @param iter
	 */
	public static void testIterator(ITreeIterator<Character> iter) {
		writeFullTree(iter);	

		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}
		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}
		if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }
		if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }

		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}
		if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }
		if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }
		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}

		//		iter.set('Z');

		if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }

		System.out.println( "add");
		iter.add('X', true);

		writeFullTree(iter);

		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}
		System.out.println( "remove");
		iter.remove();
		if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }
		if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }
		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}

		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}

		System.out.println( "remove");
		iter.remove();

		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}

		if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }
		if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }


		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}
		System.out.println( "remove");
		iter.remove();
		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}

		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}

		//		if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }
		//		 if(iter.hasPrevious()) {System.out.print(iter.previousIndex()+ "p") ; System.out.print(iter.previous() + " "); }


		if(iter.hasNext()) { System.out.print(iter.nextIndex() + "n") ; System.out.print(iter.next()+ " ") ;}

		System.out.println( "remove");
		iter.remove();
		System.out.println();
		writeFullTree(iter);
		System.out.println();
		while(iter.hasNext())
		{
			System.out.print(iter.next() );
			System.out.print(iter.previousIndex()+ " ") ;
		}

	}
	
	/**
	 * @param iter
	 */
	private static void writeFullTree(ITreeIterator<Character> iter) {
		
		
		Integer i=0;
		while(iter.hasNext())
		{
			System.out.print(iter.next() );
			System.out.print(iter.previousIndex()+ " ") ;

			if(i++ == 5)
				iter.remove();
		}
		System.out.println();
		i=0;
		while(iter.hasPrevious())
		{
			System.out.print(iter.previousIndex() ) ;
			System.out.print(iter.previous()+ " ");

			if(i++ == 5)
			{
				System.out.println( "add");
				iter.add(String.valueOf(i).charAt(0), true);
				int a = 2;
				while(iter.hasNext() && a-->0)
				{
					System.out.print(iter.next() );
					System.out.print(iter.previousIndex()+ " ") ;
				}	
			}
		}
		System.out.println();
	}
	
	
	public static void traverseIter(IBinaryTree<String> tree) {
		ITreeIterator<String> iter = tree.treeIterator(TreeIteratorOrden.PreOrden);		
		LinkedList<String> todos = new LinkedList<String>();
		while(iter.hasNext())
		{
			String a = iter.nextInfo();
			todos.add(a);
		}
		
	}
	public static void traverseDaemon(IBinaryTree<String> tree) {
		
		Daemon daemon = new Daemon()
		{
			@Override
			public void actionForEach(TreeNode cursor, Object reference) {
				BinaryTreeNode<String> node = (BinaryTreeNode<String>) cursor;
				LinkedList<String> todos = (LinkedList<String>) reference;
				String a = node.getInfo();
				todos.add(a);
			}

		};
		LinkedList<String> todos = new LinkedList<String>();
		tree.preOrderForEach(tree.getRoot(), daemon, todos);
		
	}
	
	
}

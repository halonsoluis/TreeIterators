package tests.visual;

	import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

	public class SampleTreeModel extends DefaultTreeModel
	{
	    /**
	      * Creates a new instance of SampleTreeModel with newRoot set
	      * to the root of this model.
	      */
	    public SampleTreeModel(TreeNode newRoot) {
		super(newRoot);
	    }

	    /**
	      * Subclassed to message setString() to the changed path item.
	      */
	    public void valueForPathChanged(TreePath path, Object newValue) {
		/* Update the user object. */
		DefaultMutableTreeNode      aNode = (DefaultMutableTreeNode)path.getLastPathComponent();
	//	Object    sampleData = aNode.getUserObject();
		aNode.setUserObject(newValue);
		//sampleData = newValue;
		/* UUUhhhhh, pretty colors. */
	//	sampleData.setColor(Color.green);

		/* Since we've changed how the data is to be displayed, message
		   nodeChanged. */
		nodeChanged(aNode);
	    }
	}


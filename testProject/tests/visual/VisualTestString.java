package tests.visual;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.xml.bind.JAXBException;

import treeIterators.ITreeIterator;
import treeIterators.TreeIteratorOrden;
import treeUtils.BinaryTree;
import treeUtils.BinaryTreeNode;
import treeUtils.IBinaryTree;
import treeUtils.TreeNode;
import util.MyIO;
import util.UtilFunctions;
import util.XMLManagger;

public class VisualTestString {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu editMenu = null;
	private JMenuItem exitMenuItem = null;
	private JMenuItem cutMenuItem = null;
	private JMenuItem copyMenuItem = null;
	private JMenuItem pasteMenuItem = null;
	private JMenuItem saveMenuItem = null;
	private TreeModel treeModel= null;
	private IBinaryTree<String> arbol;  //  @jve:decl-index=0:
	private JTree jTree = null;
	private DefaultMutableTreeNode root1 = null;
	private JScrollPane jScrollPane = null;
	private JToolBar jJToolBarBar = null;
	private JButton jBtnNext = null;
	private JButton jBtnPrev = null;
	private JButton jBtnRmv = null;
	private JButton jBtnAdd = null;
	private JPanel jPnlStatus = null;
	private JLabel jLblStatus = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLblPrevio = null;
	private JLabel jLblID = null;
	private ITreeIterator<String> iterArbol = null;
	private boolean isLoadedIterator = false;
	private boolean justDelete = true;
	private JLabel jLabel2 = null;
	private JMenuItem loadMenuItem = null;
	private JMenu jLoadMenu = null;
	private JMenuItem loadMenuItem2 = null;
	private JMenuItem makeMenuItem = null;
	private JToolBar jToolBar = null;
	private JButton jBtnSet = null;
	private JMenuItem jMenuItem = null;
	private JPanel jPanelAdd = null;  //  @jve:decl-index=0:visual-constraint="414,79"
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JLabel jLabel3 = null;
	private JTextField jTextField = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private ButtonGroup jBtnGroup;  //  @jve:decl-index=0:
	protected DefaultMutableTreeNode createNewNode(TreeNode<String> node, boolean isLeft) {
		if(node==null)
		{
			node = new BinaryTreeNode<String>("*");
		}
		return new DynamicTreeNode(node,isLeft);
	}





	/**
	 * This method initializes jTree	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getJTree1() {
		if (jTree == null) {
			jTree = new JTree();
			jTree.setEnabled(true);
			jTree.setShowsRootHandles(true);
			jTree.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jTree.setForeground(SystemColor.control);
			jTree.setBackground(SystemColor.control);
			jTree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		SampleTreeModel sampleTreeModel = new SampleTreeModel(getRoot1());
		jTree.setModel(sampleTreeModel);
		jTree.setCellRenderer(new SampleTreeCellRenderer());
		return jTree;
	}
	/**
	 * This method initializes arbol1	
	 * 	
	 * @return treeUtils.BinaryTree	
	 */
	private IBinaryTree getArbol1() {
		if (arbol == null) {
			arbol = UtilFunctions.getStringBinTree();
		}
		return arbol;
	}
	/**
	 * This method initializes root1	
	 * 	
	 * @return javax.swing.tree.DefaultMutableTreeNode	
	 */
	private DefaultMutableTreeNode getRoot1() {

		root1 = createNewNode(getArbol1().getRoot(),false);

		return root1;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTree1());
		}
		return jScrollPane;
	}


	/**
	 * This method initializes jJToolBarBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJJToolBarBar() {
		if (jJToolBarBar == null) {
			jJToolBarBar = new JToolBar();
			jJToolBarBar.setLayout(new BoxLayout(getJJToolBarBar(), BoxLayout.X_AXIS));
			jJToolBarBar.add(getJBtnNext());
			jJToolBarBar.add(getJBtnPrev());
			jJToolBarBar.add(getJBtnRmv());
			jJToolBarBar.add(getJBtnAdd());
			jJToolBarBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jJToolBarBar.add(getJBtnSet());
		}
		return jJToolBarBar;
	}


	/**
	 * This method initializes jBtnNext	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtnNext() {
		if (jBtnNext == null) {
			jBtnNext = new JButton();
			jBtnNext.setText("Next");
			jBtnNext.setEnabled(false);
			jBtnNext.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("next"); // TODO Auto-generated Event stub actionPerformed()
					next();
				}
			});
		}
		return jBtnNext;
	}


	/**
	 * This method initializes jBtnPrev	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtnPrev() {
		if (jBtnPrev == null) {
			jBtnPrev = new JButton();
			jBtnPrev.setText("Prev");
			jBtnPrev.setEnabled(false);
			jBtnPrev.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("prev()"); // TODO Auto-generated Event stub actionPerformed()
					previous();
				}
			});
		}
		return jBtnPrev;
	}


	/**
	 * This method initializes jBtnRmv	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtnRmv() {
		if (jBtnRmv == null) {
			jBtnRmv = new JButton();
			jBtnRmv.setText("Remove");
			jBtnRmv.setEnabled(false);
			jBtnRmv.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("eliminando nodo()");
					String eliminado = remove();
					JOptionPane.showMessageDialog(null, "Ha sido eliminado el nodo: "+ eliminado);
					//crear mensaje de eliminacion 
					getJTree1();
				}
			});
		}
		return jBtnRmv;
	}


	/**
	 * This method initializes jBtnAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */

	private ButtonGroup getButtonGroup()
	{
		if(jBtnGroup == null)
		{jBtnGroup = new ButtonGroup();
		jBtnGroup.add(jRadioButton);
		jBtnGroup.add(jRadioButton1);
		}
		return jBtnGroup;
	}

	private JButton getJBtnAdd() {
		if (jBtnAdd == null) {
			jBtnAdd = new JButton();
			jBtnAdd.setText("Add");
			jBtnAdd.setEnabled(false);
			jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("agregar nuevo nodo"); // TODO Auto-generated Event stub actionPerformed()
					boolean isLeft = true;
					String newNode = "";
					getJPanelAdd();
					boolean cancel = false;
					while(!cancel)
					{ 	int value = JOptionPane.showConfirmDialog(null,jPanelAdd,"Crear un nuevo nodo",2);
						if(value == 0 && !jTextField.getText().isEmpty())
							{
							newNode = jTextField.getText();
							cancel=true;
							}else
								if(value!=0) cancel=true;
					}
					
					if(jRadioButton1.isSelected())
						isLeft=false;
					if(!newNode.isEmpty())
					{
						add(newNode, isLeft);
						getJTree1();
					}
					jTextField.setText("");

				}
			});
		}
		return jBtnAdd;
	}


	/**
	 * This method initializes jPnlStatus	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPnlStatus() {
		if (jPnlStatus == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.gridy = 1;
			jLabel2 = new JLabel();
			jLabel2.setText("Orden");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridwidth = 4;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints3.insets = new Insets(2, 16, 0, 16);
			gridBagConstraints3.gridwidth = 1;
			gridBagConstraints3.gridy = 3;
			jLblID = new JLabel();
			jLblID.setText("-1");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints2.insets = new Insets(2, 16, 0, 16);
			gridBagConstraints2.gridwidth = 1;
			gridBagConstraints2.gridy = 2;
			jLblPrevio = new JLabel();
			jLblPrevio.setText("ninguno");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints1.insets = new Insets(2, 16, 0, 16);
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.gridy = 3;
			jLabel1 = new JLabel();
			jLabel1.setText("ID");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.insets = new Insets(2, 16, 0, 16);
			gridBagConstraints.gridwidth = 1;
			gridBagConstraints.gridy = 2;
			jLabel = new JLabel();
			jLabel.setText("Previo");
			jLblStatus = new JLabel();
			jLblStatus.setText("Estado Actual del Recorrido");
			jPnlStatus = new JPanel();
			jPnlStatus.setLayout(new GridBagLayout());
			jPnlStatus.add(jLblStatus, gridBagConstraints11);
			jPnlStatus.add(jLabel, gridBagConstraints);
			jPnlStatus.add(jLabel1, gridBagConstraints1);
			jPnlStatus.add(jLblPrevio, gridBagConstraints2);
			jPnlStatus.add(jLblID, gridBagConstraints3);
			jPnlStatus.add(jLabel2, gridBagConstraints21);
		}
		return jPnlStatus;
	}



	/**
	 * This method initializes loadMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getLoadMenuItem() {
		if (loadMenuItem == null) {
			loadMenuItem = new JMenuItem();
			loadMenuItem.setText("Cargar Arbol");
			loadMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK, true));
			loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("cargar arbol from file"); 

					try {
						loadXMLTree();
						System.out.println("cargado"); 
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (JAXBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					getJTree1();
				}
			});
		}
		return loadMenuItem;
	}




	/**
	 * This method initializes jLoadMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJLoadMenu() {
		if (jLoadMenu == null) {
			jLoadMenu = new JMenu();
			jLoadMenu.setText("Cargar Arbol");
			jLoadMenu.add(getLoadMenuItem());
			jLoadMenu.add(getLoadMenuItem2());
		}
		return jLoadMenu;
	}




	/**
	 * This method initializes loadMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getLoadMenuItem2() {
		if (loadMenuItem2 == null) {
			loadMenuItem2 = new JMenuItem();
			loadMenuItem2.setText("Cargar Arbol de Prueba");
			loadMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK, true));
			loadMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("load default tree"); // TODO Auto-generated Event stub actionPerformed()
					arbol = null;
					getJTree1();
				}
			});
		}
		return loadMenuItem2;
	}




	/**
	 * This method initializes makeMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMakeMenuItem() {
		if (makeMenuItem == null) {
			makeMenuItem = new JMenuItem();
			makeMenuItem.setText("Crear nuevo Arbol");
			makeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK, true));
			makeMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("new tree"); // TODO Auto-generated Event stub actionPerformed()

					//pedir a usuario la raiz del arbol
					BinaryTreeNode<String> newRoot = new BinaryTreeNode<String>("borrame");
					arbol = new BinaryTree<String>(newRoot);
					getJTree1();
				}
			});
		}
		return makeMenuItem;
	}




	/**
	 * This method initializes jToolBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.add(getJScrollPane());

		}
		return jToolBar;
	}




	/**
	 * This method initializes jBtnSet	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtnSet() {
		if (jBtnSet == null) {
			jBtnSet = new JButton();
			jBtnSet.setEnabled(false);
			jBtnSet.setText("Set");
			jBtnSet.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("set()"); // TODO Auto-generated Event stub actionPerformed()
					String newNode = "";
					while(newNode.length()==0)
						newNode = JOptionPane.showInputDialog("Inserte el nuevo nodo: ");
					String oldNode = set(newNode);
					JOptionPane.showMessageDialog(null, "Ha sido sobreescrito el nodo: "+ oldNode);
					getJTree1();
				}


			});
		}
		return jBtnSet;
	}




	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("time test");
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("time test()"); // TODO Auto-generated Event stub actionPerformed()

					UtilFunctions.traverseIter(arbol);
					UtilFunctions.traverseDaemon(arbol);
				}
			});
		}
		return jMenuItem;
	}




	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelAdd() {
		if (jPanelAdd == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.gridwidth = 3;
			gridBagConstraints12.fill = GridBagConstraints.BOTH;
			gridBagConstraints12.insets = new Insets(11, 6, 0, 6);
			gridBagConstraints12.gridy = 3;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.BOTH;
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridy = 2;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.BOTH;
			gridBagConstraints7.gridy = 0;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.insets = new Insets(13, 8, 0, 6);
			gridBagConstraints7.gridx = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.insets = new Insets(12, 6, 0, 0);
			gridBagConstraints6.gridy = 0;
			jLabel3 = new JLabel();
			jLabel3.setText("Informacion del Nodo");

			jPanelAdd = new JPanel();
			jPanelAdd.setLayout(new GridBagLayout());
			jPanelAdd.setSize(new Dimension(281, 138));
			jPanelAdd.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Complete el formulario", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelAdd.add(jLabel3, gridBagConstraints6);
			jPanelAdd.add(getJTextField(), gridBagConstraints7);
			jPanelAdd.add(getJPanel2(), gridBagConstraints12);

			getButtonGroup();
		}
		return jPanelAdd;
	}





	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setText("Izquierda");
			jRadioButton.setSelected(true);
		}
		return jRadioButton;
	}





	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("Derecha");
		}
		
		
		return jRadioButton1;
	}





	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
		}
		return jTextField;
	}


	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 1;
			gridBagConstraints10.insets = new Insets(0, 11, 0, 11);
			gridBagConstraints10.gridy = 0;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.gridy = 0;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Seleccione donde insertar", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel2.add(getJRadioButton(), gridBagConstraints9);
			jPanel2.add(getJRadioButton1(), gridBagConstraints10);
		}
		return jPanel2;
	}





	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VisualTestString application = new VisualTestString();
				application.getJFrame().setVisible(true);
			}
		});
	}

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setSize(new Dimension(248, 370));
			jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setMaximumSize(new Dimension(248, 370));
			jFrame.setMinimumSize(new Dimension(248,180));
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("TreeIterator");
			jFrame.setResizable(true);
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				ToolTipManager.sharedInstance().registerComponent(jTree);
			} catch (Exception exc) {
				System.err.println("Error loading L&F: " + exc);
			}
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
			jContentPane.add(getJJToolBarBar(), null);
			jContentPane.add(getJPnlStatus(), null);
			jContentPane.add(getJToolBar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getEditMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("General");
			fileMenu.add(getJLoadMenu());
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(new JSeparator());
			fileMenu.add(getExitMenuItem());
			fileMenu.add(getMakeMenuItem());
		//	fileMenu.add(getJMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getEditMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			editMenu.setText("Activar Iterador");
			editMenu.add(getCutMenuItem());
			editMenu.add(getCopyMenuItem());
			editMenu.add(getPasteMenuItem());
		}
		return editMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Salir");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCutMenuItem() {
		if (cutMenuItem == null) {
			cutMenuItem = new JMenuItem();
			cutMenuItem.setText("PreOrden");
			cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
					Event.CTRL_MASK, true));
			cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("activando Preorden"); // TODO Auto-generated Event stub actionPerformed()
					loadPREIterator();
				}
			});
		}
		return cutMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCopyMenuItem() {
		if (copyMenuItem == null) {
			copyMenuItem = new JMenuItem();
			copyMenuItem.setText("EntreOrden");
			copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
					Event.CTRL_MASK, true));
			copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("activando EntreOrden"); // TODO Auto-generated Event stub actionPerformed()
					loadENTREIterator();
				}
			});
		}
		return copyMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getPasteMenuItem() {
		if (pasteMenuItem == null) {
			pasteMenuItem = new JMenuItem();
			pasteMenuItem.setText("PosOrden");
			pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
			pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("activando PosOrden"); // TODO Auto-generated Event stub actionPerformed()
					loadPOSIterator();
				}
			});
		}
		return pasteMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText("Guardar Arbol");
			saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
			saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("saving tree in xml file"); // TODO Auto-generated Event stub actionPerformed()
					try {
						saveXMLTree();
						System.out.println("saved");
					} catch (JAXBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return saveMenuItem;
	}




	//-----------Metodos para Interaccion
	private String remove()
	{
		String result =  iterArbol.remove();
		justDelete = true;
		activateControls();
		return  result;
	}

	private String next()
	{
		String result = iterArbol.nextInfo();
		justDelete = false;
		activateControls();
		drawPath(result);
		if(jLabel2.getText()=="PRE")
			jTree.expandRow(iterArbol.previousIndex());
		return  result;
	}
	private String previous()
	{
		jLblID.setText(String.valueOf(iterArbol.previousIndex()));
		String result =  iterArbol.previousInfo();
		jLblPrevio.setText(result.toString());
		
		justDelete = false;
		activateControls();
		if(jLabel2.getText()=="PRE")
			jTree.collapseRow(iterArbol.nextIndex());
		return  result;
	}




	/**
	 * @param result
	 */
	private void drawPath(String result) {
		jLblPrevio.setText(result.toString());
		jLblID.setText(String.valueOf(iterArbol.previousIndex()));


	}
	private void add(String newNode,boolean isLeft)
	{
		iterArbol.add(newNode,isLeft);
		activateControls();
	}

	private String set(String newNode) {

		String oldInfo = iterArbol.set(newNode);
		activateControls();
		return oldInfo;
	}
	/**
	 * inicializa la interfaz para usar un nuevo iterador
	 */
	private void init() {
		isLoadedIterator =true;
		activateControls();
		restartPath();

	}

	private void loadXMLTree() throws FileNotFoundException, JAXBException
	{
		File file = MyIO.seeDialog(false);
		if(file!=null && file.exists() & file.length()!=0)
		{
			arbol = (BinaryTree<String>) XMLManagger.loadXML(arbol,file.getAbsolutePath());
			arbol.getRoot();
		}
	}

	private void saveXMLTree() throws JAXBException, FileNotFoundException
	{
		File file =  MyIO.seeDialog(true);
		if(file!=null)
			XMLManagger.saveXML(arbol, file.getAbsolutePath());
			
			
		
	}
	private void restartPath() 
	{
		jLblPrevio.setText("ninguno");
		jLblID.setText("-1");
		justDelete = true;
	}

	private void loadPREIterator()
	{//new TreeIteratorPRE<String>(arbol);
		iterArbol = arbol.treeIterator(TreeIteratorOrden.PreOrden);
		jLabel2.setText("PRE");
		init();
	}

	private void loadENTREIterator()
	{
		iterArbol = arbol.treeIterator(TreeIteratorOrden.EntreOrden);
		jLabel2.setText("ENTRE");
		init();
	}
	private void loadPOSIterator()
	{
		iterArbol = arbol.treeIterator(TreeIteratorOrden.PosOrden);
		jLabel2.setText("POS");
		init();
	}
	private void activateControls() 
	{
		jBtnRmv.setEnabled(isLoadedIterator);
		jBtnAdd.setEnabled(isLoadedIterator);	
		jBtnNext.setEnabled(isLoadedIterator);
		jBtnPrev.setEnabled(isLoadedIterator);

		if(isLoadedIterator)	
		{
			jBtnNext.setEnabled(iterArbol.hasNext());
			jBtnPrev.setEnabled(iterArbol.hasPrevious());
			if(!jBtnNext.isEnabled() && !jBtnPrev.isEnabled())
				justDelete=true;
			jBtnRmv.setEnabled(!justDelete);
			jBtnSet.setEnabled(!justDelete);
		}	



	}
}

/**
 * 
 */
package util;

/**
 * @author nero
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.xml.bind.JAXBException;

import treeUtils.BinaryTree;


//guardar el singleton en un fichero



public class MyIO {


	public static File seeDialog(boolean isSaving){
		File file = null;
		JFileChooser chooser = new JFileChooser(); 
		chooser.addChoosableFileFilter( new Filtro_XML(){

		});
		chooser.setMultiSelectionEnabled(false);


		if(isSaving)
		{
			chooser.setApproveButtonText("Salvar");
			chooser.setDialogTitle("Salvar Arbol Binario");
		}else
		{
			chooser.setApproveButtonText("Cargar");
			chooser.setDialogTitle("Cargar Arbol Binario");	
		}
		int result = chooser.showSaveDialog(null);
		if(result == JFileChooser.APPROVE_OPTION) {
			{ 
				file = chooser.getSelectedFile(); 
				if(isSaving)
					if(!file.getAbsolutePath().endsWith(".xml") || file.getAbsolutePath().endsWith(".XML"))
						file = new File(file.getAbsolutePath() + ".xml");


			}
		}
		return file;

	}

}

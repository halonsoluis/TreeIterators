package util;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class Filtro_XML extends FileFilter{
	@Override		
	public boolean accept(File fileobj)	{
		String extension = "";

		if(fileobj.getPath().lastIndexOf('.') > 0)
			extension = fileobj.getPath().substring(
					fileobj.getPath().lastIndexOf('.') 
					+ 1).toLowerCase();

		if(extension != "")
			return extension.equals("xml");
		else
			return fileobj.isDirectory();
	}

	@Override
	public String getDescription() {
		return ".xml";
	}

}

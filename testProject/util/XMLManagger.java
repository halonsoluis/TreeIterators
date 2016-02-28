package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLManagger {

	public static void saveXML(Object object, String path) throws JAXBException, FileNotFoundException{
		
			//creacion del contexto de transformacion para la clase que se desea manipular
			JAXBContext context = JAXBContext.newInstance(object.getClass());
			
			/**
			 * creacion del objeto que se encarga de la transformacion de los objetos
			 * Java en elementos XML  
			 */
			Marshaller marshaller = context.createMarshaller();
			
			/**
			 * Indica que el formato de salida del contenido del XML
			 * se obtenga con la indentacion correspndiente
			 */
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			/**
			 * realizar el proceso de transformacion del contenido Java en XML,
			 * se realiza a partir de la clase correspondiente al elmento raiz, 
			 * y se especifica, donde se va a almacenar el contenido del XML generado
			 * 
			 * En el primer caso se almacena en el fichero "eBook.xml" 
			 * En el segundo caso se almacena en la consola 
			 */
			marshaller.marshal(object, new FileOutputStream(path));
			marshaller.marshal(object, System.out);
		
	}
	
	public static Object loadXML(Object object, String path) throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(object.getClass());
		
		//La clase que se encarga de la deserializacion del XML en Objetos Java 
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		//Metodo que se encarga de la deserializacion  
		object = unmarshaller.unmarshal(new FileInputStream(path));
				
		return object;
	}
}

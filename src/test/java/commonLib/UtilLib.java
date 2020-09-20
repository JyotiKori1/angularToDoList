package commonLib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import modules.ToDos;
import todos.todoscrud.CRUDToDoTest;

public class UtilLib {
	
	/* 
	 * This class is implemented to serve util functions
	 *  */
	
	/* Define logger to print logs */

	Logger logger = LogManager.getLogger(UtilLib.class);  
	 public Properties getFileFromResourceAsStream(String fileName)  {

	        // The class loader that loaded the class
		 Properties prop = null;
		 InputStream fis = null;
		 try {
			prop=new Properties();
			fis = this.getClass().getResourceAsStream(fileName);
			 
			// create Properties class object
			if (fis != null) {
				// load properties file into it
				prop.load(fis);
			} else {
				throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
			}
		    
		 } catch (IOException ex) {
		    System.err.print(ex);
		 }
		 
		 return prop;

	    }
	 
	 public InputStream getFileFromResourceAsStream1(String fileName) throws ToDoException{

	        // The class loader that loaded the class
	        ClassLoader classLoader = getClass().getClassLoader();
	        String path = this.getClass().getClassLoader().getResource(fileName).toExternalForm();
	        InputStream inputStream = classLoader.getResourceAsStream(fileName);
	      //  InputStream inputStream = getClass().getResourceAsStream(fileName);

	        // the stream holding the file content
	        if (inputStream == null) {
	            throw new ToDoException("file not found at the specified path, make sure file name and path are specified correctly! " + fileName);
	        } else {
	            return inputStream;
	        }

	    }
	 
	/* Fetch input file defined at resources folder */
	 public List<String> fetchTodoListFromFile()
	 {
		 List <String> itemsToAdd=new ArrayList<String>();
		
		 InputStream fis=null;
		try {
			fis = getFileFromResourceAsStream1("ToDoItems.txt");
		} catch (ToDoException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		
		 InputStreamReader isr = new InputStreamReader(fis,
                 StandardCharsets.UTF_8);
		 
         BufferedReader br = new BufferedReader(isr); 

     br.lines().forEach(line -> itemsToAdd.add(line));
     logger.info(itemsToAdd);
     try {
    	 fis.close();
		br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     return itemsToAdd;
	 }


}

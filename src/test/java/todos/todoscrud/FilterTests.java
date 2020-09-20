package todos.todoscrud;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;



import commonLib.BaseTest;
import modules.Filter;
import modules.ToDos;


public class FilterTests extends BaseTest {
	
	ToDos todo;
	
	/* This test designed to test in parallel if required */
	
	//Filter ToDo List
		 @Test
		 public void activeFilter()
		 {
			
			 todo=new ToDos(driver);
			
			 todo.entertoDoItem("test");
			 todo.entertoDoItem("filer");
			 todo.entertoDoItem("runs");
			 todo.entertoDoItem("Parallely");
			 
		  Filter filter = new Filter(driver); 
		  filter.goTo();
		
		   Assert.assertTrue(filter.verifyToDoList());
		 
		 }

}

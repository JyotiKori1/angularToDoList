package todos.todoscrud;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;



import commonLib.BaseTest;
import modules.Filter;


public class FilterTests extends BaseTest {
	
	/* This test designed to test in parallel if required */
	
	//Filter ToDo List
		 @Test
		 public void activeFilter()
		 {
			 
		
		  Filter filter = new Filter(driver); filter.goTo();
		  
		  Assert.assertTrue(filter.verifyToDoList());
		 
		 }

}

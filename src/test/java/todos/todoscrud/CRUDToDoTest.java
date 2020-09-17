package todos.todoscrud;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import commonLib.BaseTest;
import commonLib.UtilLib;
import modules.Filter;
import modules.ToDos;
import modules.TodoComplete;
import modules.TodoDelete;

public class CRUDToDoTest extends BaseTest {
	
	/* Declare data structures */
	
	UtilLib utilLib=new UtilLib();
	List <String> itemsToAdd=new ArrayList<String>();
	ToDos toDos;
	TodoComplete todoComplete;
	TodoDelete todoDelete;
	Filter filter;
	Logger logger = LogManager.getLogger(CRUDToDoTest.class);  


	@BeforeTest
	public void goTo(){
		/* Access the link */
		this.driver.get("http://todomvc.com/examples/angularjs/#/");
		toDos = new ToDos(driver);
		todoComplete= new TodoComplete(driver);
		todoDelete= new TodoDelete(driver);
		filter=new Filter(driver);

	}
	
	/* Defined Testng groups to group the dependent tests */

	@Test(groups="Sanity")
	public void addTodoItems() {
		/* This method adds the items read from the text file to add items */

		itemsToAdd=utilLib.fetchTodoListFromFile();
		logger.info(itemsToAdd);
		for(String str: itemsToAdd)
			toDos.entertoDoItem(str);
	}

	@Test(dependsOnMethods = "addTodoItems")
	public void verifyAddedItemPresentinTodoList() {
		/* Verify added elements */
		Assert.assertTrue(toDos.presentInTodoList(itemsToAdd));
	}

	@Test(dependsOnMethods = "addTodoItems")
	public void CompleteTodo()
	{
		//Verify count before Select
		int inititalCount=Integer.parseInt(toDos.counterValue1());
		//select item
		todoComplete.selectItem();
		//Verify count after Select
		int afterCount=Integer.parseInt(toDos.counterValue1());
		//Verify vount got reduced by 1
		Assert.assertTrue(afterCount==inititalCount-1);



		//Verify if item is marked with line 
		String passItem=itemsToAdd.get(0);
		boolean completedFlag=todoComplete.presentInCompletedList(passItem);
		Assert.assertTrue(completedFlag);
		Assert.assertTrue(todoComplete.sizeOfCompletedList()==1);


	}


	//Delete Item and Verify
	@Test(dependsOnMethods = "addTodoItems")
	public void deleteTodo()
	{
		// todoDelete.deleteItem();
	}


	//Filter ToDo List
	@Test(dependsOnMethods = "addTodoItems")
	public void activeFilter()
	{
		Assert.assertTrue(filter.verifyToDoList());
	}

	//Filter Completed List
	@Test(dependsOnMethods = "addTodoItems")
	public void comleteFilter()
	{
		Assert.assertTrue(filter.verifyCompletedList()>=1);
	}

}

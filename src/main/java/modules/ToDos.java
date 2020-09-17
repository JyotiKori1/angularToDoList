package modules;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToDos {
	
	 private WebDriver driver;
	    private WebDriverWait wait;
	    
	    @FindBy(xpath = "//*[@class='header']/h1[contains(text(),'todos')]")
	    private WebElement todosTitle;
	    
	    @FindBy(xpath = "//*[@placeholder='What needs to be done?']")
	    private WebElement todosCreate;
	    
	    String empname="Have Eough Sleep";
	    @FindBy(xpath="//*[@class='view']/*[contains(text(),'Have Eough Sleep')]")
	    private WebElement verifyTodosCreated;
	    
	    @FindBy(xpath="//*[@class='todo-list']/li")
	    private List<WebElement> TodosList;
	    
	    @FindBy(xpath="//*[@class='todo-count']/*[@class='ng-binding']")
	    private WebElement counter1;
	    
	    public ToDos(WebDriver driver){
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, 30);
	        PageFactory.initElements(driver, this);
	    }

	    public void entertoDoItem(String item){
	    	this.wait.until(ExpectedConditions.visibilityOf(this.todosCreate));
	        this.todosCreate.sendKeys(item);
	        todosCreate.sendKeys(Keys.ENTER);
	       
	    }
	    
	    public boolean presentInTodoList(List<String> ToDoList)
	    {
	    	List <WebElement> items= TodosList;
	    	boolean flag = false;
	    	for(WebElement el:items)
	    	{
	    		flag=false;
	    		for(String str: ToDoList)
	    		{
	    		
	    		if(el.getText().equals(str))
	    		{
	    			flag=true;
	    			break;
	    		}
	    		
	    		}
	    }
	    	return flag;
	    }
	    
	   
	    
	    public void verifyEnteredItem(String item)
	    {
	   
		   
	    	String ss=verifyTodosCreated.getText();
	    	System.out.println(ss);
	    }
	    public String counterValue1(){
	    	String num=counter1.getText();
	    	System.out.println(num);
	    	return counter1.getText();
	       
	    }

	/*
	 * @FindBy(xpath = "(//*[@type='checkbox'])[2]") private WebElement
	 * markItemComplete;
	 * 
	 * public void selectItem() { markItemComplete.click();
	 * 
	 * }
	 */
	    
	   
	    
	   
	    //Select Item For Delete
	   // @FindBy(xpath = "(//*[@type='checkbox'])[2]")
	/*
	 * @FindBy(xpath = "(//*[@class='ng-scope'])[2]") private WebElement
	 * markItemForDelete;
	 * 
	 * // @FindBy(xpath = "(//*[@type='checkbox'])[2]")
	 * 
	 * @FindBy(xpath = "(//*[@class='ng-scope'])[2]/div/button") private WebElement
	 * clickItemForDelete;
	 * 
	 * 
	 * public void deleteItem() { Actions action = new Actions(this.driver);
	 * action.moveToElement(markItemForDelete); // action.build().perform();
	 * clickItemForDelete.click(); }
	 */
	    
	    
	/*
	 * //Filter //For Ative Filter // @FindBy(xpath = "(//*[@type='checkbox'])[2]")
	 * 
	 * @FindBy(xpath = "(//*[@class='filters'])/li[2]/*[contains(text(),'Active')]")
	 * private WebElement ActiveFilter;
	 * 
	 * @FindBy(xpath="//*[@class='ng-scope']") private List<WebElement> ActiveList;
	 * 
	 * public boolean verifyToDoList() { //Click on Active Filter
	 * ActiveFilter.click();
	 * 
	 * List <WebElement> ListOfActive= ActiveList;
	 * System.out.println("ListOfActive: " +ListOfActive.size()); boolean
	 * flag=false; int ActiveCount=0; for(WebElement el:ListOfActive) {
	 * 
	 * if(el.getText()!= null) { System.out.println("Pressent");
	 * ActiveCount=ActiveCount+1;
	 * 
	 * }
	 * 
	 * } ActiveCount--; System.out.println("ActiveCount : " +ActiveCount);
	 * 
	 * //int ActiveCount=ListOfActive.size(); int
	 * ItemsLeft=Integer.parseInt(counter1.getText());
	 * System.out.println("ItemsLeft : " +ItemsLeft); if(ActiveCount==ItemsLeft)
	 * flag=true;
	 * 
	 * return flag;
	 * 
	 * 
	 * }
	 */
	    //Filter
	    //For Completed Filter
	    			
	    @FindBy(xpath = "(//*[@class='filters'])/li[3]/*[contains(text(),'Completed')]")
	    private WebElement CompletedFilter;
	    
	
	  @FindBy(xpath="//*[@class='ng-scope completed']") private List<WebElement>
	  CompletedList;
	 
	    
	
	  public void verifyCompletedList() { //Click on Active Filter
	  CompletedFilter.click();
	  
	  List <WebElement> ListOfCompleted= CompletedList;
	  System.out.println("ListOfCompleted: " +ListOfCompleted.size());
	  
	  for(WebElement el:ListOfCompleted) {
	  
	  if(el.getText()!= null) { System.out.println("Pressent");
	  
	  
	  }
	  
	  }
	  
	  }
	 
	    
	    
	  
}

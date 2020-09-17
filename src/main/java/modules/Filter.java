package modules;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Filter {

	private WebDriver driver;
    private WebDriverWait wait;
    Logger logger = LogManager.getLogger(Filter.class);  
    
    
    //Filter
    //For Ative Filter
 // @FindBy(xpath = "(//*[@type='checkbox'])[2]")
    @FindBy(xpath = "(//*[@class='filters'])/li[2]/*[contains(text(),'Active')]")
    private WebElement ActiveFilter;
    
    @FindBy(xpath="//*[@class='ng-scope']")
    private List<WebElement> ActiveList;
    
    @FindBy(xpath="//*[@class='todo-count']/*[@class='ng-binding']")
    private WebElement counter1;
    
    @FindBy(xpath = "(//*[@class='filters'])/li[3]/*[contains(text(),'Completed')]")
    private WebElement CompletedFilter;
    

    @FindBy(xpath="//*[@class='ng-scope completed']") 
    private List<WebElement> CompletedList;
 
    
    
    public Filter(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
       
        
    }
    public void goTo(){
        this.driver.get("http://todomvc.com/examples/angularjs/#/active");
    }
    public boolean verifyToDoList()
    {
    	//Click on Active Filter
    	ActiveFilter.click();
    	
    	List <WebElement> ListOfActive= ActiveList;
    	int ActiveCount=ListOfActive.size()-1;
    	boolean flag=false;
    	    	
       	int ItemsLeft=Integer.parseInt(this.counter1.getText());
    	logger.info("ItemsLeft : " +ItemsLeft);
    	
    	if(ActiveCount==ItemsLeft)
    		flag=true;
    		
    		return flag;
    
    	
    }
    
    //Filter
    //For Completed Filter
    			
 
  public int verifyCompletedList() { 
  
	//Click on Completed Filter 
	  CompletedFilter.click();
  
  List <WebElement> ListOfCompleted= CompletedList;
  logger.info("ListOfCompleted: " +ListOfCompleted.size());
  
  for(WebElement el:ListOfCompleted) {
  
  if(el.getText()!= null) { logger.info("Pressent");
   
  
  }
  }
  return ListOfCompleted.size();
  
  }
 
  }

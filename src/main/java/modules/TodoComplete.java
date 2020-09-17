package modules;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodoComplete {
	
	
	 private WebDriver driver;
	    private WebDriverWait wait;

	    @FindBy(xpath = "(//*[@type='checkbox'])[2]")
	    private WebElement markItemComplete;
	    
	   
	    
	    public TodoComplete(WebDriver driver){
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, 30);
	        PageFactory.initElements(driver, this);
	    }
	    public void selectItem() {
	    	this.markItemComplete.click();
	    	
	    }
	    //VErify if item completed marked with line
	    @FindBy(xpath="//*[@class='ng-scope completed']")
	    private List<WebElement> CompletedList;
	    
	    public boolean presentInCompletedList(String item)
	    {
	    	List <WebElement> items= CompletedList;
	    	boolean flag=false;
	    	for(WebElement el:items)
	    	{
	    		if(el.getText().equals(item))
	    		{
	    			System.out.println("Pressent");
	    		flag= true;
	    		}
	    }
	    	return flag;
	    }
	    
	    //Verify size of selected-marked with line item is as per config
	    public int sizeOfCompletedList()
	    {
	    	List <WebElement> items= CompletedList;
	    	
	    	return items.size();
	    }
}

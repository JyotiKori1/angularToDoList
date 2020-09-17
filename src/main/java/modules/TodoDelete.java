package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodoDelete {
	
	 private WebDriver driver;
	    private WebDriverWait wait;

	    @FindBy(xpath = "(//*[@class='ng-scope'])[2]")
	    private WebElement markItemForDelete;
	    
	 // @FindBy(xpath = "(//*[@type='checkbox'])[2]")
	    @FindBy(xpath = "(//*[@class='ng-scope'])[2]/div/button")
	    private WebElement clickItemForDelete;
	   
	    public TodoDelete(WebDriver driver){
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, 30);
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void deleteItem()
	    {
	    Actions action = new Actions(this.driver);
	    action.moveToElement(markItemForDelete);
	   // action.build().perform();
	    this.clickItemForDelete.click();
	    }
	    
	   
	    
	

}

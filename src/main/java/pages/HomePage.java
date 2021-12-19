package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    @FindBy(linkText = "Dropdown")
    private WebElement dropDownlink;

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public DropdownPage clickDropdownLink(){
        dropDownlink.click();
        return PageFactory.initElements(driver,DropdownPage.class);
    }
}

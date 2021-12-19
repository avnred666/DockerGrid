package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;

    @FindBy(id = "dropdown")
    private WebElement dropdownBox;

    public DropdownPage (WebDriver driver){
        this.driver = driver;
    }

    /**
     * Select class provided by Selenium support package is required to access dropdown lists
     * @param option
     */

    public void selectFromDropdown(String option){
        Select dropdownElement = new Select(dropdownBox);
        dropdownElement.selectByVisibleText(option);
    }

    public List<String> findSelectedOption(){
        Select dropdownElement = new Select(dropdownBox);
        /*Get all selected options of the dropdown > Convert to Stream > Map it to element text > collect as a string list*/
        return dropdownElement.getAllSelectedOptions().stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public void changeDropdownToMultiselect(){
        String script = "arguments[0].setAttribute('multiple','')";
        ((JavascriptExecutor)driver).executeScript(script,dropdownBox);
    }

}

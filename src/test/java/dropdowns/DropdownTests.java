package dropdowns;

import base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DropdownPage;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DropdownTests extends BaseTests {
    @Test
    public void testDropdownSelectedOption()  {
        String option = "Option 1";
        DropdownPage dropdownPage = homePage.clickDropdownLink();
        dropdownPage.selectFromDropdown(option);
        List<String> selectedOptions = dropdownPage.findSelectedOption();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(selectedOptions.size(),1,"Incorrect number of options selected");
        softAssert.assertTrue(selectedOptions.contains(option),"Incorrect option selected!");
        softAssert.assertAll();
    }

    @Test
    public void testDropdownMultiSelect()  {
        String option1 = "Option 1";
        String option2 = "Option 2";
        DropdownPage dropdownPage = homePage.clickDropdownLink();
        dropdownPage.changeDropdownToMultiselect();
        dropdownPage.selectFromDropdown(option1);
        dropdownPage.selectFromDropdown(option2);
        List<String> selectedOptions = dropdownPage.findSelectedOption();
        assertEquals(selectedOptions.size(), 2, "Number of selected items");
    }
}

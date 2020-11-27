package com.herokuapp.theinternet.checkboxespagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTest() {

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // click on checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();
        // select all checkboxes
        checkboxesPage.selectAllCheckboxes();
        // verify all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");
    }
}

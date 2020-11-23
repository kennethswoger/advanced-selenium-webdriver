package com.herokuapp.theinternet.loginpagetests;


import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {


	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");

		// open main page
		WelcomePageObject Welcomepage = new WelcomePageObject(driver, log);
		Welcomepage.openPage();


		// Click on Form Authentication link
		LoginPage loginPage = Welcomepage.clickFormAuthenticationLink();


		// enter username and password
		SecureAreaPage secureAreaPage = loginPage.logIn(username, password);


		// Verification
		String actualErrorMessage = secureAreaPage.getErrorMessageText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}

}

package com.store.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.store.PageObject.indexPage;

import junit.framework.Assert;

public class TC_indexPage_001 extends BaseClass {

	indexPage pg = new indexPage(driver);

	@Test(priority =0)
	public void VerifySignIn() throws IOException {
		logg.info("***************TestCase Verify SignIn Method*****************");
		String userName = pg.SignIn(usr, passwd);
		logg.info("Sigin happpened");
		if (userName.equals("Hello, pragya")) {
			logg.info("VerifyLogin - Passed");

			Assert.assertTrue(true);
		} else {
			logg.info("VerifyLogin - Failed");
			captureScreenShot(driver, "VerifySignIn");
			Assert.assertTrue(false);

		}

		logg.info("***************TestCase Verify Login ends*****************");

		// pg.Search();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logg.info("Search happpened");
	}

	/*
	 * @Test(priority =1) public void Perform_Scroll() {
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); pg.Scroll();
	 * }
	 */

}

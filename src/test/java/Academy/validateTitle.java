package Academy;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base{
	
	private static Logger log = LogManager.getLogger(validateTitle.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.error("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.fatal("Navigate to Home Page");
	}


	@Test
	public void validateAppTitle() throws IOException{
		LandingPage l = new LandingPage(driver);
		// compare text from browser with actual text.
		//if fail print Error
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES1234");
		//Assert.assertTrue(condition, message);
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
	
}

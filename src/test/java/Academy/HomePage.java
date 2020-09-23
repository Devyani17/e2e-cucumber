package Academy;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}


	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username,String Password,String text) {
		//one is inheritance
		//creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		log.error(text);
		log.error("iamerror");
		log.info(text, "hihi");
		lp.getLogin().click();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
	
	@DataProvider
	public Object[][] getData() {
		//Row stands for how many different data types test should run
		//Column stands for how many values per each test
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Non Restricted User";
		
		return data;
		
	}
	
}

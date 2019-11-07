package OLB;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.base;

public class SPR_Calculator extends base {
	private static Logger log = LogManager.getLogger(SPR_Calculator.class.getName());
	
//	Using Selenium WebDriver, create a Java automation project that includes 
	// tests for any/all features of the room size calculator app. (link provided below)
//	https://goodcalculators.com/room-size-calculator/
//
//	Use OOP and test automation best practices
//	Project MUST compile
//	DO NOT use Cucumber/Gherkin/or any form of BDD
//	DO NOT include ads or other apps and pages in testing
//	HINT:  Area = length * width
//	HINT:  To calculate wastage multiple Area by 0.10 and add result to Area
	
	@Test(priority = 1)
	public void launchBrowser_URL() throws IOException {
		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
		log.info("Navigated to Room size calculator page");
	}
	
	// Validate we landed on roomSizeCalculator Page
	@Test(priority = 2)
	public void validateHomePage() {
		HomePage hp = new HomePage(driver);
		String acctualText = hp.getroomSizeCalculatorBanner().getText();
		String expectedText = "Room Size Calculator - Calculate the Size of the Room";
		// choose by feet or meters to calculate
		hp.mtSelect.click();
	
		Assert.assertEquals(acctualText, expectedText);
		log.info("Landed and expected textMsgValue");
		log.error("Fail on landing");
	}

	// Validate Area A  and wastage areaA 10% per logic
	@Test(priority = 3)
	public void calculateArea_A(){
	// these data can be stored in excel or data.properties
		double widthAmt = 2;
		double lenAmt = 3;
		double widthBmt = 0;
		double lenBmt = 0;
		HomePage hp = new HomePage(driver);
	//Validate Area A perApp vs perFormula
		double area_a_perApp = hp.CalculateArea_WithMetters(widthAmt, lenAmt, widthBmt, lenBmt);
	// total area per formula
		double area_a_perFormula = hp.CalculateArea_perFormula(widthAmt, lenAmt, widthBmt, lenBmt);
		Assert.assertEquals(area_a_perApp, area_a_perFormula);
		
	//Validate Area A_10 perApp vs perFormula
		double area_a10_perApp = hp.CalculateArea10_WithMetters();
		double area_a10_perFormula = hp.CalculateArea10_perFormula(widthAmt, lenAmt, widthBmt, lenBmt);
		Assert.assertEquals(area_a10_perApp, area_a10_perFormula);
	}
	
	
	// Validate Area B per logic
	@Test(priority = 4)
	public void calculateArea_B(){
		HomePage hp = new HomePage(driver);
	// need to clear fields first
		hp.getClearBtn().click();
		
	// these data can be stored in excel or data.properties
		double widthAmt = 0;
		double lenAmt = 0;
		double widthBmt = 5;
		double lenBmt = 3;
		
	//Validate Area B perApp vs perFormula
		double area_b_perApp = hp.CalculateArea_WithMetters(widthAmt, lenAmt, widthBmt, lenBmt);
	// total area per formula
		double area_b_perFormula = hp.CalculateArea_perFormula(widthAmt, lenAmt, widthBmt, lenBmt);
		Assert.assertEquals(area_b_perApp, area_b_perFormula);
		
	//Validate Area A_10 perApp vs perFormula
		double area_b10_perApp = hp.CalculateArea10_WithMetters();
		double area_b10_perFormula = hp.CalculateArea10_perFormula(widthAmt, lenAmt, widthBmt, lenBmt);
		Assert.assertEquals(area_b10_perApp, area_b10_perFormula);
	}
	
	
	// Validate WHOLE Area excluding 'not includedArea' per logic
	@Test(priority = 5)
	public void calculateArea_whole(){
		HomePage hp = new HomePage(driver);
	// need to clear fields first
			hp.getClearBtn().click();	
	// these data can be stored in excel or data.properties
		double widthAmt = 2;
		double lenAmt = 4;
		double widthBmt = 5;
		double lenBmt = 3;
	//Validate Area B perApp vs perFormula
		double area_ab_perApp = hp.CalculateArea_WithMetters(widthAmt, lenAmt, widthBmt, lenBmt);
	// total area per formula
		double area_ab_perFormula = hp.CalculateArea_perFormula(widthAmt, lenAmt, widthBmt, lenBmt);
		Assert.assertEquals(area_ab_perApp, area_ab_perFormula);
		
	//Validate Area A_10 perApp vs perFormula
		double area_ab10_perApp = hp.CalculateArea10_WithMetters();
		double area_ab10_perFormula = hp.CalculateArea10_perFormula(widthAmt, lenAmt, widthBmt, lenBmt);
		Assert.assertEquals(area_ab10_perApp, area_ab10_perFormula);
	}
	
	
	// Validate WHOLE Area including 'not includedArea(Bath, kitchen)' per logic
		// app doesn't generate whole house Area, so even i create formula, i dont have appValue to compare
		//	double wholeArea = lenA * (widthA+widthB);


	
	// get all Len&Width default values
	
	// Validate resetButton
	
	
	//close the browser
	
	
}

package OLB;

import org.decimal4j.util.DoubleRounder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='content']/div[2]/div/h1")
	WebElement roomSizeCalculatorBanner;

	// properties
	@FindBy(id = "calculate-ft")
	WebElement ftSelect;

	@FindBy(id = "calculate-mt")
	WebElement mtSelect;
	public WebElement getByMeters() {
		return mtSelect;
	}
	
	@FindBy(id = "w-ft1")
	WebElement widthAft;
	
	@FindBy(id = "wth-m1")
	WebElement widthAmt;
	public WebElement getWidthAMt() {
		return widthAmt;
	}
	
	@FindBy(id = "wth-m2")
	WebElement widthBmt;
	public WebElement getWidthBMt() {
		return widthBmt;
	}
	
	@FindBy(id = "w-in1")
	WebElement widthAin;

	@FindBy(id = "len-ft1")
	WebElement lenAft;

	@FindBy(id = "len-m1")
	WebElement lenAmt;
	public WebElement getLenAMt() {
		return lenAmt;
	}
	
	@FindBy(id = "len-m2")
	WebElement lenBmt;
	public WebElement getLenBMt() {
		return lenBmt;
	}

	@FindBy(id = "len-in1")
	WebElement lenAin;

	@FindBy(id = "w-ft2")
	WebElement widthBft;

	@FindBy(id = "w-in2")
	WebElement widthBin;

	@FindBy(id = "len-ft2")
	WebElement lenBft;

	@FindBy(id = "len-in2")
	WebElement lenBin;

	// need to add more. Clear btn has the same id
	@FindBy(id = "SubmitAndCalculate")
	WebElement calculateBtn;
	public WebElement getCalculateBtn() {
		return calculateBtn;
	}
	
	@FindBy(xpath = "//*[@id='SubmitAndCalculate'][2]")
	WebElement clearBtn;
	public WebElement getClearBtn() {
		return clearBtn;
	}
	
	@FindBy(id = "totarea-res")
	WebElement totalArea;

	@FindBy(id = "totarea-res-10-perc")
	WebElement totalArea10;

	//
	public WebElement getroomSizeCalculatorBanner() {
		return roomSizeCalculatorBanner;
	}
	
	public WebElement getByFeet() {
		return ftSelect;
	}

	public WebElement getWidthAft() {
		return widthAft;
	}
	
	public WebElement getWidthAin() {
		return widthAin;
	}

	public WebElement getLenAft() {
		return lenAft;
	}

	public WebElement getLenAin() {
		return lenAin;
	}

	public WebElement getWidthBft() {
		return widthBft;
	}

	public WebElement getWidthBin() {
		return widthBin;
	}

	public WebElement getLenBft() {
		return lenBft;
	}

	public WebElement getLenBin() {
		return lenBin;
	}

	
	public WebElement getTotalAreaByApp() {
		return totalArea;
	}

	public WebElement getTotalArea10ByApp() {
		return totalArea10;
	}

	// ================================================================
	public void chooseByFtOrByMt(String unitNm) {
//		if((unitNm.equalsIgnoreCase("mt")) || (unitNm.equalsIgnoreCase("meters"))){
//			getByMeters().click();
//		}else {
//			getByFeet().click();
//		}
		
		if(unitNm.contains("mt")){
			getByMeters().click();
		}else {
			getByFeet().click();
		}
	}

	public double CalculateArea_WithMetters(double widthAmt,double lenAmt,double widthBmt,double lenBmt) {
		getWidthAMt().sendKeys(String.valueOf(widthAmt));
		getLenAMt().sendKeys(String.valueOf(lenAmt));
		
		getWidthBMt().sendKeys(String.valueOf(widthBmt));
		getLenBMt().sendKeys(String.valueOf(lenBmt));
		
		getCalculateBtn().click();
		String str = getTotalAreaByApp().getText();
        String[] arrOfStr = str.split(" "); 
        String areaA = arrOfStr[0];   
        double totalArea = Double.parseDouble(areaA);
		return totalArea;
	}
	
	public double CalculateArea10_WithMetters() {
		String str = getTotalArea10ByApp().getText();
        String[] arrOfStr = str.split(" "); 
        String area10 = arrOfStr[0];   
        double totalArea10 = Double.parseDouble(area10);
		System.out.println(totalArea10);
        return totalArea10;
	}
	
	
	public double CalculateArea_perFormula(double widthAmt,double lenAmt,double widthBmt,double lenBmt) {
		double totalArea = ((widthAmt * lenAmt) + (widthBmt * lenBmt));
		return totalArea;
	}
	
	public double CalculateArea10_perFormula(double widthAmt,double lenAmt,double widthBmt,double lenBmt) {
		double totalArea10Str = (((widthAmt * lenAmt) + (widthBmt * lenBmt)) * 1.1);
		double totalArea10=DoubleRounder.round(totalArea10Str, 2);
		System.out.println(totalArea10); 
		return totalArea10;
	}

	
	
}

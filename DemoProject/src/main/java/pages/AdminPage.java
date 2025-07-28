package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Page_Utility;

public class AdminPage {
	public WebDriver driver;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and@class='small-box-footer']") WebElement managenews;
	@FindBy(xpath="//a[@href='javascript:void(0)'and@class='btn btn-rounded btn-danger']") WebElement newadmin;
	@FindBy(xpath="//input[@id='username']")WebElement enterusername;
	@FindBy(xpath="//input[@id='password']")WebElement enterpassword;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="//div[@class='card-footer center']//button") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successalert;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement dismissalert;

	public AdminPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickManageAdmin()
	{
		managenews.click();
	}
	public void clickNewAdmin()
	{
		newadmin.click();
	}
	public void enterUsername(String newusername)
	{
		enterusername.sendKeys(newusername);
	}
	public void enterPassword(String newpassword)
	{
		enterpassword.sendKeys(newpassword);
	}
	public void selectType()
	{
		//Select select=new Select(usertype); 
		//select.selectByVisibleText("Staff");
		Page_Utility pageutility=new Page_Utility();
		pageutility.selectByVisibleText(usertype, "Staff");
	}
	public void save()
	{
		savebutton.click();
	}
	public Boolean alertIsDisplayed()
	{
		return successalert.isDisplayed();
	}
	public Boolean dismissAlertIsDisplayed()
	{
		return dismissalert.isDisplayed();
	}

}

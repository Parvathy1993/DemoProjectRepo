package TestScript3;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LoginPage;
import utilities.Excel_Utility;
import utilities.FakerUtility;

public class AdminTest extends Base {
	
	@Test
	public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException
	{
		
		String username=Excel_Utility.getStringData(1,0,"LoginPage");
		String password=Excel_Utility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		AdminPage adminpage=new AdminPage(driver);
		adminpage.clickManageAdmin();
		adminpage.clickNewAdmin();
		//String newusername=Excel_Utility.getStringData(1,0,"Admin");
		//String newpassword=Excel_Utility.getStringData(1,1,"Admin");
		FakerUtility fakerutility=new FakerUtility();
		String newusername=fakerutility.creatARandomFirstName();
		String newpassword=fakerutility.creatARandomLastName();
		adminpage.enterUsername(newusername);
		adminpage.enterPassword(newpassword);
		adminpage.selectType();
		adminpage.save();
		Boolean alertisdisplayed=adminpage.alertIsDisplayed();
		Assert.assertTrue(alertisdisplayed);

	}
}

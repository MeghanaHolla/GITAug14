package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelAug4\\TestData.xlsx"	, "Sheet2");
		Methods mtd = new Methods();
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			//Making changes after R1.1
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maximizeBrowserWindow();
				break;
			case "impWait":
				mtd.implementImplicitWait();
				break;
			case "navigateToApplication":
				mtd.naivgateToAUT(data[i][6]);
				break;
			case "enterUserID":
				mtd.enterUserID(data[i][5], data[i][6]);
				break;
			case "enterPassword":
				mtd.enterPassword(data[i][5], data[i][6]);
				break;
			case "clickLogin":
				mtd.clickButton(data[i][4],data[i][5]);
				break;
			case "verifyErrMsg":
				String actualMsg = mtd.getErrorMessage(data[i][4],data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeApp":
				mtd.closeApplication();
				break;
			}
		}
	}

}

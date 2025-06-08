package dataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class ExcelDataProvider {
    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return ExcelUtils.getTestData("src/test/resources/testdata/UserData.xlsx", "Sheet1");
    }
}

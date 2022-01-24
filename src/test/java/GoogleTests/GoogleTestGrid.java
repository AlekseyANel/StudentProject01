package GoogleTests;

import org.junit.Test;
import seleniumGrid.seleniumGridTest;

public class GoogleTestGrid extends seleniumGridTest {

    @Test
    public void googleTestGrid() {
        googlePage.openGooglePage();
        googlePage.enterTextForGooglePage("maven selenium java");
        googlePage.clickOnSubmit();

    }

}

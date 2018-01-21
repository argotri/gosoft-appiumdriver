package web.id.gosoft.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BukalapakApps extends PageObject {

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    WebElementFacade btnAllow;


    public void allowApps() {
        if (btnAllow.isVisible()) {
            btnAllow.click();
        }

    }

}

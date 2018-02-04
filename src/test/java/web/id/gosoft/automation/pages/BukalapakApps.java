package web.id.gosoft.automation.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import web.id.gosoft.automation.GoSoftMobileDriver;

public class BukalapakApps extends PageObject {

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    WebElementFacade btnAllow;

    @FindBy(id = "text_search")
    WebElementFacade txtSearch;


    public void allowApps() {
        if (btnAllow.isVisible()) {
            btnAllow.click();
        }
    }

    public void search(String productName){
        txtSearch.click();
        txtSearch.type(productName);
        GoSoftMobileDriver.ANDROID_DRIVER.pressKeyCode(AndroidKeyCode.ENTER);
//        ((AndroidDriver)getDriver()).pressKeyCode(AndroidKeyCode.ENTER);
    }

}

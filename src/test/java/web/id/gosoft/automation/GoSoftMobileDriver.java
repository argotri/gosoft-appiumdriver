package web.id.gosoft.automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public class GoSoftMobileDriver implements DriverSource{
    public static AndroidDriver<AndroidElement> ANDROID_DRIVER;
    public static AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private  DesiredCapabilities capabilities;
    @Override
    public WebDriver newDriver() {
        try {
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream("serenity.properties");
            prop.load(input);
            Enumeration enuKeys = prop.keys();
            capabilities = new DesiredCapabilities();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = prop.getProperty(key);
                if (key.startsWith("appium.dc")) {
//                    System.out.println(key.split(".")[1] + "= " + value);
                    capabilities.setCapability(key.split("\\.")[2], value);
                }
            }
//            capabilities.setCapability("platformName", "android");
//            capabilities.setCapability("deviceName", "device");
//            capabilities.setCapability("appActivity", " com.bukalapak.android.HomeActivity_");
//            capabilities.setCapability("appPackage", " com.bukalapak.android");
            if(!Boolean.parseBoolean(prop.getProperty("appium.usingappiumserver"))){
                // Jika appium tidak di start secara manual
                builder = new AppiumServiceBuilder();
                builder.withIPAddress("127.0.0.1");
                builder.usingPort(Integer.parseInt(prop.getProperty("appium.port")));
                builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
                builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
                builder.withCapabilities(capabilities);
                try {
                    service = AppiumDriverLocalService.buildService(builder);
                }catch (Exception e){
                    e.printStackTrace();
                }
                service.start();
            }
            ANDROID_DRIVER= new AndroidDriver(new URL("http://127.0.0.1:"+prop.getProperty("appium.port")+"/wd/hub"),capabilities);
            return ANDROID_DRIVER;
        } catch (MalformedURLException e) {
            throw new Error(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}

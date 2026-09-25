package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import com.ws.driver.DriverScript;

public class HelperUtil extends DriverScript {

        public static String captureScreenshots(WebDriver driver){
            File src =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath =
                    System.getProperty("user.dir")+""+
                            "./src/test/resources/testreports/screenshots/screen_"+System.currentTimeMillis()+".png";
            try {
                FileHandler.copy(src,new File(screenshotPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return screenshotPath;
        }
}



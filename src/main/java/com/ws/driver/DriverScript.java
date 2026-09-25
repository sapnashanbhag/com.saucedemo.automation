package com.ws.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


public class DriverScript {
        public static WebDriver driver;
        Properties prop;

        //first method (constructor) called to initialise the object
        public DriverScript(){
            try{
                //Reading from config.properties file
                File file = new File("./src/test/resources/config.properties");
                FileInputStream fis = new FileInputStream(file);
                prop = new Properties(); //if we declare proeprties here we get null pointer exception. Properties is a Class to read a properties file

                prop.load(fis); //loads the fis file

            }
            catch(Exception e){
                System.out.println("unable to load the prorperties file");
                e.printStackTrace();
            }
        }
        //launching the browser by reading from properties file.

        public void InitApplication() {
            String browser = prop.getProperty("browser");
            System.out.println(browser);
            if (browser.trim().equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.trim().equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else if (browser.trim().equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else {
                System.err.println("please check the config file for supported browsers");
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); //to handle network errors
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            launchApplication();
        }
        //used to launch application and called inside initApplication
        public void launchApplication() {

            String url = prop.getProperty("url");
            // if(url = qa) //line to be addedd if different urls for different env's
            driver.get(url);
        }


        /* method used to quit the driver */
        public void quitDriver(){
            driver.quit();
        }

    }


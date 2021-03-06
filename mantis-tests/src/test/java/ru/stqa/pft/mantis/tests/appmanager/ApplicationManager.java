package ru.stqa.pft.mantis.tests.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;
import static org.openqa.selenium.remote.BrowserType.*;

/**
 * Created by Sergei on 15.04.2016.
 */
public class ApplicationManager {
    private final String browser;
    private final Properties properties;
    WebDriver wd;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }


    public void init() throws IOException {
        String target = getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (Objects.equals(browser, FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (Objects.equals(browser, CHROME)) {
            wd = new ChromeDriver();
        } else if (Objects.equals(browser, IE)) {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));


    }

    public void stop() {
        wd.quit();
    }



}

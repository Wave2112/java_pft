package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

/**
 * Created by Sergei on 15.04.2016.
 */
public class ApplicationManager {
    private final String browser;
    WebDriver wd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ClientHelper clientHelper;
    private GroupHelper groupHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (Objects.equals(browser, FIREFOX)){
            wd = new FirefoxDriver();
        } else if (Objects.equals(browser, CHROME)){
            wd = new ChromeDriver();
        } else if (Objects.equals(browser, IE)){
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        clientHelper = new ClientHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }




    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ClientHelper getClientHelper() {
        return clientHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}

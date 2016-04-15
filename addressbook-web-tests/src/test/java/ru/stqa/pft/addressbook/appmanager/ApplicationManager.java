package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sergei on 15.04.2016.
 */
public class ApplicationManager {
    FirefoxDriver wd;
    private ClientHelper clientHelper;
    private GroupHelper groupHelper;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        clientHelper = new ClientHelper(wd);
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void gotoGroupPage() {
        clientHelper.wd.findElement(By.linkText("groups")).click();
    }

    public void returnToHomePage() {
       clientHelper.wd.findElement(By.linkText("home page")).click();
    }

    public void stop() {
        clientHelper.wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ClientHelper getClientHelper() {
        return clientHelper;
    }
}

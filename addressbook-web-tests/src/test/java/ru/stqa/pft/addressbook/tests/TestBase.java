package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import static org.openqa.selenium.remote.BrowserType.FIREFOX;

/**
 * Created by Sergei on 15.04.2016.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(FIREFOX);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}

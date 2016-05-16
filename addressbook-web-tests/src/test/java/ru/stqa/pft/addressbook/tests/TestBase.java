package ru.stqa.pft.addressbook.tests;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import static java.lang.System.getProperty;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

/**
 * Created by Sergei on 15.04.2016.
 */
public class TestBase {

    protected static final ApplicationManager app =
            new ApplicationManager(getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}

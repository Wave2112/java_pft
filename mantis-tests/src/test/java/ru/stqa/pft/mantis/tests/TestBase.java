package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.mantis.tests.appmanager.ApplicationManager;

import static java.lang.System.getProperty;


/**
 * Created by Sergei on 15.04.2016.
 */
public class TestBase {

    protected static final ApplicationManager app =
            new ApplicationManager(getProperty("browser", BrowserType.FIREFOX));

}

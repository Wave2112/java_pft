package ru.stqa.pft.addressbook.tests;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ClientDeletionTests extends TestBase {
    @BeforeMethod
    public void areThereClients() {
        if (!app.getClientHelper().isElementPresent(By.name("entry"))) {
            app.getClientHelper().initClientGeneration();
            app.getClientHelper().fillClientForm(new ClientData("tesname", "213", "teeest", "test",
                    "test", "sssss", "123", "4421", "555", "1111", "1991", "2313", "Test1"), true);
            app.getClientHelper().submitClientCreation();
        }
    }
    @Test
    public void testClientDeletion(){
        app.getNavigationHelper().goToHomePage();
        List<ClientData> before = app.getClientHelper().getClientList();
        app.getClientHelper().getClients(before.size() - 1);
        app.getClientHelper().deleteClient();
        app.getClientHelper().acceptDelete();
        app.getNavigationHelper().goToHomePage();
        List<ClientData> after = app.getClientHelper().getClientList();
        assertEquals(after.size(), before.size() - 1, "Некорректное количество клиентов");
        before.remove(before.size() - 1);
        assertEquals(after,before);
        assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));

    }
}

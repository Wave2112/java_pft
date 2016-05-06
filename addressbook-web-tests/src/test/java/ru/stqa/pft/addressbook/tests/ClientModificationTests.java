package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ClientModificationTests extends TestBase {

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
    public void testClientModification() {
        app.getNavigationHelper().goToHomePage();
        List<ClientData> before = app.getClientHelper().getClientList();
        app.getClientHelper().selectContactById(before.get(0).getId());
        app.getClientHelper().editSelectedClient();
        ClientData client = new ClientData("tesname", "213", "teeest", "test",
                "test", "sssss", "123", "4421", "555", "1111", "1991", "2313", null);
        app.getClientHelper()
                .fillClientForm(client, false);
        app.getClientHelper().submitClientCreation();
        app.getNavigationHelper().goToHomePage();
        List<ClientData> after = app.getClientHelper().getClientList();
        assertEquals(after.size(), before.size(), "Некорректное количество клиентов");
        before.remove(before.size() - 1);
        before.add(client);
        Comparator<? super ClientData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        assertEquals(after, before);
    }
}

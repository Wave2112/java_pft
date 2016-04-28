package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ClientModificationTests extends TestBase {

    @Test
    public void testClientModification() {
        app.getNavigationHelper().goToHomePage();
        app.getClientHelper().areThereClients();
        int before = app.getClientHelper().getClientCount();
        app.getClientHelper().editClient();
        app.getClientHelper()
                .fillClientForm(new ClientData("tesname", "213", "teeest", "test",
                        "test", "sssss", "123", "4421", "555", "1111", "1991", "2313", null), false);
        app.getClientHelper().submitClientCreation();
        app.getNavigationHelper().goToHomePage();
        int after = app.getClientHelper().getClientCount();
        assertEquals(after, before, "Некорректное количество клиентов");

    }
}

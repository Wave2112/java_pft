package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ClientModificationTests extends TestBase {

    @Test
    public void testClientModification() {
        app.getNavigationHelper().goToHomePage();
        app.getClientHelper().areThereClients();
        List<ClientData> before = app.getClientHelper().getClientList();
        app.getClientHelper().editClient();
        app.getClientHelper()
                .fillClientForm(new ClientData("tesname", "213", "teeest", "test",
                        "test", "sssss", "123", "4421", "555", "1111", "1991", "2313", null), false);
        app.getClientHelper().submitClientCreation();
        app.getNavigationHelper().goToHomePage();
        List<ClientData> after = app.getClientHelper().getClientList();
        assertEquals(after.size(), before.size(), "Некорректное количество клиентов");
    }
}

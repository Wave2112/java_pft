package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import java.util.HashSet;
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
        System.out.println(before);
       // app.getClientHelper().getClients(before.size() - 1);
        app.getClientHelper().editClient();
        ClientData client = new ClientData("tesname", "213", "teeest", "test",
                "test", "sssss", "123", "4421", "555", "1111", "1991", "2313", null);
        app.getClientHelper()
                .fillClientForm(client, false);
        app.getClientHelper().submitClientCreation();
        app.getNavigationHelper().goToHomePage();
        List<ClientData> after = app.getClientHelper().getClientList();
        System.out.println(after);
        assertEquals(after.size(), before.size(), "Некорректное количество клиентов");
        before.remove(before.size() - 1);
        before.add(client);
        System.out.println("before" + before);
        System.out.println("after" + before);
        assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
    }
}

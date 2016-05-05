package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ClientCreationTests  extends TestBase{


    @Test
    public void testClientCreation() {
        app.getNavigationHelper().goToHomePage();
        List<ClientData> before = app.getClientHelper().getClientList();
        app.getClientHelper().initClientGeneration();
        ClientData client = new ClientData("tesname", "213", "teeest", "test",
                "test", "sssss", "123", "4421", "555", "1111", "1991", "2313", "Test1");
        app.getClientHelper().fillClientForm(client, true);
        app.getClientHelper().submitClientCreation();
        app.getNavigationHelper().goToHomePage();
        List<ClientData> after = app.getClientHelper().getClientList();
        assertEquals(after.size(), before.size() + 1, "Некорректное количество клиентов");
        client.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(client);
        assertEquals(new HashSet<Object>(after), new HashSet<Object> (before));
    }
}

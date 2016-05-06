package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ClientCreationTests  extends TestBase{


    @Test
    public void testClientCreation() {
        app.goTo().homePage();
        List<ClientData> before = app.client().list();
        app.client().initClientGeneration();
        ClientData client = new ClientData("tesname", "213", "teeest", "test",
                "test", "sssss", "123", "4421", "555", "1111", "1991", "2313", "Test1");
        app.client().fillClientForm(client, true);
        app.client().submitClientCreation();
        app.goTo().homePage();
        List<ClientData> after = app.client().list();
        assertEquals(after.size(), before.size() + 1, "Некорректное количество клиентов");
        client.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(client);
        Comparator<? super ClientData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        assertEquals(after, before);
    }
}

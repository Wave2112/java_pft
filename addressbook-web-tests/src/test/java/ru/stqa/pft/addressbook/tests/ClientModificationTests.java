package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ClientModificationTests extends TestBase {

    @BeforeMethod
    public void areThereClients() {
        if (app.client().all().size() == 0) {
            app.client().initClientGeneration();
            app.client().fillClientForm(new ClientData()
                    .withFirstName("tesname").withMiddleName("213").withLastName("teeest").withNickName("test")
                    .withCompany("test").withAddress("sssss").withHome("123").withWork("4421")
                    .withFax("555").withDate("1111").withDate("1991").withAnnyversary("2313").withGroup("Test1"), true);
            app.client().submitClientCreation();
        }
    }

    @Test
    public void testClientModification() {
        app.goTo().homePage();
        Set<ClientData> before = app.client().all();
        ClientData deletedClient = before.iterator().next();
        app.client().selectClientById(deletedClient.getId());
        app.client().editSelectedClient();
        ClientData client = new ClientData()
                .withFirstName("tesname").withMiddleName("213").withLastName("teeest").withNickName("test")
                .withCompany("test").withAddress("sssss").withHome("123").withWork("4421")
                .withFax("555").withDate("1111").withDate("1991").withAnnyversary("2313");
        app.client()
                .fillClientForm(client, false);
        app.client().submitClientCreation();
        app.goTo().homePage();
        Set<ClientData> after = app.client().all();
        assertEquals(after.size(), before.size(), "Некорректное количество клиентов");
        before.remove(deletedClient);
        before.add(client);
        assertEquals(after, before);
    }
}

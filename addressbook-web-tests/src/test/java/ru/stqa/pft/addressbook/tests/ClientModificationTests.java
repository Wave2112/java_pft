package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;
import ru.stqa.pft.addressbook.model.Clients;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
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
        Clients before = app.client().all();
        ClientData modifiedClient = before.iterator().next();
        ClientData client = new ClientData().withId(modifiedClient.getId())
                .withFirstName("tesname").withLastName("teeest").withAddress("sssss");
        app.client().selectClientById(modifiedClient.getId());
        app.client().editSelectedClient();
        app.client()
                .fillClientForm(client, false);
        app.client().submitClientCreation();
        app.goTo().homePage();
        Clients after = app.client().all();
        assertEquals(after.size(), before.size(), "Некорректное количество клиентов");
        assertThat(after, equalTo(before.without(modifiedClient).withAdded(client)));
    }
}

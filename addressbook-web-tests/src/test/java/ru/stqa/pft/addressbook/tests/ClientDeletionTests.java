package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;
import ru.stqa.pft.addressbook.model.Clients;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ClientDeletionTests extends TestBase {
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
    public void testClientDeletion(){
        app.goTo().homePage();
        Clients before = app.client().all();
        ClientData deletedClient = before.iterator().next();
        app.client().delete(deletedClient);
        app.goTo().homePage();
        Clients after = app.client().all();
        assertEquals(after.size(), before.size() - 1, "Некорректное количество клиентов");
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedClient)));
    }

}

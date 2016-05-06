package ru.stqa.pft.addressbook.tests;


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
        if (app.client().list().size() == 0) {
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
        List<ClientData> before = app.client().list();
        int index = before.size() - 1;
        app.client().delete(index);
        app.goTo().homePage();
        List<ClientData> after = app.client().list();
        assertEquals(after.size(), before.size() - 1, "Некорректное количество клиентов");
        before.remove(index);
        assertEquals(after,before);
        assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));

    }

}

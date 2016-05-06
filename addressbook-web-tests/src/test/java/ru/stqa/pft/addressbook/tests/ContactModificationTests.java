package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void areThereClients() {
        if (app.contact().all().size() == 0) {
            app.contact().initClientGeneration();
            app.contact().fillClientForm(new ContactData()
                    .withFirstName("tesname").withMiddleName("213").withLastName("teeest").withNickName("test")
                    .withCompany("test").withAddress("sssss").withHomePhone("123").withWorkPhone("4421")
                    .withFax("555").withDate("1111").withDate("1991").withAnnyversary("2313").withGroup("Test1"), true);
            app.contact().submitClientCreation();
        }
    }

    @Test
    public void testClientModification() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData modifiedClient = before.iterator().next();
        ContactData client = new ContactData().withId(modifiedClient.getId())
                .withFirstName("tesname").withLastName("teeest").withAddress("sssss");
        app.contact().selectClientById(modifiedClient.getId());
        app.contact().editSelectedClient();
        app.contact()
                .fillClientForm(client, false);
        app.contact().submitClientCreation();
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size(), "Некорректное количество клиентов");
        assertThat(after, equalTo(before.without(modifiedClient).withAdded(client)));
    }
}

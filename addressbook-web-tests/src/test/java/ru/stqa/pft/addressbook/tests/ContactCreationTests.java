package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {


    @Test
    public void testClientCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().initClientGeneration();
        ContactData client = new ContactData()
                .withFirstName("tesname").withMiddleName("213").withLastName("teeest").withNickName("test")
                .withCompany("test").withAddress("sssss").withHomePhone("123").withMobilePhone("213131").withWorkPhone("4421")
                .withFax("555").withDate("1111").withDate("1991").withAnnyversary("2313").withGroup("Test1");
        app.contact().fillClientForm(client, true);
        app.contact().submitClientCreation();
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() + 1, "Некорректное количество клиентов");
        assertThat(after, equalTo(
                before.withAdded(client.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}

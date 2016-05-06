package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;
import ru.stqa.pft.addressbook.model.Clients;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ClientCreationTests extends TestBase {


    @Test
    public void testClientCreation() {
        app.goTo().homePage();
        Clients before = app.client().all();
        app.client().initClientGeneration();
        ClientData client = new ClientData()
                .withFirstName("tesname").withMiddleName("213").withLastName("teeest").withNickName("test")
                .withCompany("test").withAddress("sssss").withHome("123").withWork("4421")
                .withFax("555").withDate("1111").withDate("1991").withAnnyversary("2313").withGroup("Test1");
        app.client().fillClientForm(client, true);
        app.client().submitClientCreation();
        app.goTo().homePage();
        Clients after = app.client().all();
        assertEquals(after.size(), before.size() + 1, "Некорректное количество клиентов");
        assertThat(after, equalTo(
                before.withAdded(client.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}

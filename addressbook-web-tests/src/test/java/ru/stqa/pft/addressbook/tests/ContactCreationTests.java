package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {


    private final Properties properties;

    public ContactCreationTests() {
        properties = new Properties();    }

    @Test
    public void testContactCreation() throws IOException {
        String target = getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().initClientGeneration();
        File photo = new File("src/test/resources/stru.jpg");
        ContactData client = new ContactData()
                .withFirstName(properties.getProperty("web.FirstName"))
                .withMiddleName(properties.getProperty("web.MiddleName"))
                .withLastName(properties.getProperty("web.LastName"))
                .withNickName(properties.getProperty("web.NickName"))
                .withCompany(properties.getProperty("web.Company"))
                .withAddress(properties.getProperty("web.Address"))
                .withHomePhone(properties.getProperty("web.HomePhone"))
                .withMobilePhone(properties.getProperty("web.MobilePhone"))
                .withWorkPhone(properties.getProperty("web.WorkPhone"))
                .withFax(properties.getProperty("web.Fax"))
                .withDate(properties.getProperty("web.Date"))
                .withAnnyversary(properties.getProperty("web.Annyversary"))
                .withGroup(properties.getProperty("web.Group"))
                .withEmail(properties.getProperty("web.Email"))
                .withEmail2(properties.getProperty("web.Email2"))
                .withEmail3(properties.getProperty("web.Email3"))
                .withPhoto(photo);
        app.contact().fillClientForm(client, true);
        app.contact().submitClientCreation();
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() + 1, "Некорректное количество клиентов");
        assertThat(after, equalTo(
                before.withAdded(client.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}

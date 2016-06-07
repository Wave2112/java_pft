package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;
import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ContactDeletionTests extends TestBase {
    private final Properties properties;

    public ContactDeletionTests() {
        properties = new Properties();
    }

    @BeforeMethod
    public void areThereClients() throws IOException {
        String target = getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if (app.contact().all().size() == 0) {
            app.contact().initClientGeneration();
            app.contact().fillClientForm(new ContactData()
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
                    .withGroup(properties.getProperty("web.Group"))
                    .withEmail(properties.getProperty("web.Email"))
                    .withEmail2(properties.getProperty("web.Email2"))
                    .withEmail3(properties.getProperty("web.Email3")), true);
            app.contact().submitClientCreation();
        }
    }
    @Test
    public void testClientDeletion(){
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData deletedClient = before.iterator().next();
        app.contact().delete(deletedClient);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1, "Некорректное количество клиентов");
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedClient)));
    }

}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

import static java.lang.System.getProperty;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Sergei on 07.05.2016.
 */
public class ContactEmailTests extends TestBase{
    private final Properties properties;

    public ContactEmailTests() {
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
    public void testContactEmail() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllEmails(),equalTo(mergeEmails(contactInfoFromEditForm)));

    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactEmailTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String email) {
        return email.replaceAll("\\s{2,}"," ");
    }
}


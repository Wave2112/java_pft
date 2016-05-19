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
 * Created by Sergei on 06.05.2016.
 */
public class ContactPhoneTests extends TestBase {
    private final Properties properties;

    public ContactPhoneTests() {
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
                    .withAnnyversary(properties.getProperty("web.Annyversary"))
                    .withGroup(properties.getProperty("web.Group"))
                    .withEmail(properties.getProperty("web.Email"))
                    .withEmail2(properties.getProperty("web.Email2"))
                    .withEmail3(properties.getProperty("web.Email3")), true);
            app.contact().submitClientCreation();
        }
    }
    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
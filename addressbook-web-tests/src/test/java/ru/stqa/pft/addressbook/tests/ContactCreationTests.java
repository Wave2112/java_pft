package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            GroupData newGroup = new GroupData().withName("test").withHeader("test2").withFooter("test3");
            app.group().create(newGroup);
        }
    }

    private final Properties properties;

    public ContactCreationTests() {
        properties = new Properties();    }

    @Test
    public void testContactCreation() throws IOException {
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/stru.jpg");
        ContactData newContactData = new ContactData()
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
                .withEmail3(properties.getProperty("web.Email3"))
                .withPhoto(photo)
                .inGroup(groups.iterator().next());
        String target = getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        app.contact().initClientGeneration();
        app.contact().fillClientForm(newContactData, true);
        app.contact().submitClientCreation();
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size() + 1, "Некорректное количество клиентов");
        assertThat(after, equalTo(
                before.withAdded(newContactData.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
        verifyContactListInUI();
    }
}

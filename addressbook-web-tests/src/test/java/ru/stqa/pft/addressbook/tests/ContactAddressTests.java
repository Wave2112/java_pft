package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sergei on 07.05.2016.
 */
public class ContactAddressTests extends TestBase {
    @Test
    public void testContactAddresses() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAddress(),equalTo(cleaned(contactInfoFromEditForm.getAddress())));
    }

    public static String cleaned(String address){
        return address.replaceAll("\\s{2,}"," ");
    }
}


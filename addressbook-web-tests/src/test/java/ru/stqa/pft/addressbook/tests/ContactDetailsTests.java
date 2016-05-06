package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sergei on 07.05.2016.
 */
public class ContactDetailsTests extends TestBase {
    @Test
    public void testContactDetails() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactDetailsInfoForm = app.contact().infoFromEditForm(contact);
        app.contact().detailsSelectedContact();
        System.out.println(contact.getLastName());
        System.out.println(contact.getAddress());
        String contactInfo = contact.getLastName() + contact.getAddress();
        assertThat(contactInfo, equalTo(mergeDetails(contactDetailsInfoForm)));
    }

    private String mergeDetails(ContactData contact) {
        return Arrays.asList(
                contact.getLastName(),
                contact.getAddress())
                .stream().filter((s) -> ! s.equals(""))
                .collect(Collectors.joining(""));
    }

}


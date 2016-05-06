package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by Sergei on 15.04.2016.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillClientForm(ContactData contactData, boolean creation) {
        getFirstName(By.name("firstname"), contactData.getFirstName());
        getMiddleName(By.name("middlename"), contactData.getMiddleName());
        getLastName(By.name("lastname"), contactData.getLastName());
        getNickName(By.name("nickname"), contactData.getNickName());
        getCompany(By.name("company"), contactData.getCompany());
        getAddress(By.name("address"), contactData.getAddress());
        getHomePhone(By.name("home"), contactData.getHomePhone());
        getMobilePhone(By.name("mobile"), contactData.getMobilePhone());
        getWorkPhone(By.name("work"), contactData.getWorkPhone());
        getFax(By.name("fax"), contactData.getFax());
        getDate(By.name("byear"), contactData.getDate());
        getAnniversary(By.name("ayear"), contactData.getAnnyversary());
        getEmail(By.name("email"), contactData.getEmail());
        getEmail2(By.name("email2"), contactData.getEmail2());
        getEmail3(By.name("email3"), contactData.getEmail3());
        if (creation) {
            if (isElementPresent(By.name("new_group"))) {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    private void getEmail(By email, String emailString) {
        click(email);
        clear(email);
        type(email, emailString);
    }

    private void getEmail2(By email, String emailString) {
        click(email);
        clear(email);
        type(email, emailString);
    }

    private void getEmail3(By email, String emailString) {
        click(email);
        clear(email);
        type(email, emailString);
    }

    private void getDate(By date, String date2) {
        click(By.xpath("//div[@id='content']/form/select[1]//option[15]"));
        click(By.xpath("//div[@id='content']/form/select[2]//option[3]"));
        type(date, date2);
    }

    private void getAnniversary(By date, String date2) {
        click(By.xpath("//div[@id='content']/form/select[4]//option[5]"));
        click(By.xpath("//div[@id='content']/form/select[3]//option[3]"));
        type(date, date2);
    }

    private void getFax(By fax, String fax2) {
        click(fax);
        clear(fax);
        type(fax, fax2);
    }

    private void getWorkPhone(By work, String work2) {
        click(work);
        clear(work);
        type(work, work2);
    }


    private void getHomePhone(By home, String home2) {
        click(home);
        clear(home);
        type(home, home2);
    }

    private void getMobilePhone(By mobile, String mobile2) {
        click(mobile);
        clear(mobile);
        type(mobile, mobile2);
    }

    private void getAddress(By address, String address2) {
        click(address);
        clear(address);
        type(address, address2);
    }

    private void getCompany(By company, String company2) {
        click(company);
        clear(company);
        type(company, company2);
    }

    private void getNickName(By nickname, String nickName) {
        click(nickname);
        clear(nickname);
        type(nickname, nickName);
    }

    private void getLastName(By lastname, String lastName) {
        click(lastname);
        clear(lastname);
        type(lastname, lastName);
    }

    private void getMiddleName(By middlename, String middleName) {
        click(middlename);
        clear(middlename);
        type(middlename, middleName);
    }

    private void getFirstName(By firstname, String firstName) {
        click(firstname);
        clear(firstname);
        type(firstname, firstName);
    }

    public void submitClientCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }


    public void initClientGeneration() {
        click(By.linkText("add new"));
        contactCache = null;
    }


    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        contactCache = null;
    }

    public void acceptDelete() {
        wd.switchTo().alert().accept();
    }


    public void selectClientById(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
    }

    public void editSelectedContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
        contactCache = null;
    }
    public void detailsSelectedContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
    }


    public void delete(ContactData contact) {
        selectClientById(contact.getId());
        deleteContact();
        contactCache = null;
        acceptDelete();
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withHomePhone(home)
                .withMobilePhone(mobile)
                .withWorkPhone(work)
                .withEmail(email)
                .withEmail2(email2)
                .withEmail3(email3)
                .withAddress(address);
    }

    private void initContactModificationById(int id) {
        wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactData()
                    .withId(id).withFirstName(firstName).withLastName(lastName)
                    .withAddress(address)
                    .withAllPhones(allPhones)
                    .withAllEmails(allEmails));
        }
        return new Contacts(contactCache);
    }
}

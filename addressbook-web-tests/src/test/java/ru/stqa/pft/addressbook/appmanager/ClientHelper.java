package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ClientData;

/**
 * Created by Sergei on 15.04.2016.
 */
public class ClientHelper extends HelperBase {
    public int getClientCount(){
        return wd.findElements(By.name("entry")).size();
    }


    public ClientHelper(WebDriver wd) {
        super(wd);
    }

    public void fillClientForm(ClientData clientData, boolean creation) {
        getFirstName(By.name("firstname"), clientData.getFirstName());
        getMiddleName(By.name("middlename"), clientData.getMiddleName());
        getLastName(By.name("lastname"), clientData.getLastName());
        getNickName(By.name("nickname"), clientData.getNickName());
        getCompany(By.name("company"), clientData.getCompany());
        getAddress(By.name("address"), clientData.getAddress());
        getHome(By.name("home"), clientData.getHome());
        getMobile(By.name("mobile"), clientData.getMobile());
        getWork(By.name("work"), clientData.getWork());
        getFax(By.name("fax"), clientData.getFax());
        getDate(By.name("byear"), clientData.getDate());
        getAnniversary(By.name("ayear"), clientData.getAnnyversary());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(clientData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
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

    private void getWork(By work, String work2) {
        click(work);
        clear(work);
        type(work, work2);
    }

    private void getMobile(By mobile, String mobile2) {
        click(mobile);
        clear(mobile);
        type(mobile, mobile2);
    }

    private void getHome(By home, String home2) {
        click(home);
        clear(home);
        type(home, home2);
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
    }

    public void getClients() {
        click(By.id("MassCB"));
    }

    public void deleteClient() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptDelete() {
        wd.switchTo().alert().accept();
    }

    public void editClient() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void areThereClients() {
        if (! isElementPresent(By.id("maintaible"))) {
            initClientGeneration();
            fillClientForm(new ClientData("tesname", "213", "teeest", "test",
                    "test", "sssss", "123", "4421", "555", "1111", "1991", "2313", "Test1"), true);
            submitClientCreation();
            wd.findElement(By.linkText("home")).click();
        }
    }
}

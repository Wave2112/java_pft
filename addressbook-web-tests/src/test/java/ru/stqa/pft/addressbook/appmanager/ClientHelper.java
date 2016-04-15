package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ClientData;

/**
 * Created by Sergei on 15.04.2016.
 */
public class ClientHelper extends HelperBase {

    public ClientHelper(FirefoxDriver wd){
        super(wd);
    }

    public void fillClientForm(ClientData clientData) {
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
}

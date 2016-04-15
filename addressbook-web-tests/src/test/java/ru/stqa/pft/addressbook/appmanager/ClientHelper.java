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
        click(By.name("firstname"));
        clear(By.name("firstname"));
        type(By.name("firstname"),clientData.getFirstName());
        click(By.name("middlename"));
        clear(By.name("middlename"));
        type(By.name("middlename"),clientData.getMiddleName());
        click(By.name("lastname"));
        clear(By.name("lastname"));
        type(By.name("lastname"), clientData.getLastName());
        click(By.name("nickname"));
        clear(By.name("nickname"));
        type(By.name("nickname"),clientData.getNickName());
        click(By.name("company"));
        clear(By.name("company"));
        type(By.name("company"), clientData.getCompany());
        click(By.name("address"));
        clear(By.name("address"));
        type(By.name("address"), clientData.getAddress());
        click(By.name("home"));
        clear(By.name("home"));
        type(By.name("home"), clientData.getHome());
        click(By.name("mobile"));
        clear(By.name("mobile"));
        type(By.name("mobile"), clientData.getMobile());
        click(By.name("work"));
        clear(By.name("work"));
        type(By.name("work"), clientData.getWork());
        click(By.name("fax"));
        clear(By.name("fax"));
        type(By.name("fax"), clientData.getFax());
        click (By.xpath("//div[@id='content']/form/input[21]"));
    }



    public void initClientGeneration() {
        wd.findElement(By.linkText("add new")).click();
    }
}

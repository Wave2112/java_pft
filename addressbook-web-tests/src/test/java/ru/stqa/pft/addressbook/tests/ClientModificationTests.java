package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ClientModificationTests extends TestBase{

    @Test
    public void testClientModification(){
    app.returnToHomePage();
    app.getClientHelper().editClient();
    app.getClientHelper().initClientGeneration();
    app.getClientHelper()
            .fillClientForm(new ClientData("tesname", "213", "teeest", "test",
            "test", "sssss", "123", "4421", "555", "1111", "1991", "2313"));
    app.getClientHelper().submitClientCreation();
    app.returnToHomePage();
    }
}

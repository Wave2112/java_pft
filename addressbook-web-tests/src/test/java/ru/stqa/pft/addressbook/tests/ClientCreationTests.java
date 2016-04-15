package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

public class ClientCreationTests  extends TestBase{


    @Test
    public void testClientCreation() {
        app.getClientHelper().initClientGeneration();
        app.getClientHelper().fillClientForm(new ClientData("tesname", "213", "teeest", "test", "test", "sssss", "123", "4421", "555", "1111"));
        app.returnToHomePage();
    }
}

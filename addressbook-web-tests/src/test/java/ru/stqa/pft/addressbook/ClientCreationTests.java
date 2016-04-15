package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ClientCreationTests  extends TestBase{


    @Test
    public void testClientCreation() {
        initClientGeneration();
        fillClientForm(new ClientData("tesname", "213", "teeest", "test", "test", "sssss", "123", "4421", "555", "1111"));
        returnToHomePage();
    }
}

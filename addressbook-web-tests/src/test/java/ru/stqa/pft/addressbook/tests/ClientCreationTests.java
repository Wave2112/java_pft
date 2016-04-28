package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import static org.testng.Assert.assertEquals;

public class ClientCreationTests  extends TestBase{


    @Test
    public void testClientCreation() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getClientHelper().getClientCount();
        app.getClientHelper().initClientGeneration();
        app.getClientHelper()
                .fillClientForm(new ClientData("tesname", "213", "teeest", "test",
                        "test", "sssss", "123", "4421", "555", "1111", "1991", "2313", "Test1"), true);
        app.getClientHelper().submitClientCreation();
        app.getNavigationHelper().goToHomePage();
        int after = app.getClientHelper().getClientCount();
        assertEquals(after, before + 1, "Некорректное количество клиентов");
    }
}

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ClientCreationTests  extends TestBase{


    @Test
    public void testClientCreation() {
        app.getNavigationHelper().goToHomePage();
        List<ClientData> before = app.getClientHelper().getClientList();
        app.getClientHelper().initClientGeneration();
        app.getClientHelper()
                .fillClientForm(new ClientData("tesname", "213", "teeest", "test",
                        "test", "sssss", "123", "4421", "555", "1111", "1991", "2313", "Test1"), true);
        app.getClientHelper().submitClientCreation();
        app.getNavigationHelper().goToHomePage();
        List<ClientData> after = app.getClientHelper().getClientList();
        assertEquals(after.size(), before.size() + 1, "Некорректное количество клиентов");
    }
}

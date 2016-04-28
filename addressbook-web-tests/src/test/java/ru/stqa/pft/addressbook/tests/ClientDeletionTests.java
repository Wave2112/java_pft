package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClientData;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ClientDeletionTests extends TestBase {
    @Test
    public void testClientDeletion(){
        app.getNavigationHelper().goToHomePage();
        List<ClientData> before = app.getClientHelper().getClientList();
        app.getClientHelper().areThereClients();
        app.getClientHelper().getClients();
        app.getClientHelper().deleteClient();
        app.getClientHelper().acceptDelete();
        app.getNavigationHelper().goToHomePage();
        List<ClientData> after = app.getClientHelper().getClientList();
        assertEquals(after.size(), before.size() - 1, "Некорректное количество клиентов");
    }
}

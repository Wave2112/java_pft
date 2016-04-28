package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ClientDeletionTests extends TestBase {
    @Test
    public void testClientDeletion(){
        app.getNavigationHelper().goToHomePage();
        int before = app.getClientHelper().getClientCount();
        app.getClientHelper().areThereClients();
        app.getClientHelper().getClients();
        app.getClientHelper().deleteClient();
        app.getClientHelper().acceptDelete();
        app.getNavigationHelper().goToHomePage();
        int after = app.getClientHelper().getClientCount();
        assertEquals(after, before - 1, "Некорректное количество клиентов");
    }
}

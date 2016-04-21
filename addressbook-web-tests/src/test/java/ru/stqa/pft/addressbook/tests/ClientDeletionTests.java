package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Sergei on 16.04.2016.
 */
public class ClientDeletionTests extends TestBase {
    @Test
    public void testClientDeletion(){
        app.returnToHomePage();
        app.getClientHelper().getClients();
        app.getClientHelper().deleteClient();
        app.getClientHelper().acceptDelete();
    }
}
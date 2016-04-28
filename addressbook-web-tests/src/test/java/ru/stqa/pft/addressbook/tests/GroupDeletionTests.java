package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        assertEquals(after, before - 1, "Некорректное количество групп");

    }

}

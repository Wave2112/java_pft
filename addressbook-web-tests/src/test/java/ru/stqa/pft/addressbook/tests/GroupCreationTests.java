package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1", null, null));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        assertEquals(after, before + 1, "Некорректное количество групп");
    }
}

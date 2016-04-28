package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        assertEquals(after, before, "Некорректное количество групп");
    }
}

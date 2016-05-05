package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("Test1", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        assertEquals(after.size(), before.size() + 1, "Некорректное количество групп");

        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        assertEquals(new HashSet<Object> (after), new HashSet<Object> (before));
    }
}

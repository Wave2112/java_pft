package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        GroupData group = new GroupData().withName("Test1");
        app.group().create(group);
        List<GroupData> after = app.group().list();
        assertEquals(after.size(), before.size() + 1, "Некорректное количество групп");
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        assertEquals(after, before);
    }
}

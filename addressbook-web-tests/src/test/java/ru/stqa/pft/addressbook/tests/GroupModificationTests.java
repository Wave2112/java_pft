package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sergei on 16.04.2016.
 */


public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("Test1"));
        }
    }
    @Test
    public void testGroupModification(){
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        GroupData group = new GroupData()
                .withId(before.get(index).getId()).withName("Test1").withHeader("Test2").withFooter("Test3");
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        assertEquals(after.size(), before.size(), "Некорректное количество групп");
        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        assertEquals(after, before);
    }


}

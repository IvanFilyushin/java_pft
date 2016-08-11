package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test (enabled=false)
  public void testContactCreation() {

    List<ContactData> before = app.contact().list();

    app.contact().gotoAddPage();
    ContactData contact = new ContactData("name1", "name2", "name3",
            "title", "company", "address", "phone1", "phone2", "phone3",
            "test1");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(contact);
    Comparator <? super ContactData> byId=(c1,c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}



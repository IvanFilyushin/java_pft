package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().gotoAddContactPage();
    ContactData contact = new ContactData("name1", "name2", "name3",
            "title", "company", "address", "phone1", "phone2", "phone3",
            "test1");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = after.stream().max( (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
    contact.setId(max);
    before.add(contact);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}



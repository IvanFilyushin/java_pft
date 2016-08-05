package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().gotoAddContactPage();
    app.getContactHelper().createContact(new ContactData("name1", "name2", "name3",
            "title", "company", "address", "phone1", "phone2", "phone3",
            "test1"));
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);
  }

}

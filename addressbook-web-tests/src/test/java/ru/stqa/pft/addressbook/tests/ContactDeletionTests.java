package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Ольга on 26.07.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testsContactDeletion() {

    app.getContactHelper().returnToHomePage();

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().gotoAddContactPage();
      app.getContactHelper().createContact(new ContactData("name1", "name2", "name3",
              "title", "company", "address", "phone1", "phone2", "phone3",
              "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    before.remove(before.size() - 1);
    Assert.assertEquals(after,before);

  }
}

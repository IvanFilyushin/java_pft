package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    int before=app.getContactHelper().getContactCount();
    app.getContactHelper().gotoAddContactPage();
    app.getContactHelper().createContact(new ContactData("name1", "name2", "name3",
            "title", "company", "address", "phone1", "phone2", "phone3",
            "test1"));
    int after=app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before+1);
  }

}

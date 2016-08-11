package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Ольга on 28.07.2016.
 */
public class AllContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().returnToHomePage();
    if (app.contact().list().size() == 0) {
      app.contact().gotoAddPage();
      app.contact().create(new ContactData("name1", "name2", "name3",
              "title", "company", "address", "phone1", "phone2", "phone3",
              "test1"));
    }
  }
  @Test
  public void testAllContactDeletionTest() {

    app.contact().allContacts();
    app.contact().delete();
    app.contact().returnToHomePage();
    int after = app.contact().count();
    Assert.assertEquals(after, 0);
  }

}

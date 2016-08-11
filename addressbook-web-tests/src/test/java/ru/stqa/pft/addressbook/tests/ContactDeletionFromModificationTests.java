package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Ольга on 28.07.2016.
 */
public class ContactDeletionFromModificationTests extends TestBase{

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
  public void testsContactDeletionFromModification(){
    List<ContactData> before = app.contact().list();
//    подобрать название метода для трёх строчек
    app.contact().gotoModification();
    app.contact().deleteFromModification();
    app.contact().returnToHomePage();

    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(0);
    Assert.assertEquals(after,before);

  }
}

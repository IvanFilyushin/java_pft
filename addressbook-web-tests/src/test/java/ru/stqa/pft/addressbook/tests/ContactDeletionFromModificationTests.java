package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by Ольга on 28.07.2016.
 */
public class ContactDeletionFromModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().returnToHomePage();
    if (app.contact().list().size() == 0) {
      app.contact().gotoAddPage();
      app.contact().create(new ContactData().withFirstName("name1").withLastName("name2")
              .withNickName("name3").withTitle("title").withCompany("company").withAddress("address")
              .withPhone1("phone1").withPhone2("phone2").withPhone3("phone3").withGroup("test1"));
    }
  }

  @Test
  public void testsContactDeletionFromModification(){
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
//    подобрать название метода для трёх строчек
    app.contact().gotoModification(deletedContact.getId());
    app.contact().deleteFromModification();
    app.contact().returnToHomePage();

    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(deletedContact);
    Assert.assertEquals(after,before);

  }
}

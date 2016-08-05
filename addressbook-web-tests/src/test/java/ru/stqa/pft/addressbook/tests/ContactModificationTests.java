package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Ольга on 26.07.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test

  public void testsContactModification(){
    app.getContactHelper().returnToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().gotoAddContactPage();
      app.getContactHelper().createContact(new ContactData("name1", "name2", "name3",
              "title", "company", "address", "phone1", "phone2", "phone3",
              "test1"));
    }
    int before=app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before-1);
    app.getContactHelper().gotoModificationContactPage();
    app.getContactHelper().fillContactForm(new ContactData("rename", "name2", "name3", "title", "company",
            "address", "phone1", "phone2", "phone3",
            null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    int after=app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);

  }

}

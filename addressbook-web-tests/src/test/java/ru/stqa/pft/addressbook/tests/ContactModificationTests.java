package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Ольга on 26.07.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test

  public void testsContactModification(){
    app.getContactHelper().returnToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().gotoModificationContactPage();
    app.getContactHelper().fillContactForm(new ContactData("rename", "name2", "name3", "title", "company", "address", "phone1", "phone2", "phone3"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }

}

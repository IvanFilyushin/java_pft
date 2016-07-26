package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app2.getNavigationHelper2().gotoContactPage();
    app2.getContactHelper().fillContactForm(new ContactData("name1", "name2", "name3", "title", "company", "address", "phone1", "phone2", "phone3"));
    app2.getContactHelper().submitContactCreation();
    app2.getContactHelper().returnToHomePage();
  }

}

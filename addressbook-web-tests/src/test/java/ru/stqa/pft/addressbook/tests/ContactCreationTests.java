package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app2.gotoContactPage();
    app2.fillContactForm(new ContactData("name1", "name2", "name3", "title", "company", "address", "phone1", "phone2", "phone3"));
    app2.submitContactCreation();
    app2.returnToHomePage();
  }

}

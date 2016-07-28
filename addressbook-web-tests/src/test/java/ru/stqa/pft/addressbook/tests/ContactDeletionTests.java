package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Ольга on 26.07.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testsContactDeletion() {

    app.getContactHelper().returnToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().returnToHomePage();

  }
}

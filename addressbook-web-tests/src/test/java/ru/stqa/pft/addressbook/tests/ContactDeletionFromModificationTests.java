package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Ольга on 28.07.2016.
 */
public class ContactDeletionFromModificationTests extends TestBase{

  @Test
  public void testsContactDeletionFromModification(){

    app.getNavigationHelper().returnToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().gotoModificationContactPage();
    app.getContactHelper().deleteContactModification();
    app.getNavigationHelper().returnToHomePage();

  }
}

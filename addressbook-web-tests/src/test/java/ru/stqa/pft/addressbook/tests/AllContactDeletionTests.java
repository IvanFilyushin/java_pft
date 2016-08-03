package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Ольга on 28.07.2016.
 */
public class AllContactDeletionTests extends TestBase {

  @Test

  public void testAllContactDeletionTest(){

    app.getNavigationHelper().returnToHomePage();
    app.getContactHelper().selectAllContacts();
    app.getContactHelper().deleteSelectedContacts();
 //   app.getContactHelper().alert();
    app.getNavigationHelper().returnToHomePage();
  }


}

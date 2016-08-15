package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Ольга on 15.08.2016.
 */
public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones() {

    app.contact().returnToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    if ((contact.getPhone1() == contactInfoFromEditForm.getPhone1()) &&
            (contact.getPhone2() == contactInfoFromEditForm.getPhone2()) &&
            (contact.getPhone3() == contactInfoFromEditForm.getPhone3())){
  int i=0;
    }

  }
}

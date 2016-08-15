package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Ольга on 15.08.2016.
 */
public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones() {

    app.contact().returnToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getPhone1(), equalTo(clened(contactInfoFromEditForm.getPhone1())));
    assertThat(contact.getPhone2(), equalTo(clened(contactInfoFromEditForm.getPhone2())));
    assertThat(contact.getPhone3(), equalTo(clened(contactInfoFromEditForm.getPhone3())));
  }

  public String clened(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}

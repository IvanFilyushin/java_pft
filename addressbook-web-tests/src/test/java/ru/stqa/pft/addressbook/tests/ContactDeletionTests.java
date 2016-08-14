package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Ольга on 26.07.2016.
 */
public class ContactDeletionTests extends TestBase {

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
  public void testsContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().deleteContact(deletedContact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()-1));
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}

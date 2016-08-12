package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Ольга on 26.07.2016.
 */
public class ContactModificationTests extends TestBase {

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
  public void testsContactModification() {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withId(before.get(0).getId()).withFirstName("rename")
            .withLastName("name2").withNickName("name3").withTitle("title").withCompany("company")
            .withAddress("address").withPhone1("phone1").withPhone2("phone2").withPhone3("phone3");
    app.contact().modify(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(0);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);

  }

}

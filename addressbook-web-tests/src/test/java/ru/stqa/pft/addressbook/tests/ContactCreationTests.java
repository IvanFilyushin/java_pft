package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    Set<ContactData> before = app.contact().all();

    app.contact().gotoAddPage();
    ContactData contact = new ContactData().withFirstName("name1")
            .withLastName("name2").withNickName("name3").withTitle("title").withCompany("company")
            .withAddress("address").withPhone1("phone1").withPhone2("phone2").withPhone3("phone3")
            .withGroup("test1");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);


    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);

    Assert.assertEquals(before, after);

  }
}



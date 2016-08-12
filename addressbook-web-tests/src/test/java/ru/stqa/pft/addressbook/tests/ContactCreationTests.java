package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test (enabled=false)
  public void testContactCreation() {

    List<ContactData> before = app.contact().list();

    app.contact().gotoAddPage();
    ContactData contact = new ContactData().withId(before.get(0).getId()).withFirstName("rename")
            .withLastName("name2").withNickName("name3").withTitle("title").withCompany("company")
            .withAddress("address").withPhone1("phone1").withPhone2("phone2").withPhone3("phone3")
            .withGroup("test1");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(contact);
    Comparator <? super ContactData> byId=(c1,c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}



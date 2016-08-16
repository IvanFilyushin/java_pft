package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    Contacts before = app.contact().all();

    app.contact().gotoAddPage();
    ContactData contact = new ContactData().withFirstName("name1")
            .withLastName("name2").withNickName("name3").withTitle("title").withCompany("company")
            .withAddress("address").withPhone1("8(903)125-14-62").withPhone2("745-85-244").withPhone3("100 00 52")
            .withEmail1("as@co.com").withEmail2("petrus@zw.ru").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    assertThat(after, equalTo(before.withAddedContact(contact)));

  }
}



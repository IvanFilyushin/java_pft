package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts(){

    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstName("fname 1").withLastName("lname 1").withNickName("nname 1")
            .withTitle("title1").withCompany("company1")
            .withAddress("address1").withPhone1("Phone 1").withPhone2("Phone 2").withPhone3("Phone 3")
            .withEmail1("Email1").withEmail2("Email2").withGroup("test1")
            .withPhoto(new File("src/test/resources/zt.png"))});
    list.add(new Object[] {new ContactData().withFirstName("fname 2").withLastName("lname 2").withNickName("nname 2")
            .withTitle("title2").withCompany("company2")
            .withAddress("address2").withPhone1("Phone1 2").withPhone2("Phone2 2").withPhone3("Phone3 2")
            .withEmail1("Email1 2").withEmail2("Email2 2").withGroup("test1")
            .withPhoto(new File("src/test/resources/zt.png"))});

    return list.iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {

    Contacts before = app.contact().all();

    app.contact().gotoAddPage();
//   File photo = new File("src/test/resources/zt.png");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    assertThat(after, equalTo(before.withAddedContact(contact)));

  }

  @Test (enabled = false)

  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/zt.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}



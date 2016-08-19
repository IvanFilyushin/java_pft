package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ольга on 19.08.2016.
 */
public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts,file);

  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    String path="C:/DEVIL/java_pft/addressbook-web-tests";
    for(ContactData contact:contacts){
      writer.write(String.format("%s;%s;%s;%s;%s;%s\n", contact.getFirstname(),contact.getLastname(),contact.getAddress(),
      contact.getEmail1(),contact.getPhone1(),path+"/src/test/resources/zt.png"));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for(int i = 0;i < count; i++){
      contacts.add(new ContactData().withFirstName("name"+i).withLastName("lastname"+i).withAddress("address"+i)
              .withEmail1("email"+i).withPhone1("phone"+i));
    }
    return contacts;
  }
}

package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ольга on 26.07.2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void returnToHomePage() {

    if (isElementPresent(By.id("maintable")))
      return;
    click(By.linkText("home"));
  }

  public void fillForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getPhone1());
    type(By.name("mobile"), contactData.getPhone2());
    type(By.name("work"), contactData.getPhone3());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {

    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void selectContactById(int id) {

    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

  }

  public void delete() {
    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void submitModification() {
    click(By.name("update"));
  }

  public void gotoModification(int id) {

    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element : elements) {
      int idd = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      if (idd == id) {
        element.findElement(By.xpath("./td[8]/a/img")).click();
        return;
      }
    }
  }

  public void allContacts() {
    click(By.id("MassCB"));
  }

  public void deleteFromModification() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void create(ContactData contact) {
    fillForm(contact, true);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }


  public void deleteContact(int index) {
    selectContact(index);
    delete();
    returnToHomePage();
  }

  public void deleteContact(ContactData contact) {
    selectContactById(contact.getId());
    delete();
    contactCache = null;
    returnToHomePage();
  }

  public void deleteContacts() {
    delete();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    gotoModification(contact.getId());
    fillForm(contact, false);
    submitModification();
    contactCache = null;
    returnToHomePage();
  }


  public void deleteFromEdit(ContactData deletedContact) {
    gotoModification(deletedContact.getId());
    deleteFromModification();
    contactCache = null;
    returnToHomePage();
  }

  public void gotoAddPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
      return;
    }
    click(By.linkText("add new"));
  }

  public boolean isThereAContact() {

    return isElementPresent(By.name("selected[]"));
  }

  public int count() {

    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = element.findElement(By.xpath("./td[2]")).getText();
      String firstname = element.findElement(By.xpath("./td[3]")).getText();
      ContactData contact = new ContactData().withId(id).withFirstName(firstname).withLastName(lastname);
      contacts.add(contact);
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = element.findElement(By.xpath("./td[2]")).getText();
      String firstname = element.findElement(By.xpath("./td[3]")).getText();
      String phone1 = element.findElement(By.xpath("./td[6]")).getText();
      ContactData contact = new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
              .withPhone1(phone1);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {

    gotoModification(contact.getId());
    return new ContactData().withPhone1(wd.findElement(By.name("home")).getAttribute("value")).
            withPhone2(wd.findElement(By.name("mobile")).getAttribute("value")).
            withPhone3(wd.findElement(By.name("work")).getAttribute("value"));

  }
}

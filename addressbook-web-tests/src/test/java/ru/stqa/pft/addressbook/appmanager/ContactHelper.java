package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void gotoModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
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
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    selectContact(0);
    gotoModification();
    fillForm(contact, false);
    submitModification();
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

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
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
}

package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String nickname;
  private String email1;
  private String email2;
  private String email3;
  private String title;
  private String company;

  private String address;
  private String phone1;
  private String phone2;
  private String phone3;
  private String group;
  private String allPhones;
  private String allEmails;
  private String info;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getInfo() {
    return info;
  }

  public ContactData withInfo(String info) {
    this.info = info;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastName(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickName(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withPhone1(String phone1) {
    this.phone1 = phone1;
    return this;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  public ContactData withPhone3(String phone3) {
    this.phone3 = phone3;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public String getEmail1() {
    return email1;
  }
  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
  }
  public ContactData withEmail1(String email) {
    this.email1 = email;
    return this;
  }
  public ContactData withEmail2(String email) {
    this.email2 = email;
    return this;
  }
  public ContactData withEmail3(String email) {
    this.email3 = email;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone1() {
    return phone1;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getPhone3() {
    return phone3;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}
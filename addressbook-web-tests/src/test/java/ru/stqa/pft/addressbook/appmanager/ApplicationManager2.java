package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ольга on 26.07.2016.
 */
public class ApplicationManager2 {

  FirefoxDriver wd;

  private SessionHelper2 sessionHelper2;
  private NavigationHelper2 navigationHelper2;
  private ContactHelper contactHelper;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    contactHelper = new ContactHelper(wd);
    navigationHelper2 = new NavigationHelper2(wd);
    sessionHelper2=new SessionHelper2(wd);
    sessionHelper2.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper2 getNavigationHelper2() {
    return navigationHelper2;
  }
}

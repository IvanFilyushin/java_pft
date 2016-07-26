package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Ольга on 26.07.2016.
 */
public class NavigationHelper2 {
  private FirefoxDriver wd;

  public NavigationHelper2(FirefoxDriver wd) {
    this.wd =wd;
  }

  public void gotoContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}

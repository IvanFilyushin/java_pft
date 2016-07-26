package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager2;

/**
 * Created by Ольга on 22.07.2016.
 */
public class TestBase {
  //protected final ApplicationManager2 app2 = new ApplicationManager2();

 protected final ApplicationManager app = new ApplicationManager();

 @BeforeMethod
 public void setUp() throws Exception {
  app.init();
 }

 // @BeforeMethod
 // public void setUp() throws Exception {
  //  app2.init();
//  }

  // @AfterMethod
//  public void tearDown() {
//    app.stop();
//  }

//  @AfterMethod
//  public void tearDown() {
//    app2.stop();
//  }

//  public ApplicationManager2 getApp2() {
//    return app2;
//  }
}

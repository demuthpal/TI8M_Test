package org.demuth.project.automatedtest.ti8m;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

  @Test()
  public void userCanSearch() {
    GooglePage page = open("https://google.com/ncr", GooglePage.class);
    SearchResultsPage results = page.searchFor("25010");
    results.checkResultsSize(1);
    results.getResults().get(0).shouldHave(text("iso25000"));
    final String isoIndexPageURL = results.getResults().get(0).findElement(By.tagName("a")).getAttribute("href");
    //SelenideElement firstResultElement = Selenide.$(results.getResults().get(0).toWebElement());
    GooglePage isoIndexPage = open(isoIndexPageURL , GooglePage.class);


    SelenideElement activePaginatorElement = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]"));
    boolean exists = Selenide.$(By.cssSelector("active")).exists();
    boolean isDisplayed = Selenide.$(By.cssSelector("active")).isDisplayed();

    SelenideElement activePaginatorElement2 = Selenide.$(By.cssSelector("css=img[alt=\"Español (ES)\"]"));
    boolean exists2 = Selenide.$(By.cssSelector("active")).exists();
    boolean isDisplayed2 = Selenide.$(By.cssSelector("active")).isDisplayed();

   // css=img[alt="English (UK)"]
   // css=img[alt="Español (ES)"]



  }

  @Test()
  public void language() {
    GooglePage page = open("https://google.com/ncr", GooglePage.class);
    SearchResultsPage results = page.searchFor("25010");
    results.checkResultsSize(1);
    results.getResults().get(0).shouldHave(text("iso25000"));
    final String isoIndexPageURL = results.getResults().get(0).findElement(By.tagName("a")).getAttribute("href");
    //SelenideElement firstResultElement = Selenide.$(results.getResults().get(0).toWebElement());
    GooglePage isoIndexPage = open(isoIndexPageURL, GooglePage.class);


    SelenideElement activePaginatorElement = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]"));
    boolean exists = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).exists();
    boolean isDisplayed = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).isDisplayed();

    SelenideElement activePaginatorElement2 = Selenide.$(By.cssSelector("css=img[alt=\"Español (ES)\"]"));
    boolean exists2 = Selenide.$(By.cssSelector("css=img[alt=\"Español (ES)\"]")).exists();
    boolean isDisplayed2 = Selenide.$(By.cssSelector("css=img[alt=\"Español (ES)\"]")).isDisplayed();

    activePaginatorElement.click();

  }

}


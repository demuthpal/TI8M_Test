package org.demuth.project.automatedtest.ti8m;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.sun.tools.doclint.Messages;
import org.junit.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

  public void userSearch(String inputtext, String clickfor) {
    try {
      GooglePage page = open("https://google.com/ncr", GooglePage.class);
      SearchResultsPage results = page.searchFor(inputtext);
      results.checkResultsSize(1);
      results.getResults().get(0).shouldHave(text(clickfor));
      System.out.println("Suche nach " + inputtext + " funktioniert " + clickfor + " existiert und auswählbar.");
      final String isoIndexPageURL = results.getResults().get(0).findElement(By.tagName("a")).getAttribute("href");
      GooglePage isoIndexPage = open(isoIndexPageURL, GooglePage.class);
      Selenide.$(By.cssSelector("small.subheading-category")).isDisplayed();
      SelenideElement activePaginatorTitle = Selenide.$(By.cssSelector("small.subheading-category"));
      boolean exists = Selenide.$(By.cssSelector("small.subheading-category")).exists();
      if (exists = true) {
        System.out.println("ISO/IEC 25010 existiert");
      }

    } catch (Exception e) {
      System.out.println("Suche nach " + inputtext + " oder click in der Ergebnisliste auf " + clickfor + " nich OK.");
    }


  }

  public void clickonpagenumber(int number) {

    //Selenide.$(By.cssSelector("a[title="\" + number + "\"]")).click();
    //css=a[title="2"]
    Selenide.$(By.cssSelector("a[title=\"" + number + "\"]")).click();
  }


  /**
   * Test to search inputtext check it in results and click on the clickfor
   */
  @Test
  public void userCanSearch() {

    userSearch("25010", "iso25000");

  }

  /**
   * Sprachauswahl Testcase
   */
  @Test
  public void language() {
    open("http://iso25000.com/index.php/normas-iso-25000/iso-25010");

    try {
      SelenideElement activePaginatorElementES = Selenide.$(By.cssSelector("img[alt=\"Español (ES)\"]"));
      boolean existsES = Selenide.$(By.cssSelector("img[alt=\"Español (ES)\"]")).exists();
      boolean isDisplayed2 = Selenide.$(By.cssSelector("img[alt=\"Español (ES)\"]")).isDisplayed();
      activePaginatorElementES.click();
      System.out.println("Sprachauswahl ES ist möglich.");
    } catch (Exception ES) {
      System.out.println("Sprachauswahl ES ist nicht möglich.");
    }

    try {
      SelenideElement activePaginatorElementUK = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]"));
      boolean exists = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).exists();
      boolean isDisplayed = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).isDisplayed();
      activePaginatorElementUK.click();
      System.out.println("Sprachauswahl UK ist möglich.");
    } catch (Exception ES) {
      System.out.println("Sprachauswahl UK ist nicht möglich.");
    }
  }

  /**
   * Paginierung Testcase
   */
  @Test
  public void pagenumbr() {
    open("http://iso25000.com/index.php/en/iso-25000-standards/iso-25010");

    //userSearch("25010", "iso25000");

    try {
      clickonpagenumber(2);
      System.out.println("Klick auf 2 ist möglich.");
    } catch (Exception ES) {
      System.out.println("Klick auf 2 ist nicht möglich.");
    }

    try {
      clickonpagenumber(3);
      System.out.println("Klick auf 3 ist möglich.");
    } catch (Exception ES) {
      System.out.println("Klick auf 3 ist nicht möglich.");
    }

    try {
      clickonpagenumber(1);
      System.out.println("Klick auf 3 ist möglich.");
    } catch (Exception ES) {
      System.out.println("Klick auf 3 ist nicht möglich.");
    }



/*
    try {
      SelenideElement two = Selenide.$(By.cssSelector("a[title=\"2\"]"));
      boolean twoexists = Selenide.$(By.cssSelector("a[title=\"2\"]")).exists();
      boolean twoisDisplayed = Selenide.$(By.cssSelector("a[title=\"2\"]")).isDisplayed();
      two.click();
      System.out.println("Klick auf 2 ist möglich.");
    } catch (Exception ES) {
      System.out.println("Klick auf 2 ist nicht möglich.");
    }
  }
}




  //  Selenide.$(By.cssSelector("a[title=\"2\"]")).click();
  //  Selenide.$(By.cssSelector("a[title=\"3\"]")).click();
  //  Selenide.$(By.cssSelector("a[title=\"1\"]")).click();

    //clickonpagenumber(2);
    //clickonpagenumber(3);
    //clickonpagenumber(1);
    

    /*
    try {
      SelenideElement activePaginatorElementES = Selenide.$(By.cssSelector("img[alt=\"Español (ES)\"]"));
      boolean existsES = Selenide.$(By.cssSelector("img[alt=\"Español (ES)\"]")).exists();
      boolean isDisplayed2 = Selenide.$(By.cssSelector("img[alt=\"Español (ES)\"]")).isDisplayed();
      activePaginatorElementES.click();
      System.out.println("Sprachauswahl ES ist möglich.");
    } catch (Exception ES) {
      System.out.println("Sprachauswahl ES ist nicht möglich.");
    }

    try {
      clickonpagenumber(2);
      clickonpagenumber(3);
      clickonpagenumber(1);
      System.out.println("Paginierung ist möglich");
    } catch (Exception ESP) {
      System.out.println("Paginierung ist nicht möglich.");
    }

    try {
      SelenideElement activePaginatorElementUK = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]"));
      boolean exists = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).exists();
      boolean isDisplayed = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).isDisplayed();
      activePaginatorElementUK.click();
      System.out.println("Sprachauswahl UK ist möglich.");
    } catch (Exception UK) {
      System.out.println("Sprachauswahl UK ist nicht möglich.");
    }

    try {
      clickonpagenumber(2);
      clickonpagenumber(3);
      clickonpagenumber(1);
      System.out.println("Pagierung ist möglich");
    } catch (Exception UKP) {
      System.out.println("Pagierung ist nicht möglich.");
    }

*/






  /*
    try {
      clickonpagenumber(1 );
      clickonpagenumber(2 );
      clickonpagenumber(3 );
      System.out.println("Sprachauswahl ES ist möglich.");
    } catch (Exception ES) {
      System.out.println("Sprachauswahl ES ist nicht möglich.");
    }

    try {
      SelenideElement activePaginatorElementUK = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]"));
      boolean exists = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).exists();
      boolean isDisplayed = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).isDisplayed();
      activePaginatorElementUK.click();
      System.out.println("Sprachauswahl UK ist möglich.");
    } catch (Exception ES) {
      System.out.println("Sprachauswahl UK ist nicht möglich.");
    }
  }

*/
        /*SearchResultsPage results = page.searchFor("25010");
        results.checkResultsSize(1);
        results.getResults().get(0).shouldHave(text("ISO/IEC 25010"));
        final String isoIndexPageURL = results.getResults().get(0).findElement(By.tagName("a")).getAttribute("href");
        //SelenideElement firstResultElement = Selenide.$(results.getResults().get(0).toWebElement());
        GooglePage isoIndexPage = open(isoIndexPageURL, GooglePage.class);


        SelenideElement activePaginatorElement = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]"));
        boolean exists = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).exists();
        boolean isDisplayed = Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).isDisplayed();
*/
  //Selenide.$(By.cssSelector("img[alt=\"English (UK)\"]")).click();


  //Selenide.$(By.cssSelector("a[title=\"2\"]")).click();
  //Selenide.$(By.cssSelector("a[title=\"3\"]")).click();

  //clickonpagenumber(1 );
  //clickonpagenumber(2 );
  //clickonpagenumber(3 );

*/


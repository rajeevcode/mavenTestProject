package pageClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

// import utilities.WaitTypes;

public class SearchPage {
  public static WebElement element = null;
  static Logger log = Logger.getLogger ( SearchPage.class );

  /**
   * Clear all the fields on the Search page
   *
   * @param driver
   */
  public static void clearAllFields(WebDriver driver) {
    driver.findElement ( By.id ( "flight-origin-hp-flight" ) ).clear ( );
    driver.findElement ( By.id ( "flight-destination-hp-flight" ) ).clear ( );
    driver.findElement ( By.id ( "flight-departing-hp-flight" ) ).clear ( );
    driver.findElement ( By.id ( "flight-returning-hp-flight" ) ).clear ( );
  }

  /**
   * Click on Morning check box to filter the results
   *
   * @param driver
   */
  public static void clickMorningFlight(WebDriver driver) {
//		WebElement element = WaitTypes.getWhenVisible(driver,
//				By.xpath("//ul[@id='departureTimeList']//span[contains(text(), 'Morning')]//preceding-sibling::input"), 30);
//		element.click();
    log.info ( "Clicked on Morning Time to filter the results" );
  }

  /**
   * Click non-stop check box
   *
   * @param driver
   */
  public static void clickNonStopCheckBox(WebDriver driver) {
    element = driver.findElement ( By.id ( "advanced-flight-nonstop" ) );
    element.click ( );
    log.info ( "Clicked non-stop check box" );
  }

  /**
   * Click on Advanced Options link
   *
   * @param driver
   */
  public static void clickOnAdvancedLink(WebDriver driver) {
    element = driver.findElement ( By.id ( "advanced-options" ) );
    element.click ( );
    log.info ( "Clicked on Advanced Options link" );
  }

  /**
   * Click on search button
   *
   * @param driver
   */
  public static void clickOnSearchButton(WebDriver driver) {
    element = searchButton ( driver );
    element.click ( );
  }

  /**
   * Returns the search button box element
   *
   * @param driver
   * @return
   */
  public static WebElement searchButton(WebDriver driver) {
    element = driver.findElement ( By.id ( "//button[@type='submit']" ) );
    return element;
  }

  /**
   * Fill departure date in departure date text box
   *
   * @param driver
   * @param date
   */
  public static void fillDepartureDateTextBox(WebDriver driver, String date) {
    element = departureDateTextBox ( driver );
    element.sendKeys ( date );
    log.info ( "Enter departure date as " + date );
  }

  /**
   * Returns the departure date text box element
   *
   * @param driver
   * @return
   */
  public static WebElement departureDateTextBox(WebDriver driver) {
    element = driver.findElement ( By.id ( "flight-returning-hp-flight" ) );
    return element;
  }

  /**
   * Fill destination city in destination text box
   *
   * @param driver
   * @param origin
   */
  public static void fillDestinationTextBox(WebDriver driver, String destination) throws Exception {
    element = destinationTextBox ( driver );
    element.sendKeys ( destination );
    Thread.sleep ( 2000 );
    element.sendKeys ( Keys.TAB );
    log.info ( "Enter destination city as " + destination );
  }

  /**
   * Returns the flight destination text box element
   *
   * @param driver
   * @return
   */
  public static WebElement destinationTextBox(WebDriver driver) {
    element = driver.findElement ( By.id ( "flight-destination-hp-flight" ) );
    log.info ( "Destination text box element found" );
    return element;
  }

  /**
   * Fill origin city in origin text box
   *
   * @param driver
   * @param origin
   */
  public static void fillOriginTextBox(WebDriver driver, String origin) throws Exception {
    element = originTextBox ( driver );
    element.sendKeys ( origin );
    Thread.sleep ( 2000 );
    element.sendKeys ( Keys.TAB );
    log.info ( "Enter origin city as " + origin );
  }

  /**
   * Returns the flight origin text box element
   *
   * @param driver
   * @return
   */
  public static WebElement originTextBox(WebDriver driver) {
    element = driver.findElement ( By.id ( "flight-origin-hp-flight" ) );
    log.info ( "Origin text box element found" );
    return element;
  }

  /**
   * Fill return date in return date text box
   *
   * @param driver
   * @param date
   */
  public static void fillReturnDateTextBox(WebDriver driver, String date) {
    element = returnDateTextBox ( driver );
    element.clear ( );
    element.sendKeys ( date );
    element.sendKeys ( Keys.TAB );
    log.info ( "Enter return date as " + date );
  }

  /**
   * Returns the return date text box element
   *
   * @param driver
   * @return
   */
  public static WebElement returnDateTextBox(WebDriver driver) {
    element = driver.findElement ( By.id ( "flight-returning-hp-flight" ) );
    return element;
  }

  /**
   * Navigate to flights tab
   *
   * @param driver
   */
  public static void navigateToFlightsTab(WebDriver driver) {
    // driver.findElement(By.id("header-history")).click();
    element = driver.findElement ( By.id ( "tab-flight-tab-hp" ) );
    element.click ( );
    log.info ( "Navigate to flights tab" );
  }

  /**
   * Select flight adults
   *
   * @param driver
   * @param flightAdults
   */
  public static void selectFlightAdults(WebDriver driver, String flightAdults) {
    Select options = new Select ( driver.findElement ( By.id ( "flight-adults" ) ) );
    options.selectByValue ( flightAdults );
    log.info ( "Select flight adults as " + flightAdults );
  }

  /**
   * Select flight class
   *
   * @param driver
   */
  public static void selectFlightClass(WebDriver driver, String flightClass) {
    Select options = new Select ( driver.findElement ( By.id ( "flight-advanced-preferred-class" ) ) );
    options.selectByValue ( flightClass );
    log.info ( "Select flight class as " + flightClass );
  }

}

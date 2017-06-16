package com.companyname.prjname.qa.functionlibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static cucumber.prjname.java.tests.SharedDriver.getDriver;
import static org.junit.Assert.assertTrue;

public class WebNavigation {

    public static void openWebPage(String url) {
        getDriver().get(url);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //To Click a Link
    public static void clickALinkWithCssLocator(String cssLocator){

        getDriver().findElement(By.cssSelector(cssLocator)).click();
    }

    public static void enterAnyTextInAField(String cssLocator, String text){
        getDriver().findElement(By.cssSelector(cssLocator)).sendKeys(text);
    }

    public static void enterAnyNumberInAField(String fieldLocator, float anyNumber){
        String text =  Float.toString(anyNumber);
        getDriver().findElement(By.cssSelector(fieldLocator)).sendKeys(text);
    }

    public static String getTextByCSS(String cssLocator) {
        return getDriver().findElement(By.cssSelector(cssLocator)).getText();
    }

    public static void assertContentExists(String cssLocator, String textToBePresent){
        String textToVerify = getTextByCSS(cssLocator).toUpperCase();
        assertTrue(textToVerify.contains(textToBePresent.toUpperCase()));
    }

    public static boolean isElementPresent(String cssLocator) throws Throwable {
        try {
            getDriver().findElement(By.cssSelector(cssLocator));
                return true;
            } catch (NoSuchElementException e) {
                return false;
        }
    }

    public static String getIDElement(){

        WebElement div = getDriver().findElement(By.cssSelector("div.row:nth-child(2)"));
        String id = div.getAttribute("id");
        return id;
    }

    public static void selectAnOptionFromAList(String listLocator, String listOption){
            WebElement element =  getDriver().findElement(By.cssSelector(listLocator));
            Select dropDownList = new Select(element);
            dropDownList.selectByVisibleText(listOption);
    }

    public static void selectDateFromTheCalendar(String cssLocator, int dateToSelect){

        WebElement dateWidget = getDriver().findElement(By.cssSelector(cssLocator));
        List<WebElement> list=dateWidget.findElements(By.tagName("td"));
        String tempDate = String.valueOf(dateToSelect);
        for (WebElement cell: list){
            String text = cell.getText();
        if (text.equals(tempDate)){
            cell.findElement(By.linkText(tempDate)).click();
        break;
        }
        }
    }

    public static void closeBrowser(){

        getDriver().close();
    }
}

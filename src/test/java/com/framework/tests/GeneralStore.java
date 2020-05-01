package com.framework.tests;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralStore {
	AppiumDriver<AndroidElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "9DC7N17711004538");
		caps.setCapability("platformName", "ANDROID");
		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\DmoDe\\Desktop\\General-Store.apk");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
		caps.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AppiumDriver<AndroidElement>(url, caps);

	}

	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	@Test
	public void firstTest() {
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		AndroidElement textField = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField"));
		explicityWaitFor(textField);
		textField.clear();
		textField.sendKeys("Marco Mario");

		driver.findElement(MobileBy.xpath("//*[@text='Female']")).click();
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"))
				.click();
		driver.findElement(MobileBy.xpath("//*[@text='Male']")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	}

	@Test
	public void firstTestNegative() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		AndroidElement countrySelector = driver.findElement(MobileBy.id("android:id/text1"));
		explicityWaitFor(countrySelector);
		countrySelector.click();

		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"))
				.click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		AndroidElement toastMessage = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]"));
		String message = toastMessage.getAttribute("name");

		System.out.println("Message text: " + message);

		Assert.assertTrue(message.contains("Please"));

		driver.navigate().back();
		driver.navigate().back();
	}

	@Test
	public void secondTest() {
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		AndroidElement textField = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField"));
		explicityWaitFor(textField);
		textField.clear();
		textField.sendKeys("Marco Mario");

		driver.findElement(MobileBy.xpath("//*[@text='Female']")).click();
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"))
				.click();
		driver.findElement(MobileBy.xpath("//*[@text='Male']")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
				+ "new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0));"));
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		driver.navigate().back();
		
		/*
		 * sa dva elementa prikazana
		 * 
		 * int size = driver.findElements(MobileBy.id(
		 * "com.androidsample.generalstore:id/productName")).size();
		 * 
		 * for (int i = 0; i < size; i++) { String text =
		 * driver.findElements(MobileBy.id(
		 * "com.androidsample.generalstore:id/productName")).get(i).getText();
		 * 
		 * 
		 * if(text == "Jordan 6 Rings") { driver.findElements(MobileBy.id(
		 * "com.androidsample.generalstore:id/productAddCart")).get(i).click(); break; }
		 * 
		 * }
		 */
		
		
	}
	
	@Test
	public void thirdTest() {
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		AndroidElement textField = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField"));
		explicityWaitFor(textField);
		textField.clear();
		textField.sendKeys("Marco Mario");

		driver.findElement(MobileBy.xpath("//*[@text='Female']")).click();
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"))
				.click();
		driver.findElement(MobileBy.xpath("//*[@text='Male']")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
				+ "new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0));"));
		
		driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		String productText = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productName")).getText();
		
		Assert.assertTrue(productText.equals("Jordan 6 Rings"));
	}
	
	@Test
	public void thirdTestAdd2Items() {
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		AndroidElement textField = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField"));
		explicityWaitFor(textField);
		textField.clear();
		textField.sendKeys("Zoki Podunavac");
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));"))
				.click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
				+ "new UiSelector().textMatches(\"Air Jordan 1 Mid SE\").instance(0));"));
		
		driver.findElements(MobileBy.xpath("//*[@text=\"ADD TO CART\"]")).get(0).click();
		driver.findElements(MobileBy.xpath("//*[@text=\"ADD TO CART\"]")).get(0).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String pricePer2Items = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		String trimmed = pricePer2Items.substring(1).trim();
		double value = Double.parseDouble(trimmed);
		//System.out.println("Value: " + value);
		Assert.assertEquals(value, 230.0);
		
		
	}
	
	@Test
	public void fourthTest() {
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		AndroidElement textField = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField"));
		explicityWaitFor(textField);
		textField.clear();
		textField.sendKeys("Pera Kvrzica");

		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Congo\"));"))
				.click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
				+ "new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0));"));
		
		driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		
		@SuppressWarnings("rawtypes") 
		TouchAction t = new TouchAction(driver);
		
		AndroidElement lPress = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/termsButton"));
		t.longPress(longPressOptions().withElement(element(lPress)).withDuration(ofSeconds(2))).release().perform();
		
		driver.findElement(MobileBy.id("android:id/button1")).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement input = driver.findElementByName("q");
		
		input.click();
		
		input.sendKeys("Hello bre!");
	}
	

	public void explicityWaitFor(AndroidElement element) {
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(element));
	}

}

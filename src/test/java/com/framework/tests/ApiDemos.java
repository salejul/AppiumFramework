package com.framework.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.frameworks.pages.TheAppPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ApiDemos {

	AppiumDriver<AndroidElement> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "9DC7N17711004538");
		caps.setCapability("platformName", "ANDROID");
		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\DmoDe\\Desktop\\ApiDemos-debug.apk");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5);
		caps.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AppiumDriver<AndroidElement>(url, caps);

	}

	@AfterClass
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	@Test
	public void tapLongPressTest() {

		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

		@SuppressWarnings("rawtypes") 
		TouchAction t = new TouchAction(driver);

		AndroidElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		t.tap(tapOptions().withElement(element(expandList))).perform();

		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();

		AndroidElement lPress = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		t.longPress(longPressOptions().withElement(element(lPress)).withDuration(ofSeconds(4))).release().perform();

		Assert.assertTrue(driver.findElementById("android:id/title").isDisplayed(), "Not displayed!");

	}

	@Test
	public void swipeTest() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"2. Inline\")")).click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		AndroidElement grabbable = driver.findElementByXPath("//*[@content-desc='15']");
		AndroidElement dropTo = driver.findElementByXPath("//*[@content-desc='45']");

		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(grabbable)).withDuration(ofSeconds(2)))
				.moveTo(element(dropTo)).release().perform();
		

	}

	@Test
	public void scrollDown() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		
	}
	
	@Test
	public void dragNDrop() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		AndroidElement draggable = driver.findElementsByClassName("android.view.View").get(0);
		AndroidElement droppable = driver.findElementsByClassName("android.view.View").get(1);
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(draggable)).withDuration(ofSeconds(3))).moveTo(element(droppable)).release().perform();
		
	}
	
	

	public void explicitWait(AndroidElement element) {
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(element));
	}

}

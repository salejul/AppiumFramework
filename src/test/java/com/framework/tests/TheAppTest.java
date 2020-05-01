package com.framework.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.frameworks.pages.TheAppPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TheAppTest {

	AppiumDriver<AndroidElement> driver;
	

	@BeforeClass
	public void setUp() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "9DC7N17711004538");
        caps.setCapability("platformName", "ANDROID");
        caps.setCapability("app", "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk");
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
	public void simpleTest() {
		
		//mora ovde da se instancira izgleda, OK!
		
		//TheAppPage prviFlow = new TheAppPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(MobileBy.AccessibilityId("List Demo")).click();
		

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Altocumulus")));

        PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
        Interaction moveToStart = finger.createPointerMove(Duration.ZERO, Origin.viewport(), 520, 1530);
        Interaction pressDown = finger.createPointerDown(MouseButton.LEFT.asArg());
        Interaction moveToEnd = finger.createPointerMove(Duration.ofMillis(1000), Origin.viewport(), 520, 490);
        Interaction pressUp = finger.createPointerUp(MouseButton.LEFT.asArg());

        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(moveToStart);
        swipe.addAction(pressDown);
        swipe.addAction(moveToEnd);
        swipe.addAction(pressUp);

        driver.perform(Arrays.asList(swipe));

        driver.findElement(MobileBy.AccessibilityId("Stratus"));
		
	}

	public void explicitWait(AndroidElement element) {
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(element));
	}

}

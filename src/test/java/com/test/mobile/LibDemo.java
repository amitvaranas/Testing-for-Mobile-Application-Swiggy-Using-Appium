package com.test.mobile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LibDemo {
	void scrollUp(AndroidDriver driver) {
		int w = driver.manage().window().getSize().getWidth();
		int h = driver.manage().window().getSize().getHeight();
		System.out.println(w);
		System.out.println(h);
		int startX = (int) (0.5 * w);
		int endX = startX;
		int startY = (int) (0.9 * h);
		int endY = (int) (0.4 * h);
		TouchAction touchAction = new TouchAction(driver);
		// TODO Auto-generated method stub
		touchAction.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startX, startY)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void scrollDown(AndroidDriver driver) {
		int w = driver.manage().window().getSize().getWidth();
		int h = driver.manage().window().getSize().getHeight();
		System.out.println(w);
		System.out.println(h);
		int startX = (int) (0.5 * w);
		int endX = startX;
		int startY = (int) (0.4 * h);
		int endY = (int) (0.9 * h);
		TouchAction touchAction = new TouchAction(driver);
		// TODO Auto-generated method stub
		touchAction.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startX, startY)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ScrollToView(String view, AndroidDriver driver) {
		// TODO Auto-generated method stub

		boolean flag = false;
		while (!flag) {
			List<WebElement> lstViews = driver.findElements(By.xpath("//android.widget.TextView"));
			for (WebElement vw : lstViews) {
				System.out.println(vw.getAttribute("text"));
				if (vw.getAttribute("text").contains(view)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				scrollUp(driver);
			}

		}
	}

	public void ClickOnToView(String vw, AndroidDriver driver) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + vw + "']")).click();

	}

}

package automation.common;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import automation.common.model.BrowserType;

public final class Driver {
	public static WebDriver browser;
	public static BrowserType browserType = BrowserType.CHROME;
	public static int timeout = 30;
	public static boolean isBrowserOpen = false;

	public static void startBrowser(String url) throws Exception {
		startBrowser(url, browserType, timeout);
	}

	public static void startBrowser(String url, BrowserType browserType, int timeout) throws Exception {
		switch (browserType) {
		case CHROME: {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			// options.addArguments("headless");
			// options.addArguments("window-size=1920,1080");
			browser = new ChromeDriver(options);
		}
			break;

		case FIREFOX: {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("window-size=1920,1080");
			browser = new FirefoxDriver(options);
		}
			break;

		case INTERNET_EXPLORER: {
			browser = new InternetExplorerDriver();
		}
			break;

		default:
			throw new Exception("This browser is not supported yet.");
		}

		browser.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		browser.navigate().to(url);
		isBrowserOpen = true;
	}

	public static String getParentWindowHandler() {
		String parentWindowHandler = browser.getWindowHandle();
		return parentWindowHandler;
	}

	public static void switchToSubWindow() {
		String subWindowHandler = null;

		Set<String> handles = browser.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		browser.switchTo().window(subWindowHandler);
	}

	public static void switchToParentWindow(String parentWindowHandler) {
		browser.switchTo().window(parentWindowHandler);
	}

	public static void stopBrowser() throws Exception {
		Thread.sleep(2000);
		browser.quit();
		isBrowserOpen = false;
	}

	public static void refreshBrowser() throws Exception {
		browser.navigate().refresh();
	}

	public static void navigateBackBrowser() throws Exception {
		browser.navigate().back();
	}

	public static void navigateForwardBrowser() throws Exception {
		browser.navigate().forward();
	}

	public static boolean isBrowserOpen() {
		return isBrowserOpen;
	}
}

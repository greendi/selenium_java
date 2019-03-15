package automation.common.selector;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import automation.common.Driver;

public class SingleElementSelector {

	private Selector assertion;
	private Selector wait;
	private By locator;
	private WebElement webElement;

	public SingleElementSelector(By locator) {
		this.setLocator(locator);
		this.webElement = getElement();
		this.assertion = new Selector(locator, false, getElement());
		this.wait = new Selector(locator, true, getElement());
	}

	/**
	 * Gets the current text of the element.
	 * 
	 * @return The text of the specified element.
	 */
	public String getText() {
		for (int i = 0; i < 10; i++) {
			try {
				return webElement.getText();
			} catch (StaleElementReferenceException e) {
				continue;
			}
		}
		throw new StaleElementReferenceException("Could not get text of element: " + webElement);
	}

	/**
	 * Gets the value of a HTML attribute.
	 * 
	 * @param attributeName The name of the attribute to get the value of.
	 * @return The value of the specified HTML attribute.
	 */
	public String getAttribute(String attributeName) {
		for (int i = 0; i < 10; i++) {
			try {
				return webElement.getAttribute(attributeName);
			} catch (StaleElementReferenceException e) {
				continue;
			}
		}

		throw new StaleElementReferenceException("Could not get attribute of element: " + webElement);
	}

	/**
	 * Gets the read-only attribute of a HTML attribute.
	 */
	public String readOnlyValue() {
		return webElement.getAttribute("readonly");
	}

	/**
	 * Gets the value attribute of a HTML attribute.
	 */
	public String value() {
		return webElement.getAttribute("value");
	}

	/**
	 * Gets the placeholder attribute of a HTML attribute.
	 */
	public String placeholder() {
		return webElement.getAttribute("placeholder");
	}

	/**
	 * Sends the specified text as a set of characters to input.
	 * 
	 * @param text    The text to input.
	 * @param timeout The maximum amount of time to wait for the operation to
	 *                complete.
	 * @param wait    Whether to wait for the operation to successfully complete.
	 */
	public void sendKeys(String text, Long timeout, Boolean wait) {
		if (!wait) {
			webElement.sendKeys(text);
			return;
		}

		this.wait.conditionalWait(timeout).until((ExpectedCondition<Boolean>) condition -> {
			this.getWait().isClickable(timeout);
			for (int i = 0; i < 10; i++) {
				try {
					this.webElement.sendKeys(text);
					if (this.getAttribute("value").contains(text)) {
						return true;
					}
				} catch (StaleElementReferenceException e) {
					continue;
				}
			}
			return false;
		});
	}

	public void sendKeys(String text) {
		sendKeys(text, null, true);
	}

	/**
	 * Sends the specified text as a set of characters to input when focus is
	 * required also on the element.
	 * 
	 * @param text The text to input.
	 */
	public void sendKeysFocus(String text) {
		this.getWait().isClickable(null);
		Actions actions = new Actions(Driver.browser);
		actions.moveToElement(this.webElement);
		actions.click();
		actions.sendKeys(text);
		actions.build().perform();
	}

	/**
	 * Sends the specified text as a set of characters to input.
	 * 
	 * @param text The text to input.
	 */
	public void sendKeysDefault(String text) {
		webElement.sendKeys(text);
	}

	/**
	 * Clears the text from a specified element.
	 * 
	 * @param timeout The maximum amount of time to wait for the operation to
	 *                complete.
	 * @param wait    Whether to wait for the operation to successfully complete.
	 */
	public void clear(Long timeout, Boolean wait) {
		if (!wait) {
			webElement.clear();
			return;
		}

		this.wait.conditionalWait(timeout).until((ExpectedCondition<Boolean>) condition -> {
			this.getWait().isClickable(timeout);
			for (int i = 0; i < 10; i++) {
				try {
					this.webElement.clear();
					if (this.getAttribute("value") != "") {
						return true;
					}
				} catch (StaleElementReferenceException e) {
					continue;
				}
			}
			return false;
		});
	}

	public void clear() {
		clear(null, true);
	}

	/**
	 * Clears the text from a specified element.
	 * 
	 */
	public void clearFocus() {
		this.getWait().isClickable(null);
		Actions actions = new Actions(Driver.browser);
		actions.moveToElement(this.webElement);
		actions.click();
		actions.build();
		actions.build().perform();
	}

	/**
	 * Clicks this element.
	 * 
	 * @param timeout The maximum amount of time to wait for the element to become
	 *                click-able.
	 * @param wait    Whether to wait or click immediately.
	 */
	public void click(Long timeout, boolean wait) {
		if (wait == true)
			this.wait.isClickable(timeout);

		for (int i = 0; i < 30; i++) {
			try {
				webElement.click();
				return;
			} catch (StaleElementReferenceException e) {
				continue;
			}
		}

		throw new StaleElementReferenceException("Could not click on element: " + webElement);
	}

	public void click() {
		click(null, true);
	}
	
	public void defaultClick() throws InterruptedException {
		this.getWait().isClickable(null);
		webElement.click();
	}
	
	public boolean retryingFindClick() {
		boolean result = false;
		int attempts = 0;
		while (attempts < 5) {
			try {
				webElement.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	/**
	 * Double clicks this element.
	 * 
	 */
	public void doubleClick() {
		this.getWait().isVisible(null);
		Actions actions = new Actions(Driver.browser);
		actions.moveToElement(this.webElement);
		actions.doubleClick().build().perform();
	}

	public boolean retryingFindDoubleClick() {
		boolean result = false;
		int attempts = 0;
		while (attempts < 5) {
			try {
				this.getWait().isVisible(null);
				Actions actions = new Actions(Driver.browser);
				actions.moveToElement(this.webElement);
				actions.doubleClick().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public boolean isDisplayed() {
		if (webElement.isDisplayed())
			return true;
		else
			return false;
	}

	public Selector getWait() {
		return wait;
	}

	public void setWait(Selector wait) {
		this.wait = wait;
	}

	public Selector getAssertion() {
		return assertion;
	}

	public void setAssertion(Selector assertion) {
		this.assertion = assertion;
	}

	public By getLocator() {
		return locator;
	}

	public void setLocator(By locator) {
		this.locator = locator;
	}

	public WebElement getWebElement() {
		return webElement;
	}

	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}

	private WebElement getElement() {
		for (int i = 0; i < 10; i++) {
			try {
				return Driver.browser.findElement(this.locator);
			} catch (StaleElementReferenceException e) {
				continue;
			}
		}
		throw new StaleElementReferenceException(null);
	}

	public List<WebElement> getWebElements() {
		for (int i = 0; i < 10; i++) {
			try {
				return Driver.browser.findElements(this.locator);
			} catch (StaleElementReferenceException e) {
				continue;
			}
		}
		throw new StaleElementReferenceException(null);
	}
}

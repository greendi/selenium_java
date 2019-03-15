package automation.common.selector;

import java.util.List;
import java.util.function.Supplier;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.Driver;

public class Selector {

	private boolean throwException;
	private By locator;
	private WebElement webElement;

	public Selector(By locator, boolean throwException, WebElement webElement) {
		this.webElement = webElement;
		this.locator = locator;
		this.throwException = throwException;
	}

	public WebDriverWait conditionalWait(Long timeout) {
		return new WebDriverWait(Driver.browser, Timeout.process(timeout));
	}

	/**
	 * Asserts that the element is click-able.
	 *
	 * @param timeout The maximum amount of time to wait for the element to become
	 *                click-able.
	 * @return True when the element is click-able and false when it is not.
	 */
	public boolean isClickable(Long timeout) {
		WebElement webElement = (WebElement) handleExceptions(
				() -> conditionalWait(timeout).until(ExpectedConditions.elementToBeClickable(this.webElement)));
		return webElement != null;
	}

	/**
	 * Asserts that the element is selected.
	 *
	 * @param timeout The maximum amount of time to wait for the element to become
	 *                selected.
	 * @return True when the element is selected and false when it is not.
	 */
	public boolean isSelected(Long timeout) {
		Boolean isSelected = (Boolean) handleExceptions(
				() -> conditionalWait(timeout).until(ExpectedConditions.elementToBeSelected(webElement)));
		return isSelected != null ? isSelected : false;
	}

	/**
	 * Asserts that the element is not selected.
	 *
	 * @param timeout The maximum amount of time to wait for the element to not be
	 *                selected.
	 * @return True when the element is not selected and false when it is not.
	 */
	public boolean isNotSelected(Long timeout) {
		Boolean isNotSelected = (Boolean) handleExceptions(
				() -> conditionalWait(timeout).until(ExpectedConditions.elementSelectionStateToBe(webElement, false)));
		return isNotSelected != null ? isNotSelected : false;
	}

	/**
	 * Waits until the element does not specific attribute value.
	 *
	 * @param timeout The maximum amount of time to wait for the element to not have
	 *                specific attribute value.
	 * @param name    The name of the attribute to get the value of.
	 */
	public void waitAttributeValueChange(String name, String value1, String value2, Long timeout) {
		handleExceptions(() -> conditionalWait(timeout).until((ExpectedCondition<Boolean>) condition -> {
			isVisible(timeout);
			for (int i = 0; i < 10; i++) {
				try {
					if (!value1.equals(webElement.getAttribute(name))
							&& (!value2.equals(webElement.getAttribute(name)))) {
						return true;
					}
				} catch (StaleElementReferenceException e) {
					continue;
				}
			}
			throw new StaleElementReferenceException("Could not get attribute of element: " + webElement);
		}));
	}

	/**
	 * Asserts that the element is visible.
	 *
	 * @param timeout The maximum amount of time to wait for the element to become
	 *                visible.
	 * @return True when the element is visible and false when it is not.
	 */
	@SuppressWarnings("unchecked")
	public boolean isVisible(Long timeout) {
		List<WebElement> webElements = (List<WebElement>) handleExceptions(() -> conditionalWait(timeout)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getLocator())));
		return webElements == null ? false : CollectionUtils.isNotEmpty(webElements);
	}

	/**
	 * Asserts that the element is not visible.
	 *
	 * @param timeout The maximum amount of time to wait for the element to not be
	 *                visible.
	 * @return True when the element is not visible and false when it is not.
	 */
	public boolean isNotVisible(Long timeout) {
		Boolean isNotVisible = (Boolean) handleExceptions(
				() -> conditionalWait(timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator)));
		return isNotVisible != null ? isNotVisible : false;
	}

	/**
	 * Asserts that the element is enabled.
	 *
	 * @return True when the element is enabled and false when it is not.
	 */
	public boolean isEnabled(Long timeout) {
		Boolean isEnabled = (Boolean) handleExceptions(
				() -> conditionalWait(timeout).until((ExpectedCondition<Boolean>) condition -> webElement.isEnabled()));
		return isEnabled != null ? isEnabled : false;
	}

	/**
	 * Asserts that the element is disabled.
	 *
	 * @return True when the element is disabled and false when it is not.
	 */
	public boolean isDisabled(Long timeout) {
		Boolean isDisabled = (Boolean) handleExceptions(() -> conditionalWait(timeout)
				.until((ExpectedCondition<Boolean>) condition -> !webElement.isEnabled()));
		return isDisabled != null ? isDisabled : false;
	}

	/**
	 * Asserts that the element has the specified text.
	 *
	 * @param text    The text to wait for the element to have.
	 * @param timeout The maximum amount of time to wait for the text to appear.
	 * @return True when the element has the specified text and false when it is
	 *         not.
	 */
	public boolean hasText(String text, Long timeout) {
		Boolean hasText = (Boolean) handleExceptions(() -> conditionalWait(timeout)
				.until(ExpectedConditions.textToBePresentInElementLocated(locator, text)));
		return hasText != null ? hasText : false;
	}

	/**
	 * Asserts that the element has the specified value.
	 *
	 * @param text    The text to wait for the value to have.
	 * @param timeout The maximum amount of time to wait for the value to be equal
	 *                to the specified value.
	 * @return True when the element has the specified value and false when it is
	 *         not.
	 */
	public boolean hasValue(String text, Long timeout) {
		Boolean hasValue = (Boolean) handleExceptions(
				() -> conditionalWait(timeout).until(ExpectedConditions.attributeToBe(webElement, "value", text)));
		return hasValue != null ? hasValue : false;
	}

	/**
	 * Asserts that the element has the specified maximum length.
	 *
	 * @param text    The text to wait for the maximum length to have.
	 * @param timeout The maximum amount of time to wait for the value to be equal
	 *                to the specified max length.
	 * @return True when the element has the specified maximum length and false when
	 *         it is not.
	 */
	public boolean hasMaxLength(String text, Long timeout) {
		Boolean hasMaxLength = (Boolean) handleExceptions(
				() -> conditionalWait(timeout).until(ExpectedConditions.attributeToBe(webElement, "maxLength", text)));
		return hasMaxLength != null ? hasMaxLength : false;
	}

	/**
	 * Asserts that the element has the specified minimum length.
	 *
	 * @param text    The text to wait for the minimum length to have.
	 * @param timeout The maximum amount of time to wait for the value to be equal
	 *                to the specified minimum length.
	 * @return True when the element has the specified minimum length and false when
	 *         it is not.
	 */
	public boolean hasMinLength(String text, Long timeout) {
		Boolean hasMinLength = (Boolean) handleExceptions(
				() -> conditionalWait(timeout).until(ExpectedConditions.attributeToBe(webElement, "minLength", text)));
		return hasMinLength != null ? hasMinLength : false;
	}

	/**
	 * Wraps the specified function in a try-catch. Handles exceptions based on
	 * throwException flag
	 */
	private Object handleExceptions(Supplier<Object> f) {
		for (int i = 0; i <= 10; i++) {
			try {
				return f.get();
			} catch (TimeoutException e) {
				if (throwException) {
					throw e;
				}
				return null;
			} catch (StaleElementReferenceException e) {
				continue;
			}
		}
		throw new StaleElementReferenceException("Could not find element");
	}

	public By getLocator() {
		return locator;
	}

	public void setLocator(By locator) {
		this.locator = locator;
	}

	public boolean isThrowException() {
		return throwException;
	}

	public void setThrowException(boolean throwException) {
		this.throwException = throwException;
	}

	public WebElement getWebElement() {
		return webElement;
	}

	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}

}
